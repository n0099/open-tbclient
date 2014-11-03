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
    private Runnable NM;
    private com.baidu.tbadk.img.e ahw;
    private AlbumActivity ahz;
    private final int aij;
    private String aik;
    private String ail;
    private String aim;
    private Button ain;
    private HorizontalScrollView aio;
    private LinearLayout aip;
    private RelativeLayout aiq;
    private ImageView air;
    private Fragment[] ais;
    private String[] ait;
    private FrameLayout[] aiu;
    private int aiv;
    private Handler mHandler;
    private int mPadding;
    private LinearLayout mParent;

    public v(AlbumActivity albumActivity) {
        super(albumActivity);
        this.aij = 3;
        this.aik = "tag_album";
        this.ail = "tag_image";
        this.aim = "tag_b_image";
        this.mHandler = new Handler();
        this.ahz = albumActivity;
        this.ahw = new com.baidu.tbadk.img.e(albumActivity);
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(com.baidu.tieba.w.album_activity);
        this.mParent = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.v.parent);
        this.ain = (Button) albumActivity.findViewById(com.baidu.tieba.v.btn_done);
        this.ain.setOnClickListener(albumActivity);
        this.aio = (HorizontalScrollView) albumActivity.findViewById(com.baidu.tieba.v.bottom_scroll);
        this.aip = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.v.bottom_container);
        this.aiq = (RelativeLayout) albumActivity.findViewById(com.baidu.tieba.v.lay_bottom);
        this.air = (ImageView) albumActivity.findViewById(com.baidu.tieba.v.add_more);
        this.aiv = (int) this.ahz.getResources().getDimension(com.baidu.tieba.t.album_bottom_item_height);
        this.mPadding = (int) this.ahz.getResources().getDimension(com.baidu.tieba.t.default_gap_4);
    }

    public void dQ(int i) {
        this.aiu = new FrameLayout[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aiu.length) {
                this.aiu[i3] = (FrameLayout) com.baidu.adp.lib.g.b.ek().inflate(this.ahz, com.baidu.tieba.w.album_bottom_item_view, null);
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

    public void yb() {
        this.ais = new Fragment[3];
        this.ait = new String[3];
        this.ais[0] = new m();
        this.ait[0] = this.aik;
        this.ais[1] = new ah();
        this.ait[1] = this.ail;
        this.ais[2] = new b();
        this.ait[2] = this.aim;
    }

    public Fragment dR(int i) {
        if (i < 0 || i > 2) {
            return null;
        }
        return this.ais[i];
    }

    public String dS(int i) {
        if (i < 0 || i > 2) {
            return null;
        }
        return this.ait[i];
    }

    public void onChangeSkinType(int i) {
        this.ahz.getLayoutMode().L(i == 1);
        this.ahz.getLayoutMode().h(this.mParent);
    }

    public Button yc() {
        return this.ain;
    }

    public View yd() {
        Fragment dR = dR(0);
        if (dR == null || !(dR instanceof m)) {
            return null;
        }
        return ((m) dR).getBtnBack();
    }

    public View ye() {
        Fragment dR = dR(1);
        if (dR == null || !(dR instanceof ah)) {
            return null;
        }
        return ((ah) dR).xQ();
    }

    public View yf() {
        Fragment dR = dR(2);
        if (dR == null || !(dR instanceof b)) {
            return null;
        }
        return ((b) dR).xQ();
    }

    public TextView yg() {
        Fragment dR = dR(1);
        if (dR == null || !(dR instanceof ah)) {
            return null;
        }
        return ((ah) dR).yg();
    }

    public void b(boolean z, String str) {
        this.ain.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.ain.setText(str);
    }

    public void e(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.aiu.length;
            for (int i = 0; i < length; i++) {
                if (this.aiu[i] != null && (a = a(this.aiu[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.aiv, this.aiv));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aiv + (this.mPadding * 2), this.aiv + (this.mPadding * 2));
                    layoutParams.bottomMargin = ((int) this.ahz.getResources().getDimension(com.baidu.tieba.t.album_bottom_item_margin_bottom)) - this.mPadding;
                    layoutParams.topMargin = ((int) this.ahz.getResources().getDimension(com.baidu.tieba.t.album_bottom_item_margin_top)) - this.mPadding;
                    layoutParams.leftMargin = ((int) this.ahz.getResources().getDimension(com.baidu.tieba.t.album_bottom_item_margin_left)) - this.mPadding;
                    this.aiu[i].setLayoutParams(layoutParams);
                    aw.h(this.aiu[i], com.baidu.tieba.u.bg_add_photo);
                    this.aip.addView(this.aiu[i], this.aip.getChildCount() - 1);
                    a(this.aio);
                    a.setOnClickListener(new w(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.w(this.aiv, this.aiv));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.ahw.a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.ahw.a(imageFileInfo, new x(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.w(this.aiv, this.aiv));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.aip.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.aip.getChildAt(i) != null && (this.aip.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.aip.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.aip.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void bm(boolean z) {
        if (this.air != null) {
            if (z) {
                this.air.setVisibility(0);
            } else {
                this.air.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.aio != null) {
            if (this.NM == null) {
                this.NM = new y(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.NM);
            this.mHandler.postDelayed(this.NM, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.NM != null) {
            this.mHandler.removeCallbacks(this.NM);
        }
        if (this.ahw != null) {
            this.ahw.sq();
        }
    }

    public void dT(int i) {
        if (TbadkApplication.m251getInst().getSkinType() != 1) {
            if (i == 2) {
                this.aiq.setBackgroundResource(com.baidu.tieba.u.bg_pic_bottom_bar_special);
                this.ain.setBackgroundResource(com.baidu.tieba.u.album_done_btn_special);
                this.air.setBackgroundResource(com.baidu.tieba.u.icon_bottom_add_photo_special);
                return;
            }
            this.aiq.setBackgroundResource(com.baidu.tieba.u.bg_pic_bottom_bar);
            this.ain.setBackgroundResource(com.baidu.tieba.u.album_done_btn);
            this.air.setBackgroundResource(com.baidu.tieba.u.icon_bottom_add_photo);
        }
    }
}
