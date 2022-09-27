package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class EmotionFloatView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GifView a;
    public TextView b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmotionFloatView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0252, (ViewGroup) this, true);
            this.a = (GifView) findViewById(R.id.obfuscated_res_0x7f0908d9);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f09078a);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.b.setVisibility(z ? 0 : 8);
        }
    }

    public void c(GifInfo gifInfo) {
        GifView gifView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gifInfo) == null) || (gifView = this.a) == null) {
            return;
        }
        gifView.i0(gifInfo);
    }

    public void setBackGroundFloat(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 1) {
                setBackgroundDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094b, SkinManager.getColor(R.color.CAM_X0208), WebPManager.ResourceStateType.NORMAL));
            } else if (i == 2) {
                setBackgroundDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094c, SkinManager.getColor(R.color.CAM_X0208), WebPManager.ResourceStateType.NORMAL));
            } else if (i == 3) {
                setBackgroundDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094a, SkinManager.getColor(R.color.CAM_X0208), WebPManager.ResourceStateType.NORMAL));
            }
        }
    }

    public void setDeleteBottomListener(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (textView = this.b) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void setDeleteBottomVisible(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (textView = this.b) == null) {
            return;
        }
        textView.setVisibility(i);
    }

    public void setEmotionViewTag(Object obj) {
        GifView gifView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, obj) == null) || (gifView = this.a) == null) {
            return;
        }
        gifView.setTag(obj);
    }

    public void setShowStaticDrawable(boolean z) {
        GifView gifView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (gifView = this.a) == null) {
            return;
        }
        gifView.setShowStaticDrawable(z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmotionFloatView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionFloatView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }
}
