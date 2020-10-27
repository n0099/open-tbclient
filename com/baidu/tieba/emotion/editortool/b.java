package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes13.dex */
public class b {
    private int bAm;
    private int bAn;
    private int column;
    private int ibA;
    private int ibB;
    private EmotionGroupType ibw;
    private int ibx;
    private int iby;
    private com.baidu.tbadk.editortools.emotiontool.c ibz;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.ibz = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c cnY() {
        return this.ibz;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.ibw = emotionGroupType;
    }

    public EmotionGroupType cnZ() {
        return this.ibw;
    }

    public void rn(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int coa() {
        return this.column;
    }

    public void xk(int i) {
        this.ibB = i;
    }

    public int cob() {
        return this.ibB;
    }

    public void xl(int i) {
        this.ibA = i;
    }

    public int coc() {
        return this.ibA;
    }

    public void xm(int i) {
        this.ibx = i;
    }

    public int cod() {
        return this.ibx;
    }

    public void xn(int i) {
        this.bAm = i;
    }

    public int coe() {
        return this.bAm;
    }

    public void xo(int i) {
        this.bAn = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void xp(int i) {
        this.iby = i;
    }

    public int cof() {
        return this.iby;
    }
}
