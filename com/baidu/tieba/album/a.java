package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private String albumId;
    private ImageFileInfo aoN;
    private String count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void eR(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String Bg() {
        return this.count;
    }

    public void eS(String str) {
        this.count = str;
    }

    public ImageFileInfo Bh() {
        return this.aoN;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.aoN = imageFileInfo;
    }
}
