package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int eHY;
    private List<EmotionImageData> fYD;
    private int fpy;

    public int getPage() {
        return this.eHY;
    }

    public void setPage(int i) {
        this.eHY = i;
    }

    public int byl() {
        return this.fpy;
    }

    public void setHasMore(int i) {
        this.fpy = i;
    }

    public List<EmotionImageData> bym() {
        return this.fYD;
    }

    public void bU(List<EmotionImageData> list) {
        this.fYD = list;
    }
}
