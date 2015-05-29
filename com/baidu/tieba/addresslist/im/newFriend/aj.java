package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class aj {
    private boolean aAf;

    public aj(boolean z) {
        this.aAf = z;
    }

    public int hashCode() {
        return (this.aAf ? 1231 : 1237) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.aAf == ((aj) obj).aAf;
    }
}
