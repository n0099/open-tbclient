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
    private TbImageView bCo;
    private TextView bCp;
    private TextView bCq;
    private TextView bCr;
    private int cCE;
    private com.baidu.tieba.homepage.recommendfrs.data.e cCF;
    private View.OnClickListener cCG;
    private int cCI;
    private LineCountNotifyTextView cCJ;
    private TextView cCK;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cCI = -1;
        this.cCE = 0;
        this.cCG = new d(this);
        view.setOnClickListener(this.cCG);
        this.bCo = (TbImageView) view.findViewById(w.h.img);
        this.cCJ = (LineCountNotifyTextView) view.findViewById(w.h.title);
        this.cCK = (TextView) view.findViewById(w.h.discription);
        View findViewById = view.findViewById(w.h.hot_thread_comment);
        this.bCp = (TextView) findViewById.findViewById(w.h.hot_thread_line_tag);
        this.bCq = (TextView) findViewById.findViewById(w.h.hot_thread_line_praise);
        this.bCr = (TextView) findViewById.findViewById(w.h.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cCF = eVar;
            String str = (eVar.akX() == null || eVar.akX().size() <= 0) ? null : eVar.akX().get(0);
            TbImageView tbImageView = this.bCo;
            if (!eVar.akR()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(eVar.getTitle())) {
                this.cCJ.setText(eVar.getTitle());
                this.cCJ.setGetLineCountCallback(new e(this, eVar));
            }
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bCp.setVisibility(8);
            } else {
                this.bCp.setVisibility(0);
                this.bCp.setText(getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bCp.setOnClickListener(new f(this, eVar));
            }
            this.bCq.setVisibility(0);
            this.bCq.setText(au.t(eVar.akU()));
            com.baidu.tieba.graffiti.c.al(this.bCq);
            this.bCr.setText(au.t(eVar.akV()));
            r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qp(String.valueOf(eVar.getThreadId()))) {
                this.cCE = w.e.cp_cont_c;
            } else {
                this.cCE = w.e.cp_cont_b;
            }
            aq.c(this.cCJ, this.cCE, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
            if (this.cCE != 0 && this.cCJ != null) {
                aq.c(this.cCJ, this.cCE, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
