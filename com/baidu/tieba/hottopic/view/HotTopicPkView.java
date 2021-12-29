package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.q1.b;
import c.a.t0.q1.c;
import c.a.t0.q1.d;
import c.a.t0.q1.l.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class HotTopicPkView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f46398e;

    /* renamed from: f  reason: collision with root package name */
    public int f46399f;

    /* renamed from: g  reason: collision with root package name */
    public int f46400g;

    /* renamed from: h  reason: collision with root package name */
    public int f46401h;

    /* renamed from: i  reason: collision with root package name */
    public int f46402i;

    /* renamed from: j  reason: collision with root package name */
    public int f46403j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f46404k;
    public Drawable l;
    public Drawable m;
    public int n;
    public int o;
    public int p;
    public int q;
    public RectF r;
    public RectF s;
    public Paint t;
    public i u;
    public HotTopicActivity v;
    public boolean w;
    public boolean x;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicPkView f46405e;

        public a(HotTopicPkView hotTopicPkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicPkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46405e = hotTopicPkView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (int i2 = 0; i2 < 4; i2++) {
                    this.f46405e.postInvalidate();
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
                this.f46405e.w = false;
                this.f46405e.postInvalidate();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicPkView(Context context, AttributeSet attributeSet, int i2) {
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
        this.w = false;
        this.x = false;
        f(context);
    }

    public final void b(Canvas canvas) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            i iVar = this.u;
            if (iVar.f22158h == 0 && iVar.f22160j == 0) {
                this.f46402i = (int) ((this.f46401h * 0.5d) + this.n + 50.0d);
            } else {
                i iVar2 = this.u;
                long j2 = iVar2.f22158h;
                this.f46402i = (int) (((((float) j2) / ((float) (j2 + iVar2.f22160j))) * this.f46401h) + this.n + 50.0f);
            }
            if (this.u.f22161k == 2) {
                this.t.setColor(SkinManager.getColor(b.topic_pk_agree_disable));
            } else {
                this.t.setColor(SkinManager.getColor(b.CAM_X0308));
            }
            canvas.drawRect(this.n / 2.0f, this.f46403j, this.f46402i, this.f46398e - i2, this.t);
            if (this.u.f22161k == 1) {
                this.t.setColor(SkinManager.getColor(b.topic_pk_oppose_disable));
            } else {
                this.t.setColor(SkinManager.getColor(b.CAM_X0302));
            }
            canvas.drawRect(this.f46402i, this.f46403j, this.f46400g - (this.n / 2.0f), this.f46398e - i3, this.t);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            Drawable drawable = SkinManager.getDrawable(d.icon_pic_vs);
            this.m = drawable;
            if (this.w) {
                if (this.x) {
                    int i2 = this.f46402i;
                    int i3 = this.p;
                    int i4 = this.f46403j;
                    drawable.setBounds((i2 - (i3 / 2)) - 3, i4, ((i2 - (i3 / 2)) - 3) + i3, this.q + i4);
                    this.m.draw(canvas);
                } else {
                    int i5 = this.f46402i;
                    int i6 = this.p;
                    int i7 = this.f46403j;
                    drawable.setBounds((i5 - (i6 / 2)) + 3, i7, (i5 - (i6 / 2)) + 3 + i6, this.q + i7);
                    this.m.draw(canvas);
                }
                this.x = !this.x;
                return;
            }
            int i8 = this.f46402i;
            int i9 = this.p;
            int i10 = this.f46403j;
            drawable.setBounds(i8 - (i9 / 2), i10, (i8 - (i9 / 2)) + i9, this.q + i10);
            this.m.draw(canvas);
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            g();
            this.f46404k.setBounds(0, 0, this.n, this.o);
            this.f46404k.draw(canvas);
            Drawable drawable = this.l;
            int i2 = this.f46400g;
            drawable.setBounds(i2 - this.n, 0, i2, this.o);
            this.l.draw(canvas);
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(c.ds25);
            this.t.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(c.fontsize28));
            if (this.u.f22161k == 2) {
                this.t.setColor(SkinManager.getColor(b.topic_pk_agree_disable));
            } else {
                this.t.setColor(SkinManager.getColor(b.CAM_X0308));
            }
            canvas.drawText(StringHelper.numberUniformFormat(this.u.f22158h), this.n, this.f46398e + dimensionPixelSize, this.t);
            if (this.u.f22161k == 1) {
                this.t.setColor(SkinManager.getColor(b.topic_pk_oppose_disable));
            } else {
                this.t.setColor(SkinManager.getColor(b.CAM_X0302));
            }
            canvas.drawText(StringHelper.numberUniformFormat(this.u.f22160j), (this.f46400g - this.n) - ((int) this.t.measureText(StringHelper.numberUniformFormat(this.u.f22160j))), this.f46398e + dimensionPixelSize, this.t);
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            Paint paint = new Paint();
            this.t = paint;
            paint.setAntiAlias(true);
            this.t.setDither(true);
            this.t.setFilterBitmap(true);
            this.f46399f = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(c.ds30);
            g();
            this.m = SkinManager.getDrawable(d.icon_pic_vs);
            this.n = this.f46404k.getIntrinsicWidth();
            this.o = this.f46404k.getIntrinsicHeight();
            this.p = this.m.getIntrinsicWidth();
            this.q = this.m.getIntrinsicHeight();
            this.r = new RectF(0.0f, 0.0f, this.n, this.o);
            this.f46403j = (this.o - this.q) / 2;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i iVar = this.u;
            if (iVar == null) {
                this.f46404k = SkinManager.getDrawable(d.icon_pk_red_n);
                this.l = SkinManager.getDrawable(d.icon_pk_blule_n);
                return;
            }
            int i2 = iVar.f22161k;
            if (i2 == 1) {
                this.f46404k = SkinManager.getDrawable(d.icon_pk_red_s);
                this.l = SkinManager.getDrawable(d.icon_pk_blule_d);
            } else if (i2 == 2) {
                this.l = SkinManager.getDrawable(d.icon_pk_blule_s);
                this.f46404k = SkinManager.getDrawable(d.icon_pk_red_d);
            } else {
                this.f46404k = SkinManager.getDrawable(d.icon_pk_red_n);
                this.l = SkinManager.getDrawable(d.icon_pk_blule_n);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            b(canvas);
            d(canvas);
            c(canvas);
            e(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f46398e = this.o;
            int size = View.MeasureSpec.getSize(i2);
            this.f46400g = size;
            setMeasuredDimension(size, this.f46398e + this.f46399f);
            this.f46401h = (this.f46400g - (this.n * 2)) - 100;
            if (this.s == null) {
                int i4 = this.f46400g;
                this.s = new RectF(i4 - this.n, 0.0f, i4, this.f46398e);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            if (this.u.f22161k != 0) {
                return true;
            }
            if (motionEvent.getAction() != 0) {
                return super.onTouchEvent(motionEvent);
            }
            if (this.r.contains(motionEvent.getX(), motionEvent.getY())) {
                i iVar = this.u;
                iVar.f22158h++;
                iVar.f22161k = 1;
            } else if (this.s.contains(motionEvent.getX(), motionEvent.getY())) {
                i iVar2 = this.u;
                iVar2.f22160j++;
                iVar2.f22161k = 2;
            }
            g();
            i iVar3 = this.u;
            if (iVar3.f22161k != 0) {
                if (iVar3.f22158h + iVar3.f22160j > 50) {
                    this.w = true;
                    new Thread(new a(this)).start();
                } else {
                    invalidate();
                }
                this.v.sendPkData();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, iVar, hotTopicActivity) == null) || iVar == null || hotTopicActivity == null) {
            return;
        }
        this.u = iVar;
        this.v = hotTopicActivity;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicPkView(Context context, AttributeSet attributeSet) {
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
        this.w = false;
        this.x = false;
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicPkView(Context context) {
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
        this.w = false;
        this.x = false;
        f(context);
    }
}
