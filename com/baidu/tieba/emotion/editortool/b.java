package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes13.dex */
public class b {
    private int bqn;
    private int bqo;
    private int column;
    private EmotionGroupType hsZ;
    private int hta;
    private int htb;
    private com.baidu.tbadk.editortools.emotiontool.c htc;
    private int htd;
    private int hte;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.htc = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c ceg() {
        return this.htc;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.hsZ = emotionGroupType;
    }

    public EmotionGroupType ceh() {
        return this.hsZ;
    }

    public void qn(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int cei() {
        return this.column;
    }

    public void vM(int i) {
        this.hte = i;
    }

    public int cej() {
        return this.hte;
    }

    public void vN(int i) {
        this.htd = i;
    }

    public int cek() {
        return this.htd;
    }

    public void vO(int i) {
        this.hta = i;
    }

    public int cel() {
        return this.hta;
    }

    public void vP(int i) {
        this.bqn = i;
    }

    public int cem() {
        return this.bqn;
    }

    public void vQ(int i) {
        this.bqo = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void vR(int i) {
        this.htb = i;
    }

    public int cen() {
        return this.htb;
    }
}
