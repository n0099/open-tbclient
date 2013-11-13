package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f1460a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        BaseFragmentActivity baseFragmentActivity;
        String str;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        EnterForumActivity unused;
        unused = this.f1460a.g;
        if (EnterForumActivity.f1388a == 0) {
            z = this.f1460a.x;
            if (z) {
                baseFragmentActivity3 = this.f1460a.f;
                SignAllForumActivity.a(baseFragmentActivity3);
            } else {
                baseFragmentActivity = this.f1460a.f;
                str = this.f1460a.y;
                UtilHelper.a((Context) baseFragmentActivity, str);
            }
            baseFragmentActivity2 = this.f1460a.f;
            com.baidu.tieba.ai.a(baseFragmentActivity2, "signall_enter_click");
        }
    }
}
