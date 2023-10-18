package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fv4 extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public TextView c;
    public Button d;
    public to4 e;
    public int f;
    public int g;
    public RelativeLayout h;
    public CustomMessageListener i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv4 a;

        public a(fv4 fv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.e == null) {
                return;
            }
            if (this.a.e.d == to4.C) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.e.l) && !ad.isEmpty(this.a.e.k)) {
                    fv4 fv4Var = this.a;
                    fv4Var.e(fv4Var.e.k);
                }
            } else if (this.a.e.d == to4.D && !ad.isEmpty(this.a.e.k)) {
                fv4 fv4Var2 = this.a;
                fv4Var2.e(fv4Var2.e.k);
            }
            this.a.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv4 a;

        public b(fv4 fv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv4 a;

        public c(fv4 fv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv4Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().unRegisterListener(this.a.i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(fv4 fv4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fv4(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new d(this, 2921420);
        g(context);
        MessageManager.getInstance().registerListener(this.i);
    }

    public final void e(String str) {
        TbPageContext<?> f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !ad.isEmpty(str) && (f = f(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            UrlManager.getInstance().dealOneLink(f, new String[]{str});
        }
    }

    public final TbPageContext f(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void d(Context context, to4 to4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, to4Var) != null) || to4Var == null) {
            return;
        }
        this.e = to4Var;
        if (ad.isEmpty(to4Var.e)) {
            this.b.setText(context.getResources().getString(R.string.task_already_finish));
        } else {
            this.b.setText(to4Var.e);
        }
        if (ad.isEmpty(to4Var.p)) {
            this.b.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
        } else {
            this.b.setTextColor(ColorUtils.parseColor(to4Var.p));
        }
        if (ad.isEmpty(to4Var.f)) {
            this.c.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f030c));
        } else {
            this.c.setText(to4Var.f);
        }
        if (ad.isEmpty(to4Var.q)) {
            this.c.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
        } else {
            this.c.setTextColor(ColorUtils.parseColor(to4Var.q));
        }
        if (!ad.isEmpty(to4Var.o)) {
            this.c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(context, R.dimen.tbds120), ColorUtils.parseColor(to4Var.o)));
        }
        if (!ad.isEmpty(to4Var.j)) {
            this.a.startLoad(to4Var.j, 10, false);
        } else {
            SkinManager.setImageResource(this.a, R.drawable.banner_size);
        }
    }

    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
            this.a = tbImageView;
            tbImageView.setRadius(BdUtilHelper.getDimens(context, R.dimen.tbds32));
            this.a.setConrers(3);
            this.b = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
            this.c = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
            this.d = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f0904be);
            this.h = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
            this.c.setOnClickListener(new a(this));
            this.d.setOnClickListener(new b(this));
            setContentView(inflate);
            GreyUtil.grey(this);
            setWidth(-1);
            setHeight(-1);
            setFocusable(true);
            setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.black_alpha35)));
            setAnimationStyle(R.style.obfuscated_res_0x7f1002d6);
            setClippingEnabled(false);
            setOnDismissListener(new c(this));
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                currentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                this.f = displayMetrics.widthPixels;
                this.g = displayMetrics.heightPixels;
            }
            if (this.g > 2000 && this.f > 2000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (h() && (relativeLayout = this.h) != null && relativeLayout.getLayoutParams() != null) {
                this.h.getLayoutParams().width = (this.f * 2) / 3;
            }
            showAtLocation(getContentView(), 17, 0, 0);
        }
    }
}
