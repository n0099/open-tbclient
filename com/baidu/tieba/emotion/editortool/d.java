package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private int column;
    private EmotionGroupType cst;
    private int csu;
    private int csv;
    private com.baidu.tbadk.editortools.emotiontool.c csw;
    private int csx;
    private int csy;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.csw = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c agx() {
        return this.csw;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cst = emotionGroupType;
    }

    public EmotionGroupType agy() {
        return this.cst;
    }

    public void fa(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eZ(int i) {
        this.column = i;
    }

    public int agz() {
        return this.column;
    }

    public void jh(int i) {
        this.csy = i;
    }

    public int agA() {
        return this.csy;
    }

    public void ji(int i) {
        this.csx = i;
    }

    public int agB() {
        return this.csx;
    }

    public void jj(int i) {
        this.csu = i;
    }

    public int agC() {
        return this.csu;
    }

    public void jk(int i) {
        this.startIndex = i;
    }

    public int agD() {
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

    public void jl(int i) {
        this.csv = i;
    }

    public int agE() {
        return this.csv;
    }
}
