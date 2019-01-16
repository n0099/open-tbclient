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
    private d bHG;
    private com.baidu.tieba.easterEgg.d dpL;
    private HashMap<String, String> dpM;
    private SparseArray<String> dpN;

    public b(int i) {
        super(i);
        this.bHG = new d();
        avG();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.dpN.get(socketMessage.getCmd());
        if (str != null && this.dpM != null && this.dpM.get(str) != null && this.dpL != null) {
            this.dpL.H(str, this.bHG.toJson(this.dpM.get(str)), this.bHG.toJson(this.bHG.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void avG() {
        int l;
        this.dpN = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.I(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ao.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ao.isEmpty(str) && str.contains(ETAG.EQUAL) && (l = com.baidu.adp.lib.g.b.l(str.split("[=]")[1], 0)) != 0) {
                        this.dpN.put(l, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void q(HashMap<String, String> hashMap) {
        this.dpM = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.dpL = dVar;
    }
}
