package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bZk;
    private int hSE;
    private List<EmotionImageData> iMO;

    public int getPage() {
        return this.bZk;
    }

    public void setPage(int i) {
        this.bZk = i;
    }

    public int cwU() {
        return this.hSE;
    }

    public void setHasMore(int i) {
        this.hSE = i;
    }

    public List<EmotionImageData> cwV() {
        return this.iMO;
    }

    public void da(List<EmotionImageData> list) {
        this.iMO = list;
    }
}
