package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.download.QueryDownloadMessage;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.compatible.menukey.MenuKeyUtils;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class am {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private final ScrollView E;
    private int F;
    private final TbImageView H;
    private int I;
    private int J;
    private final BaseActivity a;
    private final int b;
    private final LinearLayout c;
    private final NavigationBar d;
    private final NoNetworkView e;
    private final TbImageView f;
    private final TextView g;
    private TextView h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final FrameLayout m;
    private final ImageView n;
    private final ImageView o;
    private final LinearLayout p;
    private final int q;
    private final int r;
    private final int s;
    private final GridView t;
    private ar u;
    private final Handler v;
    private final v w;
    private GifView x;
    private WindowManager y;
    private WindowManager.LayoutParams z;
    private int G = -1;
    private final Runnable K = new an(this);

    public am(BaseActivity baseActivity) {
        this.a = baseActivity;
        baseActivity.setContentView(com.baidu.tieba.v.face_package_detail_activity);
        this.c = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.face_package);
        this.d = (NavigationBar) baseActivity.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h = this.d.a("");
        this.e = (NoNetworkView) baseActivity.findViewById(com.baidu.tieba.u.view_no_network);
        this.p = (LinearLayout) this.c.findViewById(com.baidu.tieba.u.face_package_container);
        this.f = (TbImageView) this.c.findViewById(com.baidu.tieba.u.face_package_cover);
        this.g = (TextView) this.c.findViewById(com.baidu.tieba.u.face_package_title);
        this.i = (TextView) this.c.findViewById(com.baidu.tieba.u.face_package_price);
        this.j = (TextView) this.c.findViewById(com.baidu.tieba.u.face_package_status);
        this.k = (TextView) this.c.findViewById(com.baidu.tieba.u.face_package_btn);
        this.l = (TextView) this.c.findViewById(com.baidu.tieba.u.face_package_info);
        this.t = (GridView) this.c.findViewById(com.baidu.tieba.u.face_package_faces);
        this.H = (TbImageView) this.c.findViewById(com.baidu.tieba.u.face_package_title_tag);
        this.t.setSelection(-1);
        this.t.setOnItemLongClickListener(baseActivity);
        this.m = (FrameLayout) this.c.findViewById(com.baidu.tieba.u.face_package_downloading);
        this.n = (ImageView) this.c.findViewById(com.baidu.tieba.u.face_package_downloading_up);
        this.o = (ImageView) this.c.findViewById(com.baidu.tieba.u.face_package_downloading_cancel);
        this.b = TbadkApplication.m252getInst().getSkinType();
        this.I = baseActivity.getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_cover_width);
        this.J = baseActivity.getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_cover_height);
        this.v = new Handler();
        this.k.setOnClickListener(baseActivity);
        this.o.setOnClickListener(baseActivity);
        Bitmap a = com.baidu.tbadk.core.util.d.a(com.baidu.tieba.t.bg_content_buy_bar_down);
        Bitmap a2 = com.baidu.tbadk.core.util.d.a(com.baidu.tieba.t.bg_content_buy_bar_up);
        this.r = a.getWidth();
        this.q = a2.getWidth();
        this.s = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_page_padding);
        this.w = new v(baseActivity, com.baidu.tieba.y.common_alert_dialog);
        this.E = (ScrollView) this.c.findViewById(com.baidu.tieba.u.container_scrollview);
        a(baseActivity);
    }

    private void a(Context context) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.x = new GifView(context);
        if (skinType == 1) {
            this.x.setBackgroundResource(com.baidu.tieba.t.bg_expression_bubble_1);
        } else {
            this.x.setBackgroundResource(com.baidu.tieba.t.bg_expression_bubble);
        }
        this.x.setVisibility(8);
        this.y = (WindowManager) context.getSystemService("window");
        this.z = new WindowManager.LayoutParams();
        this.A = context.getResources().getDimensionPixelSize(com.baidu.tieba.s.face_tab_content_float_width);
        this.B = context.getResources().getDimensionPixelSize(com.baidu.tieba.s.face_tab_content_float_height);
        this.z.width = this.A;
        this.z.height = this.B;
        this.z.gravity = 51;
        this.z.format = -3;
        this.z.type = 1000;
        this.z.flags |= 56;
        this.F = com.baidu.adp.lib.util.j.a((Activity) context);
        if (MenuKeyUtils.hasSmartBar()) {
            this.z.type = 1000;
            this.z.flags = 25165832;
        }
    }

    public void a(ak akVar) {
        if (akVar != null) {
            b(akVar);
        }
    }

    private void b(FacePackageData facePackageData) {
        if (facePackageData != null && facePackageData.faceList != null) {
            this.t.setLayoutParams(new LinearLayout.LayoutParams(-1, ((com.baidu.adp.lib.util.j.b(this.a) - (this.s * 2)) / 4) * ((int) Math.ceil(facePackageData.faceList.size() / 4.0f))));
        }
    }

    public void a(String str) {
        if (str != null && str.length() > 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(linkedList));
        }
    }

    public void a(FacePackageData facePackageData) {
        if (facePackageData != null) {
            if (this.u == null) {
                this.u = new ar(this.a, facePackageData.faceList);
                this.t.setAdapter((ListAdapter) this.u);
                return;
            }
            this.u.a(facePackageData.faceList);
            this.u.notifyDataSetChanged();
        }
    }

    public void b(ak akVar) {
        FacePackageData facePackageData;
        if (akVar != null && akVar.a() != null && (facePackageData = akVar.a().facePackage) != null) {
            if (akVar.c()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.p.setVisibility(0);
            this.f.setTag(facePackageData.coverUrl);
            if (!TextUtils.isEmpty(facePackageData.pname) && facePackageData.pname.length() > 9) {
                this.g.setText(String.valueOf(facePackageData.pname.substring(0, 8)) + "...");
            } else {
                this.g.setText(facePackageData.pname);
            }
            this.H.setTag(facePackageData.tagUrl);
            this.i.setText(String.valueOf(this.a.getResources().getString(com.baidu.tieba.x.price_tip)) + facePackageData.price);
            this.l.setText(facePackageData.pdesc);
            this.h.setText(facePackageData.pname);
            b(facePackageData);
            a(akVar.e());
            a(facePackageData);
            o();
        }
    }

    private void o() {
        if (this.v != null) {
            this.v.removeCallbacks(this.K);
            this.v.postDelayed(this.K, 90L);
        }
    }

    public void a() {
        if (this.f != null) {
            this.f.a(this.f.getTag().toString(), 10, this.I, this.J, false);
            String obj = this.H.getTag().toString();
            this.H.setVisibility(8);
            this.H.setEvent(new ao(this));
            this.H.a(obj, 10, this.I, this.J, false);
        }
    }

    public void a(com.baidu.tbadk.core.view.q qVar) {
        this.e.a(qVar);
    }

    public void b(com.baidu.tbadk.core.view.q qVar) {
        this.e.b(qVar);
    }

    public void c(ak akVar) {
        if (akVar != null && akVar.a() != null && akVar.a().facePackage != null) {
            FacePackageData facePackageData = akVar.a().facePackage;
            if (facePackageData.buyStatus == 1) {
                this.j.setText(this.a.getResources().getString(com.baidu.tieba.x.has_buy));
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            switch (akVar.d()) {
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
                    p();
                    return;
                default:
                    return;
            }
        }
    }

    public void b() {
        this.k.setVisibility(0);
        this.m.setVisibility(8);
        this.k.setText(this.a.getResources().getString(com.baidu.tieba.x.downloaded));
        if (this.b == 1) {
            this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text_1));
            this.k.setBackgroundResource(com.baidu.tieba.t.btn_content_buy_d_1);
            return;
        }
        this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text));
        this.k.setBackgroundResource(com.baidu.tieba.t.btn_content_buy_d);
    }

    public void a(long j, long j2) {
        this.k.setVisibility(8);
        this.m.setVisibility(0);
        int i = (int) ((((float) j2) / ((float) j)) * this.r);
        int i2 = i < this.q ? this.q : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.width = i2;
        this.n.setLayoutParams(layoutParams);
    }

    public void c() {
        this.k.setVisibility(0);
        this.m.setVisibility(8);
        this.k.setText(this.a.getResources().getString(com.baidu.tieba.x.buy_package));
        if (this.b == 1) {
            this.k.setBackgroundResource(com.baidu.tieba.t.faceshop_package_btn_selector_1);
        } else {
            this.k.setBackgroundResource(com.baidu.tieba.t.faceshop_package_btn_selector);
        }
    }

    public void d() {
        this.k.setVisibility(0);
        this.m.setVisibility(8);
        this.k.setText(this.a.getResources().getString(com.baidu.tieba.x.can_download));
        if (this.b == 1) {
            this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.faceshop_package_btn_text_1));
            this.k.setBackgroundResource(com.baidu.tieba.t.faceshop_package_btn_selector_1);
            return;
        }
        this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.faceshop_package_btn_text));
        this.k.setBackgroundResource(com.baidu.tieba.t.faceshop_package_btn_selector);
    }

    private void p() {
        this.k.setVisibility(0);
        this.m.setVisibility(8);
        this.k.setText(this.a.getResources().getString(com.baidu.tieba.x.off_the_shelf));
        if (this.b == 1) {
            this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text_1));
            this.k.setBackgroundResource(com.baidu.tieba.t.btn_content_buy_d_1);
            return;
        }
        this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text));
        this.k.setBackgroundResource(com.baidu.tieba.t.btn_content_buy_d);
    }

    public void e() {
        if (this.w != null) {
            this.w.a();
            com.baidu.adp.lib.e.d.a(this.w, this.a);
        }
    }

    public void f() {
        if (this.w != null) {
            this.w.b();
        }
    }

    public void g() {
        if (this.w != null) {
            com.baidu.adp.lib.e.d.b(this.w, this.a);
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
        if (this.e != null && this.e.getVisibility() == 0 && UtilHelper.isNetOk()) {
            this.e.a(false);
        }
    }

    public TextView i() {
        return this.k;
    }

    public ImageView j() {
        return this.o;
    }

    public void a(int i, Rect rect, FacePackageData facePackageData) {
        if (i != this.G && facePackageData.faceDynamicList != null && i >= 0 && i <= facePackageData.faceDynamicList.size()) {
            if (this.G != -1) {
                a(this.G, false);
            }
            this.G = i;
            this.t.setSelection(i);
            a(i, true);
            this.D = true;
            this.x.setVisibility(0);
            String str = "#(" + facePackageData.faceNameList.get(i) + ")";
            this.x.setTag(str);
            if (com.baidu.tbadk.c.c.b()) {
                com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
                aVar.e = new StringBuilder(String.valueOf(facePackageData.pid)).toString();
                aVar.b = str;
                aVar.g = this.J;
                aVar.f = this.I;
                aVar.d = facePackageData.faceDynamicList.get(i);
                this.x.a(aVar);
            } else {
                com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
                aVar2.e = new StringBuilder(String.valueOf(facePackageData.pid)).toString();
                aVar2.g = this.J;
                aVar2.f = this.I;
                aVar2.b = str;
                aVar2.c = facePackageData.faceList.get(i);
                this.x.a(aVar2);
            }
            this.z.x = rect.left - ((this.A - rect.width()) / 2);
            this.z.y = rect.top - this.z.height;
            if (this.z.y < this.F) {
                this.E.scrollBy(0, this.z.y - this.F);
                this.z.y = this.F;
            }
            this.z.y += this.t.getChildAt(i - this.t.getFirstVisiblePosition()).getPaddingTop();
            if (!this.C) {
                this.y.addView(this.x, this.z);
                this.C = true;
                return;
            }
            this.y.updateViewLayout(this.x, this.z);
        }
    }

    public boolean k() {
        return this.D;
    }

    public void l() {
        this.D = false;
        this.x.setVisibility(8);
        this.t.setSelection(-1);
        a(this.G, false);
        this.G = -1;
    }

    private void a(int i, boolean z) {
        ((ViewGroup) this.t.getChildAt(i - this.t.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void m() {
        this.D = false;
        if (this.C) {
            this.C = false;
            this.y.removeView(this.x);
        }
    }

    public GridView n() {
        return this.t;
    }
}
