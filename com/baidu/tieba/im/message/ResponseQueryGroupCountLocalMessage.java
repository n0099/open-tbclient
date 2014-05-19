package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.QueryGroupCount.QueryGroupCountResIdl;
/* loaded from: classes.dex */
public class ResponseQueryGroupCountLocalMessage extends CustomResponsedMessage<Object> {
    private String link;
    private int localGroupCount;
    private String picUrl;
    private int userGroupCount;

    public ResponseQueryGroupCountLocalMessage() {
        super(MessageTypes.CMD_REQUEST_GROUP_COUNT_LOCAL);
    }

    public ResponseQueryGroupCountLocalMessage(int i) {
        super(i);
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public int getUserGroupCount() {
        return this.userGroupCount;
    }

    public void setUserGroupCount(int i) {
        this.userGroupCount = i;
    }

    public int getLocalGroupCount() {
        return this.localGroupCount;
    }

    public void setLocalGroupCount(int i) {
        this.localGroupCount = i;
    }

    public void decodeInBackGround(int i, byte[] bArr) {
        QueryGroupCountResIdl queryGroupCountResIdl = (QueryGroupCountResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupCountResIdl.class);
        setError(queryGroupCountResIdl.error.errorno.intValue());
        setErrorString(queryGroupCountResIdl.error.usermsg);
        if (getError() == 0) {
            setLocalGroupCount(queryGroupCountResIdl.data.localGroupCount.intValue());
            setUserGroupCount(queryGroupCountResIdl.data.userGroupCount.intValue());
            if (queryGroupCountResIdl.data.banner != null) {
                setPicUrl(queryGroupCountResIdl.data.banner.picUrl);
                setLink(queryGroupCountResIdl.data.banner.link);
            }
        }
    }
}
