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
    private GridView WF;
    r WG;
    private HorizontalScrollView WI;
    q WJ;
    u Wi;
    private TextView Wr;
    private LinearLayout Ws;
    private static volatile int currentPosition = 0;
    private static volatile int WH = 0;
    private static boolean Wk = false;
    private static boolean Wl = true;
    private final int WC = 50;
    private final int WD = 20;
    private ViewphotoLinkedHashMap WE = new ViewphotoLinkedHashMap(50);
    private NavigationBar mNavigationBar = null;
    int WK = 0;
    int WL = 0;
    private boolean WM = false;
    private Handler mHandler = new m(this);

    public boolean sF() {
        return Wk;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (sF() || this.Wi.getCount() == 0) {
            Wk = false;
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
        this.Wr = (TextView) findViewById(com.baidu.tieba.v.jigsaw_selected_text);
        this.WL = (int) getResources().getDimension(com.baidu.tieba.t.onedip);
        this.WK = (i - (this.WL * 16)) / 3;
        this.Wi = u.sM();
        this.WG = new r(this, this);
        this.WF = (GridView) findViewById(com.baidu.tieba.v.jigsaw_grid);
        this.WF.setAdapter((ListAdapter) this.WG);
        this.WF.setOnScrollListener(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        ((Button) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_textbtn, new o(this))).setText(com.baidu.tieba.y.jigsaw_start);
        this.Ws = (LinearLayout) findViewById(com.baidu.tieba.v.selected_ll);
        this.WI = (HorizontalScrollView) findViewById(com.baidu.tieba.v.hsv);
        this.mNavigationBar.setTitleText(this.Wi.sN());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.WM = true;
        Wl = true;
        this.WJ = new q(this);
        Thread thread = new Thread(this.WJ);
        thread.setDaemon(true);
        thread.start();
        this.Wr.setText(this.Wi.E(this));
        sG();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.WE.clear();
        super.onDestroy();
    }

    private void sG() {
        this.Ws.removeAllViews();
        for (Uri uri : this.Wi.C(this)) {
            x xVar = new x(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(com.baidu.tieba.t.jigsawSelectedWidth), (int) getResources().getDimension(com.baidu.tieba.t.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            xVar.setLayoutParams(layoutParams);
            if (xVar.g(uri)) {
                this.Ws.addView(xVar);
                xVar.setOnClickListener(new p(this, xVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Uri uri) {
        a aVar;
        if (uri != null) {
            for (int i = 0; i < this.Ws.getChildCount(); i++) {
                View childAt = this.Ws.getChildAt(i);
                if ((childAt instanceof x) && uri.equals(((x) childAt).getUri())) {
                    this.Ws.removeView(childAt);
                }
            }
            int e = this.Wi.e(uri);
            if (e >= 0 && (aVar = (a) this.WE.get((Object) Integer.valueOf(e))) != null) {
                aVar.setIsSelected(false);
            }
            this.Wi.b(this, uri);
            this.Wr.setText(this.Wi.E(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.WJ.sL();
        sI();
        System.gc();
        if (this.WJ != null) {
            this.WJ.sL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bitmap bitmap) {
        ImageView imageView;
        if (this.WE.containsKey(Integer.valueOf(i))) {
            imageView = this.WE.get((Object) Integer.valueOf(i));
            this.WE.get((Object) Integer.valueOf(i)).setImageBitmap(bitmap);
        } else {
            imageView = new ImageView(this);
            imageView.setImageBitmap(bitmap);
            this.WE.put(Integer.valueOf(i), imageView);
        }
        imageView.setTag("bitmap");
    }

    private void sI() {
        int count = currentPosition + 20 > this.Wi.getCount() ? this.Wi.getCount() - currentPosition : 20;
        if (this.WE.size() != 0) {
            for (int i = currentPosition; i < currentPosition + count; i++) {
                if (this.WE.containsKey(Integer.valueOf(i))) {
                    this.WE.get((Object) Integer.valueOf(i)).setImageDrawable(null);
                    this.WE.get((Object) Integer.valueOf(i)).setTag("");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sH() {
        if (u.sM().C(this).size() >= 2) {
            if (Wl) {
                Wl = false;
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
