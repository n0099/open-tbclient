package com.baidu.tieba.forumsearch.c;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener eWN;
    private TextView eXA;
    private TextView eXB;
    private TextView eXC;
    private com.baidu.tieba.forumsearch.b.b eXD;
    private BarImageView eXz;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eXz = (BarImageView) getView().findViewById(d.g.forum_avatar);
        this.eXA = (TextView) getView().findViewById(d.g.forum_name);
        this.eXB = (TextView) getView().findViewById(d.g.forum_attention);
        this.eXC = (TextView) getView().findViewById(d.g.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s(View.OnClickListener onClickListener) {
        this.eWN = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.eXA, d.C0277d.cp_cont_b);
            al.j(this.eXB, d.C0277d.cp_cont_d);
            al.j(this.eXC, d.C0277d.cp_cont_d);
            al.k(getView(), d.f.square_search_item_bg);
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
            this.eXD = bVar;
            this.eXz.startLoad(bVar.getAvatar(), 10, false);
            this.eXA.setText(cJ(bVar.getForumName(), bVar.bbA()));
            this.eXB.setText(String.format(this.mTbPageContext.getString(d.j.concern), bVar.bby()));
            this.eXC.setText(String.format(this.mTbPageContext.getString(d.j.search_bar_thread), bVar.bbz()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder cJ(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(d.C0277d.cp_cont_h));
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
        if (this.eXD != null) {
            TiebaStatic.log("c12261");
            e.uT(this.eXD.bbA());
            view.setTag(this.eXD);
            if (this.eWN != null) {
                this.eWN.onClick(view);
            }
        }
    }
}
