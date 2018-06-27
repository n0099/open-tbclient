package com.baidu.tieba.frs.worldcup.videotopic.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bc;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VideoTopicList.DataRes;
import tbclient.VideoTopicList.VideoTopicListResIdl;
/* loaded from: classes2.dex */
public class c implements com.baidu.tbadk.mvc.b.c {
    public List<h> bha = new ArrayList();
    public int cCk;

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        if (message != null && (message instanceof VideoTopicListResIdl)) {
            a(((VideoTopicListResIdl) message).data);
        }
    }

    private void a(DataRes dataRes) {
        if (dataRes != null) {
            List<ThreadInfo> list = dataRes.thread_list;
            if (list != null) {
                for (ThreadInfo threadInfo : list) {
                    bc bcVar = new bc();
                    bcVar.a(threadInfo);
                    if (bcVar.getType() == bc.aiq) {
                        this.bha.add(bcVar);
                    }
                }
            }
            this.cCk = dataRes.has_more.intValue();
        }
    }

    public List<h> aBo() {
        return this.bha;
    }

    public Integer aBp() {
        return Integer.valueOf(this.cCk);
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Jx() {
        return new byte[0];
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void v(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean A(byte[] bArr) {
        return false;
    }
}
