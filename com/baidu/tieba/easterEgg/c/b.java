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
    private Gson dTN;
    private d hrW;
    private HashMap<String, String> hrX;
    private SparseArray<String> hrY;

    public b(int i) {
        super(i);
        this.dTN = new Gson();
        cea();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.hrY.get(socketMessage.getCmd());
        if (str != null && this.hrX != null && this.hrX.get(str) != null && this.hrW != null) {
            this.hrW.ap(str, this.dTN.toJson(this.hrX.get(str)), this.dTN.toJson(this.dTN.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void cea() {
        int i;
        this.hrY = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!y.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!at.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!at.isEmpty(str) && str.contains(ETAG.EQUAL) && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.hrY.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void E(HashMap<String, String> hashMap) {
        this.hrX = hashMap;
    }

    public void a(d dVar) {
        this.hrW = dVar;
    }
}
