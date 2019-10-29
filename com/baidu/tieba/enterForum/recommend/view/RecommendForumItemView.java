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
    private com.baidu.tieba.enterForum.recommend.b.b ffA;
    private LinearLayout ffq;
    private BarImageView ffr;
    private TextView ffs;
    private TextView fft;
    private TextView ffu;
    private TextView ffv;
    private View ffw;
    private TextView ffx;
    private TextView ffy;
    private a ffz;

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
        this.ffq = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.ffr = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.ffs = (TextView) rootView.findViewById(R.id.forum_name);
        this.fft = (TextView) rootView.findViewById(R.id.forum_attention);
        this.ffu = (TextView) rootView.findViewById(R.id.forum_thread);
        this.ffv = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.ffw = rootView.findViewById(R.id.forum_like_container);
        this.ffx = (TextView) rootView.findViewById(R.id.forum_like);
        this.ffy = (TextView) rootView.findViewById(R.id.forum_already_like);
        this.ffy.setVisibility(8);
        this.ffr.setOnClickListener(this);
        this.ffw.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.ffz = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ffw) {
            if (!this.ffA.caZ) {
                this.ffz.d(this.ffA);
                return;
            }
            return;
        }
        this.ffz.e(this.ffA);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.ffs, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fft, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ffu, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ffv, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.ffx, R.drawable.recommend_like_btn_selector, 1);
        am.setBackgroundResource(this.ffw, R.drawable.recommend_like_bg);
        am.setBackgroundResource(this.ffq, R.drawable.recommend_forum_item_bg);
        am.setViewTextColor(this.ffy, (int) R.color.cp_cont_d);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.ffA = bVar;
            this.ffr.startLoad(bVar.avatar, 15, false);
            this.ffr.setStrokeColorResId(R.color.cp_bg_line_d);
            this.ffr.setStrokeWith(3);
            this.ffr.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.ffs.setText(str);
            this.fft.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.ffu.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.fdR)) {
                this.ffv.setText(bVar.fdR);
            } else {
                this.ffv.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            jl(bVar.caZ);
            g(bVar);
        }
    }

    public void jl(boolean z) {
        if (z) {
            this.ffw.setVisibility(8);
            this.ffy.setVisibility(0);
        } else {
            this.ffw.setVisibility(0);
            this.ffy.setVisibility(8);
        }
        this.ffA.caZ = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.bS("obj_type", String.valueOf(bVar.fdV));
            anVar.p("fid", bVar.forumId);
            anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
