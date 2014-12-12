package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class ai {
    private boolean bjS;

    public ai(boolean z) {
        this.bjS = z;
    }

    public int hashCode() {
        return (this.bjS ? 1231 : 1237) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.bjS == ((ai) obj).bjS;
    }
}
