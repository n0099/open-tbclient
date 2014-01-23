package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bq;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends j {
    private static String d = "from_page";
    private FrameLayout e;
    private ViewPager f;
    private LinearLayout g;
    private Button h;
    private FrameLayout i;
    private ImageView j;
    private List<View> k;
    private boolean l;
    private af b = null;
    private String c = null;
    private Handler m = new aa(this);
    public View.OnClickListener a = new ab(this);

    public static void a(Activity activity, String str) {
        Intent intent = new Intent(activity, GuideActivity.class);
        intent.putExtra(d, str);
        activity.startActivity(intent);
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.guide_activity);
        this.l = false;
        a();
        if (bundle != null) {
            this.c = bundle.getString(d);
        } else {
            this.c = getIntent().getStringExtra(d);
        }
        if (this.c != null && this.c.equals("from_logo_page")) {
            this.b = new af(this, null);
            this.b.setSelfExecute(true);
            this.b.execute(new String[0]);
            return;
        }
        this.b = null;
    }

    private void a() {
        this.e = (FrameLayout) findViewById(R.id.fl_guide_bottom);
        this.f = (ViewPager) findViewById(R.id.guide_viewPager);
        this.g = (LinearLayout) findViewById(R.id.ll_guide_point_icon);
        this.h = (Button) findViewById(R.id.btn_guide_enter);
        this.i = (FrameLayout) findViewById(R.id.fl_guide_top);
        this.j = (ImageView) findViewById(R.id.iv_guide_horse);
        this.k = new ArrayList();
        LayoutInflater layoutInflater = getLayoutInflater();
        View inflate = layoutInflater.inflate(R.layout.guide_viewpager_view1, (ViewGroup) null);
        View inflate2 = layoutInflater.inflate(R.layout.guide_viewpager_view2, (ViewGroup) null);
        this.k.add(inflate);
        this.k.add(inflate2);
        this.f.setAdapter(new GuideViewPagerAdapter(this.k));
        this.f.setOnPageChangeListener(new GuideOnPageChangeListener());
        this.h.setVisibility(8);
        this.h.setOnClickListener(this.a);
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.m.removeMessages(1);
        this.m.removeMessages(2);
        if (this.b != null) {
            this.b.cancel(true);
            this.b = null;
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.m.postDelayed(new ac(this), 200L);
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        b();
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (!this.c.equals("from_about_page")) {
                    b();
                }
                closeActivity();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String A = TiebaApplication.A();
        boolean aF = TiebaApplication.h().aF();
        if (A != null && A.length() > 0 && !aF) {
            MainTabActivity.a(this, 1);
        } else {
            MainTabActivity.c(1);
            MainTabActivity.a(this, 2);
            if (aF) {
                TiebaApplication.h().aG();
            }
            if ((A == null || A.length() <= 0) && TiebaApplication.n() && f.a((Activity) this)) {
                TiebaApplication.h().aw();
                f.a(this, 0, 1, false);
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPackageName(), getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getString(R.string.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
        sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getString(R.string.app_name)}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.a(getClass().getName(), "checkShortCut", e.toString());
        }
        return false;
    }

    /* loaded from: classes.dex */
    public class GuideViewPagerAdapter extends android.support.v4.view.ae {
        public List<View> a;

        public GuideViewPagerAdapter(List<View> list) {
            this.a = list;
        }

        @Override // android.support.v4.view.ae
        public void destroyItem(View view, int i, Object obj) {
            ((ViewPager) view).removeView(this.a.get(i));
        }

        @Override // android.support.v4.view.ae
        public void finishUpdate(View view) {
        }

        @Override // android.support.v4.view.ae
        public int getCount() {
            return this.a.size();
        }

        @Override // android.support.v4.view.ae
        public Object instantiateItem(View view, int i) {
            ((ViewPager) view).addView(this.a.get(i), 0);
            return this.a.get(i);
        }

        @Override // android.support.v4.view.ae
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.ae
        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        }

        @Override // android.support.v4.view.ae
        public Parcelable saveState() {
            return null;
        }

        @Override // android.support.v4.view.ae
        public void startUpdate(View view) {
        }
    }

    /* loaded from: classes.dex */
    public class GuideOnPageChangeListener implements bq {
        public GuideOnPageChangeListener() {
        }

        @Override // android.support.v4.view.bq
        public void a_(int i) {
            switch (i) {
                case 0:
                    GuideActivity.this.h.setVisibility(8);
                    GuideActivity.this.a(0);
                    return;
                case 1:
                    GuideActivity.this.h.setVisibility(0);
                    GuideActivity.this.a(1);
                    return;
                default:
                    return;
            }
        }

        @Override // android.support.v4.view.bq
        public void a(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.bq
        public void b(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        int childCount = this.g.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ImageView imageView = (ImageView) this.g.getChildAt(i2);
            if (i2 == i % 2) {
                imageView.setImageResource(R.drawable.dot_guide_s);
            } else {
                imageView.setImageResource(R.drawable.dot_guide_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.m.postDelayed(new ad(this), 2000L);
        this.j.startAnimation(AnimationUtils.loadAnimation(this, R.anim.guide_horse_set));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.m.postDelayed(new ae(this), 1000L);
        this.i.startAnimation(AnimationUtils.loadAnimation(this, R.anim.guide_horse_view_trans));
        g();
        a(0);
        this.f.setCurrentItem(0);
    }

    private void g() {
        this.e.startAnimation(AnimationUtils.loadAnimation(this, R.anim.guide_viewpager_alpha));
    }
}
