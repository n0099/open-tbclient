package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import protobuf.QueryGroupLocation.QueryGroupLocationResIdl;
/* loaded from: classes3.dex */
public class ResponseRequestGroupLocMessage extends SocketResponsedMessage {
    private List<String> businessAreaList;
    private String position;

    public ResponseRequestGroupLocMessage() {
        super(103010);
        this.position = "";
        this.businessAreaList = new ArrayList();
    }

    public void setPosition(String str) {
        if (str != null) {
            this.position = str;
        }
    }

    public String getPosition() {
        return this.position;
    }

    public void addBusinessArea(String str) {
        if (str != null && !str.equals("") && !this.businessAreaList.contains(str)) {
            this.businessAreaList.add(str);
        }
    }

    public Iterator<String> getIteraotrOfBusinessAreaList() {
        return this.businessAreaList.iterator();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryGroupLocationResIdl queryGroupLocationResIdl = (QueryGroupLocationResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupLocationResIdl.class);
        setError(queryGroupLocationResIdl.error.errorno.intValue());
        setErrorString(queryGroupLocationResIdl.error.usermsg);
        if (queryGroupLocationResIdl.data.business != null) {
            for (String str : queryGroupLocationResIdl.data.business) {
                addBusinessArea(str);
            }
        }
    }
}
