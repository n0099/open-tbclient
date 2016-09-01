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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView bdj;
    private TextView bdk;
    private TextView bdl;
    private TextView bdm;
    private int cIb;
    private com.baidu.tieba.homepage.recommendfrs.data.e cIc;
    private View.OnClickListener cId;
    private int cIf;
    private LineCountNotifyTextView cIg;
    private TextView cIh;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cIf = -1;
        this.cIb = 0;
        this.cId = new d(this);
        view.setOnClickListener(this.cId);
        this.bdj = (TbImageView) view.findViewById(t.g.img);
        this.cIg = (LineCountNotifyTextView) view.findViewById(t.g.title);
        this.cIh = (TextView) view.findViewById(t.g.discription);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.bdk = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.bdl = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.bdm = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cIc = eVar;
            String str = (eVar.amZ() == null || eVar.amZ().size() <= 0) ? null : eVar.amZ().get(0);
            TbImageView tbImageView = this.bdj;
            if (!eVar.Wg()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(eVar.getTitle())) {
                this.cIg.setText(eVar.getTitle());
                this.cIg.setGetLineCountCallback(new e(this, eVar));
            }
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bdk.setVisibility(8);
            } else {
                this.bdk.setVisibility(0);
                this.bdk.setText(getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bdk.setOnClickListener(new f(this, eVar));
            }
            this.bdl.setVisibility(0);
            this.bdl.setText(ba.w(eVar.amW()));
            com.baidu.tieba.graffiti.d.al(this.bdl);
            this.bdm.setText(ba.w(eVar.amX()));
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rf(String.valueOf(eVar.getThreadId()))) {
                this.cIb = t.d.cp_cont_c;
            } else {
                this.cIb = t.d.cp_cont_b;
            }
            av.c(this.cIg, this.cIb, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
            if (this.cIb != 0 && this.cIg != null) {
                av.c(this.cIg, this.cIb, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
