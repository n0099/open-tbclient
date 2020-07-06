package com.baidu.tieba.forumsearch.c;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes11.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener hxu;
    private BarImageView hyl;
    private TextView hym;
    private TextView hyn;
    private TextView hyo;
    private com.baidu.tieba.forumsearch.b.b hyp;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.hyl = (BarImageView) getView().findViewById(R.id.forum_avatar);
        this.hym = (TextView) getView().findViewById(R.id.forum_name);
        this.hyn = (TextView) getView().findViewById(R.id.forum_attention);
        this.hyo = (TextView) getView().findViewById(R.id.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void y(View.OnClickListener onClickListener) {
        this.hxu = onClickListener;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setViewTextColor(this.hym, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.hyn, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.hyo, (int) R.color.cp_cont_d);
            an.setBackgroundResource(getView(), R.drawable.square_search_item_bg);
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
            this.hyp = bVar;
            this.hyl.startLoad(bVar.getAvatar(), 10, false);
            this.hym.setText(eh(bVar.getForumName(), bVar.bWS()));
            this.hyn.setText(String.format(this.mTbPageContext.getString(R.string.concern), bVar.bWQ()));
            this.hyo.setText(String.format(this.mTbPageContext.getString(R.string.search_bar_thread), bVar.bWR()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder eh(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(an.getColor(R.color.cp_cont_h));
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
        if (this.hyp != null) {
            TiebaStatic.log("c12261");
            e.Fb(this.hyp.bWS());
            view.setTag(this.hyp);
            if (this.hxu != null) {
                this.hxu.onClick(view);
            }
        }
    }
}
