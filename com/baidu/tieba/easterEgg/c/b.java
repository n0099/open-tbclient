package com.baidu.tieba.easterEgg.c;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.google.gson.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b extends k {
    private d cTc;
    private com.baidu.tieba.easterEgg.d ezq;
    private HashMap<String, String> ezr;
    private SparseArray<String> ezs;

    public b(int i) {
        super(i);
        this.cTc = new d();
        aVv();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.ezs.get(socketMessage.getCmd());
        if (str != null && this.ezr != null && this.ezr.get(str) != null && this.ezq != null) {
            this.ezq.S(str, this.cTc.toJson(this.ezr.get(str)), this.cTc.toJson(this.cTc.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void aVv() {
        int l;
        this.ezs = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.T(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ap.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ap.isEmpty(str) && str.contains("=") && (l = com.baidu.adp.lib.g.b.l(str.split("[=]")[1], 0)) != 0) {
                        this.ezs.put(l, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void r(HashMap<String, String> hashMap) {
        this.ezr = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.ezq = dVar;
    }
}
