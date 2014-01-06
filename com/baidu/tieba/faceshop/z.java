package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class z {
    private com.baidu.tieba.j a;
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
    private Runnable x = new aa(this);

    public z(com.baidu.tieba.j jVar) {
        this.a = jVar;
        jVar.setContentView(R.layout.face_package_detail_activity);
        this.c = (LinearLayout) jVar.findViewById(R.id.face_package);
        this.d = (NavigationBar) jVar.findViewById(R.id.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a("");
        this.e = (NoNetworkView) jVar.findViewById(R.id.view_no_network);
        this.o = (LinearLayout) this.c.findViewById(R.id.face_package_container);
        this.f = (TbImageView) this.c.findViewById(R.id.face_package_cover);
        this.g = (TextView) this.c.findViewById(R.id.face_package_title);
        this.h = (TextView) this.c.findViewById(R.id.face_package_price);
        this.i = (TextView) this.c.findViewById(R.id.face_package_status);
        this.j = (TextView) this.c.findViewById(R.id.face_package_btn);
        this.k = (TextView) this.c.findViewById(R.id.face_package_info);
        this.s = (GridView) this.c.findViewById(R.id.face_package_faces);
        this.s.setSelection(-1);
        this.l = (FrameLayout) this.c.findViewById(R.id.face_package_downloading);
        this.m = (ImageView) this.c.findViewById(R.id.face_package_downloading_up);
        this.n = (ImageView) this.c.findViewById(R.id.face_package_downloading_cancel);
        this.b = TiebaApplication.g().an();
        this.u = new com.baidu.tieba.util.i(jVar);
        this.u.a(jVar.getResources().getDimensionPixelSize(R.dimen.faceshop_cover_width), jVar.getResources().getDimensionPixelSize(R.dimen.faceshop_cover_height));
        this.v = new Handler();
        this.j.setOnClickListener(jVar);
        this.n.setOnClickListener(jVar);
        Bitmap a = com.baidu.tieba.util.m.a((int) R.drawable.bg_content_buy_bar_down);
        Bitmap a2 = com.baidu.tieba.util.m.a((int) R.drawable.bg_content_buy_bar_up);
        this.q = a.getWidth();
        this.p = a2.getWidth();
        this.r = this.a.getResources().getDimensionPixelSize(R.dimen.faceshop_page_padding);
        this.w = new h(jVar, R.style.common_alert_dialog);
    }

    public void a(w wVar) {
        if (wVar != null) {
            b(wVar);
        }
    }

    private void b(FacePackageData facePackageData) {
        if (facePackageData != null && facePackageData.faceList != null) {
            this.s.setLayoutParams(new LinearLayout.LayoutParams(-1, ((com.baidu.adp.lib.h.g.b(this.a) - (this.r * 2)) / 4) * ((int) Math.ceil(facePackageData.faceList.size() / 4.0f))));
        }
    }

    public void a(String str) {
        if (str != null && str.length() > 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.c.j(linkedList));
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

    public void b(w wVar) {
        FacePackageData facePackageData;
        if (wVar != null && wVar.a() != null && (facePackageData = wVar.a().facePackage) != null) {
            if (wVar.c()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.o.setVisibility(0);
            this.f.setTag(facePackageData.coverUrl);
            this.g.setText(facePackageData.pname);
            this.h.setText(this.a.getResources().getString(R.string.price_tip) + facePackageData.price);
            this.k.setText(facePackageData.pdesc);
            this.d.a(facePackageData.pname);
            b(facePackageData);
            a(wVar.e());
            a(facePackageData);
            l();
        }
    }

    private void l() {
        if (this.v != null) {
            this.v.removeCallbacks(this.x);
            this.v.postDelayed(this.x, 300L);
        }
    }

    private void m() {
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
                this.u.a(obj, new ab(this));
            } else {
                this.f.invalidate();
            }
        }
    }

    public void a(com.baidu.tieba.view.bf bfVar) {
        this.e.a(bfVar);
    }

    public void b(com.baidu.tieba.view.bf bfVar) {
        this.e.b(bfVar);
    }

    public void c(w wVar) {
        if (wVar != null && wVar.a() != null && wVar.a().facePackage != null) {
            FacePackageData facePackageData = wVar.a().facePackage;
            if (facePackageData.buyStatus == 1) {
                this.i.setText(this.a.getResources().getString(R.string.has_buy));
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
            switch (wVar.d()) {
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
                    n();
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

    private void n() {
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
        this.a.getLayoutMode().a(this.c);
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
        m();
    }

    public TextView j() {
        return this.j;
    }

    public ImageView k() {
        return this.n;
    }
}
