package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int fXj;
    private int fqU;
    private List<EmotionImageData> gKJ;

    public int getPage() {
        return this.fqU;
    }

    public void setPage(int i) {
        this.fqU = i;
    }

    public int bKx() {
        return this.fXj;
    }

    public void setHasMore(int i) {
        this.fXj = i;
    }

    public List<EmotionImageData> bKy() {
        return this.gKJ;
    }

    public void cc(List<EmotionImageData> list) {
        this.gKJ = list;
    }
}
