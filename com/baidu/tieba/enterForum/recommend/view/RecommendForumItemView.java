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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout hng;
    private View hnh;
    private View hni;
    private BarImageView hnj;
    private TextView hnk;
    private TextView hnl;
    private TextView hnm;
    private TextView hnn;
    private TBSpecificationBtn hno;
    private a hnp;
    private com.baidu.tieba.enterForum.recommend.b.b hnq;

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
        this.hng = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.hnh = rootView.findViewById(R.id.view_top);
        this.hni = rootView.findViewById(R.id.view_bottom);
        this.hnj = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.hnk = (TextView) rootView.findViewById(R.id.forum_name);
        this.hnl = (TextView) rootView.findViewById(R.id.forum_attention);
        this.hnm = (TextView) rootView.findViewById(R.id.forum_thread);
        this.hnn = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.hno = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mV(R.color.cp_link_tip_a);
        this.hno.setConfig(cVar);
        this.hno.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.hnj.setPlaceHolder(2);
        this.hnj.setOnClickListener(this);
        this.hno.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.hnp = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hno) {
            if (this.hnq.dQY) {
                this.hnp.e(this.hnq);
                return;
            } else {
                this.hnp.d(this.hnq);
                return;
            }
        }
        this.hnp.e(this.hnq);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.hnk, R.color.cp_cont_b);
        ao.setViewTextColor(this.hnl, R.color.cp_cont_d);
        ao.setViewTextColor(this.hnm, R.color.cp_cont_d);
        ao.setViewTextColor(this.hnn, R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.hnq = bVar;
            this.hnj.startLoad(bVar.avatar, 15, false);
            this.hnj.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hnj.setStrokeWith(3);
            this.hnj.setShowOval(true);
            String str = bVar.forumName;
            if (as.isEmpty(str)) {
                str = "";
            }
            this.hnk.setText(str);
            this.hnl.setText("关注 " + as.numFormatOverWan(bVar.memberCount));
            this.hnm.setText("贴子 " + as.numFormatOverWan(bVar.threadCount));
            if (!as.isEmpty(bVar.hlH)) {
                this.hnn.setText(bVar.hlH);
            } else {
                this.hnn.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            ne(bVar.dQY);
            com.baidu.tbadk.core.util.e.a.c.bbv().S(l.getDimens(getContext(), R.dimen.tbds10)).R(l.getDimens(getContext(), R.dimen.tbds10)).mb(R.color.cp_btn_a).aX(this.hnh);
            com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_btn_a).ml(l.getDimens(getContext(), R.dimen.tbds10)).mm(R.color.cp_shadow_a_alpha16).mk(4353).mn(l.getDimens(getContext(), R.dimen.tbds10)).mo(0).mp(l.getDimens(getContext(), R.dimen.tbds5)).aX(this.hni);
            g(bVar);
        }
    }

    public void ne(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mX(R.color.cp_cont_d);
            this.hno.setConfig(cVar);
            this.hno.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.hno.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mV(R.color.cp_link_tip_a);
            this.hno.setConfig(cVar2);
            this.hno.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.hno.setClickState(true);
        }
        this.hnq.dQY = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            ap apVar = new ap("c13374");
            apVar.dn("obj_type", String.valueOf(bVar.hlL));
            apVar.t("fid", bVar.forumId);
            apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(apVar);
        }
    }
}
