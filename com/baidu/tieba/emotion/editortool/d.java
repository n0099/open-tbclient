package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private int column;
    private EmotionGroupType csp;
    private int csq;
    private int csr;
    private com.baidu.tbadk.editortools.emotiontool.c css;
    private int cst;
    private int csu;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.css = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c agx() {
        return this.css;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.csp = emotionGroupType;
    }

    public EmotionGroupType agy() {
        return this.csp;
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
        this.csu = i;
    }

    public int agA() {
        return this.csu;
    }

    public void ji(int i) {
        this.cst = i;
    }

    public int agB() {
        return this.cst;
    }

    public void jj(int i) {
        this.csq = i;
    }

    public int agC() {
        return this.csq;
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
        this.csr = i;
    }

    public int agE() {
        return this.csr;
    }
}
