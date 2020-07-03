package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes6.dex */
public class b {
    private int bkl;
    private int bkm;
    private int column;
    private int haA;
    private EmotionGroupType hav;
    private int haw;
    private int hax;
    private com.baidu.tbadk.editortools.emotiontool.c hay;
    private int haz;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hay = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bQH() {
        return this.hay;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.hav = emotionGroupType;
    }

    public EmotionGroupType bQI() {
        return this.hav;
    }

    public void nK(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int bQJ() {
        return this.column;
    }

    public void tf(int i) {
        this.haA = i;
    }

    public int bQK() {
        return this.haA;
    }

    public void tg(int i) {
        this.haz = i;
    }

    public int bQL() {
        return this.haz;
    }

    public void th(int i) {
        this.haw = i;
    }

    public int bQM() {
        return this.haw;
    }

    public void ti(int i) {
        this.bkl = i;
    }

    public int bQN() {
        return this.bkl;
    }

    public void tj(int i) {
        this.bkm = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void tk(int i) {
        this.hax = i;
    }

    public int bQO() {
        return this.hax;
    }
}
