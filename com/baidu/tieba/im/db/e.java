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
    private static e dWi;
    private a dWj;
    private final DialogInterface.OnCancelListener dWk = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.aDb();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void bY(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e aDa() {
        if (dWi == null) {
            synchronized (e.class) {
                if (dWi == null) {
                    dWi = new e();
                }
            }
        }
        return dWi;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                nr(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                np(str);
            } else if (4 == i) {
                nq(str);
            } else if (-3 == i) {
                ah(str, i);
            } else if (-4 == i) {
                ah(str, i);
            } else {
                ah(str, i);
            }
        }
    }

    public void np(String str) {
        try {
            try {
                h.aDf().aDg();
                ai(str, 2);
                m.aDq().nh(str);
                h.aDf().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aDf().endTransaction();
            }
        } catch (Throwable th) {
            h.aDf().endTransaction();
            throw th;
        }
    }

    public void nq(String str) {
        try {
            try {
                h.aDf().aDg();
                ai(str, 4);
                l.aDo().nh(str);
                h.aDf().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aDf().endTransaction();
            }
        } catch (Throwable th) {
            h.aDf().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.aDf().aDg();
            if (v.w(list)) {
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
                if (aDc()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size2;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.a(arrayList, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aDf().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.aDf().aDg();
            if (!v.w(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (aDc()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.c(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        ai(friendId, 4);
                        l.aDo().nh(friendId);
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
            h.aDf().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.aDf().aDg();
            List<String> aDu = n.aDu();
            if (v.w(aDu)) {
                return;
            }
            int size = aDu.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (aDc()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.a(aDu, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (aDc()) {
                return;
            }
            ai("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aDf().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.nu(bW(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.aDq().ni(str);
                if (aDc()) {
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
                bVar.bY(arrayList);
            }
        }
    }

    private String bW(List<String> list) {
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
            h.aDf().aDg();
            l.aDo();
            List<String> aDp = l.aDp();
            if (v.w(aDp)) {
                return;
            }
            int size = aDp.size();
            int i = 0;
            for (String str : aDp) {
                if (aDc()) {
                    break;
                }
                ai(str, 4);
                l.aDo().nh(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (aDc()) {
                return;
            }
            ai("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aDf().endTransaction();
        }
    }

    public void ah(String str, int i) {
        try {
            try {
                h.aDf().aDg();
                ImMessageCenterPojo ap = com.baidu.tieba.im.memorycache.b.aFy().ap(str, i);
                ap.setIs_hidden(1);
                ap.setUnread_count(0);
                j.aDi().a(ap, 2);
                h.aDf().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aDf().endTransaction();
            }
        } catch (Throwable th) {
            h.aDf().endTransaction();
            throw th;
        }
    }

    public void nr(String str) {
        try {
            h.aDf().aDg();
            ImMessageCenterPojo ap = com.baidu.tieba.im.memorycache.b.aFy().ap(str, 1);
            ap.setIs_hidden(1);
            ap.setUnread_count(0);
            j.aDi().a(ap, 2);
            com.baidu.tieba.im.db.c.aCY().ni(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.aDf().endTransaction();
        }
    }

    public boolean aDb() {
        if (this.dWj != null && this.dWj.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.dWj.cancel(true);
        }
        this.dWj = null;
        return true;
    }

    public boolean aDc() {
        return this.dWj == null || (this.dWj != null && this.dWj.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.dWj = new a(i, bVar);
        this.dWj.setParallel(TiebaIMConfig.getParallel());
        this.dWj.setPriority(3);
        this.dWj.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.dWj = new a(i, bVar);
        this.dWj.setParallel(TiebaIMConfig.getParallel());
        this.dWj.setPriority(3);
        this.dWj.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b dWm;
        private b dWn = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void bY(List<c> list) {
                a.this.bX(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.dWm = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    if (this.mCustomGroupType == 4) {
                        e.this.b(list, this.dWn);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.dWn);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.dWn);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.dWm != null) {
                        a.this.dWm.onProgressUpdate(i, str, i2);
                        a.this.dWm.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bX(final List<c> list) {
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.dWm != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.dWm.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.dWm.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.dWm != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.dWm.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.dWm != null) {
                this.dWm.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.dWm != null) {
                if (isCancelled()) {
                    this.dWm.onCanceled();
                } else {
                    this.dWm.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.dWm != null) {
                this.dWm.onCanceled();
            }
        }
    }

    public void ai(String str, int i) {
        j.aDi().ak(str, i);
    }

    public void aj(String str, int i) {
        com.baidu.tieba.im.memorycache.b.aFy().aj(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo ap = com.baidu.tieba.im.memorycache.b.aFy().ap(str, i);
        if (ap != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.a.zx().fh(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.zx().dQ(com.baidu.adp.lib.g.b.g(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.a.zx().dR(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.zx().dR(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.a.zx().fg(str);
            }
            ap.setIs_hidden(1);
            ap.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.aFy().aq(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.aFy().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.aFy().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d bz(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(d.k.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.dWk);
        return dVar;
    }
}
