package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupPermData;
/* loaded from: classes.dex */
public class ResponseUserPermissionMessage extends ResponsedMessage {
    private static final long serialVersionUID = -927536214464147215L;
    private GroupPermData groupPermData;

    public ResponseUserPermissionMessage() {
    }

    public ResponseUserPermissionMessage(int i) {
        super(i);
    }

    public GroupPermData getGroupPermData() {
        return this.groupPermData;
    }

    public void setGroupPermData(GroupPermData groupPermData) {
        this.groupPermData = groupPermData;
    }
}
