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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
import d.a.n0.a0.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class GridImageLayout extends RelativeLayout {
    public TbImageView.g A;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.e.k.b<ImageView> f13303e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.e.k.b<GifView> f13304f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.b1.m.a f13305g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<TbRichTextImageInfo> f13306h;

    /* renamed from: i  reason: collision with root package name */
    public int f13307i;
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            if (GridImageLayout.this.w != null && GridImageLayout.this.f13306h != null) {
                int indexOfChild = GridImageLayout.this.indexOfChild(view);
                if (view instanceof TbImageView) {
                    url = ((TbImageView) view).getUrl();
                } else {
                    url = view instanceof GifView ? ((GifView) view).getUrl() : "";
                }
                GridImageLayout.this.w.a(view, url, indexOfChild, GridImageLayout.this.k, true);
            }
            if (GridImageLayout.this.x != null) {
                GridImageLayout.this.x.onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbImageView.g {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i2;
            float f2;
            float f3;
            if (tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            d.a.c.k.d.a m = c.k().m(d.h().g(tbImageView.getUrl(), GridImageLayout.this.s));
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

    public GridImageLayout(Context context) {
        super(context);
        this.f13303e = null;
        this.f13304f = null;
        this.r = true;
        this.v = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.y = new a();
        this.A = new b();
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int childCount;
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

    public void f() {
        this.f13306h = null;
    }

    public final void g(int i2, TbRichTextImageInfo tbRichTextImageInfo) {
        if (tbRichTextImageInfo == null || this.f13305g == null) {
            return;
        }
        d.a.c.e.k.b<GifView> bVar = this.f13304f;
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
        if (this.f13307i == 1) {
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
        if (this.f13305g.q) {
            b2.setSupportNoImage(true);
        }
        b2.setDefaultNoImageDay(SkinManager.getResourceId(R.drawable.icon_click));
        String z = tbRichTextImageInfo.z();
        if (StringUtils.isNull(z)) {
            if (this.f13305g.c()) {
                z = this.f13305g.r ? tbRichTextImageInfo.w() : tbRichTextImageInfo.x();
            }
            if (StringUtils.isNull(z)) {
                z = this.f13305g.r ? tbRichTextImageInfo.y() : tbRichTextImageInfo.B();
            }
        }
        b2.setShowStaticDrawable(false);
        this.s = 38;
        b2.x0(z, 38);
        q(b2, i2);
    }

    public final void h() {
        if (ListUtils.isEmpty(this.f13306h)) {
            return;
        }
        for (int i2 = 0; i2 < this.f13307i && i2 < 9; i2++) {
            TbRichTextImageInfo tbRichTextImageInfo = this.f13306h.get(i2);
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
        if (ListUtils.isEmpty(this.f13306h) || (tbRichTextImageInfo = this.f13306h.get(0)) == null) {
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
        if (tbRichTextImageInfo == null || this.f13305g == null) {
            return;
        }
        d.a.c.e.k.b<ImageView> bVar = this.f13303e;
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
            if (this.f13307i == 1) {
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
            if (this.f13305g.q) {
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
                if (this.f13305g.c()) {
                    str = this.f13305g.r ? tbRichTextImageInfo.w() : tbRichTextImageInfo.x();
                }
                if (StringUtils.isNull(str)) {
                    str = this.f13305g.r ? tbRichTextImageInfo.y() : tbRichTextImageInfo.B();
                }
                this.s = this.f13305g.r ? 13 : 14;
            }
            tbImageView.U(str, this.s, false);
            if (!tbRichTextImageInfo.C()) {
                tbImageView.setAdjustViewBounds(false);
            }
            q(tbImageView, i2);
        }
    }

    public final void k(Canvas canvas, RectF rectF, float[] fArr) {
        if (rectF == null) {
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
            canvas2.drawPath(d.a.n0.r.u.d.a.a(rectF2, fArr), this.o);
        }
        canvas.drawBitmap(this.n, rectF.left, rectF.top, this.q);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
        int i4 = ((int) rectF.bottom) - dimenPixelSize;
        int measureText = (((int) rectF.right) - dimenPixelSize2) - ((int) this.p.measureText(this.l));
        float[] y = d.a.n0.r.u.a.y(R.array.S_O_X001);
        this.p.setShadowLayer(y[1], y[2], y[3], (int) y[0]);
        canvas.drawText(this.l, measureText, i4, this.p);
    }

    public final int l(int i2, int i3) {
        if (n(i2, i3)) {
            return this.v[(this.f13307i == 4 ? i2 * 2 : i2 * 3) + i3];
        }
        return -1;
    }

    public final void m() {
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

    public final boolean n(int i2, int i3) {
        int i4 = this.f13307i;
        if (i4 == 4) {
            return i2 >= 0 && i2 < 2 && i3 >= 0 && i3 < 2;
        }
        return i2 >= 0 && i2 < 3 && i3 >= 0 && i3 < 3 && (i2 * 3) + i3 <= (i4 <= 9 ? i4 - 1 : 8);
    }

    public final boolean o(ArrayList<TbRichTextImageInfo> arrayList) {
        return ListUtils.equalList(this.f13306h, arrayList);
    }

    public void p() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof TbImageView) {
                ((TbImageView) getChildAt(i2)).setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            }
        }
    }

    public final void q(TbImageView tbImageView, int i2) {
        if (tbImageView == null || this.f13305g == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.t, this.u);
        t(tbImageView, i2, layoutParams);
        addView(tbImageView, layoutParams);
    }

    public final void r() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (this.f13305g == null || ListUtils.isEmpty(this.f13306h) || (tbRichTextImageInfo = this.f13306h.get(0)) == null) {
            return;
        }
        int width = tbRichTextImageInfo.getWidth();
        int height = tbRichTextImageInfo.getHeight();
        if (height <= 0) {
            return;
        }
        float f2 = (width * 1.0f) / height;
        int i2 = this.f13305g.D;
        int i3 = this.j;
        int i4 = (i2 - (i3 * 2)) / 3;
        this.t = 0;
        this.u = 0;
        if (this.f13307i != 1) {
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
        if (ListUtils.isEmpty(this.f13306h)) {
            return;
        }
        removeAllViews();
        r();
        if (this.t <= 0 || this.u <= 0) {
            return;
        }
        if (this.f13307i == 1) {
            i();
        } else {
            h();
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void setCornerStyle(int i2) {
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (ListUtils.isEmpty(arrayList) || o(arrayList) || this.f13305g == null) {
            return;
        }
        this.f13306h = arrayList;
        int size = arrayList.size();
        this.f13307i = size;
        this.l = size > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.f13307i - 9)}) : "";
        s();
    }

    public void setIsHost(boolean z) {
        this.k = z;
    }

    public void setIsTransform(boolean z) {
    }

    public void setLayoutStrategy(d.a.n0.b1.m.a aVar) {
        this.f13305g = aVar;
        if (aVar != null) {
            this.j = aVar.E;
        }
    }

    public void setObjectPool(d.a.c.e.k.b<ImageView> bVar, d.a.c.e.k.b<GifView> bVar2) {
        this.f13303e = bVar;
        this.f13304f = bVar2;
    }

    public void setOnImageClickListener(TbRichTextView.x xVar) {
        this.w = xVar;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.z = onLongClickListener;
    }

    public void setSupportGifPlay(boolean z) {
        this.r = z;
    }

    public void setTransformStyle(ImageView imageView, int i2) {
        int i3 = this.f13307i;
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

    public final void t(ImageView imageView, int i2, RelativeLayout.LayoutParams layoutParams) {
        if (imageView == null || layoutParams == null) {
            return;
        }
        imageView.setId(this.v[i2]);
        int i3 = this.f13307i == 4 ? i2 / 2 : i2 / 3;
        int i4 = this.f13307i == 4 ? i2 % 2 : i2 % 3;
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
        if (view instanceof TbImageView) {
            ((TbImageView) view).setConrers(i2);
        } else {
            boolean z = view instanceof GifView;
        }
    }

    public GridImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13303e = null;
        this.f13304f = null;
        this.r = true;
        this.v = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.y = new a();
        this.A = new b();
        m();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13303e = null;
        this.f13304f = null;
        this.r = true;
        this.v = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.y = new a();
        this.A = new b();
        m();
    }
}
