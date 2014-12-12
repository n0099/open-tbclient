package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements as {
    final /* synthetic */ FloatingPersonalChatView aYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FloatingPersonalChatView floatingPersonalChatView) {
        this.aYV = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.as
    public void NV() {
        List list;
        int i;
        List list2;
        int i2;
        List list3;
        int i3;
        n nVar;
        ap apVar;
        List list4;
        int i4;
        list = this.aYV.mUserDataList;
        if (list != null) {
            i = this.aYV.currentIndex;
            list2 = this.aYV.mUserDataList;
            if (i < list2.size()) {
                i2 = this.aYV.currentIndex;
                if (i2 >= 0) {
                    list3 = this.aYV.mUserDataList;
                    i3 = this.aYV.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    nVar = this.aYV.aYS;
                    apVar = this.aYV.aYT;
                    list4 = this.aYV.mUserDataList;
                    i4 = this.aYV.currentIndex;
                    nVar.fK(apVar.b((UserData) list4.get(i4)));
                }
            }
        }
    }
}
