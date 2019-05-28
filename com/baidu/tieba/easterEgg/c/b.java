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
    private d eOU;
    private HashMap<String, String> eOV;
    private com.google.gson.d eOW;
    private SparseArray<String> eOX;

    public b(int i) {
        super(i);
        this.eOW = new com.google.gson.d();
        bcG();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.eOX.get(socketMessage.getCmd());
        if (str != null && this.eOV != null && this.eOV.get(str) != null && this.eOU != null) {
            this.eOU.S(str, this.eOW.toJson(this.eOV.get(str)), this.eOW.toJson(this.eOW.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void bcG() {
        int f;
        this.eOX = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.aa(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ap.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ap.isEmpty(str) && str.contains("=") && (f = com.baidu.adp.lib.g.b.f(str.split("[=]")[1], 0)) != 0) {
                        this.eOX.put(f, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void r(HashMap<String, String> hashMap) {
        this.eOV = hashMap;
    }

    public void a(d dVar) {
        this.eOU = dVar;
    }
}
