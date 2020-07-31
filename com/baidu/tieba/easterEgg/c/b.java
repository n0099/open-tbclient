package com.baidu.tieba.easterEgg.c;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.b.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.easterEgg.d;
import com.baidu.webkit.internal.ETAG;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes18.dex */
public class b extends k {
    private Gson dKB;
    private d heX;
    private HashMap<String, String> heY;
    private SparseArray<String> heZ;

    public b(int i) {
        super(i);
        this.dKB = new Gson();
        bTN();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.heZ.get(socketMessage.getCmd());
        if (str != null && this.heY != null && this.heY.get(str) != null && this.heX != null) {
            this.heX.ap(str, this.dKB.toJson(this.heY.get(str)), this.dKB.toJson(this.dKB.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void bTN() {
        int i;
        this.heZ = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!x.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!as.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!as.isEmpty(str) && str.contains(ETAG.EQUAL) && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.heZ.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void G(HashMap<String, String> hashMap) {
        this.heY = hashMap;
    }

    public void a(d dVar) {
        this.heX = dVar;
    }
}
