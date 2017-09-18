package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bBs;
    private int byh;
    private List<EmotionImageData> cfg;

    public int getPage() {
        return this.bBs;
    }

    public void setPage(int i) {
        this.bBs = i;
    }

    public int adW() {
        return this.byh;
    }

    public void setHasMore(int i) {
        this.byh = i;
    }

    public List<EmotionImageData> adX() {
        return this.cfg;
    }

    public void ay(List<EmotionImageData> list) {
        this.cfg = list;
    }
}
