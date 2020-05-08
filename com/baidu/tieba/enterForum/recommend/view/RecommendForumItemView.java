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
    private LinearLayout gFU;
    private View gFV;
    private View gFW;
    private BarImageView gFX;
    private TextView gFY;
    private TextView gFZ;
    private TextView gGa;
    private TextView gGb;
    private TBSpecificationBtn gGc;
    private a gGd;
    private com.baidu.tieba.enterForum.recommend.b.b gGe;

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
        this.gFU = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.gFV = rootView.findViewById(R.id.view_top);
        this.gFW = rootView.findViewById(R.id.view_bottom);
        this.gFX = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.gFY = (TextView) rootView.findViewById(R.id.forum_name);
        this.gFZ = (TextView) rootView.findViewById(R.id.forum_attention);
        this.gGa = (TextView) rootView.findViewById(R.id.forum_thread);
        this.gGb = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.gGc = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lG(R.color.cp_link_tip_a);
        this.gGc.setConfig(cVar);
        this.gGc.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.gFX.setPlaceHolder(2);
        this.gFX.setOnClickListener(this);
        this.gGc.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.gGd = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gGc) {
            if (this.gGe.dql) {
                this.gGd.e(this.gGe);
                return;
            } else {
                this.gGd.d(this.gGe);
                return;
            }
        }
        this.gGd.e(this.gGe);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gFY, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gFZ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gGa, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gGb, (int) R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.gGe = bVar;
            this.gFX.startLoad(bVar.avatar, 15, false);
            this.gFX.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gFX.setStrokeWith(3);
            this.gFX.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.gFY.setText(str);
            this.gFZ.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.gGa.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.gEv)) {
                this.gGb.setText(bVar.gEv);
            } else {
                this.gGb.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            lT(bVar.dql);
            com.baidu.tbadk.core.util.e.a.c.aPv().R(l.getDimens(getContext(), R.dimen.tbds10)).Q(l.getDimens(getContext(), R.dimen.tbds10)).kM(R.color.cp_btn_a).aR(this.gFV);
            com.baidu.tbadk.core.util.e.a.aPq().lb(R.color.cp_btn_a).kW(l.getDimens(getContext(), R.dimen.tbds10)).kX(R.color.cp_shadow_a_alpha16).kV(4353).kY(l.getDimens(getContext(), R.dimen.tbds10)).kZ(0).la(l.getDimens(getContext(), R.dimen.tbds5)).aR(this.gFW);
            g(bVar);
        }
    }

    public void lT(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.lI(R.color.cp_cont_d);
            this.gGc.setConfig(cVar);
            this.gGc.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.gGc.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.lG(R.color.cp_link_tip_a);
            this.gGc.setConfig(cVar2);
            this.gGc.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.gGc.setClickState(true);
        }
        this.gGe.dql = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.cI("obj_type", String.valueOf(bVar.gEz));
            anVar.t("fid", bVar.forumId);
            anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
