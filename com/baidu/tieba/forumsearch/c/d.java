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
    private View.OnClickListener cWL;
    private TextView cXA;
    private com.baidu.tieba.forumsearch.b.b cXB;
    private BarImageView cXx;
    private TextView cXy;
    private TextView cXz;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cXx = (BarImageView) getView().findViewById(d.g.forum_avatar);
        this.cXy = (TextView) getView().findViewById(d.g.forum_name);
        this.cXz = (TextView) getView().findViewById(d.g.forum_attention);
        this.cXA = (TextView) getView().findViewById(d.g.forum_thread_count);
        getView().setOnClickListener(this);
        d(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.cWL = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.h(this.cXy, d.C0126d.cp_cont_b);
            ak.h(this.cXz, d.C0126d.cp_cont_d);
            ak.h(this.cXA, d.C0126d.cp_cont_d);
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
            this.cXB = bVar;
            this.cXx.startLoad(bVar.getAvatar(), 10, false);
            this.cXy.setText(aT(bVar.getForumName(), bVar.aoG()));
            this.cXz.setText(String.format(this.mTbPageContext.getString(d.k.concern), bVar.aoE()));
            this.cXA.setText(String.format(this.mTbPageContext.getString(d.k.search_bar_thread), bVar.aoF()));
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
        if (this.cXB != null) {
            TiebaStatic.log("c12261");
            e.lK(this.cXB.aoG());
            view2.setTag(this.cXB);
            if (this.cWL != null) {
                this.cWL.onClick(view2);
            }
        }
    }
}
