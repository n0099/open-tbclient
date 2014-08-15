package com.baidu.tieba.album;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.f {
    private final int a;
    private String b;
    private String c;
    private String d;
    private LinearLayout e;
    private Button f;
    private HorizontalScrollView g;
    private LinearLayout h;
    private RelativeLayout i;
    private ImageView j;
    private AlbumActivity k;
    private com.baidu.tbadk.img.e l;
    private Fragment[] m;
    private String[] n;
    private FrameLayout[] o;
    private int p;
    private int q;
    private Handler r;
    private Runnable s;

    public v(AlbumActivity albumActivity) {
        super(albumActivity);
        this.a = 3;
        this.b = "tag_album";
        this.c = "tag_image";
        this.d = "tag_b_image";
        this.r = new Handler();
        this.k = albumActivity;
        this.l = new com.baidu.tbadk.img.e(albumActivity);
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(com.baidu.tieba.v.album_activity);
        this.e = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.u.parent);
        this.f = (Button) albumActivity.findViewById(com.baidu.tieba.u.btn_done);
        this.f.setOnClickListener(albumActivity);
        this.g = (HorizontalScrollView) albumActivity.findViewById(com.baidu.tieba.u.bottom_scroll);
        this.h = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.u.bottom_container);
        this.i = (RelativeLayout) albumActivity.findViewById(com.baidu.tieba.u.lay_bottom);
        this.j = (ImageView) albumActivity.findViewById(com.baidu.tieba.u.add_more);
        this.p = (int) this.k.getResources().getDimension(com.baidu.tieba.s.album_bottom_item_height);
        this.q = (int) this.k.getResources().getDimension(com.baidu.tieba.s.default_gap_4);
    }

    public void a(int i) {
        this.o = new FrameLayout[i];
        LayoutInflater from = LayoutInflater.from(this.k);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.o.length) {
                this.o[i3] = (FrameLayout) from.inflate(com.baidu.tieba.v.album_bottom_item_view, (ViewGroup) null);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(com.baidu.tieba.u.item_iv);
    }

    public void a() {
        this.m = new Fragment[3];
        this.n = new String[3];
        this.m[0] = new m();
        this.n[0] = this.b;
        this.m[1] = new ah();
        this.n[1] = this.c;
        this.m[2] = new b();
        this.n[2] = this.d;
    }

    public Fragment b(int i) {
        if (i < 0 || i > 2) {
            return null;
        }
        return this.m[i];
    }

    public String c(int i) {
        if (i < 0 || i > 2) {
            return null;
        }
        return this.n[i];
    }

    public void d(int i) {
        this.k.c().a(i == 1);
        this.k.c().a((View) this.e);
    }

    public Button b() {
        return this.f;
    }

    public View c() {
        Fragment b = b(0);
        if (b == null || !(b instanceof m)) {
            return null;
        }
        return ((m) b).a();
    }

    public View d() {
        Fragment b = b(1);
        if (b == null || !(b instanceof ah)) {
            return null;
        }
        return ((ah) b).a();
    }

    public View e() {
        Fragment b = b(2);
        if (b == null || !(b instanceof b)) {
            return null;
        }
        return ((b) b).a();
    }

    public TextView f() {
        Fragment b = b(1);
        if (b == null || !(b instanceof ah)) {
            return null;
        }
        return ((ah) b).f();
    }

    public void a(boolean z, String str) {
        this.f.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f.setText(str);
    }

    public void a(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.o.length;
            for (int i = 0; i < length; i++) {
                if (this.o[i] != null && (a = a(this.o[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setNightDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setNightDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.p, this.p));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.p + (this.q * 2), this.p + (this.q * 2));
                    layoutParams.bottomMargin = ((int) this.k.getResources().getDimension(com.baidu.tieba.s.album_bottom_item_margin_bottom)) - this.q;
                    layoutParams.topMargin = ((int) this.k.getResources().getDimension(com.baidu.tieba.s.album_bottom_item_margin_top)) - this.q;
                    layoutParams.leftMargin = ((int) this.k.getResources().getDimension(com.baidu.tieba.s.album_bottom_item_margin_left)) - this.q;
                    this.o[i].setLayoutParams(layoutParams);
                    this.o[i].setBackgroundResource(TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.t.bg_add_photo_1 : com.baidu.tieba.t.bg_add_photo);
                    this.h.addView(this.o[i], this.h.getChildCount() - 1);
                    a(this.g);
                    a.setOnClickListener(new w(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.a(this.p, this.p));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.l.a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.l.a(imageFileInfo, new x(this, imageFileInfo), false);
                        return;
                    }
                }
            }
        }
    }

    public void b(ImageFileInfo imageFileInfo) {
        FrameLayout frameLayout;
        TbImageView a;
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.a(this.p, this.p));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.h.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.h.getChildAt(i) != null && (this.h.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.h.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.h.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void a(boolean z) {
        if (this.j != null) {
            if (z) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.g != null) {
            if (this.s == null) {
                this.s = new y(this, horizontalScrollView);
            }
            this.r.removeCallbacks(this.s);
            this.r.postDelayed(this.s, 10L);
        }
    }

    public void g() {
        if (this.r != null && this.s != null) {
            this.r.removeCallbacks(this.s);
        }
        if (this.l != null) {
            this.l.b();
        }
    }

    public void e(int i) {
        if (TbadkApplication.m252getInst().getSkinType() != 1) {
            if (i == 2) {
                this.i.setBackgroundResource(com.baidu.tieba.t.bg_pic_bottom_bar_special);
                this.f.setBackgroundResource(com.baidu.tieba.t.album_done_btn_special);
                this.j.setBackgroundResource(com.baidu.tieba.t.icon_bottom_add_photo_special);
                return;
            }
            this.i.setBackgroundResource(com.baidu.tieba.t.bg_pic_bottom_bar);
            this.f.setBackgroundResource(com.baidu.tieba.t.album_done_btn);
            this.j.setBackgroundResource(com.baidu.tieba.t.icon_bottom_add_photo);
        }
    }
}
