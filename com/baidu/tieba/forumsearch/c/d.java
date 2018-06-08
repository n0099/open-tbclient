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
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener dfY;
    private BarImageView dgK;
    private TextView dgL;
    private TextView dgM;
    private TextView dgN;
    private com.baidu.tieba.forumsearch.b.b dgO;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dgK = (BarImageView) getView().findViewById(d.g.forum_avatar);
        this.dgL = (TextView) getView().findViewById(d.g.forum_name);
        this.dgM = (TextView) getView().findViewById(d.g.forum_attention);
        this.dgN = (TextView) getView().findViewById(d.g.forum_thread_count);
        getView().setOnClickListener(this);
        d(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.dfY = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.dgL, d.C0141d.cp_cont_b);
            al.h(this.dgM, d.C0141d.cp_cont_d);
            al.h(this.dgN, d.C0141d.cp_cont_d);
            al.i(getView(), d.f.square_search_item_bg);
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
            this.dgO = bVar;
            this.dgK.startLoad(bVar.getAvatar(), 10, false);
            this.dgL.setText(bb(bVar.getForumName(), bVar.asL()));
            this.dgM.setText(String.format(this.mTbPageContext.getString(d.k.concern), bVar.asJ()));
            this.dgN.setText(String.format(this.mTbPageContext.getString(d.k.search_bar_thread), bVar.asK()));
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder bb(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(d.C0141d.cp_cont_h));
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
        if (this.dgO != null) {
            TiebaStatic.log("c12261");
            e.mr(this.dgO.asL());
            view.setTag(this.dgO);
            if (this.dfY != null) {
                this.dfY.onClick(view);
            }
        }
    }
}
