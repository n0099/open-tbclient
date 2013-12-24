package com.baidu.tieba.home;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ ForumTopicActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ForumTopicActivity forumTopicActivity) {
        this.a = forumTopicActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forum_topic_title_back /* 2131100166 */:
                this.a.finish();
                return;
            default:
                return;
        }
    }
}
