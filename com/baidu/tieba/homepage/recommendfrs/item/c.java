package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.util.r;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView bAe;
    private TextView bAf;
    private TextView bAg;
    private TextView bAh;
    private int cBO;
    private com.baidu.tieba.homepage.recommendfrs.data.e cBP;
    private View.OnClickListener cBQ;
    private int cBS;
    private LineCountNotifyTextView cBT;
    private TextView cBU;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cBS = -1;
        this.cBO = 0;
        this.cBQ = new d(this);
        view.setOnClickListener(this.cBQ);
        this.bAe = (TbImageView) view.findViewById(w.h.img);
        this.cBT = (LineCountNotifyTextView) view.findViewById(w.h.title);
        this.cBU = (TextView) view.findViewById(w.h.discription);
        View findViewById = view.findViewById(w.h.hot_thread_comment);
        this.bAf = (TextView) findViewById.findViewById(w.h.hot_thread_line_tag);
        this.bAg = (TextView) findViewById.findViewById(w.h.hot_thread_line_praise);
        this.bAh = (TextView) findViewById.findViewById(w.h.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cBP = eVar;
            String str = (eVar.akc() == null || eVar.akc().size() <= 0) ? null : eVar.akc().get(0);
            TbImageView tbImageView = this.bAe;
            if (!eVar.ajW()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(eVar.getTitle())) {
                this.cBT.setText(eVar.getTitle());
                this.cBT.setGetLineCountCallback(new e(this, eVar));
            }
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bAf.setVisibility(8);
            } else {
                this.bAf.setVisibility(0);
                this.bAf.setText(getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bAf.setOnClickListener(new f(this, eVar));
            }
            this.bAg.setVisibility(0);
            this.bAg.setText(au.t(eVar.ajZ()));
            com.baidu.tieba.graffiti.c.an(this.bAg);
            this.bAh.setText(au.t(eVar.aka()));
            r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.pX(String.valueOf(eVar.getThreadId()))) {
                this.cBO = w.e.cp_cont_c;
            } else {
                this.cBO = w.e.cp_cont_b;
            }
            aq.c(this.cBT, this.cBO, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cBO != 0 && this.cBT != null) {
                aq.c(this.cBT, this.cBO, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
