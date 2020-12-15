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
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes24.dex */
public class b extends k {
    private Gson eBJ;
    private c ise;
    private HashMap<String, String> isf;
    private SparseArray<String> isg;

    public b(int i) {
        super(i);
        this.eBJ = new Gson();
        cul();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str = this.isg.get(socketMessage.getCmd());
        if (str != null && this.isf != null && this.isf.get(str) != null && this.ise != null) {
            this.ise.aB(str, this.eBJ.toJson(this.isf.get(str)), this.eBJ.toJson(this.eBJ.toJson(socketMessage.getData())));
        }
        return socketMessage;
    }

    private void cul() {
        int i;
        this.isg = new SparseArray<>();
        ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
        if (!y.isEmpty(findHttpTasks)) {
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!au.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!au.isEmpty(str) && str.contains("=") && (i = com.baidu.adp.lib.f.b.toInt(str.split("[=]")[1], 0)) != 0) {
                        this.isg.put(i, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void F(HashMap<String, String> hashMap) {
        this.isf = hashMap;
    }

    public void a(c cVar) {
        this.ise = cVar;
    }
}
