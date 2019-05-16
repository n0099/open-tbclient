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
    private LinearLayout eVK;
    private BarImageView eVL;
    private TextView eVM;
    private TextView eVN;
    private TextView eVO;
    private TextView eVP;
    private View eVQ;
    private TextView eVR;
    private TextView eVS;
    private a eVT;
    private com.baidu.tieba.enterForum.recommend.b.b eVU;

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
        this.eVK = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.eVL = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.eVM = (TextView) rootView.findViewById(R.id.forum_name);
        this.eVN = (TextView) rootView.findViewById(R.id.forum_attention);
        this.eVO = (TextView) rootView.findViewById(R.id.forum_thread);
        this.eVP = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.eVQ = rootView.findViewById(R.id.forum_like_container);
        this.eVR = (TextView) rootView.findViewById(R.id.forum_like);
        this.eVS = (TextView) rootView.findViewById(R.id.forum_already_like);
        this.eVS.setVisibility(8);
        this.eVL.setOnClickListener(this);
        this.eVQ.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.eVT = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eVQ) {
            if (!this.eVU.bHO) {
                this.eVT.d(this.eVU);
                return;
            }
            return;
        }
        this.eVT.e(this.eVU);
    }

    public void onChangeSkinType() {
        al.j(this.eVM, R.color.cp_cont_b);
        al.j(this.eVN, R.color.cp_cont_d);
        al.j(this.eVO, R.color.cp_cont_d);
        al.j(this.eVP, R.color.cp_cont_j);
        al.f(this.eVR, R.drawable.recommend_like_btn_selector, 1);
        al.k(this.eVQ, R.drawable.recommend_like_bg);
        al.k(this.eVK, R.drawable.recommend_forum_item_bg);
        al.j(this.eVS, R.color.cp_cont_d);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.eVU = bVar;
            this.eVL.startLoad(bVar.avatar, 15, false);
            this.eVL.setStrokeColorResId(R.color.cp_bg_line_d);
            this.eVL.setStrokeWith(3);
            this.eVL.setShowOval(true);
            String str = bVar.forumName;
            if (ap.isEmpty(str)) {
                str = "";
            }
            this.eVM.setText(str);
            this.eVN.setText("关注 " + ap.aN(bVar.memberCount));
            this.eVO.setText("贴子 " + ap.aN(bVar.threadCount));
            if (!ap.isEmpty(bVar.eUk)) {
                this.eVP.setText(bVar.eUk);
            } else {
                this.eVP.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            jj(bVar.bHO);
            g(bVar);
        }
    }

    public void jj(boolean z) {
        if (z) {
            this.eVQ.setVisibility(8);
            this.eVS.setVisibility(0);
        } else {
            this.eVQ.setVisibility(0);
            this.eVS.setVisibility(8);
        }
        this.eVU.bHO = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            am amVar = new am("c13374");
            amVar.bT("obj_type", String.valueOf(bVar.eUo));
            amVar.l("fid", bVar.forumId);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(amVar);
        }
    }
}
