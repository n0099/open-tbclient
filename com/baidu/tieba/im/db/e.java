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
    private static e eNw;
    private a eNx;
    private final DialogInterface.OnCancelListener eNy = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.aQs();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cC(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e aQr() {
        if (eNw == null) {
            synchronized (e.class) {
                if (eNw == null) {
                    eNw = new e();
                }
            }
        }
        return eNw;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                pX(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                pV(str);
            } else if (4 == i) {
                pW(str);
            } else if (-3 == i) {
                ap(str, i);
            } else if (-4 == i) {
                ap(str, i);
            } else {
                ap(str, i);
            }
        }
    }

    public void pV(String str) {
        try {
            try {
                h.aQw().aQx();
                aq(str, 2);
                m.aQH().pN(str);
                h.aQw().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aQw().endTransaction();
            }
        } catch (Throwable th) {
            h.aQw().endTransaction();
            throw th;
        }
    }

    public void pW(String str) {
        try {
            try {
                h.aQw().aQx();
                aq(str, 4);
                l.aQF().pN(str);
                h.aQw().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aQw().endTransaction();
            }
        } catch (Throwable th) {
            h.aQw().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.aQw().aQx();
            if (v.I(list)) {
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
                if (aQt()) {
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
            h.aQw().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.aQw().aQx();
            if (!v.I(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (aQt()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.d(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aq(friendId, 4);
                        l.aQF().pN(friendId);
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
            h.aQw().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.aQw().aQx();
            List<String> aQL = n.aQL();
            if (v.I(aQL)) {
                return;
            }
            int size = aQL.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (aQt()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.b(aQL, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (aQt()) {
                return;
            }
            aq("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aQw().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.qa(cA(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.aQH().pO(str);
                if (aQt()) {
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
                bVar.cC(arrayList);
            }
        }
    }

    private String cA(List<String> list) {
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
            h.aQw().aQx();
            l.aQF();
            List<String> aQG = l.aQG();
            if (v.I(aQG)) {
                return;
            }
            int size = aQG.size();
            int i = 0;
            for (String str : aQG) {
                if (aQt()) {
                    break;
                }
                aq(str, 4);
                l.aQF().pN(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (aQt()) {
                return;
            }
            aq("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aQw().endTransaction();
        }
    }

    public void ap(String str, int i) {
        try {
            try {
                h.aQw().aQx();
                ImMessageCenterPojo ax = com.baidu.tieba.im.memorycache.b.aSN().ax(str, i);
                ax.setIs_hidden(1);
                ax.setUnread_count(0);
                j.aQz().a(ax, 2);
                h.aQw().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aQw().endTransaction();
            }
        } catch (Throwable th) {
            h.aQw().endTransaction();
            throw th;
        }
    }

    public void pX(String str) {
        try {
            h.aQw().aQx();
            ImMessageCenterPojo ax = com.baidu.tieba.im.memorycache.b.aSN().ax(str, 1);
            ax.setIs_hidden(1);
            ax.setUnread_count(0);
            j.aQz().a(ax, 2);
            com.baidu.tieba.im.db.c.aQp().pO(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.aQw().endTransaction();
        }
    }

    public boolean aQs() {
        if (this.eNx != null && this.eNx.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.eNx.cancel(true);
        }
        this.eNx = null;
        return true;
    }

    public boolean aQt() {
        return this.eNx == null || (this.eNx != null && this.eNx.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eNx = new a(i, bVar);
        this.eNx.setParallel(TiebaIMConfig.getParallel());
        this.eNx.setPriority(3);
        this.eNx.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eNx = new a(i, bVar);
        this.eNx.setParallel(TiebaIMConfig.getParallel());
        this.eNx.setPriority(3);
        this.eNx.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b eNA;
        private b eNB = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void cC(List<c> list) {
                a.this.cB(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.eNA = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    if (this.mCustomGroupType == 4) {
                        e.this.b(list, this.eNB);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.eNB);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.eNB);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eNA != null) {
                        a.this.eNA.onProgressUpdate(i, str, i2);
                        a.this.eNA.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cB(final List<c> list) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.eNA != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.eNA.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.eNA.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.eNA != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.eNA.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.eNA != null) {
                this.eNA.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.eNA != null) {
                if (isCancelled()) {
                    this.eNA.onCanceled();
                } else {
                    this.eNA.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eNA != null) {
                this.eNA.onCanceled();
            }
        }
    }

    public void aq(String str, int i) {
        j.aQz().as(str, i);
    }

    public void ar(String str, int i) {
        com.baidu.tieba.im.memorycache.b.aSN().ar(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo ax = com.baidu.tieba.im.memorycache.b.aSN().ax(str, i);
        if (ax != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.a.HP().gK(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.HP().eT(com.baidu.adp.lib.g.b.l(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.a.HP().eU(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.HP().eU(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.a.HP().gJ(str);
            }
            ax.setIs_hidden(1);
            ax.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.aSN().ay(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.aSN().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.aSN().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d cD(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(e.j.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.eNy);
        return dVar;
    }
}
