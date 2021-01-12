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
/* loaded from: classes7.dex */
public class b extends k {
    private Gson eGB;
    private c izK;
    private HashMap<String, String> izL;
    private SparseArray<String> izM;

    public b(int i) {
        super(i);
        this.eGB = new Gson();
        ctm();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.izM.get(socketMessage.getCmd());
        if (str != null && this.izL != null && this.izL.get(str) != null && this.izK != null) {
            this.izK.aD(str, this.eGB.toJson(this.izL.get(str)), this.eGB.toJson(this.eGB.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void ctm() {
        int i;
        this.izM = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!x.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!at.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!at.isEmpty(str) && str.contains("=") && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.izM.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void E(HashMap<String, String> hashMap) {
        this.izL = hashMap;
    }

    public void a(c cVar) {
        this.izK = cVar;
    }
}
