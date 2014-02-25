package com.baidu.tieba.im.randchat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class RingLayoutView extends RelativeLayout {
    private Context a;
    private int b;
    private int c;
    private int d;
    private Paint e;
    private int f;
    private Point[] g;
    private HeadImageView[] h;
    private a i;
    private com.baidu.tieba.view.p j;
    private Point k;
    private com.baidu.tieba.util.i l;
    private int m;

    public Point getCenterP() {
        return this.k;
    }

    public void setCenterP(Point point) {
        this.k = point;
    }

    public int getBottomP() {
        return this.m;
    }

    private double a(double d) {
        return d * d;
    }

    public int getRadius() {
        return this.b;
    }

    public void setRadius(int i) {
        this.b = i;
    }

    public RingLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new Point[10];
        this.h = new HeadImageView[10];
        this.k = new Point();
        a(context);
    }

    public RingLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new Point[10];
        this.h = new HeadImageView[10];
        this.k = new Point();
        a(context);
    }

    public RingLayoutView(Context context) {
        super(context);
        this.g = new Point[10];
        this.h = new HeadImageView[10];
        this.k = new Point();
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.b = BdUtilHelper.c(context, R.dimen.wait_chat_large_circle_radius);
        this.c = BdUtilHelper.c(context, R.dimen.wait_chat_large_circle_stroke);
        this.k.x = displayMetrics.widthPixels / 2;
        this.k.y = BdUtilHelper.c(context, R.dimen.wait_chat_large_circle_margintop) + (BdUtilHelper.c(context, R.dimen.wait_chat_person_circle_lheight) / 2) + BdUtilHelper.c(context, R.dimen.wait_chat_large_circle_radius);
        this.e = new Paint();
        this.e.setColor(context.getResources().getColor(R.color.wait_chat_large_circle_stroke_color));
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setAntiAlias(true);
        this.e.setStrokeWidth(this.c);
        this.l = new com.baidu.tieba.util.i(this.a);
    }

    public int getShapeType() {
        return this.f;
    }

    public void setShapeType(int i) {
        this.f = i;
        for (int i2 = 0; i2 < i; i2++) {
            this.g[i2] = new Point();
        }
        a(this.k, this.g, i);
        a(this.d);
        a(this.g);
        this.m = this.k.y + this.b + (BdUtilHelper.c(this.a, R.dimen.wait_chat_person_circle_height) / 2) + BdUtilHelper.c(this.a, R.dimen.wait_chat_large_circle_marginbottom);
    }

    public void a(c cVar) {
        this.i.a(cVar);
    }

    public void a() {
        this.i.a();
    }

    public void b() {
        this.i.b();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.k.x, this.k.y, this.b, this.e);
    }

    private void a(int i) {
        Point[] pointArr = new Point[this.f];
        int i2 = 0;
        int i3 = i;
        while (i3 < this.f + i) {
            pointArr[i2] = this.g[i3 % this.f];
            i3++;
            i2++;
        }
        for (int i4 = 0; i4 < this.f; i4++) {
            this.g[i4] = pointArr[i4];
        }
    }

    private void a(Point point, Point[] pointArr, int i) {
        if (pointArr != null && pointArr.length >= i) {
            for (int i2 = 0; i2 < i; i2++) {
                pointArr[i2].x = (int) (this.b * Math.cos((i2 / i) * 2.0d * 3.141592653d));
                pointArr[i2].y = (int) (this.b * Math.sin((i2 / i) * 2.0d * 3.141592653d));
            }
            double e = e();
            for (int i3 = 0; i3 < i; i3++) {
                a(pointArr[i3], e);
            }
            for (int i4 = 0; i4 < i; i4++) {
                pointArr[i4].x += point.x;
                pointArr[i4].y += point.y;
            }
        }
    }

    private void a(Point point, double d) {
        point.x = (int) ((point.x * Math.cos(d)) - (point.y * Math.sin(d)));
        point.y = (int) ((point.x * Math.sin(d)) + (point.y * Math.cos(d)));
    }

    private double e() {
        Point point;
        int i = 0;
        if (this.g == null || this.g.length == 0) {
            return 0.0d;
        }
        Point point2 = this.g[0];
        while (true) {
            if (i < this.f) {
                if (this.g[i].x >= 0 || this.g[i].y > 0) {
                    i++;
                } else {
                    Point point3 = this.g[i];
                    this.d = i;
                    point = point3;
                    break;
                }
            } else {
                point = point2;
                break;
            }
        }
        return Math.acos(((2.0d * a(this.b)) - (a(point.x) + a(point.y + this.b))) / ((this.b * 2) * this.b));
    }

    public void c() {
        for (int i = 0; i < this.f; i++) {
            a(i, (String) null, (e) null);
        }
    }

    public void a(int i, String str, e eVar) {
        if (i >= 0 && i < this.f) {
            this.h[i].setImageResource(R.drawable.pic_default_head);
            this.h[i].setTag(null);
            if (TextUtils.isEmpty(str)) {
                a(i, this.h[i], false);
                this.h[i].invalidate();
                return;
            }
            this.h[i].setTag(str);
            a(i, this.h[i], true);
            com.baidu.adp.widget.ImageView.b d = this.l.d(str, new d(this, eVar));
            if (d != null) {
                this.h[i].setImageBitmap(d.h());
            }
        }
    }

    private void a(int i, HeadImageView headImageView, boolean z) {
        int c;
        int c2;
        int c3 = BdUtilHelper.c(this.a, R.dimen.head_view_circle_bg);
        if (i == 0) {
            c = BdUtilHelper.c(this.a, R.dimen.wait_chat_person_circle_lwidth);
        } else {
            c = BdUtilHelper.c(this.a, R.dimen.wait_chat_person_circle_width);
        }
        if (i == 0) {
            c2 = BdUtilHelper.c(this.a, R.dimen.wait_chat_person_circle_lheight);
        } else {
            c2 = BdUtilHelper.c(this.a, R.dimen.wait_chat_person_circle_height);
        }
        CircleBgView circleBgView = null;
        ViewParent parent = headImageView.getParent();
        if (parent != null && (parent instanceof CircleBgView)) {
            circleBgView = (CircleBgView) parent;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) headImageView.getLayoutParams();
        if (z) {
            layoutParams.width = c - c3;
            layoutParams.height = c2 - c3;
            if (circleBgView != null) {
                circleBgView.setHasBg(true);
            }
        } else {
            layoutParams.width = c;
            layoutParams.height = c2;
            if (circleBgView != null) {
                circleBgView.setHasBg(false);
            }
        }
        headImageView.setLayoutParams(layoutParams);
        if (circleBgView != null) {
            circleBgView.invalidate();
        }
    }

    private void a(Point[] pointArr) {
        int c;
        int c2;
        removeAllViews();
        for (int i = 0; i < this.f; i++) {
            Point point = pointArr[i];
            if (i == 0) {
                c = BdUtilHelper.c(this.a, R.dimen.wait_chat_person_circle_lwidth);
            } else {
                c = BdUtilHelper.c(this.a, R.dimen.wait_chat_person_circle_width);
            }
            if (i == 0) {
                c2 = BdUtilHelper.c(this.a, R.dimen.wait_chat_person_circle_lheight);
            } else {
                c2 = BdUtilHelper.c(this.a, R.dimen.wait_chat_person_circle_height);
            }
            CircleBgView circleBgView = new CircleBgView(this.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c, c2);
            layoutParams.leftMargin = (int) (point.x - (c / 2.0f));
            layoutParams.topMargin = (int) (point.y - (c2 / 2.0f));
            circleBgView.setLayoutParams(layoutParams);
            circleBgView.setBackgroundColor(0);
            circleBgView.setHasBg(false);
            circleBgView.invalidate();
            HeadImageView headImageView = new HeadImageView(this.a);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(c, c2);
            layoutParams2.gravity = 17;
            headImageView.setLayoutParams(layoutParams2);
            headImageView.setGifIconSupport(false);
            headImageView.setIsRound(true);
            headImageView.setDrawBorder(true);
            headImageView.setAutoChangeStyle(false);
            headImageView.setNightDefaultResource(-1);
            headImageView.setDefaultResource(-1);
            headImageView.setImageResource(R.drawable.pic_default_head);
            HeadImageView.setSkinMode(0);
            this.h[i] = headImageView;
            circleBgView.addView(headImageView);
            addView(circleBgView);
        }
        a aVar = new a(this.a);
        int c3 = BdUtilHelper.c(this.a, R.dimen.loading_view_width);
        int c4 = BdUtilHelper.c(this.a, R.dimen.loading_view_height);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(c3, c4);
        layoutParams3.leftMargin = this.k.x - (c3 / 2);
        layoutParams3.topMargin = this.k.y - (c4 / 2);
        aVar.setLayoutParams(layoutParams3);
        int c5 = BdUtilHelper.c(this.a, R.dimen.ds450);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(c5, c5);
        layoutParams4.leftMargin = this.k.x - (c5 / 2);
        layoutParams4.topMargin = this.k.y - (c5 / 2);
        this.j = new com.baidu.tieba.view.p(this.a);
        this.j.setLayoutParams(layoutParams4);
        this.i = aVar;
        this.i.setVisibility(8);
        addView(aVar);
        addView(this.j);
    }

    public void setChatClickListener(View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
    }

    public com.baidu.tieba.view.p getChatterboxView() {
        return this.j;
    }

    public a getLoadingView() {
        return this.i;
    }

    public void d() {
        if (this.i != null) {
            this.i.a();
        }
        if (this.j != null) {
            this.j.a();
        }
    }
}
