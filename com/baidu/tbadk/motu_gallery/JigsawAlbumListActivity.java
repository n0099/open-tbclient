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
    u acP;
    private TextView acY;
    private LinearLayout acZ;
    private GridView adm;
    r adn;
    private HorizontalScrollView adp;
    q adq;
    private static volatile int currentPosition = 0;
    private static volatile int ado = 0;
    private static boolean acR = false;
    private static boolean acS = true;
    private final int adj = 50;
    private final int adk = 20;
    private ViewphotoLinkedHashMap adl = new ViewphotoLinkedHashMap(50);
    private NavigationBar mNavigationBar = null;
    int adr = 0;
    int ads = 0;
    private boolean adt = false;
    private Handler mHandler = new m(this);

    public boolean wA() {
        return acR;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (wA() || this.acP.getCount() == 0) {
            acR = false;
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
        this.acY = (TextView) findViewById(com.baidu.tieba.w.jigsaw_selected_text);
        this.ads = (int) getResources().getDimension(com.baidu.tieba.u.onedip);
        this.adr = (i - (this.ads * 16)) / 3;
        this.acP = u.wG();
        this.adn = new r(this, getPageContext().getContext());
        this.adm = (GridView) findViewById(com.baidu.tieba.w.jigsaw_grid);
        this.adm.setAdapter((ListAdapter) this.adn);
        this.adm.setOnScrollListener(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        ((Button) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_textbtn, new o(this))).setText(z.jigsaw_start);
        this.acZ = (LinearLayout) findViewById(com.baidu.tieba.w.selected_ll);
        this.adp = (HorizontalScrollView) findViewById(com.baidu.tieba.w.hsv);
        this.mNavigationBar.setTitleText(this.acP.wH());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.adt = true;
        acS = true;
        this.adq = new q(this);
        Thread thread = new Thread(this.adq);
        thread.setDaemon(true);
        thread.start();
        this.acY.setText(this.acP.ab(getPageContext().getContext()));
        wB();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.adl.clear();
        super.onDestroy();
    }

    private void wB() {
        this.acZ.removeAllViews();
        for (Uri uri : this.acP.Z(getPageContext().getContext())) {
            w wVar = new w(getPageContext().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedWidth), (int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            if (wVar.h(uri)) {
                this.acZ.addView(wVar);
                wVar.setOnClickListener(new p(this, wVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Uri uri) {
        a aVar;
        if (uri != null) {
            for (int i = 0; i < this.acZ.getChildCount(); i++) {
                View childAt = this.acZ.getChildAt(i);
                if ((childAt instanceof w) && uri.equals(((w) childAt).getUri())) {
                    this.acZ.removeView(childAt);
                }
            }
            int f = this.acP.f(uri);
            if (f >= 0 && (aVar = (a) this.adl.get((Object) Integer.valueOf(f))) != null) {
                aVar.setIsSelected(false);
            }
            this.acP.d(getPageContext().getContext(), uri);
            this.acY.setText(this.acP.ab(getPageContext().getContext()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.adq.wF();
        wD();
        System.gc();
        if (this.adq != null) {
            this.adq.wF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bitmap bitmap) {
        ImageView imageView;
        if (this.adl.containsKey(Integer.valueOf(i))) {
            imageView = this.adl.get((Object) Integer.valueOf(i));
            this.adl.get((Object) Integer.valueOf(i)).setImageBitmap(bitmap);
        } else {
            imageView = new ImageView(getPageContext().getContext());
            imageView.setImageBitmap(bitmap);
            this.adl.put(Integer.valueOf(i), imageView);
        }
        imageView.setTag("bitmap");
    }

    private void wD() {
        int count = currentPosition + 20 > this.acP.getCount() ? this.acP.getCount() - currentPosition : 20;
        if (this.adl.size() != 0) {
            for (int i = currentPosition; i < currentPosition + count; i++) {
                if (this.adl.containsKey(Integer.valueOf(i))) {
                    this.adl.get((Object) Integer.valueOf(i)).setImageDrawable(null);
                    this.adl.get((Object) Integer.valueOf(i)).setTag("");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC() {
        if (u.wG().Z(getPageContext().getContext()).size() >= 2) {
            if (acS) {
                acS = false;
                setResult(2);
                finish();
                return;
            }
            return;
        }
        x.showToastLong(z.jigsaw_2_least);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        currentPosition = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
