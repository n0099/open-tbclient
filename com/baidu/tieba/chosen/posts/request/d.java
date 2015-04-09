package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.mvc.b.k;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.List;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.HotThread.HotThreadResIdl;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.mvc.b.b, k {
    private Error error;
    private List<tinfo> list;

    public List<tinfo> FU() {
        return this.list;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void c(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void a(Message message) {
        if (message instanceof HotThreadResIdl) {
            HotThreadResIdl hotThreadResIdl = (HotThreadResIdl) message;
            this.error = hotThreadResIdl.error;
            this.list = hotThreadResIdl.data.hot_thread;
        }
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "chosen_post_cache";
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean A(byte[] bArr) {
        try {
            a((HotThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, HotThreadResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] AC() {
        return null;
    }
}
