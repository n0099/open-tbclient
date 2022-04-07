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
import com.repackage.oi;
import com.repackage.wt4;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public Context b;
    public TbImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public RelativeLayout g;
    public TextView h;
    public TextView i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPrivateCommonDialogView(Context context) {
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
        this.b = context;
        b(context);
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, tbImageView) == null) {
            int f = oi.f(this.b, R.dimen.tbds44);
            if (UtilHelper.getRealScreenOrientation(this.b) == 2) {
                k = oi.i(this.b);
            } else {
                k = oi.k(this.b);
            }
            int i = k - (f * 2);
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = (i * 21) / 38;
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setRadius(oi.f(this.b, R.dimen.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
        }
    }

    private void setTextAttribute(List<TextView> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, list) == null) {
            for (TextView textView : list) {
                Drawable drawable = textView.getCompoundDrawables()[1];
                int f = oi.f(this.b, R.dimen.tbds78);
                drawable.setBounds(0, 0, f, f);
                textView.setCompoundDrawables(null, drawable, null, null);
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
            }
        }
    }

    public boolean a(PrivateForumPopInfoData privateForumPopInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, privateForumPopInfoData)) == null) {
            if (privateForumPopInfoData != null && privateForumPopInfoData.A() != null) {
                String str = privateForumPopInfoData.A() + "_" + privateForumPopInfoData.z();
                if (wt4.k().h(str, false)) {
                    return false;
                }
                wt4.k().u(str, true);
                if (privateForumPopInfoData.A().equals("task_complete")) {
                    this.g.setVisibility(0);
                    this.f.setVisibility(8);
                } else {
                    this.g.setVisibility(8);
                    this.f.setVisibility(0);
                }
                if (privateForumPopInfoData.A().equals("create_success")) {
                    this.d.setVisibility(0);
                    this.d.setText(R.string.obfuscated_res_0x7f0f071b);
                    this.f.setText(R.string.obfuscated_res_0x7f0f0719);
                    SkinManager.setImageResource(this.c, R.drawable.obfuscated_res_0x7f080f0b);
                } else if (privateForumPopInfoData.A().equals("left_time")) {
                    this.d.setVisibility(8);
                    this.f.setText(R.string.obfuscated_res_0x7f0f0719);
                    SkinManager.setImageResource(this.c, R.drawable.obfuscated_res_0x7f080f0d);
                } else if (privateForumPopInfoData.A().equals("clear_forum")) {
                    this.d.setVisibility(8);
                    this.f.setText(R.string.obfuscated_res_0x7f0f071c);
                    SkinManager.setImageResource(this.c, R.drawable.obfuscated_res_0x7f080f0c);
                } else if (privateForumPopInfoData.A().equals("task_complete")) {
                    this.d.setVisibility(0);
                    this.d.setText(R.string.obfuscated_res_0x7f0f071f);
                    SkinManager.setImageResource(this.c, R.drawable.obfuscated_res_0x7f080f0e);
                }
                this.e.setText(privateForumPopInfoData.y());
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d034a, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090bb7);
            this.a = linearLayout;
            this.c = (TbImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090bba);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bbc);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bb9);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bb8);
            this.g = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090bbb);
            this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bb6);
            this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bbd);
            this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bbf);
            setImageAttribute(this.c);
            setTextAttribute(Arrays.asList(this.h, this.i, this.j));
            SkinManager.setBackgroundResource(this.a, R.drawable.bg_frs_private_dialog);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundResourceSelector(this.f, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
        }
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f.setOnClickListener(onClickListener);
    }
}
