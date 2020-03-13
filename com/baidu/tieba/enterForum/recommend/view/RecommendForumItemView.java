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
    private LinearLayout fYB;
    private View fYC;
    private View fYD;
    private BarImageView fYE;
    private TextView fYF;
    private TextView fYG;
    private TextView fYH;
    private TextView fYI;
    private TBSpecificationBtn fYJ;
    private a fYK;
    private com.baidu.tieba.enterForum.recommend.b.b fYL;

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
        this.fYB = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.fYC = rootView.findViewById(R.id.view_top);
        this.fYD = rootView.findViewById(R.id.view_bottom);
        this.fYE = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.fYF = (TextView) rootView.findViewById(R.id.forum_name);
        this.fYG = (TextView) rootView.findViewById(R.id.forum_attention);
        this.fYH = (TextView) rootView.findViewById(R.id.forum_thread);
        this.fYI = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.fYJ = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.ls(R.color.cp_link_tip_a);
        this.fYJ.setConfig(cVar);
        this.fYJ.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.fYE.setPlaceHolder(2);
        this.fYE.setOnClickListener(this);
        this.fYJ.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.fYK = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fYJ) {
            if (this.fYL.cQO) {
                this.fYK.e(this.fYL);
                return;
            } else {
                this.fYK.d(this.fYL);
                return;
            }
        }
        this.fYK.e(this.fYL);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fYF, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fYG, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fYH, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fYI, (int) R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.fYL = bVar;
            this.fYE.startLoad(bVar.avatar, 15, false);
            this.fYE.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fYE.setStrokeWith(3);
            this.fYE.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.fYF.setText(str);
            this.fYG.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.fYH.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.fXd)) {
                this.fYI.setText(bVar.fXd);
            } else {
                this.fYI.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            kL(bVar.cQO);
            com.baidu.tbadk.core.util.e.a.b.aHc().ah(l.getDimens(getContext(), R.dimen.tbds10)).ag(l.getDimens(getContext(), R.dimen.tbds10)).kC(R.color.cp_btn_a).aQ(this.fYC);
            com.baidu.tbadk.core.util.e.a.aHa().kR(R.color.cp_btn_a).kM(l.getDimens(getContext(), R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kL(4353).kO(l.getDimens(getContext(), R.dimen.tbds10)).kP(0).kQ(l.getDimens(getContext(), R.dimen.tbds5)).aQ(this.fYD);
            g(bVar);
        }
    }

    public void kL(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.lu(R.color.cp_cont_d);
            this.fYJ.setConfig(cVar);
            this.fYJ.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.fYJ.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.ls(R.color.cp_link_tip_a);
            this.fYJ.setConfig(cVar2);
            this.fYJ.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.fYJ.setClickState(true);
        }
        this.fYL.cQO = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.cy("obj_type", String.valueOf(bVar.fXh));
            anVar.s("fid", bVar.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
