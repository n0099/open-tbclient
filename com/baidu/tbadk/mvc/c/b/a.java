package com.baidu.tbadk.mvc.c.b;

import com.baidu.tbadk.core.data.ErrorData;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.c.b {
    public a(ErrorData errorData) {
        super(33554434, null, null, null);
        setExtra(errorData);
        aT(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.c.b
    /* renamed from: AM */
    public ErrorData getExtra() {
        Object extra = super.getExtra();
        if (extra instanceof ErrorData) {
            return (ErrorData) extra;
        }
        return null;
    }
}
