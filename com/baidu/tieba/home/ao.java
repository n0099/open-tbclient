package com.baidu.tieba.home;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.Random;
/* loaded from: classes.dex */
public class ao extends FrameLayout {
    private int a;
    private final int b;
    private Context c;
    private ProgressBar d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private Scroller i;
    private int j;
    private Runnable k;
    private Runnable l;
    private Runnable m;

    public ao(Context context) {
        super(context);
        this.a = 0;
        this.b = 180;
        this.j = 2000;
        this.k = new ap(this);
        this.l = new aq(this);
        this.m = new ar(this);
        b();
    }

    private void b() {
        this.c = getContext();
        ((LayoutInflater) this.c.getSystemService("layout_inflater")).inflate(R.layout.signallforum_progress_view, this);
        this.d = (ProgressBar) findViewById(R.id.signallforum_progress);
        this.e = (ImageView) findViewById(R.id.signallforum_icon);
        this.f = (TextView) findViewById(R.id.signallforun_status);
        this.g = (TextView) findViewById(R.id.signallforun_message1);
        this.h = (TextView) findViewById(R.id.signallforun_message2);
        c();
        this.i = new Scroller(this.c, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(BdUtilHelper.a(this.c, 180.0f), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = (i3 - i) / 2;
        int measuredWidth = this.d.getMeasuredWidth();
        int measuredHeight = this.d.getMeasuredHeight();
        int i6 = i5 - (measuredWidth / 2);
        int a = BdUtilHelper.a(this.c, 16.0f);
        int i7 = measuredHeight + a;
        this.d.layout(i6, a, measuredWidth + i6, i7);
        int measuredWidth2 = this.e.getMeasuredWidth();
        int measuredHeight2 = this.e.getMeasuredHeight();
        int i8 = i5 - (measuredWidth2 / 2);
        int measuredHeight3 = (i7 - (this.d.getMeasuredHeight() / 2)) - measuredHeight2;
        int i9 = measuredHeight2 + measuredHeight3;
        this.e.layout(i8, measuredHeight3, measuredWidth2 + i8, i9);
        int measuredWidth3 = this.f.getMeasuredWidth();
        int measuredHeight4 = this.f.getMeasuredHeight();
        int i10 = i5 - (measuredWidth3 / 2);
        int a2 = i9 + BdUtilHelper.a(this.c, 10.0f);
        this.f.layout(i10, a2, measuredWidth3 + i10, measuredHeight4 + a2);
        int measuredWidth4 = this.g.getMeasuredWidth();
        int measuredHeight5 = this.g.getMeasuredHeight();
        int i11 = i5 - (measuredWidth4 / 2);
        int a3 = BdUtilHelper.a(this.c, 125.0f);
        int i12 = measuredHeight5 + a3;
        this.g.layout(i11, a3, measuredWidth4 + i11, i12);
        int measuredWidth5 = this.h.getMeasuredWidth();
        int i13 = i5 - (measuredWidth5 / 2);
        this.h.layout(i13, i12, measuredWidth5 + i13, this.h.getMeasuredHeight() + i12);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    private void c() {
        removeCallbacks(this.k);
        removeCallbacks(this.l);
        boolean z = TiebaApplication.g().al() == 1;
        switch (this.a) {
            case 0:
                this.d.setClickable(true);
                this.d.setProgress(0);
                this.d.setSecondaryProgress(0);
                this.d.setBackgroundResource(R.drawable.btn_all_sign);
                this.f.setText(R.string.signallforum_begin);
                return;
            case 1:
                post(this.m);
                this.d.setClickable(false);
                this.d.setBackgroundResource(R.drawable.bg_all_sign_conduct);
                this.e.setImageResource(z ? R.drawable.icon_all_sign_d_1 : R.drawable.icon_all_sign_d);
                this.f.setText(R.string.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.d.getMax()) / 100;
                if (nextInt - this.d.getProgress() < 0) {
                    this.i.startScroll(nextInt, 0, this.d.getProgress() - nextInt, 0, this.j);
                } else {
                    this.i.startScroll(this.d.getProgress(), 0, nextInt - this.d.getProgress(), 0, this.j);
                }
                post(this.k);
                return;
            case 2:
                this.d.setClickable(true);
                this.d.setBackgroundResource(z ? R.drawable.bg_all_sign_d_1 : R.drawable.bg_all_sign_d);
                this.d.setProgress(0);
                this.e.setImageResource(z ? R.drawable.bg_all_sign_ok_1 : R.drawable.bg_all_sign_ok);
                this.f.setText(R.string.signallforum_success);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.a;
    }

    public void setSigning(int i) {
        if (this.a != 1 && this.a == 0) {
            this.d.setProgress(i);
            this.a = 1;
            c();
        }
    }

    public void a() {
        if (this.a != 2) {
            this.a = 2;
            c();
        }
    }

    public ProgressBar getProgressBar() {
        return this.d;
    }

    public ImageView getIcon() {
        return this.e;
    }

    public TextView getmStatus() {
        return this.f;
    }

    public TextView getMessage1() {
        return this.g;
    }

    public TextView getMessage2() {
        return this.h;
    }

    public int getProgress() {
        return this.d.getProgress();
    }

    public void setDuration(int i) {
        this.j = i;
    }
}
