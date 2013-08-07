package com.baidu.tieba.home;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumTopicActivity f1157a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ForumTopicActivity forumTopicActivity) {
        this.f1157a = forumTopicActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forum_topic_title_back /* 2131100019 */:
                this.f1157a.finish();
                return;
            default:
                return;
        }
    }
}
