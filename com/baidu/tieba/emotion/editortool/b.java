package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes13.dex */
public class b {
    private int bkF;
    private int bkG;
    private int column;
    private EmotionGroupType hga;
    private int hgb;
    private int hgc;
    private com.baidu.tbadk.editortools.emotiontool.c hgd;
    private int hge;
    private int hgf;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hgd = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bTT() {
        return this.hgd;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.hga = emotionGroupType;
    }

    public EmotionGroupType bTU() {
        return this.hga;
    }

    public void oc(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int bTV() {
        return this.column;
    }

    public void tx(int i) {
        this.hgf = i;
    }

    public int bTW() {
        return this.hgf;
    }

    public void ty(int i) {
        this.hge = i;
    }

    public int bTX() {
        return this.hge;
    }

    public void tz(int i) {
        this.hgb = i;
    }

    public int bTY() {
        return this.hgb;
    }

    public void tA(int i) {
        this.bkF = i;
    }

    public int bTZ() {
        return this.bkF;
    }

    public void tB(int i) {
        this.bkG = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void tC(int i) {
        this.hgc = i;
    }

    public int bUa() {
        return this.hgc;
    }
}
