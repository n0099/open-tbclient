package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import java.io.Serializable;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes4.dex */
public class RelateForumItemData implements Serializable, n {
    public static final BdUniqueId TYPE_FORUM_CARD = BdUniqueId.gen();
    public static final long serialVersionUID = 1;
    public long forumId = 0;
    public String forumName = null;
    public String forumAvatar = null;
    public String forumAbstract = null;
    public long threadNum = 0;
    public long postNum = 0;
    public long followNum = 0;
    public boolean isLiked = false;

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return TYPE_FORUM_CARD;
    }

    public void parserProtobuf(RelateForum relateForum) {
        if (relateForum == null) {
            return;
        }
        this.forumId = relateForum.forum_id.intValue();
        this.forumName = relateForum.forum_name;
        this.forumAvatar = relateForum.avatar;
        this.forumAbstract = relateForum.desc;
        this.threadNum = relateForum.thread_num.intValue();
        this.postNum = relateForum.post_num.intValue();
        this.followNum = relateForum.member_num.intValue();
        this.isLiked = relateForum.is_liked.intValue() != 0;
    }

    public void setIsLiked(boolean z) {
        this.isLiked = z;
    }
}
