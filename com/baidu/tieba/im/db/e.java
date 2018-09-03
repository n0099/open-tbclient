package com.baidu.tieba.im.db;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e eqh;
    private a eqi;
    private final DialogInterface.OnCancelListener eqj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.aJz();
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

    public static e aJy() {
        if (eqh == null) {
            synchronized (e.class) {
                if (eqh == null) {
                    eqh = new e();
                }
            }
        }
        return eqh;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                om(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                ok(str);
            } else if (4 == i) {
                ol(str);
            } else if (-3 == i) {
                af(str, i);
            } else if (-4 == i) {
                af(str, i);
            } else {
                af(str, i);
            }
        }
    }

    public void ok(String str) {
        try {
            try {
                h.aJD().aJE();
                ag(str, 2);
                m.aJO().ob(str);
                h.aJD().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aJD().endTransaction();
            }
        } catch (Throwable th) {
            h.aJD().endTransaction();
            throw th;
        }
    }

    public void ol(String str) {
        try {
            try {
                h.aJD().aJE();
                ag(str, 4);
                l.aJM().ob(str);
                h.aJD().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aJD().endTransaction();
            }
        } catch (Throwable th) {
            h.aJD().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.aJD().aJE();
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
                if (aJA()) {
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
            h.aJD().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.aJD().aJE();
            if (!w.z(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (aJA()) {
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
                        l.aJM().ob(friendId);
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
            h.aJD().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.aJD().aJE();
            List<String> aJS = n.aJS();
            if (w.z(aJS)) {
                return;
            }
            int size = aJS.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (aJA()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(w.a(aJS, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (aJA()) {
                return;
            }
            ag("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aJD().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.oq(ci(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.aJO().oc(str);
                if (aJA()) {
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
            h.aJD().aJE();
            l.aJM();
            List<String> aJN = l.aJN();
            if (w.z(aJN)) {
                return;
            }
            int size = aJN.size();
            int i = 0;
            for (String str : aJN) {
                if (aJA()) {
                    break;
                }
                ag(str, 4);
                l.aJM().ob(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (aJA()) {
                return;
            }
            ag("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aJD().endTransaction();
        }
    }

    public void af(String str, int i) {
        try {
            try {
                h.aJD().aJE();
                ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aLV().an(str, i);
                an.setIs_hidden(1);
                an.setUnread_count(0);
                j.aJG().a(an, 2);
                h.aJD().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aJD().endTransaction();
            }
        } catch (Throwable th) {
            h.aJD().endTransaction();
            throw th;
        }
    }

    public void om(String str) {
        try {
            h.aJD().aJE();
            ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aLV().an(str, 1);
            an.setIs_hidden(1);
            an.setUnread_count(0);
            j.aJG().a(an, 2);
            com.baidu.tieba.im.db.c.aJw().oc(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.aJD().endTransaction();
        }
    }

    public boolean aJz() {
        if (this.eqi != null && this.eqi.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.eqi.cancel(true);
        }
        this.eqi = null;
        return true;
    }

    public boolean aJA() {
        return this.eqi == null || (this.eqi != null && this.eqi.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eqi = new a(i, bVar);
        this.eqi.setParallel(TiebaIMConfig.getParallel());
        this.eqi.setPriority(3);
        this.eqi.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eqi = new a(i, bVar);
        this.eqi.setParallel(TiebaIMConfig.getParallel());
        this.eqi.setPriority(3);
        this.eqi.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b eql;
        private b eqm = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            this.eql = bVar;
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
                        e.this.b(list, this.eqm);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.eqm);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.eqm);
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
                    if (a.this.eql != null) {
                        a.this.eql.onProgressUpdate(i, str, i2);
                        a.this.eql.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cj(final List<c> list) {
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.eql != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.eql.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.eql.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.eql != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.eql.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.eql != null) {
                this.eql.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.eql != null) {
                if (isCancelled()) {
                    this.eql.onCanceled();
                } else {
                    this.eql.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eql != null) {
                this.eql.onCanceled();
            }
        }
    }

    public void ag(String str, int i) {
        j.aJG().ai(str, i);
    }

    public void ah(String str, int i) {
        com.baidu.tieba.im.memorycache.b.aLV().ah(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aLV().an(str, i);
        if (an != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fG(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dW(com.baidu.adp.lib.g.b.g(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dX(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dX(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fF(str);
            }
            an.setIs_hidden(1);
            an.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.aLV().ao(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.aLV().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.aLV().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d bK(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(f.j.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.eqj);
        return dVar;
    }
}
