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
/* loaded from: classes11.dex */
public class b extends k {
    private d gxA;
    private HashMap<String, String> gxB;
    private Gson gxC;
    private SparseArray<String> gxD;

    public b(int i) {
        super(i);
        this.gxC = new Gson();
        bHa();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.gxD.get(socketMessage.getCmd());
        if (str != null && this.gxB != null && this.gxB.get(str) != null && this.gxA != null) {
            this.gxA.aj(str, this.gxC.toJson(this.gxB.get(str)), this.gxC.toJson(this.gxC.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void bHa() {
        int i;
        this.gxD = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!v.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!aq.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!aq.isEmpty(str) && str.contains(ETAG.EQUAL) && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.gxD.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void F(HashMap<String, String> hashMap) {
        this.gxB = hashMap;
    }

    public void a(d dVar) {
        this.gxA = dVar;
    }
}
