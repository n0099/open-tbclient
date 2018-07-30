package com.baidu.tieba.frs.worldcup.videotopic.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VideoTopicList.DataRes;
import tbclient.VideoTopicList.VideoTopicListResIdl;
/* loaded from: classes3.dex */
public class c implements com.baidu.tbadk.mvc.b.c {
    public List<h> bhF = new ArrayList();
    public int cEP;

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
                    bb bbVar = new bb();
                    bbVar.a(threadInfo);
                    if (bbVar.getType() == bb.ahM) {
                        this.bhF.add(bbVar);
                    }
                }
            }
            this.cEP = dataRes.has_more.intValue();
        }
    }

    public List<h> aBX() {
        return this.bhF;
    }

    public Integer aBY() {
        return Integer.valueOf(this.cEP);
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Js() {
        return new byte[0];
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void u(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean y(byte[] bArr) {
        return false;
    }
}
