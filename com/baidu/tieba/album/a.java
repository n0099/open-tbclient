package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private String albumId;
    private ImageFileInfo apL;
    private String count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void eT(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String BF() {
        return this.count;
    }

    public void eU(String str) {
        this.count = str;
    }

    public ImageFileInfo BG() {
        return this.apL;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.apL = imageFileInfo;
    }
}
