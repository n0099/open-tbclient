package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.tieba.im.h<Integer> {
    final /* synthetic */ ap aYY;
    private final /* synthetic */ UserData aYZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar, UserData userData) {
        this.aYY = apVar;
        this.aYZ = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Integer doInBackground() {
        int c;
        c = this.aYY.c(this.aYZ);
        return Integer.valueOf(c);
    }
}
