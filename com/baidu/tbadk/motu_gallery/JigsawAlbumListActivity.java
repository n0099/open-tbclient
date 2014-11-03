package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class JigsawAlbumListActivity extends BaseActivity implements AbsListView.OnScrollListener {
    private GridView WJ;
    r WK;
    private HorizontalScrollView WM;
    q WN;
    u Wm;
    private TextView Wv;
    private LinearLayout Ww;
    private static volatile int currentPosition = 0;
    private static volatile int WL = 0;
    private static boolean Wo = false;
    private static boolean Wp = true;
    private final int WG = 50;
    private final int WH = 20;
    private ViewphotoLinkedHashMap WI = new ViewphotoLinkedHashMap(50);
    private NavigationBar mNavigationBar = null;
    int WO = 0;
    int WP = 0;
    private boolean WQ = false;
    private Handler mHandler = new m(this);

    public boolean sH() {
        return Wo;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (sH() || this.Wm.getCount() == 0) {
            Wo = false;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.motu_albums_list_activity);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        this.Wv = (TextView) findViewById(com.baidu.tieba.v.jigsaw_selected_text);
        this.WP = (int) getResources().getDimension(com.baidu.tieba.t.onedip);
        this.WO = (i - (this.WP * 16)) / 3;
        this.Wm = u.sO();
        this.WK = new r(this, this);
        this.WJ = (GridView) findViewById(com.baidu.tieba.v.jigsaw_grid);
        this.WJ.setAdapter((ListAdapter) this.WK);
        this.WJ.setOnScrollListener(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        ((Button) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_textbtn, new o(this))).setText(com.baidu.tieba.y.jigsaw_start);
        this.Ww = (LinearLayout) findViewById(com.baidu.tieba.v.selected_ll);
        this.WM = (HorizontalScrollView) findViewById(com.baidu.tieba.v.hsv);
        this.mNavigationBar.setTitleText(this.Wm.sP());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.WQ = true;
        Wp = true;
        this.WN = new q(this);
        Thread thread = new Thread(this.WN);
        thread.setDaemon(true);
        thread.start();
        this.Wv.setText(this.Wm.E(this));
        sI();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.WI.clear();
        super.onDestroy();
    }

    private void sI() {
        this.Ww.removeAllViews();
        for (Uri uri : this.Wm.C(this)) {
            x xVar = new x(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(com.baidu.tieba.t.jigsawSelectedWidth), (int) getResources().getDimension(com.baidu.tieba.t.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            xVar.setLayoutParams(layoutParams);
            if (xVar.g(uri)) {
                this.Ww.addView(xVar);
                xVar.setOnClickListener(new p(this, xVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Uri uri) {
        a aVar;
        if (uri != null) {
            for (int i = 0; i < this.Ww.getChildCount(); i++) {
                View childAt = this.Ww.getChildAt(i);
                if ((childAt instanceof x) && uri.equals(((x) childAt).getUri())) {
                    this.Ww.removeView(childAt);
                }
            }
            int e = this.Wm.e(uri);
            if (e >= 0 && (aVar = (a) this.WI.get((Object) Integer.valueOf(e))) != null) {
                aVar.setIsSelected(false);
            }
            this.Wm.b(this, uri);
            this.Wv.setText(this.Wm.E(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.WN.sN();
        sK();
        System.gc();
        if (this.WN != null) {
            this.WN.sN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bitmap bitmap) {
        ImageView imageView;
        if (this.WI.containsKey(Integer.valueOf(i))) {
            imageView = this.WI.get((Object) Integer.valueOf(i));
            this.WI.get((Object) Integer.valueOf(i)).setImageBitmap(bitmap);
        } else {
            imageView = new ImageView(this);
            imageView.setImageBitmap(bitmap);
            this.WI.put(Integer.valueOf(i), imageView);
        }
        imageView.setTag("bitmap");
    }

    private void sK() {
        int count = currentPosition + 20 > this.Wm.getCount() ? this.Wm.getCount() - currentPosition : 20;
        if (this.WI.size() != 0) {
            for (int i = currentPosition; i < currentPosition + count; i++) {
                if (this.WI.containsKey(Integer.valueOf(i))) {
                    this.WI.get((Object) Integer.valueOf(i)).setImageDrawable(null);
                    this.WI.get((Object) Integer.valueOf(i)).setTag("");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sJ() {
        if (u.sO().C(this).size() >= 2) {
            if (Wp) {
                Wp = false;
                setResult(2);
                finish();
                return;
            }
            return;
        }
        y.dc(com.baidu.tieba.y.jigsaw_2_least);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        currentPosition = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
