package com.baidu.tieba.easterEgg.c;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.b.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.easterEgg.c;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b extends k {
    private Gson eLm;
    private c iEr;
    private HashMap<String, String> iEs;
    private SparseArray<String> iEt;

    public b(int i) {
        super(i);
        this.eLm = new Gson();
        cxd();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.iEt.get(socketMessage.getCmd());
        if (str != null && this.iEs != null && this.iEs.get(str) != null && this.iEr != null) {
            this.iEr.aE(str, this.eLm.toJson(this.iEs.get(str)), this.eLm.toJson(this.eLm.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void cxd() {
        int i;
        this.iEt = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!x.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!at.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!at.isEmpty(str) && str.contains("=") && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.iEt.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void E(HashMap<String, String> hashMap) {
        this.iEs = hashMap;
    }

    public void a(c cVar) {
        this.iEr = cVar;
    }
}
