package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private EmotionGroupType bFr;
    private int bFs;
    private int bFt;
    private int bFu;
    private int bFv;
    private com.baidu.tbadk.editortools.emotiontool.c bFw;
    private int bFx;
    private int bFy;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bFw = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c WK() {
        return this.bFw;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bFr = emotionGroupType;
    }

    public EmotionGroupType WL() {
        return this.bFr;
    }

    public void eM(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eL(int i) {
        this.column = i;
    }

    public int WM() {
        return this.column;
    }

    public void he(int i) {
        this.bFy = i;
    }

    public int WN() {
        return this.bFy;
    }

    public void hf(int i) {
        this.bFx = i;
    }

    public int WO() {
        return this.bFx;
    }

    public void hg(int i) {
        this.bFs = i;
    }

    public int WP() {
        return this.bFs;
    }

    public void hh(int i) {
        this.bFu = i;
    }

    public int WQ() {
        return this.bFu;
    }

    public void setEndIndex(int i) {
        this.bFv = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void hi(int i) {
        this.bFt = i;
    }

    public int WR() {
        return this.bFt;
    }
}
