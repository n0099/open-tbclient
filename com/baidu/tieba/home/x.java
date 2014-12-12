package com.baidu.tieba.home;
/* loaded from: classes.dex */
class x {
    private int mSkinType = -1;

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    public boolean cc(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }
}
