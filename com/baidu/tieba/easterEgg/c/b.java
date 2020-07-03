package com.baidu.tieba.easterEgg.c;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.b.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.easterEgg.d;
import com.baidu.webkit.internal.ETAG;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class b extends k {
    private Gson dEE;
    private d gZs;
    private HashMap<String, String> gZt;
    private SparseArray<String> gZu;

    public b(int i) {
        super(i);
        this.dEE = new Gson();
        bQB();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.gZu.get(socketMessage.getCmd());
        if (str != null && this.gZt != null && this.gZt.get(str) != null && this.gZs != null) {
            this.gZs.ao(str, this.dEE.toJson(this.gZt.get(str)), this.dEE.toJson(this.dEE.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void bQB() {
        int i;
        this.gZu = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!w.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!ar.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!ar.isEmpty(str) && str.contains(ETAG.EQUAL) && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.gZu.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void H(HashMap<String, String> hashMap) {
        this.gZt = hashMap;
    }

    public void a(d dVar) {
        this.gZs = dVar;
    }
}
