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
    private TbPageContext<?> aaI;
    private TextView auy;
    private TextView bAf;
    private TextView bAg;
    private TextView bAh;
    private int cBO;
    private com.baidu.tieba.homepage.recommendfrs.data.e cBP;
    private View.OnClickListener cBQ;
    private TbImageView cBX;
    private TbImageView cBY;
    private TbImageView cBZ;
    private List<TbImageView> cCa;
    private int mSkinType;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cBO = 0;
        this.cBQ = new h(this);
        this.aaI = tbPageContext;
        view.setOnClickListener(this.cBQ);
        this.cBX = (TbImageView) view.findViewById(w.h.img1);
        this.cBY = (TbImageView) view.findViewById(w.h.img2);
        this.cBZ = (TbImageView) view.findViewById(w.h.img3);
        this.auy = (TextView) view.findViewById(w.h.title);
        View findViewById = view.findViewById(w.h.hot_thread_comment);
        this.bAf = (TextView) findViewById.findViewById(w.h.hot_thread_line_tag);
        this.bAg = (TextView) findViewById.findViewById(w.h.hot_thread_line_praise);
        this.bAh = (TextView) findViewById.findViewById(w.h.hot_thread_line_comment);
        this.cCa = new ArrayList();
        this.cCa.add(this.cBX);
        this.cCa.add(this.cBY);
        this.cCa.add(this.cBZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cBP = eVar;
            if (eVar.akc() != null) {
                List<String> akc = eVar.akc();
                if (akc.size() > 3) {
                    akc.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) x.c(akc, i);
                    TbImageView tbImageView = this.cCa.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!eVar.ajW()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.auy.setText(eVar.getTitle());
            this.bAg.setVisibility(0);
            String t = au.t(eVar.ajZ());
            this.bAg.setText(t);
            this.bAg.setContentDescription(String.valueOf(this.aaI.getString(w.l.zan_num)) + t);
            com.baidu.tieba.graffiti.c.an(this.bAg);
            String t2 = au.t(eVar.aka());
            this.bAh.setText(t2);
            this.bAh.setContentDescription(String.valueOf(this.aaI.getString(w.l.reply_num)) + t2);
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bAf.setVisibility(8);
            } else {
                this.bAf.setVisibility(0);
                this.bAf.setText(getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bAf.setOnClickListener(new i(this, eVar));
            }
            r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.pX(String.valueOf(eVar.getThreadId()))) {
                this.cBO = w.e.cp_cont_c;
            } else {
                this.cBO = w.e.cp_cont_b;
            }
            aq.c(this.auy, this.cBO, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cBO != 0 && this.auy != null) {
                aq.c(this.auy, this.cBO, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
