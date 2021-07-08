package com.baidu.tieba.frs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import d.a.c.e.p.l;
import d.a.o0.r.d0.b;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15403e;

    /* renamed from: f  reason: collision with root package name */
    public Context f15404f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f15405g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15406h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15407i;
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
        this.f15404f = context;
        b(context);
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, tbImageView) == null) {
            int g2 = l.g(this.f15404f, R.dimen.tbds44);
            if (UtilHelper.getRealScreenOrientation(this.f15404f) == 2) {
                k = l.i(this.f15404f);
            } else {
                k = l.k(this.f15404f);
            }
            int i2 = k - (g2 * 2);
            ViewGroup.LayoutParams layoutParams = this.f15405g.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = (i2 * 21) / 38;
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setRadius(l.g(this.f15404f, R.dimen.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
        }
    }

    private void setTextAttribute(List<TextView> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, list) == null) {
            for (TextView textView : list) {
                Drawable drawable = textView.getCompoundDrawables()[1];
                int g2 = l.g(this.f15404f, R.dimen.tbds78);
                drawable.setBounds(0, 0, g2, g2);
                textView.setCompoundDrawables(null, drawable, null, null);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            }
        }
    }

    public boolean a(PrivateForumPopInfoData privateForumPopInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, privateForumPopInfoData)) == null) {
            if (privateForumPopInfoData != null && privateForumPopInfoData.y() != null) {
                String str = privateForumPopInfoData.y() + "_" + privateForumPopInfoData.x();
                if (b.j().g(str, false)) {
                    return false;
                }
                b.j().t(str, true);
                if (privateForumPopInfoData.y().equals("task_complete")) {
                    this.k.setVisibility(0);
                    this.j.setVisibility(8);
                } else {
                    this.k.setVisibility(8);
                    this.j.setVisibility(0);
                }
                if (privateForumPopInfoData.y().equals("create_success")) {
                    this.f15406h.setVisibility(0);
                    this.f15406h.setText(R.string.frs_private_create_title);
                    this.j.setText(R.string.frs_private_create_button);
                    SkinManager.setImageResource(this.f15405g, R.drawable.pic_frs_private_create_success);
                } else if (privateForumPopInfoData.y().equals("left_time")) {
                    this.f15406h.setVisibility(8);
                    this.j.setText(R.string.frs_private_create_button);
                    SkinManager.setImageResource(this.f15405g, R.drawable.pic_frs_private_target_remind);
                } else if (privateForumPopInfoData.y().equals("clear_forum")) {
                    this.f15406h.setVisibility(8);
                    this.j.setText(R.string.frs_private_fail_button);
                    SkinManager.setImageResource(this.f15405g, R.drawable.pic_frs_private_target_fail);
                } else if (privateForumPopInfoData.y().equals("task_complete")) {
                    this.f15406h.setVisibility(0);
                    this.f15406h.setText(R.string.frs_private_success_title);
                    SkinManager.setImageResource(this.f15405g, R.drawable.pic_frs_private_target_success);
                }
                this.f15407i.setText(privateForumPopInfoData.w());
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_private_common);
            this.f15403e = linearLayout;
            this.f15405g = (TbImageView) linearLayout.findViewById(R.id.frs_private_common_image);
            this.f15406h = (TextView) this.f15403e.findViewById(R.id.frs_private_common_title);
            this.f15407i = (TextView) this.f15403e.findViewById(R.id.frs_private_common_hint);
            this.j = (TextView) this.f15403e.findViewById(R.id.frs_private_common_button);
            this.k = (RelativeLayout) this.f15403e.findViewById(R.id.frs_private_common_tips);
            this.l = (TextView) this.f15403e.findViewById(R.id.frs_private_center_tip);
            this.m = (TextView) this.f15403e.findViewById(R.id.frs_private_left_tip);
            this.n = (TextView) this.f15403e.findViewById(R.id.frs_private_right_tip);
            setImageAttribute(this.f15405g);
            setTextAttribute(Arrays.asList(this.l, this.m, this.n));
            SkinManager.setBackgroundResource(this.f15403e, R.drawable.bg_frs_private_dialog);
            SkinManager.setViewTextColor(this.f15406h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15407i, R.color.CAM_X0107);
            SkinManager.setBackgroundResourceSelector(this.j, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
        }
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.j.setOnClickListener(onClickListener);
    }
}
