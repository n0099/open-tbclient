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
import com.baidu.tieba.f;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener dkD;
    private BarImageView dlp;
    private TextView dlq;
    private TextView dlr;
    private TextView dls;
    private com.baidu.tieba.forumsearch.b.b dlt;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dlp = (BarImageView) getView().findViewById(f.g.forum_avatar);
        this.dlq = (TextView) getView().findViewById(f.g.forum_name);
        this.dlr = (TextView) getView().findViewById(f.g.forum_attention);
        this.dls = (TextView) getView().findViewById(f.g.forum_thread_count);
        getView().setOnClickListener(this);
        d(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void p(View.OnClickListener onClickListener) {
        this.dkD = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.h(this.dlq, f.d.cp_cont_b);
            am.h(this.dlr, f.d.cp_cont_d);
            am.h(this.dls, f.d.cp_cont_d);
            am.i(getView(), f.C0146f.square_search_item_bg);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.forum_search_result_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            this.dlt = bVar;
            this.dlp.startLoad(bVar.getAvatar(), 10, false);
            this.dlq.setText(bd(bVar.getForumName(), bVar.atz()));
            this.dlr.setText(String.format(this.mTbPageContext.getString(f.j.concern), bVar.atx()));
            this.dls.setText(String.format(this.mTbPageContext.getString(f.j.search_bar_thread), bVar.aty()));
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder bd(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(f.d.cp_cont_h));
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
        if (this.dlt != null) {
            TiebaStatic.log("c12261");
            e.ms(this.dlt.atz());
            view.setTag(this.dlt);
            if (this.dkD != null) {
                this.dkD.onClick(view);
            }
        }
    }
}
