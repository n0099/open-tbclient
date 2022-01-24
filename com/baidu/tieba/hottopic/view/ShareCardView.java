package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.t0.r1.b;
import c.a.t0.r1.c;
import c.a.t0.r1.e;
import c.a.t0.r1.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class ShareCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f44749e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f44750f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f44751g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44752h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44753i;

    /* renamed from: j  reason: collision with root package name */
    public ShareFromTopicMsgData f44754j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(f.thread_to_group_share_view, this);
            setOrientation(1);
            this.f44749e = (LinearLayout) findViewById(e.share_content);
            this.f44753i = (TextView) findViewById(e.share_title_view);
            this.f44750f = (EditText) findViewById(e.chat_msg);
            this.f44751g = (TbImageView) findViewById(e.chat_group_img);
            this.f44752h = (TextView) findViewById(e.chat_group_desc);
            SkinManager.setViewTextColor(this.f44753i, b.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f44750f, b.CAM_X0105, 2);
            SkinManager.setViewTextColor(this.f44752h, b.CAM_X0106, 1);
            this.f44750f.setHintTextColor(SkinManager.getColor(b.CAM_X0110));
            this.f44750f.setPadding(context.getResources().getDimensionPixelSize(c.ds20), 0, 0, 0);
            hideEditTextCursor();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f44753i.setText(this.f44754j.getTitle());
            BdLog.e("mData.getImageUrl()的图片URL" + this.f44754j.getImageUrl());
            this.f44751g.setTag(this.f44754j.getImageUrl());
            BdLog.e("mData.getContent()的Content" + this.f44754j.getContent());
            this.f44752h.setText(this.f44754j.getContent());
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f44750f : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            EditText editText = this.f44750f;
            if (editText != null) {
                return m.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void hideEditTextCursor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f44749e.setFocusable(true);
            this.f44749e.setFocusableInTouchMode(true);
            this.f44749e.requestFocus();
        }
    }

    public void loadImageIcon(String str, boolean z) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) || (tbImageView = this.f44751g) == null) {
            return;
        }
        tbImageView.startLoad(str, z ? 17 : 18, false);
    }

    public void setData(ShareFromTopicMsgData shareFromTopicMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareFromTopicMsgData) == null) {
            this.f44754j = shareFromTopicMsgData;
            b();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new LinearLayout.LayoutParams(-1, -2) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareCardView(Context context) {
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
        a(context);
    }
}
