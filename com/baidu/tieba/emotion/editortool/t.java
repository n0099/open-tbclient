package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private int aPA;
    private int aPB;
    private int aPC;
    private com.baidu.tbadk.editortools.emotiontool.c aPD;
    private int aPE;
    private int aPF;
    private EmotionGroupType aPy;
    private int aPz;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aPD = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c Jl() {
        return this.aPD;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.aPy = emotionGroupType;
    }

    public EmotionGroupType Jm() {
        return this.aPy;
    }

    public void ev(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eu(int i) {
        this.column = i;
    }

    public int Jn() {
        return this.column;
    }

    public void fm(int i) {
        this.aPF = i;
    }

    public int Jo() {
        return this.aPF;
    }

    public void fn(int i) {
        this.aPE = i;
    }

    public int Jp() {
        return this.aPE;
    }

    public void fo(int i) {
        this.aPz = i;
    }

    public int Jq() {
        return this.aPz;
    }

    public void fp(int i) {
        this.aPB = i;
    }

    public int Jr() {
        return this.aPB;
    }

    public void setEndIndex(int i) {
        this.aPC = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void fq(int i) {
        this.aPA = i;
    }

    public int Js() {
        return this.aPA;
    }
}
