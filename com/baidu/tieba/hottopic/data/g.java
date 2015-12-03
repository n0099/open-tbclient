package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.MagicPost;
import tbclient.Hottopic.MagicPostList;
/* loaded from: classes.dex */
public class g implements u {
    public static final BdUniqueId bEe = BdUniqueId.gen();
    private boolean bEf = false;
    public String bEg = null;
    public long threadId = 0;
    public long postId = 0;
    public String UD = null;
    public String bEh = null;
    public String bEi = null;
    public long bEj = 0;
    public long bEk = 0;
    public String bEl = null;
    public Integer bEm = 0;
    public boolean bEn = false;
    public long bEo = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bEe;
    }

    public boolean UA() {
        return this.bEf;
    }

    public void a(MagicPostList magicPostList) {
        if (magicPostList != null) {
            this.bEf = false;
            this.threadId = magicPostList.thread_id.longValue();
            this.postId = magicPostList.post_id.longValue();
            this.bEk = magicPostList.create_time.intValue();
            this.bEn = magicPostList.is_comment.intValue() != 0;
            this.bEl = magicPostList.content_text;
            if (magicPostList.user_info != null) {
                this.bEi = magicPostList.user_info.user_name;
                this.bEh = magicPostList.user_info.portrait;
                this.bEj = magicPostList.user_info.user_id.longValue();
            }
            if (this.bEn && magicPostList.quote != null) {
                this.bEo = magicPostList.quote.post_id.longValue();
            }
        }
    }

    public void a(MagicPost magicPost) {
        if (magicPost != null) {
            this.bEg = magicPost.magic_title;
            this.bEf = true;
        }
    }
}
