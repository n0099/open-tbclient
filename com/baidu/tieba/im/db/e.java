package com.baidu.tieba.im.db;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e kEI;
    private a kEJ;
    private final DialogInterface.OnCancelListener kEK = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cVv();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void ex(List<c> list);

        void f(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e cVu() {
        if (kEI == null) {
            synchronized (e.class) {
                if (kEI == null) {
                    kEI = new e();
                }
            }
        }
        return kEI;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                MO(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                MM(str);
            } else if (4 == i) {
                MN(str);
            } else if (-3 == i) {
                bl(str, i);
            } else if (-4 == i) {
                bl(str, i);
            } else {
                bl(str, i);
            }
        }
    }

    public void MM(String str) {
        try {
            try {
                h.cVz().cVA();
                bm(str, 2);
                m.cVM().ME(str);
                h.cVz().cVB();
            } catch (Exception e) {
                e.printStackTrace();
                h.cVz().cVB();
            }
        } catch (Throwable th) {
            h.cVz().cVB();
            throw th;
        }
    }

    public void MN(String str) {
        try {
            try {
                h.cVz().cVA();
                bm(str, 4);
                l.cVJ().ME(str);
                h.cVz().cVB();
            } catch (Exception e) {
                e.printStackTrace();
                h.cVz().cVB();
            }
        } catch (Throwable th) {
            h.cVz().cVB();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.cVz().cVA();
            if (y.isEmpty(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (int size = list.size() - 1; size >= 0; size--) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) y.getItem(list, size);
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
                if (cVw()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size2;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(y.subList(arrayList, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cVz().cVB();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.cVz().cVA();
            if (!y.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (cVw()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) y.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        bm(friendId, 4);
                        l.cVJ().ME(friendId);
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
            h.cVz().cVB();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.cVz().cVA();
            List<String> cVQ = n.cVQ();
            if (y.isEmpty(cVQ)) {
                return;
            }
            int size = cVQ.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cVw()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(y.subList(cVQ, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (cVw()) {
                return;
            }
            bm(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cVz().cVB();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.MS(ev(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.cVM().MF(str);
                if (cVw()) {
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
                bVar.ex(arrayList);
            }
        }
    }

    private String ev(List<String> list) {
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
            h.cVz().cVA();
            l.cVJ();
            List<String> cVK = l.cVK();
            if (y.isEmpty(cVK)) {
                return;
            }
            int size = cVK.size();
            int i = 0;
            for (String str : cVK) {
                if (cVw()) {
                    break;
                }
                bm(str, 4);
                l.cVJ().ME(str);
                i++;
                if (bVar != null) {
                    bVar.f((i * 100) / size, str, 4);
                }
            }
            if (cVw()) {
                return;
            }
            bm(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cVz().cVB();
        }
    }

    public void bl(String str, int i) {
        try {
            try {
                h.cVz().cVA();
                ImMessageCenterPojo bs = com.baidu.tieba.im.memorycache.b.cWE().bs(str, i);
                bs.setIs_hidden(1);
                bs.setUnread_count(0);
                j.cVD().a(bs, 2);
                h.cVz().cVB();
            } catch (Exception e) {
                e.printStackTrace();
                h.cVz().cVB();
            }
        } catch (Throwable th) {
            h.cVz().cVB();
            throw th;
        }
    }

    public void MO(String str) {
        try {
            h.cVz().cVA();
            ImMessageCenterPojo bs = com.baidu.tieba.im.memorycache.b.cWE().bs(str, 1);
            bs.setIs_hidden(1);
            bs.setUnread_count(0);
            j.cVD().a(bs, 2);
            com.baidu.tieba.im.db.c.cVs().MF(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.cVz().cVB();
        }
    }

    public boolean cVv() {
        if (this.kEJ != null && this.kEJ.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.kEJ.cancel(true);
        }
        this.kEJ = null;
        return true;
    }

    public boolean cVw() {
        return this.kEJ == null || (this.kEJ != null && this.kEJ.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.kEJ = new a(i, bVar);
        this.kEJ.setParallel(TiebaIMConfig.getParallel());
        this.kEJ.setPriority(3);
        this.kEJ.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.kEJ = new a(i, bVar);
        this.kEJ.setParallel(TiebaIMConfig.getParallel());
        this.kEJ.setPriority(3);
        this.kEJ.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b kEM;
        private b kEN = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void ex(List<c> list) {
                a.this.ew(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.kEM = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    if (this.mCustomGroupType == 4) {
                        e.this.b(list, this.kEN);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.kEN);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.kEN);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(final int i, final String str, final int i2) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.kEM != null) {
                        a.this.kEM.onProgressUpdate(i, str, i2);
                        a.this.kEM.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ew(final List<c> list) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.kEM != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.kEM.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.kEM.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.kEM != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.kEM.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.kEM != null) {
                this.kEM.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.kEM != null) {
                if (isCancelled()) {
                    this.kEM.onCanceled();
                } else {
                    this.kEM.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.kEM != null) {
                this.kEM.onCanceled();
            }
        }
    }

    public void bm(String str, int i) {
        j.cVD().bo(str, i);
    }

    public void bn(String str, int i) {
        com.baidu.tieba.im.memorycache.b.cWE().bn(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo bs = com.baidu.tieba.im.memorycache.b.cWE().bs(str, i);
        if (bs != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().Ca(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().qq(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().qr(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().qr(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().BZ(str);
            }
            bs.setIs_hidden(1);
            bs.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.cWE().bt(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.cWE().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.cWE().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d gw(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.kEK);
        return dVar;
    }
}
