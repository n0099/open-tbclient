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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private TextView hhA;
    private TextView hhB;
    private TextView hhC;
    private TextView hhD;
    private TBSpecificationBtn hhE;
    private a hhF;
    private com.baidu.tieba.enterForum.recommend.b.b hhG;
    private LinearLayout hhw;
    private View hhx;
    private View hhy;
    private BarImageView hhz;

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
        this.hhw = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.hhx = rootView.findViewById(R.id.view_top);
        this.hhy = rootView.findViewById(R.id.view_bottom);
        this.hhz = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.hhA = (TextView) rootView.findViewById(R.id.forum_name);
        this.hhB = (TextView) rootView.findViewById(R.id.forum_attention);
        this.hhC = (TextView) rootView.findViewById(R.id.forum_thread);
        this.hhD = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.hhE = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mC(R.color.cp_link_tip_a);
        this.hhE.setConfig(cVar);
        this.hhE.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.hhz.setPlaceHolder(2);
        this.hhz.setOnClickListener(this);
        this.hhE.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.hhF = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hhE) {
            if (this.hhG.dKM) {
                this.hhF.e(this.hhG);
                return;
            } else {
                this.hhF.d(this.hhG);
                return;
            }
        }
        this.hhF.e(this.hhG);
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.hhA, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hhB, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.hhC, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.hhD, (int) R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.hhG = bVar;
            this.hhz.startLoad(bVar.avatar, 15, false);
            this.hhz.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hhz.setStrokeWith(3);
            this.hhz.setShowOval(true);
            String str = bVar.forumName;
            if (ar.isEmpty(str)) {
                str = "";
            }
            this.hhA.setText(str);
            this.hhB.setText("关注 " + ar.numFormatOverWan(bVar.memberCount));
            this.hhC.setText("贴子 " + ar.numFormatOverWan(bVar.threadCount));
            if (!ar.isEmpty(bVar.hfX)) {
                this.hhD.setText(bVar.hfX);
            } else {
                this.hhD.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            mz(bVar.dKM);
            com.baidu.tbadk.core.util.e.a.c.aXu().S(l.getDimens(getContext(), R.dimen.tbds10)).R(l.getDimens(getContext(), R.dimen.tbds10)).lH(R.color.cp_btn_a).aR(this.hhx);
            com.baidu.tbadk.core.util.e.a.aXp().lW(R.color.cp_btn_a).lR(l.getDimens(getContext(), R.dimen.tbds10)).lS(R.color.cp_shadow_a_alpha16).lQ(4353).lT(l.getDimens(getContext(), R.dimen.tbds10)).lU(0).lV(l.getDimens(getContext(), R.dimen.tbds5)).aR(this.hhy);
            g(bVar);
        }
    }

    public void mz(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mE(R.color.cp_cont_d);
            this.hhE.setConfig(cVar);
            this.hhE.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.hhE.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mC(R.color.cp_link_tip_a);
            this.hhE.setConfig(cVar2);
            this.hhE.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.hhE.setClickState(true);
        }
        this.hhG.dKM = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            ao aoVar = new ao("c13374");
            aoVar.dk("obj_type", String.valueOf(bVar.hgb));
            aoVar.s("fid", bVar.forumId);
            aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aoVar);
        }
    }
}
