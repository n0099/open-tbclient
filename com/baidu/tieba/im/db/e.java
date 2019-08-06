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
    private static e gFk;
    private a gFl;
    private final DialogInterface.OnCancelListener gFm = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bCQ();
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

    public static e bCP() {
        if (gFk == null) {
            synchronized (e.class) {
                if (gFk == null) {
                    gFk = new e();
                }
            }
        }
        return gFk;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                yV(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                yT(str);
            } else if (4 == i) {
                yU(str);
            } else if (-3 == i) {
                aI(str, i);
            } else if (-4 == i) {
                aI(str, i);
            } else {
                aI(str, i);
            }
        }
    }

    public void yT(String str) {
        try {
            try {
                h.bCU().bCV();
                aJ(str, 2);
                m.bDg().yL(str);
                h.bCU().bCW();
            } catch (Exception e) {
                e.printStackTrace();
                h.bCU().bCW();
            }
        } catch (Throwable th) {
            h.bCU().bCW();
            throw th;
        }
    }

    public void yU(String str) {
        try {
            try {
                h.bCU().bCV();
                aJ(str, 4);
                l.bDe().yL(str);
                h.bCU().bCW();
            } catch (Exception e) {
                e.printStackTrace();
                h.bCU().bCW();
            }
        } catch (Throwable th) {
            h.bCU().bCW();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bCU().bCV();
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
                if (bCR()) {
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
            h.bCU().bCW();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bCU().bCV();
            if (!v.aa(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bCR()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.c(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aJ(friendId, 4);
                        l.bDe().yL(friendId);
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
            h.bCU().bCW();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bCU().bCV();
            List<String> bDk = n.bDk();
            if (v.aa(bDk)) {
                return;
            }
            int size = bDk.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bCR()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.c(bDk, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bCR()) {
                return;
            }
            aJ("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bCU().bCW();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.yZ(cU(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bDg().yM(str);
                if (bCR()) {
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
            h.bCU().bCV();
            l.bDe();
            List<String> bDf = l.bDf();
            if (v.aa(bDf)) {
                return;
            }
            int size = bDf.size();
            int i = 0;
            for (String str : bDf) {
                if (bCR()) {
                    break;
                }
                aJ(str, 4);
                l.bDe().yL(str);
                i++;
                if (bVar != null) {
                    bVar.f((i * 100) / size, str, 4);
                }
            }
            if (bCR()) {
                return;
            }
            aJ("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bCU().bCW();
        }
    }

    public void aI(String str, int i) {
        try {
            try {
                h.bCU().bCV();
                ImMessageCenterPojo aQ = com.baidu.tieba.im.memorycache.b.bFn().aQ(str, i);
                aQ.setIs_hidden(1);
                aQ.setUnread_count(0);
                j.bCY().a(aQ, 2);
                h.bCU().bCW();
            } catch (Exception e) {
                e.printStackTrace();
                h.bCU().bCW();
            }
        } catch (Throwable th) {
            h.bCU().bCW();
            throw th;
        }
    }

    public void yV(String str) {
        try {
            h.bCU().bCV();
            ImMessageCenterPojo aQ = com.baidu.tieba.im.memorycache.b.bFn().aQ(str, 1);
            aQ.setIs_hidden(1);
            aQ.setUnread_count(0);
            j.bCY().a(aQ, 2);
            com.baidu.tieba.im.db.c.bCN().yM(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bCU().bCW();
        }
    }

    public boolean bCQ() {
        if (this.gFl != null && this.gFl.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.gFl.cancel(true);
        }
        this.gFl = null;
        return true;
    }

    public boolean bCR() {
        return this.gFl == null || (this.gFl != null && this.gFl.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gFl = new a(i, bVar);
        this.gFl.setParallel(TiebaIMConfig.getParallel());
        this.gFl.setPriority(3);
        this.gFl.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gFl = new a(i, bVar);
        this.gFl.setParallel(TiebaIMConfig.getParallel());
        this.gFl.setPriority(3);
        this.gFl.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b gFo;
        private b gFp = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            this.gFo = bVar;
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
                        e.this.b(list, this.gFp);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.gFp);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.gFp);
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
                    if (a.this.gFo != null) {
                        a.this.gFo.onProgressUpdate(i, str, i2);
                        a.this.gFo.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cV(final List<c> list) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.gFo != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.gFo.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.gFo.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.gFo != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.gFo.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.gFo != null) {
                this.gFo.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.gFo != null) {
                if (isCancelled()) {
                    this.gFo.onCanceled();
                } else {
                    this.gFo.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.gFo != null) {
                this.gFo.onCanceled();
            }
        }
    }

    public void aJ(String str, int i) {
        j.bCY().aL(str, i);
    }

    public void aK(String str, int i) {
        com.baidu.tieba.im.memorycache.b.bFn().aK(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aQ = com.baidu.tieba.im.memorycache.b.bFn().aQ(str, i);
        if (aQ != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anF().pl(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anF().ju(com.baidu.adp.lib.g.b.f(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anF().jv(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anF().jv(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.anF().pk(str);
            }
            aQ.setIs_hidden(1);
            aQ.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.bFn().aR(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.bFn().f(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.bFn().f(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d dQ(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.gFm);
        return dVar;
    }
}
