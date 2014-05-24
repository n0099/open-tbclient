package com.baidu.tieba.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener {
    private static final String c = AlbumActivity.class.getName();
    private p d;
    private v e;
    private int f;
    private boolean g = false;
    private com.baidu.tbadk.img.e h;

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.a.class, AlbumActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.h = new com.baidu.tbadk.img.e(this);
            h();
            a(bundle);
            i();
            j();
            e();
        } catch (Exception e) {
            BdLog.e(c, "oncreate", "error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.d.b().toJsonString());
    }

    private void a(Bundle bundle) {
        this.d = new p();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.d.a(writeImagesInfo);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
            this.d.a(writeImagesInfo2);
        }
    }

    private void h() {
        this.e = new v(this);
        this.e.a();
    }

    private void i() {
        if (this.d != null && !TextUtils.isEmpty(this.d.c())) {
            d(1);
        } else {
            d(0);
        }
    }

    private void j() {
        if (this.e != null && this.d != null) {
            this.e.a(this.d.d());
            if (this.d.a() != null) {
                for (ImageFileInfo imageFileInfo : this.d.a()) {
                    this.e.a(imageFileInfo);
                }
            }
            l();
        }
    }

    void e() {
        int d = this.d.d();
        int h = this.d.h();
        this.e.a(h != 0, getString(com.baidu.tieba.y.album_finish_btn, new Object[]{Integer.valueOf(h), Integer.valueOf(d)}));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.e.d(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.e.b()) {
            if (this.f == 0) {
                this.d.a((String) null);
            }
            Intent intent = new Intent();
            intent.putExtra("album_result", this.d.b().toJsonString());
            setResult(-1, intent);
            finish();
        } else if (view == this.e.c()) {
            if (this.d != null) {
                this.d.a((String) null);
            }
            k();
        } else if (view == this.e.d()) {
            d(0);
        } else if (view == this.e.e()) {
            d(1);
        } else if (view == this.e.f()) {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p f() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.tbadk.img.e g() {
        if (this.h == null) {
            this.h = new com.baidu.tbadk.img.e(this);
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        if (!this.g) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.e.c(this.f));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.h.b();
            }
            this.f = i;
            if (this.e != null) {
                this.e.e(this.f);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.e.c(i)) != null) {
                beginTransaction.show(this.e.b(i));
            } else {
                beginTransaction.add(com.baidu.tieba.v.fragment, this.e.b(i), this.e.c(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int d = this.d.d();
        if (this.d.h() < d) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.d.a(imageFileInfo2);
            e();
            l();
            this.e.a(imageFileInfo2);
            return true;
        }
        a(String.format(getString(com.baidu.tieba.y.album_beyond_max_choose), Integer.valueOf(d)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.d.b(imageFileInfo);
        e();
        l();
        this.e.b(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f == 0) {
                if (this.d != null) {
                    this.d.a((String) null);
                }
                k();
                return true;
            } else if (this.f == 1) {
                d(0);
                return true;
            } else if (this.f == 2) {
                d(1);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        Fragment b;
        if (this.e != null && (b = this.e.b(1)) != null && (b instanceof ah)) {
            ((ah) b).a(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        Fragment b;
        if (this.e != null && (b = this.e.b(1)) != null && (b instanceof ah)) {
            ((ah) b).a(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ImageFileInfo imageFileInfo, boolean z) {
        Fragment b;
        if (this.e != null && (b = this.e.b(2)) != null && (b instanceof b)) {
            ((b) b).a(imageFileInfo, z);
        }
    }

    private void k() {
        Intent intent = new Intent();
        String c2 = this.d.c();
        if (TextUtils.isEmpty(c2)) {
            c2 = "";
        }
        intent.putExtra("last_album_id", c2);
        setResult(0, intent);
        finish();
    }

    private void l() {
        if (this.d != null && this.e != null) {
            if (this.d.h() == this.d.d()) {
                this.e.a(false);
            } else {
                this.e.a(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.g = true;
        if (this.e != null) {
            this.e.g();
        }
        this.h.b();
        q.a().c();
    }
}
