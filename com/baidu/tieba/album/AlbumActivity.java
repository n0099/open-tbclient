package com.baidu.tieba.album;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.img.WriteImagesInfo;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class AlbumActivity extends com.baidu.tieba.k implements View.OnClickListener {
    private static final String d = AlbumActivity.class.getName();
    private p e;
    private u f;
    private int g;
    private boolean h = false;
    private com.baidu.tieba.img.e i;

    private static void a(Activity activity, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(activity, AlbumActivity.class);
            intent.putExtra("write_images_info", str);
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, WriteImagesInfo writeImagesInfo, int i) {
        if (writeImagesInfo != null) {
            a(activity, writeImagesInfo.toJsonString(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.i = new com.baidu.tieba.img.e(this);
            h();
            a(bundle);
            i();
            j();
            e();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(d, "oncreate", "error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.e.b().toJsonString());
    }

    private void a(Bundle bundle) {
        this.e = new p();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.e.a(writeImagesInfo);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
            this.e.a(writeImagesInfo2);
        }
    }

    private void h() {
        this.f = new u(this);
        this.f.a();
    }

    private void i() {
        if (this.e != null && !TextUtils.isEmpty(this.e.c())) {
            d(1);
        } else {
            d(0);
        }
    }

    private void j() {
        if (this.f != null && this.e != null) {
            this.f.a(this.e.d());
            if (this.e.a() != null) {
                for (ImageFileInfo imageFileInfo : this.e.a()) {
                    this.f.a(imageFileInfo);
                }
            }
            l();
        }
    }

    public void e() {
        int d2 = this.e.d();
        int h = this.e.h();
        this.f.a(h != 0, getString(R.string.album_finish_btn, new Object[]{Integer.valueOf(h), Integer.valueOf(d2)}));
    }

    @Override // com.baidu.tieba.k
    protected void b(int i) {
        this.f.d(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f.e()) {
            if (this.g == 0) {
                this.e.a((String) null);
            }
            Intent intent = new Intent();
            intent.putExtra("album_result", this.e.b().toJsonString());
            setResult(-1, intent);
            finish();
        } else if (view == this.f.f()) {
            if (this.e != null) {
                this.e.a((String) null);
            }
            k();
        } else if (view == this.f.g()) {
            d(0);
        } else if (view == this.f.h()) {
            d(1);
        } else if (view == this.f.i()) {
            k();
        }
    }

    public p f() {
        return this.e;
    }

    public com.baidu.tieba.img.e g() {
        if (this.i == null) {
            this.i = new com.baidu.tieba.img.e(this);
        }
        return this.i;
    }

    public void d(int i) {
        if (!this.h) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.f.c(this.g));
            if (findFragmentByTag != null) {
                getSupportFragmentManager().beginTransaction().hide(findFragmentByTag).commitAllowingStateLoss();
                getSupportFragmentManager().executePendingTransactions();
                this.i.b();
            }
            this.g = i;
            if (this.f != null) {
                this.f.e(this.g);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.f.c(i)) != null) {
                getSupportFragmentManager().beginTransaction().show(this.f.b(i)).commitAllowingStateLoss();
                getSupportFragmentManager().executePendingTransactions();
                return;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, this.f.b(i), this.f.c(i)).commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int d2 = this.e.d();
        if (this.e.h() < d2) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.e.a(imageFileInfo2);
            e();
            l();
            this.f.a(imageFileInfo2);
            return true;
        }
        a(String.format(getString(R.string.album_beyond_max_choose), Integer.valueOf(d2)));
        return false;
    }

    public boolean b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.e.b(imageFileInfo);
        e();
        l();
        this.f.b(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.g == 0) {
                if (this.e != null) {
                    this.e.a((String) null);
                }
                k();
                return true;
            } else if (this.g == 1) {
                d(0);
                return true;
            } else if (this.g == 2) {
                d(1);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void a(int i, boolean z) {
        Fragment b;
        if (this.f != null && (b = this.f.b(1)) != null && (b instanceof ag)) {
            ((ag) b).a(i, z);
        }
    }

    public void a(ImageFileInfo imageFileInfo, boolean z) {
        Fragment b;
        if (this.f != null && (b = this.f.b(1)) != null && (b instanceof ag)) {
            ((ag) b).a(imageFileInfo, z);
        }
    }

    public void b(ImageFileInfo imageFileInfo, boolean z) {
        Fragment b;
        if (this.f != null && (b = this.f.b(2)) != null && (b instanceof b)) {
            ((b) b).a(imageFileInfo, z);
        }
    }

    private void k() {
        Intent intent = new Intent();
        String c = this.e.c();
        if (TextUtils.isEmpty(c)) {
            c = "";
        }
        intent.putExtra("last_album_id", c);
        setResult(0, intent);
        finish();
    }

    private void l() {
        if (this.e != null && this.f != null) {
            if (this.e.h() == this.e.d()) {
                this.f.a(false);
            } else {
                this.f.a(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.h = true;
        if (this.f != null) {
            this.f.j();
        }
        this.i.b();
    }
}
