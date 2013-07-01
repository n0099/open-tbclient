package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TopicPagerAdapter f923a;
    private final /* synthetic */ com.baidu.tieba.data.bd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(TopicPagerAdapter topicPagerAdapter, com.baidu.tieba.data.bd bdVar) {
        this.f923a = topicPagerAdapter;
        this.b = bdVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.f923a.g;
        StatService.onEvent(context, "ef_topic", "click");
        this.f923a.a(this.b.b, this.b.c);
    }
}
