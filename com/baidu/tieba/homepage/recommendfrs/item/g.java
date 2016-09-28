package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbPageContext<?> Gd;
    private TextView bdE;
    private TextView bdF;
    private TextView bdG;
    private int cIT;
    private com.baidu.tieba.homepage.recommendfrs.data.e cIU;
    private View.OnClickListener cIV;
    private TbImageView cJc;
    private TbImageView cJd;
    private TbImageView cJe;
    private List<TbImageView> cJf;
    private int mSkinType;
    private TextView title;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cIT = 0;
        this.cIV = new h(this);
        this.Gd = tbPageContext;
        view.setOnClickListener(this.cIV);
        this.cJc = (TbImageView) view.findViewById(r.g.img1);
        this.cJd = (TbImageView) view.findViewById(r.g.img2);
        this.cJe = (TbImageView) view.findViewById(r.g.img3);
        this.title = (TextView) view.findViewById(r.g.title);
        View findViewById = view.findViewById(r.g.hot_thread_comment);
        this.bdE = (TextView) findViewById.findViewById(r.g.hot_thread_line_tag);
        this.bdF = (TextView) findViewById.findViewById(r.g.hot_thread_line_praise);
        this.bdG = (TextView) findViewById.findViewById(r.g.hot_thread_line_comment);
        this.cJf = new ArrayList();
        this.cJf.add(this.cJc);
        this.cJf.add(this.cJd);
        this.cJf.add(this.cJe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cIU = eVar;
            if (eVar.ann() != null) {
                List<String> ann = eVar.ann();
                if (ann.size() > 3) {
                    ann.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) y.c(ann, i);
                    TbImageView tbImageView = this.cJf.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!eVar.Wz()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.title.setText(eVar.getTitle());
            this.bdF.setVisibility(0);
            String w = az.w(eVar.ank());
            this.bdF.setText(w);
            this.bdF.setContentDescription(String.valueOf(this.Gd.getString(r.j.zan_num)) + w);
            com.baidu.tieba.graffiti.d.ak(this.bdF);
            String w2 = az.w(eVar.anl());
            this.bdG.setText(w2);
            this.bdG.setContentDescription(String.valueOf(this.Gd.getString(r.j.reply_num)) + w2);
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bdE.setVisibility(8);
            } else {
                this.bdE.setVisibility(0);
                this.bdE.setText(getContext().getString(r.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bdE.setOnClickListener(new i(this, eVar));
            }
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ru(String.valueOf(eVar.getThreadId()))) {
                this.cIT = r.d.cp_cont_c;
            } else {
                this.cIT = r.d.cp_cont_b;
            }
            av.c(this.title, this.cIT, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cIT != 0 && this.title != null) {
                av.c(this.title, this.cIT, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
