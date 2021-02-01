package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.im.data.BlackListItemData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.GetMaskInfo.GetMaskInfoResIdl;
import protobuf.GetMaskInfo.UserInfo;
/* loaded from: classes.dex */
public class ResponseGetMaskInfoMessage extends SocketResponsedMessage {
    public static final int FALSE = 0;
    private ArrayList<BlackListItemData> blackList;
    private int isMask;
    private String list;

    public ResponseGetMaskInfoMessage() {
        super(CmdConfigSocket.CMD_GET_MASK_INFO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetMaskInfoResIdl getMaskInfoResIdl = (GetMaskInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMaskInfoResIdl.class);
        setError(getMaskInfoResIdl.error.errorno.intValue());
        setErrorString(getMaskInfoResIdl.error.usermsg);
        if (getError() == 0) {
            this.blackList = new ArrayList<>();
            if (getMaskInfoResIdl.data != null) {
                this.isMask = getMaskInfoResIdl.data.isMask.intValue();
                this.list = getMaskInfoResIdl.data.list;
                List<UserInfo> list = getMaskInfoResIdl.data.users;
                int size = list != null ? list.size() : 0;
                for (int i2 = 0; i2 < size; i2++) {
                    BlackListItemData blackListItemData = new BlackListItemData();
                    blackListItemData.iP(list.get(i2).portrait);
                    blackListItemData.setUserId(list.get(i2).uid.longValue());
                    blackListItemData.setUserName(list.get(i2).name);
                    blackListItemData.Cj(list.get(i2).nameShow);
                    this.blackList.add(blackListItemData);
                }
            }
        }
    }

    public int getIsMask() {
        return this.isMask;
    }

    public boolean isMask() {
        return this.isMask != 0;
    }

    public String getList() {
        return this.list;
    }

    public ArrayList<BlackListItemData> getBlackList() {
        return this.blackList;
    }
}
