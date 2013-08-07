package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecommendPagerAdapter f1117a;
    private final /* synthetic */ com.baidu.tieba.data.ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(RecommendPagerAdapter recommendPagerAdapter, com.baidu.tieba.data.ba baVar) {
        this.f1117a = recommendPagerAdapter;
        this.b = baVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        if (TiebaApplication.f().t()) {
            activity2 = this.f1117a.g;
            StatService.onEvent(activity2, "forum_by_day", "click", 1);
        }
        activity = this.f1117a.g;
        FrsActivity.a(activity, this.b.a(), (String) null);
    }
}
