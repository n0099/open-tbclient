package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import protobuf.GetMaskInfo.GetMaskInfoRes;
/* loaded from: classes.dex */
public class ResponseGetMaskInfoMessage extends SocketResponsedMessage {
    private int a;
    private String b;
    private ArrayList<com.baidu.tieba.im.data.a> c;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        GetMaskInfoRes.GetMaskInfoResIdl parseFrom = GetMaskInfoRes.GetMaskInfoResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = parseFrom.getData().getIsMask();
            this.b = parseFrom.getData().getList();
            List<GetMaskInfoRes.UserInfo> usersList = parseFrom.getData().getUsersList();
            int size = usersList != null ? usersList.size() : 0;
            this.c = new ArrayList<>();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                aVar.b(usersList.get(i2).getPortrait());
                aVar.a(usersList.get(i2).getUid());
                aVar.a(usersList.get(i2).getName());
                this.c.add(aVar);
            }
        }
    }

    public ResponseGetMaskInfoMessage() {
        super(104103);
    }

    public final int d() {
        return this.a;
    }

    public final ArrayList<com.baidu.tieba.im.data.a> i() {
        return this.c;
    }
}
