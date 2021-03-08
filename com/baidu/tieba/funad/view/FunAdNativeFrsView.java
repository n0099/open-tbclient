package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.a.a;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.n;
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.FunNativeAd;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class FunAdNativeFrsView extends FunAdNativePbView {
    private LinearLayout jVP;
    private RoundTbImageView jVQ;
    private TextView jVR;
    private TextView jVS;
    private FunAdAgreeView jVT;
    private ImageView jVU;
    private TextView jVV;
    private ImageView jVW;
    private TextView jVX;
    private ViewGroup jVY;
    private ImageView jVZ;

    public FunAdNativeFrsView(Context context) {
        super(context);
    }

    public FunAdNativeFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FunAdNativeFrsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void initView(Context context) {
        super.initView(context);
        this.jVP = (LinearLayout) findViewById(R.id.fun_ad_frs_view_layout);
        this.jVQ = (RoundTbImageView) findViewById(R.id.top_ad_logo);
        this.jVS = (TextView) findViewById(R.id.top_ad_name);
        this.jVR = (TextView) findViewById(R.id.top_ad_justnow);
        this.jVT = (FunAdAgreeView) findViewById(R.id.ad_agree_view);
        this.jVW = (ImageView) findViewById(R.id.thread_info_commont_img);
        this.jVX = (TextView) findViewById(R.id.thread_info_commont_num);
        this.jVU = (ImageView) findViewById(R.id.share_num_img);
        this.jVV = (TextView) findViewById(R.id.share_num);
        this.jVY = (ViewGroup) findViewById(R.id.layout_card_top);
        this.jVZ = (ImageView) findViewById(R.id.fun_ad_feedback);
        this.jWb.setVisibility(8);
        cNO();
        this.jWa.setPadding(this.jWa.getPaddingLeft(), this.jWa.getPaddingTop(), this.jWa.getPaddingRight(), 0);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void cNF() {
        super.cNF();
        WebPManager.a(this.jVZ, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        c.br(this).oh(R.string.J_X06).aJ(R.color.CAM_X0205, R.color.CAM_X0206);
        c.br(this.jVR).nZ(R.color.CAM_X0109);
        c.br(this.jVS).nZ(R.color.CAM_X0105);
        c.br(this.jWi).nZ(R.color.CAM_X0101);
        c.br(this.jWg).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0606);
        this.jVU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_share22, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.fcn), WebPManager.ResourceStateType.NORMAL_DISABLE));
        this.jVW.setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_comment22, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.fcn), WebPManager.ResourceStateType.NORMAL_DISABLE));
        this.jVV.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.fcn));
        this.jVX.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.fcn));
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView
    public void f(@NonNull FunNativeAd funNativeAd) {
        super.f(funNativeAd);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void a(@NonNull n nVar, @NonNull Activity activity) {
        super.a(nVar, activity);
        if (nVar.dNz() != null) {
            FunNativeAd funNativeAd = (FunNativeAd) nVar.dNz();
            AgreeData agreeData = new AgreeData();
            if (nVar.dNB() < 0) {
                nVar.JH(a.cI(20, 100));
            }
            agreeData.agreeNum = nVar.dNB();
            this.jVS.setText(this.jVe);
            this.jVT.setAgreeAlone(true);
            this.jVT.setData(agreeData);
            if (StringUtils.isNull(funNativeAd.getIconUrl())) {
                Glide.with(this.jVQ).load(Integer.valueOf(R.drawable.icon_frs_default_header)).into(this.jVQ);
            } else {
                Glide.with(this.jVQ).load(funNativeAd.getIconUrl()).into(this.jVQ);
            }
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    protected int getLayoutId() {
        return R.layout.fun_ad_frs_native;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        return this.jVZ;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void s(BdUniqueId bdUniqueId) {
        super.s(bdUniqueId);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        if (this.jVP != null) {
            this.jVP.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void Bi(int i) {
        this.jVP.setVisibility(i);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = i == 0 ? UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) : 0;
        setLayoutParams(marginLayoutParams);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        return Arrays.asList(this, this.jWa, this.jWd, this.jWj, this.jWn, this.jWl, this.jVY);
    }

    private void cNO() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jVT.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != 1.0f || i != 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.jVT.setLayoutParams(layoutParams);
        }
    }
}
