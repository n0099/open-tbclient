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
/* loaded from: classes9.dex */
public class ChatImageWithTailView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ChatClipImageItemView f50335e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f50336f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f50337g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50338h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatImageWithTailView(Context context) {
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
        initUI(context);
    }

    public TextView getFromSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50338h : (TextView) invokeV.objValue;
    }

    public TbImageView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50337g : (TbImageView) invokeV.objValue;
    }

    public ChatClipImageItemView getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50335e : (ChatClipImageItemView) invokeV.objValue;
    }

    public LinearLayout getTail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f50336f : (LinearLayout) invokeV.objValue;
    }

    public void initUI(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.chat_image_with_tail_item, this);
            ChatClipImageItemView chatClipImageItemView = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
            this.f50335e = chatClipImageItemView;
            chatClipImageItemView.setContentDescription(getContext().getString(R.string.editor_image));
            this.f50335e.setDefaultResource(R.drawable.pic_image_h_not);
            this.f50336f = (LinearLayout) findViewById(R.id.small_tail);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.tail_icon);
            this.f50337g = tbImageView;
            tbImageView.setDefaultResource(R.drawable.tb_launcher_icon);
            this.f50337g.setAutoChangeStyle(false);
            this.f50338h = (TextView) findViewById(R.id.tail_game_from);
        }
    }

    public void setFromSource(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, textView) == null) {
            this.f50338h = textView;
        }
    }

    public void setIcon(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbImageView) == null) {
            this.f50337g = tbImageView;
        }
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, chatClipImageItemView) == null) {
            this.f50335e = chatClipImageItemView;
        }
    }

    public void setIsSupportNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f50337g.setAutoChangeStyle(z);
        }
    }

    public void setTail(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, linearLayout) == null) {
            this.f50336f = linearLayout;
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
        initUI(context);
    }
}
