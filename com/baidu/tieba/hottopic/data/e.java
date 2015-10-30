package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.MagicPost;
import tbclient.Hottopic.MagicPostList;
/* loaded from: classes.dex */
public class e implements u {
    public static final BdUniqueId bpb = BdUniqueId.gen();
    private boolean bpc = false;
    public String bpd = null;
    public long threadId = 0;
    public long postId = 0;
    public String Um = null;
    public String bpe = null;
    public String bpf = null;
    public long bpg = 0;
    public long bph = 0;
    public String bpi = null;
    public Integer bpj = 0;
    public boolean bpk = false;
    public long bpl = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bpb;
    }

    public boolean QT() {
        return this.bpc;
    }

    public void a(MagicPostList magicPostList) {
        if (magicPostList != null) {
            this.bpc = false;
            this.threadId = magicPostList.thread_id.longValue();
            this.postId = magicPostList.post_id.longValue();
            this.bph = magicPostList.create_time.intValue();
            this.bpk = magicPostList.is_comment.intValue() != 0;
            this.bpi = magicPostList.content_text;
            if (magicPostList.user_info != null) {
                this.bpf = magicPostList.user_info.user_name;
                this.bpe = magicPostList.user_info.portrait;
                this.bpg = magicPostList.user_info.user_id.longValue();
            }
            if (this.bpk && magicPostList.quote != null) {
                this.bpl = magicPostList.quote.post_id.longValue();
            }
        }
    }

    public void a(MagicPost magicPost) {
        if (magicPost != null) {
            this.bpd = magicPost.magic_title;
            this.bpc = true;
        }
    }
}
