package com.baidu.tieba;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hs8 extends PriorityOrganizer.Task {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public xp8 n;
    public MainTabActivity o;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs8 a;

        public a(hs8 hs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hs8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs8 a;

        public b(hs8 hs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hs8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LevePopData a;
        public final /* synthetic */ hs8 b;

        public c(hs8 hs8Var, LevePopData levePopData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs8Var, levePopData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hs8Var;
            this.a = levePopData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view2.getContext(), null, this.a.getBtn_scheme(), true)));
                this.b.u();
            }
        }
    }

    public hs8(TbPageContext tbPageContext, xp8 xp8Var, MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xp8Var, mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        this.n = xp8Var;
        this.o = mainTabActivity;
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public void A() {
        String cancel_btn_text;
        String btn_text;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LevePopData levePopData = TbSingleton.getInstance().getLevePopData();
            if (!levePopData.isHadShow() && !StringUtils.isNull(levePopData.getTitle()) && !StringUtils.isNull(levePopData.getDesc()) && !StringUtils.isNull(levePopData.getBtn_scheme()) && levePopData.getLevel() > 0 && levePopData.getLevel() <= 10) {
                RelativeLayout relativeLayout = new RelativeLayout(this.m.getPageActivity());
                View view2 = new View(this.m.getPageActivity());
                hv4 d = hv4.d(view2);
                d.m(1);
                d.n(R.string.J_X06);
                d.f(R.color.CAM_X0205);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds127));
                layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds149), 0, 0);
                relativeLayout.addView(view2, layoutParams);
                ImageView imageView = new ImageView(this.m.getPageActivity());
                imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08083f, WebPManager.ResourceStateType.NORMAL));
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(14);
                relativeLayout.addView(imageView, layoutParams2);
                TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.m.getPageActivity());
                tBAlertBuilder.u(levePopData.getTitle());
                tBAlertBuilder.o(levePopData.getDesc());
                tBAlertBuilder.m(true);
                tBAlertBuilder.j(relativeLayout);
                TBAlertConfig.a[] aVarArr = new TBAlertConfig.a[2];
                if (StringUtils.isNull(levePopData.getCancel_btn_text())) {
                    cancel_btn_text = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0828);
                } else {
                    cancel_btn_text = levePopData.getCancel_btn_text();
                }
                aVarArr[0] = new TBAlertConfig.a(cancel_btn_text, TBAlertConfig.OperateBtnStyle.SECONDARY, new b(this));
                if (StringUtils.isNull(levePopData.getBtn_text())) {
                    btn_text = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03b5);
                } else {
                    btn_text = levePopData.getBtn_text();
                }
                aVarArr[1] = new TBAlertConfig.a(btn_text, TBAlertConfig.OperateBtnStyle.MAIN, new c(this, levePopData));
                tBAlertBuilder.r(aVarArr);
                tBAlertBuilder.q(new a(this));
                tBAlertBuilder.h(false);
                tBAlertBuilder.g();
                tBAlertBuilder.w();
                PollingModel.W(levePopData, true);
                return;
            }
            u();
        }
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            xp8 xp8Var = this.n;
            return (xp8Var == null || xp8Var.B() == null || (this.n.B().getCurrentTabType() != 2 && this.n.B().getCurrentTabType() != 1 && this.n.B().getCurrentTabType() != 3)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LevePopData levePopData = TbSingleton.getInstance().getLevePopData();
            return !levePopData.isHadShow() && !StringUtils.isNull(levePopData.getTitle()) && !StringUtils.isNull(levePopData.getDesc()) && !StringUtils.isNull(levePopData.getBtn_scheme()) && levePopData.getLevel() > 0 && levePopData.getLevel() <= 10 && this.o.d1() && this.o.E && levePopData.getUid().longValue() == TbadkCoreApplication.getCurrentAccountId();
        }
        return invokeV.booleanValue;
    }
}
