package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView bsV;
    private TextView bsW;
    private TextView bsX;
    private TextView bsY;
    private int cAs;
    private com.baidu.tieba.homepage.recommendfrs.data.e cAt;
    private View.OnClickListener cAu;
    private int cAw;
    private LineCountNotifyTextView cAx;
    private TextView cAy;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cAw = -1;
        this.cAs = 0;
        this.cAu = new d(this);
        view.setOnClickListener(this.cAu);
        this.bsV = (TbImageView) view.findViewById(r.h.img);
        this.cAx = (LineCountNotifyTextView) view.findViewById(r.h.title);
        this.cAy = (TextView) view.findViewById(r.h.discription);
        View findViewById = view.findViewById(r.h.hot_thread_comment);
        this.bsW = (TextView) findViewById.findViewById(r.h.hot_thread_line_tag);
        this.bsX = (TextView) findViewById.findViewById(r.h.hot_thread_line_praise);
        this.bsY = (TextView) findViewById.findViewById(r.h.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cAt = eVar;
            String str = (eVar.akQ() == null || eVar.akQ().size() <= 0) ? null : eVar.akQ().get(0);
            TbImageView tbImageView = this.bsV;
            if (!eVar.akK()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(eVar.getTitle())) {
                this.cAx.setText(eVar.getTitle());
                this.cAx.setGetLineCountCallback(new e(this, eVar));
            }
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bsW.setVisibility(8);
            } else {
                this.bsW.setVisibility(0);
                this.bsW.setText(getContext().getString(r.l.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bsW.setOnClickListener(new f(this, eVar));
            }
            this.bsX.setVisibility(0);
            this.bsX.setText(at.u(eVar.akN()));
            com.baidu.tieba.graffiti.c.ap(this.bsX);
            this.bsY.setText(at.u(eVar.akO()));
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qP(String.valueOf(eVar.getThreadId()))) {
                this.cAs = r.e.cp_cont_c;
            } else {
                this.cAs = r.e.cp_cont_b;
            }
            ap.c(this.cAx, this.cAs, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cAs != 0 && this.cAx != null) {
                ap.c(this.cAx, this.cAs, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
