package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbPageContext<?> DQ;
    private TextView aXr;
    private TextView aXs;
    private TextView aXt;
    private TbImageView cwF;
    private TbImageView cwG;
    private TbImageView cwH;
    private List<TbImageView> cwI;
    private final int cwJ;
    private int cww;
    private com.baidu.tieba.homepage.recommendfrs.data.e cwx;
    private View.OnClickListener cwy;
    private int mSkinType;
    private TextView title;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cwJ = 3;
        this.cww = 0;
        this.cwy = new h(this);
        this.DQ = tbPageContext;
        view.setOnClickListener(this.cwy);
        this.cwF = (TbImageView) view.findViewById(u.g.img1);
        this.cwG = (TbImageView) view.findViewById(u.g.img2);
        this.cwH = (TbImageView) view.findViewById(u.g.img3);
        this.title = (TextView) view.findViewById(u.g.title);
        View findViewById = view.findViewById(u.g.hot_thread_comment);
        this.aXr = (TextView) findViewById.findViewById(u.g.hot_thread_line_tag);
        this.aXs = (TextView) findViewById.findViewById(u.g.hot_thread_line_praise);
        this.aXt = (TextView) findViewById.findViewById(u.g.hot_thread_line_comment);
        this.cwI = new ArrayList();
        this.cwI.add(this.cwF);
        this.cwI.add(this.cwG);
        this.cwI.add(this.cwH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cwx = eVar;
            if (eVar.ail() != null) {
                List<String> ail = eVar.ail();
                if (ail.size() > 3) {
                    ail.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) y.c(ail, i);
                    TbImageView tbImageView = this.cwI.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!eVar.Ru()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.title.setText(eVar.getTitle());
            this.aXs.setVisibility(0);
            String w = ba.w(eVar.aii());
            this.aXs.setText(w);
            this.aXs.setContentDescription(String.valueOf(this.DQ.getString(u.j.zan_num)) + w);
            com.baidu.tieba.graffiti.d.al(this.aXs);
            String w2 = ba.w(eVar.aij());
            this.aXt.setText(w2);
            this.aXt.setContentDescription(String.valueOf(this.DQ.getString(u.j.reply_num)) + w2);
            if (StringUtils.isNull(eVar.getForumName())) {
                this.aXr.setVisibility(8);
            } else {
                this.aXr.setVisibility(0);
                this.aXr.setText(getContext().getString(u.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.aXr.setOnClickListener(new i(this, eVar));
            }
            s readThreadHistory = TbadkCoreApplication.m10getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qv(String.valueOf(eVar.getThreadId()))) {
                this.cww = u.d.cp_cont_c;
            } else {
                this.cww = u.d.cp_cont_b;
            }
            av.c(this.title, this.cww, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
            if (this.cww != 0 && this.title != null) {
                av.c(this.title, this.cww, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
