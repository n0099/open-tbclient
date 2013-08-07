package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecommendPagerAdapter f1113a;
    private final /* synthetic */ com.baidu.tieba.data.bb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(RecommendPagerAdapter recommendPagerAdapter, com.baidu.tieba.data.bb bbVar) {
        this.f1113a = recommendPagerAdapter;
        this.b = bbVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.f1113a.g;
        StatService.onEvent(activity, "ef_guess", "click");
        activity2 = this.f1113a.g;
        FrsActivity.a(activity2, this.b.e(), (String) null);
    }
}
