package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.UpgradePopWindowHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.bw4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fw4 extends ew4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> f;
    public b35 g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw4 a;

        public a(fw4 fw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d.d().dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw4 a;

        public b(fw4 fw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d.d().dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw4 a;

        public c(fw4 fw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.a.f, new String[]{this.a.g.c()});
                this.a.d.d().dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fw4(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.f = tbPageContext;
    }

    @Override // com.baidu.tieba.bw4
    public void d(bw4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (iw4.l() && aVar != null) {
                aVar.a(false);
                return;
            }
            if (LaunchStatsUtils.getLaunchType() == 0) {
                b35 upgradePopWindowConfig = TbSingleton.getInstance().getUpgradePopWindowConfig();
                this.g = upgradePopWindowConfig;
                if (upgradePopWindowConfig.i() && this.g.h().contains("app") && UpgradePopWindowHelper.isDue(this.g)) {
                    ry4.l().z(UpgradePopWindowHelper.SP_UPGRADE_POP_WINDOW_SHOW_DATE, UpgradePopWindowHelper.date2String());
                    if (aVar != null) {
                        aVar.a(true);
                        return;
                    }
                }
            }
            if (aVar != null) {
                aVar.a(false);
            }
        }
    }

    @Override // com.baidu.tieba.ew4
    public void g(TBAlertBuilder tBAlertBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tBAlertBuilder) == null) {
            if (this.g == null) {
                this.g = TbSingleton.getInstance().getUpgradePopWindowConfig();
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.c);
            View view2 = new View(this.c);
            rw4 d = rw4.d(view2);
            d.m(1);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds237));
            layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds120), 0, 0);
            relativeLayout.addView(view2, layoutParams);
            ImageView imageView = new ImageView(this.c);
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_popshengji, null);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(14);
            relativeLayout.addView(imageView, layoutParams2);
            this.d.w(this.g.d());
            this.d.q(this.g.g());
            this.d.o(true);
            this.d.l(relativeLayout);
            if (TextUtils.isEmpty(this.g.c())) {
                this.d.t(new TBAlertConfig.a(this.g.e(), TBAlertConfig.OperateBtnStyle.MAIN, new a(this)));
            } else {
                this.d.t(new TBAlertConfig.a(this.g.f(), TBAlertConfig.OperateBtnStyle.SECONDARY, new b(this)), new TBAlertConfig.a(this.g.e(), TBAlertConfig.OperateBtnStyle.FORCE, new c(this)));
            }
            this.d.d().setCanceledOnTouchOutside(false);
        }
    }

    @Override // com.baidu.tieba.ew4
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            iw4.t("grayUpdate");
        }
    }

    @Override // com.baidu.tieba.ew4
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            iw4.n("grayUpdate");
        }
    }
}
