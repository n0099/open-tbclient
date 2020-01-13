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
/* loaded from: classes7.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout fWl;
    private View fWm;
    private View fWn;
    private BarImageView fWo;
    private TextView fWp;
    private TextView fWq;
    private TextView fWr;
    private TextView fWs;
    private TBSpecificationBtn fWt;
    private a fWu;
    private com.baidu.tieba.enterForum.recommend.b.b fWv;

    /* loaded from: classes7.dex */
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
        this.fWl = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.fWm = rootView.findViewById(R.id.view_top);
        this.fWn = rootView.findViewById(R.id.view_bottom);
        this.fWo = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.fWp = (TextView) rootView.findViewById(R.id.forum_name);
        this.fWq = (TextView) rootView.findViewById(R.id.forum_attention);
        this.fWr = (TextView) rootView.findViewById(R.id.forum_thread);
        this.fWs = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.fWt = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lb(R.color.cp_link_tip_a);
        this.fWt.setConfig(cVar);
        this.fWt.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.fWo.setPlaceHolder(2);
        this.fWo.setOnClickListener(this);
        this.fWt.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.fWu = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fWt) {
            if (this.fWv.cMJ) {
                this.fWu.e(this.fWv);
                return;
            } else {
                this.fWu.d(this.fWv);
                return;
            }
        }
        this.fWu.e(this.fWv);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fWp, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fWq, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fWr, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fWs, (int) R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.fWv = bVar;
            this.fWo.startLoad(bVar.avatar, 15, false);
            this.fWo.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fWo.setStrokeWith(3);
            this.fWo.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.fWp.setText(str);
            this.fWq.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.fWr.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.fUN)) {
                this.fWs.setText(bVar.fUN);
            } else {
                this.fWs.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            kI(bVar.cMJ);
            com.baidu.tbadk.core.util.f.a.b.aEN().ai(l.getDimens(getContext(), R.dimen.tbds10)).ah(l.getDimens(getContext(), R.dimen.tbds10)).kl(R.color.cp_btn_a).aQ(this.fWm);
            com.baidu.tbadk.core.util.f.a.aEL().kA(R.color.cp_btn_a).kv(l.getDimens(getContext(), R.dimen.tbds10)).kw(R.color.cp_shadow_a_alpha16).ku(4353).kx(l.getDimens(getContext(), R.dimen.tbds10)).ky(0).kz(l.getDimens(getContext(), R.dimen.tbds5)).aQ(this.fWn);
            g(bVar);
        }
    }

    public void kI(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.ld(R.color.cp_cont_d);
            this.fWt.setConfig(cVar);
            this.fWt.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.fWt.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.lb(R.color.cp_link_tip_a);
            this.fWt.setConfig(cVar2);
            this.fWt.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.fWt.setClickState(true);
        }
        this.fWv.cMJ = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.cp("obj_type", String.valueOf(bVar.fUR));
            anVar.s("fid", bVar.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
