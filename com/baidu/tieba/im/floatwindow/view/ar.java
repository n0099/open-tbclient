package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tieba.im.g<Integer> {
    final /* synthetic */ ap aYY;
    private final /* synthetic */ UserData aYZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar, UserData userData) {
        this.aYY = apVar;
        this.aYZ = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: b */
    public void onReturnDataInUI(Integer num) {
        HashMap hashMap;
        as asVar;
        as asVar2;
        if (num != null) {
            hashMap = this.aYY.aYW;
            hashMap.put(this.aYZ.getUserId(), num);
            asVar = this.aYY.aYX;
            if (asVar != null) {
                asVar2 = this.aYY.aYX;
                asVar2.NV();
            }
        }
    }
}
