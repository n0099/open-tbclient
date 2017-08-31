package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bAB;
    private int bxs;
    private List<EmotionImageData> ceo;

    public int getPage() {
        return this.bAB;
    }

    public void setPage(int i) {
        this.bAB = i;
    }

    public int adL() {
        return this.bxs;
    }

    public void setHasMore(int i) {
        this.bxs = i;
    }

    public List<EmotionImageData> adM() {
        return this.ceo;
    }

    public void ay(List<EmotionImageData> list) {
        this.ceo = list;
    }
}
