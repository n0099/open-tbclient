package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbPageContext<?> Gf;
    private TextView bgE;
    private TextView bgF;
    private TextView bgG;
    private int cOi;
    private com.baidu.tieba.homepage.recommendfrs.data.e cOj;
    private View.OnClickListener cOk;
    private TbImageView cOr;
    private TbImageView cOs;
    private TbImageView cOt;
    private List<TbImageView> cOu;
    private int mSkinType;
    private TextView title;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cOi = 0;
        this.cOk = new h(this);
        this.Gf = tbPageContext;
        view.setOnClickListener(this.cOk);
        this.cOr = (TbImageView) view.findViewById(r.g.img1);
        this.cOs = (TbImageView) view.findViewById(r.g.img2);
        this.cOt = (TbImageView) view.findViewById(r.g.img3);
        this.title = (TextView) view.findViewById(r.g.title);
        View findViewById = view.findViewById(r.g.hot_thread_comment);
        this.bgE = (TextView) findViewById.findViewById(r.g.hot_thread_line_tag);
        this.bgF = (TextView) findViewById.findViewById(r.g.hot_thread_line_praise);
        this.bgG = (TextView) findViewById.findViewById(r.g.hot_thread_line_comment);
        this.cOu = new ArrayList();
        this.cOu.add(this.cOr);
        this.cOu.add(this.cOs);
        this.cOu.add(this.cOt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cOj = eVar;
            if (eVar.aph() != null) {
                List<String> aph = eVar.aph();
                if (aph.size() > 3) {
                    aph.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) x.c(aph, i);
                    TbImageView tbImageView = this.cOu.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!eVar.XB()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.title.setText(eVar.getTitle());
            this.bgF.setVisibility(0);
            String v = ax.v(eVar.ape());
            this.bgF.setText(v);
            this.bgF.setContentDescription(String.valueOf(this.Gf.getString(r.j.zan_num)) + v);
            com.baidu.tieba.graffiti.d.ak(this.bgF);
            String v2 = ax.v(eVar.apf());
            this.bgG.setText(v2);
            this.bgG.setContentDescription(String.valueOf(this.Gf.getString(r.j.reply_num)) + v2);
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bgE.setVisibility(8);
            } else {
                this.bgE.setVisibility(0);
                this.bgE.setText(getContext().getString(r.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bgE.setOnClickListener(new i(this, eVar));
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rP(String.valueOf(eVar.getThreadId()))) {
                this.cOi = r.d.cp_cont_c;
            } else {
                this.cOi = r.d.cp_cont_b;
            }
            at.c(this.title, this.cOi, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cOi != 0 && this.title != null) {
                at.c(this.title, this.cOi, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
