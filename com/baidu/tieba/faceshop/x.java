package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.by;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class x {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private ScrollView E;
    private int F;
    private TbImageView H;
    private com.baidu.tieba.f a;
    private int b;
    private LinearLayout c;
    private NavigationBar d;
    private NoNetworkView e;
    private TbImageView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private FrameLayout l;
    private ImageView m;
    private ImageView n;
    private LinearLayout o;
    private int p;
    private int q;
    private int r;
    private GridView s;
    private ae t;
    private com.baidu.tieba.util.i u;
    private Handler v;
    private h w;
    private GifView x;
    private WindowManager y;
    private WindowManager.LayoutParams z;
    private int G = -1;
    private com.baidu.tbadk.imageManager.d I = new y(this);
    private Runnable J = new z(this);

    public x(com.baidu.tieba.f fVar) {
        this.a = fVar;
        fVar.setContentView(R.layout.face_package_detail_activity);
        this.c = (LinearLayout) fVar.findViewById(R.id.face_package);
        this.d = (NavigationBar) fVar.findViewById(R.id.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a("");
        this.e = (NoNetworkView) fVar.findViewById(R.id.view_no_network);
        this.o = (LinearLayout) this.c.findViewById(R.id.face_package_container);
        this.f = (TbImageView) this.c.findViewById(R.id.face_package_cover);
        this.g = (TextView) this.c.findViewById(R.id.face_package_title);
        this.h = (TextView) this.c.findViewById(R.id.face_package_price);
        this.i = (TextView) this.c.findViewById(R.id.face_package_status);
        this.j = (TextView) this.c.findViewById(R.id.face_package_btn);
        this.k = (TextView) this.c.findViewById(R.id.face_package_info);
        this.s = (GridView) this.c.findViewById(R.id.face_package_faces);
        this.H = (TbImageView) this.c.findViewById(R.id.face_package_title_tag);
        this.s.setSelection(-1);
        this.s.setOnItemLongClickListener(fVar);
        this.l = (FrameLayout) this.c.findViewById(R.id.face_package_downloading);
        this.m = (ImageView) this.c.findViewById(R.id.face_package_downloading_up);
        this.n = (ImageView) this.c.findViewById(R.id.face_package_downloading_cancel);
        this.b = TiebaApplication.g().al();
        this.u = new com.baidu.tieba.util.i(fVar);
        this.u.a(fVar.getResources().getDimensionPixelSize(R.dimen.faceshop_cover_width), fVar.getResources().getDimensionPixelSize(R.dimen.faceshop_cover_height));
        this.v = new Handler();
        this.j.setOnClickListener(fVar);
        this.n.setOnClickListener(fVar);
        Bitmap a = com.baidu.tieba.util.n.a((int) R.drawable.bg_content_buy_bar_down);
        Bitmap a2 = com.baidu.tieba.util.n.a((int) R.drawable.bg_content_buy_bar_up);
        this.q = a.getWidth();
        this.p = a2.getWidth();
        this.r = this.a.getResources().getDimensionPixelSize(R.dimen.faceshop_page_padding);
        this.w = new h(fVar, R.style.common_alert_dialog);
        this.E = (ScrollView) this.c.findViewById(R.id.container_scrollview);
        a(fVar);
    }

    private void a(Context context) {
        int al = TiebaApplication.g().al();
        this.x = new GifView(context);
        if (al == 1) {
            this.x.setBackgroundResource(R.drawable.bg_expression_bubble_1);
        } else {
            this.x.setBackgroundResource(R.drawable.bg_expression_bubble);
        }
        this.x.setVisibility(8);
        this.y = (WindowManager) context.getSystemService("window");
        this.z = new WindowManager.LayoutParams();
        this.A = context.getResources().getDimensionPixelSize(R.dimen.face_tab_content_float_width);
        this.B = context.getResources().getDimensionPixelSize(R.dimen.face_tab_content_float_height);
        this.z.width = this.A;
        this.z.height = this.B;
        this.z.gravity = 51;
        this.z.format = -3;
        this.z.type = LocationClientOption.MIN_SCAN_SPAN;
        this.z.flags |= 56;
        if (TiebaApplication.g().bu()) {
            this.z.type = LocationClientOption.MIN_SCAN_SPAN;
            this.z.flags = 25165832;
        }
        this.F = BdUtilHelper.a((Activity) context);
    }

    public void a(v vVar) {
        if (vVar != null) {
            b(vVar);
        }
    }

    private void b(FacePackageData facePackageData) {
        if (facePackageData != null && facePackageData.faceList != null) {
            this.s.setLayoutParams(new LinearLayout.LayoutParams(-1, ((BdUtilHelper.b(this.a) - (this.r * 2)) / 4) * ((int) Math.ceil(facePackageData.faceList.size() / 4.0f))));
        }
    }

    public void a(String str) {
        if (str != null && str.length() > 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.d.j(linkedList));
        }
    }

    public void a(FacePackageData facePackageData) {
        if (facePackageData != null) {
            if (this.t == null) {
                this.t = new ae(this.a, facePackageData.faceList);
                this.s.setAdapter((ListAdapter) this.t);
                return;
            }
            this.t.a(facePackageData.faceList);
            this.t.notifyDataSetChanged();
        }
    }

    public void b(v vVar) {
        FacePackageData facePackageData;
        if (vVar != null && vVar.a() != null && (facePackageData = vVar.a().facePackage) != null) {
            if (vVar.c()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.o.setVisibility(0);
            this.f.setTag(facePackageData.coverUrl);
            this.g.setText(facePackageData.pname);
            this.H.setTag(facePackageData.tagUrl);
            this.h.setText(String.valueOf(this.a.getResources().getString(R.string.price_tip)) + facePackageData.price);
            this.k.setText(facePackageData.pdesc);
            this.d.a(facePackageData.pname);
            b(facePackageData);
            a(vVar.e());
            a(facePackageData);
            p();
        }
    }

    private void p() {
        if (this.v != null) {
            this.v.removeCallbacks(this.J);
            this.v.postDelayed(this.J, 300L);
        }
    }

    private void q() {
        if (this.u != null) {
            this.u.d();
        }
        if (this.t != null) {
            this.t.a();
        }
    }

    public void a() {
        if (this.u != null && this.f != null) {
            this.u.a();
            String obj = this.f.getTag().toString();
            if (this.u.d(obj) == null) {
                this.u.b(obj, new aa(this));
            } else {
                this.f.invalidate();
            }
            String obj2 = this.H.getTag().toString();
            if (this.u.d(obj2) == null) {
                this.u.b(obj2, new ab(this));
                return;
            }
            this.H.setVisibility(0);
            this.H.invalidate();
        }
    }

    public void a(by byVar) {
        this.e.a(byVar);
    }

    public void b(by byVar) {
        this.e.b(byVar);
    }

    public void c(v vVar) {
        if (vVar != null && vVar.a() != null && vVar.a().facePackage != null) {
            FacePackageData facePackageData = vVar.a().facePackage;
            if (facePackageData.buyStatus == 1) {
                this.i.setText(this.a.getResources().getString(R.string.has_buy));
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
            switch (vVar.d()) {
                case 1:
                    b();
                    return;
                case 2:
                case 3:
                    d();
                    return;
                case 4:
                    c();
                    return;
                case 5:
                    a(facePackageData.downloadTotal, facePackageData.downloadNow);
                    return;
                case 6:
                    r();
                    return;
                default:
                    return;
            }
        }
    }

    public void b() {
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.j.setText(this.a.getResources().getString(R.string.downloaded));
        if (this.b == 1) {
            this.j.setTextColor(this.a.getResources().getColor(R.color.faceshop_downloaded_text_1));
            this.j.setBackgroundResource(R.drawable.btn_content_buy_d_1);
            return;
        }
        this.j.setTextColor(this.a.getResources().getColor(R.color.faceshop_downloaded_text));
        this.j.setBackgroundResource(R.drawable.btn_content_buy_d);
    }

    public void a(long j, long j2) {
        this.j.setVisibility(8);
        this.l.setVisibility(0);
        int i = (int) ((((float) j2) / ((float) j)) * this.q);
        int i2 = i < this.p ? this.p : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.width = i2;
        this.m.setLayoutParams(layoutParams);
    }

    public void c() {
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.j.setText(this.a.getResources().getString(R.string.buy_package));
        if (this.b == 1) {
            this.j.setBackgroundResource(R.drawable.faceshop_package_btn_selector_1);
        } else {
            this.j.setBackgroundResource(R.drawable.faceshop_package_btn_selector);
        }
    }

    public void d() {
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.j.setText(this.a.getResources().getString(R.string.can_download));
        if (this.b == 1) {
            this.j.setTextColor(this.a.getResources().getColor(R.color.faceshop_package_btn_text_1));
            this.j.setBackgroundResource(R.drawable.faceshop_package_btn_selector_1);
            return;
        }
        this.j.setTextColor(this.a.getResources().getColor(R.color.faceshop_package_btn_text));
        this.j.setBackgroundResource(R.drawable.faceshop_package_btn_selector);
    }

    private void r() {
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.j.setText(this.a.getResources().getString(R.string.off_the_shelf));
        if (this.b == 1) {
            this.j.setTextColor(this.a.getResources().getColor(R.color.faceshop_downloaded_text_1));
            this.j.setBackgroundResource(R.drawable.btn_content_buy_d_1);
            return;
        }
        this.j.setTextColor(this.a.getResources().getColor(R.color.faceshop_downloaded_text));
        this.j.setBackgroundResource(R.drawable.btn_content_buy_d);
    }

    public void e() {
        if (this.w != null) {
            this.w.a();
            this.w.show();
        }
    }

    public void f() {
        if (this.w != null) {
            this.w.b();
        }
    }

    public void g() {
        if (this.w != null) {
            this.w.dismiss();
        }
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.c);
        if (this.d != null) {
            this.d.c(i);
        }
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public void h() {
        if (this.e != null && this.e.getVisibility() == 0 && UtilHelper.b()) {
            this.e.setVisible(false);
        }
    }

    public void i() {
        q();
    }

    public TextView j() {
        return this.j;
    }

    public ImageView k() {
        return this.n;
    }

    public void a(int i, Rect rect, FacePackageData facePackageData) {
        if (i != this.G && facePackageData.faceDynamicList != null && i >= 0 && i <= facePackageData.faceDynamicList.size()) {
            if (this.G != -1) {
                a(this.G, false);
            }
            this.G = i;
            this.s.setSelection(i);
            a(i, true);
            this.D = true;
            this.x.setVisibility(0);
            String str = "#(" + facePackageData.faceNameList.get(i) + ")";
            this.x.setTag(str);
            com.baidu.adp.widget.ImageView.b a = this.u.a(new StringBuilder(String.valueOf(facePackageData.pid)).toString(), str, facePackageData.faceDynamicList.get(i), true, this.I);
            if (a != null) {
                this.x.setGif(a);
                this.x.setIsLoading(false);
            } else {
                this.x.setIsLoading(true);
            }
            this.z.x = rect.left - ((this.A - rect.width()) / 2);
            this.z.y = rect.top - this.z.height;
            if (this.z.y < this.F) {
                this.E.scrollBy(0, this.z.y - this.F);
                this.z.y = this.F;
            }
            this.z.y += this.s.getChildAt(i - this.s.getFirstVisiblePosition()).getPaddingTop();
            if (!this.C) {
                this.y.addView(this.x, this.z);
                this.C = true;
                return;
            }
            this.y.updateViewLayout(this.x, this.z);
        }
    }

    public boolean l() {
        return this.D;
    }

    public void m() {
        this.D = false;
        this.x.setVisibility(8);
        this.s.setSelection(-1);
        a(this.G, false);
        this.G = -1;
    }

    private void a(int i, boolean z) {
        ((ViewGroup) this.s.getChildAt(i - this.s.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void n() {
        this.D = false;
        if (this.C) {
            this.C = false;
            this.y.removeView(this.x);
        }
    }

    public GridView o() {
        return this.s;
    }
}
