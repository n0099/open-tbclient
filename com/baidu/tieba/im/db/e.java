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
    private static e kqq;
    private a kqr;
    private final DialogInterface.OnCancelListener kqs = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cVR();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void e(int i, String str, int i2);

        void es(List<c> list);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e cVQ() {
        if (kqq == null) {
            synchronized (e.class) {
                if (kqq == null) {
                    kqq = new e();
                }
            }
        }
        return kqq;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                No(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                Nm(str);
            } else if (4 == i) {
                Nn(str);
            } else if (-3 == i) {
                bd(str, i);
            } else if (-4 == i) {
                bd(str, i);
            } else {
                bd(str, i);
            }
        }
    }

    public void Nm(String str) {
        try {
            try {
                h.cVV().cVW();
                be(str, 2);
                m.cWi().Ne(str);
                h.cVV().cVX();
            } catch (Exception e) {
                e.printStackTrace();
                h.cVV().cVX();
            }
        } catch (Throwable th) {
            h.cVV().cVX();
            throw th;
        }
    }

    public void Nn(String str) {
        try {
            try {
                h.cVV().cVW();
                be(str, 4);
                l.cWf().Ne(str);
                h.cVV().cVX();
            } catch (Exception e) {
                e.printStackTrace();
                h.cVV().cVX();
            }
        } catch (Throwable th) {
            h.cVV().cVX();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.cVV().cVW();
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
                if (cVS()) {
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
            h.cVV().cVX();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.cVV().cVW();
            if (!y.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (cVS()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) y.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        be(friendId, 4);
                        l.cWf().Ne(friendId);
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
            h.cVV().cVX();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.cVV().cVW();
            List<String> cWm = n.cWm();
            if (y.isEmpty(cWm)) {
                return;
            }
            int size = cWm.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cVS()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(y.subList(cWm, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (cVS()) {
                return;
            }
            be(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cVV().cVX();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.Ns(eq(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.cWi().Nf(str);
                if (cVS()) {
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
                bVar.es(arrayList);
            }
        }
    }

    private String eq(List<String> list) {
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
            h.cVV().cVW();
            l.cWf();
            List<String> cWg = l.cWg();
            if (y.isEmpty(cWg)) {
                return;
            }
            int size = cWg.size();
            int i = 0;
            for (String str : cWg) {
                if (cVS()) {
                    break;
                }
                be(str, 4);
                l.cWf().Ne(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (cVS()) {
                return;
            }
            be(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cVV().cVX();
        }
    }

    public void bd(String str, int i) {
        try {
            try {
                h.cVV().cVW();
                ImMessageCenterPojo bl = com.baidu.tieba.im.memorycache.b.cYC().bl(str, i);
                bl.setIs_hidden(1);
                bl.setUnread_count(0);
                j.cVZ().a(bl, 2);
                h.cVV().cVX();
            } catch (Exception e) {
                e.printStackTrace();
                h.cVV().cVX();
            }
        } catch (Throwable th) {
            h.cVV().cVX();
            throw th;
        }
    }

    public void No(String str) {
        try {
            h.cVV().cVW();
            ImMessageCenterPojo bl = com.baidu.tieba.im.memorycache.b.cYC().bl(str, 1);
            bl.setIs_hidden(1);
            bl.setUnread_count(0);
            j.cVZ().a(bl, 2);
            com.baidu.tieba.im.db.c.cVO().Nf(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.cVV().cVX();
        }
    }

    public boolean cVR() {
        if (this.kqr != null && this.kqr.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.kqr.cancel(true);
        }
        this.kqr = null;
        return true;
    }

    public boolean cVS() {
        return this.kqr == null || (this.kqr != null && this.kqr.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.kqr = new a(i, bVar);
        this.kqr.setParallel(TiebaIMConfig.getParallel());
        this.kqr.setPriority(3);
        this.kqr.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.kqr = new a(i, bVar);
        this.kqr.setParallel(TiebaIMConfig.getParallel());
        this.kqr.setPriority(3);
        this.kqr.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b kqu;
        private b kqv = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void es(List<c> list) {
                a.this.er(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.kqu = bVar;
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
                        e.this.b(list, this.kqv);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.kqv);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.kqv);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.kqu != null) {
                        a.this.kqu.onProgressUpdate(i, str, i2);
                        a.this.kqu.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void er(final List<c> list) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.kqu != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.kqu.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.kqu.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.kqu != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.kqu.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.kqu != null) {
                this.kqu.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.kqu != null) {
                if (isCancelled()) {
                    this.kqu.onCanceled();
                } else {
                    this.kqu.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.kqu != null) {
                this.kqu.onCanceled();
            }
        }
    }

    public void be(String str, int i) {
        j.cVZ().bg(str, i);
    }

    public void bf(String str, int i) {
        com.baidu.tieba.im.memorycache.b.cYC().bf(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo bl = com.baidu.tieba.im.memorycache.b.cYC().bl(str, i);
        if (bl != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.byI().CX(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.byI().rF(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.byI().rG(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.byI().rG(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.byI().CW(str);
            }
            bl.setIs_hidden(1);
            bl.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.cYC().bm(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.cYC().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.cYC().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d gf(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.kqs);
        return dVar;
    }
}
