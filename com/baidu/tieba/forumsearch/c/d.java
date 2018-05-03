package com.baidu.tieba.forumsearch.c;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener cVE;
    private BarImageView cWq;
    private TextView cWr;
    private TextView cWs;
    private TextView cWt;
    private com.baidu.tieba.forumsearch.b.b cWu;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cWq = (BarImageView) getView().findViewById(d.g.forum_avatar);
        this.cWr = (TextView) getView().findViewById(d.g.forum_name);
        this.cWs = (TextView) getView().findViewById(d.g.forum_attention);
        this.cWt = (TextView) getView().findViewById(d.g.forum_thread_count);
        getView().setOnClickListener(this);
        d(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.cVE = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.h(this.cWr, d.C0126d.cp_cont_b);
            ak.h(this.cWs, d.C0126d.cp_cont_d);
            ak.h(this.cWt, d.C0126d.cp_cont_d);
            ak.i(getView(), d.f.square_search_item_bg);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.forum_search_result_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            this.cWu = bVar;
            this.cWq.startLoad(bVar.getAvatar(), 10, false);
            this.cWr.setText(aT(bVar.getForumName(), bVar.aoH()));
            this.cWs.setText(String.format(this.mTbPageContext.getString(d.k.concern), bVar.aoF()));
            this.cWt.setText(String.format(this.mTbPageContext.getString(d.k.search_bar_thread), bVar.aoG()));
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder aT(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ak.getColor(d.C0126d.cp_cont_h));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int indexOf = str.indexOf(trim);
        if (indexOf != -1) {
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, trim.length() + indexOf, 33);
            return spannableStringBuilder;
        }
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.cWu != null) {
            TiebaStatic.log("c12261");
            e.lH(this.cWu.aoH());
            view2.setTag(this.cWu);
            if (this.cVE != null) {
                this.cVE.onClick(view2);
            }
        }
    }
}
