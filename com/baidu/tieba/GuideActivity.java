package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.c.ae;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends Activity {
    ArrayList a;
    ViewPager b;
    private i e;
    private Button f;
    private List g;
    private int[] d = {R.drawable.guide0, R.drawable.guide1, R.drawable.guide2, R.drawable.guide3};
    public View.OnClickListener c = new h(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ((ProgressBar) findViewById(R.id.guide_progress)).setVisibility(0);
        String u = TiebaApplication.u();
        String str = TiebaApplication.a().ad() >= 3 ? "goto_home" : "goto_recommend";
        MainTabActivity.a(this, str);
        if ((u == null || u.length() <= 0) && TiebaApplication.f() && a.a((Activity) this)) {
            a.a(this, 0, str, false);
        }
        finish();
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, GuideActivity.class));
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.guide_activity);
        this.e = new i(this, null);
        this.b = (ViewPager) findViewById(R.id.guide_pager);
        this.b.setAdapter(this.e);
        this.g = new ArrayList();
        LayoutInflater layoutInflater = getLayoutInflater();
        this.a = new ArrayList();
        int i = 0;
        while (i < this.d.length) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.d[i]);
            View inflate = i == this.d.length + (-1) ? layoutInflater.inflate(R.layout.guide_view, (ViewGroup) null) : new ImageView(this);
            inflate.setBackgroundDrawable(new BitmapDrawable(decodeResource));
            this.g.add(decodeResource);
            this.a.add(i, inflate);
            i++;
        }
        if (TiebaApplication.a().i()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.a.h.a());
            } catch (Exception e) {
                ae.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.length) {
                return;
            }
            View view = (View) this.a.get(i2);
            if (view != null) {
                view.setBackgroundDrawable(null);
            }
            Bitmap bitmap = (Bitmap) this.g.get(i2);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            i = i2 + 1;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                a();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (TiebaApplication.a().i()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                ae.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.a().i()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                ae.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
    }
}
