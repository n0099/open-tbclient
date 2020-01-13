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
import com.baidu.webkit.internal.ETAG;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class b extends k {
    private d fPt;
    private HashMap<String, String> fPu;
    private Gson fPv;
    private SparseArray<String> fPw;

    public b(int i) {
        super(i);
        this.fPv = new Gson();
        bvE();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.fPw.get(socketMessage.getCmd());
        if (str != null && this.fPu != null && this.fPu.get(str) != null && this.fPt != null) {
            this.fPt.ak(str, this.fPv.toJson(this.fPu.get(str)), this.fPv.toJson(this.fPv.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void bvE() {
        int i;
        this.fPw = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!aq.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!aq.isEmpty(str) && str.contains(ETAG.EQUAL) && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.fPw.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void q(HashMap<String, String> hashMap) {
        this.fPu = hashMap;
    }

    public void a(d dVar) {
        this.fPt = dVar;
    }
}
