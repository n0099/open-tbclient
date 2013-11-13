package com.baidu.tieba.home;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumTopicActivity f1467a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ForumTopicActivity forumTopicActivity) {
        this.f1467a = forumTopicActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forum_topic_title_back /* 2131100159 */:
                this.f1467a.finish();
                return;
            default:
                return;
        }
    }
}
