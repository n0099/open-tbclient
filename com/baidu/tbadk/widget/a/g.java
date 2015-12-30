package com.baidu.tbadk.widget.a;
/* loaded from: classes.dex */
public class g {
    public String forumAvatar;
    public long forumId;
    public String forumName;
    public boolean isLiked;
    public int rank;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return gVar.forumId == this.forumId && gVar.forumName.equals(this.forumName) && gVar.forumAvatar.equals(this.forumAvatar) && gVar.isLiked == this.isLiked && gVar.rank == this.rank;
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
