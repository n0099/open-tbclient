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
    private TextView dWd;
    private TextView jIA;
    private TbClipImageView jIB;
    private ImageOverlayView jIC;
    private FrsViewData jIs;
    private ab jIw;
    private TextView jIz;
    private ImageView jyV;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(c.this.mRootView.getResources().getString(R.string.hot_user_rank), c.this.jIw.imageUrl) || c.this.jIs == null || c.this.jIs.getForum() == null || TextUtils.isEmpty(c.this.jIs.getForum().getId())) {
                if (c.this.jIw != null && c.this.jIw.nye != null) {
                    TiebaStatic.log(new ar("c13274").v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", c.this.jIw.forumId).dR("obj_source", "frs_card").dR("obj_id", c.this.jIw.nye.id).dR("obj_name", c.this.jIw.nye.name).aq("obj_param1", c.this.jIw.nye.eFQ.intValue()));
                }
                d.a(view.getContext(), c.this.jIw);
                d.c(c.this.jIw);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(c.this.jIs.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            ar arVar = new ar("c13666");
            arVar.dR("fid", c.this.jIs.getForum().getId());
            TiebaStatic.log(arVar);
        }
    };
    private View mRootView;

    public c(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.dWd = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.jIz = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.jIA = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.jIB = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.jIB.setDrawerType(1);
        this.jIB.setIsRound(true);
        this.jIB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        this.jIC = (ImageOverlayView) this.mRootView.findViewById(R.id.image_group);
        this.jIC.l(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.jIC.setStrokeStyle(1);
        this.jIC.setLoadImageType(12);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.jyV = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (aaVar != null && !y.isEmpty(aaVar.dataList)) {
            this.jIs = frsViewData;
            ab abVar = aaVar.dataList.get(0);
            if (abVar != null) {
                this.jIw = abVar;
                if (!TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), this.jIw.imageUrl)) {
                    this.jIz.setText(this.mRootView.getContext().getString(R.string.forum_exclusive));
                } else {
                    this.jIz.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
                    this.dWd.setText(this.mRootView.getContext().getString(R.string.hot_person));
                }
                this.jIA.setText(au.ar(abVar.name, 20));
                if (TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), abVar.imageUrl)) {
                    this.jIC.setVisibility(0);
                    this.jIB.setVisibility(8);
                    g(frsViewData);
                } else {
                    this.jIB.startLoad(abVar.imageUrl, 10, false);
                    this.jIB.setVisibility(0);
                    this.jIC.setVisibility(8);
                }
                d.b(abVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.jIz, R.color.CAM_X0105);
        ap.setViewTextColor(this.jIA, R.color.CAM_X0105);
        ap.setViewTextColor(this.dWd, R.color.CAM_X0101);
        WebPManager.a(this.jyV, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jIC.onChangeSkinType();
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        com.baidu.tbadk.core.util.f.a.bty().oP(0).oW(l.getDimens(getView().getContext(), R.dimen.tbds10)).oR(i).bv(this.dWd);
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
        this.jIC.setData(arrayList);
        return false;
    }
}
