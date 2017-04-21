package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.util.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbPageContext<?> aaY;
    private TextView auQ;
    private TextView bCp;
    private TextView bCq;
    private TextView bCr;
    private int cCE;
    private com.baidu.tieba.homepage.recommendfrs.data.e cCF;
    private View.OnClickListener cCG;
    private TbImageView cCN;
    private TbImageView cCO;
    private TbImageView cCP;
    private List<TbImageView> cCQ;
    private int mSkinType;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cCE = 0;
        this.cCG = new h(this);
        this.aaY = tbPageContext;
        view.setOnClickListener(this.cCG);
        this.cCN = (TbImageView) view.findViewById(w.h.img1);
        this.cCO = (TbImageView) view.findViewById(w.h.img2);
        this.cCP = (TbImageView) view.findViewById(w.h.img3);
        this.auQ = (TextView) view.findViewById(w.h.title);
        View findViewById = view.findViewById(w.h.hot_thread_comment);
        this.bCp = (TextView) findViewById.findViewById(w.h.hot_thread_line_tag);
        this.bCq = (TextView) findViewById.findViewById(w.h.hot_thread_line_praise);
        this.bCr = (TextView) findViewById.findViewById(w.h.hot_thread_line_comment);
        this.cCQ = new ArrayList();
        this.cCQ.add(this.cCN);
        this.cCQ.add(this.cCO);
        this.cCQ.add(this.cCP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cCF = eVar;
            if (eVar.akX() != null) {
                List<String> akX = eVar.akX();
                if (akX.size() > 3) {
                    akX.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) x.c(akX, i);
                    TbImageView tbImageView = this.cCQ.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!eVar.akR()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.auQ.setText(eVar.getTitle());
            this.bCq.setVisibility(0);
            String t = au.t(eVar.akU());
            this.bCq.setText(t);
            this.bCq.setContentDescription(String.valueOf(this.aaY.getString(w.l.zan_num)) + t);
            com.baidu.tieba.graffiti.c.al(this.bCq);
            String t2 = au.t(eVar.akV());
            this.bCr.setText(t2);
            this.bCr.setContentDescription(String.valueOf(this.aaY.getString(w.l.reply_num)) + t2);
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bCp.setVisibility(8);
            } else {
                this.bCp.setVisibility(0);
                this.bCp.setText(getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bCp.setOnClickListener(new i(this, eVar));
            }
            r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qp(String.valueOf(eVar.getThreadId()))) {
                this.cCE = w.e.cp_cont_c;
            } else {
                this.cCE = w.e.cp_cont_b;
            }
            aq.c(this.auQ, this.cCE, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
            if (this.cCE != 0 && this.auQ != null) {
                aq.c(this.auQ, this.cCE, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
