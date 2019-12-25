package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int eGO;
    private List<EmotionImageData> fVu;
    private int fmo;

    public int getPage() {
        return this.eGO;
    }

    public void setPage(int i) {
        this.eGO = i;
    }

    public int bxj() {
        return this.fmo;
    }

    public void setHasMore(int i) {
        this.fmo = i;
    }

    public List<EmotionImageData> bxk() {
        return this.fVu;
    }

    public void bU(List<EmotionImageData> list) {
        this.fVu = list;
    }
}
