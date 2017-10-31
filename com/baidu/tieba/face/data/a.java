package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bFS;
    private int bKb;
    private List<EmotionImageData> cmi;

    public int getPage() {
        return this.bKb;
    }

    public void setPage(int i) {
        this.bKb = i;
    }

    public int afF() {
        return this.bFS;
    }

    public void setHasMore(int i) {
        this.bFS = i;
    }

    public List<EmotionImageData> afG() {
        return this.cmi;
    }

    public void az(List<EmotionImageData> list) {
        this.cmi = list;
    }
}
