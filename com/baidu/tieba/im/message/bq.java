package com.baidu.tieba.im.message;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.GetMaskInfo.GetMaskInfoRes;
/* loaded from: classes.dex */
public class bq extends cr implements com.baidu.tieba.im.coder.f {
    private int a;
    private String b;
    private ArrayList<com.baidu.tieba.im.data.a> c;

    public bq() {
        super(104103);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        GetMaskInfoRes.GetMaskInfoResIdl parseFrom = GetMaskInfoRes.GetMaskInfoResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
            a(parseFrom.getData().getIsMask());
            a(parseFrom.getData().getList());
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

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public ArrayList<com.baidu.tieba.im.data.a> b() {
        return this.c;
    }
}
