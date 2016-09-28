package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.s;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView bdD;
    private TextView bdE;
    private TextView bdF;
    private TextView bdG;
    private int cIT;
    private com.baidu.tieba.homepage.recommendfrs.data.e cIU;
    private View.OnClickListener cIV;
    private int cIX;
    private LineCountNotifyTextView cIY;
    private TextView cIZ;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cIX = -1;
        this.cIT = 0;
        this.cIV = new d(this);
        view.setOnClickListener(this.cIV);
        this.bdD = (TbImageView) view.findViewById(r.g.img);
        this.cIY = (LineCountNotifyTextView) view.findViewById(r.g.title);
        this.cIZ = (TextView) view.findViewById(r.g.discription);
        View findViewById = view.findViewById(r.g.hot_thread_comment);
        this.bdE = (TextView) findViewById.findViewById(r.g.hot_thread_line_tag);
        this.bdF = (TextView) findViewById.findViewById(r.g.hot_thread_line_praise);
        this.bdG = (TextView) findViewById.findViewById(r.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cIU = eVar;
            String str = (eVar.ann() == null || eVar.ann().size() <= 0) ? null : eVar.ann().get(0);
            TbImageView tbImageView = this.bdD;
            if (!eVar.Wz()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(eVar.getTitle())) {
                this.cIY.setText(eVar.getTitle());
                this.cIY.setGetLineCountCallback(new e(this, eVar));
            }
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bdE.setVisibility(8);
            } else {
                this.bdE.setVisibility(0);
                this.bdE.setText(getContext().getString(r.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bdE.setOnClickListener(new f(this, eVar));
            }
            this.bdF.setVisibility(0);
            this.bdF.setText(az.w(eVar.ank()));
            com.baidu.tieba.graffiti.d.ak(this.bdF);
            this.bdG.setText(az.w(eVar.anl()));
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ru(String.valueOf(eVar.getThreadId()))) {
                this.cIT = r.d.cp_cont_c;
            } else {
                this.cIT = r.d.cp_cont_b;
            }
            av.c(this.cIY, this.cIT, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cIT != 0 && this.cIY != null) {
                av.c(this.cIY, this.cIT, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
