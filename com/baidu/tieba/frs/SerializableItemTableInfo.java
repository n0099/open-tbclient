package com.baidu.tieba.frs;

import java.io.Serializable;
import tbclient.ItemTable;
/* loaded from: classes4.dex */
public class SerializableItemTableInfo implements Serializable {
    public int commentStar;
    public int isCommented;

    public SerializableItemTableInfo(ItemTable itemTable) {
        if (itemTable == null) {
            return;
        }
        this.isCommented = itemTable.is_commented.intValue();
        this.commentStar = itemTable.comment_star.intValue();
    }

    public int getCommentStar() {
        return this.commentStar;
    }

    public int getIsCommented() {
        return this.isCommented;
    }

    public void setCommentStar(int i2) {
        this.commentStar = i2;
    }

    public void setIsCommented(int i2) {
        this.isCommented = i2;
    }
}
