package com.baidu.tbadk.widget.a;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class a {
    public String forumAvatar;
    public long forumId;
    public String forumName;
    public boolean isLiked;
    public int rank;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.forumId == this.forumId && aVar.forumName.equals(this.forumName) && aVar.forumAvatar.equals(this.forumAvatar) && aVar.isLiked == this.isLiked && aVar.rank == this.rank;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[HotForumInfoData:");
        sb.append("rank=").append(this.rank).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("forumAvatar=").append(this.forumAvatar).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("forumName=").append(this.forumName).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("forumId=").append(this.forumId).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("isLiked=").append(this.isLiked).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("]");
        return sb.toString();
    }
}
