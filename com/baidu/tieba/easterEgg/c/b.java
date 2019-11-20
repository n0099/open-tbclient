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
    private d eXC;
    private HashMap<String, String> eXD;
    private com.google.gson.d eXE;
    private SparseArray<String> eXF;

    public b(int i) {
        super(i);
        this.eXE = new com.google.gson.d();
        bdg();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.eXF.get(socketMessage.getCmd());
        if (str != null && this.eXD != null && this.eXD.get(str) != null && this.eXC != null) {
            this.eXC.V(str, this.eXE.toJson(this.eXD.get(str)), this.eXE.toJson(this.eXE.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void bdg() {
        int i;
        this.eXF = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!aq.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!aq.isEmpty(str) && str.contains("=") && (i = com.baidu.adp.lib.g.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.eXF.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void r(HashMap<String, String> hashMap) {
        this.eXD = hashMap;
    }

    public void a(d dVar) {
        this.eXC = dVar;
    }
}
