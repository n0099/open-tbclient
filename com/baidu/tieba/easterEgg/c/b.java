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
    private d cTd;
    private com.baidu.tieba.easterEgg.d ezr;
    private HashMap<String, String> ezs;
    private SparseArray<String> ezt;

    public b(int i) {
        super(i);
        this.cTd = new d();
        aVv();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.ezt.get(socketMessage.getCmd());
        if (str != null && this.ezs != null && this.ezs.get(str) != null && this.ezr != null) {
            this.ezr.S(str, this.cTd.toJson(this.ezs.get(str)), this.cTd.toJson(this.cTd.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void aVv() {
        int l;
        this.ezt = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.T(findHttpTasks)) {
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!ap.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ap.isEmpty(str) && str.contains("=") && (l = com.baidu.adp.lib.g.b.l(str.split("[=]")[1], 0)) != 0) {
                        this.ezt.put(l, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void r(HashMap<String, String> hashMap) {
        this.ezs = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.ezr = dVar;
    }
}
