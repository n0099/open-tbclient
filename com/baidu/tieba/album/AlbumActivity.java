package com.baidu.tieba.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener {
    private n apE;
    private t apF;
    private com.baidu.tbadk.img.e apH;
    private int aaL = 0;
    private boolean apG = false;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(AlbumActivityConfig.class, AlbumActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.apH = new com.baidu.tbadk.img.e(getPageContext().getPageActivity());
        initView();
        initData(bundle);
        Bt();
        ek(0);
        Bu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.apE.getWriteImagesInfo().toJsonString());
    }

    private void initData(Bundle bundle) {
        this.apE = new n();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.apE.setWriteImagesInfo(writeImagesInfo);
            this.apE.eV(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.apE.setWriteImagesInfo(writeImagesInfo2);
            this.apE.eV(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
        }
    }

    private void initView() {
        this.apF = new t(this);
        this.apF.BO();
    }

    private void Bt() {
        if (this.apF != null && this.apE != null) {
            this.apF.ep(this.apE.getMaxImagesAllowed());
            if (this.apE.BH() != null) {
                for (ImageFileInfo imageFileInfo : this.apE.BH()) {
                    this.apF.e(imageFileInfo);
                }
            }
            By();
        }
    }

    private void Bu() {
        int size = this.apE.size();
        this.apF.e(size != 0, getPageContext().getPageActivity().getString(com.baidu.tieba.z.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.apF.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.apF.BP()) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.apE.getWriteImagesInfo().toJsonString());
            setResult(-1, intent);
            finish();
        } else if (view == this.apF.BQ()) {
            if (this.apE != null) {
                this.apE.setLastAlbumId(null);
            }
            Bx();
        } else if (view == this.apF.BR()) {
            ek(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n Bv() {
        return this.apE;
    }

    public com.baidu.tbadk.img.e Bw() {
        return this.apH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ek(int i) {
        if (!this.apG) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.apF.er(this.aaL));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.apH.wg();
            }
            this.aaL = i;
            if (this.apF != null) {
                this.apF.es(this.aaL);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.apF.er(i)) != null) {
                beginTransaction.show(this.apF.eq(i));
            } else {
                beginTransaction.add(com.baidu.tieba.w.fragment, this.apF.eq(i), this.apF.er(i));
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
        int maxImagesAllowed = this.apE.getMaxImagesAllowed();
        if (this.apE.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.apE.addChooseFile(imageFileInfo2);
            Bu();
            By();
            this.apF.e(imageFileInfo2);
            return true;
        }
        showToast(String.format(getPageContext().getContext().getString(com.baidu.tieba.z.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.apE.delChooseFile(imageFileInfo);
        Bu();
        By();
        this.apF.f(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aaL == 0) {
                if (this.apE != null) {
                    this.apE.setLastAlbumId(null);
                }
                Bx();
                return true;
            } else if (this.aaL == 1) {
                ek(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i, boolean z) {
        Fragment eq;
        if (this.apF != null && (eq = this.apF.eq(0)) != null && (eq instanceof ah)) {
            ((ah) eq).l(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageFileInfo imageFileInfo, boolean z) {
        Fragment eq;
        if (this.apF != null && (eq = this.apF.eq(0)) != null && (eq instanceof ah)) {
            ((ah) eq).e(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment eq;
        if (this.apF != null && (eq = this.apF.eq(1)) != null && (eq instanceof b)) {
            ((b) eq).e(imageFileInfo, z);
        }
    }

    private void Bx() {
        Intent intent = new Intent();
        String lastAlbumId = this.apE.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        setResult(0, intent);
        finish();
    }

    private void By() {
        if (this.apE != null && this.apF != null) {
            if (this.apE.size() == this.apE.getMaxImagesAllowed()) {
                this.apF.bn(false);
            } else {
                this.apF.bn(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.apE.getWriteImagesInfo().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_RESULT, true);
            intent2.putExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME, this.apE.BM());
            setResult(-1, intent2);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.apG = true;
        if (this.apF != null) {
            this.apF.onDestroy();
        }
        this.apH.wg();
        o.BN().destory();
    }
}
