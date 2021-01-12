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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private View iHN;
    private View iHO;
    private BarImageView iHP;
    private TextView iHQ;
    private TextView iHR;
    private TextView iHS;
    private TextView iHT;
    private TBSpecificationBtn iHU;
    private a iHV;
    private com.baidu.tieba.enterForum.recommend.b.b iHW;

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
        this.iHN = rootView.findViewById(R.id.view_top);
        this.iHO = rootView.findViewById(R.id.view_bottom);
        this.iHP = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.iHQ = (TextView) rootView.findViewById(R.id.forum_name);
        this.iHR = (TextView) rootView.findViewById(R.id.forum_attention);
        this.iHS = (TextView) rootView.findViewById(R.id.forum_thread);
        this.iHT = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.iHU = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pM(R.color.CAM_X0302);
        this.iHU.setConfig(bVar);
        this.iHU.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.iHP.setPlaceHolder(1);
        this.iHP.setOnClickListener(this);
        this.iHU.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.iHV = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iHU) {
            if (this.iHW.eNy) {
                this.iHV.e(this.iHW);
                return;
            } else {
                this.iHV.d(this.iHW);
                return;
            }
        }
        this.iHV.e(this.iHW);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.iHQ, R.color.CAM_X0105);
        ao.setViewTextColor(this.iHR, R.color.CAM_X0109);
        ao.setViewTextColor(this.iHS, R.color.CAM_X0109);
        ao.setViewTextColor(this.iHT, R.color.CAM_X0107);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.iHW = bVar;
            this.iHP.startLoad(bVar.avatar, 15, false);
            this.iHP.setStrokeColorResId(R.color.CAM_X0201);
            this.iHP.setStrokeWith(3);
            this.iHP.setShowOval(true);
            String str = bVar.forumName;
            if (at.isEmpty(str)) {
                str = "";
            }
            this.iHQ.setText(str);
            this.iHR.setText("关注 " + at.numFormatOverWan(bVar.memberCount));
            this.iHS.setText("贴子 " + at.numFormatOverWan(bVar.threadCount));
            if (!at.isEmpty(bVar.iGo)) {
                this.iHT.setText(bVar.iGo);
            } else {
                this.iHT.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            pO(bVar.eNy);
            com.baidu.tbadk.core.util.f.a.b.btc().ag(l.getDimens(getContext(), R.dimen.tbds10)).af(l.getDimens(getContext(), R.dimen.tbds10)).oK(R.color.CAM_X0901).bz(this.iHN);
            com.baidu.tbadk.core.util.f.a.bta().pb(R.color.CAM_X0901).oW(l.getDimens(getContext(), R.dimen.tbds10)).oX(R.color.CAM_X0804).oV(4353).oY(l.getDimens(getContext(), R.dimen.tbds10)).oZ(0).pa(l.getDimens(getContext(), R.dimen.tbds5)).bz(this.iHO);
            g(bVar);
        }
    }

    public void pO(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pO(R.color.CAM_X0109);
            this.iHU.setConfig(bVar);
            this.iHU.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.iHU.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pM(R.color.CAM_X0302);
            this.iHU.setConfig(bVar2);
            this.iHU.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.iHU.setClickState(true);
        }
        this.iHW.eNy = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            aq aqVar = new aq("c13374");
            aqVar.dW("obj_type", String.valueOf(bVar.iGs));
            aqVar.w("fid", bVar.forumId);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }
}
