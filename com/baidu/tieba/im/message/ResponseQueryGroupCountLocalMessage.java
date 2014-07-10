package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.QueryGroupCount.QueryGroupCountResIdl;
/* loaded from: classes.dex */
public class ResponseQueryGroupCountLocalMessage extends CustomResponsedMessage<Object> {
    private String geographicLocation;
    private String link;
    private int localGroupCount;
    private String picUrl;
    private int userGroupCount;

    public ResponseQueryGroupCountLocalMessage() {
        super(2001114);
        this.geographicLocation = "";
    }

    public ResponseQueryGroupCountLocalMessage(int i) {
        super(i);
        this.geographicLocation = "";
    }

    public String getGeographicLocation() {
        return this.geographicLocation;
    }

    public String getLink() {
        return this.link;
    }

    public String getPicUrl() {
        return this.picUrl;
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
            this.localGroupCount = queryGroupCountResIdl.data.localGroupCount.intValue();
            this.userGroupCount = queryGroupCountResIdl.data.userGroupCount.intValue();
            this.geographicLocation = queryGroupCountResIdl.data.position;
            if (queryGroupCountResIdl.data.banner != null) {
                this.picUrl = queryGroupCountResIdl.data.banner.picUrl;
                this.link = queryGroupCountResIdl.data.banner.link;
            }
        }
    }
}
