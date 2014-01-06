package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.tieba.home.EnterForumGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.bj;
import com.baidu.tieba.im.message.o;
import java.util.List;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyGroupFragment myGroupFragment) {
        this.a = myGroupFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(o oVar) {
        h hVar;
        h hVar2;
        h hVar3;
        a aVar;
        a aVar2;
        EnterForumGuideCenterView enterForumGuideCenterView;
        EnterForumGuideCenterView enterForumGuideCenterView2;
        if (this.a.i() != null && this.a.a != null) {
            hVar = this.a.c;
            if (hVar != null) {
                if (oVar.u() == 103003) {
                    this.a.a.a();
                }
                bj bjVar = (bj) oVar;
                if (bjVar.i()) {
                    if (bjVar.j() != 0 && !TextUtils.isEmpty(bjVar.k())) {
                        this.a.a(bjVar.k());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> a = bjVar.a();
                if (a != null) {
                    aVar = this.a.e;
                    aVar.a(a);
                    aVar2 = this.a.e;
                    aVar2.notifyDataSetChanged();
                    if (a.size() > 0) {
                        enterForumGuideCenterView2 = this.a.f;
                        enterForumGuideCenterView2.setVisibility(8);
                        this.a.a();
                    } else {
                        enterForumGuideCenterView = this.a.f;
                        enterForumGuideCenterView.setVisibility(0);
                    }
                }
                if (oVar.u() == 103003) {
                    this.a.b = false;
                } else if (oVar.u() == -106) {
                    hVar2 = this.a.c;
                    if (hVar2 != null) {
                        hVar3 = this.a.c;
                        hVar3.a();
                    }
                }
            }
        }
    }
}
