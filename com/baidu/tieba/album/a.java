package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private String albumId;
    private ImageFileInfo apI;
    private String count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void eQ(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String Bz() {
        return this.count;
    }

    public void eR(String str) {
        this.count = str;
    }

    public ImageFileInfo BA() {
        return this.apI;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.apI = imageFileInfo;
    }
}
