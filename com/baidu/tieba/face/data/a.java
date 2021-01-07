package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cea;
    private int hXl;
    private List<EmotionImageData> iRv;

    public int getPage() {
        return this.cea;
    }

    public void setPage(int i) {
        this.cea = i;
    }

    public int cAM() {
        return this.hXl;
    }

    public void setHasMore(int i) {
        this.hXl = i;
    }

    public List<EmotionImageData> cAN() {
        return this.iRv;
    }

    public void da(List<EmotionImageData> list) {
        this.iRv = list;
    }
}
