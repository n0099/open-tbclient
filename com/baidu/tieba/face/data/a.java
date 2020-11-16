package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int gQs;
    private int hBs;
    private List<EmotionImageData> iup;

    public int getPage() {
        return this.gQs;
    }

    public void setPage(int i) {
        this.gQs = i;
    }

    public int ctC() {
        return this.hBs;
    }

    public void setHasMore(int i) {
        this.hBs = i;
    }

    public List<EmotionImageData> ctD() {
        return this.iup;
    }

    public void cP(List<EmotionImageData> list) {
        this.iup = list;
    }
}
