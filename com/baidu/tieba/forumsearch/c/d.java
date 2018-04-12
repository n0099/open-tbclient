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
    private View.OnClickListener cVH;
    private BarImageView cWt;
    private TextView cWu;
    private TextView cWv;
    private TextView cWw;
    private com.baidu.tieba.forumsearch.b.b cWx;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cWt = (BarImageView) getView().findViewById(d.g.forum_avatar);
        this.cWu = (TextView) getView().findViewById(d.g.forum_name);
        this.cWv = (TextView) getView().findViewById(d.g.forum_attention);
        this.cWw = (TextView) getView().findViewById(d.g.forum_thread_count);
        getView().setOnClickListener(this);
        d(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.cVH = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.h(this.cWu, d.C0126d.cp_cont_b);
            ak.h(this.cWv, d.C0126d.cp_cont_d);
            ak.h(this.cWw, d.C0126d.cp_cont_d);
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
            this.cWx = bVar;
            this.cWt.startLoad(bVar.getAvatar(), 10, false);
            this.cWu.setText(aT(bVar.getForumName(), bVar.aoH()));
            this.cWv.setText(String.format(this.mTbPageContext.getString(d.k.concern), bVar.aoF()));
            this.cWw.setText(String.format(this.mTbPageContext.getString(d.k.search_bar_thread), bVar.aoG()));
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
        if (this.cWx != null) {
            TiebaStatic.log("c12261");
            e.lH(this.cWx.aoH());
            view2.setTag(this.cWx);
            if (this.cVH != null) {
                this.cVH.onClick(view2);
            }
        }
    }
}
