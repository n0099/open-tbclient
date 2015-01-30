package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tieba.im.g<Integer> {
    final /* synthetic */ ap bav;
    private final /* synthetic */ UserData baw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar, UserData userData) {
        this.bav = apVar;
        this.baw = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: b */
    public void onReturnDataInUI(Integer num) {
        HashMap hashMap;
        as asVar;
        as asVar2;
        if (num != null) {
            hashMap = this.bav.bat;
            hashMap.put(this.baw.getUserId(), num);
            asVar = this.bav.bau;
            if (asVar != null) {
                asVar2 = this.bav.bau;
                asVar2.Or();
            }
        }
    }
}
