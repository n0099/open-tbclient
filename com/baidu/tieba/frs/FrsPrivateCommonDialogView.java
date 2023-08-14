package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bs6;
import com.baidu.tieba.lk5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.StringUtils;
import com.bumptech.glide.Glide;
/* loaded from: classes5.dex */
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
        j = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        k = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds250);
        l = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        m = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds405);
        n = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds220);
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
        f(context);
    }

    public final boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!"left_time".equals(str) && !"clear_forum".equals(str) && !"task_complete".equals(str) && !"task_fail".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(PrivateForumPopInfoData privateForumPopInfoData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, privateForumPopInfoData, z)) == null) {
            if (privateForumPopInfoData == null || StringUtils.isEmpty(privateForumPopInfoData.Q()) || d(privateForumPopInfoData, z)) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean d(PrivateForumPopInfoData privateForumPopInfoData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, privateForumPopInfoData, z)) == null) {
            if (!SharedPrefHelper.getInstance().getBoolean(e(privateForumPopInfoData, z), false)) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static void setDialogShown(PrivateForumPopInfoData privateForumPopInfoData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, null, privateForumPopInfoData, z) == null) {
            SharedPrefHelper.getInstance().putBoolean(e(privateForumPopInfoData, z), true);
        }
    }

    public static String e(PrivateForumPopInfoData privateForumPopInfoData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, privateForumPopInfoData, z)) == null) {
            String str = privateForumPopInfoData.Q() + "_" + privateForumPopInfoData.P() + "_" + privateForumPopInfoData.N();
            if (z) {
                return str + "_" + TbadkCoreApplication.getCurrentAccount();
            }
            return str;
        }
        return (String) invokeLZ.objValue;
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

    public boolean c(PrivateForumPopInfoData privateForumPopInfoData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, privateForumPopInfoData, z)) == null) {
            if (!b(privateForumPopInfoData, z)) {
                return false;
            }
            a(g(privateForumPopInfoData.Q()));
            if (privateForumPopInfoData.Q().equals("left_time")) {
                this.f.setText(R.string.frs_private_create_button);
                SkinManager.setImageResource(this.a, R.drawable.pic_frs_private_target_remind);
            } else if (!privateForumPopInfoData.Q().equals("clear_forum") && !privateForumPopInfoData.Q().equals("task_fail")) {
                if (privateForumPopInfoData.Q().equals("task_complete")) {
                    this.f.setText(R.string.frs_private_create_button);
                    SkinManager.setImageResource(this.a, R.drawable.pic_frs_private_target_success);
                } else {
                    this.f.setText(R.string.frs_private_create_button);
                    h();
                    SkinManager.setImageResource(this.c, R.drawable.pic_frs_private_create_success);
                    Glide.with(this.a).load(bs6.b("pic_frs_private_create_success_bg.webp", "pic_frs_private_create_success_bg")).into(this.a);
                }
            } else {
                this.f.setText(R.string.frs_private_fail_button);
                SkinManager.setImageResource(this.a, R.drawable.pic_frs_private_target_fail);
            }
            this.f.setTag(R.id.is_forum_owner_check, Boolean.valueOf(z));
            this.f.setTag(R.id.private_pop_info, privateForumPopInfoData);
            this.d.setText(privateForumPopInfoData.getTitle());
            this.e.setText(privateForumPopInfoData.O());
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
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
            EMManager.from(this.f).setBorderWidth(R.dimen.tbds1).setCorner(R.string.J_X07).setBorderColor(R.color.CAM_X0304).setTextColor(R.color.CAM_X0304);
            EMManager.from(this.d).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.h).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.i).setCorner(R.string.J_X17).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            String avater = lk5.d().e().getAvater();
            if (avater.startsWith("http")) {
                this.b.startLoad(avater, 10, false);
            } else {
                this.b.startLoad(avater, 12, false);
            }
        }
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) && onClickListener != null) {
            this.f.setOnClickListener(onClickListener);
        }
    }
}
