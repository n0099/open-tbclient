package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class ai {
    private boolean blo;

    public ai(boolean z) {
        this.blo = z;
    }

    public int hashCode() {
        return (this.blo ? 1231 : 1237) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.blo == ((ai) obj).blo;
    }
}
