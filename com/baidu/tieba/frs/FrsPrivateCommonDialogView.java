package com.baidu.tieba.frs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.s.j0.b;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes12.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIALOG_TYPE_CREATE_SUCCESS = "create_success";
    public static final String DIALOG_TYPE_TASK_FAIL = "clear_forum";
    public static final String DIALOG_TYPE_TASK_REMIND = "left_time";
    public static final String DIALOG_TYPE_TASK_SUCCESS = "task_complete";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f43355e;

    /* renamed from: f  reason: collision with root package name */
    public Context f43356f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f43357g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f43358h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f43359i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f43360j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public TextView n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43356f = context;
        a(context);
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, tbImageView) == null) {
            int f2 = n.f(this.f43356f, e.tbds44);
            if (UtilHelper.getRealScreenOrientation(this.f43356f) == 2) {
                k = n.i(this.f43356f);
            } else {
                k = n.k(this.f43356f);
            }
            int i2 = k - (f2 * 2);
            ViewGroup.LayoutParams layoutParams = this.f43357g.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = (i2 * 21) / 38;
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setRadius(n.f(this.f43356f, e.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
        }
    }

    private void setTextAttribute(List<TextView> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, list) == null) {
            for (TextView textView : list) {
                Drawable drawable = textView.getCompoundDrawables()[1];
                int f2 = n.f(this.f43356f, e.tbds78);
                drawable.setBounds(0, 0, f2, f2);
                textView.setCompoundDrawables(null, drawable, null, null);
                SkinManager.setViewTextColor(textView, d.CAM_X0106);
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(h.frs_private_common_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(g.frs_private_common);
            this.f43355e = linearLayout;
            this.f43357g = (TbImageView) linearLayout.findViewById(g.frs_private_common_image);
            this.f43358h = (TextView) this.f43355e.findViewById(g.frs_private_common_title);
            this.f43359i = (TextView) this.f43355e.findViewById(g.frs_private_common_hint);
            this.f43360j = (TextView) this.f43355e.findViewById(g.frs_private_common_button);
            this.k = (RelativeLayout) this.f43355e.findViewById(g.frs_private_common_tips);
            this.l = (TextView) this.f43355e.findViewById(g.frs_private_center_tip);
            this.m = (TextView) this.f43355e.findViewById(g.frs_private_left_tip);
            this.n = (TextView) this.f43355e.findViewById(g.frs_private_right_tip);
            setImageAttribute(this.f43357g);
            setTextAttribute(Arrays.asList(this.l, this.m, this.n));
            SkinManager.setBackgroundResource(this.f43355e, f.bg_frs_private_dialog);
            SkinManager.setViewTextColor(this.f43358h, d.CAM_X0105);
            SkinManager.setViewTextColor(this.f43359i, d.CAM_X0107);
            SkinManager.setBackgroundResourceSelector(this.f43360j, f.btn_frs_private_n, f.btn_frs_private_s);
            SkinManager.setViewTextColor(this.f43360j, d.CAM_X0101);
        }
    }

    public boolean configPrivateDialog(PrivateForumPopInfoData privateForumPopInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, privateForumPopInfoData)) == null) {
            if (privateForumPopInfoData != null && privateForumPopInfoData.y() != null) {
                String str = privateForumPopInfoData.y() + "_" + privateForumPopInfoData.x();
                if (b.k().h(str, false)) {
                    return false;
                }
                b.k().u(str, true);
                if (privateForumPopInfoData.y().equals(DIALOG_TYPE_TASK_SUCCESS)) {
                    this.k.setVisibility(0);
                    this.f43360j.setVisibility(8);
                } else {
                    this.k.setVisibility(8);
                    this.f43360j.setVisibility(0);
                }
                if (privateForumPopInfoData.y().equals(DIALOG_TYPE_CREATE_SUCCESS)) {
                    this.f43358h.setVisibility(0);
                    this.f43358h.setText(j.frs_private_create_title);
                    this.f43360j.setText(j.frs_private_create_button);
                    SkinManager.setImageResource(this.f43357g, f.pic_frs_private_create_success);
                } else if (privateForumPopInfoData.y().equals(DIALOG_TYPE_TASK_REMIND)) {
                    this.f43358h.setVisibility(8);
                    this.f43360j.setText(j.frs_private_create_button);
                    SkinManager.setImageResource(this.f43357g, f.pic_frs_private_target_remind);
                } else if (privateForumPopInfoData.y().equals(DIALOG_TYPE_TASK_FAIL)) {
                    this.f43358h.setVisibility(8);
                    this.f43360j.setText(j.frs_private_fail_button);
                    SkinManager.setImageResource(this.f43357g, f.pic_frs_private_target_fail);
                } else if (privateForumPopInfoData.y().equals(DIALOG_TYPE_TASK_SUCCESS)) {
                    this.f43358h.setVisibility(0);
                    this.f43358h.setText(j.frs_private_success_title);
                    SkinManager.setImageResource(this.f43357g, f.pic_frs_private_target_success);
                }
                this.f43359i.setText(privateForumPopInfoData.w());
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f43360j.setOnClickListener(onClickListener);
    }
}
