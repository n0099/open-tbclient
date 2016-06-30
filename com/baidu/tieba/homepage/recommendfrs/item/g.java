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
    private TbPageContext<?> Dp;
    private TextView aWt;
    private TextView aWu;
    private TextView aWv;
    private int ctH;
    private com.baidu.tieba.homepage.recommendfrs.data.e ctI;
    private View.OnClickListener ctJ;
    private TbImageView ctQ;
    private TbImageView ctR;
    private TbImageView ctS;
    private List<TbImageView> ctT;
    private final int ctU;
    private int mSkinType;
    private TextView title;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.ctU = 3;
        this.ctH = 0;
        this.ctJ = new h(this);
        this.Dp = tbPageContext;
        view.setOnClickListener(this.ctJ);
        this.ctQ = (TbImageView) view.findViewById(u.g.img1);
        this.ctR = (TbImageView) view.findViewById(u.g.img2);
        this.ctS = (TbImageView) view.findViewById(u.g.img3);
        this.title = (TextView) view.findViewById(u.g.title);
        View findViewById = view.findViewById(u.g.hot_thread_comment);
        this.aWt = (TextView) findViewById.findViewById(u.g.hot_thread_line_tag);
        this.aWu = (TextView) findViewById.findViewById(u.g.hot_thread_line_praise);
        this.aWv = (TextView) findViewById.findViewById(u.g.hot_thread_line_comment);
        this.ctT = new ArrayList();
        this.ctT.add(this.ctQ);
        this.ctT.add(this.ctR);
        this.ctT.add(this.ctS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.B(eVar);
        if (eVar != null) {
            this.ctI = eVar;
            if (eVar.ahB() != null) {
                List<String> ahB = eVar.ahB();
                if (ahB.size() > 3) {
                    ahB.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) y.c(ahB, i);
                    TbImageView tbImageView = this.ctT.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!eVar.QL()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.title.setText(eVar.getTitle());
            this.aWu.setVisibility(0);
            String B = ba.B(eVar.ahy());
            this.aWu.setText(B);
            this.aWu.setContentDescription(String.valueOf(this.Dp.getString(u.j.zan_num)) + B);
            com.baidu.tieba.graffiti.d.an(this.aWu);
            String B2 = ba.B(eVar.ahz());
            this.aWv.setText(B2);
            this.aWv.setContentDescription(String.valueOf(this.Dp.getString(u.j.reply_num)) + B2);
            if (StringUtils.isNull(eVar.getForumName())) {
                this.aWt.setVisibility(8);
            } else {
                this.aWt.setVisibility(0);
                this.aWt.setText(getContext().getString(u.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.aWt.setOnClickListener(new i(this, eVar));
            }
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.pL(String.valueOf(eVar.getThreadId()))) {
                this.ctH = u.d.cp_cont_c;
            } else {
                this.ctH = u.d.cp_cont_b;
            }
            av.c(this.title, this.ctH, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
            if (this.ctH != 0 && this.title != null) {
                av.c(this.title, this.ctH, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
