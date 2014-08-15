package com.baidu.tieba.im.live.room;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.MetaData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tbadk.core.view.ad {
    final /* synthetic */ aq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.a = aqVar;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void a(int i) {
        List list;
        List list2;
        List list3;
        Activity activity;
        list = this.a.f;
        if (list != null) {
            list2 = this.a.f;
            if (list2.size() > 0) {
                list3 = this.a.f;
                MetaData metaData = (MetaData) list3.get(i);
                if (metaData != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    activity = this.a.a;
                    messageManager.sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bg(activity, metaData.getUserId(), metaData.getName_show())));
                }
            }
        }
    }
}
