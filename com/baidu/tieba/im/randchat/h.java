package com.baidu.tieba.im.randchat;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ChatRoomEventResponseMessage;
import com.baidu.tieba.im.model.bu;
import com.baidu.tieba.im.randchat.WaitingTipView;
/* loaded from: classes.dex */
final class h extends com.baidu.adp.framework.c.a {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(WaittingActivity waittingActivity, int i) {
        super(2001119);
        this.a = waittingActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.data.b a;
        bu buVar;
        bu buVar2;
        WaitingTipView.Type type;
        bu buVar3;
        boolean a2;
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 instanceof ChatRoomEventResponseMessage) {
            String a3 = ((ChatRoomEventResponseMessage) customResponsedMessage2).a();
            if (TextUtils.isEmpty(a3) || (a = com.baidu.tieba.im.data.b.a(a3)) == null) {
                return;
            }
            switch (a.h) {
                case 201:
                    WaittingActivity.a(this.a, a);
                    return;
                case 202:
                    WaittingActivity.b(this.a, a);
                    return;
                case 203:
                    this.a.a(a.a);
                    return;
                case 204:
                default:
                    return;
                case 205:
                    buVar = this.a.b;
                    buVar.a(a.j);
                    buVar2 = this.a.b;
                    buVar2.b(a.i);
                    type = this.a.h;
                    if (type != WaitingTipView.Type.PERSONS_READY) {
                        WaittingActivity waittingActivity = this.a;
                        buVar3 = this.a.b;
                        a2 = WaittingActivity.a(buVar3.f());
                        if (!a2) {
                            this.a.b(WaitingTipView.Type.TOPIC_UPDATE, (Object[]) null);
                        }
                        if (!TextUtils.isEmpty(a.j)) {
                            fVar = this.a.a;
                            fVar.d().getLoadingView().setVisibility(8);
                        } else if (!a2) {
                            fVar4 = this.a.a;
                            fVar4.d().getLoadingView().setVisibility(0);
                        } else {
                            fVar3 = this.a.a;
                            fVar3.d().getLoadingView().setVisibility(8);
                        }
                        fVar2 = this.a.a;
                        fVar2.d().getChatterboxView().setTitle(a.j);
                        return;
                    }
                    return;
            }
        }
    }
}
