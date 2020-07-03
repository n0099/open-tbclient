package com.baidu.tbadk.mutiprocess.backbaidubox;

import com.baidu.tbadk.mutiprocess.b;
import com.baidu.tbadk.util.d;
/* loaded from: classes.dex */
public class a implements b<BackBaiduBoxViewEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mutiprocess.b
    public boolean a(BackBaiduBoxViewEvent backBaiduBoxViewEvent) {
        if (backBaiduBoxViewEvent == null) {
            return false;
        }
        d.biB().iE(backBaiduBoxViewEvent.isShow);
        return true;
    }
}
