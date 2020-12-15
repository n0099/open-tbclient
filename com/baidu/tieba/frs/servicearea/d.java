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
/* loaded from: classes22.dex */
public class d implements a, b {
    private TextView dOp;
    private ImageView jjz;
    private FrsViewData jtc;
    private ab jtg;
    private TextView jtj;
    private TextView jtk;
    private TbClipImageView jtl;
    private ImageOverlayView jtm;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(d.this.mRootView.getResources().getString(R.string.hot_user_rank), d.this.jtg.imageUrl) || d.this.jtc == null || d.this.jtc.getForum() == null || TextUtils.isEmpty(d.this.jtc.getForum().getId())) {
                if (d.this.jtg != null && d.this.jtg.nkQ != null) {
                    TiebaStatic.log(new ar("c13274").w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("fid", d.this.jtg.forumId).dY("obj_source", "frs_card").dY("obj_id", d.this.jtg.nkQ.id).dY("obj_name", d.this.jtg.nkQ.name).al("obj_param1", d.this.jtg.nkQ.exF.intValue()));
                }
                e.a(view.getContext(), d.this.jtg);
                e.c(d.this.jtg);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(d.this.jtc.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            ar arVar = new ar("c13666");
            arVar.dY("fid", d.this.jtc.getForum().getId());
            TiebaStatic.log(arVar);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.dOp = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.jtj = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.jtk = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.jtl = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.jtl.setDrawerType(1);
        this.jtl.setIsRound(true);
        this.jtl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        this.jtm = (ImageOverlayView) this.mRootView.findViewById(R.id.image_group);
        this.jtm.k(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.jtm.setStrokeStyle(1);
        this.jtm.setLoadImageType(12);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.jjz = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (aaVar != null && !y.isEmpty(aaVar.dataList)) {
            this.jtc = frsViewData;
            ab abVar = aaVar.dataList.get(0);
            if (abVar != null) {
                this.jtg = abVar;
                if (!TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), this.jtg.imageUrl)) {
                    this.jtj.setText(this.mRootView.getContext().getString(R.string.forum_exclusive));
                } else {
                    this.jtj.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
                    this.dOp.setText(this.mRootView.getContext().getString(R.string.hot_person));
                }
                this.jtk.setText(au.am(abVar.name, 20));
                if (TextUtils.equals(this.mRootView.getResources().getString(R.string.hot_user_rank), abVar.imageUrl)) {
                    this.jtm.setVisibility(0);
                    this.jtl.setVisibility(8);
                    g(frsViewData);
                } else {
                    this.jtl.startLoad(abVar.imageUrl, 10, false);
                    this.jtl.setVisibility(0);
                    this.jtm.setVisibility(8);
                }
                e.b(abVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.jtj, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtk, R.color.CAM_X0105);
        ap.setViewTextColor(this.dOp, R.color.CAM_X0101);
        WebPManager.a(this.jjz, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jtm.onChangeSkinType();
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        com.baidu.tbadk.core.util.e.a.buz().qf(0).qm(l.getDimens(getView().getContext(), R.dimen.tbds10)).qh(i).bq(this.dOp);
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
        this.jtm.setData(arrayList);
        return false;
    }
}
