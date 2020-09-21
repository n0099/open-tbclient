package com.baidu.tieba.easterEgg.c;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.b.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.easterEgg.d;
import com.baidu.webkit.internal.ETAG;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes23.dex */
public class b extends k {
    private Gson dVX;
    private d hzb;
    private HashMap<String, String> hzc;
    private SparseArray<String> hzd;

    public b(int i) {
        super(i);
        this.dVX = new Gson();
        chp();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.hzd.get(socketMessage.getCmd());
        if (str != null && this.hzc != null && this.hzc.get(str) != null && this.hzb != null) {
            this.hzb.ap(str, this.dVX.toJson(this.hzc.get(str)), this.dVX.toJson(this.dVX.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void chp() {
        int i;
        this.hzd = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!y.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!at.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!at.isEmpty(str) && str.contains(ETAG.EQUAL) && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.hzd.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void E(HashMap<String, String> hashMap) {
        this.hzc = hashMap;
    }

    public void a(d dVar) {
        this.hzb = dVar;
    }
}
