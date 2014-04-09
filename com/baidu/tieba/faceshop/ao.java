package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.download.QueryDownloadMessage;
import com.compatible.menukey.MenuKeyUtils;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class ao {
    private WindowManager.LayoutParams A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private final ScrollView F;
    private int G;
    private final TbImageView I;
    private final com.baidu.tbadk.a a;
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
    private av u;
    private final com.baidu.tbadk.editortool.ab v;
    private final Handler w;
    private final x x;
    private GifView y;
    private WindowManager z;
    private int H = -1;
    private final com.baidu.tbadk.imageManager.d J = new ap(this);
    private final Runnable K = new aq(this);

    public ao(com.baidu.tbadk.a aVar) {
        this.a = aVar;
        aVar.setContentView(com.baidu.tieba.a.i.face_package_detail_activity);
        this.c = (LinearLayout) aVar.findViewById(com.baidu.tieba.a.h.face_package);
        this.d = (NavigationBar) aVar.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h = this.d.a("");
        this.e = (NoNetworkView) aVar.findViewById(com.baidu.tieba.a.h.view_no_network);
        this.p = (LinearLayout) this.c.findViewById(com.baidu.tieba.a.h.face_package_container);
        this.f = (TbImageView) this.c.findViewById(com.baidu.tieba.a.h.face_package_cover);
        this.g = (TextView) this.c.findViewById(com.baidu.tieba.a.h.face_package_title);
        this.i = (TextView) this.c.findViewById(com.baidu.tieba.a.h.face_package_price);
        this.j = (TextView) this.c.findViewById(com.baidu.tieba.a.h.face_package_status);
        this.k = (TextView) this.c.findViewById(com.baidu.tieba.a.h.face_package_btn);
        this.l = (TextView) this.c.findViewById(com.baidu.tieba.a.h.face_package_info);
        this.t = (GridView) this.c.findViewById(com.baidu.tieba.a.h.face_package_faces);
        this.I = (TbImageView) this.c.findViewById(com.baidu.tieba.a.h.face_package_title_tag);
        this.t.setSelection(-1);
        this.t.setOnItemLongClickListener(aVar);
        this.m = (FrameLayout) this.c.findViewById(com.baidu.tieba.a.h.face_package_downloading);
        this.n = (ImageView) this.c.findViewById(com.baidu.tieba.a.h.face_package_downloading_up);
        this.o = (ImageView) this.c.findViewById(com.baidu.tieba.a.h.face_package_downloading_cancel);
        this.b = TbadkApplication.j().l();
        this.v = new com.baidu.tbadk.editortool.ab(aVar);
        this.v.a(aVar.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.faceshop_cover_width), aVar.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.faceshop_cover_height));
        this.w = new Handler();
        this.k.setOnClickListener(aVar);
        this.o.setOnClickListener(aVar);
        Bitmap a = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.bg_content_buy_bar_down);
        Bitmap a2 = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.bg_content_buy_bar_up);
        this.r = a.getWidth();
        this.q = a2.getWidth();
        this.s = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.faceshop_page_padding);
        this.x = new x(aVar, com.baidu.tieba.a.l.common_alert_dialog);
        this.F = (ScrollView) this.c.findViewById(com.baidu.tieba.a.h.container_scrollview);
        int l = TbadkApplication.j().l();
        this.y = new GifView(aVar);
        if (l == 1) {
            this.y.setBackgroundResource(com.baidu.tieba.a.g.bg_expression_bubble_1);
        } else {
            this.y.setBackgroundResource(com.baidu.tieba.a.g.bg_expression_bubble);
        }
        this.y.setVisibility(8);
        this.z = (WindowManager) aVar.getSystemService("window");
        this.A = new WindowManager.LayoutParams();
        this.B = aVar.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.face_tab_content_float_width);
        this.C = aVar.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.face_tab_content_float_height);
        this.A.width = this.B;
        this.A.height = this.C;
        this.A.gravity = 51;
        this.A.format = -3;
        this.A.type = LocationClientOption.MIN_SCAN_SPAN;
        this.A.flags |= 56;
        this.G = com.baidu.adp.lib.util.i.a((Activity) aVar);
        if (MenuKeyUtils.hasSmartBar()) {
            this.A.type = LocationClientOption.MIN_SCAN_SPAN;
            this.A.flags = 25165832;
        }
    }

    public final void a(am amVar) {
        FacePackageData facePackageData;
        if (amVar != null && amVar.a() != null && (facePackageData = amVar.a().facePackage) != null) {
            if (amVar.c()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.p.setVisibility(0);
            this.f.setTag(facePackageData.coverUrl);
            this.g.setText(facePackageData.pname);
            this.I.setTag(facePackageData.tagUrl);
            this.i.setText(String.valueOf(this.a.getResources().getString(com.baidu.tieba.a.k.price_tip)) + facePackageData.price);
            this.l.setText(facePackageData.pdesc);
            this.h.setText(facePackageData.pname);
            if (facePackageData != null && facePackageData.faceList != null) {
                this.t.setLayoutParams(new LinearLayout.LayoutParams(-1, ((com.baidu.adp.lib.util.i.b(this.a) - (this.s * 2)) / 4) * ((int) Math.ceil(facePackageData.faceList.size() / 4.0f))));
            }
            String e = amVar.e();
            if (e != null && e.length() > 0) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(e);
                com.baidu.adp.framework.c.a().b(new QueryDownloadMessage(linkedList));
            }
            if (facePackageData != null) {
                if (this.u == null) {
                    this.u = new av(this.a, facePackageData.faceList);
                    this.t.setAdapter((ListAdapter) this.u);
                } else {
                    this.u.a(facePackageData.faceList);
                    this.u.notifyDataSetChanged();
                }
            }
            if (this.w != null) {
                this.w.removeCallbacks(this.K);
                this.w.postDelayed(this.K, 300L);
            }
        }
    }

    public final void a() {
        if (this.v != null && this.f != null) {
            this.v.a();
            String obj = this.f.getTag().toString();
            com.baidu.tbadk.editortool.ab abVar = this.v;
            if (com.baidu.tbadk.imageManager.e.a().c(obj) == null) {
                this.v.b(obj, new ar(this));
            } else {
                this.f.invalidate();
            }
            String obj2 = this.I.getTag().toString();
            com.baidu.tbadk.editortool.ab abVar2 = this.v;
            if (com.baidu.tbadk.imageManager.e.a().c(obj2) == null) {
                this.v.b(obj2, new as(this));
                return;
            }
            this.I.setVisibility(0);
            this.I.invalidate();
        }
    }

    public final void a(com.baidu.tbadk.core.view.m mVar) {
        this.e.a(mVar);
    }

    public final void b(com.baidu.tbadk.core.view.m mVar) {
        this.e.b(mVar);
    }

    public final void b(am amVar) {
        if (amVar != null && amVar.a() != null && amVar.a().facePackage != null) {
            FacePackageData facePackageData = amVar.a().facePackage;
            if (facePackageData.buyStatus == 1) {
                this.j.setText(this.a.getResources().getString(com.baidu.tieba.a.k.has_buy));
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            switch (amVar.d()) {
                case 1:
                    this.k.setVisibility(0);
                    this.m.setVisibility(8);
                    this.k.setText(this.a.getResources().getString(com.baidu.tieba.a.k.downloaded));
                    if (this.b != 1) {
                        this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.faceshop_downloaded_text));
                        this.k.setBackgroundResource(com.baidu.tieba.a.g.btn_content_buy_d);
                        return;
                    }
                    this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.faceshop_downloaded_text_1));
                    this.k.setBackgroundResource(com.baidu.tieba.a.g.btn_content_buy_d_1);
                    return;
                case 2:
                case 3:
                    b();
                    return;
                case 4:
                    this.k.setVisibility(0);
                    this.m.setVisibility(8);
                    this.k.setText(this.a.getResources().getString(com.baidu.tieba.a.k.buy_package));
                    if (this.b == 1) {
                        this.k.setBackgroundResource(com.baidu.tieba.a.g.faceshop_package_btn_selector_1);
                        return;
                    } else {
                        this.k.setBackgroundResource(com.baidu.tieba.a.g.faceshop_package_btn_selector);
                        return;
                    }
                case 5:
                    long j = facePackageData.downloadTotal;
                    long j2 = facePackageData.downloadNow;
                    this.k.setVisibility(8);
                    this.m.setVisibility(0);
                    int i = (int) ((((float) j2) / ((float) j)) * this.r);
                    int i2 = i < this.q ? this.q : i;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
                    layoutParams.width = i2;
                    this.n.setLayoutParams(layoutParams);
                    return;
                case 6:
                    this.k.setVisibility(0);
                    this.m.setVisibility(8);
                    this.k.setText(this.a.getResources().getString(com.baidu.tieba.a.k.off_the_shelf));
                    if (this.b == 1) {
                        this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.faceshop_downloaded_text_1));
                        this.k.setBackgroundResource(com.baidu.tieba.a.g.btn_content_buy_d_1);
                        return;
                    }
                    this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.faceshop_downloaded_text));
                    this.k.setBackgroundResource(com.baidu.tieba.a.g.btn_content_buy_d);
                    return;
                default:
                    return;
            }
        }
    }

    public final void b() {
        this.k.setVisibility(0);
        this.m.setVisibility(8);
        this.k.setText(this.a.getResources().getString(com.baidu.tieba.a.k.can_download));
        if (this.b == 1) {
            this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.faceshop_package_btn_text_1));
            this.k.setBackgroundResource(com.baidu.tieba.a.g.faceshop_package_btn_selector_1);
            return;
        }
        this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.faceshop_package_btn_text));
        this.k.setBackgroundResource(com.baidu.tieba.a.g.faceshop_package_btn_selector);
    }

    public final void c() {
        if (this.x != null) {
            this.x.a();
            this.x.show();
        }
    }

    public final void d() {
        if (this.x != null) {
            this.x.b();
        }
    }

    public final void e() {
        if (this.x != null) {
            this.x.dismiss();
        }
    }

    public final void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.c);
        if (this.d != null) {
            this.d.b(i);
        }
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public final void f() {
        if (this.e != null && this.e.getVisibility() == 0 && UtilHelper.a()) {
            this.e.setVisible(false);
        }
    }

    public final void g() {
        if (this.v != null) {
            this.v.c();
        }
        if (this.u != null) {
            this.u.a();
        }
    }

    public final TextView h() {
        return this.k;
    }

    public final ImageView i() {
        return this.o;
    }

    public final void a(int i, Rect rect, FacePackageData facePackageData) {
        if (i != this.H && facePackageData.faceDynamicList != null && i >= 0 && i <= facePackageData.faceDynamicList.size()) {
            if (this.H != -1) {
                a(this.H, false);
            }
            this.H = i;
            this.t.setSelection(i);
            a(i, true);
            this.E = true;
            this.y.setVisibility(0);
            String str = "#(" + facePackageData.faceNameList.get(i) + ")";
            this.y.setTag(str);
            if (com.baidu.tbadk.editortool.ab.b()) {
                com.baidu.adp.widget.ImageView.b a = this.v.a(new StringBuilder(String.valueOf(facePackageData.pid)).toString(), str, facePackageData.faceDynamicList.get(i), true, this.J, false);
                if (a != null) {
                    this.y.setGif(a);
                    this.y.setIsLoading(false);
                } else {
                    this.y.setIsLoading(true);
                }
            } else {
                String str2 = facePackageData.faceList.get(i);
                com.baidu.tbadk.editortool.ab abVar = this.v;
                com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(str2);
                if (c != null) {
                    this.y.setGif(c);
                    this.y.setIsLoading(false);
                } else {
                    this.y.setIsLoading(true);
                    this.v.b(str2, this.J);
                }
            }
            this.A.x = rect.left - ((this.B - rect.width()) / 2);
            this.A.y = rect.top - this.A.height;
            if (this.A.y < this.G) {
                this.F.scrollBy(0, this.A.y - this.G);
                this.A.y = this.G;
            }
            this.A.y += this.t.getChildAt(i - this.t.getFirstVisiblePosition()).getPaddingTop();
            if (!this.D) {
                this.z.addView(this.y, this.A);
                this.D = true;
                return;
            }
            this.z.updateViewLayout(this.y, this.A);
        }
    }

    public final boolean j() {
        return this.E;
    }

    public final void k() {
        this.E = false;
        this.y.setVisibility(8);
        this.t.setSelection(-1);
        a(this.H, false);
        this.H = -1;
    }

    private void a(int i, boolean z) {
        ((ViewGroup) this.t.getChildAt(i - this.t.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public final void l() {
        this.E = false;
        if (this.D) {
            this.D = false;
            this.z.removeView(this.y);
        }
    }

    public final GridView m() {
        return this.t;
    }
}
