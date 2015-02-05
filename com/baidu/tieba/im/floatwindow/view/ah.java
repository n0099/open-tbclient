package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements as {
    final /* synthetic */ FloatingPersonalChatView baq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FloatingPersonalChatView floatingPersonalChatView) {
        this.baq = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.as
    public void Om() {
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
        list = this.baq.mUserDataList;
        if (list != null) {
            i = this.baq.currentIndex;
            list2 = this.baq.mUserDataList;
            if (i < list2.size()) {
                i2 = this.baq.currentIndex;
                if (i2 >= 0) {
                    list3 = this.baq.mUserDataList;
                    i3 = this.baq.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    nVar = this.baq.ban;
                    apVar = this.baq.bao;
                    list4 = this.baq.mUserDataList;
                    i4 = this.baq.currentIndex;
                    nVar.fP(apVar.b((UserData) list4.get(i4)));
                }
            }
        }
    }
}
