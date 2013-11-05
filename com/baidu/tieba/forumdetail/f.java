package com.baidu.tieba.forumdetail;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.j f1219a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ItemFootNavView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ItemFootNavView itemFootNavView, com.baidu.tieba.j jVar, boolean z) {
        this.c = itemFootNavView;
        this.f1219a = jVar;
        this.b = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewGroup viewGroup;
        Context context;
        if ((TiebaApplication.C() == null || TiebaApplication.H() == null) ? false : true) {
            viewGroup = this.c.b;
            int intValue = ((Integer) viewGroup.getTag()).intValue();
            if (intValue == 1) {
                this.c.b(this.f1219a, this.b);
            } else {
                this.c.a(this.f1219a, this.b);
            }
            if (TiebaApplication.g().s()) {
                String str = intValue == 1 ? "detail_care_add" : "detail_care_cancel";
                context = this.c.f1211a;
                StatService.onEvent(context, str, "click", 1);
                return;
            }
            return;
        }
        LoginActivity.a((Activity) this.f1219a, this.c.getResources().getString(R.string.login_to_use), true, 11034);
    }
}
