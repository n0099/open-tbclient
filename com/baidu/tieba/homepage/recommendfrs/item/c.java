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
    private TextView bAa;
    private TbImageView bzX;
    private TextView bzY;
    private TextView bzZ;
    private int cAn;
    private com.baidu.tieba.homepage.recommendfrs.data.e cAo;
    private View.OnClickListener cAp;
    private int cAr;
    private LineCountNotifyTextView cAs;
    private TextView cAt;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cAr = -1;
        this.cAn = 0;
        this.cAp = new d(this);
        view.setOnClickListener(this.cAp);
        this.bzX = (TbImageView) view.findViewById(w.h.img);
        this.cAs = (LineCountNotifyTextView) view.findViewById(w.h.title);
        this.cAt = (TextView) view.findViewById(w.h.discription);
        View findViewById = view.findViewById(w.h.hot_thread_comment);
        this.bzY = (TextView) findViewById.findViewById(w.h.hot_thread_line_tag);
        this.bzZ = (TextView) findViewById.findViewById(w.h.hot_thread_line_praise);
        this.bAa = (TextView) findViewById.findViewById(w.h.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cAo = eVar;
            String str = (eVar.ajW() == null || eVar.ajW().size() <= 0) ? null : eVar.ajW().get(0);
            TbImageView tbImageView = this.bzX;
            if (!eVar.ajQ()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(eVar.getTitle())) {
                this.cAs.setText(eVar.getTitle());
                this.cAs.setGetLineCountCallback(new e(this, eVar));
            }
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bzY.setVisibility(8);
            } else {
                this.bzY.setVisibility(0);
                this.bzY.setText(getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bzY.setOnClickListener(new f(this, eVar));
            }
            this.bzZ.setVisibility(0);
            this.bzZ.setText(au.t(eVar.ajT()));
            com.baidu.tieba.graffiti.c.al(this.bzZ);
            this.bAa.setText(au.t(eVar.ajU()));
            r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qo(String.valueOf(eVar.getThreadId()))) {
                this.cAn = w.e.cp_cont_c;
            } else {
                this.cAn = w.e.cp_cont_b;
            }
            aq.c(this.cAs, this.cAn, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
            if (this.cAn != 0 && this.cAs != null) {
                aq.c(this.cAs, this.cAn, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
