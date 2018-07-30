package com.baidu.tieba.easterEgg.c;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.easterEgg.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b extends k {
    private d cQo;
    private HashMap<String, String> cQp;
    private com.google.gson.d cQq;
    private SparseArray<String> cQr;

    public b(int i) {
        super(i);
        this.cQq = new com.google.gson.d();
        anV();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.cQr.get(socketMessage.getCmd());
        if (str != null && this.cQp != null && this.cQp.get(str) != null && this.cQo != null) {
            this.cQo.z(str, this.cQq.toJson(this.cQp.get(str)), this.cQq.toJson(this.cQq.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void anV() {
        int g;
        this.cQr = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!w.z(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ap.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ap.isEmpty(str) && str.contains("=") && (g = com.baidu.adp.lib.g.b.g(str.split("[=]")[1], 0)) != 0) {
                        this.cQr.put(g, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void n(HashMap<String, String> hashMap) {
        this.cQp = hashMap;
    }

    public void a(d dVar) {
        this.cQo = dVar;
    }
}
