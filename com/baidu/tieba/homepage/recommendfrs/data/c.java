package com.baidu.tieba.homepage.recommendfrs.data;

import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ExcFrsPage.ExcFrsPageResIdl;
import tbclient.ExcFrsPage.ExcellentTagInfo;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.b.b, j {
    protected List<Object> cCr;
    protected boolean cCs = true;
    protected List<Object> cxu;
    protected boolean mHasMore;
    protected int pn;

    public int getPn() {
        return this.pn;
    }

    public boolean isEmpty() {
        return this.cxu == null || this.cxu.size() <= 0 || this.cCr == null || this.cCr.size() <= 0;
    }

    public List<Object> getThreadList() {
        return this.cCr;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void m(JSONObject jSONObject) {
    }

    public void a(Message message) {
        ExcFrsPageResIdl excFrsPageResIdl;
        if ((message instanceof ExcFrsPageResIdl) && (excFrsPageResIdl = (ExcFrsPageResIdl) message) != null && excFrsPageResIdl.error != null && excFrsPageResIdl.error.errorno.intValue() == 0 && excFrsPageResIdl.data != null) {
            if (excFrsPageResIdl.data.thread_list != null) {
                this.cCr = new ArrayList();
                this.cCr.addAll(excFrsPageResIdl.data.thread_list);
            }
            this.mHasMore = excFrsPageResIdl.data.has_more.intValue() == 1;
            this.pn = excFrsPageResIdl.data.pn.intValue();
            if (excFrsPageResIdl.data.tag_list != null) {
                this.cxu = new ArrayList();
                for (ExcellentTagInfo excellentTagInfo : excFrsPageResIdl.data.tag_list) {
                    if (excellentTagInfo != null) {
                        this.cxu.add(excellentTagInfo);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Ff() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean z(byte[] bArr) {
        try {
            a((ExcFrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcFrsPageResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean akR() {
        return this.cCs;
    }
}
