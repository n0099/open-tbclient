package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private int boA;
    private int boB;
    private int boC;
    private int boD;
    private com.baidu.tbadk.editortools.emotiontool.c boE;
    private int boF;
    private int boG;
    private EmotionGroupType boz;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.boE = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c Sq() {
        return this.boE;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.boz = emotionGroupType;
    }

    public EmotionGroupType Sr() {
        return this.boz;
    }

    public void eP(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eO(int i) {
        this.column = i;
    }

    public int Ss() {
        return this.column;
    }

    public void gt(int i) {
        this.boG = i;
    }

    public int St() {
        return this.boG;
    }

    public void gu(int i) {
        this.boF = i;
    }

    public int Su() {
        return this.boF;
    }

    public void gv(int i) {
        this.boA = i;
    }

    public int Sv() {
        return this.boA;
    }

    public void gw(int i) {
        this.boC = i;
    }

    public int Sw() {
        return this.boC;
    }

    public void setEndIndex(int i) {
        this.boD = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void gx(int i) {
        this.boB = i;
    }

    public int Sx() {
        return this.boB;
    }
}
