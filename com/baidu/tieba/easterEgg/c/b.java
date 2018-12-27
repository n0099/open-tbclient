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
    private d bGT;
    private com.baidu.tieba.easterEgg.d doZ;
    private HashMap<String, String> dpa;
    private SparseArray<String> dpb;

    public b(int i) {
        super(i);
        this.bGT = new d();
        avi();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.dpb.get(socketMessage.getCmd());
        if (str != null && this.dpa != null && this.dpa.get(str) != null && this.doZ != null) {
            this.doZ.H(str, this.bGT.toJson(this.dpa.get(str)), this.bGT.toJson(this.bGT.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void avi() {
        int l;
        this.dpb = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.I(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ao.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ao.isEmpty(str) && str.contains(ETAG.EQUAL) && (l = com.baidu.adp.lib.g.b.l(str.split("[=]")[1], 0)) != 0) {
                        this.dpb.put(l, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void q(HashMap<String, String> hashMap) {
        this.dpa = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.doZ = dVar;
    }
}
