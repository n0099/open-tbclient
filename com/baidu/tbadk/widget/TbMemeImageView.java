package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.l.c;
import c.a.d.f.l.d;
import com.baidu.adp.gif.NSGif;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.d.b a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f30747b;

    /* renamed from: c  reason: collision with root package name */
    public int f30748c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.d.o.d.a f30749d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30750e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f30751f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f30752g;

    /* renamed from: h  reason: collision with root package name */
    public String f30753h;
    public View.OnClickListener i;
    public TbRichTextView.w j;
    public final Handler k;
    public c<c.a.d.o.d.a> l;

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
            c.a.d.d.b gif;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.a.getGif()) != null && message.what == 1) {
                this.a.f30748c++;
                if (this.a.f30748c >= gif.getFrameCount()) {
                    this.a.f30748c = 0;
                }
                gif.c(this.a.f30748c);
                gif.a(this.a.f30747b, null);
                this.a.invalidate();
                this.a.k.removeMessages(1);
                this.a.k.sendEmptyMessageDelayed(1, gif.b(this.a.f30748c));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends c<c.a.d.o.d.a> {
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

        @Override // c.a.d.f.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.h().c(str, 33);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i) == null) || aVar == null) {
                return;
            }
            this.a.g(aVar);
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
        this.f30750e = true;
        this.f30751f = SkinManager.getDrawable(R.color.common_color_10220);
        this.f30752g = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080b75);
        new Rect();
        this.k = new a(this);
        this.l = new b(this);
        e();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            TbRichTextView.w wVar = this.j;
            if (wVar != null) {
                wVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setBackgroundDrawable(this.f30751f);
            setOnClickListener(null);
        }
    }

    public void f() {
        c.a.d.d.b gif;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gif = getGif()) == null) {
            return;
        }
        if (this.f30748c != 0) {
            this.f30748c = 0;
        }
        gif.c(0);
        this.k.removeMessages(1);
        this.k.sendEmptyMessageDelayed(1, gif.b(this.f30748c));
    }

    public void g(c.a.d.o.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f30749d = aVar;
        if (aVar.t() && aVar.k() != null && aVar.k().length > 0) {
            NSGif f2 = NSGif.f(aVar.k(), 0, aVar.k().length);
            if (f2 == null) {
                return;
            }
            this.a = f2;
            f2.c(0);
            Bitmap bitmap = this.f30747b;
            if (bitmap == null || (bitmap.getWidth() != this.a.getWidth() && this.f30747b.getHeight() != this.a.getHeight())) {
                this.f30747b = Bitmap.createBitmap(this.a.getWidth(), this.a.getHeight(), Bitmap.Config.ARGB_4444);
            }
            this.a.a(this.f30747b, null);
            setImageBitmap(this.f30747b);
            f();
        } else if (aVar.p() != null) {
            setImageBitmap(aVar.p());
        }
    }

    public c.a.d.o.d.a getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30749d : (c.a.d.o.d.a) invokeV.objValue;
    }

    public c.a.d.d.b getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.d.d.b bVar = this.a;
            if (bVar == null) {
                return null;
            }
            return bVar;
        }
        return (c.a.d.d.b) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getGif() == null) {
            return;
        }
        this.k.removeMessages(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if (this.f30749d == null && this.f30750e) {
                d.h().l(this.f30753h, 33, this.l, 0, 0, false, null, new Object[0]);
                return;
            }
            View.OnClickListener onClickListener = this.i;
            if (onClickListener != null) {
                onClickListener.onClick(this);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            this.k.removeMessages(1);
            c.a.d.d.b bVar = this.a;
            if (bVar != null) {
                bVar.close();
                this.a = null;
            }
            if (this.f30749d != null) {
                this.f30749d = null;
            }
            Bitmap bitmap = this.f30747b;
            if (bitmap != null) {
                bitmap.recycle();
                this.f30747b = null;
            }
            this.f30748c = 0;
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStartTemporaryDetach();
            this.k.removeMessages(1);
            c.a.d.d.b bVar = this.a;
            if (bVar != null) {
                bVar.close();
                this.a = null;
            }
            if (this.f30749d != null) {
                this.f30749d = null;
            }
            Bitmap bitmap = this.f30747b;
            if (bitmap != null) {
                bitmap.recycle();
                this.f30747b = null;
            }
            this.f30748c = 0;
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (this.a == null) {
                return;
            }
            if (i == 4 || i == 8) {
                h();
            } else if (i == 0) {
                f();
            }
        }
    }

    public void setDispatchTouchListener(TbRichTextView.w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, wVar) == null) {
            this.j = wVar;
        }
    }

    public void setHasNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z && (this.f30751f != null || this.f30752g != null)) {
                int intrinsicWidth = this.f30751f.getIntrinsicWidth();
                int intrinsicHeight = this.f30751f.getIntrinsicHeight();
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
                this.f30751f.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
            invalidate();
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

    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f30750e = z;
        }
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
        this.f30750e = true;
        this.f30751f = SkinManager.getDrawable(R.color.common_color_10220);
        this.f30752g = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080b75);
        new Rect();
        this.k = new a(this);
        this.l = new b(this);
        e();
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
        this.f30750e = true;
        this.f30751f = SkinManager.getDrawable(R.color.common_color_10220);
        this.f30752g = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080b75);
        new Rect();
        this.k = new a(this);
        this.l = new b(this);
        e();
    }
}
