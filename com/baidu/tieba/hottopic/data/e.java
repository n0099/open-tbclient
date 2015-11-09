package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.MagicPost;
import tbclient.Hottopic.MagicPostList;
/* loaded from: classes.dex */
public class e implements u {
    public static final BdUniqueId bpF = BdUniqueId.gen();
    private boolean bpG = false;
    public String bpH = null;
    public long threadId = 0;
    public long postId = 0;
    public String Un = null;
    public String bpI = null;
    public String bpJ = null;
    public long bpK = 0;
    public long bpL = 0;
    public String bpM = null;
    public Integer bpN = 0;
    public boolean bpO = false;
    public long bpP = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bpF;
    }

    public boolean Rp() {
        return this.bpG;
    }

    public void a(MagicPostList magicPostList) {
        if (magicPostList != null) {
            this.bpG = false;
            this.threadId = magicPostList.thread_id.longValue();
            this.postId = magicPostList.post_id.longValue();
            this.bpL = magicPostList.create_time.intValue();
            this.bpO = magicPostList.is_comment.intValue() != 0;
            this.bpM = magicPostList.content_text;
            if (magicPostList.user_info != null) {
                this.bpJ = magicPostList.user_info.user_name;
                this.bpI = magicPostList.user_info.portrait;
                this.bpK = magicPostList.user_info.user_id.longValue();
            }
            if (this.bpO && magicPostList.quote != null) {
                this.bpP = magicPostList.quote.post_id.longValue();
            }
        }
    }

    public void a(MagicPost magicPost) {
        if (magicPost != null) {
            this.bpH = magicPost.magic_title;
            this.bpG = true;
        }
    }
}
