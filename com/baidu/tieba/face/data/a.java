package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int dSy;
    private int dXz;
    private List<EmotionImageData> eHP;

    public int getPage() {
        return this.dXz;
    }

    public void setPage(int i) {
        this.dXz = i;
    }

    public int aXJ() {
        return this.dSy;
    }

    public void setHasMore(int i) {
        this.dSy = i;
    }

    public List<EmotionImageData> aXK() {
        return this.eHP;
    }

    public void bD(List<EmotionImageData> list) {
        this.eHP = list;
    }
}
