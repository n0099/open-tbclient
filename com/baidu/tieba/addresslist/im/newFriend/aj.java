package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class aj {
    private boolean ayu;

    public aj(boolean z) {
        this.ayu = z;
    }

    public int hashCode() {
        return (this.ayu ? 1231 : 1237) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.ayu == ((aj) obj).ayu;
    }
}
