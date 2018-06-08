package com.baidu.tieba.easterEgg.c;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.easterEgg.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b extends k {
    private d cPK;
    private HashMap<String, String> cPL;
    private com.google.gson.d cPM;
    private SparseArray<String> cPN;

    public b(int i) {
        super(i);
        this.cPM = new com.google.gson.d();
        aoc();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.cPN.get(socketMessage.getCmd());
        if (str != null && this.cPL != null && this.cPL.get(str) != null && this.cPK != null) {
            this.cPK.A(str, this.cPM.toJson(this.cPL.get(str)), this.cPM.toJson(this.cPM.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void aoc() {
        int g;
        this.cPN = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!w.z(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ao.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ao.isEmpty(str) && str.contains("=") && (g = com.baidu.adp.lib.g.b.g(str.split("[=]")[1], 0)) != 0) {
                        this.cPN.put(g, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void l(HashMap<String, String> hashMap) {
        this.cPL = hashMap;
    }

    public void a(d dVar) {
        this.cPK = dVar;
    }
}
