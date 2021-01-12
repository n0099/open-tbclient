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
    private TextView dSw;
    private FrsViewData jAR;
    private ab jAV;
    private TextView jAY;
    private TextView jAZ;
    private TbClipImageView jBa;
    private ImageOverlayView jBb;
    private ImageView jrs;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(c.this.mRootView.getResources().getString(R.string.hot_user_rank), c.this.jAV.imageUrl) || c.this.jAR == null || c.this.jAR.getForum() == null || TextUtils.isEmpty(c.this.jAR.getForum().getId())) {
                if (c.this.jAV != null && c.this.jAV.nlQ != null) {
                    TiebaStatic.log(new aq("c13274").w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("fid", c.this.jAV.forumId).dW("obj_source", "frs_card").dW("obj_id", c.this.jAV.nlQ.id).dW("obj_name", c.this.jAV.nlQ.name).an("obj_param1", c.this.jAV.nlQ.eCi.intValue()));
                }
                d.a(view.getContext(), c.this.jAV);
                d.c(c.this.jAV);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(c.this.jAR.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            aq aqVar = new aq("c13666");
            aqVar.dW("fid", c.this.jAR.getForum().getId());
            TiebaStatic.log(aqVar);
        }
    };
    private View mRootView;

    public c(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.dSw = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.jAY = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.jAZ = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.jBa = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.jBa.setDrawerType(1);
        this.jBa.setIsRound(true);
        this.jBa.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        this.jBb = (ImageOverlayView) this.mRootView.findViewById(R.id.image_group);
        this.jBb.l(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.jBb.setStrokeStyle(1);
        this.jBb.setLoadImageType(12);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.jrs = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (aaVar != null && !x.isEmpty(aaVar.dataList)) {
            this.jAR = frsViewData;
            ab abVar = aaVar.dataList.get(0);
            if (abVar != null) {
                this.jAV = abVar;
                if (!TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), this.jAV.imageUrl)) {
                    this.jAY.setText(this.mRootView.getContext().getString(R.string.forum_exclusive));
                } else {
                    this.jAY.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
                    this.dSw.setText(this.mRootView.getContext().getString(R.string.hot_person));
                }
                this.jAZ.setText(at.ao(abVar.name, 20));
                if (TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), abVar.imageUrl)) {
                    this.jBb.setVisibility(0);
                    this.jBa.setVisibility(8);
                    g(frsViewData);
                } else {
                    this.jBa.startLoad(abVar.imageUrl, 10, false);
                    this.jBa.setVisibility(0);
                    this.jBb.setVisibility(8);
                }
                d.b(abVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.jAY, R.color.CAM_X0105);
        ao.setViewTextColor(this.jAZ, R.color.CAM_X0105);
        ao.setViewTextColor(this.dSw, R.color.CAM_X0101);
        WebPManager.a(this.jrs, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jBb.onChangeSkinType();
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        com.baidu.tbadk.core.util.f.a.btb().oJ(0).oQ(l.getDimens(getView().getContext(), R.dimen.tbds10)).oL(i).bz(this.dSw);
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
        this.jBb.setData(arrayList);
        return false;
    }
}
