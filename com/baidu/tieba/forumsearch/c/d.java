package com.baidu.tieba.forumsearch.c;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes11.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.forumsearch.b.b> {
    private BarImageView hlT;
    private TextView hlU;
    private TextView hlV;
    private TextView hlW;
    private com.baidu.tieba.forumsearch.b.b hlX;
    private View.OnClickListener hlc;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.hlT = (BarImageView) getView().findViewById(R.id.forum_avatar);
        this.hlU = (TextView) getView().findViewById(R.id.forum_name);
        this.hlV = (TextView) getView().findViewById(R.id.forum_attention);
        this.hlW = (TextView) getView().findViewById(R.id.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void x(View.OnClickListener onClickListener) {
        this.hlc = onClickListener;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.hlU, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hlV, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hlW, (int) R.color.cp_cont_d);
            am.setBackgroundResource(getView(), R.drawable.square_search_item_bg);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.forum_search_result_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: c */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            this.hlX = bVar;
            this.hlT.startLoad(bVar.getAvatar(), 10, false);
            this.hlU.setText(ec(bVar.getForumName(), bVar.bTT()));
            this.hlV.setText(String.format(this.mTbPageContext.getString(R.string.concern), bVar.bTR()));
            this.hlW.setText(String.format(this.mTbPageContext.getString(R.string.search_bar_thread), bVar.bTS()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder ec(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int indexOf = str.indexOf(trim);
        if (indexOf != -1) {
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, trim.length() + indexOf, 33);
            return spannableStringBuilder;
        }
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hlX != null) {
            TiebaStatic.log("c12261");
            e.EA(this.hlX.bTT());
            view.setTag(this.hlX);
            if (this.hlc != null) {
                this.hlc.onClick(view);
            }
        }
    }
}
