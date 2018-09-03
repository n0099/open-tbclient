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
    private d cQl;
    private HashMap<String, String> cQm;
    private com.google.gson.d cQn;
    private SparseArray<String> cQo;

    public b(int i) {
        super(i);
        this.cQn = new com.google.gson.d();
        anV();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.cQo.get(socketMessage.getCmd());
        if (str != null && this.cQm != null && this.cQm.get(str) != null && this.cQl != null) {
            this.cQl.z(str, this.cQn.toJson(this.cQm.get(str)), this.cQn.toJson(this.cQn.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void anV() {
        int g;
        this.cQo = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!w.z(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ap.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ap.isEmpty(str) && str.contains("=") && (g = com.baidu.adp.lib.g.b.g(str.split("[=]")[1], 0)) != 0) {
                        this.cQo.put(g, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void n(HashMap<String, String> hashMap) {
        this.cQm = hashMap;
    }

    public void a(d dVar) {
        this.cQl = dVar;
    }
}
