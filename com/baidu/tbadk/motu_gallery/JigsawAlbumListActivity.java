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
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class JigsawAlbumListActivity extends BaseActivity implements AbsListView.OnScrollListener {
    private TextView acB;
    private LinearLayout acC;
    private GridView acO;
    r acP;
    private HorizontalScrollView acR;
    q acS;
    u acr;
    private static volatile int currentPosition = 0;
    private static volatile int acQ = 0;
    private static boolean acu = false;
    private static boolean acv = true;
    private final int acL = 50;
    private final int acM = 20;
    private ViewphotoLinkedHashMap acN = new ViewphotoLinkedHashMap(50);
    private NavigationBar mNavigationBar = null;
    int acT = 0;
    int acU = 0;
    private boolean acV = false;
    private Handler mHandler = new m(this);

    public boolean wk() {
        return acu;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (wk() || this.acr.getCount() == 0) {
            acu = false;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.motu_albums_list_activity);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        this.acB = (TextView) findViewById(com.baidu.tieba.w.jigsaw_selected_text);
        this.acU = (int) getResources().getDimension(com.baidu.tieba.u.onedip);
        this.acT = (i - (this.acU * 16)) / 3;
        this.acr = u.wq();
        this.acP = new r(this, getPageContext().getContext());
        this.acO = (GridView) findViewById(com.baidu.tieba.w.jigsaw_grid);
        this.acO.setAdapter((ListAdapter) this.acP);
        this.acO.setOnScrollListener(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        ((Button) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_textbtn, new o(this))).setText(z.jigsaw_start);
        this.acC = (LinearLayout) findViewById(com.baidu.tieba.w.selected_ll);
        this.acR = (HorizontalScrollView) findViewById(com.baidu.tieba.w.hsv);
        this.mNavigationBar.setTitleText(this.acr.wr());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.acV = true;
        acv = true;
        this.acS = new q(this);
        Thread thread = new Thread(this.acS);
        thread.setDaemon(true);
        thread.start();
        this.acB.setText(this.acr.ab(getPageContext().getContext()));
        wl();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.acN.clear();
        super.onDestroy();
    }

    private void wl() {
        this.acC.removeAllViews();
        for (Uri uri : this.acr.Z(getPageContext().getContext())) {
            x xVar = new x(getPageContext().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedWidth), (int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            xVar.setLayoutParams(layoutParams);
            if (xVar.h(uri)) {
                this.acC.addView(xVar);
                xVar.setOnClickListener(new p(this, xVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Uri uri) {
        a aVar;
        if (uri != null) {
            for (int i = 0; i < this.acC.getChildCount(); i++) {
                View childAt = this.acC.getChildAt(i);
                if ((childAt instanceof x) && uri.equals(((x) childAt).getUri())) {
                    this.acC.removeView(childAt);
                }
            }
            int f = this.acr.f(uri);
            if (f >= 0 && (aVar = (a) this.acN.get((Object) Integer.valueOf(f))) != null) {
                aVar.setIsSelected(false);
            }
            this.acr.d(getPageContext().getContext(), uri);
            this.acB.setText(this.acr.ab(getPageContext().getContext()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.acS.wp();
        wn();
        System.gc();
        if (this.acS != null) {
            this.acS.wp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bitmap bitmap) {
        ImageView imageView;
        if (this.acN.containsKey(Integer.valueOf(i))) {
            imageView = this.acN.get((Object) Integer.valueOf(i));
            this.acN.get((Object) Integer.valueOf(i)).setImageBitmap(bitmap);
        } else {
            imageView = new ImageView(getPageContext().getContext());
            imageView.setImageBitmap(bitmap);
            this.acN.put(Integer.valueOf(i), imageView);
        }
        imageView.setTag("bitmap");
    }

    private void wn() {
        int count = currentPosition + 20 > this.acr.getCount() ? this.acr.getCount() - currentPosition : 20;
        if (this.acN.size() != 0) {
            for (int i = currentPosition; i < currentPosition + count; i++) {
                if (this.acN.containsKey(Integer.valueOf(i))) {
                    this.acN.get((Object) Integer.valueOf(i)).setImageDrawable(null);
                    this.acN.get((Object) Integer.valueOf(i)).setTag("");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wm() {
        if (u.wq().Z(getPageContext().getContext()).size() >= 2) {
            if (acv) {
                acv = false;
                setResult(2);
                finish();
                return;
            }
            return;
        }
        y.showToastLong(z.jigsaw_2_least);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        currentPosition = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
