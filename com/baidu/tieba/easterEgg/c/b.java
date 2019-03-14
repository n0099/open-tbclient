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
import com.google.gson.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b extends k {
    private d cTa;
    private com.baidu.tieba.easterEgg.d ezF;
    private HashMap<String, String> ezG;
    private SparseArray<String> ezH;

    public b(int i) {
        super(i);
        this.cTa = new d();
        aVx();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.ezH.get(socketMessage.getCmd());
        if (str != null && this.ezG != null && this.ezG.get(str) != null && this.ezF != null) {
            this.ezF.S(str, this.cTa.toJson(this.ezG.get(str)), this.cTa.toJson(this.cTa.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void aVx() {
        int l;
        this.ezH = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.T(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ap.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ap.isEmpty(str) && str.contains("=") && (l = com.baidu.adp.lib.g.b.l(str.split("[=]")[1], 0)) != 0) {
                        this.ezH.put(l, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void r(HashMap<String, String> hashMap) {
        this.ezG = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.ezF = dVar;
    }
}
