package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ChatImageWithTailView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChatClipImageItemView a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f33770b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f33771c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33772d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatImageWithTailView(Context context) {
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
        a(context);
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01d9, this);
            ChatClipImageItemView chatClipImageItemView = (ChatClipImageItemView) findViewById(R.id.obfuscated_res_0x7f090ec2);
            this.a = chatClipImageItemView;
            chatClipImageItemView.setContentDescription(getContext().getString(R.string.obfuscated_res_0x7f0f051b));
            this.a.setDefaultResource(R.drawable.pic_image_h_not);
            this.f33770b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091d33);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091edd);
            this.f33771c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081833);
            this.f33771c.setAutoChangeStyle(false);
            this.f33772d = (TextView) findViewById(R.id.obfuscated_res_0x7f091edc);
        }
    }

    public TextView getFromSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33772d : (TextView) invokeV.objValue;
    }

    public TbImageView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33771c : (TbImageView) invokeV.objValue;
    }

    public ChatClipImageItemView getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (ChatClipImageItemView) invokeV.objValue;
    }

    public LinearLayout getTail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33770b : (LinearLayout) invokeV.objValue;
    }

    public void setFromSource(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, textView) == null) {
            this.f33772d = textView;
        }
    }

    public void setIcon(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbImageView) == null) {
            this.f33771c = tbImageView;
        }
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, chatClipImageItemView) == null) {
            this.a = chatClipImageItemView;
        }
    }

    public void setIsSupportNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f33771c.setAutoChangeStyle(z);
        }
    }

    public void setTail(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, linearLayout) == null) {
            this.f33770b = linearLayout;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
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
        a(context);
    }
}
