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
    private LinearLayout hAd;
    private View hAe;
    private View hAf;
    private BarImageView hAg;
    private TextView hAh;
    private TextView hAi;
    private TextView hAj;
    private TextView hAk;
    private TBSpecificationBtn hAl;
    private a hAm;
    private com.baidu.tieba.enterForum.recommend.b.b hAn;

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
        this.hAd = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.hAe = rootView.findViewById(R.id.view_top);
        this.hAf = rootView.findViewById(R.id.view_bottom);
        this.hAg = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.hAh = (TextView) rootView.findViewById(R.id.forum_name);
        this.hAi = (TextView) rootView.findViewById(R.id.forum_attention);
        this.hAj = (TextView) rootView.findViewById(R.id.forum_thread);
        this.hAk = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.hAl = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pb(R.color.cp_link_tip_a);
        this.hAl.setConfig(bVar);
        this.hAl.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.hAg.setPlaceHolder(2);
        this.hAg.setOnClickListener(this);
        this.hAl.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.hAm = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hAl) {
            if (this.hAn.eaw) {
                this.hAm.e(this.hAn);
                return;
            } else {
                this.hAm.d(this.hAn);
                return;
            }
        }
        this.hAm.e(this.hAn);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hAh, R.color.cp_cont_b);
        ap.setViewTextColor(this.hAi, R.color.cp_cont_d);
        ap.setViewTextColor(this.hAj, R.color.cp_cont_d);
        ap.setViewTextColor(this.hAk, R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.hAn = bVar;
            this.hAg.startLoad(bVar.avatar, 15, false);
            this.hAg.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hAg.setStrokeWith(3);
            this.hAg.setShowOval(true);
            String str = bVar.forumName;
            if (at.isEmpty(str)) {
                str = "";
            }
            this.hAh.setText(str);
            this.hAi.setText("关注 " + at.numFormatOverWan(bVar.memberCount));
            this.hAj.setText("贴子 " + at.numFormatOverWan(bVar.threadCount));
            if (!at.isEmpty(bVar.hyE)) {
                this.hAk.setText(bVar.hyE);
            } else {
                this.hAk.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            nK(bVar.eaw);
            com.baidu.tbadk.core.util.e.a.b.bjR().X(l.getDimens(getContext(), R.dimen.tbds10)).W(l.getDimens(getContext(), R.dimen.tbds10)).of(R.color.cp_btn_a).aZ(this.hAe);
            com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_btn_a).op(l.getDimens(getContext(), R.dimen.tbds10)).oq(R.color.cp_shadow_a_alpha16).oo(4353).or(l.getDimens(getContext(), R.dimen.tbds10)).os(0).ot(l.getDimens(getContext(), R.dimen.tbds5)).aZ(this.hAf);
            g(bVar);
        }
    }

    public void nK(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pd(R.color.cp_cont_d);
            this.hAl.setConfig(bVar);
            this.hAl.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.hAl.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pb(R.color.cp_link_tip_a);
            this.hAl.setConfig(bVar2);
            this.hAl.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.hAl.setClickState(true);
        }
        this.hAn.eaw = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            aq aqVar = new aq("c13374");
            aqVar.dD("obj_type", String.valueOf(bVar.hyI));
            aqVar.u("fid", bVar.forumId);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }
}
