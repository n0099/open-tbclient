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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static e jlZ;
    private a jma;
    private final DialogInterface.OnCancelListener jmb = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cDZ();
        }
    };

    /* loaded from: classes2.dex */
    public interface b {
        void dF(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes2.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e cDY() {
        if (jlZ == null) {
            synchronized (e.class) {
                if (jlZ == null) {
                    jlZ = new e();
                }
            }
        }
        return jlZ;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                Ky(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                Kw(str);
            } else if (4 == i) {
                Kx(str);
            } else if (-3 == i) {
                aZ(str, i);
            } else if (-4 == i) {
                aZ(str, i);
            } else {
                aZ(str, i);
            }
        }
    }

    public void Kw(String str) {
        try {
            try {
                h.cEd().cEe();
                ba(str, 2);
                m.cEq().Ko(str);
                h.cEd().cEf();
            } catch (Exception e) {
                e.printStackTrace();
                h.cEd().cEf();
            }
        } catch (Throwable th) {
            h.cEd().cEf();
            throw th;
        }
    }

    public void Kx(String str) {
        try {
            try {
                h.cEd().cEe();
                ba(str, 4);
                l.cEn().Ko(str);
                h.cEd().cEf();
            } catch (Exception e) {
                e.printStackTrace();
                h.cEd().cEf();
            }
        } catch (Throwable th) {
            h.cEd().cEf();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.cEd().cEe();
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
                if (cEa()) {
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
            h.cEd().cEf();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.cEd().cEe();
            if (!y.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (cEa()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) y.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        ba(friendId, 4);
                        l.cEn().Ko(friendId);
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
            h.cEd().cEf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.cEd().cEe();
            List<String> cEu = n.cEu();
            if (y.isEmpty(cEu)) {
                return;
            }
            int size = cEu.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cEa()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(y.subList(cEu, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (cEa()) {
                return;
            }
            ba(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cEd().cEf();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.KC(dD(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.cEq().Kp(str);
                if (cEa()) {
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
                bVar.dF(arrayList);
            }
        }
    }

    private String dD(List<String> list) {
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
            h.cEd().cEe();
            l.cEn();
            List<String> cEo = l.cEo();
            if (y.isEmpty(cEo)) {
                return;
            }
            int size = cEo.size();
            int i = 0;
            for (String str : cEo) {
                if (cEa()) {
                    break;
                }
                ba(str, 4);
                l.cEn().Ko(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (cEa()) {
                return;
            }
            ba(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cEd().cEf();
        }
    }

    public void aZ(String str, int i) {
        try {
            try {
                h.cEd().cEe();
                ImMessageCenterPojo bh = com.baidu.tieba.im.memorycache.b.cGM().bh(str, i);
                bh.setIs_hidden(1);
                bh.setUnread_count(0);
                j.cEh().a(bh, 2);
                h.cEd().cEf();
            } catch (Exception e) {
                e.printStackTrace();
                h.cEd().cEf();
            }
        } catch (Throwable th) {
            h.cEd().cEf();
            throw th;
        }
    }

    public void Ky(String str) {
        try {
            h.cEd().cEe();
            ImMessageCenterPojo bh = com.baidu.tieba.im.memorycache.b.cGM().bh(str, 1);
            bh.setIs_hidden(1);
            bh.setUnread_count(0);
            j.cEh().a(bh, 2);
            com.baidu.tieba.im.db.c.cDW().Kp(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.cEd().cEf();
        }
    }

    public boolean cDZ() {
        if (this.jma != null && this.jma.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.jma.cancel(true);
        }
        this.jma = null;
        return true;
    }

    public boolean cEa() {
        return this.jma == null || (this.jma != null && this.jma.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.jma = new a(i, bVar);
        this.jma.setParallel(TiebaIMConfig.getParallel());
        this.jma.setPriority(3);
        this.jma.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.jma = new a(i, bVar);
        this.jma.setParallel(TiebaIMConfig.getParallel());
        this.jma.setPriority(3);
        this.jma.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b jmd;
        private b jme = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void dF(List<c> list) {
                a.this.dE(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.jmd = bVar;
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
                        e.this.b(list, this.jme);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.jme);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.jme);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.jmd != null) {
                        a.this.jmd.onProgressUpdate(i, str, i2);
                        a.this.jmd.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dE(final List<c> list) {
            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.jmd != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.jmd.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.jmd.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.jmd != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.jmd.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.jmd != null) {
                this.jmd.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.jmd != null) {
                if (isCancelled()) {
                    this.jmd.onCanceled();
                } else {
                    this.jmd.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.jmd != null) {
                this.jmd.onCanceled();
            }
        }
    }

    public void ba(String str, int i) {
        j.cEh().bc(str, i);
    }

    public void bb(String str, int i) {
        com.baidu.tieba.im.memorycache.b.cGM().bb(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo bh = com.baidu.tieba.im.memorycache.b.cGM().bh(str, i);
        if (bh != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().Ba(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().pA(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().pB(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().pB(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().AZ(str);
            }
            bh.setIs_hidden(1);
            bh.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.cGM().bi(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.cGM().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.cGM().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d fl(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.jmb);
        return dVar;
    }
}
