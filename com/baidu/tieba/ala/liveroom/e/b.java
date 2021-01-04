package com.baidu.tieba.ala.liveroom.e;
/* loaded from: classes11.dex */
public class b {
    private int imageId;
    private String imageUrl;
    private String scheme;
    private String title;
    private int titleId;

    public String getScheme() {
        return this.scheme;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public int getImageId() {
        return this.imageId;
    }

    public void setImageId(int i) {
        this.imageId = i;
    }

    public int cfn() {
        return this.titleId;
    }

    public void wM(int i) {
        this.titleId = i;
    }

    public void reset() {
        this.scheme = null;
        this.title = null;
        this.imageUrl = null;
        this.imageId = 0;
        this.titleId = 0;
    }
}
