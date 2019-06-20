package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout eVL;
    private BarImageView eVM;
    private TextView eVN;
    private TextView eVO;
    private TextView eVP;
    private TextView eVQ;
    private View eVR;
    private TextView eVS;
    private TextView eVT;
    private a eVU;
    private com.baidu.tieba.enterForum.recommend.b.b eVV;

    /* loaded from: classes4.dex */
    interface a {
        void d(com.baidu.tieba.enterForum.recommend.b.b bVar);

        void e(com.baidu.tieba.enterForum.recommend.b.b bVar);
    }

    public RecommendForumItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap(context);
    }

    public RecommendForumItemView(Context context) {
        super(context);
        ap(context);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.recommend_forum_item_layout, this);
        View rootView = getRootView();
        this.eVL = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.eVM = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.eVN = (TextView) rootView.findViewById(R.id.forum_name);
        this.eVO = (TextView) rootView.findViewById(R.id.forum_attention);
        this.eVP = (TextView) rootView.findViewById(R.id.forum_thread);
        this.eVQ = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.eVR = rootView.findViewById(R.id.forum_like_container);
        this.eVS = (TextView) rootView.findViewById(R.id.forum_like);
        this.eVT = (TextView) rootView.findViewById(R.id.forum_already_like);
        this.eVT.setVisibility(8);
        this.eVM.setOnClickListener(this);
        this.eVR.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.eVU = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eVR) {
            if (!this.eVV.bHP) {
                this.eVU.d(this.eVV);
                return;
            }
            return;
        }
        this.eVU.e(this.eVV);
    }

    public void onChangeSkinType() {
        al.j(this.eVN, R.color.cp_cont_b);
        al.j(this.eVO, R.color.cp_cont_d);
        al.j(this.eVP, R.color.cp_cont_d);
        al.j(this.eVQ, R.color.cp_cont_j);
        al.f(this.eVS, R.drawable.recommend_like_btn_selector, 1);
        al.k(this.eVR, R.drawable.recommend_like_bg);
        al.k(this.eVL, R.drawable.recommend_forum_item_bg);
        al.j(this.eVT, R.color.cp_cont_d);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.eVV = bVar;
            this.eVM.startLoad(bVar.avatar, 15, false);
            this.eVM.setStrokeColorResId(R.color.cp_bg_line_d);
            this.eVM.setStrokeWith(3);
            this.eVM.setShowOval(true);
            String str = bVar.forumName;
            if (ap.isEmpty(str)) {
                str = "";
            }
            this.eVN.setText(str);
            this.eVO.setText("关注 " + ap.aN(bVar.memberCount));
            this.eVP.setText("贴子 " + ap.aN(bVar.threadCount));
            if (!ap.isEmpty(bVar.eUl)) {
                this.eVQ.setText(bVar.eUl);
            } else {
                this.eVQ.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            jj(bVar.bHP);
            g(bVar);
        }
    }

    public void jj(boolean z) {
        if (z) {
            this.eVR.setVisibility(8);
            this.eVT.setVisibility(0);
        } else {
            this.eVR.setVisibility(0);
            this.eVT.setVisibility(8);
        }
        this.eVV.bHP = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            am amVar = new am("c13374");
            amVar.bT("obj_type", String.valueOf(bVar.eUp));
            amVar.l("fid", bVar.forumId);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(amVar);
        }
    }
}
