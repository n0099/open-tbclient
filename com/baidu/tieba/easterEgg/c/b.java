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
/* loaded from: classes24.dex */
public class b extends k {
    private Gson ehZ;
    private d hNW;
    private HashMap<String, String> hNX;
    private SparseArray<String> hNY;

    public b(int i) {
        super(i);
        this.ehZ = new Gson();
        ckL();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.hNY.get(socketMessage.getCmd());
        if (str != null && this.hNX != null && this.hNX.get(str) != null && this.hNW != null) {
            this.hNW.ar(str, this.ehZ.toJson(this.hNX.get(str)), this.ehZ.toJson(this.ehZ.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void ckL() {
        int i;
        this.hNY = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!y.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!at.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!at.isEmpty(str) && str.contains(ETAG.EQUAL) && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.hNY.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void G(HashMap<String, String> hashMap) {
        this.hNX = hashMap;
    }

    public void a(d dVar) {
        this.hNW = dVar;
    }
}
