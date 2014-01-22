package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.tieba.home.EnterForumGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.bt;
import com.baidu.tieba.im.message.q;
import java.util.List;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyGroupFragment myGroupFragment) {
        this.a = myGroupFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
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
                if (qVar.w() == 103003) {
                    this.a.a.a();
                }
                bt btVar = (bt) qVar;
                if (btVar.k()) {
                    if (btVar.l() != 0 && !TextUtils.isEmpty(btVar.m())) {
                        this.a.a(btVar.m());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> a = btVar.a();
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
                if (qVar.w() == 103003) {
                    this.a.b = false;
                } else if (qVar.w() == -106) {
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
