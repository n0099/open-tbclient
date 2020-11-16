package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes13.dex */
public class b {
    private int bEM;
    private int bEN;
    private int column;
    private EmotionGroupType iil;
    private int iim;
    private int iin;
    private com.baidu.tbadk.editortools.emotiontool.c iio;
    private int iip;
    private int iiq;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iio = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c cqc() {
        return this.iio;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.iil = emotionGroupType;
    }

    public EmotionGroupType cqd() {
        return this.iil;
    }

    public void rV(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int cqe() {
        return this.column;
    }

    public void xV(int i) {
        this.iiq = i;
    }

    public int cqf() {
        return this.iiq;
    }

    public void xW(int i) {
        this.iip = i;
    }

    public int cqg() {
        return this.iip;
    }

    public void xX(int i) {
        this.iim = i;
    }

    public int cqh() {
        return this.iim;
    }

    public void xY(int i) {
        this.bEM = i;
    }

    public int cqi() {
        return this.bEM;
    }

    public void xZ(int i) {
        this.bEN = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void ya(int i) {
        this.iin = i;
    }

    public int cqj() {
        return this.iin;
    }
}
