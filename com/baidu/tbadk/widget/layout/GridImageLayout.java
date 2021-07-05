package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
import d.a.r0.a0.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class GridImageLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView.g A;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.e.k.b<ImageView> f13388e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.e.k.b<GifView> f13389f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.r0.b1.m.a f13390g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<TbRichTextImageInfo> f13391h;

    /* renamed from: i  reason: collision with root package name */
    public int f13392i;
    public int j;
    public boolean k;
    public String l;
    public RectF m;
    public Bitmap n;
    public Paint o;
    public Paint p;
    public Paint q;
    public boolean r;
    public int s;
    public int t;
    public int u;
    public int[] v;
    public TbRichTextView.x w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public View.OnLongClickListener z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridImageLayout f13393e;

        public a(GridImageLayout gridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13393e = gridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f13393e.w != null && this.f13393e.f13391h != null) {
                    int indexOfChild = this.f13393e.indexOfChild(view);
                    if (view instanceof TbImageView) {
                        url = ((TbImageView) view).getUrl();
                    } else {
                        url = view instanceof GifView ? ((GifView) view).getUrl() : "";
                    }
                    this.f13393e.w.a(view, url, indexOfChild, this.f13393e.k, true);
                }
                if (this.f13393e.x != null) {
                    this.f13393e.x.onClick(view);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GridImageLayout f13394a;

        public b(GridImageLayout gridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13394a = gridImageLayout;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i2;
            float f2;
            float f3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            d.a.c.k.d.a m = c.k().m(d.h().g(tbImageView.getUrl(), this.f13394a.s));
            int i3 = 0;
            if (m != null) {
                i3 = m.r();
                i2 = m.m();
            } else {
                i2 = 0;
            }
            if (i3 == 0 || i2 == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            Matrix imageMatrix = tbImageView.getImageMatrix();
            if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i3 * height > width * i2) {
                    f2 = height;
                    f3 = i2;
                } else {
                    f2 = width;
                    f3 = i3;
                }
                float f4 = f2 / f3;
                imageMatrix.setScale(f4, f4);
                imageMatrix.postTranslate(0.0f, 0.0f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridImageLayout(Context context) {
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
        this.f13388e = null;
        this.f13389f = null;
        this.r = true;
        this.v = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.y = new a(this);
        this.A = new b(this);
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int childCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (k.isEmpty(this.l) || (childCount = getChildCount()) != 9) {
                return;
            }
            View childAt = getChildAt(childCount - 1);
            boolean z = childAt instanceof TbImageView;
            if (z || (childAt instanceof GifView)) {
                if (this.m == null) {
                    this.m = new RectF();
                }
                this.m.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                k(canvas, this.m, z ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f13391h = null;
        }
    }

    public final void g(int i2, TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, tbRichTextImageInfo) == null) || tbRichTextImageInfo == null || this.f13390g == null) {
            return;
        }
        d.a.c.e.k.b<GifView> bVar = this.f13389f;
        GifView b2 = bVar != null ? bVar.b() : null;
        if (b2 == null || b2.getParent() != null) {
            b2 = new GifView(getContext());
        }
        b2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        b2.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        b2.setBorderSurroundContent(true);
        b2.setDrawCorner(true);
        b2.setDrawBorder(true);
        b2.setRadiusById(R.string.J_X05);
        b2.setOnClickListener(this.y);
        View.OnLongClickListener onLongClickListener = this.z;
        if (onLongClickListener != null) {
            b2.setOnLongClickListener(onLongClickListener);
        }
        b2.setOnDrawListener(null);
        if (this.f13392i == 1) {
            b2.setPlaceHolder(3);
            b2.setScaleType(ImageView.ScaleType.MATRIX);
            b2.setOnDrawListener(this.A);
        } else {
            b2.setPlaceHolder(2);
            b2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        b2.setIsLongPic(tbRichTextImageInfo.E());
        if (i2 == 8 && !k.isEmpty(this.l)) {
            b2.setLongIconSupport(false);
            b2.setGifIconSupport(false);
        } else {
            b2.setLongIconSupport(true);
            b2.setGifIconSupport(true);
        }
        if (this.f13390g.q) {
            b2.setSupportNoImage(true);
        }
        b2.setDefaultNoImageDay(SkinManager.getResourceId(R.drawable.icon_click));
        String z = tbRichTextImageInfo.z();
        if (StringUtils.isNull(z)) {
            if (this.f13390g.c()) {
                z = this.f13390g.r ? tbRichTextImageInfo.w() : tbRichTextImageInfo.x();
            }
            if (StringUtils.isNull(z)) {
                z = this.f13390g.r ? tbRichTextImageInfo.y() : tbRichTextImageInfo.B();
            }
        }
        b2.setShowStaticDrawable(false);
        this.s = 38;
        b2.l0(z, 38);
        q(b2, i2);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || ListUtils.isEmpty(this.f13391h)) {
            return;
        }
        for (int i2 = 0; i2 < this.f13392i && i2 < 9; i2++) {
            TbRichTextImageInfo tbRichTextImageInfo = this.f13391h.get(i2);
            if (tbRichTextImageInfo != null) {
                int width = tbRichTextImageInfo.getWidth();
                int height = tbRichTextImageInfo.getHeight();
                if (width > 0 && height > 0) {
                    if (this.r && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.E()) {
                        g(i2, tbRichTextImageInfo);
                    } else {
                        j(i2, tbRichTextImageInfo);
                    }
                }
            }
        }
    }

    public final void i() {
        TbRichTextImageInfo tbRichTextImageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f13391h) || (tbRichTextImageInfo = this.f13391h.get(0)) == null) {
            return;
        }
        int width = tbRichTextImageInfo.getWidth();
        int height = tbRichTextImageInfo.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        if (this.r && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.E()) {
            g(0, tbRichTextImageInfo);
        } else {
            j(0, tbRichTextImageInfo);
        }
    }

    public final void j(int i2, TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048581, this, i2, tbRichTextImageInfo) == null) || tbRichTextImageInfo == null || this.f13390g == null) {
            return;
        }
        d.a.c.e.k.b<ImageView> bVar = this.f13388e;
        String str = null;
        ImageView b2 = bVar != null ? bVar.b() : null;
        if (b2 == null || b2.getParent() != null) {
            b2 = new TbImageView(getContext());
        }
        if (b2 instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) b2;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setRadiusById(R.string.J_X05);
            tbImageView.setOnClickListener(this.y);
            View.OnLongClickListener onLongClickListener = this.z;
            if (onLongClickListener != null) {
                tbImageView.setOnLongClickListener(onLongClickListener);
            }
            tbImageView.setOnDrawListener(null);
            if (this.f13392i == 1) {
                tbImageView.setPlaceHolder(3);
                tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                tbImageView.setOnDrawListener(this.A);
            } else {
                tbImageView.setPlaceHolder(2);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            tbImageView.setIsLongPic(tbRichTextImageInfo.E());
            if (i2 == 8 && !k.isEmpty(this.l)) {
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setLongIconSupport(true);
                tbImageView.setGifIconSupport(true);
            }
            if (this.f13390g.q) {
                tbImageView.setSupportNoImage(true);
            }
            if (!this.r) {
                str = tbRichTextImageInfo.B();
                String A = tbRichTextImageInfo.A();
                if (!TextUtils.isEmpty(A) && A.toLowerCase().contains(".gif")) {
                    tbImageView.setIsGifPic(true);
                } else {
                    tbImageView.setIsGifPic(false);
                }
                this.s = 13;
            } else {
                if (this.f13390g.c()) {
                    str = this.f13390g.r ? tbRichTextImageInfo.w() : tbRichTextImageInfo.x();
                }
                if (StringUtils.isNull(str)) {
                    str = this.f13390g.r ? tbRichTextImageInfo.y() : tbRichTextImageInfo.B();
                }
                this.s = this.f13390g.r ? 13 : 14;
            }
            tbImageView.M(str, this.s, false);
            if (!tbRichTextImageInfo.C()) {
                tbImageView.setAdjustViewBounds(false);
            }
            q(tbImageView, i2);
        }
    }

    public final void k(Canvas canvas, RectF rectF, float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, canvas, rectF, fArr) == null) || rectF == null) {
            return;
        }
        Bitmap bitmap = this.n;
        if (bitmap == null || bitmap.isRecycled()) {
            int i2 = (int) (rectF.right - rectF.left);
            int i3 = (int) (rectF.bottom - rectF.top);
            this.n = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(this.n);
            canvas2.drawARGB(0, 0, 0, 0);
            float f2 = i3;
            RectF rectF2 = new RectF(-fArr[0], 0.0f, i2, f2);
            this.o.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f2, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
            canvas2.drawPath(d.a.r0.r.u.d.a.a(rectF2, fArr), this.o);
        }
        canvas.drawBitmap(this.n, rectF.left, rectF.top, this.q);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
        int i4 = ((int) rectF.bottom) - dimenPixelSize;
        int measureText = (((int) rectF.right) - dimenPixelSize2) - ((int) this.p.measureText(this.l));
        float[] z = d.a.r0.r.u.a.z(R.array.S_O_X001);
        this.p.setShadowLayer(z[1], z[2], z[3], (int) z[0]);
        canvas.drawText(this.l, measureText, i4, this.p);
    }

    public final int l(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) {
            if (n(i2, i3)) {
                return this.v[(this.f13392i == 4 ? i2 * 2 : i2 * 3) + i3];
            }
            return -1;
        }
        return invokeII.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Paint paint = new Paint();
            this.o = paint;
            paint.setAntiAlias(true);
            this.o.setColor(-16777216);
            Paint paint2 = new Paint();
            this.q = paint2;
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.p = paint3;
            paint3.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.p.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
            this.p.setAntiAlias(true);
            Paint.FontMetrics fontMetrics = this.p.getFontMetrics();
            Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            float f2 = fontMetrics.ascent;
            float f3 = fontMetrics.top;
        }
    }

    public final boolean n(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            int i4 = this.f13392i;
            if (i4 == 4) {
                return i2 >= 0 && i2 < 2 && i3 >= 0 && i3 < 2;
            }
            return i2 >= 0 && i2 < 3 && i3 >= 0 && i3 < 3 && (i2 * 3) + i3 <= (i4 <= 9 ? i4 - 1 : 8);
        }
        return invokeII.booleanValue;
    }

    public final boolean o(ArrayList<TbRichTextImageInfo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, arrayList)) == null) ? ListUtils.equalList(this.f13391h, arrayList) : invokeL.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (getChildAt(i2) instanceof TbImageView) {
                    ((TbImageView) getChildAt(i2)).setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                }
            }
        }
    }

    public final void q(TbImageView tbImageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048588, this, tbImageView, i2) == null) || tbImageView == null || this.f13390g == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.t, this.u);
        t(tbImageView, i2, layoutParams);
        addView(tbImageView, layoutParams);
    }

    public final void r() {
        TbRichTextImageInfo tbRichTextImageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f13390g == null || ListUtils.isEmpty(this.f13391h) || (tbRichTextImageInfo = this.f13391h.get(0)) == null) {
            return;
        }
        int width = tbRichTextImageInfo.getWidth();
        int height = tbRichTextImageInfo.getHeight();
        if (height <= 0) {
            return;
        }
        float f2 = (width * 1.0f) / height;
        int i2 = this.f13390g.D;
        int i3 = this.j;
        int i4 = (i2 - (i3 * 2)) / 3;
        this.t = 0;
        this.u = 0;
        if (this.f13392i != 1) {
            this.t = i4;
            this.u = i4;
        } else if (f2 >= 2.0f) {
            this.t = (i4 * 2) + i3;
            this.u = (int) ((i4 * 1.5d) + i3);
        } else if (f2 <= 0.5d) {
            this.t = (int) ((i4 * 1.5d) + i3);
            this.u = (i4 * 2) + i3;
        } else {
            int i5 = i4 * 2;
            this.t = i5 + i3;
            int i6 = i5 + i3;
            this.u = i6;
            if (f2 > 0.0f && f2 < 1.0f) {
                this.t = (int) (i6 * f2);
            } else if (f2 >= 1.0f) {
                this.u = (int) (this.t / f2);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || ListUtils.isEmpty(this.f13391h)) {
            return;
        }
        removeAllViews();
        r();
        if (this.t <= 0 || this.u <= 0) {
            return;
        }
        if (this.f13392i == 1) {
            i();
        } else {
            h();
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void setCornerStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
        }
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || o(arrayList) || this.f13390g == null) {
            return;
        }
        this.f13391h = arrayList;
        int size = arrayList.size();
        this.f13392i = size;
        this.l = size > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.f13392i - 9)}) : "";
        s();
    }

    public void setIsHost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.k = z;
        }
    }

    public void setIsTransform(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    public void setLayoutStrategy(d.a.r0.b1.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            this.f13390g = aVar;
            if (aVar != null) {
                this.j = aVar.E;
            }
        }
    }

    public void setObjectPool(d.a.c.e.k.b<ImageView> bVar, d.a.c.e.k.b<GifView> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, bVar, bVar2) == null) {
            this.f13388e = bVar;
            this.f13389f = bVar2;
        }
    }

    public void setOnImageClickListener(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, xVar) == null) {
            this.w = xVar;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onLongClickListener) == null) {
            this.z = onLongClickListener;
        }
    }

    public void setSupportGifPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.r = z;
        }
    }

    public void setTransformStyle(ImageView imageView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, imageView, i2) == null) {
            int i3 = this.f13392i;
            if (i3 == 1) {
                u(imageView, 15);
            } else if (i3 == 2) {
                if (i2 == 0) {
                    u(imageView, 5);
                } else if (i2 == 1) {
                    u(imageView, 10);
                }
            } else if (i3 == 3) {
                if (i2 == 0) {
                    u(imageView, 5);
                } else if (i2 == 2) {
                    u(imageView, 10);
                }
            } else if (i3 == 4) {
                if (i2 == 0) {
                    u(imageView, 1);
                } else if (i2 == 1) {
                    u(imageView, 2);
                } else if (i2 == 2) {
                    u(imageView, 4);
                } else if (i2 == 3) {
                    u(imageView, 8);
                }
            } else if (i3 == 5) {
                if (i2 == 0) {
                    u(imageView, 1);
                } else if (i2 == 2) {
                    u(imageView, 2);
                } else if (i2 == 3) {
                    u(imageView, 4);
                }
            } else if (i3 == 6) {
                if (i2 == 0) {
                    u(imageView, 1);
                } else if (i2 == 2) {
                    u(imageView, 2);
                } else if (i2 == 3) {
                    u(imageView, 4);
                } else if (i2 == 5) {
                    u(imageView, 8);
                }
            } else if (i3 == 7 || i3 == 8) {
                if (i2 == 0) {
                    u(imageView, 1);
                } else if (i2 == 2) {
                    u(imageView, 2);
                } else if (i2 == 6) {
                    u(imageView, 4);
                }
            } else if (i3 < 9) {
                u(imageView, 15);
            } else if (i2 == 0) {
                u(imageView, 1);
            } else if (i2 == 2) {
                u(imageView, 2);
            } else if (i2 == 6) {
                u(imageView, 4);
            } else if (i2 == 8) {
                u(imageView, 8);
            }
        }
    }

    public final void t(ImageView imageView, int i2, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048602, this, imageView, i2, layoutParams) == null) || imageView == null || layoutParams == null) {
            return;
        }
        imageView.setId(this.v[i2]);
        int i3 = this.f13392i == 4 ? i2 / 2 : i2 / 3;
        int i4 = this.f13392i == 4 ? i2 % 2 : i2 % 3;
        int i5 = i3 - 1;
        int l = l(i3, i4 - 1);
        int l2 = l(i5, i4);
        if (l2 >= 0) {
            layoutParams.addRule(3, l2);
            layoutParams.topMargin = this.j;
        }
        if (l >= 0) {
            layoutParams.addRule(1, l);
            layoutParams.leftMargin = this.j;
        }
        setTransformStyle(imageView, i2);
    }

    public final void u(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, view, i2) == null) {
            if (view instanceof TbImageView) {
                ((TbImageView) view).setConrers(i2);
            } else {
                boolean z = view instanceof GifView;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridImageLayout(Context context, AttributeSet attributeSet) {
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
        this.f13388e = null;
        this.f13389f = null;
        this.r = true;
        this.v = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.y = new a(this);
        this.A = new b(this);
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridImageLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f13388e = null;
        this.f13389f = null;
        this.r = true;
        this.v = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.y = new a(this);
        this.A = new b(this);
        m();
    }
}
