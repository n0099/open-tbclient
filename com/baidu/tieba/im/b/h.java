package com.baidu.tieba.im.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.home.EnterForumActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.k;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1472a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.f1472a = dVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        BaseFragmentActivity baseFragmentActivity;
        EnterForumActivity enterForumActivity;
        Handler handler;
        a aVar;
        Handler handler2;
        j jVar;
        j jVar2;
        a aVar2;
        a aVar3;
        j jVar3;
        j jVar4;
        EnterForumActivity enterForumActivity2;
        EnterForumActivity enterForumActivity3;
        EnterForumActivity enterForumActivity4;
        EnterForumActivity enterForumActivity5;
        baseFragmentActivity = this.f1472a.e;
        baseFragmentActivity.b();
        enterForumActivity = this.f1472a.d;
        if (enterForumActivity != null && this.f1472a.f1468a != null) {
            handler = this.f1472a.m;
            if (handler != null && this.f1472a.b != null) {
                aVar = this.f1472a.j;
                if (aVar != null) {
                    if (message.getCmd() == 103003) {
                        this.f1472a.f1468a.a();
                    }
                    if (message == null || !(message instanceof ResponseGroupsByUidMessage)) {
                        EnterForumActivity.b = false;
                        return;
                    }
                    ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) message;
                    if (responseGroupsByUidMessage.hasError()) {
                        EnterForumActivity.b = false;
                        if (responseGroupsByUidMessage.getErrNo() != k.r) {
                            String errMsg = responseGroupsByUidMessage.getErrMsg();
                            if (!TextUtils.isEmpty(errMsg)) {
                                enterForumActivity5 = this.f1472a.d;
                                enterForumActivity5.a(errMsg);
                            }
                        }
                    } else if (EnterForumActivity.b) {
                        EnterForumActivity.b = false;
                        GroupPermData groupPerm = responseGroupsByUidMessage.getGroupPerm();
                        if (groupPerm == null) {
                            enterForumActivity4 = this.f1472a.d;
                            enterForumActivity4.b(R.string.group_create_no_personinfo);
                        } else if (!groupPerm.isCreatePersonal()) {
                            enterForumActivity3 = this.f1472a.d;
                            enterForumActivity3.a(groupPerm.getCreatePersonalTip());
                        } else {
                            enterForumActivity2 = this.f1472a.d;
                            CreateGroupStepActivity.a(enterForumActivity2.i(), 2, 0);
                        }
                    } else {
                        List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                        GroupPermData groupPerm2 = responseGroupsByUidMessage.getGroupPerm();
                        if (groupPerm2 != null) {
                            this.f1472a.b.a(groupPerm2);
                        }
                        if (groups != null) {
                            if (groups.size() > 0) {
                                jVar3 = this.f1472a.k;
                                if (jVar3 != null) {
                                    jVar4 = this.f1472a.k;
                                    jVar4.b();
                                }
                            } else {
                                jVar = this.f1472a.k;
                                if (jVar != null) {
                                    jVar2 = this.f1472a.k;
                                    jVar2.a();
                                }
                            }
                            aVar2 = this.f1472a.j;
                            aVar2.a(groups);
                            this.f1472a.j();
                            aVar3 = this.f1472a.j;
                            aVar3.notifyDataSetChanged();
                            this.f1472a.f();
                        }
                        if (message.getCmd() == 103003) {
                            handler2 = this.f1472a.l;
                            handler2.removeMessages(1);
                            this.f1472a.c = false;
                        } else if (message.getCmd() == -106) {
                            if (UtilHelper.b()) {
                                this.f1472a.a();
                                if (this.f1472a.b != null) {
                                    this.f1472a.b.b();
                                    return;
                                }
                                return;
                            }
                            this.f1472a.f1468a.a();
                        }
                    }
                }
            }
        }
    }
}
