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
    private TextView jGC;
    private TextView jGD;
    private TbClipImageView jGE;
    private ImageOverlayView jGF;
    private FrsViewData jGv;
    private ab jGz;
    private ImageView jwY;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(c.this.mRootView.getResources().getString(R.string.hot_user_rank), c.this.jGz.imageUrl) || c.this.jGv == null || c.this.jGv.getForum() == null || TextUtils.isEmpty(c.this.jGv.getForum().getId())) {
                if (c.this.jGz != null && c.this.jGz.nvA != null) {
                    TiebaStatic.log(new ar("c13274").v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", c.this.jGz.forumId).dR("obj_source", "frs_card").dR("obj_id", c.this.jGz.nvA.id).dR("obj_name", c.this.jGz.nvA.name).ap("obj_param1", c.this.jGz.nvA.eEp.intValue()));
                }
                d.a(view.getContext(), c.this.jGz);
                d.c(c.this.jGz);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(c.this.jGv.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            ar arVar = new ar("c13666");
            arVar.dR("fid", c.this.jGv.getForum().getId());
            TiebaStatic.log(arVar);
        }
    };
    private View mRootView;

    public c(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.dUC = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.jGC = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.jGD = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.jGE = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.jGE.setDrawerType(1);
        this.jGE.setIsRound(true);
        this.jGE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        this.jGF = (ImageOverlayView) this.mRootView.findViewById(R.id.image_group);
        this.jGF.l(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.jGF.setStrokeStyle(1);
        this.jGF.setLoadImageType(12);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.jwY = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (aaVar != null && !y.isEmpty(aaVar.dataList)) {
            this.jGv = frsViewData;
            ab abVar = aaVar.dataList.get(0);
            if (abVar != null) {
                this.jGz = abVar;
                if (!TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), this.jGz.imageUrl)) {
                    this.jGC.setText(this.mRootView.getContext().getString(R.string.forum_exclusive));
                } else {
                    this.jGC.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
                    this.dUC.setText(this.mRootView.getContext().getString(R.string.hot_person));
                }
                this.jGD.setText(au.aq(abVar.name, 20));
                if (TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), abVar.imageUrl)) {
                    this.jGF.setVisibility(0);
                    this.jGE.setVisibility(8);
                    g(frsViewData);
                } else {
                    this.jGE.startLoad(abVar.imageUrl, 10, false);
                    this.jGE.setVisibility(0);
                    this.jGF.setVisibility(8);
                }
                d.b(abVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.jGC, R.color.CAM_X0105);
        ap.setViewTextColor(this.jGD, R.color.CAM_X0105);
        ap.setViewTextColor(this.dUC, R.color.CAM_X0101);
        WebPManager.a(this.jwY, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jGF.onChangeSkinType();
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
        this.jGF.setData(arrayList);
        return false;
    }
}
