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
    private Gson ewq;
    private d igu;
    private HashMap<String, String> igv;
    private SparseArray<String> igw;

    public b(int i) {
        super(i);
        this.ewq = new Gson();
        cqt();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.igw.get(socketMessage.getCmd());
        if (str != null && this.igv != null && this.igv.get(str) != null && this.igu != null) {
            this.igu.az(str, this.ewq.toJson(this.igv.get(str)), this.ewq.toJson(this.ewq.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void cqt() {
        int i;
        this.igw = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!y.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!at.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!at.isEmpty(str) && str.contains(ETAG.EQUAL) && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.igw.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void G(HashMap<String, String> hashMap) {
        this.igv = hashMap;
    }

    public void a(d dVar) {
        this.igu = dVar;
    }
}
