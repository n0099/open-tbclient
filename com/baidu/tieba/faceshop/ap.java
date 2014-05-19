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
import com.baidu.adp.framework.MessageManager;
import com.baidu.location.LocationClientOption;
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
public class ap {
    private WindowManager.LayoutParams A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private final ScrollView F;
    private int G;
    private final TbImageView I;
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
    private aw u;
    private final com.baidu.tbadk.editortool.ab v;
    private final Handler w;
    private final y x;
    private GifView y;
    private WindowManager z;
    private int H = -1;
    private final com.baidu.tbadk.imageManager.d J = new aq(this);
    private final Runnable K = new ar(this);

    public ap(BaseActivity baseActivity) {
        this.a = baseActivity;
        baseActivity.setContentView(com.baidu.tieba.s.face_package_detail_activity);
        this.c = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.face_package);
        this.d = (NavigationBar) baseActivity.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h = this.d.a("");
        this.e = (NoNetworkView) baseActivity.findViewById(com.baidu.tieba.r.view_no_network);
        this.p = (LinearLayout) this.c.findViewById(com.baidu.tieba.r.face_package_container);
        this.f = (TbImageView) this.c.findViewById(com.baidu.tieba.r.face_package_cover);
        this.g = (TextView) this.c.findViewById(com.baidu.tieba.r.face_package_title);
        this.i = (TextView) this.c.findViewById(com.baidu.tieba.r.face_package_price);
        this.j = (TextView) this.c.findViewById(com.baidu.tieba.r.face_package_status);
        this.k = (TextView) this.c.findViewById(com.baidu.tieba.r.face_package_btn);
        this.l = (TextView) this.c.findViewById(com.baidu.tieba.r.face_package_info);
        this.t = (GridView) this.c.findViewById(com.baidu.tieba.r.face_package_faces);
        this.I = (TbImageView) this.c.findViewById(com.baidu.tieba.r.face_package_title_tag);
        this.t.setSelection(-1);
        this.t.setOnItemLongClickListener(baseActivity);
        this.m = (FrameLayout) this.c.findViewById(com.baidu.tieba.r.face_package_downloading);
        this.n = (ImageView) this.c.findViewById(com.baidu.tieba.r.face_package_downloading_up);
        this.o = (ImageView) this.c.findViewById(com.baidu.tieba.r.face_package_downloading_cancel);
        this.b = TbadkApplication.m252getInst().getSkinType();
        this.v = new com.baidu.tbadk.editortool.ab(baseActivity);
        this.v.a(baseActivity.getResources().getDimensionPixelSize(com.baidu.tieba.p.faceshop_cover_width), baseActivity.getResources().getDimensionPixelSize(com.baidu.tieba.p.faceshop_cover_height));
        this.w = new Handler();
        this.k.setOnClickListener(baseActivity);
        this.o.setOnClickListener(baseActivity);
        Bitmap a = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.bg_content_buy_bar_down);
        Bitmap a2 = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.bg_content_buy_bar_up);
        this.r = a.getWidth();
        this.q = a2.getWidth();
        this.s = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.faceshop_page_padding);
        this.x = new y(baseActivity, com.baidu.tieba.v.common_alert_dialog);
        this.F = (ScrollView) this.c.findViewById(com.baidu.tieba.r.container_scrollview);
        a(baseActivity);
    }

    private void a(Context context) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.y = new GifView(context);
        if (skinType == 1) {
            this.y.setBackgroundResource(com.baidu.tieba.q.bg_expression_bubble_1);
        } else {
            this.y.setBackgroundResource(com.baidu.tieba.q.bg_expression_bubble);
        }
        this.y.setVisibility(8);
        this.z = (WindowManager) context.getSystemService("window");
        this.A = new WindowManager.LayoutParams();
        this.B = context.getResources().getDimensionPixelSize(com.baidu.tieba.p.face_tab_content_float_width);
        this.C = context.getResources().getDimensionPixelSize(com.baidu.tieba.p.face_tab_content_float_height);
        this.A.width = this.B;
        this.A.height = this.C;
        this.A.gravity = 51;
        this.A.format = -3;
        this.A.type = LocationClientOption.MIN_SCAN_SPAN;
        this.A.flags |= 56;
        this.G = com.baidu.adp.lib.util.h.a((Activity) context);
        if (MenuKeyUtils.hasSmartBar()) {
            this.A.type = LocationClientOption.MIN_SCAN_SPAN;
            this.A.flags = 25165832;
        }
    }

    public void a(an anVar) {
        if (anVar != null) {
            b(anVar);
        }
    }

    private void b(FacePackageData facePackageData) {
        if (facePackageData != null && facePackageData.faceList != null) {
            this.t.setLayoutParams(new LinearLayout.LayoutParams(-1, ((com.baidu.adp.lib.util.h.b(this.a) - (this.s * 2)) / 4) * ((int) Math.ceil(facePackageData.faceList.size() / 4.0f))));
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
                this.u = new aw(this.a, facePackageData.faceList);
                this.t.setAdapter((ListAdapter) this.u);
                return;
            }
            this.u.a(facePackageData.faceList);
            this.u.notifyDataSetChanged();
        }
    }

    public void b(an anVar) {
        FacePackageData facePackageData;
        if (anVar != null && anVar.a() != null && (facePackageData = anVar.a().facePackage) != null) {
            if (anVar.c()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.p.setVisibility(0);
            this.f.setTag(facePackageData.coverUrl);
            this.g.setText(facePackageData.pname);
            this.I.setTag(facePackageData.tagUrl);
            this.i.setText(String.valueOf(this.a.getResources().getString(com.baidu.tieba.u.price_tip)) + facePackageData.price);
            this.l.setText(facePackageData.pdesc);
            this.h.setText(facePackageData.pname);
            b(facePackageData);
            a(anVar.e());
            a(facePackageData);
            p();
        }
    }

    private void p() {
        if (this.w != null) {
            this.w.removeCallbacks(this.K);
            this.w.postDelayed(this.K, 90L);
        }
    }

    private void q() {
        if (this.v != null) {
            this.v.d();
        }
        if (this.u != null) {
            this.u.a();
        }
    }

    public void a() {
        if (this.v != null && this.f != null) {
            this.v.a();
            String obj = this.f.getTag().toString();
            if (this.v.d(obj) == null) {
                this.v.b(obj, new as(this));
            } else {
                this.f.invalidate();
            }
            String obj2 = this.I.getTag().toString();
            if (this.v.d(obj2) == null) {
                this.v.b(obj2, new at(this));
                return;
            }
            this.I.setVisibility(0);
            this.I.invalidate();
        }
    }

    public void a(com.baidu.tbadk.core.view.m mVar) {
        this.e.a(mVar);
    }

    public void b(com.baidu.tbadk.core.view.m mVar) {
        this.e.b(mVar);
    }

    public void c(an anVar) {
        if (anVar != null && anVar.a() != null && anVar.a().facePackage != null) {
            FacePackageData facePackageData = anVar.a().facePackage;
            if (facePackageData.buyStatus == 1) {
                this.j.setText(this.a.getResources().getString(com.baidu.tieba.u.has_buy));
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            switch (anVar.d()) {
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
        this.k.setVisibility(0);
        this.m.setVisibility(8);
        this.k.setText(this.a.getResources().getString(com.baidu.tieba.u.downloaded));
        if (this.b == 1) {
            this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.faceshop_downloaded_text_1));
            this.k.setBackgroundResource(com.baidu.tieba.q.btn_content_buy_d_1);
            return;
        }
        this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.faceshop_downloaded_text));
        this.k.setBackgroundResource(com.baidu.tieba.q.btn_content_buy_d);
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
        this.k.setText(this.a.getResources().getString(com.baidu.tieba.u.buy_package));
        if (this.b == 1) {
            this.k.setBackgroundResource(com.baidu.tieba.q.faceshop_package_btn_selector_1);
        } else {
            this.k.setBackgroundResource(com.baidu.tieba.q.faceshop_package_btn_selector);
        }
    }

    public void d() {
        this.k.setVisibility(0);
        this.m.setVisibility(8);
        this.k.setText(this.a.getResources().getString(com.baidu.tieba.u.can_download));
        if (this.b == 1) {
            this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.faceshop_package_btn_text_1));
            this.k.setBackgroundResource(com.baidu.tieba.q.faceshop_package_btn_selector_1);
            return;
        }
        this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.faceshop_package_btn_text));
        this.k.setBackgroundResource(com.baidu.tieba.q.faceshop_package_btn_selector);
    }

    private void r() {
        this.k.setVisibility(0);
        this.m.setVisibility(8);
        this.k.setText(this.a.getResources().getString(com.baidu.tieba.u.off_the_shelf));
        if (this.b == 1) {
            this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.faceshop_downloaded_text_1));
            this.k.setBackgroundResource(com.baidu.tieba.q.btn_content_buy_d_1);
            return;
        }
        this.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.faceshop_downloaded_text));
        this.k.setBackgroundResource(com.baidu.tieba.q.btn_content_buy_d);
    }

    public void e() {
        if (this.x != null) {
            this.x.a();
            this.x.show();
        }
    }

    public void f() {
        if (this.x != null) {
            this.x.b();
        }
    }

    public void g() {
        if (this.x != null) {
            this.x.dismiss();
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
            this.e.setVisible(false);
        }
    }

    public void i() {
        q();
    }

    public TextView j() {
        return this.k;
    }

    public ImageView k() {
        return this.o;
    }

    public void a(int i, Rect rect, FacePackageData facePackageData) {
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
            if (com.baidu.tbadk.editortool.ab.c()) {
                com.baidu.adp.widget.a.a a = this.v.a(new StringBuilder(String.valueOf(facePackageData.pid)).toString(), str, facePackageData.faceDynamicList.get(i), true, this.J, false);
                if (a != null) {
                    this.y.setGif(a);
                    this.y.setIsLoading(false);
                } else {
                    this.y.setIsLoading(true);
                }
            } else {
                String str2 = facePackageData.faceList.get(i);
                com.baidu.adp.widget.a.a d = this.v.d(str2);
                if (d != null) {
                    this.y.setGif(d);
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

    public boolean l() {
        return this.E;
    }

    public void m() {
        this.E = false;
        this.y.setVisibility(8);
        this.t.setSelection(-1);
        a(this.H, false);
        this.H = -1;
    }

    private void a(int i, boolean z) {
        ((ViewGroup) this.t.getChildAt(i - this.t.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void n() {
        this.E = false;
        if (this.D) {
            this.D = false;
            this.z.removeView(this.y);
        }
    }

    public GridView o() {
        return this.t;
    }
}
