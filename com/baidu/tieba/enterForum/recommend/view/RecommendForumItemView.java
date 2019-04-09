package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout eFQ;
    private BarImageView eFR;
    private TextView eFS;
    private TextView eFT;
    private TextView eFU;
    private TextView eFV;
    private View eFW;
    private TextView eFX;
    private TextView eFY;
    private a eFZ;
    private com.baidu.tieba.enterForum.recommend.b.b eGa;

    /* loaded from: classes4.dex */
    interface a {
        void d(com.baidu.tieba.enterForum.recommend.b.b bVar);

        void e(com.baidu.tieba.enterForum.recommend.b.b bVar);
    }

    public RecommendForumItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aX(context);
    }

    public RecommendForumItemView(Context context) {
        super(context);
        aX(context);
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.recommend_forum_item_layout, this);
        View rootView = getRootView();
        this.eFQ = (LinearLayout) rootView.findViewById(d.g.forum_item_container);
        this.eFR = (BarImageView) rootView.findViewById(d.g.forum_image);
        this.eFS = (TextView) rootView.findViewById(d.g.forum_name);
        this.eFT = (TextView) rootView.findViewById(d.g.forum_attention);
        this.eFU = (TextView) rootView.findViewById(d.g.forum_thread);
        this.eFV = (TextView) rootView.findViewById(d.g.forum_introduce);
        this.eFW = rootView.findViewById(d.g.forum_like_container);
        this.eFX = (TextView) rootView.findViewById(d.g.forum_like);
        this.eFY = (TextView) rootView.findViewById(d.g.forum_already_like);
        this.eFY.setVisibility(8);
        this.eFR.setOnClickListener(this);
        this.eFW.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.eFZ = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eFW) {
            if (!this.eGa.bAC) {
                this.eFZ.d(this.eGa);
                return;
            }
            return;
        }
        this.eFZ.e(this.eGa);
    }

    public void onChangeSkinType() {
        al.j(this.eFS, d.C0277d.cp_cont_b);
        al.j(this.eFT, d.C0277d.cp_cont_d);
        al.j(this.eFU, d.C0277d.cp_cont_d);
        al.j(this.eFV, d.C0277d.cp_cont_j);
        al.d(this.eFX, d.f.recommend_like_btn_selector, 1);
        al.k(this.eFW, d.f.recommend_like_bg);
        al.k(this.eFQ, d.f.recommend_forum_item_bg);
        al.j(this.eFY, d.C0277d.cp_cont_d);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.eGa = bVar;
            this.eFR.startLoad(bVar.avatar, 15, false);
            this.eFR.setStrokeColorResId(d.C0277d.cp_bg_line_d);
            this.eFR.setStrokeWith(3);
            this.eFR.setShowOval(true);
            String str = bVar.forumName;
            if (ap.isEmpty(str)) {
                str = "";
            }
            this.eFS.setText(str);
            this.eFT.setText("关注 " + ap.az(bVar.memberCount));
            this.eFU.setText("贴子 " + ap.az(bVar.threadCount));
            if (!ap.isEmpty(bVar.eEq)) {
                this.eFV.setText(bVar.eEq);
            } else {
                this.eFV.setText(TbadkCoreApplication.getInst().getString(d.j.recommend_forum_default_introduce));
            }
            iC(bVar.bAC);
            g(bVar);
        }
    }

    public void iC(boolean z) {
        if (z) {
            this.eFW.setVisibility(8);
            this.eFY.setVisibility(0);
        } else {
            this.eFW.setVisibility(0);
            this.eFY.setVisibility(8);
        }
        this.eGa.bAC = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            am amVar = new am("c13374");
            amVar.bJ("obj_type", String.valueOf(bVar.eEu));
            amVar.k(ImageViewerConfig.FORUM_ID, bVar.forumId);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(amVar);
        }
    }
}
