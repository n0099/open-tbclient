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
/* loaded from: classes.dex */
public class e {
    private static e juJ;
    private a juK;
    private final DialogInterface.OnCancelListener juL = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cHG();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void dN(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e cHF() {
        if (juJ == null) {
            synchronized (e.class) {
                if (juJ == null) {
                    juJ = new e();
                }
            }
        }
        return juJ;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                Lb(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                KZ(str);
            } else if (4 == i) {
                La(str);
            } else if (-3 == i) {
                aZ(str, i);
            } else if (-4 == i) {
                aZ(str, i);
            } else {
                aZ(str, i);
            }
        }
    }

    public void KZ(String str) {
        try {
            try {
                h.cHK().cHL();
                ba(str, 2);
                m.cHX().KR(str);
                h.cHK().cHM();
            } catch (Exception e) {
                e.printStackTrace();
                h.cHK().cHM();
            }
        } catch (Throwable th) {
            h.cHK().cHM();
            throw th;
        }
    }

    public void La(String str) {
        try {
            try {
                h.cHK().cHL();
                ba(str, 4);
                l.cHU().KR(str);
                h.cHK().cHM();
            } catch (Exception e) {
                e.printStackTrace();
                h.cHK().cHM();
            }
        } catch (Throwable th) {
            h.cHK().cHM();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.cHK().cHL();
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
                if (cHH()) {
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
            h.cHK().cHM();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.cHK().cHL();
            if (!y.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (cHH()) {
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
                        l.cHU().KR(friendId);
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
            h.cHK().cHM();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.cHK().cHL();
            List<String> cIb = n.cIb();
            if (y.isEmpty(cIb)) {
                return;
            }
            int size = cIb.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cHH()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(y.subList(cIb, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (cHH()) {
                return;
            }
            ba(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cHK().cHM();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.Lf(dL(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.cHX().KS(str);
                if (cHH()) {
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
                bVar.dN(arrayList);
            }
        }
    }

    private String dL(List<String> list) {
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
            h.cHK().cHL();
            l.cHU();
            List<String> cHV = l.cHV();
            if (y.isEmpty(cHV)) {
                return;
            }
            int size = cHV.size();
            int i = 0;
            for (String str : cHV) {
                if (cHH()) {
                    break;
                }
                ba(str, 4);
                l.cHU().KR(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (cHH()) {
                return;
            }
            ba(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cHK().cHM();
        }
    }

    public void aZ(String str, int i) {
        try {
            try {
                h.cHK().cHL();
                ImMessageCenterPojo bh = com.baidu.tieba.im.memorycache.b.cKt().bh(str, i);
                bh.setIs_hidden(1);
                bh.setUnread_count(0);
                j.cHO().a(bh, 2);
                h.cHK().cHM();
            } catch (Exception e) {
                e.printStackTrace();
                h.cHK().cHM();
            }
        } catch (Throwable th) {
            h.cHK().cHM();
            throw th;
        }
    }

    public void Lb(String str) {
        try {
            h.cHK().cHL();
            ImMessageCenterPojo bh = com.baidu.tieba.im.memorycache.b.cKt().bh(str, 1);
            bh.setIs_hidden(1);
            bh.setUnread_count(0);
            j.cHO().a(bh, 2);
            com.baidu.tieba.im.db.c.cHD().KS(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.cHK().cHM();
        }
    }

    public boolean cHG() {
        if (this.juK != null && this.juK.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.juK.cancel(true);
        }
        this.juK = null;
        return true;
    }

    public boolean cHH() {
        return this.juK == null || (this.juK != null && this.juK.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.juK = new a(i, bVar);
        this.juK.setParallel(TiebaIMConfig.getParallel());
        this.juK.setPriority(3);
        this.juK.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.juK = new a(i, bVar);
        this.juK.setParallel(TiebaIMConfig.getParallel());
        this.juK.setPriority(3);
        this.juK.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b juN;
        private b juO = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void dN(List<c> list) {
                a.this.dM(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.juN = bVar;
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
                        e.this.b(list, this.juO);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.juO);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.juO);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.juN != null) {
                        a.this.juN.onProgressUpdate(i, str, i2);
                        a.this.juN.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dM(final List<c> list) {
            com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.juN != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.juN.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.juN.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.juN != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.juN.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.juN != null) {
                this.juN.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.juN != null) {
                if (isCancelled()) {
                    this.juN.onCanceled();
                } else {
                    this.juN.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.juN != null) {
                this.juN.onCanceled();
            }
        }
    }

    public void ba(String str, int i) {
        j.cHO().bc(str, i);
    }

    public void bb(String str, int i) {
        com.baidu.tieba.im.memorycache.b.cKt().bb(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo bh = com.baidu.tieba.im.memorycache.b.cKt().bh(str, i);
        if (bh != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.boP().Bx(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.boP().pN(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.boP().pO(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.boP().pO(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.boP().Bw(str);
            }
            bh.setIs_hidden(1);
            bh.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.cKt().bi(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.cKt().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.cKt().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d fr(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.juL);
        return dVar;
    }
}
