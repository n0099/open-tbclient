package com.baidu.tieba.i.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.i.c;
import com.baidu.tieba.play.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public abstract class a<T extends com.baidu.tieba.play.b.b> implements c<T> {
    protected final String fwr;
    protected List<T> list = new ArrayList();

    public a(String str) {
        this.fwr = str;
    }

    public void a(T t) {
        this.list.add(t);
    }

    public int size() {
        if (this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    public String aXh() {
        if (StringUtils.isNull(this.fwr) || !k.lk() || StringUtils.isNull(getKey())) {
            return null;
        }
        String str = c.a.fvQ + aXi();
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
                return str;
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String aXi() {
        return "_" + this.fwr + "_" + getKey();
    }

    @Override // com.baidu.tieba.i.a.c
    public e aXj() {
        return new e(getKey(), aXh());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cI(List<T> list) {
        new BdAsyncTask<List<T>, Void, Void>() { // from class: com.baidu.tieba.i.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public Void doInBackground(List<T>[] listArr) {
                if (listArr != null && listArr.length == 1) {
                    String aXh = a.this.aXh();
                    if (!StringUtils.isNull(aXh)) {
                        a.this.j(aXh, listArr[0]);
                    }
                }
                return null;
            }
        }.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(String str, List<T> list) {
        int size = list.size();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).bmc());
        }
        com.baidu.tieba.i.d.e(new File(str), jSONArray.toString() + "\n");
    }
}
