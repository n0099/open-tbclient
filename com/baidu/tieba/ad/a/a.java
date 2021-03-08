package com.baidu.tieba.ad.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class a {
    private final com.baidu.tieba.recapp.download.a.a gjl;
    private final int gjm;
    private final int gjn;
    private final int gjo;
    private final List<String> gjp;
    private final List<com.baidu.tieba.recapp.download.a.b> gjq;

    private a() {
        this.gjl = com.baidu.tieba.recapp.download.a.a.dDO();
        this.gjm = com.baidu.tieba.a.bJk().bJq();
        this.gjn = com.baidu.tieba.a.bJk().bJr();
        this.gjo = com.baidu.tieba.a.bJk().bJp();
        String bJo = com.baidu.tieba.a.bJk().bJo();
        if (TextUtils.isEmpty(bJo)) {
            this.gjp = new ArrayList();
        } else {
            this.gjp = Arrays.asList(bJo.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS));
        }
        this.gjq = Collections.synchronizedList(new ArrayList());
        bw(this.gjo, this.gjm);
        new C0597a().execute(Integer.valueOf(this.gjo), Integer.valueOf(this.gjm));
    }

    public static a bLM() {
        return d.gjs;
    }

    /* loaded from: classes.dex */
    private static class d {
        private static final a gjs = new a();
    }

    public App a(App app, Cmatch cmatch) {
        if (a(cmatch) && app != null && com.baidu.tieba.recapp.a.f(app)) {
            return b(app, cmatch);
        }
        return null;
    }

    private boolean a(@NonNull Cmatch cmatch) {
        com.baidu.tieba.recapp.download.a.b bVar;
        if (!this.gjp.contains(cmatch.value) || com.baidu.tieba.lego.card.c.a.isEmpty(this.gjq) || (bVar = (com.baidu.tieba.recapp.download.a.b) com.baidu.tieba.lego.card.c.a.l(this.gjq, 0)) == null) {
            return false;
        }
        return this.gjn <= ((int) ((System.currentTimeMillis() - bVar.lOR) / AppStatusRules.DEFAULT_GRANULARITY));
    }

    public void onAdShow(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (com.baidu.tieba.recapp.download.a.b bVar : this.gjq) {
                if (bVar != null && TextUtils.equals(bVar.downloadKey, str)) {
                    a(bVar);
                }
            }
        }
    }

    private void a(@NonNull com.baidu.tieba.recapp.download.a.b bVar) {
        bVar.mUZ++;
        if (bVar.mUZ >= this.gjm) {
            EV(bVar.downloadKey);
            return;
        }
        bVar.lOR = System.currentTimeMillis();
        b(bVar);
    }

    private void EV(String str) {
        Iterator<com.baidu.tieba.recapp.download.a.b> it = this.gjq.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().downloadKey, str)) {
                it.remove();
            }
        }
        EW(str);
    }

    public void a(DownloadStatus downloadStatus, IDownloadModel iDownloadModel) {
        if (!TextUtils.isEmpty(iDownloadModel.getDownloadKey()) && !TextUtils.isEmpty(iDownloadModel.getPkgName())) {
            com.baidu.tieba.recapp.download.a.b d2 = d(iDownloadModel);
            if (downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
                d2.installStatus = 2;
                this.gjq.remove(d2);
            } else {
                d2.installStatus = 1;
                if (!this.gjq.contains(d2)) {
                    this.gjq.add(0, d2);
                }
            }
            b(d2);
        }
    }

    private com.baidu.tieba.recapp.download.a.b d(IDownloadModel iDownloadModel) {
        com.baidu.tieba.recapp.download.a.b bVar = new com.baidu.tieba.recapp.download.a.b();
        bVar.mVa = iDownloadModel.getAppJson();
        bVar.packageName = iDownloadModel.getPkgName();
        bVar.downloadKey = iDownloadModel.getDownloadKey();
        bVar.mUZ = 0;
        bVar.lOR = System.currentTimeMillis();
        bVar.mUY = System.currentTimeMillis();
        return bVar;
    }

    private App b(@NonNull App app, @NonNull Cmatch cmatch) {
        com.baidu.tieba.recapp.download.a.b bVar;
        if (com.baidu.tieba.lego.card.c.a.isEmpty(this.gjq)) {
            return null;
        }
        Iterator<com.baidu.tieba.recapp.download.a.b> it = this.gjq.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (!t.RA(bVar.packageName)) {
                break;
            }
            bVar.installStatus = 2;
            b(bVar);
            it.remove();
        }
        if (bVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(bVar.mVa);
            jSONObject.put("pos_name", app.pos_name);
            App parseFromJson = App.parseFromJson(jSONObject);
            if (a(cmatch, parseFromJson)) {
                return parseFromJson;
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean a(Cmatch cmatch, App app) {
        if (cmatch == Cmatch.PB_BANNER && com.baidu.tieba.recapp.a.e(app) == 14 && !com.baidu.tieba.recapp.a.g(app)) {
            return false;
        }
        return (cmatch == Cmatch.VIDEO_PB_COMMENT && (com.baidu.tieba.recapp.a.e(app) == 14 || com.baidu.tieba.recapp.a.e(app) == 7)) ? false : true;
    }

    public static String a(AppData appData) {
        if (appData == null || appData.legoCard == null) {
            return null;
        }
        return appData.legoCard.getDownloadKey();
    }

    private void b(com.baidu.tieba.recapp.download.a.b bVar) {
        new e().execute(bVar);
    }

    private void EW(String str) {
        new b().execute(str);
    }

    private void bw(int i, int i2) {
        try {
            new c().execute(Integer.valueOf(i), Integer.valueOf(i2));
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<com.baidu.tieba.recapp.download.a.b, Integer, Void> {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Void doInBackground(com.baidu.tieba.recapp.download.a.b... bVarArr) {
            if (bVarArr != null && bVarArr.length > 0 && bVarArr[0] != null) {
                a.this.gjl.c(bVarArr[0]);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Void> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            if (strArr != null && strArr.length > 0 && strArr[0] != null) {
                a.this.gjl.RK(strArr[0]);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Integer, Integer, List<com.baidu.tieba.recapp.download.a.b>> {
        private c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public List<com.baidu.tieba.recapp.download.a.b> doInBackground(Integer... numArr) {
            if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                return null;
            }
            return a.this.gjl.b(numArr[0], numArr[1]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public void onPostExecute(List<com.baidu.tieba.recapp.download.a.b> list) {
            super.onPostExecute(list);
            if (!com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
                a.this.gjq.addAll(list);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ad.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0597a extends BdAsyncTask<Integer, Integer, Void> {
        private C0597a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public Void doInBackground(Integer... numArr) {
            if (numArr != null && numArr.length > 1 && numArr[0] != null && numArr[1] != null) {
                a.this.gjl.c(numArr[0], numArr[1]);
                return null;
            }
            return null;
        }
    }
}
