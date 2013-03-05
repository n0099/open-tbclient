package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.a).setTitle("提醒").setIcon(R.drawable.dialogue_quit).setMessage("确认清除搜索记录？").setPositiveButton("确认", new as(this)).setNegativeButton("取消", new at(this)).create().show();
    }
}
