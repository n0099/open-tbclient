package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes8.dex */
public class b {
    private int bOI;
    private int bOJ;
    private int column;
    private EmotionGroupType iFt;
    private int iFu;
    private int iFv;
    private com.baidu.tbadk.editortools.emotiontool.c iFw;
    private int iFx;
    private int iFy;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iFw = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c cxl() {
        return this.iFw;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.iFt = emotionGroupType;
    }

    public EmotionGroupType cxm() {
        return this.iFt;
    }

    public void sI(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int cxn() {
        return this.column;
    }

    public void yN(int i) {
        this.iFy = i;
    }

    public int cxo() {
        return this.iFy;
    }

    public void yO(int i) {
        this.iFx = i;
    }

    public int cxp() {
        return this.iFx;
    }

    public void yP(int i) {
        this.iFu = i;
    }

    public int cxq() {
        return this.iFu;
    }

    public void yQ(int i) {
        this.bOI = i;
    }

    public int cxr() {
        return this.bOI;
    }

    public void yR(int i) {
        this.bOJ = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void yS(int i) {
        this.iFv = i;
    }

    public int cxs() {
        return this.iFv;
    }
}
