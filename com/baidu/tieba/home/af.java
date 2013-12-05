package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1445a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SearchActivity searchActivity) {
        this.f1445a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.f1445a).setTitle("提醒").setIcon(R.drawable.dialogue_quit).setMessage("确认清除搜索记录？").setPositiveButton("确认", new ah(this)).setNegativeButton("取消", new ag(this)).create().show();
    }
}
