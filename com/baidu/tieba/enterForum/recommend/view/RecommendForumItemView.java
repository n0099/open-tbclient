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
    private View iNJ;
    private View iNK;
    private BarImageView iNL;
    private TextView iNM;
    private TextView iNN;
    private TextView iNO;
    private TextView iNP;
    private TBSpecificationBtn iNQ;
    private a iNR;
    private com.baidu.tieba.enterForum.recommend.b.b iNS;

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
        this.iNJ = rootView.findViewById(R.id.view_top);
        this.iNK = rootView.findViewById(R.id.view_bottom);
        this.iNL = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.iNM = (TextView) rootView.findViewById(R.id.forum_name);
        this.iNN = (TextView) rootView.findViewById(R.id.forum_attention);
        this.iNO = (TextView) rootView.findViewById(R.id.forum_thread);
        this.iNP = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.iNQ = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pR(R.color.CAM_X0302);
        this.iNQ.setConfig(bVar);
        this.iNQ.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.iNL.setPlaceHolder(1);
        this.iNL.setOnClickListener(this);
        this.iNQ.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.iNR = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iNQ) {
            if (this.iNS.ePK) {
                this.iNR.e(this.iNS);
                return;
            } else {
                this.iNR.d(this.iNS);
                return;
            }
        }
        this.iNR.e(this.iNS);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iNM, R.color.CAM_X0105);
        ap.setViewTextColor(this.iNN, R.color.CAM_X0109);
        ap.setViewTextColor(this.iNO, R.color.CAM_X0109);
        ap.setViewTextColor(this.iNP, R.color.CAM_X0107);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.iNS = bVar;
            this.iNL.startLoad(bVar.avatar, 15, false);
            this.iNL.setStrokeColorResId(R.color.CAM_X0201);
            this.iNL.setStrokeWith(3);
            this.iNL.setShowOval(true);
            String str = bVar.forumName;
            if (au.isEmpty(str)) {
                str = "";
            }
            this.iNM.setText(str);
            this.iNN.setText("关注 " + au.numFormatOverWan(bVar.memberCount));
            this.iNO.setText("贴子 " + au.numFormatOverWan(bVar.threadCount));
            if (!au.isEmpty(bVar.iMl)) {
                this.iNP.setText(bVar.iMl);
            } else {
                this.iNP.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            pY(bVar.ePK);
            com.baidu.tbadk.core.util.f.a.b.btw().ah(l.getDimens(getContext(), R.dimen.tbds10)).ag(l.getDimens(getContext(), R.dimen.tbds10)).oP(R.color.CAM_X0901).bv(this.iNJ);
            com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0901).pb(l.getDimens(getContext(), R.dimen.tbds10)).pc(R.color.CAM_X0804).pa(4353).pd(l.getDimens(getContext(), R.dimen.tbds10)).pe(0).pf(l.getDimens(getContext(), R.dimen.tbds5)).bv(this.iNK);
            g(bVar);
        }
    }

    public void pY(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pT(R.color.CAM_X0109);
            this.iNQ.setConfig(bVar);
            this.iNQ.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.iNQ.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pR(R.color.CAM_X0302);
            this.iNQ.setConfig(bVar2);
            this.iNQ.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.iNQ.setClickState(true);
        }
        this.iNS.ePK = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            ar arVar = new ar("c13374");
            arVar.dR("obj_type", String.valueOf(bVar.iMp));
            arVar.v("fid", bVar.forumId);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }
}
