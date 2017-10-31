package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private EmotionGroupType cjm;
    private int cjn;
    private int cjo;
    private com.baidu.tbadk.editortools.emotiontool.c cjp;
    private int cjq;
    private int cjr;
    private int column;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cjp = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aes() {
        return this.cjp;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cjm = emotionGroupType;
    }

    public EmotionGroupType aet() {
        return this.cjm;
    }

    public void fc(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fb(int i) {
        this.column = i;
    }

    public int aeu() {
        return this.column;
    }

    public void iJ(int i) {
        this.cjr = i;
    }

    public int aev() {
        return this.cjr;
    }

    public void iK(int i) {
        this.cjq = i;
    }

    public int aew() {
        return this.cjq;
    }

    public void iL(int i) {
        this.cjn = i;
    }

    public int aex() {
        return this.cjn;
    }

    public void iM(int i) {
        this.startIndex = i;
    }

    public int aey() {
        return this.startIndex;
    }

    public void setEndIndex(int i) {
        this.endIndex = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void iN(int i) {
        this.cjo = i;
    }

    public int aez() {
        return this.cjo;
    }
}
