package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int dRh;
    private int euS;
    private List<EmotionImageData> fgP;

    public int getPage() {
        return this.dRh;
    }

    public void setPage(int i) {
        this.dRh = i;
    }

    public int bfO() {
        return this.euS;
    }

    public void setHasMore(int i) {
        this.euS = i;
    }

    public List<EmotionImageData> bfP() {
        return this.fgP;
    }

    public void bY(List<EmotionImageData> list) {
        this.fgP = list;
    }
}
