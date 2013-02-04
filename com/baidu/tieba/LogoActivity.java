package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.service.FatalErrorService;
import java.io.File;
/* loaded from: classes.dex */
public class LogoActivity extends e {
    private boolean b = false;
    private boolean c = false;
    private ImageView d = null;
    private Bitmap e = null;
    private AlphaAnimation f = null;
    private Handler g = new j(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        if (file == null) {
            return;
        }
        try {
            if (!file.isDirectory()) {
                if (file.delete()) {
                    return;
                }
                ae.b(getClass().getName(), "deleteAllfile", "file.delete error");
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        a(listFiles[i]);
                    } else if (!listFiles[i].delete()) {
                        ae.b(getClass().getName(), "deleteAllfile", "list[i].delete error");
                    }
                }
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "deleteAllfile", e.getMessage());
        }
    }

    private void g() {
        startService(new Intent(this, FatalErrorService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.baidu.tieba.account.a.a().d();
        if (TiebaApplication.a().j()) {
            TiebaApplication.a().ar();
        }
        if (TiebaApplication.a().an()) {
            TiebaApplication.a().ao();
            GuideActivity.a(this);
            finish();
            return;
        }
        String u = TiebaApplication.u();
        String str = TiebaApplication.a().ad() >= 3 ? "goto_home" : "goto_recommend";
        MainTabActivity.a(this, str);
        if ((u == null || u.length() <= 0) && TiebaApplication.f() && a.a((Activity) this)) {
            a.a(this, 0, str, false);
        }
        finish();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ae.a(getClass().getName(), "onCreate", null);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.logo_activity);
        this.d = (ImageView) findViewById(R.id.logo);
        this.e = com.baidu.tieba.c.e.a(this, (int) R.drawable.logo);
        this.d.setImageBitmap(this.e);
        this.f = new AlphaAnimation(0.5f, 1.0f);
        this.f.setDuration(2000L);
        this.f.setAnimationListener(new k(this));
        this.d.startAnimation(this.f);
        new l(this).start();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.d.setImageBitmap(null);
        if (this.e == null || this.e.isRecycled()) {
            return;
        }
        this.e.recycle();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
