package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1404a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(SearchActivity searchActivity) {
        this.f1404a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.f1404a).setTitle("提醒").setIcon(R.drawable.dialogue_quit).setMessage("确认清除搜索记录？").setPositiveButton("确认", new am(this)).setNegativeButton("取消", new al(this)).create().show();
    }
}
