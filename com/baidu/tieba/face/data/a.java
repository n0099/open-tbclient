package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> cVq;
    private int cjO;
    private int coJ;

    public int getPage() {
        return this.coJ;
    }

    public void setPage(int i) {
        this.coJ = i;
    }

    public int apA() {
        return this.cjO;
    }

    public void setHasMore(int i) {
        this.cjO = i;
    }

    public List<EmotionImageData> apB() {
        return this.cVq;
    }

    public void aX(List<EmotionImageData> list) {
        this.cVq = list;
    }
}
