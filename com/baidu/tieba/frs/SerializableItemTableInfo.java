package com.baidu.tieba.frs;

import java.io.Serializable;
import tbclient.ItemTable;
/* loaded from: classes2.dex */
public class SerializableItemTableInfo implements Serializable {
    public int commentStar;
    public int isCommented;

    public SerializableItemTableInfo(ItemTable itemTable) {
        if (itemTable != null) {
            this.isCommented = itemTable.is_commented.intValue();
            this.commentStar = itemTable.comment_star.intValue();
        }
    }

    public int getIsCommented() {
        return this.isCommented;
    }

    public void setIsCommented(int i) {
        this.isCommented = i;
    }

    public int getCommentStar() {
        return this.commentStar;
    }

    public void setCommentStar(int i) {
        this.commentStar = i;
    }
}
