package com.baidu.tieba.album;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.img.ImageFileInfo;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class v extends com.baidu.adp.a.e {
    private final int a;
    private String c;
    private String d;
    private String e;
    private LinearLayout f;
    private Button g;
    private HorizontalScrollView h;
    private LinearLayout i;
    private RelativeLayout j;
    private ImageView k;
    private AlbumActivity l;
    private com.baidu.tieba.img.e m;
    private Fragment[] n;
    private String[] o;
    private FrameLayout[] p;
    private int q;
    private int r;
    private Handler s;
    private Runnable t;

    public v(AlbumActivity albumActivity) {
        super(albumActivity);
        this.a = 3;
        this.c = "tag_album";
        this.d = "tag_image";
        this.e = "tag_b_image";
        this.s = new Handler();
        this.l = albumActivity;
        this.m = new com.baidu.tieba.img.e(albumActivity);
        albumActivity.setContentView(R.layout.album_activity);
        this.f = (LinearLayout) albumActivity.findViewById(R.id.parent);
        this.g = (Button) albumActivity.findViewById(R.id.btn_done);
        this.g.setOnClickListener(albumActivity);
        this.h = (HorizontalScrollView) albumActivity.findViewById(R.id.bottom_scroll);
        this.i = (LinearLayout) albumActivity.findViewById(R.id.bottom_container);
        this.j = (RelativeLayout) albumActivity.findViewById(R.id.lay_bottom);
        this.k = (ImageView) albumActivity.findViewById(R.id.add_more);
        this.q = (int) this.l.getResources().getDimension(R.dimen.album_bottom_item_height);
        this.r = (int) this.l.getResources().getDimension(R.dimen.default_gap_4);
    }

    public final void a(int i) {
        this.p = new FrameLayout[i];
        LayoutInflater from = LayoutInflater.from(this.l);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.p.length) {
                this.p[i3] = (FrameLayout) from.inflate(R.layout.album_bottom_item_view, (ViewGroup) null);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(R.id.item_iv);
    }

    public final void a() {
        this.n = new Fragment[3];
        this.o = new String[3];
        this.n[0] = new m();
        this.o[0] = this.c;
        this.n[1] = new ah();
        this.o[1] = this.d;
        this.n[2] = new b();
        this.o[2] = this.e;
    }

    public final Fragment b(int i) {
        if (i < 0 || i > 2) {
            return null;
        }
        return this.n[i];
    }

    public final String c(int i) {
        if (i < 0 || i > 2) {
            return null;
        }
        return this.o[i];
    }

    public final void d(int i) {
        this.l.a().a(i == 1);
        this.l.a().a(this.f);
    }

    public final Button d() {
        return this.g;
    }

    public final void a(boolean z, String str) {
        this.g.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.g.setText(str);
    }

    public final void a(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.p.length;
            for (int i = 0; i < length; i++) {
                if (this.p[i] != null && (a = a(this.p[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setNightDefaultResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.q, this.q));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.q + (this.r * 2), this.q + (this.r * 2));
                    layoutParams.bottomMargin = ((int) this.l.getResources().getDimension(R.dimen.album_bottom_item_margin_bottom)) - this.r;
                    layoutParams.topMargin = ((int) this.l.getResources().getDimension(R.dimen.album_bottom_item_margin_top)) - this.r;
                    layoutParams.leftMargin = ((int) this.l.getResources().getDimension(R.dimen.album_bottom_item_margin_left)) - this.r;
                    this.p[i].setLayoutParams(layoutParams);
                    this.p[i].setBackgroundResource(TiebaApplication.g().ae() == 1 ? R.drawable.bg_add_photo_1 : R.drawable.bg_add_photo);
                    this.i.addView(this.p[i], this.i.getChildCount() - 1);
                    HorizontalScrollView horizontalScrollView = this.h;
                    if (this.h != null) {
                        if (this.t == null) {
                            this.t = new y(this, horizontalScrollView);
                        }
                        this.s.removeCallbacks(this.t);
                        this.s.postDelayed(this.t, 10L);
                    }
                    a.setOnClickListener(new w(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tieba.img.effects.d.a(this.q, this.q));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.tieba.img.e eVar = this.m;
                    com.baidu.adp.widget.ImageView.b a2 = com.baidu.tieba.img.e.a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.m.a(imageFileInfo, new x(this, imageFileInfo), false);
                        return;
                    }
                }
            }
        }
    }

    public final void b(ImageFileInfo imageFileInfo) {
        FrameLayout frameLayout;
        TbImageView a;
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tieba.img.effects.d.a(this.q, this.q));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.i.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.i.getChildAt(i) != null && (this.i.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.i.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageBitmap(null);
                        this.i.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public final void a(boolean z) {
        if (this.k != null) {
            if (z) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public final void e() {
        if (this.s != null && this.t != null) {
            this.s.removeCallbacks(this.t);
        }
        if (this.m != null) {
            this.m.b();
        }
    }

    public final void e(int i) {
        if (TiebaApplication.g().ae() != 1) {
            if (i == 2) {
                this.j.setBackgroundResource(R.drawable.bg_pic_bottom_bar_special);
                this.g.setBackgroundResource(R.drawable.album_done_btn_special);
                this.k.setBackgroundResource(R.drawable.icon_bottom_add_photo_special);
                return;
            }
            this.j.setBackgroundResource(R.drawable.bg_pic_bottom_bar);
            this.g.setBackgroundResource(R.drawable.album_done_btn);
            this.k.setBackgroundResource(R.drawable.icon_bottom_add_photo);
        }
    }
}
