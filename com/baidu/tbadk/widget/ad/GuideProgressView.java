package com.baidu.tbadk.widget.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 >2\u00020\u0001:\u0001>B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0018\u0010/\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\fH\u0002J\b\u00101\u001a\u00020\fH\u0002J\b\u00102\u001a\u00020\fH\u0002J\u0018\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0006\u00105\u001a\u00020+J\u0010\u00106\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0014J\u0010\u00107\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00108\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u000e\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020\u0007J\u0010\u0010;\u001a\u00020+2\b\u0010<\u001a\u0004\u0018\u00010%J\u000e\u0010=\u001a\u00020+2\u0006\u0010:\u001a\u00020\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/baidu/tbadk/widget/ad/GuideProgressView;", "Landroid/view/View;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mArrowDstRect", "Landroid/graphics/Rect;", "mArrowIconBitmap", "Landroid/graphics/Bitmap;", "mArrowSrcRect", "mBgColor", "mBgPaint", "Landroid/graphics/Paint;", "mCompleteIconBitmap", "mCompleteIconDstRect", "mCompleteIconSrcRect", "mDownloadDstRect", "mDownloadIconBitmap", "mDownloadSrcRect", "mIconPaint", "mIsShowArrow", "", "getMIsShowArrow", "()Z", "setMIsShowArrow", "(Z)V", "mLeftIconType", "getMLeftIconType", "()I", "setMLeftIconType", "(I)V", "mProgress", "mText", "", "mTextColor", "mTextPaint", "Landroid/text/TextPaint;", "mTextSize", "drawArrowIcon", "", "canvas", "Landroid/graphics/Canvas;", "colorInt", "drawLeftIcon", "getArrowIconBitmap", "getCompleteIconBitmap", "getDownloadIconBitmap", "initView", "context", "onChangeSkin", "onDraw", "onDrawNormal", "onDrawProgress", "setProgress", "progress", "setText", "text", "updateProgress", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GuideProgressView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int t = 2131099740;
    public static final int u = 2131099648;
    public static final int v = 2131165320;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public TextPaint b;
    public Paint c;
    public int d;
    public int e;
    public int f;
    public Bitmap g;
    public Rect h;
    public Rect i;
    public Bitmap j;
    public Rect k;
    public Rect l;
    public Bitmap m;
    public Rect n;
    public Rect o;
    public int p;
    public boolean q;
    public int r;
    public String s;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuideProgressView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuideProgressView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-542809999, "Lcom/baidu/tbadk/widget/ad/GuideProgressView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-542809999, "Lcom/baidu/tbadk/widget/ad/GuideProgressView;");
                return;
            }
        }
        w = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
        x = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
        y = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        z = UtilHelper.getDimenPixelSize(R.dimen.tbds14);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuideProgressView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.a = new Paint(1);
        this.b = new TextPaint(1);
        this.c = new Paint(1);
        this.q = true;
        this.r = -1;
        this.s = "";
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        c(context, attributeSet);
        d();
    }

    public /* synthetic */ GuideProgressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final Bitmap getArrowIconBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.m == null) {
                this.m = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.icon_pure_arrow12_right);
            }
            Bitmap bitmap = this.m;
            Intrinsics.checkNotNull(bitmap);
            return bitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    private final Bitmap getCompleteIconBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.j == null) {
                this.j = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.icon_pure_image_ok_select17);
            }
            Bitmap bitmap = this.j;
            Intrinsics.checkNotNull(bitmap);
            return bitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    private final Bitmap getDownloadIconBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.g == null) {
                this.g = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.icon_pure_post_download16);
            }
            Bitmap bitmap = this.g;
            Intrinsics.checkNotNull(bitmap);
            return bitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = SkinManager.getColor(t);
            this.e = SkinManager.getColor(u);
            postInvalidate();
        }
    }

    public final boolean getMIsShowArrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public final int getMLeftIconType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public final void a(Canvas canvas, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, canvas, i) == null) && this.q) {
            Bitmap arrowIconBitmap = getArrowIconBitmap();
            if (this.n == null) {
                this.n = new Rect(0, 0, arrowIconBitmap.getWidth(), arrowIconBitmap.getHeight());
            }
            int width = getWidth() - x;
            int height = getHeight();
            int i2 = y;
            this.o = new Rect((getWidth() - x) - y, (getHeight() - y) / 2, width, ((height - i2) / 2) + i2);
            this.c.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            Rect rect = this.n;
            Rect rect2 = this.o;
            Intrinsics.checkNotNull(rect2);
            canvas.drawBitmap(arrowIconBitmap, rect, rect2, this.c);
        }
    }

    public final void b(Canvas canvas, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, i) == null) && (i2 = this.p) != 0) {
            if (i2 == 2) {
                Bitmap completeIconBitmap = getCompleteIconBitmap();
                if (this.k == null) {
                    this.k = new Rect(0, 0, completeIconBitmap.getWidth(), completeIconBitmap.getHeight());
                }
                if (this.l == null) {
                    int i3 = w;
                    int height = getHeight();
                    int i4 = y;
                    int i5 = w + i4;
                    int height2 = getHeight();
                    int i6 = y;
                    this.l = new Rect(i3, (height - i4) / 2, i5, ((height2 - i6) / 2) + i6);
                }
                this.c.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
                Rect rect = this.k;
                Rect rect2 = this.l;
                Intrinsics.checkNotNull(rect2);
                canvas.drawBitmap(completeIconBitmap, rect, rect2, this.c);
                return;
            }
            Bitmap downloadIconBitmap = getDownloadIconBitmap();
            if (this.h == null) {
                this.h = new Rect(0, 0, downloadIconBitmap.getWidth(), downloadIconBitmap.getHeight());
            }
            if (this.i == null) {
                int i7 = w;
                int height3 = getHeight();
                int i8 = y;
                int i9 = w + i8;
                int height4 = getHeight();
                int i10 = y;
                this.i = new Rect(i7, (height3 - i8) / 2, i9, ((height4 - i10) / 2) + i10);
            }
            this.c.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            Rect rect3 = this.h;
            Rect rect4 = this.i;
            Intrinsics.checkNotNull(rect4);
            canvas.drawBitmap(downloadIconBitmap, rect3, rect4, this.c);
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f = UtilHelper.getDimenPixelSize(v);
            this.d = SkinManager.getColor(t);
            this.e = SkinManager.getColor(u);
            this.b.setTextSize(this.f);
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            this.a.setColor(this.d);
            this.a.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.a);
            b(canvas, this.e);
            float f = 2;
            float measureText = w + (this.b.measureText(this.s) / f);
            if (this.p != 0) {
                measureText += y + z;
            }
            this.b.setColor(this.e);
            this.b.setStyle(Paint.Style.FILL);
            this.b.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
            float f2 = fontMetrics.top;
            canvas.drawText(this.s, measureText, ((getHeight() - f2) - fontMetrics.bottom) / f, this.b);
            a(canvas, this.e);
        }
    }

    public final void f(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            int width = (int) (getWidth() * (this.r / 100.0f));
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.a.setColor(this.d);
            this.a.setAlpha(51);
            this.a.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.a);
            b(canvas, this.d);
            float measureText = w + (this.b.measureText(this.s) / 2);
            if (this.p != 0) {
                measureText += y + z;
            }
            this.b.setColor(this.d);
            this.b.setStyle(Paint.Style.FILL);
            this.b.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
            float height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            canvas.drawText(this.s, measureText, height, this.b);
            a(canvas, this.d);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.a.setColor(this.d);
            this.a.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.a);
            b(canvas, this.e);
            this.b.setColor(this.e);
            this.b.setStyle(Paint.Style.FILL);
            this.b.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.s, measureText, height, this.b);
            a(canvas, this.e);
            canvas.restore();
        }
    }

    public final void g(int i) {
        int coerceAtMost;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i < 0) {
                coerceAtMost = -1;
            } else {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(i, 100);
            }
            this.r = coerceAtMost;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.CHINA;
            String string = TbadkCoreApplication.getInst().getString(R.string.guide_full_downloading);
            Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.st…g.guide_full_downloading)");
            String format = String.format(locale, string, Arrays.copyOf(new Object[]{Integer.valueOf(RangesKt___RangesKt.coerceAtLeast(this.r, 0))}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            this.s = format;
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (this.r > 0) {
                f(canvas);
            } else {
                e(canvas);
            }
        }
    }

    public final void setMIsShowArrow(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            this.q = z2;
        }
    }

    public final void setMLeftIconType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.p = i;
        }
    }

    public final void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.r = i;
        }
    }

    public final void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.s = str;
            postInvalidate();
        }
    }
}
