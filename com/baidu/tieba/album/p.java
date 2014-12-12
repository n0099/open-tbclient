package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private WriteImagesInfo apq;
    private String apr;
    private List<ImageFileInfo> aps;
    private int mCurrentIndex;

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.apq == null) {
            this.apq = new WriteImagesInfo();
        }
        this.apq.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.apq != null) {
            this.apq.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.apq == null) {
            return false;
        }
        return this.apq.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> Bo() {
        if (this.apq != null) {
            return this.apq.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.apq;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.apq = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.apq != null) {
            return this.apq.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.apq == null) {
            this.apq = new WriteImagesInfo();
        }
        this.apq.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.apq != null) {
            return this.apq.getMaxImagesAllowed();
        }
        return 0;
    }

    public String Bp() {
        return this.apr;
    }

    public void eT(String str) {
        this.apr = str;
    }

    public List<ImageFileInfo> Bq() {
        return this.aps;
    }

    public void D(List<ImageFileInfo> list) {
        this.aps = list;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public void setCurrentIndex(int i) {
        this.mCurrentIndex = i;
    }

    public int size() {
        if (this.apq == null) {
            return 0;
        }
        return this.apq.size();
    }
}
