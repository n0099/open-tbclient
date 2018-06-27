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
    private static e ems;
    private a emt;
    private final DialogInterface.OnCancelListener emu = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.aIB();
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

    public static e aIA() {
        if (ems == null) {
            synchronized (e.class) {
                if (ems == null) {
                    ems = new e();
                }
            }
        }
        return ems;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                oi(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                og(str);
            } else if (4 == i) {
                oh(str);
            } else if (-3 == i) {
                aj(str, i);
            } else if (-4 == i) {
                aj(str, i);
            } else {
                aj(str, i);
            }
        }
    }

    public void og(String str) {
        try {
            try {
                h.aIF().aIG();
                ak(str, 2);
                m.aIQ().nX(str);
                h.aIF().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aIF().endTransaction();
            }
        } catch (Throwable th) {
            h.aIF().endTransaction();
            throw th;
        }
    }

    public void oh(String str) {
        try {
            try {
                h.aIF().aIG();
                ak(str, 4);
                l.aIO().nX(str);
                h.aIF().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aIF().endTransaction();
            }
        } catch (Throwable th) {
            h.aIF().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.aIF().aIG();
            if (w.A(list)) {
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
                if (aIC()) {
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
            h.aIF().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.aIF().aIG();
            if (!w.A(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (aIC()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) w.d(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        ak(friendId, 4);
                        l.aIO().nX(friendId);
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
            h.aIF().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.aIF().aIG();
            List<String> aIU = n.aIU();
            if (w.A(aIU)) {
                return;
            }
            int size = aIU.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (aIC()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(w.a(aIU, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (aIC()) {
                return;
            }
            ak("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aIF().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.ol(ci(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.aIQ().nY(str);
                if (aIC()) {
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
            h.aIF().aIG();
            l.aIO();
            List<String> aIP = l.aIP();
            if (w.A(aIP)) {
                return;
            }
            int size = aIP.size();
            int i = 0;
            for (String str : aIP) {
                if (aIC()) {
                    break;
                }
                ak(str, 4);
                l.aIO().nX(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (aIC()) {
                return;
            }
            ak("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aIF().endTransaction();
        }
    }

    public void aj(String str, int i) {
        try {
            try {
                h.aIF().aIG();
                ImMessageCenterPojo ar = com.baidu.tieba.im.memorycache.b.aKX().ar(str, i);
                ar.setIs_hidden(1);
                ar.setUnread_count(0);
                j.aII().a(ar, 2);
                h.aIF().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aIF().endTransaction();
            }
        } catch (Throwable th) {
            h.aIF().endTransaction();
            throw th;
        }
    }

    public void oi(String str) {
        try {
            h.aIF().aIG();
            ImMessageCenterPojo ar = com.baidu.tieba.im.memorycache.b.aKX().ar(str, 1);
            ar.setIs_hidden(1);
            ar.setUnread_count(0);
            j.aII().a(ar, 2);
            com.baidu.tieba.im.db.c.aIy().nY(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.aIF().endTransaction();
        }
    }

    public boolean aIB() {
        if (this.emt != null && this.emt.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.emt.cancel(true);
        }
        this.emt = null;
        return true;
    }

    public boolean aIC() {
        return this.emt == null || (this.emt != null && this.emt.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.emt = new a(i, bVar);
        this.emt.setParallel(TiebaIMConfig.getParallel());
        this.emt.setPriority(3);
        this.emt.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.emt = new a(i, bVar);
        this.emt.setParallel(TiebaIMConfig.getParallel());
        this.emt.setPriority(3);
        this.emt.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b emw;
        private b emx = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            this.emw = bVar;
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
                        e.this.b(list, this.emx);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.emx);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.emx);
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
                    if (a.this.emw != null) {
                        a.this.emw.onProgressUpdate(i, str, i2);
                        a.this.emw.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cj(final List<c> list) {
            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.emw != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.emw.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.emw.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.emw != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.emw.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.emw != null) {
                this.emw.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.emw != null) {
                if (isCancelled()) {
                    this.emw.onCanceled();
                } else {
                    this.emw.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.emw != null) {
                this.emw.onCanceled();
            }
        }
    }

    public void ak(String str, int i) {
        j.aII().am(str, i);
    }

    public void al(String str, int i) {
        com.baidu.tieba.im.memorycache.b.aKX().al(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo ar = com.baidu.tieba.im.memorycache.b.aKX().ar(str, i);
        if (ar != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dp().fI(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dp().dU(com.baidu.adp.lib.g.b.g(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dp().dV(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dp().dV(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dp().fH(str);
            }
            ar.setIs_hidden(1);
            ar.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.aKX().as(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.aKX().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.aKX().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d bJ(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(d.k.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.emu);
        return dVar;
    }
}
