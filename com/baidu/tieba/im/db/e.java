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
    private static e eiz;
    private a eiA;
    private final DialogInterface.OnCancelListener eiB = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.aHU();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cg(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e aHT() {
        if (eiz == null) {
            synchronized (e.class) {
                if (eiz == null) {
                    eiz = new e();
                }
            }
        }
        return eiz;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                oh(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                oe(str);
            } else if (4 == i) {
                og(str);
            } else if (-3 == i) {
                ak(str, i);
            } else if (-4 == i) {
                ak(str, i);
            } else {
                ak(str, i);
            }
        }
    }

    public void oe(String str) {
        try {
            try {
                h.aHY().aHZ();
                al(str, 2);
                m.aIj().nW(str);
                h.aHY().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aHY().endTransaction();
            }
        } catch (Throwable th) {
            h.aHY().endTransaction();
            throw th;
        }
    }

    public void og(String str) {
        try {
            try {
                h.aHY().aHZ();
                al(str, 4);
                l.aIh().nW(str);
                h.aHY().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aHY().endTransaction();
            }
        } catch (Throwable th) {
            h.aHY().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.aHY().aHZ();
            if (w.z(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (int size = list.size() - 1; size >= 0; size--) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) w.c(list, size);
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
                if (aHV()) {
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
            h.aHY().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.aHY().aHZ();
            if (!w.z(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (aHV()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) w.c(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        al(friendId, 4);
                        l.aIh().nW(friendId);
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
            h.aHY().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.aHY().aHZ();
            List<String> aIn = n.aIn();
            if (w.z(aIn)) {
                return;
            }
            int size = aIn.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (aHV()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(w.a(aIn, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (aHV()) {
                return;
            }
            al("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aHY().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.ok(ce(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.aIj().nX(str);
                if (aHV()) {
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
                bVar.cg(arrayList);
            }
        }
    }

    private String ce(List<String> list) {
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
            h.aHY().aHZ();
            l.aIh();
            List<String> aIi = l.aIi();
            if (w.z(aIi)) {
                return;
            }
            int size = aIi.size();
            int i = 0;
            for (String str : aIi) {
                if (aHV()) {
                    break;
                }
                al(str, 4);
                l.aIh().nW(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (aHV()) {
                return;
            }
            al("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aHY().endTransaction();
        }
    }

    public void ak(String str, int i) {
        try {
            try {
                h.aHY().aHZ();
                ImMessageCenterPojo as = com.baidu.tieba.im.memorycache.b.aKr().as(str, i);
                as.setIs_hidden(1);
                as.setUnread_count(0);
                j.aIb().a(as, 2);
                h.aHY().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aHY().endTransaction();
            }
        } catch (Throwable th) {
            h.aHY().endTransaction();
            throw th;
        }
    }

    public void oh(String str) {
        try {
            h.aHY().aHZ();
            ImMessageCenterPojo as = com.baidu.tieba.im.memorycache.b.aKr().as(str, 1);
            as.setIs_hidden(1);
            as.setUnread_count(0);
            j.aIb().a(as, 2);
            com.baidu.tieba.im.db.c.aHR().nX(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.aHY().endTransaction();
        }
    }

    public boolean aHU() {
        if (this.eiA != null && this.eiA.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.eiA.cancel(true);
        }
        this.eiA = null;
        return true;
    }

    public boolean aHV() {
        return this.eiA == null || (this.eiA != null && this.eiA.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eiA = new a(i, bVar);
        this.eiA.setParallel(TiebaIMConfig.getParallel());
        this.eiA.setPriority(3);
        this.eiA.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eiA = new a(i, bVar);
        this.eiA.setParallel(TiebaIMConfig.getParallel());
        this.eiA.setPriority(3);
        this.eiA.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b eiD;
        private b eiE = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void cg(List<c> list) {
                a.this.cf(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.eiD = bVar;
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
                        e.this.b(list, this.eiE);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.eiE);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.eiE);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eiD != null) {
                        a.this.eiD.onProgressUpdate(i, str, i2);
                        a.this.eiD.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cf(final List<c> list) {
            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.eiD != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.eiD.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.eiD.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.eiD != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.eiD.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.eiD != null) {
                this.eiD.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.eiD != null) {
                if (isCancelled()) {
                    this.eiD.onCanceled();
                } else {
                    this.eiD.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eiD != null) {
                this.eiD.onCanceled();
            }
        }
    }

    public void al(String str, int i) {
        j.aIb().an(str, i);
    }

    public void am(String str, int i) {
        com.baidu.tieba.im.memorycache.b.aKr().am(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo as = com.baidu.tieba.im.memorycache.b.aKr().as(str, i);
        if (as != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.a.CX().fE(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.CX().dT(com.baidu.adp.lib.g.b.g(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.a.CX().dU(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.CX().dU(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.a.CX().fD(str);
            }
            as.setIs_hidden(1);
            as.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.aKr().at(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.aKr().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.aKr().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d bK(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(d.k.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.eiB);
        return dVar;
    }
}
