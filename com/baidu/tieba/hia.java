package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tieba.f65;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hia extends i65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity f;
    public final pfa g;
    public LevePopData h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hia a;

        public a(hia hiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hiaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LevePopData a;
        public final /* synthetic */ hia b;

        public b(hia hiaVar, LevePopData levePopData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hiaVar, levePopData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hiaVar;
            this.a = levePopData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                nx4.v(view2.getContext(), null, this.a.getBtn_scheme(), true);
                this.b.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hia(@NonNull MainTabActivity mainTabActivity, @NonNull pfa pfaVar) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, pfaVar};
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
        this.g = pfaVar;
    }

    @Override // com.baidu.tieba.f65
    public void d(f65.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (m65.k() && aVar != null) {
                aVar.callback(false);
                return;
            }
            pfa pfaVar = this.g;
            if ((pfaVar == null || pfaVar.y() == null || (this.g.y().getCurrentTabType() != 2 && this.g.y().getCurrentTabType() != 1 && this.g.y().getCurrentTabType() != 3)) && aVar != null) {
                aVar.callback(false);
                return;
            }
            LevePopData levePopData = TbSingleton.getInstance().getLevePopData();
            this.h = levePopData;
            if (!levePopData.isHadShow() && !StringUtils.isNull(this.h.getTitle()) && !StringUtils.isNull(this.h.getDesc()) && !StringUtils.isNull(this.h.getBtn_scheme()) && this.h.getLevel() > 0 && this.h.getLevel() <= 10 && this.f.L1() && this.f.B && this.h.getUid().longValue() == TbadkCoreApplication.getCurrentAccountId() && aVar != null) {
                aVar.callback(true);
            } else if (aVar != null) {
                aVar.callback(false);
            }
        }
    }

    @Override // com.baidu.tieba.i65
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
            d85 d = d85.d(view2);
            d.n(1);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds127));
            layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds149), 0, 0);
            relativeLayout.addView(view2, layoutParams);
            ImageView imageView = new ImageView(this.f);
            imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_usergrouth_home, WebPManager.ResourceStateType.NORMAL));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            relativeLayout.addView(imageView, layoutParams2);
            LevePopData levePopData2 = this.h;
            tBAlertBuilder.x(levePopData2.getTitle());
            tBAlertBuilder.q(this.h.getDesc());
            tBAlertBuilder.o(true);
            tBAlertBuilder.l(relativeLayout);
            TBAlertConfig.a[] aVarArr = new TBAlertConfig.a[2];
            if (StringUtils.isNull(this.h.getCancel_btn_text())) {
                cancel_btn_text = TbadkCoreApplication.getInst().getString(R.string.guide_popup_window_known);
            } else {
                cancel_btn_text = this.h.getCancel_btn_text();
            }
            aVarArr[0] = new TBAlertConfig.a(cancel_btn_text, TBAlertConfig.OperateBtnStyle.SECONDARY, new a(this));
            if (StringUtils.isNull(this.h.getBtn_text())) {
                btn_text = TbadkCoreApplication.getInst().getString(R.string.check_detail);
            } else {
                btn_text = this.h.getBtn_text();
            }
            aVarArr[1] = new TBAlertConfig.a(btn_text, TBAlertConfig.OperateBtnStyle.MAIN, new b(this, levePopData2));
            tBAlertBuilder.u(aVarArr);
            tBAlertBuilder.j(false);
            tBAlertBuilder.i();
            tBAlertBuilder.z();
            PollingModel.P0(this.h, true);
        }
    }

    @Override // com.baidu.tieba.i65
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            m65.u("userGrowth");
        }
    }

    @Override // com.baidu.tieba.i65
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            m65.n("userGrowth");
        }
    }
}
