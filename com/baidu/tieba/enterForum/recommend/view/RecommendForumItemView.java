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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private a iPA;
    private com.baidu.tieba.enterForum.recommend.b.b iPB;
    private View iPs;
    private View iPt;
    private BarImageView iPu;
    private TextView iPv;
    private TextView iPw;
    private TextView iPx;
    private TextView iPy;
    private TBSpecificationBtn iPz;

    /* loaded from: classes2.dex */
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
        this.iPs = rootView.findViewById(R.id.view_top);
        this.iPt = rootView.findViewById(R.id.view_bottom);
        this.iPu = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.iPv = (TextView) rootView.findViewById(R.id.forum_name);
        this.iPw = (TextView) rootView.findViewById(R.id.forum_attention);
        this.iPx = (TextView) rootView.findViewById(R.id.forum_thread);
        this.iPy = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.iPz = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pS(R.color.CAM_X0302);
        this.iPz.setConfig(bVar);
        this.iPz.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.iPu.setPlaceHolder(1);
        this.iPu.setOnClickListener(this);
        this.iPz.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.iPA = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iPz) {
            if (this.iPB.eRl) {
                this.iPA.e(this.iPB);
                return;
            } else {
                this.iPA.d(this.iPB);
                return;
            }
        }
        this.iPA.e(this.iPB);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iPv, R.color.CAM_X0105);
        ap.setViewTextColor(this.iPw, R.color.CAM_X0109);
        ap.setViewTextColor(this.iPx, R.color.CAM_X0109);
        ap.setViewTextColor(this.iPy, R.color.CAM_X0107);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.iPB = bVar;
            this.iPu.startLoad(bVar.avatar, 15, false);
            this.iPu.setStrokeColorResId(R.color.CAM_X0201);
            this.iPu.setStrokeWith(3);
            this.iPu.setShowOval(true);
            String str = bVar.forumName;
            if (au.isEmpty(str)) {
                str = "";
            }
            this.iPv.setText(str);
            this.iPw.setText("关注 " + au.numFormatOverWan(bVar.memberCount));
            this.iPx.setText("贴子 " + au.numFormatOverWan(bVar.threadCount));
            if (!au.isEmpty(bVar.iNU)) {
                this.iPy.setText(bVar.iNU);
            } else {
                this.iPy.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            pY(bVar.eRl);
            com.baidu.tbadk.core.util.f.a.b.btz().al(l.getDimens(getContext(), R.dimen.tbds10)).ak(l.getDimens(getContext(), R.dimen.tbds10)).oQ(R.color.CAM_X0901).bv(this.iPs);
            com.baidu.tbadk.core.util.f.a.btx().ph(R.color.CAM_X0901).pc(l.getDimens(getContext(), R.dimen.tbds10)).pd(R.color.CAM_X0804).pb(4353).pe(l.getDimens(getContext(), R.dimen.tbds10)).pf(0).pg(l.getDimens(getContext(), R.dimen.tbds5)).bv(this.iPt);
            g(bVar);
        }
    }

    public void pY(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pU(R.color.CAM_X0109);
            this.iPz.setConfig(bVar);
            this.iPz.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.iPz.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pS(R.color.CAM_X0302);
            this.iPz.setConfig(bVar2);
            this.iPz.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.iPz.setClickState(true);
        }
        this.iPB.eRl = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            ar arVar = new ar("c13374");
            arVar.dR("obj_type", String.valueOf(bVar.iNY));
            arVar.v("fid", bVar.forumId);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }
}
