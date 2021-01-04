package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.view.ImageOverlayView;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes2.dex */
public class c implements a, b {
    private TextView dXi;
    private ab jFB;
    private TextView jFE;
    private TextView jFF;
    private TbClipImageView jFG;
    private ImageOverlayView jFH;
    private FrsViewData jFx;
    private ImageView jvY;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(c.this.mRootView.getResources().getString(R.string.hot_user_rank), c.this.jFB.imageUrl) || c.this.jFx == null || c.this.jFx.getForum() == null || TextUtils.isEmpty(c.this.jFx.getForum().getId())) {
                if (c.this.jFB != null && c.this.jFB.nqy != null) {
                    TiebaStatic.log(new aq("c13274").w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("fid", c.this.jFB.forumId).dX("obj_source", "frs_card").dX("obj_id", c.this.jFB.nqy.id).dX("obj_name", c.this.jFB.nqy.name).an("obj_param1", c.this.jFB.nqy.eGU.intValue()));
                }
                d.a(view.getContext(), c.this.jFB);
                d.c(c.this.jFB);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(c.this.jFx.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            aq aqVar = new aq("c13666");
            aqVar.dX("fid", c.this.jFx.getForum().getId());
            TiebaStatic.log(aqVar);
        }
    };
    private View mRootView;

    public c(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.dXi = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.jFE = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.jFF = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.jFG = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.jFG.setDrawerType(1);
        this.jFG.setIsRound(true);
        this.jFG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        this.jFH = (ImageOverlayView) this.mRootView.findViewById(R.id.image_group);
        this.jFH.k(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.jFH.setStrokeStyle(1);
        this.jFH.setLoadImageType(12);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.jvY = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (aaVar != null && !x.isEmpty(aaVar.dataList)) {
            this.jFx = frsViewData;
            ab abVar = aaVar.dataList.get(0);
            if (abVar != null) {
                this.jFB = abVar;
                if (!TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), this.jFB.imageUrl)) {
                    this.jFE.setText(this.mRootView.getContext().getString(R.string.forum_exclusive));
                } else {
                    this.jFE.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
                    this.dXi.setText(this.mRootView.getContext().getString(R.string.hot_person));
                }
                this.jFF.setText(at.ao(abVar.name, 20));
                if (TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), abVar.imageUrl)) {
                    this.jFH.setVisibility(0);
                    this.jFG.setVisibility(8);
                    g(frsViewData);
                } else {
                    this.jFG.startLoad(abVar.imageUrl, 10, false);
                    this.jFG.setVisibility(0);
                    this.jFH.setVisibility(8);
                }
                d.b(abVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.jFE, R.color.CAM_X0105);
        ao.setViewTextColor(this.jFF, R.color.CAM_X0105);
        ao.setViewTextColor(this.dXi, R.color.CAM_X0101);
        WebPManager.a(this.jvY, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jFH.onChangeSkinType();
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        com.baidu.tbadk.core.util.f.a.bwU().qq(0).qx(l.getDimens(getView().getContext(), R.dimen.tbds10)).qs(i).bz(this.dXi);
    }

    private boolean g(FrsViewData frsViewData) {
        if (frsViewData.getHotUserRankData() == null || frsViewData.getHotUserRankData().hot_user == null || frsViewData.getHotUserRankData().hot_user.size() <= 0) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (ShortUserInfo shortUserInfo : frsViewData.getHotUserRankData().hot_user) {
            if (shortUserInfo != null) {
                arrayList.add(shortUserInfo.portrait);
            }
        }
        this.jFH.setData(arrayList);
        return false;
    }
}
