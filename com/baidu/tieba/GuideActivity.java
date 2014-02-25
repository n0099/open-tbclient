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
import android.support.v4.view.ViewPager;
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
public class GuideActivity extends f {
    private static String l = "from_page";
    private ArrayList<View> g;
    private z h;
    private BaseViewPager i;
    private List<Bitmap> k;
    private y d = null;
    private String e = null;
    private int[] f = {R.drawable.image_bootpage01, R.drawable.image_bootpage02};
    private Button j = null;
    private boolean m = true;
    private com.baidu.tieba.view.a n = new t(this);
    public View.OnClickListener a = new u(this);
    public View.OnClickListener b = new v(this);
    public View.OnClickListener c = new w(this);
    private final ViewPager.OnPageChangeListener o = new x(this);

    public static void a(Activity activity, String str) {
        Intent intent = new Intent(activity, GuideActivity.class);
        intent.putExtra(l, str);
        activity.startActivity(intent);
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.guide_activity);
        this.h = new z(this, null);
        this.i = (BaseViewPager) findViewById(R.id.guide_pager);
        this.i.setAdapter(this.h);
        this.i.setOnScrollOutListener(this.n);
        this.i.setOnPageChangeListener(this.o);
        this.k = new ArrayList();
        this.g = new ArrayList<>();
        for (int i = 0; i < this.f.length; i++) {
            Bitmap b = com.baidu.tieba.util.n.b(this, this.f[i]);
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setBackgroundColor(-1);
            imageView.setOnClickListener(this.c);
            imageView.setImageBitmap(b);
            this.k.add(b);
            this.g.add(i, imageView);
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.guide_view_last, (ViewGroup) null);
        this.j = (Button) inflate.findViewById(R.id.last_page_btn);
        this.j.setOnClickListener(this.a);
        this.g.add(inflate);
        if (bundle != null) {
            this.e = bundle.getString(l);
        } else {
            this.e = getIntent().getStringExtra(l);
        }
        if (TiebaApplication.g().s()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.i.l());
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
        if (this.e.equals("from_logo_page")) {
            this.d = new y(this, null);
            this.d.setSelfExecute(true);
            this.d.execute(new String[0]);
            return;
        }
        this.d = null;
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
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
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (!this.e.equals("from_about_page")) {
                    a();
                }
                closeActivity();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void a() {
        if (this.m) {
            boolean aE = TiebaApplication.g().aE();
            com.baidu.tieba.mention.v.a().l();
            com.baidu.tieba.mention.v.a().j();
            if (!aE) {
                MainTabActivity.a(this, 1);
            } else {
                MainTabActivity.d(2);
                MainTabActivity.a(this, 2);
                if (aE) {
                    TiebaApplication.g().aF();
                }
            }
            finish();
            this.m = false;
        }
    }

    public void b() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPackageName(), String.valueOf(getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getString(R.string.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
        sendBroadcast(intent2);
    }

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
            com.baidu.adp.lib.util.f.a(getClass().getName(), "checkShortCut", e.toString());
        }
        return false;
    }
}
