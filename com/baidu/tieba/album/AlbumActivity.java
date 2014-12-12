package com.baidu.tieba.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener {
    private int aan;
    private p aoJ;
    private v aoK;
    private boolean aoL = false;
    private com.baidu.tbadk.img.e aoM;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(AlbumActivityConfig.class, AlbumActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.aoM = new com.baidu.tbadk.img.e(getPageContext().getContext());
            initView();
            initData(bundle);
            AZ();
            Ba();
            Bb();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.aoJ.getWriteImagesInfo().toJsonString());
    }

    private void initData(Bundle bundle) {
        this.aoJ = new p();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.aoJ.setWriteImagesInfo(writeImagesInfo);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.aoJ.setWriteImagesInfo(writeImagesInfo2);
        }
    }

    private void initView() {
        this.aoK = new v(this);
        this.aoK.Bs();
    }

    private void AZ() {
        if (this.aoJ != null && !TextUtils.isEmpty(this.aoJ.getLastAlbumId())) {
            ee(1);
        } else {
            ee(0);
        }
    }

    private void Ba() {
        if (this.aoK != null && this.aoJ != null) {
            this.aoK.ej(this.aoJ.getMaxImagesAllowed());
            if (this.aoJ.Bo() != null) {
                for (ImageFileInfo imageFileInfo : this.aoJ.Bo()) {
                    this.aoK.e(imageFileInfo);
                }
            }
            Bf();
        }
    }

    void Bb() {
        int maxImagesAllowed = this.aoJ.getMaxImagesAllowed();
        int size = this.aoJ.size();
        this.aoK.e(size != 0, getPageContext().getContext().getString(com.baidu.tieba.z.album_finish_btn, Integer.valueOf(size), Integer.valueOf(maxImagesAllowed)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.aoK.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aoK.Bt()) {
            if (this.aan == 0) {
                this.aoJ.setLastAlbumId(null);
            }
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.aoJ.getWriteImagesInfo().toJsonString());
            setResult(-1, intent);
            finish();
        } else if (view == this.aoK.Bu()) {
            if (this.aoJ != null) {
                this.aoJ.setLastAlbumId(null);
            }
            Be();
        } else if (view == this.aoK.Bv()) {
            ee(0);
        } else if (view == this.aoK.Bw()) {
            ee(1);
        } else if (view == this.aoK.Bx()) {
            Be();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p Bc() {
        return this.aoJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.tbadk.img.e Bd() {
        if (this.aoM == null) {
            this.aoM = new com.baidu.tbadk.img.e(getPageContext().getContext());
        }
        return this.aoM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ee(int i) {
        if (!this.aoL) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.aoK.el(this.aan));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.aoM.vT();
            }
            this.aan = i;
            if (this.aoK != null) {
                this.aoK.em(this.aan);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.aoK.el(i)) != null) {
                beginTransaction.show(this.aoK.ek(i));
            } else {
                beginTransaction.add(com.baidu.tieba.w.fragment, this.aoK.ek(i), this.aoK.el(i));
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
        int maxImagesAllowed = this.aoJ.getMaxImagesAllowed();
        if (this.aoJ.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.aoJ.addChooseFile(imageFileInfo2);
            Bb();
            Bf();
            this.aoK.e(imageFileInfo2);
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
        this.aoJ.delChooseFile(imageFileInfo);
        Bb();
        Bf();
        this.aoK.f(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aan == 0) {
                if (this.aoJ != null) {
                    this.aoJ.setLastAlbumId(null);
                }
                Be();
                return true;
            } else if (this.aan == 1) {
                ee(0);
                return true;
            } else if (this.aan == 2) {
                ee(1);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i, boolean z) {
        Fragment ek;
        if (this.aoK != null && (ek = this.aoK.ek(1)) != null && (ek instanceof ah)) {
            ((ah) ek).l(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ek;
        if (this.aoK != null && (ek = this.aoK.ek(1)) != null && (ek instanceof ah)) {
            ((ah) ek).e(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ek;
        if (this.aoK != null && (ek = this.aoK.ek(2)) != null && (ek instanceof b)) {
            ((b) ek).e(imageFileInfo, z);
        }
    }

    private void Be() {
        Intent intent = new Intent();
        String lastAlbumId = this.aoJ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        setResult(0, intent);
        finish();
    }

    private void Bf() {
        if (this.aoJ != null && this.aoK != null) {
            if (this.aoJ.size() == this.aoJ.getMaxImagesAllowed()) {
                this.aoK.bl(false);
            } else {
                this.aoK.bl(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aoL = true;
        if (this.aoK != null) {
            this.aoK.onDestroy();
        }
        this.aoM.vT();
        q.Br().destory();
    }
}
