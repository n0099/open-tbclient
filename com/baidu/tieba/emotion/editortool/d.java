package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private int cjA;
    private int cjB;
    private com.baidu.tbadk.editortools.emotiontool.c cjC;
    private int cjD;
    private int cjE;
    private EmotionGroupType cjz;
    private int column;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cjC = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aeE() {
        return this.cjC;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cjz = emotionGroupType;
    }

    public EmotionGroupType aeF() {
        return this.cjz;
    }

    public void fb(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fa(int i) {
        this.column = i;
    }

    public int aeG() {
        return this.column;
    }

    public void iH(int i) {
        this.cjE = i;
    }

    public int aeH() {
        return this.cjE;
    }

    public void iI(int i) {
        this.cjD = i;
    }

    public int aeI() {
        return this.cjD;
    }

    public void iJ(int i) {
        this.cjA = i;
    }

    public int aeJ() {
        return this.cjA;
    }

    public void iK(int i) {
        this.startIndex = i;
    }

    public int aeK() {
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

    public void iL(int i) {
        this.cjB = i;
    }

    public int aeL() {
        return this.cjB;
    }
}
