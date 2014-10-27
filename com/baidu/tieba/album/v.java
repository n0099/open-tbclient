package com.baidu.tieba.album;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.f {
    private Runnable NI;
    private com.baidu.tbadk.img.e ahn;
    private AlbumActivity ahq;
    private final int aia;
    private String aib;
    private String aic;
    private String aid;
    private Button aie;
    private HorizontalScrollView aif;
    private LinearLayout aig;
    private RelativeLayout aih;
    private ImageView aii;
    private Fragment[] aij;
    private String[] aik;
    private FrameLayout[] ail;
    private int aim;
    private Handler mHandler;
    private int mPadding;
    private LinearLayout mParent;

    public v(AlbumActivity albumActivity) {
        super(albumActivity);
        this.aia = 3;
        this.aib = "tag_album";
        this.aic = "tag_image";
        this.aid = "tag_b_image";
        this.mHandler = new Handler();
        this.ahq = albumActivity;
        this.ahn = new com.baidu.tbadk.img.e(albumActivity);
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(com.baidu.tieba.w.album_activity);
        this.mParent = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.v.parent);
        this.aie = (Button) albumActivity.findViewById(com.baidu.tieba.v.btn_done);
        this.aie.setOnClickListener(albumActivity);
        this.aif = (HorizontalScrollView) albumActivity.findViewById(com.baidu.tieba.v.bottom_scroll);
        this.aig = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.v.bottom_container);
        this.aih = (RelativeLayout) albumActivity.findViewById(com.baidu.tieba.v.lay_bottom);
        this.aii = (ImageView) albumActivity.findViewById(com.baidu.tieba.v.add_more);
        this.aim = (int) this.ahq.getResources().getDimension(com.baidu.tieba.t.album_bottom_item_height);
        this.mPadding = (int) this.ahq.getResources().getDimension(com.baidu.tieba.t.default_gap_4);
    }

    public void dQ(int i) {
        this.ail = new FrameLayout[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.ail.length) {
                this.ail[i3] = (FrameLayout) com.baidu.adp.lib.g.b.ek().inflate(this.ahq, com.baidu.tieba.w.album_bottom_item_view, null);
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
        return (TbImageView) frameLayout.findViewById(com.baidu.tieba.v.item_iv);
    }

    public void xZ() {
        this.aij = new Fragment[3];
        this.aik = new String[3];
        this.aij[0] = new m();
        this.aik[0] = this.aib;
        this.aij[1] = new ah();
        this.aik[1] = this.aic;
        this.aij[2] = new b();
        this.aik[2] = this.aid;
    }

    public Fragment dR(int i) {
        if (i < 0 || i > 2) {
            return null;
        }
        return this.aij[i];
    }

    public String dS(int i) {
        if (i < 0 || i > 2) {
            return null;
        }
        return this.aik[i];
    }

    public void onChangeSkinType(int i) {
        this.ahq.getLayoutMode().L(i == 1);
        this.ahq.getLayoutMode().h(this.mParent);
    }

    public Button ya() {
        return this.aie;
    }

    public View yb() {
        Fragment dR = dR(0);
        if (dR == null || !(dR instanceof m)) {
            return null;
        }
        return ((m) dR).getBtnBack();
    }

    public View yc() {
        Fragment dR = dR(1);
        if (dR == null || !(dR instanceof ah)) {
            return null;
        }
        return ((ah) dR).xO();
    }

    public View yd() {
        Fragment dR = dR(2);
        if (dR == null || !(dR instanceof b)) {
            return null;
        }
        return ((b) dR).xO();
    }

    public TextView ye() {
        Fragment dR = dR(1);
        if (dR == null || !(dR instanceof ah)) {
            return null;
        }
        return ((ah) dR).ye();
    }

    public void b(boolean z, String str) {
        this.aie.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.aie.setText(str);
    }

    public void e(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.ail.length;
            for (int i = 0; i < length; i++) {
                if (this.ail[i] != null && (a = a(this.ail[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.aim, this.aim));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aim + (this.mPadding * 2), this.aim + (this.mPadding * 2));
                    layoutParams.bottomMargin = ((int) this.ahq.getResources().getDimension(com.baidu.tieba.t.album_bottom_item_margin_bottom)) - this.mPadding;
                    layoutParams.topMargin = ((int) this.ahq.getResources().getDimension(com.baidu.tieba.t.album_bottom_item_margin_top)) - this.mPadding;
                    layoutParams.leftMargin = ((int) this.ahq.getResources().getDimension(com.baidu.tieba.t.album_bottom_item_margin_left)) - this.mPadding;
                    this.ail[i].setLayoutParams(layoutParams);
                    aw.h(this.ail[i], com.baidu.tieba.u.bg_add_photo);
                    this.aig.addView(this.ail[i], this.aig.getChildCount() - 1);
                    a(this.aif);
                    a.setOnClickListener(new w(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.w(this.aim, this.aim));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.ahn.a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.ahn.a(imageFileInfo, new x(this, imageFileInfo), false);
                        return;
                    }
                }
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo) {
        FrameLayout frameLayout;
        TbImageView a;
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.w(this.aim, this.aim));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.aig.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.aig.getChildAt(i) != null && (this.aig.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.aig.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.aig.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void bm(boolean z) {
        if (this.aii != null) {
            if (z) {
                this.aii.setVisibility(0);
            } else {
                this.aii.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.aif != null) {
            if (this.NI == null) {
                this.NI = new y(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.NI);
            this.mHandler.postDelayed(this.NI, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.NI != null) {
            this.mHandler.removeCallbacks(this.NI);
        }
        if (this.ahn != null) {
            this.ahn.so();
        }
    }

    public void dT(int i) {
        if (TbadkApplication.m251getInst().getSkinType() != 1) {
            if (i == 2) {
                this.aih.setBackgroundResource(com.baidu.tieba.u.bg_pic_bottom_bar_special);
                this.aie.setBackgroundResource(com.baidu.tieba.u.album_done_btn_special);
                this.aii.setBackgroundResource(com.baidu.tieba.u.icon_bottom_add_photo_special);
                return;
            }
            this.aih.setBackgroundResource(com.baidu.tieba.u.bg_pic_bottom_bar);
            this.aie.setBackgroundResource(com.baidu.tieba.u.album_done_btn);
            this.aii.setBackgroundResource(com.baidu.tieba.u.icon_bottom_add_photo);
        }
    }
}
