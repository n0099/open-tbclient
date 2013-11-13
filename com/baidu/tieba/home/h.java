package com.baidu.tieba.home;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.GroupsByUidMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EnterForumActivity enterForumActivity) {
        this.f1452a = enterForumActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        oVar = this.f1452a.c;
        if (oVar != null) {
            oVar2 = this.f1452a.c;
            if (oVar2.f1459a != null) {
                oVar3 = this.f1452a.c;
                if (oVar3.f1459a.b != null) {
                    oVar4 = this.f1452a.c;
                    com.baidu.tieba.im.b.c cVar = oVar4.f1459a.b;
                    if (!TiebaApplication.B()) {
                        baseFragmentActivity3 = this.f1452a.i;
                        baseFragmentActivity3.a("请先登录");
                    } else if (!EnterForumActivity.b) {
                        if (TiebaApplication.g().s()) {
                            baseFragmentActivity2 = this.f1452a.i;
                            StatService.onEvent(baseFragmentActivity2, "create_group_tab", "click", 1);
                        }
                        baseFragmentActivity = this.f1452a.i;
                        baseFragmentActivity.a(null, new i(this));
                        com.baidu.tieba.im.messageCenter.f.a().a(new GroupsByUidMessage(cVar.f1476a, cVar.b));
                        EnterForumActivity.b = true;
                    }
                }
            }
        }
    }
}
