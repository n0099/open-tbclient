package com.baidu.tieba.im.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.home.EnterForumActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1387a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.f1387a = dVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        EnterForumActivity enterForumActivity;
        EnterForumActivity enterForumActivity2;
        Handler handler;
        a aVar;
        Handler handler2;
        n nVar;
        n nVar2;
        a aVar2;
        a aVar3;
        n nVar3;
        n nVar4;
        EnterForumActivity enterForumActivity3;
        EnterForumActivity enterForumActivity4;
        EnterForumActivity enterForumActivity5;
        EnterForumActivity enterForumActivity6;
        enterForumActivity = this.f1387a.d;
        enterForumActivity.j();
        enterForumActivity2 = this.f1387a.d;
        if (enterForumActivity2 != null && this.f1387a.f1381a != null) {
            handler = this.f1387a.k;
            if (handler != null && this.f1387a.b != null) {
                aVar = this.f1387a.h;
                if (aVar != null) {
                    if (message.getCmd() == 103003) {
                        this.f1387a.f1381a.a();
                    }
                    if (message == null || !(message instanceof ResponseGroupsByUidMessage)) {
                        EnterForumActivity.b = false;
                        return;
                    }
                    ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) message;
                    if (responseGroupsByUidMessage.hasError()) {
                        EnterForumActivity.b = false;
                        if (responseGroupsByUidMessage.getErrNo() != com.baidu.tieba.im.k.r) {
                            String errMsg = responseGroupsByUidMessage.getErrMsg();
                            if (!TextUtils.isEmpty(errMsg)) {
                                enterForumActivity6 = this.f1387a.d;
                                enterForumActivity6.a(errMsg);
                            }
                        }
                    } else if (EnterForumActivity.b) {
                        EnterForumActivity.b = false;
                        GroupPermData groupPerm = responseGroupsByUidMessage.getGroupPerm();
                        if (groupPerm == null) {
                            enterForumActivity5 = this.f1387a.d;
                            enterForumActivity5.b(R.string.group_create_no_personinfo);
                        } else if (!groupPerm.isCreatePersonal()) {
                            enterForumActivity4 = this.f1387a.d;
                            enterForumActivity4.a(groupPerm.getCreatePersonalTip());
                        } else {
                            enterForumActivity3 = this.f1387a.d;
                            CreateGroupStepActivity.a(enterForumActivity3, 2, 0);
                        }
                    } else {
                        List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                        GroupPermData groupPerm2 = responseGroupsByUidMessage.getGroupPerm();
                        if (groupPerm2 != null) {
                            this.f1387a.b.a(groupPerm2);
                            this.f1387a.j();
                        }
                        if (groups != null) {
                            if (groups.size() > 0) {
                                nVar3 = this.f1387a.i;
                                if (nVar3 != null) {
                                    nVar4 = this.f1387a.i;
                                    nVar4.b();
                                }
                            } else {
                                nVar = this.f1387a.i;
                                if (nVar != null) {
                                    nVar2 = this.f1387a.i;
                                    nVar2.a();
                                }
                            }
                            aVar2 = this.f1387a.h;
                            aVar2.a(groups);
                            this.f1387a.k();
                            aVar3 = this.f1387a.h;
                            aVar3.notifyDataSetChanged();
                            this.f1387a.f();
                        }
                        if (message.getCmd() == 103003) {
                            handler2 = this.f1387a.j;
                            handler2.removeMessages(1);
                            this.f1387a.c = false;
                        } else if (message.getCmd() == -106) {
                            if (UtilHelper.b()) {
                                this.f1387a.a();
                                if (this.f1387a.b != null) {
                                    this.f1387a.b.b();
                                    return;
                                }
                                return;
                            }
                            this.f1387a.f1381a.a();
                        }
                    }
                }
            }
        }
    }
}
