package com.baidu.tieba.easterEgg.c;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.webkit.internal.ETAG;
import com.google.gson.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b extends k {
    private d bCB;
    private com.baidu.tieba.easterEgg.d dev;
    private HashMap<String, String> dew;
    private SparseArray<String> dex;

    public b(int i) {
        super(i);
        this.bCB = new d();
        ati();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.dex.get(socketMessage.getCmd());
        if (str != null && this.dew != null && this.dew.get(str) != null && this.dev != null) {
            this.dev.G(str, this.bCB.toJson(this.dew.get(str)), this.bCB.toJson(this.bCB.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void ati() {
        int l;
        this.dex = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.J(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ao.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ao.isEmpty(str) && str.contains(ETAG.EQUAL) && (l = com.baidu.adp.lib.g.b.l(str.split("[=]")[1], 0)) != 0) {
                        this.dex.put(l, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void r(HashMap<String, String> hashMap) {
        this.dew = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.dev = dVar;
    }
}
