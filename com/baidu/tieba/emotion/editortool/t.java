package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private int bIA;
    private com.baidu.tbadk.editortools.emotiontool.c bIB;
    private int bIC;
    private int bID;
    private EmotionGroupType bIw;
    private int bIx;
    private int bIy;
    private int bIz;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bIB = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c Yf() {
        return this.bIB;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bIw = emotionGroupType;
    }

    public EmotionGroupType Yg() {
        return this.bIw;
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

    public int Yh() {
        return this.column;
    }

    public void hj(int i) {
        this.bID = i;
    }

    public int Yi() {
        return this.bID;
    }

    public void hk(int i) {
        this.bIC = i;
    }

    public int Yj() {
        return this.bIC;
    }

    public void hl(int i) {
        this.bIx = i;
    }

    public int Yk() {
        return this.bIx;
    }

    public void hm(int i) {
        this.bIz = i;
    }

    public int Yl() {
        return this.bIz;
    }

    public void setEndIndex(int i) {
        this.bIA = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void hn(int i) {
        this.bIy = i;
    }

    public int Ym() {
        return this.bIy;
    }
}
