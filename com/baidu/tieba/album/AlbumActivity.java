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
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener {
    private int Ue;
    private p ahk;
    private v ahl;
    private boolean ahm = false;
    private com.baidu.tbadk.img.e ahn;

    static {
        TbadkApplication.m251getInst().RegisterIntent(AlbumActivityConfig.class, AlbumActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.ahn = new com.baidu.tbadk.img.e(this);
            nu();
            d(bundle);
            xE();
            xF();
            xG();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.ahk.getWriteImagesInfo().toJsonString());
    }

    private void d(Bundle bundle) {
        this.ahk = new p();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.ahk.setWriteImagesInfo(writeImagesInfo);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.ahk.setWriteImagesInfo(writeImagesInfo2);
        }
    }

    private void nu() {
        this.ahl = new v(this);
        this.ahl.xZ();
    }

    private void xE() {
        if (this.ahk != null && !TextUtils.isEmpty(this.ahk.getLastAlbumId())) {
            dK(1);
        } else {
            dK(0);
        }
    }

    private void xF() {
        if (this.ahl != null && this.ahk != null) {
            this.ahl.dQ(this.ahk.getMaxImagesAllowed());
            if (this.ahk.xT() != null) {
                for (ImageFileInfo imageFileInfo : this.ahk.xT()) {
                    this.ahl.e(imageFileInfo);
                }
            }
            xK();
        }
    }

    void xG() {
        int maxImagesAllowed = this.ahk.getMaxImagesAllowed();
        int size = this.ahk.size();
        this.ahl.b(size != 0, getString(com.baidu.tieba.y.album_finish_btn, new Object[]{Integer.valueOf(size), Integer.valueOf(maxImagesAllowed)}));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.ahl.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ahl.ya()) {
            if (this.Ue == 0) {
                this.ahk.setLastAlbumId(null);
            }
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.ahk.getWriteImagesInfo().toJsonString());
            setResult(-1, intent);
            finish();
        } else if (view == this.ahl.yb()) {
            if (this.ahk != null) {
                this.ahk.setLastAlbumId(null);
            }
            xJ();
        } else if (view == this.ahl.yc()) {
            dK(0);
        } else if (view == this.ahl.yd()) {
            dK(1);
        } else if (view == this.ahl.ye()) {
            xJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p xH() {
        return this.ahk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.tbadk.img.e xI() {
        if (this.ahn == null) {
            this.ahn = new com.baidu.tbadk.img.e(this);
        }
        return this.ahn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dK(int i) {
        if (!this.ahm) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.ahl.dS(this.Ue));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.ahn.so();
            }
            this.Ue = i;
            if (this.ahl != null) {
                this.ahl.dT(this.Ue);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.ahl.dS(i)) != null) {
                beginTransaction.show(this.ahl.dR(i));
            } else {
                beginTransaction.add(com.baidu.tieba.v.fragment, this.ahl.dR(i), this.ahl.dS(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.ahk.getMaxImagesAllowed();
        if (this.ahk.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.ahk.addChooseFile(imageFileInfo2);
            xG();
            xK();
            this.ahl.e(imageFileInfo2);
            return true;
        }
        showToast(String.format(getString(com.baidu.tieba.y.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.ahk.delChooseFile(imageFileInfo);
        xG();
        xK();
        this.ahl.f(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.Ue == 0) {
                if (this.ahk != null) {
                    this.ahk.setLastAlbumId(null);
                }
                xJ();
                return true;
            } else if (this.Ue == 1) {
                dK(0);
                return true;
            } else if (this.Ue == 2) {
                dK(1);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i, boolean z) {
        Fragment dR;
        if (this.ahl != null && (dR = this.ahl.dR(1)) != null && (dR instanceof ah)) {
            ((ah) dR).l(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageFileInfo imageFileInfo, boolean z) {
        Fragment dR;
        if (this.ahl != null && (dR = this.ahl.dR(1)) != null && (dR instanceof ah)) {
            ((ah) dR).e(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment dR;
        if (this.ahl != null && (dR = this.ahl.dR(2)) != null && (dR instanceof b)) {
            ((b) dR).e(imageFileInfo, z);
        }
    }

    private void xJ() {
        Intent intent = new Intent();
        String lastAlbumId = this.ahk.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        setResult(0, intent);
        finish();
    }

    private void xK() {
        if (this.ahk != null && this.ahl != null) {
            if (this.ahk.size() == this.ahk.getMaxImagesAllowed()) {
                this.ahl.bm(false);
            } else {
                this.ahl.bm(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ahm = true;
        if (this.ahl != null) {
            this.ahl.onDestroy();
        }
        this.ahn.so();
        q.xW().xY();
    }
}
