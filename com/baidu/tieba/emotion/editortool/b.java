package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes13.dex */
public class b {
    private int btx;
    private int bty;
    private int column;
    private EmotionGroupType hAe;
    private int hAf;
    private int hAg;
    private com.baidu.tbadk.editortools.emotiontool.c hAh;
    private int hAi;
    private int hAj;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hAh = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c chv() {
        return this.hAh;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.hAe = emotionGroupType;
    }

    public EmotionGroupType chw() {
        return this.hAe;
    }

    public void qE(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int chx() {
        return this.column;
    }

    public void wl(int i) {
        this.hAj = i;
    }

    public int chy() {
        return this.hAj;
    }

    public void wm(int i) {
        this.hAi = i;
    }

    public int chz() {
        return this.hAi;
    }

    public void wn(int i) {
        this.hAf = i;
    }

    public int chA() {
        return this.hAf;
    }

    public void wo(int i) {
        this.btx = i;
    }

    public int chB() {
        return this.btx;
    }

    public void wp(int i) {
        this.bty = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void wq(int i) {
        this.hAg = i;
    }

    public int chC() {
        return this.hAg;
    }
}
