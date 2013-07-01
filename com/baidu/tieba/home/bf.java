package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TopicPagerAdapter f921a;
    private final /* synthetic */ com.baidu.tieba.data.bd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(TopicPagerAdapter topicPagerAdapter, com.baidu.tieba.data.bd bdVar) {
        this.f921a = topicPagerAdapter;
        this.b = bdVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.f921a.g;
        StatService.onEvent(context, "ef_topic", "click");
        this.f921a.a(this.b.b, this.b.c);
    }
}
