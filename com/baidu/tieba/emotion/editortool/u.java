package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class u {
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

    public com.baidu.tbadk.editortools.emotiontool.c Wj() {
        return this.bFH;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bFC = emotionGroupType;
    }

    public EmotionGroupType Wk() {
        return this.bFC;
    }

    public void eO(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eN(int i) {
        this.column = i;
    }

    public int Wl() {
        return this.column;
    }

    public void hk(int i) {
        this.bFJ = i;
    }

    public int Wm() {
        return this.bFJ;
    }

    public void hl(int i) {
        this.bFI = i;
    }

    public int Wn() {
        return this.bFI;
    }

    public void hm(int i) {
        this.bFD = i;
    }

    public int Wo() {
        return this.bFD;
    }

    public void hn(int i) {
        this.bFF = i;
    }

    public int Wp() {
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

    public void ho(int i) {
        this.bFE = i;
    }

    public int Wq() {
        return this.bFE;
    }
}
