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

    public com.baidu.tbadk.editortools.emotiontool.c acA() {
        return this.cbY;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cbT = emotionGroupType;
    }

    public EmotionGroupType acB() {
        return this.cbT;
    }

    public void eR(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eQ(int i) {
        this.column = i;
    }

    public int acC() {
        return this.column;
    }

    public void ij(int i) {
        this.cca = i;
    }

    public int acD() {
        return this.cca;
    }

    public void ik(int i) {
        this.cbZ = i;
    }

    public int acE() {
        return this.cbZ;
    }

    public void il(int i) {
        this.cbU = i;
    }

    public int acF() {
        return this.cbU;
    }

    public void im(int i) {
        this.cbW = i;
    }

    public int acG() {
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

    public void in(int i) {
        this.cbV = i;
    }

    public int acH() {
        return this.cbV;
    }
}
