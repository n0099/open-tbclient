package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes7.dex */
public class b {
    private int bPg;
    private int bPh;
    private int column;
    private EmotionGroupType iIt;
    private int iIu;
    private int iIv;
    private com.baidu.tbadk.editortools.emotiontool.c iIw;
    private int iIx;
    private int iIy;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iIw = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c cuS() {
        return this.iIw;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.iIt = emotionGroupType;
    }

    public EmotionGroupType cuT() {
        return this.iIt;
    }

    public void ri(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int cuU() {
        return this.column;
    }

    public void xs(int i) {
        this.iIy = i;
    }

    public int cuV() {
        return this.iIy;
    }

    public void xt(int i) {
        this.iIx = i;
    }

    public int cuW() {
        return this.iIx;
    }

    public void xu(int i) {
        this.iIu = i;
    }

    public int cuX() {
        return this.iIu;
    }

    public void xv(int i) {
        this.bPg = i;
    }

    public int cuY() {
        return this.bPg;
    }

    public void xw(int i) {
        this.bPh = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void xx(int i) {
        this.iIv = i;
    }

    public int cuZ() {
        return this.iIv;
    }
}
