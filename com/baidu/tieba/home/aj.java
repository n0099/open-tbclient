package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1120a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SearchActivity searchActivity) {
        this.f1120a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.f1120a).setTitle("提醒").setIcon(R.drawable.dialogue_quit).setMessage("确认清除搜索记录？").setPositiveButton("确认", new ak(this)).setNegativeButton("取消", new al(this)).create().show();
    }
}
