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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.g<BaseFragmentActivity> {
    private Runnable Tx;
    private com.baidu.tbadk.img.e aoM;
    private AlbumActivity aoO;
    private Button apA;
    private HorizontalScrollView apB;
    private LinearLayout apC;
    private RelativeLayout apD;
    private ImageView apE;
    private Fragment[] apF;
    private String[] apG;
    private FrameLayout[] apH;
    private int apI;
    private final int apw;
    private String apx;
    private String apy;
    private String apz;
    private Handler mHandler;
    private int mPadding;
    private LinearLayout mParent;

    public v(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.apw = 3;
        this.apx = "tag_album";
        this.apy = "tag_image";
        this.apz = "tag_b_image";
        this.mHandler = new Handler();
        this.aoO = albumActivity;
        this.aoM = new com.baidu.tbadk.img.e(albumActivity.getPageContext().getContext());
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(com.baidu.tieba.x.album_activity);
        this.mParent = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.w.parent);
        this.apA = (Button) albumActivity.findViewById(com.baidu.tieba.w.btn_done);
        this.apA.setOnClickListener(albumActivity);
        this.apB = (HorizontalScrollView) albumActivity.findViewById(com.baidu.tieba.w.bottom_scroll);
        this.apC = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.w.bottom_container);
        this.apD = (RelativeLayout) albumActivity.findViewById(com.baidu.tieba.w.lay_bottom);
        this.apE = (ImageView) albumActivity.findViewById(com.baidu.tieba.w.add_more);
        this.apI = (int) this.aoO.getResources().getDimension(com.baidu.tieba.u.album_bottom_item_height);
        this.mPadding = (int) this.aoO.getResources().getDimension(com.baidu.tieba.u.default_gap_4);
    }

    public void ej(int i) {
        this.apH = new FrameLayout[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.apH.length) {
                this.apH[i3] = (FrameLayout) com.baidu.adp.lib.g.b.ek().inflate(this.aoO.getPageContext().getContext(), com.baidu.tieba.x.album_bottom_item_view, null);
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
        return (TbImageView) frameLayout.findViewById(com.baidu.tieba.w.item_iv);
    }

    public void Bs() {
        this.apF = new Fragment[3];
        this.apG = new String[3];
        this.apF[0] = new m();
        this.apG[0] = this.apx;
        this.apF[1] = new ah();
        this.apG[1] = this.apy;
        this.apF[2] = new b();
        this.apG[2] = this.apz;
    }

    public Fragment ek(int i) {
        if (i < 0 || i > 2) {
            return null;
        }
        return this.apF[i];
    }

    public String el(int i) {
        if (i < 0 || i > 2) {
            return null;
        }
        return this.apG[i];
    }

    public void onChangeSkinType(int i) {
        this.aoO.getLayoutMode().ab(i == 1);
        this.aoO.getLayoutMode().h(this.mParent);
    }

    public Button Bt() {
        return this.apA;
    }

    public View Bu() {
        Fragment ek = ek(0);
        if (ek == null || !(ek instanceof m)) {
            return null;
        }
        return ((m) ek).getBtnBack();
    }

    public View Bv() {
        Fragment ek = ek(1);
        if (ek == null || !(ek instanceof ah)) {
            return null;
        }
        return ((ah) ek).Bj();
    }

    public View Bw() {
        Fragment ek = ek(2);
        if (ek == null || !(ek instanceof b)) {
            return null;
        }
        return ((b) ek).Bj();
    }

    public TextView Bx() {
        Fragment ek = ek(1);
        if (ek == null || !(ek instanceof ah)) {
            return null;
        }
        return ((ah) ek).Bx();
    }

    public void e(boolean z, String str) {
        this.apA.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.apA.setText(str);
    }

    public void e(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.apH.length;
            for (int i = 0; i < length; i++) {
                if (this.apH[i] != null && (a = a(this.apH[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.apI, this.apI));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.apI + (this.mPadding * 2), this.apI + (this.mPadding * 2));
                    layoutParams.bottomMargin = ((int) this.aoO.getResources().getDimension(com.baidu.tieba.u.album_bottom_item_margin_bottom)) - this.mPadding;
                    layoutParams.topMargin = ((int) this.aoO.getResources().getDimension(com.baidu.tieba.u.album_bottom_item_margin_top)) - this.mPadding;
                    layoutParams.leftMargin = ((int) this.aoO.getResources().getDimension(com.baidu.tieba.u.album_bottom_item_margin_left)) - this.mPadding;
                    this.apH[i].setLayoutParams(layoutParams);
                    ax.i(this.apH[i], com.baidu.tieba.v.bg_add_photo);
                    this.apC.addView(this.apH[i], this.apC.getChildCount() - 1);
                    a(this.apB);
                    a.setOnClickListener(new w(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.z(this.apI, this.apI));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.aoM.a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.aoM.a(imageFileInfo, new x(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.z(this.apI, this.apI));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.apC.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.apC.getChildAt(i) != null && (this.apC.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.apC.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.apC.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void bl(boolean z) {
        if (this.apE != null) {
            if (z) {
                this.apE.setVisibility(0);
            } else {
                this.apE.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.apB != null) {
            if (this.Tx == null) {
                this.Tx = new y(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.Tx);
            this.mHandler.postDelayed(this.Tx, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.Tx != null) {
            this.mHandler.removeCallbacks(this.Tx);
        }
        if (this.aoM != null) {
            this.aoM.vT();
        }
    }

    public void em(int i) {
        if (TbadkCoreApplication.m255getInst().getSkinType() != 1) {
            if (i == 2) {
                this.apD.setBackgroundResource(com.baidu.tieba.v.bg_pic_bottom_bar_special);
                this.apA.setBackgroundResource(com.baidu.tieba.v.album_done_btn_special);
                this.apE.setBackgroundResource(com.baidu.tieba.v.icon_bottom_add_photo_special);
                return;
            }
            this.apD.setBackgroundResource(com.baidu.tieba.v.bg_pic_bottom_bar);
            this.apA.setBackgroundResource(com.baidu.tieba.v.album_done_btn);
            this.apE.setBackgroundResource(com.baidu.tieba.v.icon_bottom_add_photo);
        }
    }
}
