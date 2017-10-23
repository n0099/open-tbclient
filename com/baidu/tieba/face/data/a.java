package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bCR;
    private int bzE;
    private List<EmotionImageData> ceO;

    public int getPage() {
        return this.bCR;
    }

    public void setPage(int i) {
        this.bCR = i;
    }

    public int ady() {
        return this.bzE;
    }

    public void setHasMore(int i) {
        this.bzE = i;
    }

    public List<EmotionImageData> adz() {
        return this.ceO;
    }

    public void ax(List<EmotionImageData> list) {
        this.ceO = list;
    }
}
