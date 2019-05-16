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
import com.baidu.tieba.easterEgg.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b extends k {
    private d eOT;
    private HashMap<String, String> eOU;
    private com.google.gson.d eOV;
    private SparseArray<String> eOW;

    public b(int i) {
        super(i);
        this.eOV = new com.google.gson.d();
        bcD();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.eOW.get(socketMessage.getCmd());
        if (str != null && this.eOU != null && this.eOU.get(str) != null && this.eOT != null) {
            this.eOT.S(str, this.eOV.toJson(this.eOU.get(str)), this.eOV.toJson(this.eOV.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void bcD() {
        int f;
        this.eOW = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.aa(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ap.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ap.isEmpty(str) && str.contains("=") && (f = com.baidu.adp.lib.g.b.f(str.split("[=]")[1], 0)) != 0) {
                        this.eOW.put(f, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void r(HashMap<String, String> hashMap) {
        this.eOU = hashMap;
    }

    public void a(d dVar) {
        this.eOT = dVar;
    }
}
