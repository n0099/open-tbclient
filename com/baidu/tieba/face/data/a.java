package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int egI;
    private int elY;
    private List<EmotionImageData> fcJ;

    public int getPage() {
        return this.elY;
    }

    public void setPage(int i) {
        this.elY = i;
    }

    public int bhg() {
        return this.egI;
    }

    public void setHasMore(int i) {
        this.egI = i;
    }

    public List<EmotionImageData> bhh() {
        return this.fcJ;
    }

    public void bL(List<EmotionImageData> list) {
        this.fcJ = list;
    }
}
