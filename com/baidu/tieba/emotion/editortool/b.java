package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public class b {
    private int KX;
    private int cuU;
    private EmotionGroupType eVf;
    private int eVg;
    private int eVh;
    private com.baidu.tbadk.editortools.emotiontool.c eVi;
    private int eVj;
    private int eVk;
    private int endIndex;
    private int index;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eVi = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c beQ() {
        return this.eVi;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.eVf = emotionGroupType;
    }

    public EmotionGroupType beR() {
        return this.eVf;
    }

    public void kA(int i) {
        this.cuU = i;
    }

    public int atf() {
        return this.cuU;
    }

    public void kz(int i) {
        this.KX = i;
    }

    public int beS() {
        return this.KX;
    }

    public void qo(int i) {
        this.eVk = i;
    }

    public int beT() {
        return this.eVk;
    }

    public void qp(int i) {
        this.eVj = i;
    }

    public int beU() {
        return this.eVj;
    }

    public void qq(int i) {
        this.eVg = i;
    }

    public int beV() {
        return this.eVg;
    }

    public void qr(int i) {
        this.startIndex = i;
    }

    public int beW() {
        return this.startIndex;
    }

    public void qs(int i) {
        this.endIndex = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void qt(int i) {
        this.eVh = i;
    }

    public int beX() {
        return this.eVh;
    }
}
