package com.baidu.tieba.album;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.g<BaseFragmentActivity> {
    private Runnable Uc;
    private AlbumActivity apM;
    private RelativeLayout aqA;
    private ImageView aqB;
    private Fragment[] aqC;
    private String[] aqD;
    private FrameLayout[] aqE;
    private View[] aqF;
    private int aqG;
    private final int aqs;
    private String aqt;
    private String aqu;
    private ViewGroup aqv;
    private Button aqw;
    private View aqx;
    private HorizontalScrollView aqy;
    private LinearLayout aqz;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aqs = 2;
        this.aqt = "tag_image";
        this.aqu = "tag_b_image";
        this.mHandler = new Handler();
        this.apM = albumActivity;
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(com.baidu.tieba.x.album_activity);
        this.aqv = (ViewGroup) albumActivity.findViewById(com.baidu.tieba.w.parent);
        this.aqw = (Button) albumActivity.findViewById(com.baidu.tieba.w.btn_done);
        this.aqw.setOnClickListener(albumActivity);
        this.aqy = (HorizontalScrollView) albumActivity.findViewById(com.baidu.tieba.w.bottom_scroll);
        this.aqz = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.w.bottom_container);
        this.aqA = (RelativeLayout) albumActivity.findViewById(com.baidu.tieba.w.lay_bottom);
        this.aqB = (ImageView) albumActivity.findViewById(com.baidu.tieba.w.add_more);
        this.aqx = albumActivity.findViewById(com.baidu.tieba.w.bottom_shadow);
        this.aqG = (int) this.apM.getResources().getDimension(com.baidu.tieba.u.ds90);
    }

    public void ep(int i) {
        this.aqE = new FrameLayout[i];
        this.aqF = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.aqE[i2] = (FrameLayout) com.baidu.adp.lib.g.b.ei().inflate(this.apM.getPageContext().getPageActivity(), com.baidu.tieba.x.album_bottom_item_view, null);
            this.aqF[i2 * 4] = this.aqE[i2].findViewById(com.baidu.tieba.w.line_top);
            this.aqF[(i2 * 4) + 1] = this.aqE[i2].findViewById(com.baidu.tieba.w.line_left);
            this.aqF[(i2 * 4) + 2] = this.aqE[i2].findViewById(com.baidu.tieba.w.line_right);
            this.aqF[(i2 * 4) + 3] = this.aqE[i2].findViewById(com.baidu.tieba.w.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(com.baidu.tieba.w.item_iv);
    }

    public void BU() {
        this.aqC = new Fragment[2];
        this.aqD = new String[2];
        this.aqC[0] = new ah();
        this.aqD[0] = this.aqt;
        this.aqC[1] = new b();
        this.aqD[1] = this.aqu;
    }

    public Fragment eq(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aqC[i];
    }

    public String er(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aqD[i];
    }

    public void onChangeSkinType(int i) {
        this.apM.getLayoutMode().ab(i == 1);
        this.apM.getLayoutMode().h(this.aqv);
    }

    public Button BV() {
        return this.aqw;
    }

    public View BW() {
        Fragment eq = eq(0);
        if (eq == null || !(eq instanceof ah)) {
            return null;
        }
        return ((ah) eq).BI();
    }

    public View BX() {
        Fragment eq = eq(1);
        if (eq == null || !(eq instanceof b)) {
            return null;
        }
        return ((b) eq).BI();
    }

    public void e(boolean z, String str) {
        if (z && !this.aqw.isEnabled()) {
            this.aqw.setEnabled(true);
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.aqw.setText(str);
    }

    public void e(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.aqE.length;
            for (int i = 0; i < length; i++) {
                if (this.aqE[i] != null && (a = a(this.aqE[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.aqG, this.aqG));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aqG, this.aqG);
                    layoutParams.rightMargin = (int) this.apM.getResources().getDimension(com.baidu.tieba.u.ds10);
                    this.aqE[i].setLayoutParams(layoutParams);
                    this.aqz.addView(this.aqE[i], this.aqz.getChildCount() - 1);
                    a(this.aqy);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.z(this.aqG, this.aqG));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.apM.BC().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.apM.BC().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.z(this.aqG, this.aqG));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.aqz.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.aqz.getChildAt(i) != null && (this.aqz.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.aqz.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.aqz.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void bn(boolean z) {
        if (this.aqB != null) {
            if (z) {
                this.aqB.setVisibility(0);
            } else {
                this.aqB.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.aqy != null) {
            if (this.Uc == null) {
                this.Uc = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.Uc);
            this.mHandler.postDelayed(this.Uc, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.Uc != null) {
            this.mHandler.removeCallbacks(this.Uc);
        }
        if (this.apM.BC() != null) {
            this.apM.BC().wm();
        }
    }

    public void es(int i) {
        if (i == 1) {
            bc.c(this.aqA, com.baidu.tieba.t.album_list_bottom_bigimage_bg, 0);
            bc.i((View) this.aqw, com.baidu.tieba.v.post_button_bg_bigimage);
            bc.c(this.aqB, com.baidu.tieba.v.btn_add_pic_bigimage, 0);
            bc.d(this.aqx, com.baidu.tieba.t.album_list_bottom_bigimage_line, 0);
            for (View view : this.aqF) {
                bc.d(view, com.baidu.tieba.t.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        bc.i(this.aqA, com.baidu.tieba.t.album_list_bottom_bg);
        bc.i((View) this.aqw, com.baidu.tieba.v.post_button_bg_smallimage);
        bc.i(this.aqB, com.baidu.tieba.v.btn_add_pic);
        bc.j(this.aqx, com.baidu.tieba.t.album_list_bottom_line);
        for (View view2 : this.aqF) {
            bc.j(view2, com.baidu.tieba.t.album_list_bottom_line);
        }
    }
}
