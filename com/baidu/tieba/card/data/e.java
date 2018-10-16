package com.baidu.tieba.card.data;
/* loaded from: classes6.dex */
public class e implements com.baidu.tieba.horizonalList.widget.c {
    public String forumAvatar;
    public long forumId;
    public String forumName;
    public boolean isLiked;
    public int rank;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof com.baidu.tbadk.widget.horizonalScrollListView.a) {
            com.baidu.tbadk.widget.horizonalScrollListView.a aVar = (com.baidu.tbadk.widget.horizonalScrollListView.a) obj;
            return aVar.forumId == this.forumId && aVar.forumName.equals(this.forumName) && aVar.forumAvatar.equals(this.forumAvatar) && aVar.isLiked == this.isLiked && aVar.rank == this.rank;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[HotForumInfoData:");
        sb.append("rank=").append(this.rank).append(",");
        sb.append("forumAvatar=").append(this.forumAvatar).append(",");
        sb.append("forumName=").append(this.forumName).append(",");
        sb.append("forumId=").append(this.forumId).append(",");
        sb.append("isLiked=").append(this.isLiked).append(",");
        sb.append("]");
        return sb.toString();
    }
}
