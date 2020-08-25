package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private int gRi;
    private int ghF;
    private List<EmotionImageData> hFa;

    public int getPage() {
        return this.ghF;
    }

    public void setPage(int i) {
        this.ghF = i;
    }

    public int chF() {
        return this.gRi;
    }

    public void setHasMore(int i) {
        this.gRi = i;
    }

    public List<EmotionImageData> chG() {
        return this.hFa;
    }

    public void cp(List<EmotionImageData> list) {
        this.hFa = list;
    }
}
