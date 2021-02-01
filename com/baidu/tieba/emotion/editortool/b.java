package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes8.dex */
public class b {
    private int bNG;
    private int bNH;
    private int column;
    private int iGA;
    private int iGB;
    private EmotionGroupType iGw;
    private int iGx;
    private int iGy;
    private com.baidu.tbadk.editortools.emotiontool.c iGz;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iGz = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c cuF() {
        return this.iGz;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.iGw = emotionGroupType;
    }

    public EmotionGroupType cuG() {
        return this.iGw;
    }

    public void rh(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int cuH() {
        return this.column;
    }

    public void xr(int i) {
        this.iGB = i;
    }

    public int cuI() {
        return this.iGB;
    }

    public void xs(int i) {
        this.iGA = i;
    }

    public int cuJ() {
        return this.iGA;
    }

    public void xt(int i) {
        this.iGx = i;
    }

    public int cuK() {
        return this.iGx;
    }

    public void xu(int i) {
        this.bNG = i;
    }

    public int cuL() {
        return this.bNG;
    }

    public void xv(int i) {
        this.bNH = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void xw(int i) {
        this.iGy = i;
    }

    public int cuM() {
        return this.iGy;
    }
}
