package com.baidu.tieba.im.forum.broadcast;

import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
/* loaded from: classes8.dex */
public interface a extends f.c {
    void a(ErrorData errorData);

    void a(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData);

    void a(com.baidu.tieba.im.forum.broadcast.data.a aVar);

    void bRc();

    void refresh();
}
