package com.baidu.tieba.easterEgg.c;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.b.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.easterEgg.d;
import com.baidu.webkit.internal.ETAG;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class b extends k {
    private d gMk;
    private HashMap<String, String> gMl;
    private Gson gMm;
    private SparseArray<String> gMn;

    public b(int i) {
        super(i);
        this.gMm = new Gson();
        bNu();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.gMn.get(socketMessage.getCmd());
        if (str != null && this.gMl != null && this.gMl.get(str) != null && this.gMk != null) {
            this.gMk.an(str, this.gMm.toJson(this.gMl.get(str)), this.gMm.toJson(this.gMm.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void bNu() {
        int i;
        this.gMn = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!aq.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!aq.isEmpty(str) && str.contains(ETAG.EQUAL) && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.gMn.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void H(HashMap<String, String> hashMap) {
        this.gMl = hashMap;
    }

    public void a(d dVar) {
        this.gMk = dVar;
    }
}
