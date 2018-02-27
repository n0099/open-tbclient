package com.baidu.tieba.forumsearch.c;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener dCJ;
    private BarImageView dDv;
    private TextView dDw;
    private TextView dDx;
    private TextView dDy;
    private com.baidu.tieba.forumsearch.b.b dDz;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dDv = (BarImageView) getView().findViewById(d.g.forum_avatar);
        this.dDw = (TextView) getView().findViewById(d.g.forum_name);
        this.dDx = (TextView) getView().findViewById(d.g.forum_attention);
        this.dDy = (TextView) getView().findViewById(d.g.forum_thread_count);
        getView().setOnClickListener(this);
        d(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void k(View.OnClickListener onClickListener) {
        this.dCJ = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.dDw, d.C0141d.cp_cont_b);
            aj.r(this.dDx, d.C0141d.cp_cont_d);
            aj.r(this.dDy, d.C0141d.cp_cont_d);
            aj.s(getView(), d.f.square_search_item_bg);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.forum_search_result_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            this.dDz = bVar;
            this.dDv.startLoad(bVar.getAvatar(), 10, false);
            this.dDw.setText(aU(bVar.getForumName(), bVar.aur()));
            this.dDx.setText(String.format(this.mTbPageContext.getString(d.j.concern), bVar.aup()));
            this.dDy.setText(String.format(this.mTbPageContext.getString(d.j.search_bar_thread), bVar.auq()));
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder aU(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0141d.cp_cont_h));
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
        if (this.dDz != null) {
            TiebaStatic.log("c12261");
            e.lE(this.dDz.aur());
            view.setTag(this.dDz);
            if (this.dCJ != null) {
                this.dCJ.onClick(view);
            }
        }
    }
}
