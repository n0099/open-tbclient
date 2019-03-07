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
    private TextView dAW;
    private LinearLayout eGi;
    private BarImageView eGj;
    private TextView eGk;
    private TextView eGl;
    private TextView eGm;
    private View eGn;
    private TextView eGo;
    private TextView eGp;
    private a eGq;
    private com.baidu.tieba.enterForum.recommend.b.b eGr;

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
        this.eGi = (LinearLayout) rootView.findViewById(d.g.forum_item_container);
        this.eGj = (BarImageView) rootView.findViewById(d.g.forum_image);
        this.dAW = (TextView) rootView.findViewById(d.g.forum_name);
        this.eGk = (TextView) rootView.findViewById(d.g.forum_attention);
        this.eGl = (TextView) rootView.findViewById(d.g.forum_thread);
        this.eGm = (TextView) rootView.findViewById(d.g.forum_introduce);
        this.eGn = rootView.findViewById(d.g.forum_like_container);
        this.eGo = (TextView) rootView.findViewById(d.g.forum_like);
        this.eGp = (TextView) rootView.findViewById(d.g.forum_already_like);
        this.eGp.setVisibility(8);
        this.eGj.setOnClickListener(this);
        this.eGn.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.eGq = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eGn) {
            if (!this.eGr.bAw) {
                this.eGq.d(this.eGr);
                return;
            }
            return;
        }
        this.eGq.e(this.eGr);
    }

    public void onChangeSkinType() {
        al.j(this.dAW, d.C0236d.cp_cont_b);
        al.j(this.eGk, d.C0236d.cp_cont_d);
        al.j(this.eGl, d.C0236d.cp_cont_d);
        al.j(this.eGm, d.C0236d.cp_cont_j);
        al.d(this.eGo, d.f.recommend_like_btn_selector, 1);
        al.k(this.eGn, d.f.recommend_like_bg);
        al.k(this.eGi, d.f.recommend_forum_item_bg);
        al.j(this.eGp, d.C0236d.cp_cont_d);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.eGr = bVar;
            this.eGj.startLoad(bVar.avatar, 15, false);
            this.eGj.setStrokeColorResId(d.C0236d.cp_bg_line_d);
            this.eGj.setStrokeWith(3);
            this.eGj.setShowOval(true);
            String str = bVar.forumName;
            if (ap.isEmpty(str)) {
                str = "";
            }
            this.dAW.setText(str);
            this.eGk.setText("关注 " + ap.az(bVar.memberCount));
            this.eGl.setText("贴子 " + ap.az(bVar.threadCount));
            if (!ap.isEmpty(bVar.eEI)) {
                this.eGm.setText(bVar.eEI);
            } else {
                this.eGm.setText(TbadkCoreApplication.getInst().getString(d.j.recommend_forum_default_introduce));
            }
            iC(bVar.bAw);
            g(bVar);
        }
    }

    public void iC(boolean z) {
        if (z) {
            this.eGn.setVisibility(8);
            this.eGp.setVisibility(0);
        } else {
            this.eGn.setVisibility(0);
            this.eGp.setVisibility(8);
        }
        this.eGr.bAw = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            am amVar = new am("c13374");
            amVar.bJ("obj_type", String.valueOf(bVar.eEM));
            amVar.k(ImageViewerConfig.FORUM_ID, bVar.forumId);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(amVar);
        }
    }
}
