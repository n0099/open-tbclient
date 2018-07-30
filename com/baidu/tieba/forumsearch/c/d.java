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
import com.baidu.tieba.d;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener dkF;
    private BarImageView dlr;
    private TextView dls;
    private TextView dlt;
    private TextView dlu;
    private com.baidu.tieba.forumsearch.b.b dlv;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dlr = (BarImageView) getView().findViewById(d.g.forum_avatar);
        this.dls = (TextView) getView().findViewById(d.g.forum_name);
        this.dlt = (TextView) getView().findViewById(d.g.forum_attention);
        this.dlu = (TextView) getView().findViewById(d.g.forum_thread_count);
        getView().setOnClickListener(this);
        d(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void p(View.OnClickListener onClickListener) {
        this.dkF = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.h(this.dls, d.C0140d.cp_cont_b);
            am.h(this.dlt, d.C0140d.cp_cont_d);
            am.h(this.dlu, d.C0140d.cp_cont_d);
            am.i(getView(), d.f.square_search_item_bg);
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
            this.dlv = bVar;
            this.dlr.startLoad(bVar.getAvatar(), 10, false);
            this.dls.setText(bd(bVar.getForumName(), bVar.atA()));
            this.dlt.setText(String.format(this.mTbPageContext.getString(d.j.concern), bVar.aty()));
            this.dlu.setText(String.format(this.mTbPageContext.getString(d.j.search_bar_thread), bVar.atz()));
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder bd(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(d.C0140d.cp_cont_h));
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
        if (this.dlv != null) {
            TiebaStatic.log("c12261");
            e.mq(this.dlv.atA());
            view.setTag(this.dlv);
            if (this.dkF != null) {
                this.dkF.onClick(view);
            }
        }
    }
}
