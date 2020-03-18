package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int eMC;
    private int fsO;
    private List<EmotionImageData> gbA;

    public int getPage() {
        return this.eMC;
    }

    public void setPage(int i) {
        this.eMC = i;
    }

    public int bzW() {
        return this.fsO;
    }

    public void setHasMore(int i) {
        this.fsO = i;
    }

    public List<EmotionImageData> bzX() {
        return this.gbA;
    }

    public void bQ(List<EmotionImageData> list) {
        this.gbA = list;
    }
}
