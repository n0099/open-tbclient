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
    final /* synthetic */ ItemFootNavView f1087a;
    private final /* synthetic */ com.baidu.tieba.j b;
    private final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ItemFootNavView itemFootNavView, com.baidu.tieba.j jVar, boolean z) {
        this.f1087a = itemFootNavView;
        this.b = jVar;
        this.c = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewGroup viewGroup;
        Context context;
        if ((TiebaApplication.C() == null || TiebaApplication.G() == null) ? false : true) {
            viewGroup = this.f1087a.b;
            int intValue = ((Integer) viewGroup.getTag()).intValue();
            if (intValue != 1) {
                this.f1087a.a(this.b, this.c);
            } else {
                this.f1087a.b(this.b, this.c);
            }
            if (TiebaApplication.g().s()) {
                String str = intValue == 1 ? "detail_care_add" : "detail_care_cancel";
                context = this.f1087a.f1080a;
                StatService.onEvent(context, str, "click", 1);
                return;
            }
            return;
        }
        LoginActivity.a((Activity) this.b, this.f1087a.getResources().getString(R.string.login_to_use), true, 11034);
    }
}
