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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
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
    private TextView dUC;
    private FrsViewData jGJ;
    private ab jGN;
    private TextView jGQ;
    private TextView jGR;
    private TbClipImageView jGS;
    private ImageOverlayView jGT;
    private ImageView jxm;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(c.this.mRootView.getResources().getString(R.string.hot_user_rank), c.this.jGN.imageUrl) || c.this.jGJ == null || c.this.jGJ.getForum() == null || TextUtils.isEmpty(c.this.jGJ.getForum().getId())) {
                if (c.this.jGN != null && c.this.jGN.nwa != null) {
                    TiebaStatic.log(new ar("c13274").v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", c.this.jGN.forumId).dR("obj_source", "frs_card").dR("obj_id", c.this.jGN.nwa.id).dR("obj_name", c.this.jGN.nwa.name).ap("obj_param1", c.this.jGN.nwa.eEp.intValue()));
                }
                d.a(view.getContext(), c.this.jGN);
                d.c(c.this.jGN);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(c.this.jGJ.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            ar arVar = new ar("c13666");
            arVar.dR("fid", c.this.jGJ.getForum().getId());
            TiebaStatic.log(arVar);
        }
    };
    private View mRootView;

    public c(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.dUC = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.jGQ = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.jGR = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.jGS = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.jGS.setDrawerType(1);
        this.jGS.setIsRound(true);
        this.jGS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        this.jGT = (ImageOverlayView) this.mRootView.findViewById(R.id.image_group);
        this.jGT.l(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.jGT.setStrokeStyle(1);
        this.jGT.setLoadImageType(12);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.jxm = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (aaVar != null && !y.isEmpty(aaVar.dataList)) {
            this.jGJ = frsViewData;
            ab abVar = aaVar.dataList.get(0);
            if (abVar != null) {
                this.jGN = abVar;
                if (!TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), this.jGN.imageUrl)) {
                    this.jGQ.setText(this.mRootView.getContext().getString(R.string.forum_exclusive));
                } else {
                    this.jGQ.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
                    this.dUC.setText(this.mRootView.getContext().getString(R.string.hot_person));
                }
                this.jGR.setText(au.aq(abVar.name, 20));
                if (TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), abVar.imageUrl)) {
                    this.jGT.setVisibility(0);
                    this.jGS.setVisibility(8);
                    g(frsViewData);
                } else {
                    this.jGS.startLoad(abVar.imageUrl, 10, false);
                    this.jGS.setVisibility(0);
                    this.jGT.setVisibility(8);
                }
                d.b(abVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.jGQ, R.color.CAM_X0105);
        ap.setViewTextColor(this.jGR, R.color.CAM_X0105);
        ap.setViewTextColor(this.dUC, R.color.CAM_X0101);
        WebPManager.a(this.jxm, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jGT.onChangeSkinType();
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        com.baidu.tbadk.core.util.f.a.btv().oO(0).oV(l.getDimens(getView().getContext(), R.dimen.tbds10)).oQ(i).bv(this.dUC);
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
        this.jGT.setData(arrayList);
        return false;
    }
}
