package com.baidu.tieba.frs.worldcup.videotopic.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bd;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VideoTopicList.DataRes;
import tbclient.VideoTopicList.VideoTopicListResIdl;
/* loaded from: classes2.dex */
public class c implements com.baidu.tbadk.mvc.b.c {
    public List<h> bfM = new ArrayList();
    public int cEr;

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
                    bd bdVar = new bd();
                    bdVar.a(threadInfo);
                    if (bdVar.getType() == bd.ahX) {
                        this.bfM.add(bdVar);
                    }
                }
            }
            this.cEr = dataRes.has_more.intValue();
        }
    }

    public List<h> aAH() {
        return this.bfM;
    }

    public Integer aAI() {
        return Integer.valueOf(this.cEr);
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Jf() {
        return new byte[0];
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void v(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean z(byte[] bArr) {
        return false;
    }
}
