package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.BlackListItemData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.GetMaskInfo.DataRes;
import protobuf.GetMaskInfo.GetMaskInfoResIdl;
import protobuf.GetMaskInfo.UserInfo;
/* loaded from: classes4.dex */
public class ResponseGetMaskInfoMessage extends SocketResponsedMessage {
    public static final int FALSE = 0;
    public ArrayList<BlackListItemData> blackList;
    public int isMask;
    public String list;

    public ResponseGetMaskInfoMessage() {
        super(104103);
    }

    public ArrayList<BlackListItemData> getBlackList() {
        return this.blackList;
    }

    public int getIsMask() {
        return this.isMask;
    }

    public String getList() {
        return this.list;
    }

    public boolean isMask() {
        return this.isMask != 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetMaskInfoResIdl getMaskInfoResIdl = (GetMaskInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMaskInfoResIdl.class);
        setError(getMaskInfoResIdl.error.errorno.intValue());
        setErrorString(getMaskInfoResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.blackList = new ArrayList<>();
        DataRes dataRes = getMaskInfoResIdl.data;
        if (dataRes != null) {
            this.isMask = dataRes.isMask.intValue();
            DataRes dataRes2 = getMaskInfoResIdl.data;
            this.list = dataRes2.list;
            List<UserInfo> list = dataRes2.users;
            int size = list != null ? list.size() : 0;
            for (int i3 = 0; i3 < size; i3++) {
                BlackListItemData blackListItemData = new BlackListItemData();
                blackListItemData.u(list.get(i3).portrait);
                blackListItemData.setUserId(list.get(i3).uid.longValue());
                blackListItemData.setUserName(list.get(i3).name);
                blackListItemData.v(list.get(i3).nameShow);
                this.blackList.add(blackListItemData);
            }
        }
    }
}
