package com.baidu.tieba.home;

import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumTopicActivity f1149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ForumTopicActivity forumTopicActivity) {
        this.f1149a = forumTopicActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forum_topic_title_back /* 2131100059 */:
                this.f1149a.finish();
                return;
            default:
                return;
        }
    }
}
