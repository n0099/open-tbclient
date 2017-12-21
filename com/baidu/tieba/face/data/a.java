package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bOn;
    private int bSu;
    private List<EmotionImageData> cvC;

    public int getPage() {
        return this.bSu;
    }

    public void setPage(int i) {
        this.bSu = i;
    }

    public int ahL() {
        return this.bOn;
    }

    public void setHasMore(int i) {
        this.bOn = i;
    }

    public List<EmotionImageData> ahM() {
        return this.cvC;
    }

    public void aL(List<EmotionImageData> list) {
        this.cvC = list;
    }
}
