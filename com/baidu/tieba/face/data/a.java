package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int dRL;
    private int dWT;
    private List<EmotionImageData> eHx;

    public int getPage() {
        return this.dWT;
    }

    public void setPage(int i) {
        this.dWT = i;
    }

    public int aXG() {
        return this.dRL;
    }

    public void setHasMore(int i) {
        this.dRL = i;
    }

    public List<EmotionImageData> aXH() {
        return this.eHx;
    }

    public void bB(List<EmotionImageData> list) {
        this.eHx = list;
    }
}
