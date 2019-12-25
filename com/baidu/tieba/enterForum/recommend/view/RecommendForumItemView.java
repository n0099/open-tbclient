package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout fTc;
    private View fTd;
    private View fTe;
    private BarImageView fTf;
    private TextView fTg;
    private TextView fTh;
    private TextView fTi;
    private TextView fTj;
    private TBSpecificationBtn fTk;
    private a fTl;
    private com.baidu.tieba.enterForum.recommend.b.b fTm;

    /* loaded from: classes6.dex */
    interface a {
        void d(com.baidu.tieba.enterForum.recommend.b.b bVar);

        void e(com.baidu.tieba.enterForum.recommend.b.b bVar);
    }

    public RecommendForumItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public RecommendForumItemView(Context context) {
        super(context);
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.recommend_forum_item_layout, this);
        View rootView = getRootView();
        this.fTc = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.fTd = rootView.findViewById(R.id.view_top);
        this.fTe = rootView.findViewById(R.id.view_bottom);
        this.fTf = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.fTg = (TextView) rootView.findViewById(R.id.forum_name);
        this.fTh = (TextView) rootView.findViewById(R.id.forum_attention);
        this.fTi = (TextView) rootView.findViewById(R.id.forum_thread);
        this.fTj = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.fTk = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lb(R.color.cp_link_tip_a);
        this.fTk.setConfig(cVar);
        this.fTk.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.fTf.setPlaceHolder(2);
        this.fTf.setOnClickListener(this);
        this.fTk.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.fTl = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fTk) {
            if (this.fTm.cMz) {
                this.fTl.e(this.fTm);
                return;
            } else {
                this.fTl.d(this.fTm);
                return;
            }
        }
        this.fTl.e(this.fTm);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fTg, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fTh, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fTi, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fTj, (int) R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.fTm = bVar;
            this.fTf.startLoad(bVar.avatar, 15, false);
            this.fTf.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fTf.setStrokeWith(3);
            this.fTf.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.fTg.setText(str);
            this.fTh.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.fTi.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.fRD)) {
                this.fTj.setText(bVar.fRD);
            } else {
                this.fTj.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            kx(bVar.cMz);
            com.baidu.tbadk.core.util.f.a.b.aEu().aj(l.getDimens(getContext(), R.dimen.tbds10)).ai(l.getDimens(getContext(), R.dimen.tbds10)).kl(R.color.cp_btn_a).aM(this.fTd);
            com.baidu.tbadk.core.util.f.a.aEs().kA(R.color.cp_btn_a).kv(l.getDimens(getContext(), R.dimen.tbds10)).kw(R.color.cp_shadow_a_alpha16).ku(4353).kx(l.getDimens(getContext(), R.dimen.tbds10)).ky(0).kz(l.getDimens(getContext(), R.dimen.tbds5)).aM(this.fTe);
            g(bVar);
        }
    }

    public void kx(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.ld(R.color.cp_cont_d);
            this.fTk.setConfig(cVar);
            this.fTk.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.fTk.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.lb(R.color.cp_link_tip_a);
            this.fTk.setConfig(cVar2);
            this.fTk.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.fTk.setClickState(true);
        }
        this.fTm.cMz = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.cp("obj_type", String.valueOf(bVar.fRH));
            anVar.s("fid", bVar.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
