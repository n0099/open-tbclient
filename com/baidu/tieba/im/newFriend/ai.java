package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class ai {
    private boolean bha;

    public ai(boolean z) {
        this.bha = z;
    }

    public int hashCode() {
        return (this.bha ? 1231 : 1237) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.bha == ((ai) obj).bha;
    }
}
