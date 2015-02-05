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
    u acM;
    private TextView acV;
    private LinearLayout acW;
    private GridView adj;
    r adk;
    private HorizontalScrollView adm;
    q adn;
    private static volatile int currentPosition = 0;
    private static volatile int adl = 0;
    private static boolean acO = false;
    private static boolean acP = true;
    private final int adg = 50;
    private final int adh = 20;
    private ViewphotoLinkedHashMap adi = new ViewphotoLinkedHashMap(50);
    private NavigationBar mNavigationBar = null;
    int ado = 0;
    int adp = 0;
    private boolean adq = false;
    private Handler mHandler = new m(this);

    public boolean wu() {
        return acO;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (wu() || this.acM.getCount() == 0) {
            acO = false;
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
        this.acV = (TextView) findViewById(com.baidu.tieba.w.jigsaw_selected_text);
        this.adp = (int) getResources().getDimension(com.baidu.tieba.u.onedip);
        this.ado = (i - (this.adp * 16)) / 3;
        this.acM = u.wA();
        this.adk = new r(this, getPageContext().getContext());
        this.adj = (GridView) findViewById(com.baidu.tieba.w.jigsaw_grid);
        this.adj.setAdapter((ListAdapter) this.adk);
        this.adj.setOnScrollListener(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        ((Button) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_textbtn, new o(this))).setText(z.jigsaw_start);
        this.acW = (LinearLayout) findViewById(com.baidu.tieba.w.selected_ll);
        this.adm = (HorizontalScrollView) findViewById(com.baidu.tieba.w.hsv);
        this.mNavigationBar.setTitleText(this.acM.wB());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.adq = true;
        acP = true;
        this.adn = new q(this);
        Thread thread = new Thread(this.adn);
        thread.setDaemon(true);
        thread.start();
        this.acV.setText(this.acM.ab(getPageContext().getContext()));
        wv();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.adi.clear();
        super.onDestroy();
    }

    private void wv() {
        this.acW.removeAllViews();
        for (Uri uri : this.acM.Z(getPageContext().getContext())) {
            w wVar = new w(getPageContext().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedWidth), (int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            if (wVar.h(uri)) {
                this.acW.addView(wVar);
                wVar.setOnClickListener(new p(this, wVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Uri uri) {
        a aVar;
        if (uri != null) {
            for (int i = 0; i < this.acW.getChildCount(); i++) {
                View childAt = this.acW.getChildAt(i);
                if ((childAt instanceof w) && uri.equals(((w) childAt).getUri())) {
                    this.acW.removeView(childAt);
                }
            }
            int f = this.acM.f(uri);
            if (f >= 0 && (aVar = (a) this.adi.get((Object) Integer.valueOf(f))) != null) {
                aVar.setIsSelected(false);
            }
            this.acM.d(getPageContext().getContext(), uri);
            this.acV.setText(this.acM.ab(getPageContext().getContext()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.adn.wz();
        wx();
        System.gc();
        if (this.adn != null) {
            this.adn.wz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bitmap bitmap) {
        ImageView imageView;
        if (this.adi.containsKey(Integer.valueOf(i))) {
            imageView = this.adi.get((Object) Integer.valueOf(i));
            this.adi.get((Object) Integer.valueOf(i)).setImageBitmap(bitmap);
        } else {
            imageView = new ImageView(getPageContext().getContext());
            imageView.setImageBitmap(bitmap);
            this.adi.put(Integer.valueOf(i), imageView);
        }
        imageView.setTag("bitmap");
    }

    private void wx() {
        int count = currentPosition + 20 > this.acM.getCount() ? this.acM.getCount() - currentPosition : 20;
        if (this.adi.size() != 0) {
            for (int i = currentPosition; i < currentPosition + count; i++) {
                if (this.adi.containsKey(Integer.valueOf(i))) {
                    this.adi.get((Object) Integer.valueOf(i)).setImageDrawable(null);
                    this.adi.get((Object) Integer.valueOf(i)).setTag("");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ww() {
        if (u.wA().Z(getPageContext().getContext()).size() >= 2) {
            if (acP) {
                acP = false;
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
