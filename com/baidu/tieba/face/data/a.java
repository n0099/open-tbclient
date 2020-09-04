package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int gRm;
    private int ghJ;
    private List<EmotionImageData> hFg;

    public int getPage() {
        return this.ghJ;
    }

    public void setPage(int i) {
        this.ghJ = i;
    }

    public int chG() {
        return this.gRm;
    }

    public void setHasMore(int i) {
        this.gRm = i;
    }

    public List<EmotionImageData> chH() {
        return this.hFg;
    }

    public void cp(List<EmotionImageData> list) {
        this.hFg = list;
    }
}
