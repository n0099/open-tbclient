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
    private TextView iNA;
    private TextView iNB;
    private TBSpecificationBtn iNC;
    private a iND;
    private com.baidu.tieba.enterForum.recommend.b.b iNE;
    private View iNv;
    private View iNw;
    private BarImageView iNx;
    private TextView iNy;
    private TextView iNz;

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
        this.iNv = rootView.findViewById(R.id.view_top);
        this.iNw = rootView.findViewById(R.id.view_bottom);
        this.iNx = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.iNy = (TextView) rootView.findViewById(R.id.forum_name);
        this.iNz = (TextView) rootView.findViewById(R.id.forum_attention);
        this.iNA = (TextView) rootView.findViewById(R.id.forum_thread);
        this.iNB = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.iNC = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pR(R.color.CAM_X0302);
        this.iNC.setConfig(bVar);
        this.iNC.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.iNx.setPlaceHolder(1);
        this.iNx.setOnClickListener(this);
        this.iNC.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.iND = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iNC) {
            if (this.iNE.ePK) {
                this.iND.e(this.iNE);
                return;
            } else {
                this.iND.d(this.iNE);
                return;
            }
        }
        this.iND.e(this.iNE);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iNy, R.color.CAM_X0105);
        ap.setViewTextColor(this.iNz, R.color.CAM_X0109);
        ap.setViewTextColor(this.iNA, R.color.CAM_X0109);
        ap.setViewTextColor(this.iNB, R.color.CAM_X0107);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.iNE = bVar;
            this.iNx.startLoad(bVar.avatar, 15, false);
            this.iNx.setStrokeColorResId(R.color.CAM_X0201);
            this.iNx.setStrokeWith(3);
            this.iNx.setShowOval(true);
            String str = bVar.forumName;
            if (au.isEmpty(str)) {
                str = "";
            }
            this.iNy.setText(str);
            this.iNz.setText("关注 " + au.numFormatOverWan(bVar.memberCount));
            this.iNA.setText("贴子 " + au.numFormatOverWan(bVar.threadCount));
            if (!au.isEmpty(bVar.iLX)) {
                this.iNB.setText(bVar.iLX);
            } else {
                this.iNB.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            pY(bVar.ePK);
            com.baidu.tbadk.core.util.f.a.b.btw().ah(l.getDimens(getContext(), R.dimen.tbds10)).ag(l.getDimens(getContext(), R.dimen.tbds10)).oP(R.color.CAM_X0901).bv(this.iNv);
            com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0901).pb(l.getDimens(getContext(), R.dimen.tbds10)).pc(R.color.CAM_X0804).pa(4353).pd(l.getDimens(getContext(), R.dimen.tbds10)).pe(0).pf(l.getDimens(getContext(), R.dimen.tbds5)).bv(this.iNw);
            g(bVar);
        }
    }

    public void pY(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pT(R.color.CAM_X0109);
            this.iNC.setConfig(bVar);
            this.iNC.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.iNC.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pR(R.color.CAM_X0302);
            this.iNC.setConfig(bVar2);
            this.iNC.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.iNC.setClickState(true);
        }
        this.iNE.ePK = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            ar arVar = new ar("c13374");
            arVar.dR("obj_type", String.valueOf(bVar.iMb));
            arVar.v("fid", bVar.forumId);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }
}
