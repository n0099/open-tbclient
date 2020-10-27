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
    private LinearLayout iiA;
    private View iiB;
    private View iiC;
    private BarImageView iiD;
    private TextView iiE;
    private TextView iiF;
    private TextView iiG;
    private TextView iiH;
    private TBSpecificationBtn iiI;
    private a iiJ;
    private com.baidu.tieba.enterForum.recommend.b.b iiK;

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
        this.iiA = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.iiB = rootView.findViewById(R.id.view_top);
        this.iiC = rootView.findViewById(R.id.view_bottom);
        this.iiD = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.iiE = (TextView) rootView.findViewById(R.id.forum_name);
        this.iiF = (TextView) rootView.findViewById(R.id.forum_attention);
        this.iiG = (TextView) rootView.findViewById(R.id.forum_thread);
        this.iiH = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.iiI = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pY(R.color.cp_link_tip_a);
        this.iiI.setConfig(bVar);
        this.iiI.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.iiD.setPlaceHolder(2);
        this.iiD.setOnClickListener(this);
        this.iiI.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.iiJ = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iiI) {
            if (this.iiK.exi) {
                this.iiJ.e(this.iiK);
                return;
            } else {
                this.iiJ.d(this.iiK);
                return;
            }
        }
        this.iiJ.e(this.iiK);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iiE, R.color.cp_cont_b);
        ap.setViewTextColor(this.iiF, R.color.cp_cont_d);
        ap.setViewTextColor(this.iiG, R.color.cp_cont_d);
        ap.setViewTextColor(this.iiH, R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.iiK = bVar;
            this.iiD.startLoad(bVar.avatar, 15, false);
            this.iiD.setStrokeColorResId(R.color.cp_bg_line_d);
            this.iiD.setStrokeWith(3);
            this.iiD.setShowOval(true);
            String str = bVar.forumName;
            if (at.isEmpty(str)) {
                str = "";
            }
            this.iiE.setText(str);
            this.iiF.setText("关注 " + at.numFormatOverWan(bVar.memberCount));
            this.iiG.setText("贴子 " + at.numFormatOverWan(bVar.threadCount));
            if (!at.isEmpty(bVar.ihb)) {
                this.iiH.setText(bVar.ihb);
            } else {
                this.iiH.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            oN(bVar.exi);
            com.baidu.tbadk.core.util.e.a.b.bpp().ab(l.getDimens(getContext(), R.dimen.tbds10)).aa(l.getDimens(getContext(), R.dimen.tbds10)).pa(R.color.cp_btn_a).bg(this.iiB);
            com.baidu.tbadk.core.util.e.a.bpn().pq(R.color.cp_btn_a).pk(l.getDimens(getContext(), R.dimen.tbds10)).pl(R.color.cp_shadow_a_alpha16).pj(4353).pm(l.getDimens(getContext(), R.dimen.tbds10)).po(0).pp(l.getDimens(getContext(), R.dimen.tbds5)).bg(this.iiC);
            g(bVar);
        }
    }

    public void oN(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.qa(R.color.cp_cont_d);
            this.iiI.setConfig(bVar);
            this.iiI.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.iiI.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pY(R.color.cp_link_tip_a);
            this.iiI.setConfig(bVar2);
            this.iiI.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.iiI.setClickState(true);
        }
        this.iiK.exi = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            aq aqVar = new aq("c13374");
            aqVar.dR("obj_type", String.valueOf(bVar.ihf));
            aqVar.w("fid", bVar.forumId);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }
}
