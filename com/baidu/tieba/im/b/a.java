package com.baidu.tieba.im.b;
/* loaded from: classes.dex */
class a implements h {
    @Override // com.baidu.tieba.im.b.h
    public Object a(String str) {
        char charAt = str.charAt(0);
        return (charAt == '1' || charAt == 'y' || charAt == 'Y' || charAt == 't' || charAt == 'T') ? Boolean.TRUE : Boolean.FALSE;
    }
}
