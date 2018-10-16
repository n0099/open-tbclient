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
    private static e eFn;
    private a eFo;
    private final DialogInterface.OnCancelListener eFp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.aPd();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cA(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e aPc() {
        if (eFn == null) {
            synchronized (e.class) {
                if (eFn == null) {
                    eFn = new e();
                }
            }
        }
        return eFn;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                pu(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                ps(str);
            } else if (4 == i) {
                pt(str);
            } else if (-3 == i) {
                ao(str, i);
            } else if (-4 == i) {
                ao(str, i);
            } else {
                ao(str, i);
            }
        }
    }

    public void ps(String str) {
        try {
            try {
                h.aPh().aPi();
                ap(str, 2);
                m.aPs().pk(str);
                h.aPh().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aPh().endTransaction();
            }
        } catch (Throwable th) {
            h.aPh().endTransaction();
            throw th;
        }
    }

    public void pt(String str) {
        try {
            try {
                h.aPh().aPi();
                ap(str, 4);
                l.aPq().pk(str);
                h.aPh().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aPh().endTransaction();
            }
        } catch (Throwable th) {
            h.aPh().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.aPh().aPi();
            if (v.J(list)) {
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
                if (aPe()) {
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
            h.aPh().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.aPh().aPi();
            if (!v.J(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (aPe()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.d(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        ap(friendId, 4);
                        l.aPq().pk(friendId);
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
            h.aPh().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.aPh().aPi();
            List<String> aPw = n.aPw();
            if (v.J(aPw)) {
                return;
            }
            int size = aPw.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (aPe()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.b(aPw, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (aPe()) {
                return;
            }
            ap("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aPh().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.px(cy(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.aPs().pl(str);
                if (aPe()) {
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
                bVar.cA(arrayList);
            }
        }
    }

    private String cy(List<String> list) {
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
            h.aPh().aPi();
            l.aPq();
            List<String> aPr = l.aPr();
            if (v.J(aPr)) {
                return;
            }
            int size = aPr.size();
            int i = 0;
            for (String str : aPr) {
                if (aPe()) {
                    break;
                }
                ap(str, 4);
                l.aPq().pk(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (aPe()) {
                return;
            }
            ap("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aPh().endTransaction();
        }
    }

    public void ao(String str, int i) {
        try {
            try {
                h.aPh().aPi();
                ImMessageCenterPojo aw = com.baidu.tieba.im.memorycache.b.aRy().aw(str, i);
                aw.setIs_hidden(1);
                aw.setUnread_count(0);
                j.aPk().a(aw, 2);
                h.aPh().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aPh().endTransaction();
            }
        } catch (Throwable th) {
            h.aPh().endTransaction();
            throw th;
        }
    }

    public void pu(String str) {
        try {
            h.aPh().aPi();
            ImMessageCenterPojo aw = com.baidu.tieba.im.memorycache.b.aRy().aw(str, 1);
            aw.setIs_hidden(1);
            aw.setUnread_count(0);
            j.aPk().a(aw, 2);
            com.baidu.tieba.im.db.c.aPa().pl(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.aPh().endTransaction();
        }
    }

    public boolean aPd() {
        if (this.eFo != null && this.eFo.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.eFo.cancel(true);
        }
        this.eFo = null;
        return true;
    }

    public boolean aPe() {
        return this.eFo == null || (this.eFo != null && this.eFo.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eFo = new a(i, bVar);
        this.eFo.setParallel(TiebaIMConfig.getParallel());
        this.eFo.setPriority(3);
        this.eFo.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eFo = new a(i, bVar);
        this.eFo.setParallel(TiebaIMConfig.getParallel());
        this.eFo.setPriority(3);
        this.eFo.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b eFr;
        private b eFs = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void cA(List<c> list) {
                a.this.cz(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.eFr = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    if (this.mCustomGroupType == 4) {
                        e.this.b(list, this.eFs);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.eFs);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.eFs);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eFr != null) {
                        a.this.eFr.onProgressUpdate(i, str, i2);
                        a.this.eFr.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cz(final List<c> list) {
            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.eFr != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.eFr.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.eFr.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.eFr != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.eFr.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.eFr != null) {
                this.eFr.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.eFr != null) {
                if (isCancelled()) {
                    this.eFr.onCanceled();
                } else {
                    this.eFr.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eFr != null) {
                this.eFr.onCanceled();
            }
        }
    }

    public void ap(String str, int i) {
        j.aPk().ar(str, i);
    }

    public void aq(String str, int i) {
        com.baidu.tieba.im.memorycache.b.aRy().aq(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aw = com.baidu.tieba.im.memorycache.b.aRy().aw(str, i);
        if (aw != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().gq(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().er(com.baidu.adp.lib.g.b.l(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().es(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().es(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().gp(str);
            }
            aw.setIs_hidden(1);
            aw.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.aRy().ax(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.aRy().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.aRy().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d cE(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(e.j.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.eFp);
        return dVar;
    }
}
