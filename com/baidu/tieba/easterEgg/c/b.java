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
    private d cNF;
    private HashMap<String, String> cNG;
    private com.google.gson.d cNH;
    private SparseArray<String> cNI;

    public b(int i) {
        super(i);
        this.cNH = new com.google.gson.d();
        anw();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.cNI.get(socketMessage.getCmd());
        if (str != null && this.cNG != null && this.cNG.get(str) != null && this.cNF != null) {
            this.cNF.y(str, this.cNH.toJson(this.cNG.get(str)), this.cNH.toJson(this.cNH.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void anw() {
        int g;
        this.cNI = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!w.A(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ap.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ap.isEmpty(str) && str.contains("=") && (g = com.baidu.adp.lib.g.b.g(str.split("[=]")[1], 0)) != 0) {
                        this.cNI.put(g, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void l(HashMap<String, String> hashMap) {
        this.cNG = hashMap;
    }

    public void a(d dVar) {
        this.cNF = dVar;
    }
}
