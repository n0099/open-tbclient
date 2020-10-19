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
/* loaded from: classes22.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout hWa;
    private View hWb;
    private View hWc;
    private BarImageView hWd;
    private TextView hWe;
    private TextView hWf;
    private TextView hWg;
    private TextView hWh;
    private TBSpecificationBtn hWi;
    private a hWj;
    private com.baidu.tieba.enterForum.recommend.b.b hWk;

    /* loaded from: classes22.dex */
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
        this.hWa = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.hWb = rootView.findViewById(R.id.view_top);
        this.hWc = rootView.findViewById(R.id.view_bottom);
        this.hWd = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.hWe = (TextView) rootView.findViewById(R.id.forum_name);
        this.hWf = (TextView) rootView.findViewById(R.id.forum_attention);
        this.hWg = (TextView) rootView.findViewById(R.id.forum_thread);
        this.hWh = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.hWi = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pN(R.color.cp_link_tip_a);
        this.hWi.setConfig(bVar);
        this.hWi.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.hWd.setPlaceHolder(2);
        this.hWd.setOnClickListener(this);
        this.hWi.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.hWj = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hWi) {
            if (this.hWk.eoL) {
                this.hWj.e(this.hWk);
                return;
            } else {
                this.hWj.d(this.hWk);
                return;
            }
        }
        this.hWj.e(this.hWk);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hWe, R.color.cp_cont_b);
        ap.setViewTextColor(this.hWf, R.color.cp_cont_d);
        ap.setViewTextColor(this.hWg, R.color.cp_cont_d);
        ap.setViewTextColor(this.hWh, R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.hWk = bVar;
            this.hWd.startLoad(bVar.avatar, 15, false);
            this.hWd.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hWd.setStrokeWith(3);
            this.hWd.setShowOval(true);
            String str = bVar.forumName;
            if (at.isEmpty(str)) {
                str = "";
            }
            this.hWe.setText(str);
            this.hWf.setText("关注 " + at.numFormatOverWan(bVar.memberCount));
            this.hWg.setText("贴子 " + at.numFormatOverWan(bVar.threadCount));
            if (!at.isEmpty(bVar.hUB)) {
                this.hWh.setText(bVar.hUB);
            } else {
                this.hWh.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            ov(bVar.eoL);
            com.baidu.tbadk.core.util.e.a.b.bnw().Z(l.getDimens(getContext(), R.dimen.tbds10)).Y(l.getDimens(getContext(), R.dimen.tbds10)).oP(R.color.cp_btn_a).bf(this.hWb);
            com.baidu.tbadk.core.util.e.a.bnu().pe(R.color.cp_btn_a).oZ(l.getDimens(getContext(), R.dimen.tbds10)).pa(R.color.cp_shadow_a_alpha16).oY(4353).pb(l.getDimens(getContext(), R.dimen.tbds10)).pc(0).pd(l.getDimens(getContext(), R.dimen.tbds5)).bf(this.hWc);
            g(bVar);
        }
    }

    public void ov(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pP(R.color.cp_cont_d);
            this.hWi.setConfig(bVar);
            this.hWi.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.hWi.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pN(R.color.cp_link_tip_a);
            this.hWi.setConfig(bVar2);
            this.hWi.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.hWi.setClickState(true);
        }
        this.hWk.eoL = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            aq aqVar = new aq("c13374");
            aqVar.dK("obj_type", String.valueOf(bVar.hUF));
            aqVar.u("fid", bVar.forumId);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }
}
