package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aXq;
    private TextView aXr;
    private TextView aXs;
    private TextView aXt;
    private int cwA;
    private LineCountNotifyTextView cwB;
    private TextView cwC;
    private int cww;
    private com.baidu.tieba.homepage.recommendfrs.data.e cwx;
    private View.OnClickListener cwy;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cwA = -1;
        this.cww = 0;
        this.cwy = new d(this);
        view.setOnClickListener(this.cwy);
        this.aXq = (TbImageView) view.findViewById(u.g.img);
        this.cwB = (LineCountNotifyTextView) view.findViewById(u.g.title);
        this.cwC = (TextView) view.findViewById(u.g.discription);
        View findViewById = view.findViewById(u.g.hot_thread_comment);
        this.aXr = (TextView) findViewById.findViewById(u.g.hot_thread_line_tag);
        this.aXs = (TextView) findViewById.findViewById(u.g.hot_thread_line_praise);
        this.aXt = (TextView) findViewById.findViewById(u.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cwx = eVar;
            String str = (eVar.ail() == null || eVar.ail().size() <= 0) ? null : eVar.ail().get(0);
            TbImageView tbImageView = this.aXq;
            if (!eVar.Ru()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(eVar.getTitle())) {
                this.cwB.setText(eVar.getTitle());
                this.cwB.setGetLineCountCallback(new e(this, eVar));
            }
            if (StringUtils.isNull(eVar.getForumName())) {
                this.aXr.setVisibility(8);
            } else {
                this.aXr.setVisibility(0);
                this.aXr.setText(getContext().getString(u.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.aXr.setOnClickListener(new f(this, eVar));
            }
            this.aXs.setVisibility(0);
            this.aXs.setText(ba.w(eVar.aii()));
            com.baidu.tieba.graffiti.d.al(this.aXs);
            this.aXt.setText(ba.w(eVar.aij()));
            s readThreadHistory = TbadkCoreApplication.m10getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qv(String.valueOf(eVar.getThreadId()))) {
                this.cww = u.d.cp_cont_c;
            } else {
                this.cww = u.d.cp_cont_b;
            }
            av.c(this.cwB, this.cww, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
            if (this.cww != 0 && this.cwB != null) {
                av.c(this.cwB, this.cww, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
