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
    private static e eQZ;
    private a eRa;
    private final DialogInterface.OnCancelListener eRb = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.aRF();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cE(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e aRE() {
        if (eQZ == null) {
            synchronized (e.class) {
                if (eQZ == null) {
                    eQZ = new e();
                }
            }
        }
        return eQZ;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                qq(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                qo(str);
            } else if (4 == i) {
                qp(str);
            } else if (-3 == i) {
                aq(str, i);
            } else if (-4 == i) {
                aq(str, i);
            } else {
                aq(str, i);
            }
        }
    }

    public void qo(String str) {
        try {
            try {
                h.aRJ().aRK();
                ar(str, 2);
                m.aRU().qg(str);
                h.aRJ().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aRJ().endTransaction();
            }
        } catch (Throwable th) {
            h.aRJ().endTransaction();
            throw th;
        }
    }

    public void qp(String str) {
        try {
            try {
                h.aRJ().aRK();
                ar(str, 4);
                l.aRS().qg(str);
                h.aRJ().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aRJ().endTransaction();
            }
        } catch (Throwable th) {
            h.aRJ().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.aRJ().aRK();
            if (v.I(list)) {
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
                if (aRG()) {
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
            h.aRJ().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.aRJ().aRK();
            if (!v.I(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (aRG()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.d(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        ar(friendId, 4);
                        l.aRS().qg(friendId);
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
            h.aRJ().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.aRJ().aRK();
            List<String> aRY = n.aRY();
            if (v.I(aRY)) {
                return;
            }
            int size = aRY.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (aRG()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.b(aRY, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (aRG()) {
                return;
            }
            ar("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aRJ().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.qt(cC(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.aRU().qh(str);
                if (aRG()) {
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
                bVar.cE(arrayList);
            }
        }
    }

    private String cC(List<String> list) {
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
            h.aRJ().aRK();
            l.aRS();
            List<String> aRT = l.aRT();
            if (v.I(aRT)) {
                return;
            }
            int size = aRT.size();
            int i = 0;
            for (String str : aRT) {
                if (aRG()) {
                    break;
                }
                ar(str, 4);
                l.aRS().qg(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (aRG()) {
                return;
            }
            ar("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aRJ().endTransaction();
        }
    }

    public void aq(String str, int i) {
        try {
            try {
                h.aRJ().aRK();
                ImMessageCenterPojo ay = com.baidu.tieba.im.memorycache.b.aUa().ay(str, i);
                ay.setIs_hidden(1);
                ay.setUnread_count(0);
                j.aRM().a(ay, 2);
                h.aRJ().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aRJ().endTransaction();
            }
        } catch (Throwable th) {
            h.aRJ().endTransaction();
            throw th;
        }
    }

    public void qq(String str) {
        try {
            h.aRJ().aRK();
            ImMessageCenterPojo ay = com.baidu.tieba.im.memorycache.b.aUa().ay(str, 1);
            ay.setIs_hidden(1);
            ay.setUnread_count(0);
            j.aRM().a(ay, 2);
            com.baidu.tieba.im.db.c.aRC().qh(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.aRJ().endTransaction();
        }
    }

    public boolean aRF() {
        if (this.eRa != null && this.eRa.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.eRa.cancel(true);
        }
        this.eRa = null;
        return true;
    }

    public boolean aRG() {
        return this.eRa == null || (this.eRa != null && this.eRa.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eRa = new a(i, bVar);
        this.eRa.setParallel(TiebaIMConfig.getParallel());
        this.eRa.setPriority(3);
        this.eRa.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eRa = new a(i, bVar);
        this.eRa.setParallel(TiebaIMConfig.getParallel());
        this.eRa.setPriority(3);
        this.eRa.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b eRd;
        private b eRe = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void cE(List<c> list) {
                a.this.cD(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.eRd = bVar;
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
                        e.this.b(list, this.eRe);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.eRe);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.eRe);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eRd != null) {
                        a.this.eRd.onProgressUpdate(i, str, i2);
                        a.this.eRd.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cD(final List<c> list) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.eRd != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.eRd.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.eRd.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.eRd != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.eRd.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.eRd != null) {
                this.eRd.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.eRd != null) {
                if (isCancelled()) {
                    this.eRd.onCanceled();
                } else {
                    this.eRd.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eRd != null) {
                this.eRd.onCanceled();
            }
        }
    }

    public void ar(String str, int i) {
        j.aRM().at(str, i);
    }

    public void as(String str, int i) {
        com.baidu.tieba.im.memorycache.b.aUa().as(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo ay = com.baidu.tieba.im.memorycache.b.aUa().ay(str, i);
        if (ay != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.a.If().gY(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.If().eU(com.baidu.adp.lib.g.b.l(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.a.If().eV(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.If().eV(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.a.If().gX(str);
            }
            ay.setIs_hidden(1);
            ay.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.aUa().az(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.aUa().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.aUa().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d cD(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(e.j.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.eRb);
        return dVar;
    }
}
