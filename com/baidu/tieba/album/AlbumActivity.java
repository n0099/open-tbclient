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
    private int Ui;
    private p aht;
    private v ahu;
    private boolean ahv = false;
    private com.baidu.tbadk.img.e ahw;

    static {
        TbadkApplication.m251getInst().RegisterIntent(AlbumActivityConfig.class, AlbumActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.ahw = new com.baidu.tbadk.img.e(this);
            nu();
            d(bundle);
            xG();
            xH();
            xI();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.aht.getWriteImagesInfo().toJsonString());
    }

    private void d(Bundle bundle) {
        this.aht = new p();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.aht.setWriteImagesInfo(writeImagesInfo);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.aht.setWriteImagesInfo(writeImagesInfo2);
        }
    }

    private void nu() {
        this.ahu = new v(this);
        this.ahu.yb();
    }

    private void xG() {
        if (this.aht != null && !TextUtils.isEmpty(this.aht.getLastAlbumId())) {
            dK(1);
        } else {
            dK(0);
        }
    }

    private void xH() {
        if (this.ahu != null && this.aht != null) {
            this.ahu.dQ(this.aht.getMaxImagesAllowed());
            if (this.aht.xV() != null) {
                for (ImageFileInfo imageFileInfo : this.aht.xV()) {
                    this.ahu.e(imageFileInfo);
                }
            }
            xM();
        }
    }

    void xI() {
        int maxImagesAllowed = this.aht.getMaxImagesAllowed();
        int size = this.aht.size();
        this.ahu.b(size != 0, getString(com.baidu.tieba.y.album_finish_btn, new Object[]{Integer.valueOf(size), Integer.valueOf(maxImagesAllowed)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.ahu.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ahu.yc()) {
            if (this.Ui == 0) {
                this.aht.setLastAlbumId(null);
            }
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.aht.getWriteImagesInfo().toJsonString());
            setResult(-1, intent);
            finish();
        } else if (view == this.ahu.yd()) {
            if (this.aht != null) {
                this.aht.setLastAlbumId(null);
            }
            xL();
        } else if (view == this.ahu.ye()) {
            dK(0);
        } else if (view == this.ahu.yf()) {
            dK(1);
        } else if (view == this.ahu.yg()) {
            xL();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p xJ() {
        return this.aht;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.tbadk.img.e xK() {
        if (this.ahw == null) {
            this.ahw = new com.baidu.tbadk.img.e(this);
        }
        return this.ahw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dK(int i) {
        if (!this.ahv) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.ahu.dS(this.Ui));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.ahw.sq();
            }
            this.Ui = i;
            if (this.ahu != null) {
                this.ahu.dT(this.Ui);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.ahu.dS(i)) != null) {
                beginTransaction.show(this.ahu.dR(i));
            } else {
                beginTransaction.add(com.baidu.tieba.v.fragment, this.ahu.dR(i), this.ahu.dS(i));
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
        int maxImagesAllowed = this.aht.getMaxImagesAllowed();
        if (this.aht.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.aht.addChooseFile(imageFileInfo2);
            xI();
            xM();
            this.ahu.e(imageFileInfo2);
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
        this.aht.delChooseFile(imageFileInfo);
        xI();
        xM();
        this.ahu.f(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.Ui == 0) {
                if (this.aht != null) {
                    this.aht.setLastAlbumId(null);
                }
                xL();
                return true;
            } else if (this.Ui == 1) {
                dK(0);
                return true;
            } else if (this.Ui == 2) {
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
        if (this.ahu != null && (dR = this.ahu.dR(1)) != null && (dR instanceof ah)) {
            ((ah) dR).l(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageFileInfo imageFileInfo, boolean z) {
        Fragment dR;
        if (this.ahu != null && (dR = this.ahu.dR(1)) != null && (dR instanceof ah)) {
            ((ah) dR).e(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment dR;
        if (this.ahu != null && (dR = this.ahu.dR(2)) != null && (dR instanceof b)) {
            ((b) dR).e(imageFileInfo, z);
        }
    }

    private void xL() {
        Intent intent = new Intent();
        String lastAlbumId = this.aht.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        setResult(0, intent);
        finish();
    }

    private void xM() {
        if (this.aht != null && this.ahu != null) {
            if (this.aht.size() == this.aht.getMaxImagesAllowed()) {
                this.ahu.bm(false);
            } else {
                this.ahu.bm(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ahv = true;
        if (this.ahu != null) {
            this.ahu.onDestroy();
        }
        this.ahw.sq();
        q.xY().ya();
    }
}
