package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int gzl;
    private int hjS;
    private List<EmotionImageData> ibc;

    public int getPage() {
        return this.gzl;
    }

    public void setPage(int i) {
        this.gzl = i;
    }

    public int cor() {
        return this.hjS;
    }

    public void setHasMore(int i) {
        this.hjS = i;
    }

    public List<EmotionImageData> cos() {
        return this.ibc;
    }

    public void cy(List<EmotionImageData> list) {
        this.ibc = list;
    }
}
