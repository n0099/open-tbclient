package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tieba.b55;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class aha extends e55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity f;
    public final iea g;
    public LevePopData h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aha a;

        public a(aha ahaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ahaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ahaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LevePopData a;
        public final /* synthetic */ aha b;

        public b(aha ahaVar, LevePopData levePopData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ahaVar, levePopData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ahaVar;
            this.a = levePopData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BrowserHelper.startWebActivity(view2.getContext(), (String) null, this.a.getBtn_scheme(), true);
                this.b.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aha(@NonNull MainTabActivity mainTabActivity, @NonNull iea ieaVar) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ieaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = mainTabActivity;
        this.g = ieaVar;
    }

    @Override // com.baidu.tieba.b55
    public void d(b55.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (YunDialogManager.isShowingDialog() && aVar != null) {
                aVar.callback(false);
                return;
            }
            iea ieaVar = this.g;
            if ((ieaVar == null || ieaVar.z() == null || (this.g.z().getCurrentTabType() != 2 && this.g.z().getCurrentTabType() != 1 && this.g.z().getCurrentTabType() != 3)) && aVar != null) {
                aVar.callback(false);
                return;
            }
            LevePopData levePopData = TbSingleton.getInstance().getLevePopData();
            this.h = levePopData;
            if (!levePopData.isHadShow() && !StringUtils.isNull(this.h.getTitle()) && !StringUtils.isNull(this.h.getDesc()) && !StringUtils.isNull(this.h.getBtn_scheme()) && this.h.getLevel() > 0 && this.h.getLevel() <= 10 && this.f.K1() && this.f.B && this.h.getUid().longValue() == TbadkCoreApplication.getCurrentAccountId() && aVar != null) {
                aVar.callback(true);
            } else if (aVar != null) {
                aVar.callback(false);
            }
        }
    }

    @Override // com.baidu.tieba.e55
    public void h(TBAlertBuilder tBAlertBuilder) {
        String cancel_btn_text;
        String btn_text;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tBAlertBuilder) == null) {
            if (this.h == null) {
                this.h = TbSingleton.getInstance().getLevePopData();
            }
            LevePopData levePopData = this.h;
            if (levePopData != null && levePopData.isHadShow()) {
                c();
                return;
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.f);
            View view2 = new View(this.f);
            EMManager.from(view2).setCardType(1).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds127));
            layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds149), 0, 0);
            relativeLayout.addView(view2, layoutParams);
            ImageView imageView = new ImageView(this.f);
            imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_usergrouth_home, WebPManager.ResourceStateType.NORMAL));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            relativeLayout.addView(imageView, layoutParams2);
            LevePopData levePopData2 = this.h;
            TBAlertBuilder customHeaderView = tBAlertBuilder.setTitleStr(levePopData2.getTitle()).setDescStr(this.h.getDesc()).setDescLightStyle(true).setCustomHeaderView(relativeLayout);
            TBAlertConfig.OperateBtnConfig[] operateBtnConfigArr = new TBAlertConfig.OperateBtnConfig[2];
            if (StringUtils.isNull(this.h.getCancel_btn_text())) {
                cancel_btn_text = TbadkCoreApplication.getInst().getString(R.string.guide_popup_window_known);
            } else {
                cancel_btn_text = this.h.getCancel_btn_text();
            }
            operateBtnConfigArr[0] = new TBAlertConfig.OperateBtnConfig(cancel_btn_text, TBAlertConfig.OperateBtnStyle.SECONDARY, new a(this));
            if (StringUtils.isNull(this.h.getBtn_text())) {
                btn_text = TbadkCoreApplication.getInst().getString(R.string.check_detail);
            } else {
                btn_text = this.h.getBtn_text();
            }
            operateBtnConfigArr[1] = new TBAlertConfig.OperateBtnConfig(btn_text, TBAlertConfig.OperateBtnStyle.MAIN, new b(this, levePopData2));
            customHeaderView.setOperateBtn(operateBtnConfigArr).setCancelable(false).setAutoClose().show();
            PollingModel.setLevelPopData(this.h, true);
        }
    }

    @Override // com.baidu.tieba.e55
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            YunDialogManager.unMarkShowingDialogName("userGrowth");
        }
    }

    @Override // com.baidu.tieba.e55
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            YunDialogManager.markShowingDialogName("userGrowth");
        }
    }
}
