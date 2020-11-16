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
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.view.ImageOverlayView;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes21.dex */
public class d implements a, b {
    private TextView dHr;
    private ImageView iVY;
    private aa jfB;
    private TextView jfE;
    private TextView jfF;
    private TbClipImageView jfG;
    private ImageOverlayView jfH;
    private FrsViewData jfx;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(d.this.mRootView.getResources().getString(R.string.hot_user_rank), d.this.jfB.imageUrl) || d.this.jfx == null || d.this.jfx.getForum() == null || TextUtils.isEmpty(d.this.jfx.getForum().getId())) {
                if (d.this.jfB != null && d.this.jfB.mWQ != null) {
                    TiebaStatic.log(new ar("c13274").w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", d.this.jfB.forumId).dR("obj_source", "frs_card").dR("obj_id", d.this.jfB.mWQ.id).dR("obj_name", d.this.jfB.mWQ.name).ak("obj_param1", d.this.jfB.mWQ.eqD.intValue()));
                }
                e.a(view.getContext(), d.this.jfB);
                e.c(d.this.jfB);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(d.this.jfx.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            ar arVar = new ar("c13666");
            arVar.dR("fid", d.this.jfx.getForum().getId());
            TiebaStatic.log(arVar);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.dHr = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.jfE = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.jfF = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.jfG = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.jfG.setDrawerType(1);
        this.jfG.setIsRound(true);
        this.jfG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        this.jfH = (ImageOverlayView) this.mRootView.findViewById(R.id.image_group);
        this.jfH.j(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.jfH.setStrokeStyle(1);
        this.jfH.setLoadImageType(12);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.iVY = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(z zVar, FrsViewData frsViewData) {
        if (zVar != null && !y.isEmpty(zVar.dataList)) {
            this.jfx = frsViewData;
            aa aaVar = zVar.dataList.get(0);
            if (aaVar != null) {
                this.jfB = aaVar;
                if (!TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), this.jfB.imageUrl)) {
                    this.jfE.setText(this.mRootView.getContext().getString(R.string.forum_exclusive));
                } else {
                    this.jfE.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
                    this.dHr.setText(this.mRootView.getContext().getString(R.string.hot_person));
                }
                this.jfF.setText(au.al(aaVar.name, 20));
                if (TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), aaVar.imageUrl)) {
                    this.jfH.setVisibility(0);
                    this.jfG.setVisibility(8);
                    g(frsViewData);
                } else {
                    this.jfG.startLoad(aaVar.imageUrl, 10, false);
                    this.jfG.setVisibility(0);
                    this.jfH.setVisibility(8);
                }
                e.b(aaVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.jfE, R.color.CAM_X0105);
        ap.setViewTextColor(this.jfF, R.color.CAM_X0105);
        ap.setViewTextColor(this.dHr, R.color.CAM_X0101);
        WebPManager.a(this.iVY, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jfH.onChangeSkinType();
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        com.baidu.tbadk.core.util.e.a.brc().pF(0).pM(l.getDimens(getView().getContext(), R.dimen.tbds10)).pH(i).bn(this.dHr);
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
        this.jfH.setData(arrayList);
        return false;
    }
}
