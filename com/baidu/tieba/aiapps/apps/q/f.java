package com.baidu.tieba.aiapps.apps.q;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.ubc.l;
import com.baidu.ubc.m;
/* loaded from: classes4.dex */
public class f implements l {
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.ubc.l
    public m aIy() {
        return new a(this.mContext);
    }

    @Override // com.baidu.ubc.l
    public String Nd() {
        return "";
    }

    @Override // com.baidu.ubc.l
    public boolean gv(String str) {
        return false;
    }

    @Override // com.baidu.ubc.l
    public boolean Ne() {
        return com.baidu.ubc.f.DEBUG;
    }
}
