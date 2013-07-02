package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ RecommendPagerAdapter a;
    private final /* synthetic */ com.baidu.tieba.data.as b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(RecommendPagerAdapter recommendPagerAdapter, com.baidu.tieba.data.as asVar) {
        this.a = recommendPagerAdapter;
        this.b = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.a.g;
        StatService.onEvent(activity, "ef_guess", "click");
        activity2 = this.a.g;
        FrsActivity.a(activity2, this.b.e(), (String) null);
    }
}
