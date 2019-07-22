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
    private LinearLayout faM;
    private BarImageView faN;
    private TextView faO;
    private TextView faP;
    private TextView faQ;
    private TextView faR;
    private View faS;
    private TextView faT;
    private TextView faU;
    private a faV;
    private com.baidu.tieba.enterForum.recommend.b.b faW;

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
        this.faM = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.faN = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.faO = (TextView) rootView.findViewById(R.id.forum_name);
        this.faP = (TextView) rootView.findViewById(R.id.forum_attention);
        this.faQ = (TextView) rootView.findViewById(R.id.forum_thread);
        this.faR = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.faS = rootView.findViewById(R.id.forum_like_container);
        this.faT = (TextView) rootView.findViewById(R.id.forum_like);
        this.faU = (TextView) rootView.findViewById(R.id.forum_already_like);
        this.faU.setVisibility(8);
        this.faN.setOnClickListener(this);
        this.faS.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.faV = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.faS) {
            if (!this.faW.bIP) {
                this.faV.d(this.faW);
                return;
            }
            return;
        }
        this.faV.e(this.faW);
    }

    public void onChangeSkinType() {
        am.j(this.faO, R.color.cp_cont_b);
        am.j(this.faP, R.color.cp_cont_d);
        am.j(this.faQ, R.color.cp_cont_d);
        am.j(this.faR, R.color.cp_cont_j);
        am.f(this.faT, R.drawable.recommend_like_btn_selector, 1);
        am.k(this.faS, R.drawable.recommend_like_bg);
        am.k(this.faM, R.drawable.recommend_forum_item_bg);
        am.j(this.faU, R.color.cp_cont_d);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.faW = bVar;
            this.faN.startLoad(bVar.avatar, 15, false);
            this.faN.setStrokeColorResId(R.color.cp_bg_line_d);
            this.faN.setStrokeWith(3);
            this.faN.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.faO.setText(str);
            this.faP.setText("关注 " + aq.aO(bVar.memberCount));
            this.faQ.setText("贴子 " + aq.aO(bVar.threadCount));
            if (!aq.isEmpty(bVar.eZm)) {
                this.faR.setText(bVar.eZm);
            } else {
                this.faR.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            jt(bVar.bIP);
            g(bVar);
        }
    }

    public void jt(boolean z) {
        if (z) {
            this.faS.setVisibility(8);
            this.faU.setVisibility(0);
        } else {
            this.faS.setVisibility(0);
            this.faU.setVisibility(8);
        }
        this.faW.bIP = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.bT("obj_type", String.valueOf(bVar.eZq));
            anVar.l("fid", bVar.forumId);
            anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
