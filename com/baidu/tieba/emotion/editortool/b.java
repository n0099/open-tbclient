package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class b {
    private EmotionGroupType cQO;
    private int cQP;
    private int cQQ;
    private com.baidu.tbadk.editortools.emotiontool.c cQR;
    private int cQS;
    private int cQT;
    private int column;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cQR = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aoj() {
        return this.cQR;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cQO = emotionGroupType;
    }

    public EmotionGroupType aok() {
        return this.cQO;
    }

    public void eW(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eV(int i) {
        this.column = i;
    }

    public int aol() {
        return this.column;
    }

    public void js(int i) {
        this.cQT = i;
    }

    public int aom() {
        return this.cQT;
    }

    public void jt(int i) {
        this.cQS = i;
    }

    public int aon() {
        return this.cQS;
    }

    public void ju(int i) {
        this.cQP = i;
    }

    public int aoo() {
        return this.cQP;
    }

    public void jv(int i) {
        this.startIndex = i;
    }

    public int aop() {
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

    public void jw(int i) {
        this.cQQ = i;
    }

    public int aoq() {
        return this.cQQ;
    }
}
