package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.StringUtils;
import com.repackage.li;
import com.repackage.o25;
import com.repackage.wq4;
import com.repackage.ys4;
/* loaded from: classes3.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ImageView b;
    public HeadImageView c;
    public TbImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public RelativeLayout h;
    public View i;
    public View j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-397543599, "Lcom/baidu/tieba/frs/FrsPrivateCommonDialogView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-397543599, "Lcom/baidu/tieba/frs/FrsPrivateCommonDialogView;");
                return;
            }
        }
        k = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        l = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds250);
        m = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        n = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds405);
        o = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds220);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        d(context);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            if (z) {
                int i = n;
                layoutParams.height = i;
                layoutParams2.height = i;
                layoutParams3.height = o;
            } else {
                int i2 = l;
                layoutParams.height = i2;
                layoutParams2.height = i2;
                layoutParams3.height = m;
            }
            this.h.setLayoutParams(layoutParams);
            this.b.setLayoutParams(layoutParams2);
            this.i.setLayoutParams(layoutParams3);
        }
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, privateForumPopInfoData, z)) == null) {
            if (privateForumPopInfoData == null || StringUtils.isEmpty(privateForumPopInfoData.B()) || c(privateForumPopInfoData, z)) {
                return false;
            }
            a(e(privateForumPopInfoData.B()));
            if (privateForumPopInfoData.B().equals("left_time")) {
                this.g.setText(R.string.obfuscated_res_0x7f0f0729);
                SkinManager.setImageResource(this.b, R.drawable.obfuscated_res_0x7f080f3d);
            } else if (!privateForumPopInfoData.B().equals("clear_forum") && !privateForumPopInfoData.B().equals("task_fail")) {
                if (privateForumPopInfoData.B().equals("task_complete")) {
                    this.g.setText(R.string.obfuscated_res_0x7f0f0729);
                    SkinManager.setImageResource(this.b, R.drawable.obfuscated_res_0x7f080f3e);
                } else {
                    this.g.setText(R.string.obfuscated_res_0x7f0f0729);
                    f();
                    SkinManager.setImageResource(this.d, R.drawable.obfuscated_res_0x7f080f3a);
                    SkinManager.setImageResource(this.b, R.drawable.obfuscated_res_0x7f080f3b);
                }
            } else {
                this.g.setText(R.string.obfuscated_res_0x7f0f072b);
                SkinManager.setImageResource(this.b, R.drawable.obfuscated_res_0x7f080f3c);
            }
            this.g.setTag(R.id.obfuscated_res_0x7f090f23, Boolean.valueOf(z));
            this.g.setTag(R.id.obfuscated_res_0x7f0918fd, privateForumPopInfoData);
            this.e.setText(privateForumPopInfoData.getTitle());
            this.f.setText(privateForumPopInfoData.z());
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public final boolean c(PrivateForumPopInfoData privateForumPopInfoData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, privateForumPopInfoData, z)) == null) {
            String str = privateForumPopInfoData.B() + "_" + privateForumPopInfoData.A() + "_" + privateForumPopInfoData.y();
            if (z) {
                str = str + "_" + TbadkCoreApplication.getCurrentAccount();
            }
            if (ys4.k().h(str, false)) {
                return true;
            }
            ys4.k().u(str, true);
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d033a, this);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b90);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090a4c);
            this.c = headImageView;
            headImageView.setIsRound(true);
            this.c.setDrawBorder(true);
            this.c.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
            this.c.setBorderWidth(k);
            this.d = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090a4b);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090b91);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090b8f);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090b8e);
            this.h = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0918fc);
            this.i = findViewById(R.id.obfuscated_res_0x7f090cef);
            this.j = findViewById(R.id.obfuscated_res_0x7f0918fb);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0108);
            wq4 d = wq4.d(this.g);
            d.l(R.dimen.tbds1);
            d.n(R.string.J_X07);
            d.k(R.color.CAM_X0304);
            d.v(R.color.CAM_X0304);
            wq4 d2 = wq4.d(this.e);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0105);
            wq4 d3 = wq4.d(this.i);
            d3.n(R.string.J_X14);
            d3.f(R.color.CAM_X0201);
            wq4 d4 = wq4.d(this.j);
            d4.n(R.string.J_X17);
            d4.f(R.color.CAM_X0201);
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? ("left_time".equals(str) || "clear_forum".equals(str) || "task_complete".equals(str) || "task_fail".equals(str)) ? false : true : invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.setVisibility(0);
            this.d.setVisibility(0);
            String avater = o25.d().e().getAvater();
            if (avater.startsWith("http")) {
                this.c.K(avater, 10, false);
            } else {
                this.c.K(avater, 12, false);
            }
        }
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.g.setOnClickListener(onClickListener);
    }
}
