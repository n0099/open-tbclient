package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout faZ;
    private BarImageView fba;
    private TextView fbb;
    private TextView fbc;
    private TextView fbd;
    private TextView fbe;
    private View fbf;
    private TextView fbg;
    private TextView fbh;
    private a fbi;
    private com.baidu.tieba.enterForum.recommend.b.b fbj;

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
        this.faZ = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.fba = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.fbb = (TextView) rootView.findViewById(R.id.forum_name);
        this.fbc = (TextView) rootView.findViewById(R.id.forum_attention);
        this.fbd = (TextView) rootView.findViewById(R.id.forum_thread);
        this.fbe = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.fbf = rootView.findViewById(R.id.forum_like_container);
        this.fbg = (TextView) rootView.findViewById(R.id.forum_like);
        this.fbh = (TextView) rootView.findViewById(R.id.forum_already_like);
        this.fbh.setVisibility(8);
        this.fba.setOnClickListener(this);
        this.fbf.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.fbi = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fbf) {
            if (!this.fbj.bIU) {
                this.fbi.d(this.fbj);
                return;
            }
            return;
        }
        this.fbi.e(this.fbj);
    }

    public void onChangeSkinType() {
        am.j(this.fbb, R.color.cp_cont_b);
        am.j(this.fbc, R.color.cp_cont_d);
        am.j(this.fbd, R.color.cp_cont_d);
        am.j(this.fbe, R.color.cp_cont_j);
        am.f(this.fbg, R.drawable.recommend_like_btn_selector, 1);
        am.k(this.fbf, R.drawable.recommend_like_bg);
        am.k(this.faZ, R.drawable.recommend_forum_item_bg);
        am.j(this.fbh, R.color.cp_cont_d);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.fbj = bVar;
            this.fba.startLoad(bVar.avatar, 15, false);
            this.fba.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fba.setStrokeWith(3);
            this.fba.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.fbb.setText(str);
            this.fbc.setText("关注 " + aq.aO(bVar.memberCount));
            this.fbd.setText("贴子 " + aq.aO(bVar.threadCount));
            if (!aq.isEmpty(bVar.eZA)) {
                this.fbe.setText(bVar.eZA);
            } else {
                this.fbe.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            jt(bVar.bIU);
            g(bVar);
        }
    }

    public void jt(boolean z) {
        if (z) {
            this.fbf.setVisibility(8);
            this.fbh.setVisibility(0);
        } else {
            this.fbf.setVisibility(0);
            this.fbh.setVisibility(8);
        }
        this.fbj.bIU = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.bT("obj_type", String.valueOf(bVar.eZE));
            anVar.l("fid", bVar.forumId);
            anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
