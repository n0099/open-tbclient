package com.baidu.tbadk.mutiprocess.prePageKey;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.mutiprocess.b;
import com.baidu.tbadk.pageExtra.d;
/* loaded from: classes.dex */
public class a implements b<PrePageKeyEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mutiprocess.b
    public boolean a(PrePageKeyEvent prePageKeyEvent) {
        if (prePageKeyEvent == null && StringUtil.isEmpty(prePageKeyEvent.prePageKey)) {
            return false;
        }
        d.Dn(prePageKeyEvent.prePageKey);
        return true;
    }
}
