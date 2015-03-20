package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class aj {
    private boolean aym;

    public aj(boolean z) {
        this.aym = z;
    }

    public int hashCode() {
        return (this.aym ? 1231 : 1237) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.aym == ((aj) obj).aym;
    }
}
