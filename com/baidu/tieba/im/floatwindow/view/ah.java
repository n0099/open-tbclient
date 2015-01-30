package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements as {
    final /* synthetic */ FloatingPersonalChatView bas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FloatingPersonalChatView floatingPersonalChatView) {
        this.bas = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.as
    public void Or() {
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
        list = this.bas.mUserDataList;
        if (list != null) {
            i = this.bas.currentIndex;
            list2 = this.bas.mUserDataList;
            if (i < list2.size()) {
                i2 = this.bas.currentIndex;
                if (i2 >= 0) {
                    list3 = this.bas.mUserDataList;
                    i3 = this.bas.currentIndex;
                    if (list3.get(i3) == null) {
                        return;
                    }
                    nVar = this.bas.bao;
                    apVar = this.bas.bap;
                    list4 = this.bas.mUserDataList;
                    i4 = this.bas.currentIndex;
                    nVar.fP(apVar.b((UserData) list4.get(i4)));
                }
            }
        }
    }
}
