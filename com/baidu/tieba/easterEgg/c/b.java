package com.baidu.tieba.easterEgg.c;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.easterEgg.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b extends k {
    private d eTU;
    private HashMap<String, String> eTV;
    private com.google.gson.d eTW;
    private SparseArray<String> eTX;

    public b(int i) {
        super(i);
        this.eTW = new com.google.gson.d();
        beI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.eTX.get(socketMessage.getCmd());
        if (str != null && this.eTV != null && this.eTV.get(str) != null && this.eTU != null) {
            this.eTU.S(str, this.eTW.toJson(this.eTV.get(str)), this.eTW.toJson(this.eTW.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void beI() {
        int f;
        this.eTX = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.aa(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!aq.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!aq.isEmpty(str) && str.contains("=") && (f = com.baidu.adp.lib.g.b.f(str.split("[=]")[1], 0)) != 0) {
                        this.eTX.put(f, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void r(HashMap<String, String> hashMap) {
        this.eTV = hashMap;
    }

    public void a(d dVar) {
        this.eTU = dVar;
    }
}
