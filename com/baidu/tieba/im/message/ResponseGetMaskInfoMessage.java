package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.GetMaskInfo.GetMaskInfoResIdl;
import protobuf.GetMaskInfo.UserInfo;
/* loaded from: classes.dex */
public class ResponseGetMaskInfoMessage extends SocketResponsedMessage {
    public static final int FALSE = 0;
    private ArrayList<com.baidu.tieba.im.data.a> blackList;
    private int isMask;
    private String list;

    public ResponseGetMaskInfoMessage() {
        super(MessageTypes.CMD_GET_MASK_INFO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetMaskInfoResIdl getMaskInfoResIdl = (GetMaskInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMaskInfoResIdl.class);
        setError(getMaskInfoResIdl.error.errorno.intValue());
        setErrorString(getMaskInfoResIdl.error.usermsg);
        if (getError() == 0) {
            this.blackList = new ArrayList<>();
            if (getMaskInfoResIdl.data != null) {
                setIsMask(getMaskInfoResIdl.data.isMask.intValue());
                setList(getMaskInfoResIdl.data.list);
                List<UserInfo> list = getMaskInfoResIdl.data.users;
                int size = list != null ? list.size() : 0;
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                    aVar.b(list.get(i2).portrait);
                    aVar.a(list.get(i2).uid.intValue());
                    aVar.a(list.get(i2).name);
                    this.blackList.add(aVar);
                }
            }
        }
    }

    public int getIsMask() {
        return this.isMask;
    }

    public void setIsMask(int i) {
        this.isMask = i;
    }

    public String getList() {
        return this.list;
    }

    public void setList(String str) {
        this.list = str;
    }

    public ArrayList<com.baidu.tieba.im.data.a> getBlackList() {
        return this.blackList;
    }

    public void setBlackList(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.blackList = arrayList;
    }
}
