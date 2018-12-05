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
    public List<h> bvL = new ArrayList();
    public int daL;

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
                    if (bbVar.getType() == bb.atv) {
                        this.bvL.add(bbVar);
                    }
                }
            }
            this.daL = dataRes.has_more.intValue();
        }
    }

    public List<h> aIJ() {
        return this.bvL;
    }

    public Integer aIK() {
        return Integer.valueOf(this.daL);
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] NX() {
        return new byte[0];
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void I(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean F(byte[] bArr) {
        return false;
    }
}
