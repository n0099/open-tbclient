package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private EmotionGroupType bFC;
    private int bFD;
    private int bFE;
    private int bFF;
    private int bFG;
    private com.baidu.tbadk.editortools.emotiontool.c bFH;
    private int bFI;
    private int bFJ;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bFH = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c Xd() {
        return this.bFH;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bFC = emotionGroupType;
    }

    public EmotionGroupType Xe() {
        return this.bFC;
    }

    public void eL(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eK(int i) {
        this.column = i;
    }

    public int Xf() {
        return this.column;
    }

    public void hi(int i) {
        this.bFJ = i;
    }

    public int Xg() {
        return this.bFJ;
    }

    public void hj(int i) {
        this.bFI = i;
    }

    public int Xh() {
        return this.bFI;
    }

    public void hk(int i) {
        this.bFD = i;
    }

    public int Xi() {
        return this.bFD;
    }

    public void hl(int i) {
        this.bFF = i;
    }

    public int Xj() {
        return this.bFF;
    }

    public void setEndIndex(int i) {
        this.bFG = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void hm(int i) {
        this.bFE = i;
    }

    public int Xk() {
        return this.bFE;
    }
}
