package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbPageContext<?> Fp;
    private TextView apd;
    private TextView bsW;
    private TextView bsX;
    private TextView bsY;
    private TbImageView cAB;
    private TbImageView cAC;
    private TbImageView cAD;
    private List<TbImageView> cAE;
    private int cAs;
    private com.baidu.tieba.homepage.recommendfrs.data.e cAt;
    private View.OnClickListener cAu;
    private int mSkinType;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cAs = 0;
        this.cAu = new h(this);
        this.Fp = tbPageContext;
        view.setOnClickListener(this.cAu);
        this.cAB = (TbImageView) view.findViewById(r.h.img1);
        this.cAC = (TbImageView) view.findViewById(r.h.img2);
        this.cAD = (TbImageView) view.findViewById(r.h.img3);
        this.apd = (TextView) view.findViewById(r.h.title);
        View findViewById = view.findViewById(r.h.hot_thread_comment);
        this.bsW = (TextView) findViewById.findViewById(r.h.hot_thread_line_tag);
        this.bsX = (TextView) findViewById.findViewById(r.h.hot_thread_line_praise);
        this.bsY = (TextView) findViewById.findViewById(r.h.hot_thread_line_comment);
        this.cAE = new ArrayList();
        this.cAE.add(this.cAB);
        this.cAE.add(this.cAC);
        this.cAE.add(this.cAD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cAt = eVar;
            if (eVar.akQ() != null) {
                List<String> akQ = eVar.akQ();
                if (akQ.size() > 3) {
                    akQ.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) w.c(akQ, i);
                    TbImageView tbImageView = this.cAE.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!eVar.akK()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.apd.setText(eVar.getTitle());
            this.bsX.setVisibility(0);
            String u = at.u(eVar.akN());
            this.bsX.setText(u);
            this.bsX.setContentDescription(String.valueOf(this.Fp.getString(r.l.zan_num)) + u);
            com.baidu.tieba.graffiti.c.ap(this.bsX);
            String u2 = at.u(eVar.akO());
            this.bsY.setText(u2);
            this.bsY.setContentDescription(String.valueOf(this.Fp.getString(r.l.reply_num)) + u2);
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bsW.setVisibility(8);
            } else {
                this.bsW.setVisibility(0);
                this.bsW.setText(getContext().getString(r.l.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bsW.setOnClickListener(new i(this, eVar));
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qP(String.valueOf(eVar.getThreadId()))) {
                this.cAs = r.e.cp_cont_c;
            } else {
                this.cAs = r.e.cp_cont_b;
            }
            ap.c(this.apd, this.cAs, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cAs != 0 && this.apd != null) {
                ap.c(this.apd, this.cAs, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
