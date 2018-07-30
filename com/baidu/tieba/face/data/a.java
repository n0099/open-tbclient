package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> cVu;
    private int cjR;
    private int coM;

    public int getPage() {
        return this.coM;
    }

    public void setPage(int i) {
        this.coM = i;
    }

    public int apA() {
        return this.cjR;
    }

    public void setHasMore(int i) {
        this.cjR = i;
    }

    public List<EmotionImageData> apB() {
        return this.cVu;
    }

    public void aX(List<EmotionImageData> list) {
        this.cVu = list;
    }
}
