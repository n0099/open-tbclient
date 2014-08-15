package com.baidu.tieba.im.randchat;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ChatRoomEventResponseMessage;
import com.baidu.tieba.im.model.bf;
import com.baidu.tieba.im.randchat.WaitingTipView;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(WaittingActivity waittingActivity, int i) {
        super(i);
        this.a = waittingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.data.b a;
        bf bfVar;
        bf bfVar2;
        WaitingTipView.Type type;
        bf bfVar3;
        boolean a2;
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        if (customResponsedMessage instanceof ChatRoomEventResponseMessage) {
            String data = ((ChatRoomEventResponseMessage) customResponsedMessage).getData();
            if (TextUtils.isEmpty(data) || (a = com.baidu.tieba.im.data.b.a(data)) == null) {
                return;
            }
            switch (a.h) {
                case 201:
                    this.a.a(a);
                    return;
                case 202:
                    this.a.b(a);
                    return;
                case 203:
                    this.a.c(a);
                    return;
                case 204:
                default:
                    return;
                case 205:
                    bfVar = this.a.b;
                    bfVar.a(a.j);
                    bfVar2 = this.a.b;
                    bfVar2.b(a.i);
                    type = this.a.i;
                    if (type != WaitingTipView.Type.PERSONS_READY) {
                        WaittingActivity waittingActivity = this.a;
                        bfVar3 = this.a.b;
                        a2 = waittingActivity.a(bfVar3.f());
                        if (!a2) {
                            this.a.b(WaitingTipView.Type.TOPIC_UPDATE, (Object[]) null);
                        }
                        if (!TextUtils.isEmpty(a.j)) {
                            fVar = this.a.a;
                            fVar.b().getLoadingView().setVisibility(8);
                        } else if (!a2) {
                            fVar4 = this.a.a;
                            fVar4.b().getLoadingView().setVisibility(0);
                        } else {
                            fVar3 = this.a.a;
                            fVar3.b().getLoadingView().setVisibility(8);
                        }
                        fVar2 = this.a.a;
                        fVar2.b().getChatterboxView().setTitle(a.j);
                        return;
                    }
                    return;
            }
        }
    }
}
