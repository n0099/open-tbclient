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
    private LinearLayout gFO;
    private View gFP;
    private View gFQ;
    private BarImageView gFR;
    private TextView gFS;
    private TextView gFT;
    private TextView gFU;
    private TextView gFV;
    private TBSpecificationBtn gFW;
    private a gFX;
    private com.baidu.tieba.enterForum.recommend.b.b gFY;

    /* loaded from: classes9.dex */
    public interface a {
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
        this.gFO = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.gFP = rootView.findViewById(R.id.view_top);
        this.gFQ = rootView.findViewById(R.id.view_bottom);
        this.gFR = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.gFS = (TextView) rootView.findViewById(R.id.forum_name);
        this.gFT = (TextView) rootView.findViewById(R.id.forum_attention);
        this.gFU = (TextView) rootView.findViewById(R.id.forum_thread);
        this.gFV = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.gFW = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lG(R.color.cp_link_tip_a);
        this.gFW.setConfig(cVar);
        this.gFW.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.gFR.setPlaceHolder(2);
        this.gFR.setOnClickListener(this);
        this.gFW.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.gFX = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gFW) {
            if (this.gFY.dqh) {
                this.gFX.e(this.gFY);
                return;
            } else {
                this.gFX.d(this.gFY);
                return;
            }
        }
        this.gFX.e(this.gFY);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gFS, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gFT, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gFU, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gFV, (int) R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.gFY = bVar;
            this.gFR.startLoad(bVar.avatar, 15, false);
            this.gFR.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gFR.setStrokeWith(3);
            this.gFR.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.gFS.setText(str);
            this.gFT.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.gFU.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.gEp)) {
                this.gFV.setText(bVar.gEp);
            } else {
                this.gFV.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            lT(bVar.dqh);
            com.baidu.tbadk.core.util.e.a.c.aPy().R(l.getDimens(getContext(), R.dimen.tbds10)).Q(l.getDimens(getContext(), R.dimen.tbds10)).kM(R.color.cp_btn_a).aR(this.gFP);
            com.baidu.tbadk.core.util.e.a.aPt().lb(R.color.cp_btn_a).kW(l.getDimens(getContext(), R.dimen.tbds10)).kX(R.color.cp_shadow_a_alpha16).kV(4353).kY(l.getDimens(getContext(), R.dimen.tbds10)).kZ(0).la(l.getDimens(getContext(), R.dimen.tbds5)).aR(this.gFQ);
            g(bVar);
        }
    }

    public void lT(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.lI(R.color.cp_cont_d);
            this.gFW.setConfig(cVar);
            this.gFW.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.gFW.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.lG(R.color.cp_link_tip_a);
            this.gFW.setConfig(cVar2);
            this.gFW.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.gFW.setClickState(true);
        }
        this.gFY.dqh = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.cI("obj_type", String.valueOf(bVar.gEt));
            anVar.t("fid", bVar.forumId);
            anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
