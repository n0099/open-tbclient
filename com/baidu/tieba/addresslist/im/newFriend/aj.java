package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class aj {
    private boolean aAg;

    public aj(boolean z) {
        this.aAg = z;
    }

    public int hashCode() {
        return (this.aAg ? 1231 : 1237) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.aAg == ((aj) obj).aAg;
    }
}
