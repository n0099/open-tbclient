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
    private TbImageView aWs;
    private TextView aWt;
    private TextView aWu;
    private TextView aWv;
    private int ctH;
    private com.baidu.tieba.homepage.recommendfrs.data.e ctI;
    private View.OnClickListener ctJ;
    private int ctL;
    private LineCountNotifyTextView ctM;
    private TextView ctN;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.ctL = -1;
        this.ctH = 0;
        this.ctJ = new d(this);
        view.setOnClickListener(this.ctJ);
        this.aWs = (TbImageView) view.findViewById(u.g.img);
        this.ctM = (LineCountNotifyTextView) view.findViewById(u.g.title);
        this.ctN = (TextView) view.findViewById(u.g.discription);
        View findViewById = view.findViewById(u.g.hot_thread_comment);
        this.aWt = (TextView) findViewById.findViewById(u.g.hot_thread_line_tag);
        this.aWu = (TextView) findViewById.findViewById(u.g.hot_thread_line_praise);
        this.aWv = (TextView) findViewById.findViewById(u.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.B(eVar);
        if (eVar != null) {
            this.ctI = eVar;
            String str = (eVar.ahB() == null || eVar.ahB().size() <= 0) ? null : eVar.ahB().get(0);
            TbImageView tbImageView = this.aWs;
            if (!eVar.QL()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(eVar.getTitle())) {
                this.ctM.setText(eVar.getTitle());
                this.ctM.setGetLineCountCallback(new e(this, eVar));
            }
            if (StringUtils.isNull(eVar.getForumName())) {
                this.aWt.setVisibility(8);
            } else {
                this.aWt.setVisibility(0);
                this.aWt.setText(getContext().getString(u.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.aWt.setOnClickListener(new f(this, eVar));
            }
            this.aWu.setVisibility(0);
            this.aWu.setText(ba.B(eVar.ahy()));
            com.baidu.tieba.graffiti.d.an(this.aWu);
            this.aWv.setText(ba.B(eVar.ahz()));
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.pL(String.valueOf(eVar.getThreadId()))) {
                this.ctH = u.d.cp_cont_c;
            } else {
                this.ctH = u.d.cp_cont_b;
            }
            av.c(this.ctM, this.ctH, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
            if (this.ctH != 0 && this.ctM != null) {
                av.c(this.ctM, this.ctH, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
