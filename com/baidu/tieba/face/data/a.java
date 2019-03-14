package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int dSu;
    private int dXv;
    private List<EmotionImageData> eHL;

    public int getPage() {
        return this.dXv;
    }

    public void setPage(int i) {
        this.dXv = i;
    }

    public int aXJ() {
        return this.dSu;
    }

    public void setHasMore(int i) {
        this.dSu = i;
    }

    public List<EmotionImageData> aXK() {
        return this.eHL;
    }

    public void bD(List<EmotionImageData> list) {
        this.eHL = list;
    }
}
