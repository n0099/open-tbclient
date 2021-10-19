package com.baidu.tieba.frs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.s.d0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIALOG_TYPE_CREATE_SUCCESS = "create_success";
    public static final String DIALOG_TYPE_TASK_FAIL = "clear_forum";
    public static final String DIALOG_TYPE_TASK_REMIND = "left_time";
    public static final String DIALOG_TYPE_TASK_SUCCESS = "task_complete";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f50936e;

    /* renamed from: f  reason: collision with root package name */
    public Context f50937f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f50938g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50939h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f50940i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f50941j;
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
        this.f50937f = context;
        a(context);
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, tbImageView) == null) {
            int g2 = l.g(this.f50937f, R.dimen.tbds44);
            if (UtilHelper.getRealScreenOrientation(this.f50937f) == 2) {
                k = l.i(this.f50937f);
            } else {
                k = l.k(this.f50937f);
            }
            int i2 = k - (g2 * 2);
            ViewGroup.LayoutParams layoutParams = this.f50938g.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = (i2 * 21) / 38;
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setRadius(l.g(this.f50937f, R.dimen.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
        }
    }

    private void setTextAttribute(List<TextView> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, list) == null) {
            for (TextView textView : list) {
                Drawable drawable = textView.getCompoundDrawables()[1];
                int g2 = l.g(this.f50937f, R.dimen.tbds78);
                drawable.setBounds(0, 0, g2, g2);
                textView.setCompoundDrawables(null, drawable, null, null);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_private_common);
            this.f50936e = linearLayout;
            this.f50938g = (TbImageView) linearLayout.findViewById(R.id.frs_private_common_image);
            this.f50939h = (TextView) this.f50936e.findViewById(R.id.frs_private_common_title);
            this.f50940i = (TextView) this.f50936e.findViewById(R.id.frs_private_common_hint);
            this.f50941j = (TextView) this.f50936e.findViewById(R.id.frs_private_common_button);
            this.k = (RelativeLayout) this.f50936e.findViewById(R.id.frs_private_common_tips);
            this.l = (TextView) this.f50936e.findViewById(R.id.frs_private_center_tip);
            this.m = (TextView) this.f50936e.findViewById(R.id.frs_private_left_tip);
            this.n = (TextView) this.f50936e.findViewById(R.id.frs_private_right_tip);
            setImageAttribute(this.f50938g);
            setTextAttribute(Arrays.asList(this.l, this.m, this.n));
            SkinManager.setBackgroundResource(this.f50936e, R.drawable.bg_frs_private_dialog);
            SkinManager.setViewTextColor(this.f50939h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f50940i, R.color.CAM_X0107);
            SkinManager.setBackgroundResourceSelector(this.f50941j, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
            SkinManager.setViewTextColor(this.f50941j, R.color.CAM_X0101);
        }
    }

    public boolean configPrivateDialog(PrivateForumPopInfoData privateForumPopInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, privateForumPopInfoData)) == null) {
            if (privateForumPopInfoData != null && privateForumPopInfoData.y() != null) {
                String str = privateForumPopInfoData.y() + "_" + privateForumPopInfoData.x();
                if (b.j().g(str, false)) {
                    return false;
                }
                b.j().t(str, true);
                if (privateForumPopInfoData.y().equals(DIALOG_TYPE_TASK_SUCCESS)) {
                    this.k.setVisibility(0);
                    this.f50941j.setVisibility(8);
                } else {
                    this.k.setVisibility(8);
                    this.f50941j.setVisibility(0);
                }
                if (privateForumPopInfoData.y().equals(DIALOG_TYPE_CREATE_SUCCESS)) {
                    this.f50939h.setVisibility(0);
                    this.f50939h.setText(R.string.frs_private_create_title);
                    this.f50941j.setText(R.string.frs_private_create_button);
                    SkinManager.setImageResource(this.f50938g, R.drawable.pic_frs_private_create_success);
                } else if (privateForumPopInfoData.y().equals(DIALOG_TYPE_TASK_REMIND)) {
                    this.f50939h.setVisibility(8);
                    this.f50941j.setText(R.string.frs_private_create_button);
                    SkinManager.setImageResource(this.f50938g, R.drawable.pic_frs_private_target_remind);
                } else if (privateForumPopInfoData.y().equals(DIALOG_TYPE_TASK_FAIL)) {
                    this.f50939h.setVisibility(8);
                    this.f50941j.setText(R.string.frs_private_fail_button);
                    SkinManager.setImageResource(this.f50938g, R.drawable.pic_frs_private_target_fail);
                } else if (privateForumPopInfoData.y().equals(DIALOG_TYPE_TASK_SUCCESS)) {
                    this.f50939h.setVisibility(0);
                    this.f50939h.setText(R.string.frs_private_success_title);
                    SkinManager.setImageResource(this.f50938g, R.drawable.pic_frs_private_target_success);
                }
                this.f50940i.setText(privateForumPopInfoData.w());
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
        this.f50941j.setOnClickListener(onClickListener);
    }
}
