package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView bfS;
    private TextView bfT;
    private TextView bfU;
    private TextView bfV;
    private int cto;
    private com.baidu.tieba.homepage.recommendfrs.data.e ctp;
    private View.OnClickListener ctq;
    private int cts;
    private LineCountNotifyTextView ctt;
    private TextView ctu;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cts = -1;
        this.cto = 0;
        this.ctq = new d(this);
        view.setOnClickListener(this.ctq);
        this.bfS = (TbImageView) view.findViewById(r.g.img);
        this.ctt = (LineCountNotifyTextView) view.findViewById(r.g.title);
        this.ctu = (TextView) view.findViewById(r.g.discription);
        View findViewById = view.findViewById(r.g.hot_thread_comment);
        this.bfT = (TextView) findViewById.findViewById(r.g.hot_thread_line_tag);
        this.bfU = (TextView) findViewById.findViewById(r.g.hot_thread_line_praise);
        this.bfV = (TextView) findViewById.findViewById(r.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.ctp = eVar;
            String str = (eVar.ajJ() == null || eVar.ajJ().size() <= 0) ? null : eVar.ajJ().get(0);
            TbImageView tbImageView = this.bfS;
            if (!eVar.ajD()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(eVar.getTitle())) {
                this.ctt.setText(eVar.getTitle());
                this.ctt.setGetLineCountCallback(new e(this, eVar));
            }
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bfT.setVisibility(8);
            } else {
                this.bfT.setVisibility(0);
                this.bfT.setText(getContext().getString(r.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bfT.setOnClickListener(new f(this, eVar));
            }
            this.bfU.setVisibility(0);
            this.bfU.setText(av.v(eVar.ajG()));
            com.baidu.tieba.graffiti.d.ak(this.bfU);
            this.bfV.setText(av.v(eVar.ajH()));
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qv(String.valueOf(eVar.getThreadId()))) {
                this.cto = r.d.cp_cont_c;
            } else {
                this.cto = r.d.cp_cont_b;
            }
            ar.c(this.ctt, this.cto, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cto != 0 && this.ctt != null) {
                ar.c(this.ctt, this.cto, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
