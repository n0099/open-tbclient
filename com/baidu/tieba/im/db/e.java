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
    private static e kGY;
    private a kGZ;
    private final DialogInterface.OnCancelListener kHa = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cVJ();
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

    public static e cVI() {
        if (kGY == null) {
            synchronized (e.class) {
                if (kGY == null) {
                    kGY = new e();
                }
            }
        }
        return kGY;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                MV(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                MT(str);
            } else if (4 == i) {
                MU(str);
            } else if (-3 == i) {
                bl(str, i);
            } else if (-4 == i) {
                bl(str, i);
            } else {
                bl(str, i);
            }
        }
    }

    public void MT(String str) {
        try {
            try {
                h.cVN().cVO();
                bm(str, 2);
                m.cWa().ML(str);
                h.cVN().cVP();
            } catch (Exception e) {
                e.printStackTrace();
                h.cVN().cVP();
            }
        } catch (Throwable th) {
            h.cVN().cVP();
            throw th;
        }
    }

    public void MU(String str) {
        try {
            try {
                h.cVN().cVO();
                bm(str, 4);
                l.cVX().ML(str);
                h.cVN().cVP();
            } catch (Exception e) {
                e.printStackTrace();
                h.cVN().cVP();
            }
        } catch (Throwable th) {
            h.cVN().cVP();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.cVN().cVO();
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
                if (cVK()) {
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
            h.cVN().cVP();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.cVN().cVO();
            if (!y.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (cVK()) {
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
                        l.cVX().ML(friendId);
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
            h.cVN().cVP();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.cVN().cVO();
            List<String> cWe = n.cWe();
            if (y.isEmpty(cWe)) {
                return;
            }
            int size = cWe.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cVK()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(y.subList(cWe, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (cVK()) {
                return;
            }
            bm(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cVN().cVP();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.MZ(ev(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.cWa().MM(str);
                if (cVK()) {
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
            h.cVN().cVO();
            l.cVX();
            List<String> cVY = l.cVY();
            if (y.isEmpty(cVY)) {
                return;
            }
            int size = cVY.size();
            int i = 0;
            for (String str : cVY) {
                if (cVK()) {
                    break;
                }
                bm(str, 4);
                l.cVX().ML(str);
                i++;
                if (bVar != null) {
                    bVar.f((i * 100) / size, str, 4);
                }
            }
            if (cVK()) {
                return;
            }
            bm(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cVN().cVP();
        }
    }

    public void bl(String str, int i) {
        try {
            try {
                h.cVN().cVO();
                ImMessageCenterPojo bs = com.baidu.tieba.im.memorycache.b.cWS().bs(str, i);
                bs.setIs_hidden(1);
                bs.setUnread_count(0);
                j.cVR().a(bs, 2);
                h.cVN().cVP();
            } catch (Exception e) {
                e.printStackTrace();
                h.cVN().cVP();
            }
        } catch (Throwable th) {
            h.cVN().cVP();
            throw th;
        }
    }

    public void MV(String str) {
        try {
            h.cVN().cVO();
            ImMessageCenterPojo bs = com.baidu.tieba.im.memorycache.b.cWS().bs(str, 1);
            bs.setIs_hidden(1);
            bs.setUnread_count(0);
            j.cVR().a(bs, 2);
            com.baidu.tieba.im.db.c.cVG().MM(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.cVN().cVP();
        }
    }

    public boolean cVJ() {
        if (this.kGZ != null && this.kGZ.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.kGZ.cancel(true);
        }
        this.kGZ = null;
        return true;
    }

    public boolean cVK() {
        return this.kGZ == null || (this.kGZ != null && this.kGZ.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.kGZ = new a(i, bVar);
        this.kGZ.setParallel(TiebaIMConfig.getParallel());
        this.kGZ.setPriority(3);
        this.kGZ.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.kGZ = new a(i, bVar);
        this.kGZ.setParallel(TiebaIMConfig.getParallel());
        this.kGZ.setPriority(3);
        this.kGZ.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b kHc;
        private b kHd = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            this.kHc = bVar;
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
                        e.this.b(list, this.kHd);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.kHd);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.kHd);
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
                    if (a.this.kHc != null) {
                        a.this.kHc.onProgressUpdate(i, str, i2);
                        a.this.kHc.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ew(final List<c> list) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.kHc != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.kHc.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.kHc.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.kHc != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.kHc.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.kHc != null) {
                this.kHc.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.kHc != null) {
                if (isCancelled()) {
                    this.kHc.onCanceled();
                } else {
                    this.kHc.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.kHc != null) {
                this.kHc.onCanceled();
            }
        }
    }

    public void bm(String str, int i) {
        j.cVR().bo(str, i);
    }

    public void bn(String str, int i) {
        com.baidu.tieba.im.memorycache.b.cWS().bn(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo bs = com.baidu.tieba.im.memorycache.b.cWS().bs(str, i);
        if (bs != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxE().Ch(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxE().qr(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxE().qs(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxE().qs(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxE().Cg(str);
            }
            bs.setIs_hidden(1);
            bs.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.cWS().bt(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.cWS().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.cWS().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d gv(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.kHa);
        return dVar;
    }
}
