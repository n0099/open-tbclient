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
    private static e gyf;
    private a gyg;
    private final DialogInterface.OnCancelListener gyh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bzW();
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

    public static e bzV() {
        if (gyf == null) {
            synchronized (e.class) {
                if (gyf == null) {
                    gyf = new e();
                }
            }
        }
        return gyf;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                yi(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                yg(str);
            } else if (4 == i) {
                yh(str);
            } else if (-3 == i) {
                aH(str, i);
            } else if (-4 == i) {
                aH(str, i);
            } else {
                aH(str, i);
            }
        }
    }

    public void yg(String str) {
        try {
            try {
                h.bAa().bAb();
                aI(str, 2);
                m.bAl().xY(str);
                h.bAa().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAa().endTransaction();
            }
        } catch (Throwable th) {
            h.bAa().endTransaction();
            throw th;
        }
    }

    public void yh(String str) {
        try {
            try {
                h.bAa().bAb();
                aI(str, 4);
                l.bAj().xY(str);
                h.bAa().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAa().endTransaction();
            }
        } catch (Throwable th) {
            h.bAa().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bAa().bAb();
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
                if (bzX()) {
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
            h.bAa().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bAa().bAb();
            if (!v.aa(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bzX()) {
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
                        l.bAj().xY(friendId);
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
            h.bAa().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bAa().bAb();
            List<String> bAp = n.bAp();
            if (v.aa(bAp)) {
                return;
            }
            int size = bAp.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bzX()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.c(bAp, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bzX()) {
                return;
            }
            aI("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAa().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.yl(cT(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bAl().xZ(str);
                if (bzX()) {
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
            h.bAa().bAb();
            l.bAj();
            List<String> bAk = l.bAk();
            if (v.aa(bAk)) {
                return;
            }
            int size = bAk.size();
            int i = 0;
            for (String str : bAk) {
                if (bzX()) {
                    break;
                }
                aI(str, 4);
                l.bAj().xY(str);
                i++;
                if (bVar != null) {
                    bVar.f((i * 100) / size, str, 4);
                }
            }
            if (bzX()) {
                return;
            }
            aI("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAa().endTransaction();
        }
    }

    public void aH(String str, int i) {
        try {
            try {
                h.bAa().bAb();
                ImMessageCenterPojo aP = com.baidu.tieba.im.memorycache.b.bCr().aP(str, i);
                aP.setIs_hidden(1);
                aP.setUnread_count(0);
                j.bAd().a(aP, 2);
                h.bAa().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAa().endTransaction();
            }
        } catch (Throwable th) {
            h.bAa().endTransaction();
            throw th;
        }
    }

    public void yi(String str) {
        try {
            h.bAa().bAb();
            ImMessageCenterPojo aP = com.baidu.tieba.im.memorycache.b.bCr().aP(str, 1);
            aP.setIs_hidden(1);
            aP.setUnread_count(0);
            j.bAd().a(aP, 2);
            com.baidu.tieba.im.db.c.bzT().xZ(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bAa().endTransaction();
        }
    }

    public boolean bzW() {
        if (this.gyg != null && this.gyg.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.gyg.cancel(true);
        }
        this.gyg = null;
        return true;
    }

    public boolean bzX() {
        return this.gyg == null || (this.gyg != null && this.gyg.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gyg = new a(i, bVar);
        this.gyg.setParallel(TiebaIMConfig.getParallel());
        this.gyg.setPriority(3);
        this.gyg.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gyg = new a(i, bVar);
        this.gyg.setParallel(TiebaIMConfig.getParallel());
        this.gyg.setPriority(3);
        this.gyg.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b gyj;
        private b gyk = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            this.gyj = bVar;
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
                        e.this.b(list, this.gyk);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.gyk);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.gyk);
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
                    if (a.this.gyj != null) {
                        a.this.gyj.onProgressUpdate(i, str, i2);
                        a.this.gyj.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cU(final List<c> list) {
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.gyj != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.gyj.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.gyj.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.gyj != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.gyj.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.gyj != null) {
                this.gyj.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.gyj != null) {
                if (isCancelled()) {
                    this.gyj.onCanceled();
                } else {
                    this.gyj.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.gyj != null) {
                this.gyj.onCanceled();
            }
        }
    }

    public void aI(String str, int i) {
        j.bAd().aK(str, i);
    }

    public void aJ(String str, int i) {
        com.baidu.tieba.im.memorycache.b.bCr().aJ(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aP = com.baidu.tieba.im.memorycache.b.bCr().aP(str, i);
        if (aP != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().oV(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().jn(com.baidu.adp.lib.g.b.f(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().jo(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().jo(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().oU(str);
            }
            aP.setIs_hidden(1);
            aP.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.bCr().aQ(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.bCr().f(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.bCr().f(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d dO(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.gyh);
        return dVar;
    }
}
