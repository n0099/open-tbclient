package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class z {
    private boolean a;
    private int b;

    public z(boolean z, int i) {
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
        z zVar = (z) obj;
        return this.a == zVar.a && this.b == zVar.b;
    }
}
