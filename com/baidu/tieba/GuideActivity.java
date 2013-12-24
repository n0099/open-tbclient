package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.bq;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends j {
    public static String a = "from_logo_page";
    public static String b = "from_about_page";
    private static String n = "from_page";
    private ArrayList<View> g;
    private ag h;
    private BaseViewPager i;
    private List<Bitmap> k;
    private int[] f = {R.drawable.image_bootpage01};
    private Button j = null;
    private af l = null;
    private String m = null;
    private com.baidu.tieba.view.a o = new aa(this);
    public View.OnClickListener c = new ab(this);
    public View.OnClickListener d = new ac(this);
    public View.OnClickListener e = new ad(this);
    private final bq p = new ae(this);

    public static void a(Activity activity, String str) {
        Intent intent = new Intent(activity, GuideActivity.class);
        intent.putExtra(n, str);
        activity.startActivity(intent);
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.guide_activity);
        this.h = new ag(this, null);
        this.i = (BaseViewPager) findViewById(R.id.guide_pager);
        this.i.setAdapter(this.h);
        this.i.setOnScrollOutListener(this.o);
        this.i.setOnPageChangeListener(this.p);
        this.k = new ArrayList();
        this.g = new ArrayList<>();
        for (int i = 0; i < this.f.length; i++) {
            Bitmap b2 = com.baidu.tieba.util.m.b(this, this.f[i]);
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setBackgroundColor(-1);
            imageView.setOnClickListener(this.e);
            imageView.setImageBitmap(b2);
            this.k.add(b2);
            this.g.add(i, imageView);
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.guide_view_last, (ViewGroup) null);
        this.j = (Button) inflate.findViewById(R.id.last_page_btn);
        this.j.setOnClickListener(this.c);
        this.g.add(inflate);
        if (TiebaApplication.h().t()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.h.a());
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
        if (bundle != null) {
            this.m = bundle.getString(n);
        } else {
            this.m = getIntent().getStringExtra(n);
        }
        if (this.m.equals(a)) {
            this.l = new af(this, null);
            this.l.setSelfExecute(true);
            this.l.execute(new String[0]);
            return;
        }
        this.l = null;
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f.length) {
                break;
            }
            View view = this.g.get(i2);
            if (view != null) {
                view.setBackgroundDrawable(null);
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageBitmap(null);
                }
            }
            Bitmap bitmap = this.k.get(i2);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            i = i2 + 1;
        }
        if (this.l != null) {
            this.l.cancel(true);
            this.l = null;
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.h().t()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        if (TiebaApplication.h().t()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                a();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String B = TiebaApplication.B();
        boolean aH = TiebaApplication.h().aH();
        if (B != null && B.length() > 0 && !aH) {
            MainTabActivity.a(this, 1);
        } else {
            MainTabActivity.c(1);
            MainTabActivity.a(this, 2);
            if (aH) {
                TiebaApplication.h().aI();
            }
            if ((B == null || B.length() <= 0) && TiebaApplication.o() && f.a((Activity) this)) {
                TiebaApplication.h().ay();
                f.a(this, 0, 1, false);
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
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
    public boolean c() {
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
            com.baidu.tieba.util.be.a(getClass().getName(), "checkShortCut", e.toString());
        }
        return false;
    }
}
