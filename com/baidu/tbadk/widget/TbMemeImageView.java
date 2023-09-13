package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pb a;
    public Bitmap b;
    public int c;
    public BdImage d;
    public boolean e;
    public Drawable f;
    public Drawable g;
    public String h;
    public View.OnClickListener i;
    public final Handler j;
    public BdResourceCallback<BdImage> k;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbMemeImageView a;

        public a(TbMemeImageView tbMemeImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbMemeImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbMemeImageView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            pb gif;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.a.getGif()) != null && message.what == 1) {
                TbMemeImageView.c(this.a, 1);
                if (this.a.c >= gif.getFrameCount()) {
                    this.a.c = 0;
                }
                gif.c(this.a.c);
                gif.a(this.a.b, null);
                this.a.invalidate();
                this.a.j.removeMessages(1);
                this.a.j.sendEmptyMessageDelayed(1, gif.b(this.a.c));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbMemeImageView a;

        public b(TbMemeImageView tbMemeImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbMemeImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbMemeImageView;
        }

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                BdResourceLoader.getInstance().cancelLoad(str, 33);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdImage, str, i) == null) && bdImage != null) {
                this.a.i(bdImage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMemeImageView(Context context) {
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
        this.e = true;
        this.f = SkinManager.getDrawable(R.color.common_color_10220);
        this.g = SkinManager.getDrawable(R.drawable.icon_click);
        this.j = new a(this);
        this.k = new b(this);
        f();
    }

    public void setHasNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z && (this.f != null || this.g != null)) {
                int intrinsicWidth = this.f.getIntrinsicWidth();
                int intrinsicHeight = this.f.getIntrinsicHeight();
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (intrinsicWidth > measuredWidth) {
                    intrinsicWidth = measuredWidth;
                }
                if (intrinsicHeight > measuredHeight) {
                    intrinsicHeight = measuredHeight;
                }
                int paddingLeft = ((measuredWidth - intrinsicWidth) / 2) + getPaddingLeft();
                int paddingTop = ((measuredHeight - intrinsicHeight) / 2) + getPaddingTop();
                this.f.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMemeImageView(Context context, AttributeSet attributeSet) {
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
        this.e = true;
        this.f = SkinManager.getDrawable(R.color.common_color_10220);
        this.g = SkinManager.getDrawable(R.drawable.icon_click);
        this.j = new a(this);
        this.k = new b(this);
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMemeImageView(Context context, AttributeSet attributeSet, int i) {
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
        this.e = true;
        this.f = SkinManager.getDrawable(R.color.common_color_10220);
        this.g = SkinManager.getDrawable(R.drawable.icon_click);
        this.j = new a(this);
        this.k = new b(this);
        f();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (this.a == null) {
                return;
            }
            if (i != 4 && i != 8) {
                if (i == 0) {
                    g();
                    return;
                }
                return;
            }
            j();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            if (!isClickable()) {
                setClickable(true);
            }
            super.setOnClickListener(this);
            this.i = onClickListener;
        }
    }

    public static /* synthetic */ int c(TbMemeImageView tbMemeImageView, int i) {
        int i2 = tbMemeImageView.c + i;
        tbMemeImageView.c = i2;
        return i2;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setBackgroundDrawable(this.f);
            setOnClickListener(null);
        }
    }

    public BdImage getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (BdImage) invokeV.objValue;
    }

    public pb getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            pb pbVar = this.a;
            if (pbVar == null) {
                return null;
            }
            return pbVar;
        }
        return (pb) invokeV.objValue;
    }

    public void h() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (handler = this.j) != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || getGif() == null) {
            return;
        }
        this.j.removeMessages(1);
    }

    public void g() {
        pb gif;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (gif = getGif()) == null) {
            return;
        }
        if (this.c != 0) {
            this.c = 0;
        }
        gif.c(0);
        this.j.removeMessages(1);
        this.j.sendEmptyMessageDelayed(1, gif.b(this.c));
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            this.j.removeMessages(1);
            pb pbVar = this.a;
            if (pbVar != null) {
                pbVar.close();
                this.a = null;
            }
            if (this.d != null) {
                this.d = null;
            }
            Bitmap bitmap = this.b;
            if (bitmap != null) {
                bitmap.recycle();
                this.b = null;
            }
            this.c = 0;
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStartTemporaryDetach();
            this.j.removeMessages(1);
            pb pbVar = this.a;
            if (pbVar != null) {
                pbVar.close();
                this.a = null;
            }
            if (this.d != null) {
                this.d = null;
            }
            Bitmap bitmap = this.b;
            if (bitmap != null) {
                bitmap.recycle();
                this.b = null;
            }
            this.c = 0;
        }
    }

    public void i(BdImage bdImage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, bdImage) != null) || bdImage == null) {
            return;
        }
        this.d = bdImage;
        if (bdImage.isGif() && bdImage.getByteData() != null && bdImage.getByteData().length > 0) {
            NSGif f = NSGif.f(bdImage.getByteData(), 0, bdImage.getByteData().length);
            if (f == null) {
                return;
            }
            this.a = f;
            f.c(0);
            Bitmap bitmap = this.b;
            if (bitmap == null || (bitmap.getWidth() != this.a.getWidth() && this.b.getHeight() != this.a.getHeight())) {
                this.b = Bitmap.createBitmap(this.a.getWidth(), this.a.getHeight(), Bitmap.Config.ARGB_4444);
            }
            this.a.a(this.b, null);
            setImageBitmap(this.b);
            g();
        } else if (bdImage.getRawBitmap() != null) {
            setImageBitmap(bdImage.getRawBitmap());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (this.d == null && this.e) {
                BdResourceLoader.getInstance().loadResource(this.h, 33, this.k, 0, 0, false, null, new Object[0]);
                return;
            }
            View.OnClickListener onClickListener = this.i;
            if (onClickListener != null) {
                onClickListener.onClick(this);
            }
        }
    }
}
