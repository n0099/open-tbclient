package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tieba.im.g<Integer> {
    final /* synthetic */ ap bau;
    private final /* synthetic */ UserData bav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar, UserData userData) {
        this.bau = apVar;
        this.bav = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: b */
    public void onReturnDataInUI(Integer num) {
        HashMap hashMap;
        as asVar;
        as asVar2;
        if (num != null) {
            hashMap = this.bau.bas;
            hashMap.put(this.bav.getUserId(), num);
            asVar = this.bau.bat;
            if (asVar != null) {
                asVar2 = this.bau.bat;
                asVar2.Om();
            }
        }
    }
}
