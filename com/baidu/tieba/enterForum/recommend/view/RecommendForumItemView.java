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
    private LinearLayout fYo;
    private View fYp;
    private View fYq;
    private BarImageView fYr;
    private TextView fYs;
    private TextView fYt;
    private TextView fYu;
    private TextView fYv;
    private TBSpecificationBtn fYw;
    private a fYx;
    private com.baidu.tieba.enterForum.recommend.b.b fYy;

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
        this.fYo = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.fYp = rootView.findViewById(R.id.view_top);
        this.fYq = rootView.findViewById(R.id.view_bottom);
        this.fYr = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.fYs = (TextView) rootView.findViewById(R.id.forum_name);
        this.fYt = (TextView) rootView.findViewById(R.id.forum_attention);
        this.fYu = (TextView) rootView.findViewById(R.id.forum_thread);
        this.fYv = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.fYw = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.ls(R.color.cp_link_tip_a);
        this.fYw.setConfig(cVar);
        this.fYw.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.fYr.setPlaceHolder(2);
        this.fYr.setOnClickListener(this);
        this.fYw.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.fYx = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fYw) {
            if (this.fYy.cQN) {
                this.fYx.e(this.fYy);
                return;
            } else {
                this.fYx.d(this.fYy);
                return;
            }
        }
        this.fYx.e(this.fYy);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fYs, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fYt, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fYu, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fYv, (int) R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.fYy = bVar;
            this.fYr.startLoad(bVar.avatar, 15, false);
            this.fYr.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fYr.setStrokeWith(3);
            this.fYr.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.fYs.setText(str);
            this.fYt.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.fYu.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.fWQ)) {
                this.fYv.setText(bVar.fWQ);
            } else {
                this.fYv.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            kL(bVar.cQN);
            com.baidu.tbadk.core.util.f.a.b.aHb().ah(l.getDimens(getContext(), R.dimen.tbds10)).ag(l.getDimens(getContext(), R.dimen.tbds10)).kC(R.color.cp_btn_a).aQ(this.fYp);
            com.baidu.tbadk.core.util.f.a.aGZ().kR(R.color.cp_btn_a).kM(l.getDimens(getContext(), R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kL(4353).kO(l.getDimens(getContext(), R.dimen.tbds10)).kP(0).kQ(l.getDimens(getContext(), R.dimen.tbds5)).aQ(this.fYq);
            g(bVar);
        }
    }

    public void kL(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.lu(R.color.cp_cont_d);
            this.fYw.setConfig(cVar);
            this.fYw.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.fYw.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.ls(R.color.cp_link_tip_a);
            this.fYw.setConfig(cVar2);
            this.fYw.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.fYw.setClickState(true);
        }
        this.fYy.cQN = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.cy("obj_type", String.valueOf(bVar.fWU));
            anVar.s("fid", bVar.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
