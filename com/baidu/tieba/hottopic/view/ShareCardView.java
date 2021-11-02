package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.r0.j1.b;
import b.a.r0.j1.c;
import b.a.r0.j1.e;
import b.a.r0.j1.f;
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
/* loaded from: classes9.dex */
public class ShareCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f50083e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f50084f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f50085g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50086h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f50087i;
    public ShareFromTopicMsgData j;

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
            this.f50083e = (LinearLayout) findViewById(e.share_content);
            this.f50087i = (TextView) findViewById(e.share_title_view);
            this.f50084f = (EditText) findViewById(e.chat_msg);
            this.f50085g = (TbImageView) findViewById(e.chat_group_img);
            this.f50086h = (TextView) findViewById(e.chat_group_desc);
            SkinManager.setViewTextColor(this.f50087i, b.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f50084f, b.CAM_X0105, 2);
            SkinManager.setViewTextColor(this.f50086h, b.CAM_X0106, 1);
            this.f50084f.setHintTextColor(SkinManager.getColor(b.CAM_X0110));
            this.f50084f.setPadding(context.getResources().getDimensionPixelSize(c.ds20), 0, 0, 0);
            hideEditTextCursor();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f50087i.setText(this.j.getTitle());
            BdLog.e("mData.getImageUrl()的图片URL" + this.j.getImageUrl());
            this.f50085g.setTag(this.j.getImageUrl());
            BdLog.e("mData.getContent()的Content" + this.j.getContent());
            this.f50086h.setText(this.j.getContent());
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50084f : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            EditText editText = this.f50084f;
            if (editText != null) {
                return k.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void hideEditTextCursor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f50083e.setFocusable(true);
            this.f50083e.setFocusableInTouchMode(true);
            this.f50083e.requestFocus();
        }
    }

    public void loadImageIcon(String str, boolean z) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) || (tbImageView = this.f50085g) == null) {
            return;
        }
        tbImageView.startLoad(str, z ? 17 : 18, false);
    }

    public void setData(ShareFromTopicMsgData shareFromTopicMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareFromTopicMsgData) == null) {
            this.j = shareFromTopicMsgData;
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
