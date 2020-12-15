package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes13.dex */
public class b {
    private int bJV;
    private int bJW;
    private int column;
    private int index;
    private EmotionGroupType itg;
    private int ith;
    private int iti;
    private com.baidu.tbadk.editortools.emotiontool.c itj;
    private int itk;
    private int itl;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.itj = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c cur() {
        return this.itj;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.itg = emotionGroupType;
    }

    public EmotionGroupType cus() {
        return this.itg;
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

    public int cut() {
        return this.column;
    }

    public void yA(int i) {
        this.itl = i;
    }

    public int cuu() {
        return this.itl;
    }

    public void yB(int i) {
        this.itk = i;
    }

    public int cuv() {
        return this.itk;
    }

    public void yC(int i) {
        this.ith = i;
    }

    public int cuw() {
        return this.ith;
    }

    public void yD(int i) {
        this.bJV = i;
    }

    public int cux() {
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
        this.iti = i;
    }

    public int cuy() {
        return this.iti;
    }
}
