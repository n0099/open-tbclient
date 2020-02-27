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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout fYm;
    private View fYn;
    private View fYo;
    private BarImageView fYp;
    private TextView fYq;
    private TextView fYr;
    private TextView fYs;
    private TextView fYt;
    private TBSpecificationBtn fYu;
    private a fYv;
    private com.baidu.tieba.enterForum.recommend.b.b fYw;

    /* loaded from: classes9.dex */
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
        this.fYm = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.fYn = rootView.findViewById(R.id.view_top);
        this.fYo = rootView.findViewById(R.id.view_bottom);
        this.fYp = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.fYq = (TextView) rootView.findViewById(R.id.forum_name);
        this.fYr = (TextView) rootView.findViewById(R.id.forum_attention);
        this.fYs = (TextView) rootView.findViewById(R.id.forum_thread);
        this.fYt = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.fYu = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.ls(R.color.cp_link_tip_a);
        this.fYu.setConfig(cVar);
        this.fYu.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.fYp.setPlaceHolder(2);
        this.fYp.setOnClickListener(this);
        this.fYu.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.fYv = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fYu) {
            if (this.fYw.cQM) {
                this.fYv.e(this.fYw);
                return;
            } else {
                this.fYv.d(this.fYw);
                return;
            }
        }
        this.fYv.e(this.fYw);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fYq, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fYr, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fYs, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fYt, (int) R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.fYw = bVar;
            this.fYp.startLoad(bVar.avatar, 15, false);
            this.fYp.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fYp.setStrokeWith(3);
            this.fYp.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.fYq.setText(str);
            this.fYr.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.fYs.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.fWO)) {
                this.fYt.setText(bVar.fWO);
            } else {
                this.fYt.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            kL(bVar.cQM);
            com.baidu.tbadk.core.util.f.a.b.aGZ().ah(l.getDimens(getContext(), R.dimen.tbds10)).ag(l.getDimens(getContext(), R.dimen.tbds10)).kC(R.color.cp_btn_a).aQ(this.fYn);
            com.baidu.tbadk.core.util.f.a.aGX().kR(R.color.cp_btn_a).kM(l.getDimens(getContext(), R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kL(4353).kO(l.getDimens(getContext(), R.dimen.tbds10)).kP(0).kQ(l.getDimens(getContext(), R.dimen.tbds5)).aQ(this.fYo);
            g(bVar);
        }
    }

    public void kL(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.lu(R.color.cp_cont_d);
            this.fYu.setConfig(cVar);
            this.fYu.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.fYu.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.ls(R.color.cp_link_tip_a);
            this.fYu.setConfig(cVar2);
            this.fYu.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.fYu.setClickState(true);
        }
        this.fYw.cQM = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.cy("obj_type", String.valueOf(bVar.fWS));
            anVar.s("fid", bVar.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
