package com.baidu.tieba.forumsearch.c;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes18.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener hQD;
    private BarImageView hRt;
    private TextView hRu;
    private TextView hRv;
    private TextView hRw;
    private com.baidu.tieba.forumsearch.b.b hRx;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.hRt = (BarImageView) getView().findViewById(R.id.forum_avatar);
        this.hRu = (TextView) getView().findViewById(R.id.forum_name);
        this.hRv = (TextView) getView().findViewById(R.id.forum_attention);
        this.hRw = (TextView) getView().findViewById(R.id.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void y(View.OnClickListener onClickListener) {
        this.hQD = onClickListener;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.hRu, R.color.cp_cont_b);
            ap.setViewTextColor(this.hRv, R.color.cp_cont_d);
            ap.setViewTextColor(this.hRw, R.color.cp_cont_d);
            ap.setBackgroundResource(getView(), R.drawable.square_search_item_bg);
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
            this.hRx = bVar;
            this.hRt.startLoad(bVar.getAvatar(), 10, false);
            this.hRu.setText(eB(bVar.getForumName(), bVar.ckI()));
            this.hRv.setText(String.format(this.mTbPageContext.getString(R.string.concern), bVar.ckG()));
            this.hRw.setText(String.format(this.mTbPageContext.getString(R.string.search_bar_thread), bVar.ckH()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder eB(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_h));
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
        if (this.hRx != null) {
            TiebaStatic.log("c12261");
            e.Io(this.hRx.ckI());
            view.setTag(this.hRx);
            if (this.hQD != null) {
                this.hQD.onClick(view);
            }
        }
    }
}
