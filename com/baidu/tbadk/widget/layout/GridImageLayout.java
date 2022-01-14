package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.l.d;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.c0.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
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
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class GridImageLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CORNER_STYLE_CARD = 1;
    public static final int CORNER_STYLE_DEFAULT = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.f.k.b<ImageView> f41345e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.f.k.b<GifView> f41346f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.g1.n.a f41347g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<TbRichTextImageInfo> f41348h;

    /* renamed from: i  reason: collision with root package name */
    public int f41349i;

    /* renamed from: j  reason: collision with root package name */
    public int f41350j;
    public boolean k;
    public String l;
    public RectF m;
    public Paint n;
    public Paint o;
    public Paint p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int[] u;
    public TbRichTextView.y v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public View.OnLongClickListener y;
    public TbImageView.h z;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridImageLayout f41351e;

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
            this.f41351e = gridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f41351e.v != null && this.f41351e.f41348h != null) {
                    int indexOfChild = this.f41351e.indexOfChild(view);
                    if (view instanceof TbImageView) {
                        url = ((TbImageView) view).getUrl();
                    } else {
                        url = view instanceof GifView ? ((GifView) view).getUrl() : "";
                    }
                    this.f41351e.v.a(view, url, indexOfChild, this.f41351e.k, true);
                }
                if (this.f41351e.w != null) {
                    this.f41351e.w.onClick(view);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GridImageLayout a;

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
            this.a = gridImageLayout;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i2;
            float f2;
            float f3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            c.a.d.n.d.a m = c.k().m(d.h().g(tbImageView.getUrl(), this.a.r));
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
        this.f41345e = null;
        this.f41346f = null;
        this.q = true;
        this.u = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.x = new a(this);
        this.z = new b(this);
        l();
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f41348h = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int childCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (m.isEmpty(this.l) || (childCount = getChildCount()) != 9) {
                return;
            }
            View childAt = getChildAt(childCount - 1);
            boolean z = childAt instanceof TbImageView;
            if (z || (childAt instanceof GifView)) {
                if (this.m == null) {
                    this.m = new RectF();
                }
                this.m.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (z) {
                    ((TbImageView) childAt).getRadius();
                } else {
                    ((GifView) childAt).getRadius();
                }
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !m.isEmpty(this.l) && getChildCount() == 9) {
            int f2 = n.f(getContext(), R.dimen.M_W_X003);
            int f3 = n.f(getContext(), R.dimen.M_W_X004);
            int f4 = n.f(getContext(), R.dimen.tbds52);
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            EMTextView eMTextView = new EMTextView(getContext());
            eMTextView.setPadding(f2, 0, f2, 0);
            eMTextView.setGravity(16);
            eMTextView.setText(this.l);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(eMTextView);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
            d2.A(R.string.F_X02);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0607);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, f4);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.rightMargin = f3;
            layoutParams.bottomMargin = f3;
            relativeLayout.addView(eMTextView, layoutParams);
            int i2 = this.s;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            addView(relativeLayout, layoutParams2);
        }
    }

    public final void g(int i2, TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, tbRichTextImageInfo) == null) || tbRichTextImageInfo == null || this.f41347g == null) {
            return;
        }
        c.a.d.f.k.b<GifView> bVar = this.f41346f;
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
        b2.setOnClickListener(this.x);
        View.OnLongClickListener onLongClickListener = this.y;
        if (onLongClickListener != null) {
            b2.setOnLongClickListener(onLongClickListener);
        }
        b2.setOnDrawListener(null);
        if (this.f41349i == 1) {
            b2.setPlaceHolder(3);
            b2.setScaleType(ImageView.ScaleType.MATRIX);
            b2.setOnDrawListener(this.z);
        } else {
            b2.setPlaceHolder(2);
            b2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        b2.setIsLongPic(tbRichTextImageInfo.E());
        if (i2 == 8 && !m.isEmpty(this.l)) {
            b2.setLongIconSupport(false);
            b2.setGifIconSupport(false);
        } else {
            b2.setLongIconSupport(true);
            b2.setGifIconSupport(true);
        }
        if (this.f41347g.q) {
            b2.setSupportNoImage(true);
        }
        b2.setDefaultNoImageDay(SkinManager.getResourceId(R.drawable.icon_click));
        String z = tbRichTextImageInfo.z();
        if (StringUtils.isNull(z)) {
            if (this.f41347g.c()) {
                z = this.f41347g.r ? tbRichTextImageInfo.w() : tbRichTextImageInfo.x();
            }
            if (StringUtils.isNull(z)) {
                z = this.f41347g.r ? tbRichTextImageInfo.y() : tbRichTextImageInfo.B();
            }
        }
        b2.setShowStaticDrawable(false);
        this.r = 38;
        b2.startLoad(z, 38);
        o(b2, i2);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f41348h)) {
            return;
        }
        for (int i2 = 0; i2 < this.f41349i && i2 < 9; i2++) {
            TbRichTextImageInfo tbRichTextImageInfo = this.f41348h.get(i2);
            if (tbRichTextImageInfo != null) {
                int width = tbRichTextImageInfo.getWidth();
                int height = tbRichTextImageInfo.getHeight();
                if (width > 0 && height > 0) {
                    if (this.q && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.E()) {
                        g(i2, tbRichTextImageInfo);
                    } else {
                        j(i2, tbRichTextImageInfo);
                    }
                }
            }
        }
        f();
    }

    public final void i() {
        TbRichTextImageInfo tbRichTextImageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ListUtils.isEmpty(this.f41348h) || (tbRichTextImageInfo = this.f41348h.get(0)) == null) {
            return;
        }
        int width = tbRichTextImageInfo.getWidth();
        int height = tbRichTextImageInfo.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        if (this.q && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.E()) {
            g(0, tbRichTextImageInfo);
        } else {
            j(0, tbRichTextImageInfo);
        }
    }

    public final void j(int i2, TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, tbRichTextImageInfo) == null) || tbRichTextImageInfo == null || this.f41347g == null) {
            return;
        }
        c.a.d.f.k.b<ImageView> bVar = this.f41345e;
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
            tbImageView.setOnClickListener(this.x);
            View.OnLongClickListener onLongClickListener = this.y;
            if (onLongClickListener != null) {
                tbImageView.setOnLongClickListener(onLongClickListener);
            }
            tbImageView.setOnDrawListener(null);
            if (this.f41349i == 1) {
                tbImageView.setPlaceHolder(3);
                tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                tbImageView.setOnDrawListener(this.z);
            } else {
                tbImageView.setPlaceHolder(2);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            tbImageView.setIsLongPic(tbRichTextImageInfo.E());
            if (i2 == 8 && !m.isEmpty(this.l)) {
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setLongIconSupport(true);
                tbImageView.setGifIconSupport(true);
            }
            if (this.f41347g.q) {
                tbImageView.setSupportNoImage(true);
            }
            if (!this.q) {
                str = tbRichTextImageInfo.B();
                String A = tbRichTextImageInfo.A();
                if (!TextUtils.isEmpty(A) && A.toLowerCase().contains(".gif")) {
                    tbImageView.setIsGifPic(true);
                } else {
                    tbImageView.setIsGifPic(false);
                }
                this.r = 13;
            } else {
                if (this.f41347g.c()) {
                    str = this.f41347g.r ? tbRichTextImageInfo.w() : tbRichTextImageInfo.x();
                }
                if (StringUtils.isNull(str)) {
                    str = this.f41347g.r ? tbRichTextImageInfo.y() : tbRichTextImageInfo.B();
                }
                this.r = this.f41347g.r ? 13 : 14;
            }
            tbImageView.startLoad(str, this.r, false);
            if (!tbRichTextImageInfo.C()) {
                tbImageView.setAdjustViewBounds(false);
            }
            o(tbImageView, i2);
        }
    }

    public final int k(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) {
            if (m(i2, i3)) {
                return this.u[(this.f41349i == 4 ? i2 * 2 : i2 * 3) + i3];
            }
            return -1;
        }
        return invokeII.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Paint paint = new Paint();
            this.n = paint;
            paint.setAntiAlias(true);
            this.n.setColor(-16777216);
            Paint paint2 = new Paint();
            this.p = paint2;
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.o = paint3;
            paint3.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.o.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
            this.o.setAntiAlias(true);
            Paint.FontMetrics fontMetrics = this.o.getFontMetrics();
            Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            float f2 = fontMetrics.ascent;
            float f3 = fontMetrics.top;
        }
    }

    public final boolean m(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            int i4 = this.f41349i;
            if (i4 == 4) {
                return i2 >= 0 && i2 < 2 && i3 >= 0 && i3 < 2;
            }
            return i2 >= 0 && i2 < 3 && i3 >= 0 && i3 < 3 && (i2 * 3) + i3 <= (i4 <= 9 ? i4 - 1 : 8);
        }
        return invokeII.booleanValue;
    }

    public final boolean n(ArrayList<TbRichTextImageInfo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, arrayList)) == null) ? ListUtils.equalList(this.f41348h, arrayList) : invokeL.booleanValue;
    }

    public final void o(TbImageView tbImageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048587, this, tbImageView, i2) == null) || tbImageView == null || this.f41347g == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.s, this.t);
        r(tbImageView, i2, layoutParams);
        addView(tbImageView, layoutParams);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (getChildAt(i2) instanceof TbImageView) {
                    ((TbImageView) getChildAt(i2)).setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                }
            }
        }
    }

    public final void p() {
        TbRichTextImageInfo tbRichTextImageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f41347g == null || ListUtils.isEmpty(this.f41348h) || (tbRichTextImageInfo = this.f41348h.get(0)) == null) {
            return;
        }
        int width = tbRichTextImageInfo.getWidth();
        int height = tbRichTextImageInfo.getHeight();
        if (height <= 0) {
            return;
        }
        float f2 = (width * 1.0f) / height;
        int i2 = this.f41347g.G;
        int i3 = this.f41350j;
        int i4 = (i2 - (i3 * 2)) / 3;
        this.s = 0;
        this.t = 0;
        if (this.f41349i != 1) {
            this.s = i4;
            this.t = i4;
        } else if (f2 >= 2.0f) {
            this.s = (i4 * 2) + i3;
            this.t = (int) ((i4 * 1.5d) + i3);
        } else if (f2 <= 0.5d) {
            this.s = (int) ((i4 * 1.5d) + i3);
            this.t = (i4 * 2) + i3;
        } else {
            int i5 = i4 * 2;
            this.s = i5 + i3;
            int i6 = i5 + i3;
            this.t = i6;
            if (f2 > 0.0f && f2 < 1.0f) {
                this.s = (int) (i6 * f2);
            } else if (f2 >= 1.0f) {
                this.t = (int) (this.s / f2);
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || ListUtils.isEmpty(this.f41348h)) {
            return;
        }
        removeAllViews();
        p();
        if (this.s <= 0 || this.t <= 0) {
            return;
        }
        if (this.f41349i == 1) {
            i();
        } else {
            h();
        }
    }

    public final void r(ImageView imageView, int i2, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048591, this, imageView, i2, layoutParams) == null) || imageView == null || layoutParams == null) {
            return;
        }
        imageView.setId(this.u[i2]);
        int i3 = this.f41349i == 4 ? i2 / 2 : i2 / 3;
        int i4 = this.f41349i == 4 ? i2 % 2 : i2 % 3;
        int i5 = i3 - 1;
        int k = k(i3, i4 - 1);
        int k2 = k(i5, i4);
        if (k2 >= 0) {
            layoutParams.addRule(3, k2);
            layoutParams.topMargin = this.f41350j;
        }
        if (k >= 0) {
            layoutParams.addRule(1, k);
            layoutParams.leftMargin = this.f41350j;
        }
        setTransformStyle(imageView, i2);
    }

    public final void s(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, view, i2) == null) {
            if (view instanceof TbImageView) {
                ((TbImageView) view).setConrers(i2);
            } else {
                boolean z = view instanceof GifView;
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setCornerStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
        }
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || n(arrayList) || this.f41347g == null) {
            return;
        }
        this.f41348h = arrayList;
        int size = arrayList.size();
        this.f41349i = size;
        this.l = size > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.f41349i - 9)}) : "";
        q();
    }

    public void setIsHost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.k = z;
        }
    }

    public void setIsTransform(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
        }
    }

    public void setLayoutStrategy(c.a.s0.g1.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            this.f41347g = aVar;
            if (aVar != null) {
                this.f41350j = aVar.H;
            }
        }
    }

    public void setObjectPool(c.a.d.f.k.b<ImageView> bVar, c.a.d.f.k.b<GifView> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, bVar, bVar2) == null) {
            this.f41345e = bVar;
            this.f41346f = bVar2;
        }
    }

    public void setOnImageClickListener(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, yVar) == null) {
            this.v = yVar;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onLongClickListener) == null) {
            this.y = onLongClickListener;
        }
    }

    public void setSupportGifPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.q = z;
        }
    }

    public void setTransformStyle(ImageView imageView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, imageView, i2) == null) {
            int i3 = this.f41349i;
            if (i3 == 1) {
                s(imageView, 15);
            } else if (i3 == 2) {
                if (i2 == 0) {
                    s(imageView, 5);
                } else if (i2 == 1) {
                    s(imageView, 10);
                }
            } else if (i3 == 3) {
                if (i2 == 0) {
                    s(imageView, 5);
                } else if (i2 == 2) {
                    s(imageView, 10);
                }
            } else if (i3 == 4) {
                if (i2 == 0) {
                    s(imageView, 1);
                } else if (i2 == 1) {
                    s(imageView, 2);
                } else if (i2 == 2) {
                    s(imageView, 4);
                } else if (i2 == 3) {
                    s(imageView, 8);
                }
            } else if (i3 == 5) {
                if (i2 == 0) {
                    s(imageView, 1);
                } else if (i2 == 2) {
                    s(imageView, 2);
                } else if (i2 == 3) {
                    s(imageView, 4);
                }
            } else if (i3 == 6) {
                if (i2 == 0) {
                    s(imageView, 1);
                } else if (i2 == 2) {
                    s(imageView, 2);
                } else if (i2 == 3) {
                    s(imageView, 4);
                } else if (i2 == 5) {
                    s(imageView, 8);
                }
            } else if (i3 == 7 || i3 == 8) {
                if (i2 == 0) {
                    s(imageView, 1);
                } else if (i2 == 2) {
                    s(imageView, 2);
                } else if (i2 == 6) {
                    s(imageView, 4);
                }
            } else if (i3 < 9) {
                s(imageView, 15);
            } else if (i2 == 0) {
                s(imageView, 1);
            } else if (i2 == 2) {
                s(imageView, 2);
            } else if (i2 == 6) {
                s(imageView, 4);
            } else if (i2 == 8) {
                s(imageView, 8);
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
        this.f41345e = null;
        this.f41346f = null;
        this.q = true;
        this.u = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.x = new a(this);
        this.z = new b(this);
        l();
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
        this.f41345e = null;
        this.f41346f = null;
        this.q = true;
        this.u = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.x = new a(this);
        this.z = new b(this);
        l();
    }
}
