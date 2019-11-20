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
    private BarImageView feA;
    private TextView feB;
    private TextView feC;
    private TextView feD;
    private TextView feE;
    private View feF;
    private TextView feG;
    private TextView feH;
    private a feI;
    private com.baidu.tieba.enterForum.recommend.b.b feJ;
    private LinearLayout fez;

    /* loaded from: classes4.dex */
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
        this.fez = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.feA = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.feB = (TextView) rootView.findViewById(R.id.forum_name);
        this.feC = (TextView) rootView.findViewById(R.id.forum_attention);
        this.feD = (TextView) rootView.findViewById(R.id.forum_thread);
        this.feE = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.feF = rootView.findViewById(R.id.forum_like_container);
        this.feG = (TextView) rootView.findViewById(R.id.forum_like);
        this.feH = (TextView) rootView.findViewById(R.id.forum_already_like);
        this.feH.setVisibility(8);
        this.feA.setOnClickListener(this);
        this.feF.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.feI = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.feF) {
            if (!this.feJ.cai) {
                this.feI.d(this.feJ);
                return;
            }
            return;
        }
        this.feI.e(this.feJ);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.feB, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.feC, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.feD, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.feE, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.feG, R.drawable.recommend_like_btn_selector, 1);
        am.setBackgroundResource(this.feF, R.drawable.recommend_like_bg);
        am.setBackgroundResource(this.fez, R.drawable.recommend_forum_item_bg);
        am.setViewTextColor(this.feH, (int) R.color.cp_cont_d);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.feJ = bVar;
            this.feA.startLoad(bVar.avatar, 15, false);
            this.feA.setStrokeColorResId(R.color.cp_bg_line_d);
            this.feA.setStrokeWith(3);
            this.feA.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.feB.setText(str);
            this.feC.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.feD.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.fda)) {
                this.feE.setText(bVar.fda);
            } else {
                this.feE.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            jl(bVar.cai);
            g(bVar);
        }
    }

    public void jl(boolean z) {
        if (z) {
            this.feF.setVisibility(8);
            this.feH.setVisibility(0);
        } else {
            this.feF.setVisibility(0);
            this.feH.setVisibility(8);
        }
        this.feJ.cai = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.bS("obj_type", String.valueOf(bVar.fde));
            anVar.p("fid", bVar.forumId);
            anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
