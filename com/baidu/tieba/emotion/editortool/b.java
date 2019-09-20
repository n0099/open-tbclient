package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public class b {
    private int KX;
    private int cvQ;
    private EmotionGroupType eWL;
    private int eWM;
    private int eWN;
    private com.baidu.tbadk.editortools.emotiontool.c eWO;
    private int eWP;
    private int eWQ;
    private int endIndex;
    private int index;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eWO = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bfu() {
        return this.eWO;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.eWL = emotionGroupType;
    }

    public EmotionGroupType bfv() {
        return this.eWL;
    }

    public void kD(int i) {
        this.cvQ = i;
    }

    public int atr() {
        return this.cvQ;
    }

    public void kC(int i) {
        this.KX = i;
    }

    public int bfw() {
        return this.KX;
    }

    public void qr(int i) {
        this.eWQ = i;
    }

    public int bfx() {
        return this.eWQ;
    }

    public void qs(int i) {
        this.eWP = i;
    }

    public int bfy() {
        return this.eWP;
    }

    public void qt(int i) {
        this.eWM = i;
    }

    public int bfz() {
        return this.eWM;
    }

    public void qu(int i) {
        this.startIndex = i;
    }

    public int bfA() {
        return this.startIndex;
    }

    public void qv(int i) {
        this.endIndex = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void qw(int i) {
        this.eWN = i;
    }

    public int bfB() {
        return this.eWN;
    }
}
