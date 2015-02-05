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
    private Runnable TZ;
    private AlbumActivity apJ;
    private String[] aqA;
    private FrameLayout[] aqB;
    private View[] aqC;
    private int aqD;
    private final int aqp;
    private String aqq;
    private String aqr;
    private ViewGroup aqs;
    private Button aqt;
    private View aqu;
    private HorizontalScrollView aqv;
    private LinearLayout aqw;
    private RelativeLayout aqx;
    private ImageView aqy;
    private Fragment[] aqz;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aqp = 2;
        this.aqq = "tag_image";
        this.aqr = "tag_b_image";
        this.mHandler = new Handler();
        this.apJ = albumActivity;
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(com.baidu.tieba.x.album_activity);
        this.aqs = (ViewGroup) albumActivity.findViewById(com.baidu.tieba.w.parent);
        this.aqt = (Button) albumActivity.findViewById(com.baidu.tieba.w.btn_done);
        this.aqt.setOnClickListener(albumActivity);
        this.aqv = (HorizontalScrollView) albumActivity.findViewById(com.baidu.tieba.w.bottom_scroll);
        this.aqw = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.w.bottom_container);
        this.aqx = (RelativeLayout) albumActivity.findViewById(com.baidu.tieba.w.lay_bottom);
        this.aqy = (ImageView) albumActivity.findViewById(com.baidu.tieba.w.add_more);
        this.aqu = albumActivity.findViewById(com.baidu.tieba.w.bottom_shadow);
        this.aqD = (int) this.apJ.getResources().getDimension(com.baidu.tieba.u.ds90);
    }

    public void ep(int i) {
        this.aqB = new FrameLayout[i];
        this.aqC = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.aqB[i2] = (FrameLayout) com.baidu.adp.lib.g.b.ei().inflate(this.apJ.getPageContext().getPageActivity(), com.baidu.tieba.x.album_bottom_item_view, null);
            this.aqC[i2 * 4] = this.aqB[i2].findViewById(com.baidu.tieba.w.line_top);
            this.aqC[(i2 * 4) + 1] = this.aqB[i2].findViewById(com.baidu.tieba.w.line_left);
            this.aqC[(i2 * 4) + 2] = this.aqB[i2].findViewById(com.baidu.tieba.w.line_right);
            this.aqC[(i2 * 4) + 3] = this.aqB[i2].findViewById(com.baidu.tieba.w.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(com.baidu.tieba.w.item_iv);
    }

    public void BO() {
        this.aqz = new Fragment[2];
        this.aqA = new String[2];
        this.aqz[0] = new ah();
        this.aqA[0] = this.aqq;
        this.aqz[1] = new b();
        this.aqA[1] = this.aqr;
    }

    public Fragment eq(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aqz[i];
    }

    public String er(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aqA[i];
    }

    public void onChangeSkinType(int i) {
        this.apJ.getLayoutMode().ab(i == 1);
        this.apJ.getLayoutMode().h(this.aqs);
    }

    public Button BP() {
        return this.aqt;
    }

    public View BQ() {
        Fragment eq = eq(0);
        if (eq == null || !(eq instanceof ah)) {
            return null;
        }
        return ((ah) eq).BC();
    }

    public View BR() {
        Fragment eq = eq(1);
        if (eq == null || !(eq instanceof b)) {
            return null;
        }
        return ((b) eq).BC();
    }

    public void e(boolean z, String str) {
        if (z && !this.aqt.isEnabled()) {
            this.aqt.setEnabled(true);
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.aqt.setText(str);
    }

    public void e(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.aqB.length;
            for (int i = 0; i < length; i++) {
                if (this.aqB[i] != null && (a = a(this.aqB[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.aqD, this.aqD));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aqD, this.aqD);
                    layoutParams.rightMargin = (int) this.apJ.getResources().getDimension(com.baidu.tieba.u.ds10);
                    this.aqB[i].setLayoutParams(layoutParams);
                    this.aqw.addView(this.aqB[i], this.aqw.getChildCount() - 1);
                    a(this.aqv);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.z(this.aqD, this.aqD));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.apJ.Bw().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.apJ.Bw().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.z(this.aqD, this.aqD));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.aqw.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.aqw.getChildAt(i) != null && (this.aqw.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.aqw.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.aqw.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void bn(boolean z) {
        if (this.aqy != null) {
            if (z) {
                this.aqy.setVisibility(0);
            } else {
                this.aqy.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.aqv != null) {
            if (this.TZ == null) {
                this.TZ = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.TZ);
            this.mHandler.postDelayed(this.TZ, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.TZ != null) {
            this.mHandler.removeCallbacks(this.TZ);
        }
        if (this.apJ.Bw() != null) {
            this.apJ.Bw().wg();
        }
    }

    public void es(int i) {
        if (i == 1) {
            bc.c(this.aqx, com.baidu.tieba.t.album_list_bottom_bigimage_bg, 0);
            bc.i((View) this.aqt, com.baidu.tieba.v.post_button_bg_bigimage);
            bc.c(this.aqy, com.baidu.tieba.v.btn_add_pic_bigimage, 0);
            bc.d(this.aqu, com.baidu.tieba.t.album_list_bottom_bigimage_line, 0);
            for (View view : this.aqC) {
                bc.d(view, com.baidu.tieba.t.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        bc.i(this.aqx, com.baidu.tieba.t.album_list_bottom_bg);
        bc.i((View) this.aqt, com.baidu.tieba.v.post_button_bg_smallimage);
        bc.i(this.aqy, com.baidu.tieba.v.btn_add_pic);
        bc.j(this.aqu, com.baidu.tieba.t.album_list_bottom_line);
        for (View view2 : this.aqC) {
            bc.j(view2, com.baidu.tieba.t.album_list_bottom_line);
        }
    }
}
