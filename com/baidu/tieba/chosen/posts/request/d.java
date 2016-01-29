package com.baidu.tieba.chosen.posts.request;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.HotThread.HotThreadResIdl;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.mvc.b.b, j {
    private Error error;
    private List<tinfo> list;

    public List<tinfo> KO() {
        if (this.list == null || this.list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tinfo tinfoVar : this.list) {
            if (c(tinfoVar)) {
                arrayList.add(tinfoVar);
            }
        }
        return arrayList;
    }

    private boolean c(tinfo tinfoVar) {
        if (tinfoVar == null) {
            return false;
        }
        if (tinfoVar.pics == null || tinfoVar.pics.size() <= 0) {
            String str = tinfoVar.title;
            String str2 = tinfoVar._abstract;
            if (StringUtils.isNull(str) && StringUtils.isNull(str2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void g(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
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
    public boolean Q(byte[] bArr) {
        try {
            a((HotThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, HotThreadResIdl.class));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] EA() {
        return null;
    }
}
