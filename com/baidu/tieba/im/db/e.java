package com.baidu.tieba.im.db;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e gEj;
    private a gEk;
    private final DialogInterface.OnCancelListener gEl = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bAm();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void dj(List<c> list);

        void f(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e bAl() {
        if (gEj == null) {
            synchronized (e.class) {
                if (gEj == null) {
                    gEj = new e();
                }
            }
        }
        return gEj;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                xM(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                xK(str);
            } else if (4 == i) {
                xL(str);
            } else if (-3 == i) {
                aF(str, i);
            } else if (-4 == i) {
                aF(str, i);
            } else {
                aF(str, i);
            }
        }
    }

    public void xK(String str) {
        try {
            try {
                h.bAq().bAr();
                aG(str, 2);
                m.bAD().xC(str);
                h.bAq().bAs();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAq().bAs();
            }
        } catch (Throwable th) {
            h.bAq().bAs();
            throw th;
        }
    }

    public void xL(String str) {
        try {
            try {
                h.bAq().bAr();
                aG(str, 4);
                l.bAB().xC(str);
                h.bAq().bAs();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAq().bAs();
            }
        } catch (Throwable th) {
            h.bAq().bAs();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bAq().bAr();
            if (v.isEmpty(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (int size = list.size() - 1; size >= 0; size--) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.getItem(list, size);
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
                if (bAn()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size2;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.subList(arrayList, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAq().bAs();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bAq().bAr();
            if (!v.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bAn()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aG(friendId, 4);
                        l.bAB().xC(friendId);
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
            h.bAq().bAs();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bAq().bAr();
            List<String> bAH = n.bAH();
            if (v.isEmpty(bAH)) {
                return;
            }
            int size = bAH.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bAn()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.subList(bAH, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bAn()) {
                return;
            }
            aG(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAq().bAs();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.xQ(dh(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bAD().xD(str);
                if (bAn()) {
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
                bVar.dj(arrayList);
            }
        }
    }

    private String dh(List<String> list) {
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
            h.bAq().bAr();
            l.bAB();
            List<String> bAC = l.bAC();
            if (v.isEmpty(bAC)) {
                return;
            }
            int size = bAC.size();
            int i = 0;
            for (String str : bAC) {
                if (bAn()) {
                    break;
                }
                aG(str, 4);
                l.bAB().xC(str);
                i++;
                if (bVar != null) {
                    bVar.f((i * 100) / size, str, 4);
                }
            }
            if (bAn()) {
                return;
            }
            aG(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAq().bAs();
        }
    }

    public void aF(String str, int i) {
        try {
            try {
                h.bAq().bAr();
                ImMessageCenterPojo aN = com.baidu.tieba.im.memorycache.b.bCK().aN(str, i);
                aN.setIs_hidden(1);
                aN.setUnread_count(0);
                j.bAv().a(aN, 2);
                h.bAq().bAs();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAq().bAs();
            }
        } catch (Throwable th) {
            h.bAq().bAs();
            throw th;
        }
    }

    public void xM(String str) {
        try {
            h.bAq().bAr();
            ImMessageCenterPojo aN = com.baidu.tieba.im.memorycache.b.bCK().aN(str, 1);
            aN.setIs_hidden(1);
            aN.setUnread_count(0);
            j.bAv().a(aN, 2);
            com.baidu.tieba.im.db.c.bAj().xD(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bAq().bAs();
        }
    }

    public boolean bAm() {
        if (this.gEk != null && this.gEk.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.gEk.cancel(true);
        }
        this.gEk = null;
        return true;
    }

    public boolean bAn() {
        return this.gEk == null || (this.gEk != null && this.gEk.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gEk = new a(i, bVar);
        this.gEk.setParallel(TiebaIMConfig.getParallel());
        this.gEk.setPriority(3);
        this.gEk.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gEk = new a(i, bVar);
        this.gEk.setParallel(TiebaIMConfig.getParallel());
        this.gEk.setPriority(3);
        this.gEk.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b gEn;
        private b gEo = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void dj(List<c> list) {
                a.this.di(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.gEn = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    if (this.mCustomGroupType == 4) {
                        e.this.b(list, this.gEo);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.gEo);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.gEo);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gEn != null) {
                        a.this.gEn.onProgressUpdate(i, str, i2);
                        a.this.gEn.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void di(final List<c> list) {
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.gEn != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.gEn.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.gEn.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.gEn != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.gEn.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.gEn != null) {
                this.gEn.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.gEn != null) {
                if (isCancelled()) {
                    this.gEn.onCanceled();
                } else {
                    this.gEn.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.gEn != null) {
                this.gEn.onCanceled();
            }
        }
    }

    public void aG(String str, int i) {
        j.bAv().aI(str, i);
    }

    public void aH(String str, int i) {
        com.baidu.tieba.im.memorycache.b.bCK().aH(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aN = com.baidu.tieba.im.memorycache.b.bCK().aN(str, i);
        if (aN != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aqr().oP(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aqr().jh(com.baidu.adp.lib.g.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aqr().ji(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aqr().ji(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.aqr().oO(str);
            }
            aN.setIs_hidden(1);
            aN.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.bCK().aO(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.bCK().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.bCK().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d dE(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.gEl);
        return dVar;
    }
}
