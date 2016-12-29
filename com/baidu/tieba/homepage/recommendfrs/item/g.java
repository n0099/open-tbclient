package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbPageContext<?> Gf;
    private TextView apY;
    private TextView bfT;
    private TextView bfU;
    private TextView bfV;
    private List<TbImageView> ctA;
    private int cto;
    private com.baidu.tieba.homepage.recommendfrs.data.e ctp;
    private View.OnClickListener ctq;
    private TbImageView ctx;
    private TbImageView cty;
    private TbImageView ctz;
    private int mSkinType;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cto = 0;
        this.ctq = new h(this);
        this.Gf = tbPageContext;
        view.setOnClickListener(this.ctq);
        this.ctx = (TbImageView) view.findViewById(r.g.img1);
        this.cty = (TbImageView) view.findViewById(r.g.img2);
        this.ctz = (TbImageView) view.findViewById(r.g.img3);
        this.apY = (TextView) view.findViewById(r.g.title);
        View findViewById = view.findViewById(r.g.hot_thread_comment);
        this.bfT = (TextView) findViewById.findViewById(r.g.hot_thread_line_tag);
        this.bfU = (TextView) findViewById.findViewById(r.g.hot_thread_line_praise);
        this.bfV = (TextView) findViewById.findViewById(r.g.hot_thread_line_comment);
        this.ctA = new ArrayList();
        this.ctA.add(this.ctx);
        this.ctA.add(this.cty);
        this.ctA.add(this.ctz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.ctp = eVar;
            if (eVar.ajJ() != null) {
                List<String> ajJ = eVar.ajJ();
                if (ajJ.size() > 3) {
                    ajJ.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) x.c(ajJ, i);
                    TbImageView tbImageView = this.ctA.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!eVar.ajD()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.apY.setText(eVar.getTitle());
            this.bfU.setVisibility(0);
            String v = av.v(eVar.ajG());
            this.bfU.setText(v);
            this.bfU.setContentDescription(String.valueOf(this.Gf.getString(r.j.zan_num)) + v);
            com.baidu.tieba.graffiti.d.ak(this.bfU);
            String v2 = av.v(eVar.ajH());
            this.bfV.setText(v2);
            this.bfV.setContentDescription(String.valueOf(this.Gf.getString(r.j.reply_num)) + v2);
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bfT.setVisibility(8);
            } else {
                this.bfT.setVisibility(0);
                this.bfT.setText(getContext().getString(r.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bfT.setOnClickListener(new i(this, eVar));
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qv(String.valueOf(eVar.getThreadId()))) {
                this.cto = r.d.cp_cont_c;
            } else {
                this.cto = r.d.cp_cont_b;
            }
            ar.c(this.apY, this.cto, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cto != 0 && this.apY != null) {
                ar.c(this.apY, this.cto, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
