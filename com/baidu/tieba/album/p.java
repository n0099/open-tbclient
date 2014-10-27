package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private int RK;
    private WriteImagesInfo ahS;
    private String ahT;
    private List<ImageFileInfo> ahU;

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.ahS == null) {
            this.ahS = new WriteImagesInfo();
        }
        this.ahS.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.ahS != null) {
            this.ahS.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.ahS == null) {
            return false;
        }
        return this.ahS.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> xT() {
        if (this.ahS != null) {
            return this.ahS.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.ahS;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.ahS = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.ahS != null) {
            return this.ahS.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.ahS == null) {
            this.ahS = new WriteImagesInfo();
        }
        this.ahS.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.ahS != null) {
            return this.ahS.getMaxImagesAllowed();
        }
        return 0;
    }

    public String xU() {
        return this.ahT;
    }

    public void eo(String str) {
        this.ahT = str;
    }

    public List<ImageFileInfo> xV() {
        return this.ahU;
    }

    public void y(List<ImageFileInfo> list) {
        this.ahU = list;
    }

    public int getCurrentIndex() {
        return this.RK;
    }

    public void dP(int i) {
        this.RK = i;
    }

    public int size() {
        if (this.ahS == null) {
            return 0;
        }
        return this.ahS.size();
    }
}
