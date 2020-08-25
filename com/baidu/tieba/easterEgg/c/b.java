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
/* loaded from: classes18.dex */
public class b extends k {
    private Gson dTJ;
    private d hrQ;
    private HashMap<String, String> hrR;
    private SparseArray<String> hrS;

    public b(int i) {
        super(i);
        this.dTJ = new Gson();
        cdZ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.hrS.get(socketMessage.getCmd());
        if (str != null && this.hrR != null && this.hrR.get(str) != null && this.hrQ != null) {
            this.hrQ.ap(str, this.dTJ.toJson(this.hrR.get(str)), this.dTJ.toJson(this.dTJ.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void cdZ() {
        int i;
        this.hrS = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!y.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!at.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!at.isEmpty(str) && str.contains(ETAG.EQUAL) && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.hrS.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void E(HashMap<String, String> hashMap) {
        this.hrR = hashMap;
    }

    public void a(d dVar) {
        this.hrQ = dVar;
    }
}
