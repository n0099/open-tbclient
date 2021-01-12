package com.baidu.tieba.ala.alaar.sticker.model;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdFileHelper;
import java.io.File;
/* loaded from: classes10.dex */
public class DuFileFaceItem extends FuFaceItem {
    @Override // com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem
    public String getFilePath() {
        String filePath;
        if (TextUtils.isEmpty(this.file) && this.mSticker.getFile() == null) {
            return "none";
        }
        String path = this.mSticker.getPath();
        if (TextUtils.isEmpty(path)) {
            if (this.file.endsWith(".zip")) {
                filePath = this.file.substring(0, this.file.length() - 4);
            } else {
                filePath = super.getFilePath();
            }
            if (filePath != null) {
                this.mSticker.setFile(new File(filePath));
                return filePath;
            }
            return filePath;
        }
        return path;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem
    public String getLoadingFile() {
        if (TextUtils.isEmpty(this.mLoadingFile)) {
            this.mLoadingFile = this.file;
        }
        return this.mLoadingFile;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem
    public boolean isResLoaded() {
        return this.mResLoaded;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem
    protected void checkResFile() {
        this.mResLoaded = "none".equals(getFilePath()) || BdFileHelper.checkFile(getFilePath());
    }
}
