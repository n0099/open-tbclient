package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class ai {
    private boolean bgM;

    public ai(boolean z) {
        this.bgM = z;
    }

    public int hashCode() {
        return (this.bgM ? 1231 : 1237) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.bgM == ((ai) obj).bgM;
    }
}
