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
import d.a.c.e.l.c;
import d.a.c.e.l.d;
/* loaded from: classes3.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.d.b f13298e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f13299f;

    /* renamed from: g  reason: collision with root package name */
    public int f13300g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.k.d.a f13301h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13302i;
    public Drawable j;
    public Drawable k;
    public String l;
    public View.OnClickListener m;
    public TbRichTextView.v n;
    public final Handler o;
    public c<d.a.c.k.d.a> p;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbMemeImageView f13303a;

        public a(TbMemeImageView tbMemeImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbMemeImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13303a = tbMemeImageView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d.a.c.d.b gif;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.f13303a.getGif()) != null && message.what == 1) {
                this.f13303a.f13300g++;
                if (this.f13303a.f13300g >= gif.getFrameCount()) {
                    this.f13303a.f13300g = 0;
                }
                gif.c(this.f13303a.f13300g);
                gif.a(this.f13303a.f13299f, null);
                this.f13303a.invalidate();
                this.f13303a.o.removeMessages(1);
                this.f13303a.o.sendEmptyMessageDelayed(1, gif.b(this.f13303a.f13300g));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c<d.a.c.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbMemeImageView f13304a;

        public b(TbMemeImageView tbMemeImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbMemeImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13304a = tbMemeImageView;
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.h().c(str, 33);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            this.f13304a.g(aVar);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13302i = true;
        this.j = SkinManager.getDrawable(R.color.common_color_10220);
        this.k = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.img_default_100);
        new Rect();
        this.o = new a(this);
        this.p = new b(this);
        e();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            TbRichTextView.v vVar = this.n;
            if (vVar != null) {
                vVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setBackgroundDrawable(this.j);
            setOnClickListener(null);
        }
    }

    public void f() {
        d.a.c.d.b gif;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gif = getGif()) == null) {
            return;
        }
        if (this.f13300g != 0) {
            this.f13300g = 0;
        }
        gif.c(0);
        this.o.removeMessages(1);
        this.o.sendEmptyMessageDelayed(1, gif.b(this.f13300g));
    }

    public void g(d.a.c.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f13301h = aVar;
        if (aVar.t() && aVar.k() != null && aVar.k().length > 0) {
            NSGif f2 = NSGif.f(aVar.k(), 0, aVar.k().length);
            if (f2 == null) {
                return;
            }
            this.f13298e = f2;
            f2.c(0);
            Bitmap bitmap = this.f13299f;
            if (bitmap == null || (bitmap.getWidth() != this.f13298e.getWidth() && this.f13299f.getHeight() != this.f13298e.getHeight())) {
                this.f13299f = Bitmap.createBitmap(this.f13298e.getWidth(), this.f13298e.getHeight(), Bitmap.Config.ARGB_4444);
            }
            this.f13298e.a(this.f13299f, null);
            setImageBitmap(this.f13299f);
            f();
        } else if (aVar.p() != null) {
            setImageBitmap(aVar.p());
        }
    }

    public d.a.c.k.d.a getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13301h : (d.a.c.k.d.a) invokeV.objValue;
    }

    public d.a.c.d.b getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.c.d.b bVar = this.f13298e;
            if (bVar == null) {
                return null;
            }
            return bVar;
        }
        return (d.a.c.d.b) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getGif() == null) {
            return;
        }
        this.o.removeMessages(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if (this.f13301h == null && this.f13302i) {
                d.h().l(this.l, 33, this.p, 0, 0, false, null, new Object[0]);
                return;
            }
            View.OnClickListener onClickListener = this.m;
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
            this.o.removeMessages(1);
            d.a.c.d.b bVar = this.f13298e;
            if (bVar != null) {
                bVar.close();
                this.f13298e = null;
            }
            if (this.f13301h != null) {
                this.f13301h = null;
            }
            Bitmap bitmap = this.f13299f;
            if (bitmap != null) {
                bitmap.recycle();
                this.f13299f = null;
            }
            this.f13300g = 0;
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStartTemporaryDetach();
            this.o.removeMessages(1);
            d.a.c.d.b bVar = this.f13298e;
            if (bVar != null) {
                bVar.close();
                this.f13298e = null;
            }
            if (this.f13301h != null) {
                this.f13301h = null;
            }
            Bitmap bitmap = this.f13299f;
            if (bitmap != null) {
                bitmap.recycle();
                this.f13299f = null;
            }
            this.f13300g = 0;
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (this.f13298e == null) {
                return;
            }
            if (i2 == 4 || i2 == 8) {
                h();
            } else if (i2 == 0) {
                f();
            }
        }
    }

    public void setDispatchTouchListener(TbRichTextView.v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, vVar) == null) {
            this.n = vVar;
        }
    }

    public void setHasNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z && (this.j != null || this.k != null)) {
                int intrinsicWidth = this.j.getIntrinsicWidth();
                int intrinsicHeight = this.j.getIntrinsicHeight();
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
                this.j.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
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
            this.m = onClickListener;
        }
    }

    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f13302i = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMemeImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f13302i = true;
        this.j = SkinManager.getDrawable(R.color.common_color_10220);
        this.k = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.img_default_100);
        new Rect();
        this.o = new a(this);
        this.p = new b(this);
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
        this.f13302i = true;
        this.j = SkinManager.getDrawable(R.color.common_color_10220);
        this.k = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.img_default_100);
        new Rect();
        this.o = new a(this);
        this.p = new b(this);
        e();
    }
}
