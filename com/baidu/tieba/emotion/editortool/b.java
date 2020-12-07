package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes13.dex */
public class b {
    private int bJV;
    private int bJW;
    private int column;
    private int index;
    private EmotionGroupType ite;
    private int itf;
    private int itg;
    private com.baidu.tbadk.editortools.emotiontool.c ith;
    private int iti;
    private int itj;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.ith = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c cuq() {
        return this.ith;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.ite = emotionGroupType;
    }

    public EmotionGroupType cur() {
        return this.ite;
    }

    public void sw(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int cus() {
        return this.column;
    }

    public void yA(int i) {
        this.itj = i;
    }

    public int cut() {
        return this.itj;
    }

    public void yB(int i) {
        this.iti = i;
    }

    public int cuu() {
        return this.iti;
    }

    public void yC(int i) {
        this.itf = i;
    }

    public int cuv() {
        return this.itf;
    }

    public void yD(int i) {
        this.bJV = i;
    }

    public int cuw() {
        return this.bJV;
    }

    public void yE(int i) {
        this.bJW = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void yF(int i) {
        this.itg = i;
    }

    public int cux() {
        return this.itg;
    }
}
