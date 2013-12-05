package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.tieba.home.EnterForumGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import java.util.List;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyGroupFragment f1839a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyGroupFragment myGroupFragment) {
        this.f1839a = myGroupFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        h hVar;
        h hVar2;
        h hVar3;
        a aVar;
        a aVar2;
        EnterForumGuideCenterView enterForumGuideCenterView;
        EnterForumGuideCenterView enterForumGuideCenterView2;
        if (this.f1839a.i() != null && this.f1839a.f1832a != null) {
            hVar = this.f1839a.c;
            if (hVar != null) {
                if (message.getCmd() == 103003) {
                    this.f1839a.f1832a.a();
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) message;
                if (responseGroupsByUidMessage.hasError()) {
                    if (responseGroupsByUidMessage.getErrNo() > 0 && !TextUtils.isEmpty(responseGroupsByUidMessage.getErrMsg())) {
                        this.f1839a.a(responseGroupsByUidMessage.getErrMsg());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (groups != null) {
                    aVar = this.f1839a.e;
                    aVar.a(groups);
                    aVar2 = this.f1839a.e;
                    aVar2.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        enterForumGuideCenterView2 = this.f1839a.f;
                        enterForumGuideCenterView2.setVisibility(8);
                        this.f1839a.a();
                    } else {
                        enterForumGuideCenterView = this.f1839a.f;
                        enterForumGuideCenterView.setVisibility(0);
                    }
                }
                if (message.getCmd() == 103003) {
                    this.f1839a.b = false;
                } else if (message.getCmd() == -106) {
                    hVar2 = this.f1839a.c;
                    if (hVar2 != null) {
                        hVar3 = this.f1839a.c;
                        hVar3.a();
                    }
                }
            }
        }
    }
}
