package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class ai {
    private boolean a;
    private int b;

    public ai(boolean z, int i) {
        this.a = z;
        this.b = i;
    }

    public int hashCode() {
        return (this.a ? 1 : 0) + this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ai aiVar = (ai) obj;
        return this.a == aiVar.a && this.b == aiVar.b;
    }
}
