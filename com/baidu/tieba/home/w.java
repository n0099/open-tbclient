package com.baidu.tieba.home;
/* loaded from: classes.dex */
class w {
    private int mSkinType = -1;

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    public boolean cj(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }
}
