package com.baidu.tieba.album;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.img.WriteImagesInfo;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class AlbumActivity extends com.baidu.tieba.k implements View.OnClickListener {
    private static final String d = AlbumActivity.class.getName();
    private p e;
    private v f;
    private int g;
    private boolean h = false;
    private com.baidu.tieba.img.e i;

    public static void a(Activity activity, WriteImagesInfo writeImagesInfo, int i) {
        if (writeImagesInfo != null) {
            String jsonString = writeImagesInfo.toJsonString();
            if (!TextUtils.isEmpty(jsonString)) {
                Intent intent = new Intent(activity, AlbumActivity.class);
                intent.putExtra("write_images_info", jsonString);
                activity.startActivityForResult(intent, 12002);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.i = new com.baidu.tieba.img.e(this);
            this.f = new v(this);
            this.f.a();
            this.e = new p();
            if (bundle != null) {
                WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                writeImagesInfo.parseJson(bundle.getString("write_images_info"));
                this.e.a(writeImagesInfo);
            } else {
                Intent intent = getIntent();
                if (intent != null) {
                    WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                    writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                    this.e.a(writeImagesInfo2);
                }
            }
            if (this.e == null || TextUtils.isEmpty(this.e.c())) {
                d(0);
            } else {
                d(1);
            }
            if (this.f != null && this.e != null) {
                this.f.a(this.e.d());
                if (this.e.a() != null) {
                    for (ImageFileInfo imageFileInfo : this.e.a()) {
                        this.f.a(imageFileInfo);
                    }
                }
                i();
            }
            g();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(d, "oncreate", "error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.e.b().toJsonString());
    }

    private void g() {
        int d2 = this.e.d();
        int h = this.e.h();
        this.f.a(h != 0, getString(R.string.album_finish_btn, new Object[]{Integer.valueOf(h), Integer.valueOf(d2)}));
    }

    @Override // com.baidu.tieba.k
    protected final void b(int i) {
        this.f.d(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f.d()) {
            if (this.g == 0) {
                this.e.a((String) null);
            }
            Intent intent = new Intent();
            intent.putExtra("album_result", this.e.b().toJsonString());
            setResult(-1, intent);
            finish();
            return;
        }
        Fragment b = this.f.b(0);
        if (view == ((b == null || !(b instanceof m)) ? null : ((m) b).a())) {
            if (this.e != null) {
                this.e.a((String) null);
            }
            h();
            return;
        }
        Fragment b2 = this.f.b(1);
        if (view == ((b2 == null || !(b2 instanceof ah)) ? null : ((ah) b2).a())) {
            d(0);
            return;
        }
        Fragment b3 = this.f.b(2);
        if (view == ((b3 == null || !(b3 instanceof b)) ? null : ((b) b3).a())) {
            d(1);
            return;
        }
        Fragment b4 = this.f.b(1);
        if (view == ((b4 == null || !(b4 instanceof ah)) ? null : ((ah) b4).b())) {
            h();
        }
    }

    public final p e() {
        return this.e;
    }

    public final com.baidu.tieba.img.e f() {
        if (this.i == null) {
            this.i = new com.baidu.tieba.img.e(this);
        }
        return this.i;
    }

    public final void d(int i) {
        if (!this.h) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.f.c(this.g));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.i.b();
            }
            this.g = i;
            if (this.f != null) {
                this.f.e(this.g);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.f.c(i)) != null) {
                beginTransaction.show(this.f.b(i));
            } else {
                beginTransaction.add(R.id.fragment, this.f.b(i), this.f.c(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    public final boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int d2 = this.e.d();
        if (this.e.h() < d2) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.e.a(imageFileInfo2);
            g();
            i();
            this.f.a(imageFileInfo2);
            return true;
        }
        BdUtilHelper.a((Context) this, String.format(getString(R.string.album_beyond_max_choose), Integer.valueOf(d2)));
        return false;
    }

    public final boolean b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.e.b(imageFileInfo);
        g();
        i();
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
                h();
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

    public final void a(int i, boolean z) {
        Fragment b;
        if (this.f != null && (b = this.f.b(1)) != null && (b instanceof ah)) {
            ((ah) b).a(i, z);
        }
    }

    public final void a(ImageFileInfo imageFileInfo, boolean z) {
        Fragment b;
        if (this.f != null && (b = this.f.b(1)) != null && (b instanceof ah)) {
            ((ah) b).a(imageFileInfo, false);
        }
    }

    public final void b(ImageFileInfo imageFileInfo, boolean z) {
        Fragment b;
        if (this.f != null && (b = this.f.b(2)) != null && (b instanceof b)) {
            ((b) b).a(imageFileInfo, false);
        }
    }

    private void h() {
        Intent intent = new Intent();
        String c = this.e.c();
        if (TextUtils.isEmpty(c)) {
            c = "";
        }
        intent.putExtra("last_album_id", c);
        setResult(0, intent);
        finish();
    }

    private void i() {
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
            this.f.e();
        }
        this.i.b();
        q.a().b();
    }
}
