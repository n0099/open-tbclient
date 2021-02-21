package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes8.dex */
public class b {
    private int bNG;
    private int bNH;
    private int column;
    private EmotionGroupType iGK;
    private int iGL;
    private int iGM;
    private com.baidu.tbadk.editortools.emotiontool.c iGN;
    private int iGO;
    private int iGP;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iGN = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c cuM() {
        return this.iGN;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.iGK = emotionGroupType;
    }

    public EmotionGroupType cuN() {
        return this.iGK;
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

    public int cuO() {
        return this.column;
    }

    public void xr(int i) {
        this.iGP = i;
    }

    public int cuP() {
        return this.iGP;
    }

    public void xs(int i) {
        this.iGO = i;
    }

    public int cuQ() {
        return this.iGO;
    }

    public void xt(int i) {
        this.iGL = i;
    }

    public int cuR() {
        return this.iGL;
    }

    public void xu(int i) {
        this.bNG = i;
    }

    public int cuS() {
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
        this.iGM = i;
    }

    public int cuT() {
        return this.iGM;
    }
}
