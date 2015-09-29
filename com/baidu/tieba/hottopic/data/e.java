package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.MagicPost;
import tbclient.Hottopic.MagicPostList;
/* loaded from: classes.dex */
public class e implements u {
    public static final BdUniqueId boQ = BdUniqueId.gen();
    private boolean boR = false;
    public String boS = null;
    public long threadId = 0;
    public long postId = 0;
    public String Ul = null;
    public String boT = null;
    public String boU = null;
    public long boV = 0;
    public long boW = 0;
    public String boX = null;
    public Integer boY = 0;
    public boolean boZ = false;
    public long bpa = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return boQ;
    }

    public boolean QX() {
        return this.boR;
    }

    public void a(MagicPostList magicPostList) {
        if (magicPostList != null) {
            this.boR = false;
            this.threadId = magicPostList.thread_id.longValue();
            this.postId = magicPostList.post_id.longValue();
            this.boW = magicPostList.create_time.intValue();
            this.boZ = magicPostList.is_comment.intValue() != 0;
            this.boX = magicPostList.content_text;
            if (magicPostList.user_info != null) {
                this.boU = magicPostList.user_info.user_name;
                this.boT = magicPostList.user_info.portrait;
                this.boV = magicPostList.user_info.user_id.longValue();
            }
            if (this.boZ && magicPostList.quote != null) {
                this.bpa = magicPostList.quote.post_id.longValue();
            }
        }
    }

    public void a(MagicPost magicPost) {
        if (magicPost != null) {
            this.boS = magicPost.magic_title;
            this.boR = true;
        }
    }
}
