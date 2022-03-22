package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsShareCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public Context f32976b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f32977c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f32978d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32979e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f32980f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f32981g;

    /* renamed from: h  reason: collision with root package name */
    public ShareFromFrsMsgData f32982h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32976b = context;
        c(context);
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return m.cutString(str, 18) + this.f32976b.getString(R.string.obfuscated_res_0x7f0f063c);
        }
        return (String) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.setFocusable(true);
            this.a.setFocusableInTouchMode(true);
            this.a.requestFocus();
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d034f, this);
            setOrientation(1);
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091cb8);
            this.f32979e = (TextView) findViewById(R.id.obfuscated_res_0x7f090add);
            this.f32977c = (EditText) findViewById(R.id.obfuscated_res_0x7f0905fc);
            this.f32978d = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090ad9);
            this.f32981g = (TextView) findViewById(R.id.obfuscated_res_0x7f090adb);
            this.f32980f = (TextView) findViewById(R.id.obfuscated_res_0x7f090ade);
            SkinManager.setViewTextColor(this.f32979e, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f32977c, R.color.CAM_X0105, 2);
            this.f32977c.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.f32977c.setPadding(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5), 0, 0, 0);
            b();
        }
    }

    public void d(String str, boolean z) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) || (headImageView = this.f32978d) == null) {
            return;
        }
        headImageView.J(str, 15, false);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f32979e.setText(a(this.f32982h.getName()));
            BdLog.e("mData.getImageUrl()的图片URL" + this.f32982h.getImageUrl());
            this.f32978d.J(this.f32982h.getImageUrl(), 15, false);
            this.f32981g.setText(StringHelper.numFormatOver10000((long) this.f32982h.getMemberNum()));
            this.f32980f.setText(StringHelper.numFormatOver10000((long) this.f32982h.getPostNum()));
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f32977c : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            EditText editText = this.f32977c;
            if (editText != null) {
                return m.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, shareFromFrsMsgData) == null) {
            this.f32982h = shareFromFrsMsgData;
            e();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.f32978d.setPageId(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new LinearLayout.LayoutParams(-1, -2) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsShareCardView(Context context) {
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
        this.f32976b = context;
        c(context);
    }
}
