package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.io.Serializable;
import tbclient.GuessLikeThreadInfo;
/* loaded from: classes6.dex */
public class CardHListViewNormalItemData implements com.baidu.adp.widget.ListView.h, Serializable {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private static final long serialVersionUID = 9123181123453164969L;
    public long forumId;
    public String forumName;
    public String recomCover;
    public String recomReason;
    public long replyNum;
    public long threadId;
    public String title;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }

    public void parseProtobuf(GuessLikeThreadInfo guessLikeThreadInfo) {
        if (guessLikeThreadInfo != null) {
            this.title = guessLikeThreadInfo.title;
            this.forumId = guessLikeThreadInfo.forum_id.longValue();
            this.threadId = guessLikeThreadInfo.thread_id.longValue();
            this.replyNum = guessLikeThreadInfo.reply_num.longValue();
            this.forumName = guessLikeThreadInfo.forum_name;
            this.recomCover = guessLikeThreadInfo.recom_cover;
            this.recomReason = guessLikeThreadInfo.recom_reason;
        }
    }
}
