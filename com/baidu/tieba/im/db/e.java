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
    private static e kcc;
    private a kcd;
    private final DialogInterface.OnCancelListener kce = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cQX();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void e(int i, String str, int i2);

        void eh(List<c> list);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e cQW() {
        if (kcc == null) {
            synchronized (e.class) {
                if (kcc == null) {
                    kcc = new e();
                }
            }
        }
        return kcc;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                MF(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                MD(str);
            } else if (4 == i) {
                ME(str);
            } else if (-3 == i) {
                bd(str, i);
            } else if (-4 == i) {
                bd(str, i);
            } else {
                bd(str, i);
            }
        }
    }

    public void MD(String str) {
        try {
            try {
                h.cRb().cRc();
                be(str, 2);
                m.cRo().Mv(str);
                h.cRb().cRd();
            } catch (Exception e) {
                e.printStackTrace();
                h.cRb().cRd();
            }
        } catch (Throwable th) {
            h.cRb().cRd();
            throw th;
        }
    }

    public void ME(String str) {
        try {
            try {
                h.cRb().cRc();
                be(str, 4);
                l.cRl().Mv(str);
                h.cRb().cRd();
            } catch (Exception e) {
                e.printStackTrace();
                h.cRb().cRd();
            }
        } catch (Throwable th) {
            h.cRb().cRd();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.cRb().cRc();
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
                if (cQY()) {
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
            h.cRb().cRd();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.cRb().cRc();
            if (!y.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (cQY()) {
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
                        l.cRl().Mv(friendId);
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
            h.cRb().cRd();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.cRb().cRc();
            List<String> cRs = n.cRs();
            if (y.isEmpty(cRs)) {
                return;
            }
            int size = cRs.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cQY()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(y.subList(cRs, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (cQY()) {
                return;
            }
            be(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cRb().cRd();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.MJ(ef(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.cRo().Mw(str);
                if (cQY()) {
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
                bVar.eh(arrayList);
            }
        }
    }

    private String ef(List<String> list) {
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
            h.cRb().cRc();
            l.cRl();
            List<String> cRm = l.cRm();
            if (y.isEmpty(cRm)) {
                return;
            }
            int size = cRm.size();
            int i = 0;
            for (String str : cRm) {
                if (cQY()) {
                    break;
                }
                be(str, 4);
                l.cRl().Mv(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (cQY()) {
                return;
            }
            be(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cRb().cRd();
        }
    }

    public void bd(String str, int i) {
        try {
            try {
                h.cRb().cRc();
                ImMessageCenterPojo bl = com.baidu.tieba.im.memorycache.b.cTK().bl(str, i);
                bl.setIs_hidden(1);
                bl.setUnread_count(0);
                j.cRf().a(bl, 2);
                h.cRb().cRd();
            } catch (Exception e) {
                e.printStackTrace();
                h.cRb().cRd();
            }
        } catch (Throwable th) {
            h.cRb().cRd();
            throw th;
        }
    }

    public void MF(String str) {
        try {
            h.cRb().cRc();
            ImMessageCenterPojo bl = com.baidu.tieba.im.memorycache.b.cTK().bl(str, 1);
            bl.setIs_hidden(1);
            bl.setUnread_count(0);
            j.cRf().a(bl, 2);
            com.baidu.tieba.im.db.c.cQU().Mw(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.cRb().cRd();
        }
    }

    public boolean cQX() {
        if (this.kcd != null && this.kcd.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.kcd.cancel(true);
        }
        this.kcd = null;
        return true;
    }

    public boolean cQY() {
        return this.kcd == null || (this.kcd != null && this.kcd.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.kcd = new a(i, bVar);
        this.kcd.setParallel(TiebaIMConfig.getParallel());
        this.kcd.setPriority(3);
        this.kcd.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.kcd = new a(i, bVar);
        this.kcd.setParallel(TiebaIMConfig.getParallel());
        this.kcd.setPriority(3);
        this.kcd.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b kcg;
        private b kch = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void eh(List<c> list) {
                a.this.eg(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.kcg = bVar;
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
                        e.this.b(list, this.kch);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.kch);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.kch);
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
                    if (a.this.kcg != null) {
                        a.this.kcg.onProgressUpdate(i, str, i2);
                        a.this.kcg.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eg(final List<c> list) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.kcg != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.kcg.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.kcg.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.kcg != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.kcg.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.kcg != null) {
                this.kcg.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.kcg != null) {
                if (isCancelled()) {
                    this.kcg.onCanceled();
                } else {
                    this.kcg.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.kcg != null) {
                this.kcg.onCanceled();
            }
        }
    }

    public void be(String str, int i) {
        j.cRf().bg(str, i);
    }

    public void bf(String str, int i) {
        com.baidu.tieba.im.memorycache.b.cTK().bf(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo bl = com.baidu.tieba.im.memorycache.b.cTK().bl(str, i);
        if (bl != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bvS().CQ(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bvS().qG(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bvS().qH(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bvS().qH(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.bvS().CP(str);
            }
            bl.setIs_hidden(1);
            bl.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.cTK().bm(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.cTK().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.cTK().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d fz(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.kce);
        return dVar;
    }
}
