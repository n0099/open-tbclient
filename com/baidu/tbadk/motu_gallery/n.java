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
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.a implements AbsListView.OnScrollListener {
    private static volatile int j = 0;
    private static volatile int k = 0;
    private static boolean q = false;
    private static boolean r = true;
    w a;
    t b;
    s c;
    private GridView i;
    private LinearLayout m;
    private HorizontalScrollView n;
    private TextView o;
    private final int f = 50;
    private final int g = 20;
    private ViewphotoLinkedHashMap h = new ViewphotoLinkedHashMap(50);
    private NavigationBar l = null;
    int d = 0;
    int e = 0;
    private boolean p = false;
    private Handler s = new o(this);

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (q || this.a.b() == 0) {
            q = false;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tbadk.k.motu_albums_list_activity);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        this.o = (TextView) findViewById(com.baidu.tbadk.j.jigsaw_selected_text);
        this.e = (int) getResources().getDimension(com.baidu.tbadk.h.onedip);
        this.d = (i - (this.e * 16)) / 3;
        this.a = w.a();
        this.b = new t(this, this);
        this.i = (GridView) findViewById(com.baidu.tbadk.j.jigsaw_grid);
        this.i.setAdapter((ListAdapter) this.b);
        this.i.setOnScrollListener(this);
        this.l = (NavigationBar) findViewById(com.baidu.tbadk.j.view_navigation_bar);
        this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new p(this));
        ((Button) this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tbadk.k.widget_nb_item_textbtn, new q(this))).setText(com.baidu.tbadk.l.jigsaw_start);
        this.m = (LinearLayout) findViewById(com.baidu.tbadk.j.selected_ll);
        this.n = (HorizontalScrollView) findViewById(com.baidu.tbadk.j.hsv);
        this.l.a(this.a.e());
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        this.p = true;
        r = true;
        this.c = new s(this);
        Thread thread = new Thread(this.c);
        thread.setDaemon(true);
        thread.start();
        this.o.setText(this.a.c(this));
        c();
    }

    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        this.l.b(i);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        this.h.clear();
        super.onDestroy();
    }

    private void c() {
        this.m.removeAllViews();
        for (Uri uri : this.a.d()) {
            y yVar = new y(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(com.baidu.tbadk.h.jigsawSelectedWidth), (int) getResources().getDimension(com.baidu.tbadk.h.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            yVar.setLayoutParams(layoutParams);
            if (yVar.a(uri)) {
                this.m.addView(yVar);
                yVar.setOnClickListener(new r(this, yVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(n nVar, Uri uri) {
        a aVar;
        if (uri != null) {
            for (int i = 0; i < nVar.m.getChildCount(); i++) {
                View childAt = nVar.m.getChildAt(i);
                if ((childAt instanceof y) && uri.equals(((y) childAt).getUri())) {
                    nVar.m.removeView(childAt);
                }
            }
            int a = nVar.a.a(uri);
            if (a >= 0 && (aVar = (a) nVar.h.get((Object) Integer.valueOf(a))) != null) {
                aVar.setIsSelected(false);
            }
            nVar.a.b(nVar, uri);
            nVar.o.setText(nVar.a.c(nVar));
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.c.a();
        int b = j + 20 > this.a.b() ? this.a.b() - j : 20;
        if (this.h.size() != 0) {
            for (int i = j; i < j + b; i++) {
                if (this.h.containsKey(Integer.valueOf(i))) {
                    this.h.get((Object) Integer.valueOf(i)).setImageBitmap(null);
                    this.h.get((Object) Integer.valueOf(i)).setTag("");
                }
            }
        }
        System.gc();
        if (this.c != null) {
            this.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(n nVar, int i, Bitmap bitmap) {
        ImageView imageView;
        if (nVar.h.containsKey(Integer.valueOf(i))) {
            imageView = nVar.h.get((Object) Integer.valueOf(i));
            nVar.h.get((Object) Integer.valueOf(i)).setImageBitmap(bitmap);
        } else {
            imageView = new ImageView(nVar);
            imageView.setImageBitmap(bitmap);
            nVar.h.put(Integer.valueOf(i), imageView);
        }
        imageView.setTag("bitmap");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(n nVar) {
        if (w.a().d().size() < 2) {
            z.a(com.baidu.tbadk.l.jigsaw_2_least);
        } else if (r) {
            r = false;
            nVar.setResult(2);
            nVar.finish();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        j = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
