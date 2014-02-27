package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.tieba.home.EnterForumGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.cc;
import com.baidu.tieba.im.message.s;
import java.util.List;
/* loaded from: classes.dex */
final class e implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MyGroupFragment myGroupFragment) {
        this.a = myGroupFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        h hVar;
        h hVar2;
        h hVar3;
        a aVar;
        a aVar2;
        EnterForumGuideCenterView enterForumGuideCenterView;
        EnterForumGuideCenterView enterForumGuideCenterView2;
        if (this.a.getActivity() != null && this.a.b != null) {
            hVar = this.a.d;
            if (hVar != null) {
                if (sVar.w() == 103003) {
                    this.a.b.a();
                }
                cc ccVar = (cc) sVar;
                if (ccVar.l()) {
                    if (ccVar.m() != 0 && !TextUtils.isEmpty(ccVar.n())) {
                        this.a.a(ccVar.n());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> a = ccVar.a();
                if (a != null) {
                    aVar = this.a.f;
                    aVar.a(a);
                    aVar2 = this.a.f;
                    aVar2.notifyDataSetChanged();
                    if (a.size() > 0) {
                        enterForumGuideCenterView2 = this.a.g;
                        enterForumGuideCenterView2.setVisibility(8);
                        this.a.a();
                    } else {
                        enterForumGuideCenterView = this.a.g;
                        enterForumGuideCenterView.setVisibility(0);
                    }
                }
                if (sVar.w() == 103003) {
                    this.a.c = false;
                } else if (sVar.w() == -106) {
                    hVar2 = this.a.d;
                    if (hVar2 != null) {
                        hVar3 = this.a.d;
                        hVar3.a();
                    }
                }
            }
        }
    }
}
