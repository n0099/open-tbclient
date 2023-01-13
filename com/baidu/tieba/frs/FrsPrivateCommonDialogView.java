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
import com.baidu.tieba.cx4;
import com.baidu.tieba.cz4;
import com.baidu.tieba.v95;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.StringUtils;
/* loaded from: classes4.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public HeadImageView b;
    public TbImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public RelativeLayout g;
    public View h;
    public View i;

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
        j = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        k = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds250);
        l = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        m = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds405);
        n = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds220);
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
        d(context);
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!"left_time".equals(str) && !"clear_forum".equals(str) && !"task_complete".equals(str) && !"task_fail".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            if (z) {
                int i = m;
                layoutParams.height = i;
                layoutParams2.height = i;
                layoutParams3.height = n;
            } else {
                int i2 = k;
                layoutParams.height = i2;
                layoutParams2.height = i2;
                layoutParams3.height = l;
            }
            this.g.setLayoutParams(layoutParams);
            this.a.setLayoutParams(layoutParams2);
            this.h.setLayoutParams(layoutParams3);
        }
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, privateForumPopInfoData, z)) == null) {
            if (privateForumPopInfoData == null || StringUtils.isEmpty(privateForumPopInfoData.J()) || c(privateForumPopInfoData, z)) {
                return false;
            }
            a(e(privateForumPopInfoData.J()));
            if (privateForumPopInfoData.J().equals("left_time")) {
                this.f.setText(R.string.frs_private_create_button);
                SkinManager.setImageResource(this.a, R.drawable.pic_frs_private_target_remind);
            } else if (!privateForumPopInfoData.J().equals("clear_forum") && !privateForumPopInfoData.J().equals("task_fail")) {
                if (privateForumPopInfoData.J().equals("task_complete")) {
                    this.f.setText(R.string.frs_private_create_button);
                    SkinManager.setImageResource(this.a, R.drawable.pic_frs_private_target_success);
                } else {
                    this.f.setText(R.string.frs_private_create_button);
                    f();
                    SkinManager.setImageResource(this.c, R.drawable.pic_frs_private_create_success);
                    SkinManager.setImageResource(this.a, R.drawable.pic_frs_private_create_success_bg);
                }
            } else {
                this.f.setText(R.string.frs_private_fail_button);
                SkinManager.setImageResource(this.a, R.drawable.pic_frs_private_target_fail);
            }
            this.f.setTag(R.id.is_forum_owner_check, Boolean.valueOf(z));
            this.f.setTag(R.id.private_pop_info, privateForumPopInfoData);
            this.d.setText(privateForumPopInfoData.getTitle());
            this.e.setText(privateForumPopInfoData.H());
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public final boolean c(PrivateForumPopInfoData privateForumPopInfoData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, privateForumPopInfoData, z)) == null) {
            String str = privateForumPopInfoData.J() + "_" + privateForumPopInfoData.I() + "_" + privateForumPopInfoData.G();
            if (z) {
                str = str + "_" + TbadkCoreApplication.getCurrentAccount();
            }
            if (cz4.l().i(str, false)) {
                return true;
            }
            cz4.l().v(str, true);
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
            this.a = (ImageView) findViewById(R.id.frs_private_common_image);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.forum_owner_avatar);
            this.b = headImageView;
            headImageView.setIsRound(true);
            this.b.setDrawBorder(true);
            this.b.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
            this.b.setBorderWidth(j);
            this.c = (TbImageView) findViewById(R.id.forum_owner_arrive);
            this.d = (TextView) findViewById(R.id.frs_private_common_title);
            this.e = (TextView) findViewById(R.id.frs_private_common_hint);
            this.f = (TextView) findViewById(R.id.frs_private_common_button);
            this.g = (RelativeLayout) findViewById(R.id.private_pop_header);
            this.h = findViewById(R.id.header_bg);
            this.i = findViewById(R.id.private_pop_content);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0108);
            cx4 d = cx4.d(this.f);
            d.l(R.dimen.tbds1);
            d.n(R.string.J_X07);
            d.k(R.color.CAM_X0304);
            d.v(R.color.CAM_X0304);
            cx4 d2 = cx4.d(this.d);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0105);
            cx4 d3 = cx4.d(this.h);
            d3.n(R.string.J_X14);
            d3.f(R.color.CAM_X0201);
            cx4 d4 = cx4.d(this.i);
            d4.n(R.string.J_X17);
            d4.f(R.color.CAM_X0201);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            String avater = v95.d().e().getAvater();
            if (avater.startsWith("http")) {
                this.b.K(avater, 10, false);
            } else {
                this.b.K(avater, 12, false);
            }
        }
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) && onClickListener != null) {
            this.f.setOnClickListener(onClickListener);
        }
    }
}
