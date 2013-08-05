package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.data.bp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TopicPagerAdapter f1145a;
    private final /* synthetic */ bp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(TopicPagerAdapter topicPagerAdapter, bp bpVar) {
        this.f1145a = topicPagerAdapter;
        this.b = bpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.f1145a.g;
        StatService.onEvent(activity, "ef_topic", "click");
        activity2 = this.f1145a.g;
        com.baidu.tieba.util.am.a(activity2, this.b.b, this.b.c);
    }
}
