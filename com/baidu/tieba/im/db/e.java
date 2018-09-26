package com.baidu.tieba.im.db;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e exB;
    private a exC;
    private final DialogInterface.OnCancelListener exD = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.aLO();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cl(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e aLN() {
        if (exB == null) {
            synchronized (e.class) {
                if (exB == null) {
                    exB = new e();
                }
            }
        }
        return exB;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                oS(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                oQ(str);
            } else if (4 == i) {
                oR(str);
            } else if (-3 == i) {
                ak(str, i);
            } else if (-4 == i) {
                ak(str, i);
            } else {
                ak(str, i);
            }
        }
    }

    public void oQ(String str) {
        try {
            try {
                h.aLS().aLT();
                al(str, 2);
                m.aMd().oI(str);
                h.aLS().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aLS().endTransaction();
            }
        } catch (Throwable th) {
            h.aLS().endTransaction();
            throw th;
        }
    }

    public void oR(String str) {
        try {
            try {
                h.aLS().aLT();
                al(str, 4);
                l.aMb().oI(str);
                h.aLS().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aLS().endTransaction();
            }
        } catch (Throwable th) {
            h.aLS().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.aLS().aLT();
            if (v.z(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (int size = list.size() - 1; size >= 0; size--) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.d(list, size);
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
                if (aLP()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size2;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.b(arrayList, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aLS().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.aLS().aLT();
            if (!v.z(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (aLP()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.d(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        al(friendId, 4);
                        l.aMb().oI(friendId);
                        i = i2 + 1;
                        if (bVar != null) {
                            bVar.e((i * 100) / size, friendId, 4);
                        }
                    }
                    i3--;
                    i2 = i;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aLS().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.aLS().aLT();
            List<String> aMh = n.aMh();
            if (v.z(aMh)) {
                return;
            }
            int size = aMh.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (aLP()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.b(aMh, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (aLP()) {
                return;
            }
            al("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aLS().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.oV(cj(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.aMd().oJ(str);
                if (aLP()) {
                    c cVar = new c();
                    cVar.id = str;
                    cVar.customGroupType = 2;
                    cVar.progress = i;
                    arrayList.add(cVar);
                } else {
                    bVar.e(i, str, 2);
                }
            }
            if (!arrayList.isEmpty() && bVar != null) {
                bVar.cl(arrayList);
            }
        }
    }

    private String cj(List<String> list) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : list) {
            if (!z) {
                sb.append(",");
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
            h.aLS().aLT();
            l.aMb();
            List<String> aMc = l.aMc();
            if (v.z(aMc)) {
                return;
            }
            int size = aMc.size();
            int i = 0;
            for (String str : aMc) {
                if (aLP()) {
                    break;
                }
                al(str, 4);
                l.aMb().oI(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (aLP()) {
                return;
            }
            al("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aLS().endTransaction();
        }
    }

    public void ak(String str, int i) {
        try {
            try {
                h.aLS().aLT();
                ImMessageCenterPojo as = com.baidu.tieba.im.memorycache.b.aOk().as(str, i);
                as.setIs_hidden(1);
                as.setUnread_count(0);
                j.aLV().a(as, 2);
                h.aLS().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aLS().endTransaction();
            }
        } catch (Throwable th) {
            h.aLS().endTransaction();
            throw th;
        }
    }

    public void oS(String str) {
        try {
            h.aLS().aLT();
            ImMessageCenterPojo as = com.baidu.tieba.im.memorycache.b.aOk().as(str, 1);
            as.setIs_hidden(1);
            as.setUnread_count(0);
            j.aLV().a(as, 2);
            com.baidu.tieba.im.db.c.aLL().oJ(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.aLS().endTransaction();
        }
    }

    public boolean aLO() {
        if (this.exC != null && this.exC.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.exC.cancel(true);
        }
        this.exC = null;
        return true;
    }

    public boolean aLP() {
        return this.exC == null || (this.exC != null && this.exC.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.exC = new a(i, bVar);
        this.exC.setParallel(TiebaIMConfig.getParallel());
        this.exC.setPriority(3);
        this.exC.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.exC = new a(i, bVar);
        this.exC.setParallel(TiebaIMConfig.getParallel());
        this.exC.setPriority(3);
        this.exC.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b exF;
        private b exG = new b() { // from class: com.baidu.tieba.im.db.e.a.1
            @Override // com.baidu.tieba.im.db.e.b
            public void e(int i, String str, int i2) {
                if (a.this.isCancelled()) {
                    a.this.d(i, str, i2);
                    return;
                }
                c cVar = new c();
                cVar.id = str;
                cVar.customGroupType = i2;
                cVar.progress = i;
                a.this.publishProgress(cVar);
            }

            @Override // com.baidu.tieba.im.db.e.b
            public void cl(List<c> list) {
                a.this.ck(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.exF = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    if (this.mCustomGroupType == 4) {
                        e.this.b(list, this.exG);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.exG);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.exG);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.exF != null) {
                        a.this.exF.onProgressUpdate(i, str, i2);
                        a.this.exF.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ck(final List<c> list) {
            com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.exF != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.exF.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.exF.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.exF != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.exF.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.exF != null) {
                this.exF.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.exF != null) {
                if (isCancelled()) {
                    this.exF.onCanceled();
                } else {
                    this.exF.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.exF != null) {
                this.exF.onCanceled();
            }
        }
    }

    public void al(String str, int i) {
        j.aLV().an(str, i);
    }

    public void am(String str, int i) {
        com.baidu.tieba.im.memorycache.b.aOk().am(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo as = com.baidu.tieba.im.memorycache.b.aOk().as(str, i);
        if (as != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Ey().gc(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Ey().ei(com.baidu.adp.lib.g.b.l(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Ey().ej(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Ey().ej(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.a.Ey().gb(str);
            }
            as.setIs_hidden(1);
            as.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.aOk().at(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.aOk().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.aOk().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d cr(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(e.j.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.exD);
        return dVar;
    }
}
