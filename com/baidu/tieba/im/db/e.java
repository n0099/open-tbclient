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
    private static e ggR;
    private a ggS;
    private final DialogInterface.OnCancelListener ggT = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bsh();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cN(List<c> list);

        void f(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e bsg() {
        if (ggR == null) {
            synchronized (e.class) {
                if (ggR == null) {
                    ggR = new e();
                }
            }
        }
        return ggR;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                wT(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                wR(str);
            } else if (4 == i) {
                wS(str);
            } else if (-3 == i) {
                aL(str, i);
            } else if (-4 == i) {
                aL(str, i);
            } else {
                aL(str, i);
            }
        }
    }

    public void wR(String str) {
        try {
            try {
                h.bsl().bsm();
                aM(str, 2);
                m.bsw().wJ(str);
                h.bsl().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bsl().endTransaction();
            }
        } catch (Throwable th) {
            h.bsl().endTransaction();
            throw th;
        }
    }

    public void wS(String str) {
        try {
            try {
                h.bsl().bsm();
                aM(str, 4);
                l.bsu().wJ(str);
                h.bsl().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bsl().endTransaction();
            }
        } catch (Throwable th) {
            h.bsl().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bsl().bsm();
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
                if (bsi()) {
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
            h.bsl().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bsl().bsm();
            if (!v.T(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bsi()) {
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
                        l.bsu().wJ(friendId);
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
            h.bsl().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bsl().bsm();
            List<String> bsA = n.bsA();
            if (v.T(bsA)) {
                return;
            }
            int size = bsA.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bsi()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.c(bsA, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bsi()) {
                return;
            }
            aM("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bsl().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.wW(cL(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bsw().wK(str);
                if (bsi()) {
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
                bVar.cN(arrayList);
            }
        }
    }

    private String cL(List<String> list) {
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
            h.bsl().bsm();
            l.bsu();
            List<String> bsv = l.bsv();
            if (v.T(bsv)) {
                return;
            }
            int size = bsv.size();
            int i = 0;
            for (String str : bsv) {
                if (bsi()) {
                    break;
                }
                aM(str, 4);
                l.bsu().wJ(str);
                i++;
                if (bVar != null) {
                    bVar.f((i * 100) / size, str, 4);
                }
            }
            if (bsi()) {
                return;
            }
            aM("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bsl().endTransaction();
        }
    }

    public void aL(String str, int i) {
        try {
            try {
                h.bsl().bsm();
                ImMessageCenterPojo aT = com.baidu.tieba.im.memorycache.b.buC().aT(str, i);
                aT.setIs_hidden(1);
                aT.setUnread_count(0);
                j.bso().a(aT, 2);
                h.bsl().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bsl().endTransaction();
            }
        } catch (Throwable th) {
            h.bsl().endTransaction();
            throw th;
        }
    }

    public void wT(String str) {
        try {
            h.bsl().bsm();
            ImMessageCenterPojo aT = com.baidu.tieba.im.memorycache.b.buC().aT(str, 1);
            aT.setIs_hidden(1);
            aT.setUnread_count(0);
            j.bso().a(aT, 2);
            com.baidu.tieba.im.db.c.bse().wK(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bsl().endTransaction();
        }
    }

    public boolean bsh() {
        if (this.ggS != null && this.ggS.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.ggS.cancel(true);
        }
        this.ggS = null;
        return true;
    }

    public boolean bsi() {
        return this.ggS == null || (this.ggS != null && this.ggS.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.ggS = new a(i, bVar);
        this.ggS.setParallel(TiebaIMConfig.getParallel());
        this.ggS.setPriority(3);
        this.ggS.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.ggS = new a(i, bVar);
        this.ggS.setParallel(TiebaIMConfig.getParallel());
        this.ggS.setPriority(3);
        this.ggS.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b ggV;
        private b ggW = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void cN(List<c> list) {
                a.this.cM(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.ggV = bVar;
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
                        e.this.b(list, this.ggW);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.ggW);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.ggW);
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
                    if (a.this.ggV != null) {
                        a.this.ggV.onProgressUpdate(i, str, i2);
                        a.this.ggV.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cM(final List<c> list) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.ggV != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.ggV.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.ggV.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.ggV != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.ggV.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.ggV != null) {
                this.ggV.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.ggV != null) {
                if (isCancelled()) {
                    this.ggV.onCanceled();
                } else {
                    this.ggV.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.ggV != null) {
                this.ggV.onCanceled();
            }
        }
    }

    public void aM(String str, int i) {
        j.bso().aO(str, i);
    }

    public void aN(String str, int i) {
        com.baidu.tieba.im.memorycache.b.buC().aN(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aT = com.baidu.tieba.im.memorycache.b.buC().aT(str, i);
        if (aT != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().nL(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().iz(com.baidu.adp.lib.g.b.l(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().iA(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().iA(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().nK(str);
            }
            aT.setIs_hidden(1);
            aT.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.buC().aU(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.buC().f(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.buC().f(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d dY(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(d.j.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.ggT);
        return dVar;
    }
}
