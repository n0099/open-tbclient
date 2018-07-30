package com.baidu.tieba.im.db;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e eql;
    private a eqm;
    private final DialogInterface.OnCancelListener eqn = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.aJC();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void ck(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e aJB() {
        if (eql == null) {
            synchronized (e.class) {
                if (eql == null) {
                    eql = new e();
                }
            }
        }
        return eql;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                ok(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                oi(str);
            } else if (4 == i) {
                oj(str);
            } else if (-3 == i) {
                af(str, i);
            } else if (-4 == i) {
                af(str, i);
            } else {
                af(str, i);
            }
        }
    }

    public void oi(String str) {
        try {
            try {
                h.aJG().aJH();
                ag(str, 2);
                m.aJR().nZ(str);
                h.aJG().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aJG().endTransaction();
            }
        } catch (Throwable th) {
            h.aJG().endTransaction();
            throw th;
        }
    }

    public void oj(String str) {
        try {
            try {
                h.aJG().aJH();
                ag(str, 4);
                l.aJP().nZ(str);
                h.aJG().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aJG().endTransaction();
            }
        } catch (Throwable th) {
            h.aJG().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.aJG().aJH();
            if (w.z(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (int size = list.size() - 1; size >= 0; size--) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) w.d(list, size);
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
                if (aJD()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size2;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(w.a(arrayList, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aJG().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.aJG().aJH();
            if (!w.z(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (aJD()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) w.d(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        ag(friendId, 4);
                        l.aJP().nZ(friendId);
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
            h.aJG().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.aJG().aJH();
            List<String> aJV = n.aJV();
            if (w.z(aJV)) {
                return;
            }
            int size = aJV.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (aJD()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(w.a(aJV, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (aJD()) {
                return;
            }
            ag("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aJG().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.oo(ci(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.aJR().oa(str);
                if (aJD()) {
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
                bVar.ck(arrayList);
            }
        }
    }

    private String ci(List<String> list) {
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
            h.aJG().aJH();
            l.aJP();
            List<String> aJQ = l.aJQ();
            if (w.z(aJQ)) {
                return;
            }
            int size = aJQ.size();
            int i = 0;
            for (String str : aJQ) {
                if (aJD()) {
                    break;
                }
                ag(str, 4);
                l.aJP().nZ(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (aJD()) {
                return;
            }
            ag("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aJG().endTransaction();
        }
    }

    public void af(String str, int i) {
        try {
            try {
                h.aJG().aJH();
                ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aLY().an(str, i);
                an.setIs_hidden(1);
                an.setUnread_count(0);
                j.aJJ().a(an, 2);
                h.aJG().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aJG().endTransaction();
            }
        } catch (Throwable th) {
            h.aJG().endTransaction();
            throw th;
        }
    }

    public void ok(String str) {
        try {
            h.aJG().aJH();
            ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aLY().an(str, 1);
            an.setIs_hidden(1);
            an.setUnread_count(0);
            j.aJJ().a(an, 2);
            com.baidu.tieba.im.db.c.aJz().oa(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.aJG().endTransaction();
        }
    }

    public boolean aJC() {
        if (this.eqm != null && this.eqm.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.eqm.cancel(true);
        }
        this.eqm = null;
        return true;
    }

    public boolean aJD() {
        return this.eqm == null || (this.eqm != null && this.eqm.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eqm = new a(i, bVar);
        this.eqm.setParallel(TiebaIMConfig.getParallel());
        this.eqm.setPriority(3);
        this.eqm.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eqm = new a(i, bVar);
        this.eqm.setParallel(TiebaIMConfig.getParallel());
        this.eqm.setPriority(3);
        this.eqm.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b eqp;
        private b eqq = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void ck(List<c> list) {
                a.this.cj(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.eqp = bVar;
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
                        e.this.b(list, this.eqq);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.eqq);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.eqq);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eqp != null) {
                        a.this.eqp.onProgressUpdate(i, str, i2);
                        a.this.eqp.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cj(final List<c> list) {
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.eqp != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.eqp.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.eqp.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.eqp != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.eqp.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.eqp != null) {
                this.eqp.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.eqp != null) {
                if (isCancelled()) {
                    this.eqp.onCanceled();
                } else {
                    this.eqp.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eqp != null) {
                this.eqp.onCanceled();
            }
        }
    }

    public void ag(String str, int i) {
        j.aJJ().ai(str, i);
    }

    public void ah(String str, int i) {
        com.baidu.tieba.im.memorycache.b.aLY().ah(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aLY().an(str, i);
        if (an != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fG(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dX(com.baidu.adp.lib.g.b.g(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dY(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dY(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fF(str);
            }
            an.setIs_hidden(1);
            an.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.aLY().ao(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.aLY().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.aLY().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d bK(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(d.j.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.eqn);
        return dVar;
    }
}
