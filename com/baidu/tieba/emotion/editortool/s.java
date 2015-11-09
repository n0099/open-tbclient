package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class s {
    private EmotionGroupType aKY;
    private int aKZ;
    private int aLa;
    private int aLb;
    private int aLc;
    private com.baidu.tbadk.editortools.emotiontool.c aLd;
    private int aLe;
    private int aLf;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aLd = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c HS() {
        return this.aLd;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.aKY = emotionGroupType;
    }

    public EmotionGroupType HT() {
        return this.aKY;
    }

    public void eh(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eg(int i) {
        this.column = i;
    }

    public int HU() {
        return this.column;
    }

    public void eX(int i) {
        this.aLf = i;
    }

    public int HV() {
        return this.aLf;
    }

    public void eY(int i) {
        this.aLe = i;
    }

    public int HW() {
        return this.aLe;
    }

    public void eZ(int i) {
        this.aKZ = i;
    }

    public int HX() {
        return this.aKZ;
    }

    public void fa(int i) {
        this.aLb = i;
    }

    public int HY() {
        return this.aLb;
    }

    public void setEndIndex(int i) {
        this.aLc = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void fb(int i) {
        this.aLa = i;
    }

    public int HZ() {
        return this.aLa;
    }
}
