package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private EmotionGroupType bae;
    private int baf;
    private int bag;
    private int bah;
    private int bai;
    private com.baidu.tbadk.editortools.emotiontool.c baj;
    private int bak;
    private int bal;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.baj = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c Ne() {
        return this.baj;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bae = emotionGroupType;
    }

    public EmotionGroupType Nf() {
        return this.bae;
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

    public int Ng() {
        return this.column;
    }

    public void fW(int i) {
        this.bal = i;
    }

    public int Nh() {
        return this.bal;
    }

    public void fX(int i) {
        this.bak = i;
    }

    public int Ni() {
        return this.bak;
    }

    public void fY(int i) {
        this.baf = i;
    }

    public int Nj() {
        return this.baf;
    }

    public void fZ(int i) {
        this.bah = i;
    }

    public int Nk() {
        return this.bah;
    }

    public void setEndIndex(int i) {
        this.bai = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void ga(int i) {
        this.bag = i;
    }

    public int Nl() {
        return this.bag;
    }
}
