package com.baidu.tieba.frs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.q0.s.e0.b;
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
/* loaded from: classes9.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIALOG_TYPE_CREATE_SUCCESS = "create_success";
    public static final String DIALOG_TYPE_TASK_FAIL = "clear_forum";
    public static final String DIALOG_TYPE_TASK_REMIND = "left_time";
    public static final String DIALOG_TYPE_TASK_SUCCESS = "task_complete";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f49160e;

    /* renamed from: f  reason: collision with root package name */
    public Context f49161f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f49162g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49163h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49164i;
    public TextView j;
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
        this.f49161f = context;
        a(context);
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, tbImageView) == null) {
            int g2 = l.g(this.f49161f, R.dimen.tbds44);
            if (UtilHelper.getRealScreenOrientation(this.f49161f) == 2) {
                k = l.i(this.f49161f);
            } else {
                k = l.k(this.f49161f);
            }
            int i2 = k - (g2 * 2);
            ViewGroup.LayoutParams layoutParams = this.f49162g.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = (i2 * 21) / 38;
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setRadius(l.g(this.f49161f, R.dimen.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
        }
    }

    private void setTextAttribute(List<TextView> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, list) == null) {
            for (TextView textView : list) {
                Drawable drawable = textView.getCompoundDrawables()[1];
                int g2 = l.g(this.f49161f, R.dimen.tbds78);
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
            this.f49160e = linearLayout;
            this.f49162g = (TbImageView) linearLayout.findViewById(R.id.frs_private_common_image);
            this.f49163h = (TextView) this.f49160e.findViewById(R.id.frs_private_common_title);
            this.f49164i = (TextView) this.f49160e.findViewById(R.id.frs_private_common_hint);
            this.j = (TextView) this.f49160e.findViewById(R.id.frs_private_common_button);
            this.k = (RelativeLayout) this.f49160e.findViewById(R.id.frs_private_common_tips);
            this.l = (TextView) this.f49160e.findViewById(R.id.frs_private_center_tip);
            this.m = (TextView) this.f49160e.findViewById(R.id.frs_private_left_tip);
            this.n = (TextView) this.f49160e.findViewById(R.id.frs_private_right_tip);
            setImageAttribute(this.f49162g);
            setTextAttribute(Arrays.asList(this.l, this.m, this.n));
            SkinManager.setBackgroundResource(this.f49160e, R.drawable.bg_frs_private_dialog);
            SkinManager.setViewTextColor(this.f49163h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f49164i, R.color.CAM_X0107);
            SkinManager.setBackgroundResourceSelector(this.j, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
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
                    this.j.setVisibility(8);
                } else {
                    this.k.setVisibility(8);
                    this.j.setVisibility(0);
                }
                if (privateForumPopInfoData.y().equals(DIALOG_TYPE_CREATE_SUCCESS)) {
                    this.f49163h.setVisibility(0);
                    this.f49163h.setText(R.string.frs_private_create_title);
                    this.j.setText(R.string.frs_private_create_button);
                    SkinManager.setImageResource(this.f49162g, R.drawable.pic_frs_private_create_success);
                } else if (privateForumPopInfoData.y().equals(DIALOG_TYPE_TASK_REMIND)) {
                    this.f49163h.setVisibility(8);
                    this.j.setText(R.string.frs_private_create_button);
                    SkinManager.setImageResource(this.f49162g, R.drawable.pic_frs_private_target_remind);
                } else if (privateForumPopInfoData.y().equals(DIALOG_TYPE_TASK_FAIL)) {
                    this.f49163h.setVisibility(8);
                    this.j.setText(R.string.frs_private_fail_button);
                    SkinManager.setImageResource(this.f49162g, R.drawable.pic_frs_private_target_fail);
                } else if (privateForumPopInfoData.y().equals(DIALOG_TYPE_TASK_SUCCESS)) {
                    this.f49163h.setVisibility(0);
                    this.f49163h.setText(R.string.frs_private_success_title);
                    SkinManager.setImageResource(this.f49162g, R.drawable.pic_frs_private_target_success);
                }
                this.f49164i.setText(privateForumPopInfoData.w());
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
        this.j.setOnClickListener(onClickListener);
    }
}
