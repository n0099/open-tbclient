package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView bgD;
    private TextView bgE;
    private TextView bgF;
    private TextView bgG;
    private int cOi;
    private com.baidu.tieba.homepage.recommendfrs.data.e cOj;
    private View.OnClickListener cOk;
    private int cOm;
    private LineCountNotifyTextView cOn;
    private TextView cOo;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cOm = -1;
        this.cOi = 0;
        this.cOk = new d(this);
        view.setOnClickListener(this.cOk);
        this.bgD = (TbImageView) view.findViewById(r.g.img);
        this.cOn = (LineCountNotifyTextView) view.findViewById(r.g.title);
        this.cOo = (TextView) view.findViewById(r.g.discription);
        View findViewById = view.findViewById(r.g.hot_thread_comment);
        this.bgE = (TextView) findViewById.findViewById(r.g.hot_thread_line_tag);
        this.bgF = (TextView) findViewById.findViewById(r.g.hot_thread_line_praise);
        this.bgG = (TextView) findViewById.findViewById(r.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cOj = eVar;
            String str = (eVar.aph() == null || eVar.aph().size() <= 0) ? null : eVar.aph().get(0);
            TbImageView tbImageView = this.bgD;
            if (!eVar.XB()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(eVar.getTitle())) {
                this.cOn.setText(eVar.getTitle());
                this.cOn.setGetLineCountCallback(new e(this, eVar));
            }
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bgE.setVisibility(8);
            } else {
                this.bgE.setVisibility(0);
                this.bgE.setText(getContext().getString(r.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bgE.setOnClickListener(new f(this, eVar));
            }
            this.bgF.setVisibility(0);
            this.bgF.setText(ax.v(eVar.ape()));
            com.baidu.tieba.graffiti.d.ak(this.bgF);
            this.bgG.setText(ax.v(eVar.apf()));
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rP(String.valueOf(eVar.getThreadId()))) {
                this.cOi = r.d.cp_cont_c;
            } else {
                this.cOi = r.d.cp_cont_b;
            }
            at.c(this.cOn, this.cOi, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cOi != 0 && this.cOn != null) {
                at.c(this.cOn, this.cOi, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
