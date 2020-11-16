package com.baidu.tieba.easterEgg.c;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.b.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.easterEgg.c;
import com.baidu.webkit.internal.ETAG;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes23.dex */
public class b extends k {
    private Gson euH;
    private c ihi;
    private HashMap<String, String> ihj;
    private SparseArray<String> ihk;

    public b(int i) {
        super(i);
        this.euH = new Gson();
        cpW();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.ihk.get(socketMessage.getCmd());
        if (str != null && this.ihj != null && this.ihj.get(str) != null && this.ihi != null) {
            this.ihi.az(str, this.euH.toJson(this.ihj.get(str)), this.euH.toJson(this.euH.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void cpW() {
        int i;
        this.ihk = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!y.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!au.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!au.isEmpty(str) && str.contains(ETAG.EQUAL) && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.ihk.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void F(HashMap<String, String> hashMap) {
        this.ihj = hashMap;
    }

    public void a(c cVar) {
        this.ihi = cVar;
    }
}
