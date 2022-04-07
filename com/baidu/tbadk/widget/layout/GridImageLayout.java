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
import com.repackage.af5;
import com.repackage.dg;
import com.repackage.fo;
import com.repackage.h35;
import com.repackage.ig;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.wr4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class GridImageLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dg<ImageView> a;
    public dg<GifView> b;
    public af5 c;
    public ArrayList<TbRichTextImageInfo> d;
    public int e;
    public int f;
    public boolean g;
    public String h;
    public RectF i;
    public Paint j;
    public Paint k;
    public Paint l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public int[] q;
    public TbRichTextView.y r;
    public View.OnClickListener s;
    public View.OnClickListener t;
    public View.OnLongClickListener u;
    public TbImageView.h v;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GridImageLayout a;

        public a(GridImageLayout gridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String url;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.r != null && this.a.d != null) {
                    int indexOfChild = this.a.indexOfChild(view2);
                    if (view2 instanceof TbImageView) {
                        url = ((TbImageView) view2).getUrl();
                    } else {
                        url = view2 instanceof GifView ? ((GifView) view2).getUrl() : "";
                    }
                    this.a.r.a(view2, url, indexOfChild, this.a.g, true);
                }
                if (this.a.s != null) {
                    this.a.s.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i;
            float f;
            float f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            fo m = h35.k().m(ig.h().g(tbImageView.getUrl(), this.a.n));
            int i2 = 0;
            if (m != null) {
                i2 = m.r();
                i = m.m();
            } else {
                i = 0;
            }
            if (i2 == 0 || i == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            Matrix imageMatrix = tbImageView.getImageMatrix();
            if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f = height;
                    f2 = i;
                } else {
                    f = width;
                    f2 = i2;
                }
                float f3 = f / f2;
                imageMatrix.setScale(f3, f3);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.m = true;
        this.q = new int[]{R.id.obfuscated_res_0x7f090cea, R.id.obfuscated_res_0x7f090ceb, R.id.obfuscated_res_0x7f090cec, R.id.obfuscated_res_0x7f090ced, R.id.obfuscated_res_0x7f090cee, R.id.obfuscated_res_0x7f090cef, R.id.obfuscated_res_0x7f090cf0, R.id.obfuscated_res_0x7f090cf1, R.id.obfuscated_res_0x7f090cf2};
        this.t = new a(this);
        this.v = new b(this);
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int childCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (ni.isEmpty(this.h) || (childCount = getChildCount()) != 9) {
                return;
            }
            View childAt = getChildAt(childCount - 1);
            boolean z = childAt instanceof TbImageView;
            if (z || (childAt instanceof GifView)) {
                if (this.i == null) {
                    this.i = new RectF();
                }
                this.i.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !ni.isEmpty(this.h) && getChildCount() == 9) {
            int f = oi.f(getContext(), R.dimen.M_W_X003);
            int f2 = oi.f(getContext(), R.dimen.M_W_X004);
            int f3 = oi.f(getContext(), R.dimen.tbds52);
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            EMTextView eMTextView = new EMTextView(getContext());
            eMTextView.setPadding(f, 0, f, 0);
            eMTextView.setGravity(16);
            eMTextView.setText(this.h);
            wr4 d = wr4.d(eMTextView);
            d.z(R.dimen.T_X09);
            d.v(R.color.CAM_X0101);
            d.A(R.string.F_X02);
            d.n(R.string.J_X01);
            d.f(R.color.CAM_X0607);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, f3);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.rightMargin = f2;
            layoutParams.bottomMargin = f2;
            relativeLayout.addView(eMTextView, layoutParams);
            int i = this.o;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            addView(relativeLayout, layoutParams2);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = null;
        }
    }

    public final void h(int i, TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, tbRichTextImageInfo) == null) || tbRichTextImageInfo == null || this.c == null) {
            return;
        }
        dg<GifView> dgVar = this.b;
        GifView b2 = dgVar != null ? dgVar.b() : null;
        if (b2 == null || b2.getParent() != null) {
            b2 = new GifView(getContext());
        }
        b2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        b2.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        b2.setBorderSurroundContent(true);
        b2.setDrawCorner(true);
        b2.setDrawBorder(true);
        b2.setRadiusById(R.string.J_X05);
        b2.setOnClickListener(this.t);
        View.OnLongClickListener onLongClickListener = this.u;
        if (onLongClickListener != null) {
            b2.setOnLongClickListener(onLongClickListener);
        }
        b2.setOnDrawListener(null);
        if (this.e == 1) {
            b2.setPlaceHolder(3);
            b2.setScaleType(ImageView.ScaleType.MATRIX);
            b2.setOnDrawListener(this.v);
        } else {
            b2.setPlaceHolder(2);
            b2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        b2.setIsLongPic(tbRichTextImageInfo.G());
        if (i == 8 && !ni.isEmpty(this.h)) {
            b2.setLongIconSupport(false);
            b2.setGifIconSupport(false);
        } else {
            b2.setLongIconSupport(true);
            b2.setGifIconSupport(true);
        }
        if (this.c.q) {
            b2.setSupportNoImage(true);
        }
        b2.setDefaultNoImageDay(SkinManager.getResourceId(R.drawable.icon_click));
        String B = tbRichTextImageInfo.B();
        if (StringUtils.isNull(B)) {
            if (this.c.c()) {
                B = this.c.r ? tbRichTextImageInfo.y() : tbRichTextImageInfo.z();
            }
            if (StringUtils.isNull(B)) {
                B = this.c.r ? tbRichTextImageInfo.A() : tbRichTextImageInfo.D();
            }
        }
        b2.setShowStaticDrawable(false);
        this.n = 38;
        b2.h0(B, 38);
        q(b2, i);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.d)) {
            return;
        }
        for (int i = 0; i < this.e && i < 9; i++) {
            TbRichTextImageInfo tbRichTextImageInfo = this.d.get(i);
            if (tbRichTextImageInfo != null) {
                int width = tbRichTextImageInfo.getWidth();
                int height = tbRichTextImageInfo.getHeight();
                if (width > 0 && height > 0) {
                    if (this.m && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.G()) {
                        h(i, tbRichTextImageInfo);
                    } else {
                        k(i, tbRichTextImageInfo);
                    }
                }
            }
        }
        f();
    }

    public final void j() {
        TbRichTextImageInfo tbRichTextImageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ListUtils.isEmpty(this.d) || (tbRichTextImageInfo = this.d.get(0)) == null) {
            return;
        }
        int width = tbRichTextImageInfo.getWidth();
        int height = tbRichTextImageInfo.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        if (this.m && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.G()) {
            h(0, tbRichTextImageInfo);
        } else {
            k(0, tbRichTextImageInfo);
        }
    }

    public final void k(int i, TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048582, this, i, tbRichTextImageInfo) == null) || tbRichTextImageInfo == null || this.c == null) {
            return;
        }
        dg<ImageView> dgVar = this.a;
        String str = null;
        ImageView b2 = dgVar != null ? dgVar.b() : null;
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
            tbImageView.setOnClickListener(this.t);
            View.OnLongClickListener onLongClickListener = this.u;
            if (onLongClickListener != null) {
                tbImageView.setOnLongClickListener(onLongClickListener);
            }
            tbImageView.setOnDrawListener(null);
            if (this.e == 1) {
                tbImageView.setPlaceHolder(3);
                tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                tbImageView.setOnDrawListener(this.v);
            } else {
                tbImageView.setPlaceHolder(2);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            tbImageView.setIsLongPic(tbRichTextImageInfo.G());
            if (i == 8 && !ni.isEmpty(this.h)) {
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setLongIconSupport(true);
                tbImageView.setGifIconSupport(true);
            }
            if (this.c.q) {
                tbImageView.setSupportNoImage(true);
            }
            if (!this.m) {
                str = tbRichTextImageInfo.D();
                String C = tbRichTextImageInfo.C();
                if (!TextUtils.isEmpty(C) && C.toLowerCase().contains(".gif")) {
                    tbImageView.setIsGifPic(true);
                } else {
                    tbImageView.setIsGifPic(false);
                }
                this.n = 13;
            } else {
                if (this.c.c()) {
                    str = this.c.r ? tbRichTextImageInfo.y() : tbRichTextImageInfo.z();
                }
                if (StringUtils.isNull(str)) {
                    str = this.c.r ? tbRichTextImageInfo.A() : tbRichTextImageInfo.D();
                }
                this.n = this.c.r ? 13 : 14;
            }
            tbImageView.K(str, this.n, false);
            if (!tbRichTextImageInfo.E()) {
                tbImageView.setAdjustViewBounds(false);
            }
            q(tbImageView, i);
        }
    }

    public final int l(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i, i2)) == null) {
            if (n(i, i2)) {
                return this.q[(this.e == 4 ? i * 2 : i * 3) + i2];
            }
            return -1;
        }
        return invokeII.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Paint paint = new Paint();
            this.j = paint;
            paint.setAntiAlias(true);
            this.j.setColor(-16777216);
            Paint paint2 = new Paint();
            this.l = paint2;
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.k = paint3;
            paint3.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.k.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
            this.k.setAntiAlias(true);
            Paint.FontMetrics fontMetrics = this.k.getFontMetrics();
            Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            float f = fontMetrics.ascent;
            float f2 = fontMetrics.top;
        }
    }

    public final boolean n(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) {
            int i3 = this.e;
            if (i3 == 4) {
                return i >= 0 && i < 2 && i2 >= 0 && i2 < 2;
            }
            return i >= 0 && i < 3 && i2 >= 0 && i2 < 3 && (i * 3) + i2 <= (i3 <= 9 ? i3 - 1 : 8);
        }
        return invokeII.booleanValue;
    }

    public final boolean o(ArrayList<TbRichTextImageInfo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, arrayList)) == null) ? ListUtils.equalList(this.d, arrayList) : invokeL.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                if (getChildAt(i) instanceof TbImageView) {
                    ((TbImageView) getChildAt(i)).setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                }
            }
        }
    }

    public final void q(TbImageView tbImageView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048588, this, tbImageView, i) == null) || tbImageView == null || this.c == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.o, this.p);
        t(tbImageView, i, layoutParams);
        addView(tbImageView, layoutParams);
    }

    public final void r() {
        TbRichTextImageInfo tbRichTextImageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.c == null || ListUtils.isEmpty(this.d) || (tbRichTextImageInfo = this.d.get(0)) == null) {
            return;
        }
        int width = tbRichTextImageInfo.getWidth();
        int height = tbRichTextImageInfo.getHeight();
        if (height <= 0) {
            return;
        }
        float f = (width * 1.0f) / height;
        int i = this.c.G;
        int i2 = this.f;
        int i3 = (i - (i2 * 2)) / 3;
        this.o = 0;
        this.p = 0;
        if (this.e != 1) {
            this.o = i3;
            this.p = i3;
        } else if (f >= 2.0f) {
            this.o = (i3 * 2) + i2;
            this.p = (int) ((i3 * 1.5d) + i2);
        } else if (f <= 0.5d) {
            this.o = (int) ((i3 * 1.5d) + i2);
            this.p = (i3 * 2) + i2;
        } else {
            int i4 = i3 * 2;
            this.o = i4 + i2;
            int i5 = i4 + i2;
            this.p = i5;
            if (f > 0.0f && f < 1.0f) {
                this.o = (int) (i5 * f);
            } else if (f >= 1.0f) {
                this.p = (int) (this.o / f);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || ListUtils.isEmpty(this.d)) {
            return;
        }
        removeAllViews();
        r();
        if (this.o <= 0 || this.p <= 0) {
            return;
        }
        if (this.e == 1) {
            j();
        } else {
            i();
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void setCornerStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
        }
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || o(arrayList) || this.c == null) {
            return;
        }
        this.d = arrayList;
        int size = arrayList.size();
        this.e = size;
        this.h = size > 9 ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f042e, new Object[]{Integer.valueOf(this.e - 9)}) : "";
        s();
    }

    public void setIsHost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.g = z;
        }
    }

    public void setIsTransform(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    public void setLayoutStrategy(af5 af5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, af5Var) == null) {
            this.c = af5Var;
            if (af5Var != null) {
                this.f = af5Var.H;
            }
        }
    }

    public void setObjectPool(dg<ImageView> dgVar, dg<GifView> dgVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, dgVar, dgVar2) == null) {
            this.a = dgVar;
            this.b = dgVar2;
        }
    }

    public void setOnImageClickListener(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, yVar) == null) {
            this.r = yVar;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onLongClickListener) == null) {
            this.u = onLongClickListener;
        }
    }

    public void setSupportGifPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.m = z;
        }
    }

    public void setTransformStyle(ImageView imageView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, imageView, i) == null) {
            int i2 = this.e;
            if (i2 == 1) {
                u(imageView, 15);
            } else if (i2 == 2) {
                if (i == 0) {
                    u(imageView, 5);
                } else if (i == 1) {
                    u(imageView, 10);
                }
            } else if (i2 == 3) {
                if (i == 0) {
                    u(imageView, 5);
                } else if (i == 2) {
                    u(imageView, 10);
                }
            } else if (i2 == 4) {
                if (i == 0) {
                    u(imageView, 1);
                } else if (i == 1) {
                    u(imageView, 2);
                } else if (i == 2) {
                    u(imageView, 4);
                } else if (i == 3) {
                    u(imageView, 8);
                }
            } else if (i2 == 5) {
                if (i == 0) {
                    u(imageView, 1);
                } else if (i == 2) {
                    u(imageView, 2);
                } else if (i == 3) {
                    u(imageView, 4);
                }
            } else if (i2 == 6) {
                if (i == 0) {
                    u(imageView, 1);
                } else if (i == 2) {
                    u(imageView, 2);
                } else if (i == 3) {
                    u(imageView, 4);
                } else if (i == 5) {
                    u(imageView, 8);
                }
            } else if (i2 == 7 || i2 == 8) {
                if (i == 0) {
                    u(imageView, 1);
                } else if (i == 2) {
                    u(imageView, 2);
                } else if (i == 6) {
                    u(imageView, 4);
                }
            } else if (i2 < 9) {
                u(imageView, 15);
            } else if (i == 0) {
                u(imageView, 1);
            } else if (i == 2) {
                u(imageView, 2);
            } else if (i == 6) {
                u(imageView, 4);
            } else if (i == 8) {
                u(imageView, 8);
            }
        }
    }

    public final void t(ImageView imageView, int i, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048602, this, imageView, i, layoutParams) == null) || imageView == null || layoutParams == null) {
            return;
        }
        imageView.setId(this.q[i]);
        int i2 = this.e == 4 ? i / 2 : i / 3;
        int i3 = this.e == 4 ? i % 2 : i % 3;
        int i4 = i2 - 1;
        int l = l(i2, i3 - 1);
        int l2 = l(i4, i3);
        if (l2 >= 0) {
            layoutParams.addRule(3, l2);
            layoutParams.topMargin = this.f;
        }
        if (l >= 0) {
            layoutParams.addRule(1, l);
            layoutParams.leftMargin = this.f;
        }
        setTransformStyle(imageView, i);
    }

    public final void u(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, view2, i) == null) {
            if (view2 instanceof TbImageView) {
                ((TbImageView) view2).setConrers(i);
            } else {
                boolean z = view2 instanceof GifView;
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
        this.a = null;
        this.b = null;
        this.m = true;
        this.q = new int[]{R.id.obfuscated_res_0x7f090cea, R.id.obfuscated_res_0x7f090ceb, R.id.obfuscated_res_0x7f090cec, R.id.obfuscated_res_0x7f090ced, R.id.obfuscated_res_0x7f090cee, R.id.obfuscated_res_0x7f090cef, R.id.obfuscated_res_0x7f090cf0, R.id.obfuscated_res_0x7f090cf1, R.id.obfuscated_res_0x7f090cf2};
        this.t = new a(this);
        this.v = new b(this);
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridImageLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.a = null;
        this.b = null;
        this.m = true;
        this.q = new int[]{R.id.obfuscated_res_0x7f090cea, R.id.obfuscated_res_0x7f090ceb, R.id.obfuscated_res_0x7f090cec, R.id.obfuscated_res_0x7f090ced, R.id.obfuscated_res_0x7f090cee, R.id.obfuscated_res_0x7f090cef, R.id.obfuscated_res_0x7f090cf0, R.id.obfuscated_res_0x7f090cf1, R.id.obfuscated_res_0x7f090cf2};
        this.t = new a(this);
        this.v = new b(this);
        m();
    }
}
