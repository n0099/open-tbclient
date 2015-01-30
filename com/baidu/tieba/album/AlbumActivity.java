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
    private n apH;
    private t apI;
    private com.baidu.tbadk.img.e apK;
    private int aaO = 0;
    private boolean apJ = false;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(AlbumActivityConfig.class, AlbumActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.apK = new com.baidu.tbadk.img.e(getPageContext().getPageActivity());
        initView();
        initData(bundle);
        Bz();
        ek(0);
        BA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.apH.getWriteImagesInfo().toJsonString());
    }

    private void initData(Bundle bundle) {
        this.apH = new n();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.apH.setWriteImagesInfo(writeImagesInfo);
            this.apH.eY(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.apH.setWriteImagesInfo(writeImagesInfo2);
            this.apH.eY(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
        }
    }

    private void initView() {
        this.apI = new t(this);
        this.apI.BU();
    }

    private void Bz() {
        if (this.apI != null && this.apH != null) {
            this.apI.ep(this.apH.getMaxImagesAllowed());
            if (this.apH.BN() != null) {
                for (ImageFileInfo imageFileInfo : this.apH.BN()) {
                    this.apI.e(imageFileInfo);
                }
            }
            BE();
        }
    }

    private void BA() {
        int size = this.apH.size();
        this.apI.e(size != 0, getPageContext().getPageActivity().getString(com.baidu.tieba.z.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.apI.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.apI.BV()) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.apH.getWriteImagesInfo().toJsonString());
            setResult(-1, intent);
            finish();
        } else if (view == this.apI.BW()) {
            if (this.apH != null) {
                this.apH.setLastAlbumId(null);
            }
            BD();
        } else if (view == this.apI.BX()) {
            ek(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n BB() {
        return this.apH;
    }

    public com.baidu.tbadk.img.e BC() {
        return this.apK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ek(int i) {
        if (!this.apJ) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.apI.er(this.aaO));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.apK.wm();
            }
            this.aaO = i;
            if (this.apI != null) {
                this.apI.es(this.aaO);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.apI.er(i)) != null) {
                beginTransaction.show(this.apI.eq(i));
            } else {
                beginTransaction.add(com.baidu.tieba.w.fragment, this.apI.eq(i), this.apI.er(i));
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
        int maxImagesAllowed = this.apH.getMaxImagesAllowed();
        if (this.apH.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.apH.addChooseFile(imageFileInfo2);
            BA();
            BE();
            this.apI.e(imageFileInfo2);
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
        this.apH.delChooseFile(imageFileInfo);
        BA();
        BE();
        this.apI.f(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aaO == 0) {
                if (this.apH != null) {
                    this.apH.setLastAlbumId(null);
                }
                BD();
                return true;
            } else if (this.aaO == 1) {
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
        if (this.apI != null && (eq = this.apI.eq(0)) != null && (eq instanceof ah)) {
            ((ah) eq).l(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageFileInfo imageFileInfo, boolean z) {
        Fragment eq;
        if (this.apI != null && (eq = this.apI.eq(0)) != null && (eq instanceof ah)) {
            ((ah) eq).e(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment eq;
        if (this.apI != null && (eq = this.apI.eq(1)) != null && (eq instanceof b)) {
            ((b) eq).e(imageFileInfo, z);
        }
    }

    private void BD() {
        Intent intent = new Intent();
        String lastAlbumId = this.apH.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        setResult(0, intent);
        finish();
    }

    private void BE() {
        if (this.apH != null && this.apI != null) {
            if (this.apH.size() == this.apH.getMaxImagesAllowed()) {
                this.apI.bn(false);
            } else {
                this.apI.bn(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.apH.getWriteImagesInfo().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_RESULT, true);
            intent2.putExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME, this.apH.BS());
            setResult(-1, intent2);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.apJ = true;
        if (this.apI != null) {
            this.apI.onDestroy();
        }
        this.apK.wm();
        o.BT().destory();
    }
}
