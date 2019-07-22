package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public class b {
    private int KX;
    private int cuN;
    private EmotionGroupType eUY;
    private int eUZ;
    private int eVa;
    private com.baidu.tbadk.editortools.emotiontool.c eVb;
    private int eVc;
    private int eVd;
    private int endIndex;
    private int index;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eVb = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c beO() {
        return this.eVb;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.eUY = emotionGroupType;
    }

    public EmotionGroupType beP() {
        return this.eUY;
    }

    public void kz(int i) {
        this.cuN = i;
    }

    public int atd() {
        return this.cuN;
    }

    public void ky(int i) {
        this.KX = i;
    }

    public int beQ() {
        return this.KX;
    }

    public void qn(int i) {
        this.eVd = i;
    }

    public int beR() {
        return this.eVd;
    }

    public void qo(int i) {
        this.eVc = i;
    }

    public int beS() {
        return this.eVc;
    }

    public void qp(int i) {
        this.eUZ = i;
    }

    public int beT() {
        return this.eUZ;
    }

    public void qq(int i) {
        this.startIndex = i;
    }

    public int beU() {
        return this.startIndex;
    }

    public void qr(int i) {
        this.endIndex = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void qs(int i) {
        this.eVa = i;
    }

    public int beV() {
        return this.eVa;
    }
}
