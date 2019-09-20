package com.baidu.tieba.im.db;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e gHc;
    private a gHd;
    private final DialogInterface.OnCancelListener gHe = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bDE();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cW(List<c> list);

        void f(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e bDD() {
        if (gHc == null) {
            synchronized (e.class) {
                if (gHc == null) {
                    gHc = new e();
                }
            }
        }
        return gHc;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                zu(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                zs(str);
            } else if (4 == i) {
                zt(str);
            } else if (-3 == i) {
                aK(str, i);
            } else if (-4 == i) {
                aK(str, i);
            } else {
                aK(str, i);
            }
        }
    }

    public void zs(String str) {
        try {
            try {
                h.bDI().bDJ();
                aL(str, 2);
                m.bDU().zk(str);
                h.bDI().bDK();
            } catch (Exception e) {
                e.printStackTrace();
                h.bDI().bDK();
            }
        } catch (Throwable th) {
            h.bDI().bDK();
            throw th;
        }
    }

    public void zt(String str) {
        try {
            try {
                h.bDI().bDJ();
                aL(str, 4);
                l.bDS().zk(str);
                h.bDI().bDK();
            } catch (Exception e) {
                e.printStackTrace();
                h.bDI().bDK();
            }
        } catch (Throwable th) {
            h.bDI().bDK();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bDI().bDJ();
            if (v.aa(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (int size = list.size() - 1; size >= 0; size--) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.c(list, size);
                if (imMessageCenterShowItemData != null && !TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                    arrayList.add(imMessageCenterShowItemData.getFriendId());
                }
            }
            int size2 = arrayList.size();
            int i3 = size2 / 100;
            if (size2 % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bDF()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size2;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.c(arrayList, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bDI().bDK();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bDI().bDJ();
            if (!v.aa(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bDF()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.c(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aL(friendId, 4);
                        l.bDS().zk(friendId);
                        i = i2 + 1;
                        if (bVar != null) {
                            bVar.f((i * 100) / size, friendId, 4);
                        }
                    }
                    i3--;
                    i2 = i;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bDI().bDK();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bDI().bDJ();
            List<String> bDY = n.bDY();
            if (v.aa(bDY)) {
                return;
            }
            int size = bDY.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bDF()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.c(bDY, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bDF()) {
                return;
            }
            aL("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bDI().bDK();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.zy(cU(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bDU().zl(str);
                if (bDF()) {
                    c cVar = new c();
                    cVar.id = str;
                    cVar.customGroupType = 2;
                    cVar.progress = i;
                    arrayList.add(cVar);
                } else {
                    bVar.f(i, str, 2);
                }
            }
            if (!arrayList.isEmpty() && bVar != null) {
                bVar.cW(arrayList);
            }
        }
    }

    private String cU(List<String> list) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : list) {
            if (!z) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            } else {
                z = false;
            }
            sb.append(str);
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [382=4] */
    public void b(b bVar) {
        try {
            h.bDI().bDJ();
            l.bDS();
            List<String> bDT = l.bDT();
            if (v.aa(bDT)) {
                return;
            }
            int size = bDT.size();
            int i = 0;
            for (String str : bDT) {
                if (bDF()) {
                    break;
                }
                aL(str, 4);
                l.bDS().zk(str);
                i++;
                if (bVar != null) {
                    bVar.f((i * 100) / size, str, 4);
                }
            }
            if (bDF()) {
                return;
            }
            aL("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bDI().bDK();
        }
    }

    public void aK(String str, int i) {
        try {
            try {
                h.bDI().bDJ();
                ImMessageCenterPojo aS = com.baidu.tieba.im.memorycache.b.bGb().aS(str, i);
                aS.setIs_hidden(1);
                aS.setUnread_count(0);
                j.bDM().a(aS, 2);
                h.bDI().bDK();
            } catch (Exception e) {
                e.printStackTrace();
                h.bDI().bDK();
            }
        } catch (Throwable th) {
            h.bDI().bDK();
            throw th;
        }
    }

    public void zu(String str) {
        try {
            h.bDI().bDJ();
            ImMessageCenterPojo aS = com.baidu.tieba.im.memorycache.b.bGb().aS(str, 1);
            aS.setIs_hidden(1);
            aS.setUnread_count(0);
            j.bDM().a(aS, 2);
            com.baidu.tieba.im.db.c.bDB().zl(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bDI().bDK();
        }
    }

    public boolean bDE() {
        if (this.gHd != null && this.gHd.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.gHd.cancel(true);
        }
        this.gHd = null;
        return true;
    }

    public boolean bDF() {
        return this.gHd == null || (this.gHd != null && this.gHd.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gHd = new a(i, bVar);
        this.gHd.setParallel(TiebaIMConfig.getParallel());
        this.gHd.setPriority(3);
        this.gHd.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gHd = new a(i, bVar);
        this.gHd.setParallel(TiebaIMConfig.getParallel());
        this.gHd.setPriority(3);
        this.gHd.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b gHg;
        private b gHh = new b() { // from class: com.baidu.tieba.im.db.e.a.1
            @Override // com.baidu.tieba.im.db.e.b
            public void f(int i, String str, int i2) {
                if (a.this.isCancelled()) {
                    a.this.e(i, str, i2);
                    return;
                }
                c cVar = new c();
                cVar.id = str;
                cVar.customGroupType = i2;
                cVar.progress = i;
                a.this.publishProgress(cVar);
            }

            @Override // com.baidu.tieba.im.db.e.b
            public void cW(List<c> list) {
                a.this.cV(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.gHg = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    if (this.mCustomGroupType == 4) {
                        e.this.b(list, this.gHh);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.gHh);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.gHh);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gHg != null) {
                        a.this.gHg.onProgressUpdate(i, str, i2);
                        a.this.gHg.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cV(final List<c> list) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.gHg != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.gHg.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.gHg.onCanceled();
                        list.clear();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(c... cVarArr) {
            super.onProgressUpdate(cVarArr);
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.gHg != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.gHg.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.gHg != null) {
                this.gHg.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.gHg != null) {
                if (isCancelled()) {
                    this.gHg.onCanceled();
                } else {
                    this.gHg.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.gHg != null) {
                this.gHg.onCanceled();
            }
        }
    }

    public void aL(String str, int i) {
        j.bDM().aN(str, i);
    }

    public void aM(String str, int i) {
        com.baidu.tieba.im.memorycache.b.bGb().aM(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aS = com.baidu.tieba.im.memorycache.b.bGb().aS(str, i);
        if (aS != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anR().pw(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anR().jx(com.baidu.adp.lib.g.b.f(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anR().jy(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anR().jy(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.anR().pv(str);
            }
            aS.setIs_hidden(1);
            aS.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.bGb().aT(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.bGb().f(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.bGb().f(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d dR(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.gHe);
        return dVar;
    }
}
