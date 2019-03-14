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
    private TextView dAS;
    private LinearLayout eGe;
    private BarImageView eGf;
    private TextView eGg;
    private TextView eGh;
    private TextView eGi;
    private View eGj;
    private TextView eGk;
    private TextView eGl;
    private a eGm;
    private com.baidu.tieba.enterForum.recommend.b.b eGn;

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
        this.eGe = (LinearLayout) rootView.findViewById(d.g.forum_item_container);
        this.eGf = (BarImageView) rootView.findViewById(d.g.forum_image);
        this.dAS = (TextView) rootView.findViewById(d.g.forum_name);
        this.eGg = (TextView) rootView.findViewById(d.g.forum_attention);
        this.eGh = (TextView) rootView.findViewById(d.g.forum_thread);
        this.eGi = (TextView) rootView.findViewById(d.g.forum_introduce);
        this.eGj = rootView.findViewById(d.g.forum_like_container);
        this.eGk = (TextView) rootView.findViewById(d.g.forum_like);
        this.eGl = (TextView) rootView.findViewById(d.g.forum_already_like);
        this.eGl.setVisibility(8);
        this.eGf.setOnClickListener(this);
        this.eGj.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.eGm = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eGj) {
            if (!this.eGn.bAy) {
                this.eGm.d(this.eGn);
                return;
            }
            return;
        }
        this.eGm.e(this.eGn);
    }

    public void onChangeSkinType() {
        al.j(this.dAS, d.C0277d.cp_cont_b);
        al.j(this.eGg, d.C0277d.cp_cont_d);
        al.j(this.eGh, d.C0277d.cp_cont_d);
        al.j(this.eGi, d.C0277d.cp_cont_j);
        al.d(this.eGk, d.f.recommend_like_btn_selector, 1);
        al.k(this.eGj, d.f.recommend_like_bg);
        al.k(this.eGe, d.f.recommend_forum_item_bg);
        al.j(this.eGl, d.C0277d.cp_cont_d);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.eGn = bVar;
            this.eGf.startLoad(bVar.avatar, 15, false);
            this.eGf.setStrokeColorResId(d.C0277d.cp_bg_line_d);
            this.eGf.setStrokeWith(3);
            this.eGf.setShowOval(true);
            String str = bVar.forumName;
            if (ap.isEmpty(str)) {
                str = "";
            }
            this.dAS.setText(str);
            this.eGg.setText("关注 " + ap.az(bVar.memberCount));
            this.eGh.setText("贴子 " + ap.az(bVar.threadCount));
            if (!ap.isEmpty(bVar.eEE)) {
                this.eGi.setText(bVar.eEE);
            } else {
                this.eGi.setText(TbadkCoreApplication.getInst().getString(d.j.recommend_forum_default_introduce));
            }
            iC(bVar.bAy);
            g(bVar);
        }
    }

    public void iC(boolean z) {
        if (z) {
            this.eGj.setVisibility(8);
            this.eGl.setVisibility(0);
        } else {
            this.eGj.setVisibility(0);
            this.eGl.setVisibility(8);
        }
        this.eGn.bAy = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            am amVar = new am("c13374");
            amVar.bJ("obj_type", String.valueOf(bVar.eEI));
            amVar.k(ImageViewerConfig.FORUM_ID, bVar.forumId);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(amVar);
        }
    }
}
