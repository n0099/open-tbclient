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
    private LinearLayout fcF;
    private BarImageView fcG;
    private TextView fcH;
    private TextView fcI;
    private TextView fcJ;
    private TextView fcK;
    private View fcL;
    private TextView fcM;
    private TextView fcN;
    private a fcO;
    private com.baidu.tieba.enterForum.recommend.b.b fcP;

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
        this.fcF = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.fcG = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.fcH = (TextView) rootView.findViewById(R.id.forum_name);
        this.fcI = (TextView) rootView.findViewById(R.id.forum_attention);
        this.fcJ = (TextView) rootView.findViewById(R.id.forum_thread);
        this.fcK = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.fcL = rootView.findViewById(R.id.forum_like_container);
        this.fcM = (TextView) rootView.findViewById(R.id.forum_like);
        this.fcN = (TextView) rootView.findViewById(R.id.forum_already_like);
        this.fcN.setVisibility(8);
        this.fcG.setOnClickListener(this);
        this.fcL.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.fcO = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fcL) {
            if (!this.fcP.bJs) {
                this.fcO.d(this.fcP);
                return;
            }
            return;
        }
        this.fcO.e(this.fcP);
    }

    public void onChangeSkinType() {
        am.j(this.fcH, R.color.cp_cont_b);
        am.j(this.fcI, R.color.cp_cont_d);
        am.j(this.fcJ, R.color.cp_cont_d);
        am.j(this.fcK, R.color.cp_cont_j);
        am.f(this.fcM, R.drawable.recommend_like_btn_selector, 1);
        am.k(this.fcL, R.drawable.recommend_like_bg);
        am.k(this.fcF, R.drawable.recommend_forum_item_bg);
        am.j(this.fcN, R.color.cp_cont_d);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.fcP = bVar;
            this.fcG.startLoad(bVar.avatar, 15, false);
            this.fcG.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fcG.setStrokeWith(3);
            this.fcG.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.fcH.setText(str);
            this.fcI.setText("关注 " + aq.aO(bVar.memberCount));
            this.fcJ.setText("贴子 " + aq.aO(bVar.threadCount));
            if (!aq.isEmpty(bVar.fbg)) {
                this.fcK.setText(bVar.fbg);
            } else {
                this.fcK.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            jw(bVar.bJs);
            g(bVar);
        }
    }

    public void jw(boolean z) {
        if (z) {
            this.fcL.setVisibility(8);
            this.fcN.setVisibility(0);
        } else {
            this.fcL.setVisibility(0);
            this.fcN.setVisibility(8);
        }
        this.fcP.bJs = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.bT("obj_type", String.valueOf(bVar.fbk));
            anVar.n("fid", bVar.forumId);
            anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
