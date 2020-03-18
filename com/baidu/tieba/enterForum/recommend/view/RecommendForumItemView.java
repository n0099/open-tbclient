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
/* loaded from: classes9.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout fZj;
    private View fZk;
    private View fZl;
    private BarImageView fZm;
    private TextView fZn;
    private TextView fZo;
    private TextView fZp;
    private TextView fZq;
    private TBSpecificationBtn fZr;
    private a fZs;
    private com.baidu.tieba.enterForum.recommend.b.b fZt;

    /* loaded from: classes9.dex */
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
        this.fZj = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.fZk = rootView.findViewById(R.id.view_top);
        this.fZl = rootView.findViewById(R.id.view_bottom);
        this.fZm = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.fZn = (TextView) rootView.findViewById(R.id.forum_name);
        this.fZo = (TextView) rootView.findViewById(R.id.forum_attention);
        this.fZp = (TextView) rootView.findViewById(R.id.forum_thread);
        this.fZq = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.fZr = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lu(R.color.cp_link_tip_a);
        this.fZr.setConfig(cVar);
        this.fZr.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.fZm.setPlaceHolder(2);
        this.fZm.setOnClickListener(this);
        this.fZr.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.fZs = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fZr) {
            if (this.fZt.cRb) {
                this.fZs.e(this.fZt);
                return;
            } else {
                this.fZs.d(this.fZt);
                return;
            }
        }
        this.fZs.e(this.fZt);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fZn, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fZo, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fZp, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fZq, (int) R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.fZt = bVar;
            this.fZm.startLoad(bVar.avatar, 15, false);
            this.fZm.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fZm.setStrokeWith(3);
            this.fZm.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.fZn.setText(str);
            this.fZo.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.fZp.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.fXL)) {
                this.fZq.setText(bVar.fXL);
            } else {
                this.fZq.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            kQ(bVar.cRb);
            com.baidu.tbadk.core.util.e.a.b.aHg().ah(l.getDimens(getContext(), R.dimen.tbds10)).ag(l.getDimens(getContext(), R.dimen.tbds10)).kC(R.color.cp_btn_a).aQ(this.fZk);
            com.baidu.tbadk.core.util.e.a.aHe().kR(R.color.cp_btn_a).kM(l.getDimens(getContext(), R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kL(4353).kO(l.getDimens(getContext(), R.dimen.tbds10)).kP(0).kQ(l.getDimens(getContext(), R.dimen.tbds5)).aQ(this.fZl);
            g(bVar);
        }
    }

    public void kQ(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.lw(R.color.cp_cont_d);
            this.fZr.setConfig(cVar);
            this.fZr.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.fZr.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.lu(R.color.cp_link_tip_a);
            this.fZr.setConfig(cVar2);
            this.fZr.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.fZr.setClickState(true);
        }
        this.fZt.cRb = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.cx("obj_type", String.valueOf(bVar.fXP));
            anVar.s("fid", bVar.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
