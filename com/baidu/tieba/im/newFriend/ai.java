package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class ai {
    private boolean blp;

    public ai(boolean z) {
        this.blp = z;
    }

    public int hashCode() {
        return (this.blp ? 1231 : 1237) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.blp == ((ai) obj).blp;
    }
}
