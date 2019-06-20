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
    private static e gyh;
    private a gyi;
    private final DialogInterface.OnCancelListener gyj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bzX();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cV(List<c> list);

        void f(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e bzW() {
        if (gyh == null) {
            synchronized (e.class) {
                if (gyh == null) {
                    gyh = new e();
                }
            }
        }
        return gyh;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                yk(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                yi(str);
            } else if (4 == i) {
                yj(str);
            } else if (-3 == i) {
                aH(str, i);
            } else if (-4 == i) {
                aH(str, i);
            } else {
                aH(str, i);
            }
        }
    }

    public void yi(String str) {
        try {
            try {
                h.bAb().bAc();
                aI(str, 2);
                m.bAm().ya(str);
                h.bAb().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAb().endTransaction();
            }
        } catch (Throwable th) {
            h.bAb().endTransaction();
            throw th;
        }
    }

    public void yj(String str) {
        try {
            try {
                h.bAb().bAc();
                aI(str, 4);
                l.bAk().ya(str);
                h.bAb().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAb().endTransaction();
            }
        } catch (Throwable th) {
            h.bAb().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bAb().bAc();
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
                if (bzY()) {
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
            h.bAb().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bAb().bAc();
            if (!v.aa(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bzY()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.c(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aI(friendId, 4);
                        l.bAk().ya(friendId);
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
            h.bAb().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bAb().bAc();
            List<String> bAq = n.bAq();
            if (v.aa(bAq)) {
                return;
            }
            int size = bAq.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bzY()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.c(bAq, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bzY()) {
                return;
            }
            aI("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAb().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.yn(cT(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bAm().yb(str);
                if (bzY()) {
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
                bVar.cV(arrayList);
            }
        }
    }

    private String cT(List<String> list) {
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
            h.bAb().bAc();
            l.bAk();
            List<String> bAl = l.bAl();
            if (v.aa(bAl)) {
                return;
            }
            int size = bAl.size();
            int i = 0;
            for (String str : bAl) {
                if (bzY()) {
                    break;
                }
                aI(str, 4);
                l.bAk().ya(str);
                i++;
                if (bVar != null) {
                    bVar.f((i * 100) / size, str, 4);
                }
            }
            if (bzY()) {
                return;
            }
            aI("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAb().endTransaction();
        }
    }

    public void aH(String str, int i) {
        try {
            try {
                h.bAb().bAc();
                ImMessageCenterPojo aP = com.baidu.tieba.im.memorycache.b.bCs().aP(str, i);
                aP.setIs_hidden(1);
                aP.setUnread_count(0);
                j.bAe().a(aP, 2);
                h.bAb().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAb().endTransaction();
            }
        } catch (Throwable th) {
            h.bAb().endTransaction();
            throw th;
        }
    }

    public void yk(String str) {
        try {
            h.bAb().bAc();
            ImMessageCenterPojo aP = com.baidu.tieba.im.memorycache.b.bCs().aP(str, 1);
            aP.setIs_hidden(1);
            aP.setUnread_count(0);
            j.bAe().a(aP, 2);
            com.baidu.tieba.im.db.c.bzU().yb(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bAb().endTransaction();
        }
    }

    public boolean bzX() {
        if (this.gyi != null && this.gyi.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.gyi.cancel(true);
        }
        this.gyi = null;
        return true;
    }

    public boolean bzY() {
        return this.gyi == null || (this.gyi != null && this.gyi.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gyi = new a(i, bVar);
        this.gyi.setParallel(TiebaIMConfig.getParallel());
        this.gyi.setPriority(3);
        this.gyi.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gyi = new a(i, bVar);
        this.gyi.setParallel(TiebaIMConfig.getParallel());
        this.gyi.setPriority(3);
        this.gyi.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b gyl;
        private b gym = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void cV(List<c> list) {
                a.this.cU(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.gyl = bVar;
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
                        e.this.b(list, this.gym);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.gym);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.gym);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gyl != null) {
                        a.this.gyl.onProgressUpdate(i, str, i2);
                        a.this.gyl.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cU(final List<c> list) {
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.gyl != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.gyl.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.gyl.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.gyl != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.gyl.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.gyl != null) {
                this.gyl.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.gyl != null) {
                if (isCancelled()) {
                    this.gyl.onCanceled();
                } else {
                    this.gyl.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.gyl != null) {
                this.gyl.onCanceled();
            }
        }
    }

    public void aI(String str, int i) {
        j.bAe().aK(str, i);
    }

    public void aJ(String str, int i) {
        com.baidu.tieba.im.memorycache.b.bCs().aJ(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aP = com.baidu.tieba.im.memorycache.b.bCs().aP(str, i);
        if (aP != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().oU(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().jn(com.baidu.adp.lib.g.b.f(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().jo(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().jo(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().oT(str);
            }
            aP.setIs_hidden(1);
            aP.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.bCs().aQ(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.bCs().f(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.bCs().f(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d dO(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.gyj);
        return dVar;
    }
}
