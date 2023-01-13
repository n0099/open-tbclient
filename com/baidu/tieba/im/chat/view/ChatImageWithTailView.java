package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.cx4;
import com.baidu.tieba.w95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ChatImageWithTailView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GifView a;
    public LinearLayout b;
    public TbImageView c;
    public TextView d;
    public LinearLayout e;
    public ImageView f;
    public TextView g;
    public boolean h;

    /* loaded from: classes4.dex */
    public class a implements w95 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatImageWithTailView a;

        @Override // com.baidu.tieba.w95
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public a(ChatImageWithTailView chatImageWithTailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatImageWithTailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatImageWithTailView;
        }

        @Override // com.baidu.tieba.w95
        public void onLoadFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.h) {
                this.a.a.setVisibility(8);
                this.a.e.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.w95
        public void onLoadSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.a.setVisibility(0);
                this.a.e.setVisibility(8);
            }
        }
    }

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
        this.h = true;
        d(context);
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
        this.h = true;
        d(context);
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.h = z;
        }
    }

    public void setErrorBgResId(int i) {
        GifView gifView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (gifView = this.a) != null) {
            gifView.setDefaultBgResource(i);
        }
    }

    public void setErrorResId(int i) {
        GifView gifView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (gifView = this.a) != null) {
            gifView.setErrorResid(i);
        }
    }

    public void setFromSource(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView) == null) {
            this.d = textView;
        }
    }

    public void setIcon(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbImageView) == null) {
            this.c = tbImageView;
        }
    }

    public void setImage(GifView gifView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gifView) == null) {
            this.a = gifView;
        }
    }

    public void setIsSupportNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.c.setAutoChangeStyle(z);
        }
    }

    public void setTail(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, linearLayout) == null) {
            this.b = linearLayout;
        }
    }

    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.chat_image_with_tail_item, this);
            GifView gifView = (GifView) findViewById(R.id.img_msgitem_image_new);
            this.a = gifView;
            gifView.setContentDescription(getContext().getString(R.string.editor_image));
            this.a.setDrawerType(1);
            this.a.setDefaultResource(SkinManager.getResourceId(R.drawable.icon_pic_im_image_default));
            this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0203));
            this.a.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.L_X01));
            this.a.setDrawBorder(true);
            this.a.setConrers(15);
            this.a.setRadiusById(R.string.J_X05);
            this.a.setShowStaticDrawable(false);
            this.a.setLoadCallback(new a(this));
            this.b = (LinearLayout) findViewById(R.id.small_tail);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.tail_icon);
            this.c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.tb_launcher_icon);
            this.c.setAutoChangeStyle(false);
            this.d = (TextView) findViewById(R.id.tail_game_from);
            this.e = (LinearLayout) findViewById(R.id.chat_img_error_holder);
            this.f = (ImageView) findViewById(R.id.ic_chat_img_error);
            this.g = (TextView) findViewById(R.id.tv_chat_img_error);
            cx4 d = cx4.d(this.e);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0205);
            WebPManager.setPureDrawable(this.f, R.drawable.icon_pure_im_image_failed, R.color.CAM_X0203, null);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0110);
        }
    }

    public TextView getFromSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (TextView) invokeV.objValue;
    }

    public TbImageView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (TbImageView) invokeV.objValue;
    }

    public GifView getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (GifView) invokeV.objValue;
    }

    public LinearLayout getTail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (LinearLayout) invokeV.objValue;
    }
}
