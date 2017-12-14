package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bOj;
    private int bSq;
    private List<EmotionImageData> cvy;

    public int getPage() {
        return this.bSq;
    }

    public void setPage(int i) {
        this.bSq = i;
    }

    public int ahM() {
        return this.bOj;
    }

    public void setHasMore(int i) {
        this.bOj = i;
    }

    public List<EmotionImageData> ahN() {
        return this.cvy;
    }

    public void aL(List<EmotionImageData> list) {
        this.cvy = list;
    }
}
