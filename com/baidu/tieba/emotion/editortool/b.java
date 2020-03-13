package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes6.dex */
public class b {
    private int aDE;
    private int aDF;
    private int column;
    private EmotionGroupType fTh;
    private int fTi;
    private int fTj;
    private com.baidu.tbadk.editortools.emotiontool.c fTk;
    private int fTl;
    private int fTm;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fTk = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bxr() {
        return this.fTk;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.fTh = emotionGroupType;
    }

    public EmotionGroupType bxs() {
        return this.fTh;
    }

    public void mz(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void my(int i) {
        this.column = i;
    }

    public int bxt() {
        return this.column;
    }

    public void rE(int i) {
        this.fTm = i;
    }

    public int bxu() {
        return this.fTm;
    }

    public void rF(int i) {
        this.fTl = i;
    }

    public int bxv() {
        return this.fTl;
    }

    public void rG(int i) {
        this.fTi = i;
    }

    public int bxw() {
        return this.fTi;
    }

    public void rH(int i) {
        this.aDE = i;
    }

    public int bxx() {
        return this.aDE;
    }

    public void rI(int i) {
        this.aDF = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void rJ(int i) {
        this.fTj = i;
    }

    public int bxy() {
        return this.fTj;
    }
}
