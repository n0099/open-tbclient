package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class ae {
    private boolean a;
    private int b;

    public ae(boolean z, int i) {
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
        ae aeVar = (ae) obj;
        return this.a == aeVar.a && this.b == aeVar.b;
    }
}
