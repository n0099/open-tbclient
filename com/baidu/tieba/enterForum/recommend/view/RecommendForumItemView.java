package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private BarImageView hAa;
    private TextView hAb;
    private TextView hAc;
    private TextView hAd;
    private TextView hAe;
    private TBSpecificationBtn hAf;
    private a hAg;
    private com.baidu.tieba.enterForum.recommend.b.b hAh;
    private LinearLayout hzX;
    private View hzY;
    private View hzZ;

    /* loaded from: classes16.dex */
    public interface a {
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
        this.hzX = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.hzY = rootView.findViewById(R.id.view_top);
        this.hzZ = rootView.findViewById(R.id.view_bottom);
        this.hAa = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.hAb = (TextView) rootView.findViewById(R.id.forum_name);
        this.hAc = (TextView) rootView.findViewById(R.id.forum_attention);
        this.hAd = (TextView) rootView.findViewById(R.id.forum_thread);
        this.hAe = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.hAf = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pb(R.color.cp_link_tip_a);
        this.hAf.setConfig(bVar);
        this.hAf.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.hAa.setPlaceHolder(2);
        this.hAa.setOnClickListener(this);
        this.hAf.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.hAg = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hAf) {
            if (this.hAh.eas) {
                this.hAg.e(this.hAh);
                return;
            } else {
                this.hAg.d(this.hAh);
                return;
            }
        }
        this.hAg.e(this.hAh);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hAb, R.color.cp_cont_b);
        ap.setViewTextColor(this.hAc, R.color.cp_cont_d);
        ap.setViewTextColor(this.hAd, R.color.cp_cont_d);
        ap.setViewTextColor(this.hAe, R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.hAh = bVar;
            this.hAa.startLoad(bVar.avatar, 15, false);
            this.hAa.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hAa.setStrokeWith(3);
            this.hAa.setShowOval(true);
            String str = bVar.forumName;
            if (at.isEmpty(str)) {
                str = "";
            }
            this.hAb.setText(str);
            this.hAc.setText("关注 " + at.numFormatOverWan(bVar.memberCount));
            this.hAd.setText("贴子 " + at.numFormatOverWan(bVar.threadCount));
            if (!at.isEmpty(bVar.hyy)) {
                this.hAe.setText(bVar.hyy);
            } else {
                this.hAe.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            nI(bVar.eas);
            com.baidu.tbadk.core.util.e.a.b.bjR().X(l.getDimens(getContext(), R.dimen.tbds10)).W(l.getDimens(getContext(), R.dimen.tbds10)).of(R.color.cp_btn_a).aZ(this.hzY);
            com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_btn_a).op(l.getDimens(getContext(), R.dimen.tbds10)).oq(R.color.cp_shadow_a_alpha16).oo(4353).or(l.getDimens(getContext(), R.dimen.tbds10)).os(0).ot(l.getDimens(getContext(), R.dimen.tbds5)).aZ(this.hzZ);
            g(bVar);
        }
    }

    public void nI(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pd(R.color.cp_cont_d);
            this.hAf.setConfig(bVar);
            this.hAf.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.hAf.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pb(R.color.cp_link_tip_a);
            this.hAf.setConfig(bVar2);
            this.hAf.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.hAf.setClickState(true);
        }
        this.hAh.eas = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            aq aqVar = new aq("c13374");
            aqVar.dD("obj_type", String.valueOf(bVar.hyC));
            aqVar.u("fid", bVar.forumId);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }
}
