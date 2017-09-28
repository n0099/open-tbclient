package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private EmotionGroupType cbT;
    private int cbU;
    private int cbV;
    private int cbW;
    private int cbX;
    private com.baidu.tbadk.editortools.emotiontool.c cbY;
    private int cbZ;
    private int cca;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cbY = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c acn() {
        return this.cbY;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cbT = emotionGroupType;
    }

    public EmotionGroupType aco() {
        return this.cbT;
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

    public int acp() {
        return this.column;
    }

    public void ir(int i) {
        this.cca = i;
    }

    public int acq() {
        return this.cca;
    }

    public void is(int i) {
        this.cbZ = i;
    }

    public int acr() {
        return this.cbZ;
    }

    public void it(int i) {
        this.cbU = i;
    }

    public int acs() {
        return this.cbU;
    }

    public void iu(int i) {
        this.cbW = i;
    }

    public int act() {
        return this.cbW;
    }

    public void setEndIndex(int i) {
        this.cbX = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void iv(int i) {
        this.cbV = i;
    }

    public int acu() {
        return this.cbV;
    }
}
