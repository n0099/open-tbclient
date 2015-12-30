package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.MagicPost;
import tbclient.Hottopic.MagicPostList;
/* loaded from: classes.dex */
public class g implements u {
    public static final BdUniqueId bHH = BdUniqueId.gen();
    private boolean bHI = false;
    public String bHJ = null;
    public long threadId = 0;
    public long postId = 0;
    public String Ve = null;
    public String bHK = null;
    public String bHL = null;
    public long bHM = 0;
    public long bHN = 0;
    public String bHO = null;
    public Integer bHP = 0;
    public boolean bHQ = false;
    public long bHR = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bHH;
    }

    public boolean VD() {
        return this.bHI;
    }

    public void a(MagicPostList magicPostList) {
        if (magicPostList != null) {
            this.bHI = false;
            this.threadId = magicPostList.thread_id.longValue();
            this.postId = magicPostList.post_id.longValue();
            this.bHN = magicPostList.create_time.intValue();
            this.bHQ = magicPostList.is_comment.intValue() != 0;
            this.bHO = magicPostList.content_text;
            if (magicPostList.user_info != null) {
                this.bHL = magicPostList.user_info.user_name;
                this.bHK = magicPostList.user_info.portrait;
                this.bHM = magicPostList.user_info.user_id.longValue();
            }
            if (this.bHQ && magicPostList.quote != null) {
                this.bHR = magicPostList.quote.post_id.longValue();
            }
        }
    }

    public void a(MagicPost magicPost) {
        if (magicPost != null) {
            this.bHJ = magicPost.magic_title;
            this.bHI = true;
        }
    }
}
