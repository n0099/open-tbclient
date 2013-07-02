package com.baidu.tieba.home;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ ForumTopicActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ForumTopicActivity forumTopicActivity) {
        this.a = forumTopicActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forum_topic_title_back /* 2131099998 */:
                this.a.finish();
                return;
            default:
                return;
        }
    }
}
