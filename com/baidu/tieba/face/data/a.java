package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int eLS;
    private int fsb;
    private List<EmotionImageData> gaD;

    public int getPage() {
        return this.eLS;
    }

    public void setPage(int i) {
        this.eLS = i;
    }

    public int bzN() {
        return this.fsb;
    }

    public void setHasMore(int i) {
        this.fsb = i;
    }

    public List<EmotionImageData> bzO() {
        return this.gaD;
    }

    public void bQ(List<EmotionImageData> list) {
        this.gaD = list;
    }
}
