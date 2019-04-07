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
    private LinearLayout eFP;
    private BarImageView eFQ;
    private TextView eFR;
    private TextView eFS;
    private TextView eFT;
    private TextView eFU;
    private View eFV;
    private TextView eFW;
    private TextView eFX;
    private a eFY;
    private com.baidu.tieba.enterForum.recommend.b.b eFZ;

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
        this.eFP = (LinearLayout) rootView.findViewById(d.g.forum_item_container);
        this.eFQ = (BarImageView) rootView.findViewById(d.g.forum_image);
        this.eFR = (TextView) rootView.findViewById(d.g.forum_name);
        this.eFS = (TextView) rootView.findViewById(d.g.forum_attention);
        this.eFT = (TextView) rootView.findViewById(d.g.forum_thread);
        this.eFU = (TextView) rootView.findViewById(d.g.forum_introduce);
        this.eFV = rootView.findViewById(d.g.forum_like_container);
        this.eFW = (TextView) rootView.findViewById(d.g.forum_like);
        this.eFX = (TextView) rootView.findViewById(d.g.forum_already_like);
        this.eFX.setVisibility(8);
        this.eFQ.setOnClickListener(this);
        this.eFV.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.eFY = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eFV) {
            if (!this.eFZ.bAB) {
                this.eFY.d(this.eFZ);
                return;
            }
            return;
        }
        this.eFY.e(this.eFZ);
    }

    public void onChangeSkinType() {
        al.j(this.eFR, d.C0277d.cp_cont_b);
        al.j(this.eFS, d.C0277d.cp_cont_d);
        al.j(this.eFT, d.C0277d.cp_cont_d);
        al.j(this.eFU, d.C0277d.cp_cont_j);
        al.d(this.eFW, d.f.recommend_like_btn_selector, 1);
        al.k(this.eFV, d.f.recommend_like_bg);
        al.k(this.eFP, d.f.recommend_forum_item_bg);
        al.j(this.eFX, d.C0277d.cp_cont_d);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.eFZ = bVar;
            this.eFQ.startLoad(bVar.avatar, 15, false);
            this.eFQ.setStrokeColorResId(d.C0277d.cp_bg_line_d);
            this.eFQ.setStrokeWith(3);
            this.eFQ.setShowOval(true);
            String str = bVar.forumName;
            if (ap.isEmpty(str)) {
                str = "";
            }
            this.eFR.setText(str);
            this.eFS.setText("关注 " + ap.az(bVar.memberCount));
            this.eFT.setText("贴子 " + ap.az(bVar.threadCount));
            if (!ap.isEmpty(bVar.eEp)) {
                this.eFU.setText(bVar.eEp);
            } else {
                this.eFU.setText(TbadkCoreApplication.getInst().getString(d.j.recommend_forum_default_introduce));
            }
            iC(bVar.bAB);
            g(bVar);
        }
    }

    public void iC(boolean z) {
        if (z) {
            this.eFV.setVisibility(8);
            this.eFX.setVisibility(0);
        } else {
            this.eFV.setVisibility(0);
            this.eFX.setVisibility(8);
        }
        this.eFZ.bAB = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            am amVar = new am("c13374");
            amVar.bJ("obj_type", String.valueOf(bVar.eEt));
            amVar.k(ImageViewerConfig.FORUM_ID, bVar.forumId);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(amVar);
        }
    }
}
