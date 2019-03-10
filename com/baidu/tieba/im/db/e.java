package com.baidu.tieba.im.db;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e ghf;
    private a ghg;
    private final DialogInterface.OnCancelListener ghh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bsl();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cQ(List<c> list);

        void f(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e bsk() {
        if (ghf == null) {
            synchronized (e.class) {
                if (ghf == null) {
                    ghf = new e();
                }
            }
        }
        return ghf;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                wW(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                wU(str);
            } else if (4 == i) {
                wV(str);
            } else if (-3 == i) {
                aL(str, i);
            } else if (-4 == i) {
                aL(str, i);
            } else {
                aL(str, i);
            }
        }
    }

    public void wU(String str) {
        try {
            try {
                h.bsp().bsq();
                aM(str, 2);
                m.bsA().wM(str);
                h.bsp().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bsp().endTransaction();
            }
        } catch (Throwable th) {
            h.bsp().endTransaction();
            throw th;
        }
    }

    public void wV(String str) {
        try {
            try {
                h.bsp().bsq();
                aM(str, 4);
                l.bsy().wM(str);
                h.bsp().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bsp().endTransaction();
            }
        } catch (Throwable th) {
            h.bsp().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bsp().bsq();
            if (v.T(list)) {
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
                if (bsm()) {
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
            h.bsp().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bsp().bsq();
            if (!v.T(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bsm()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.c(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aM(friendId, 4);
                        l.bsy().wM(friendId);
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
            h.bsp().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bsp().bsq();
            List<String> bsE = n.bsE();
            if (v.T(bsE)) {
                return;
            }
            int size = bsE.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bsm()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.c(bsE, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bsm()) {
                return;
            }
            aM("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bsp().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.wZ(cO(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bsA().wN(str);
                if (bsm()) {
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
                bVar.cQ(arrayList);
            }
        }
    }

    private String cO(List<String> list) {
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
            h.bsp().bsq();
            l.bsy();
            List<String> bsz = l.bsz();
            if (v.T(bsz)) {
                return;
            }
            int size = bsz.size();
            int i = 0;
            for (String str : bsz) {
                if (bsm()) {
                    break;
                }
                aM(str, 4);
                l.bsy().wM(str);
                i++;
                if (bVar != null) {
                    bVar.f((i * 100) / size, str, 4);
                }
            }
            if (bsm()) {
                return;
            }
            aM("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bsp().endTransaction();
        }
    }

    public void aL(String str, int i) {
        try {
            try {
                h.bsp().bsq();
                ImMessageCenterPojo aT = com.baidu.tieba.im.memorycache.b.buG().aT(str, i);
                aT.setIs_hidden(1);
                aT.setUnread_count(0);
                j.bss().a(aT, 2);
                h.bsp().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bsp().endTransaction();
            }
        } catch (Throwable th) {
            h.bsp().endTransaction();
            throw th;
        }
    }

    public void wW(String str) {
        try {
            h.bsp().bsq();
            ImMessageCenterPojo aT = com.baidu.tieba.im.memorycache.b.buG().aT(str, 1);
            aT.setIs_hidden(1);
            aT.setUnread_count(0);
            j.bss().a(aT, 2);
            com.baidu.tieba.im.db.c.bsi().wN(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bsp().endTransaction();
        }
    }

    public boolean bsl() {
        if (this.ghg != null && this.ghg.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.ghg.cancel(true);
        }
        this.ghg = null;
        return true;
    }

    public boolean bsm() {
        return this.ghg == null || (this.ghg != null && this.ghg.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.ghg = new a(i, bVar);
        this.ghg.setParallel(TiebaIMConfig.getParallel());
        this.ghg.setPriority(3);
        this.ghg.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.ghg = new a(i, bVar);
        this.ghg.setParallel(TiebaIMConfig.getParallel());
        this.ghg.setPriority(3);
        this.ghg.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b ghj;
        private b ghk = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void cQ(List<c> list) {
                a.this.cP(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.ghj = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    if (this.mCustomGroupType == 4) {
                        e.this.b(list, this.ghk);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.ghk);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.ghk);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ghj != null) {
                        a.this.ghj.onProgressUpdate(i, str, i2);
                        a.this.ghj.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cP(final List<c> list) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.ghj != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.ghj.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.ghj.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.ghj != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.ghj.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.ghj != null) {
                this.ghj.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.ghj != null) {
                if (isCancelled()) {
                    this.ghj.onCanceled();
                } else {
                    this.ghj.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.ghj != null) {
                this.ghj.onCanceled();
            }
        }
    }

    public void aM(String str, int i) {
        j.bss().aO(str, i);
    }

    public void aN(String str, int i) {
        com.baidu.tieba.im.memorycache.b.buG().aN(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aT = com.baidu.tieba.im.memorycache.b.buG().aT(str, i);
        if (aT != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().nK(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iA(com.baidu.adp.lib.g.b.l(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iB(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iB(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().nJ(str);
            }
            aT.setIs_hidden(1);
            aT.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.buG().aU(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.buG().f(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.buG().f(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d dZ(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(d.j.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.ghh);
        return dVar;
    }
}
