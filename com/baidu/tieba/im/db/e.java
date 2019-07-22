package com.baidu.tieba.im.db;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
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
    private static e gEs;
    private a gEt;
    private final DialogInterface.OnCancelListener gEu = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bCC();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cX(List<c> list);

        void f(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e bCB() {
        if (gEs == null) {
            synchronized (e.class) {
                if (gEs == null) {
                    gEs = new e();
                }
            }
        }
        return gEs;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                yU(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                yS(str);
            } else if (4 == i) {
                yT(str);
            } else if (-3 == i) {
                aI(str, i);
            } else if (-4 == i) {
                aI(str, i);
            } else {
                aI(str, i);
            }
        }
    }

    public void yS(String str) {
        try {
            try {
                h.bCG().bCH();
                aJ(str, 2);
                m.bCS().yK(str);
                h.bCG().bCI();
            } catch (Exception e) {
                e.printStackTrace();
                h.bCG().bCI();
            }
        } catch (Throwable th) {
            h.bCG().bCI();
            throw th;
        }
    }

    public void yT(String str) {
        try {
            try {
                h.bCG().bCH();
                aJ(str, 4);
                l.bCQ().yK(str);
                h.bCG().bCI();
            } catch (Exception e) {
                e.printStackTrace();
                h.bCG().bCI();
            }
        } catch (Throwable th) {
            h.bCG().bCI();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bCG().bCH();
            if (v.aa(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (int size = list.size() - 1; size >= 0; size--) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.c(list, size);
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
                if (bCD()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size2;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.c(arrayList, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bCG().bCI();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bCG().bCH();
            if (!v.aa(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bCD()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.c(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aJ(friendId, 4);
                        l.bCQ().yK(friendId);
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
            h.bCG().bCI();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bCG().bCH();
            List<String> bCW = n.bCW();
            if (v.aa(bCW)) {
                return;
            }
            int size = bCW.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bCD()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.c(bCW, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bCD()) {
                return;
            }
            aJ("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bCG().bCI();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.yY(cV(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bCS().yL(str);
                if (bCD()) {
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
                bVar.cX(arrayList);
            }
        }
    }

    private String cV(List<String> list) {
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
            h.bCG().bCH();
            l.bCQ();
            List<String> bCR = l.bCR();
            if (v.aa(bCR)) {
                return;
            }
            int size = bCR.size();
            int i = 0;
            for (String str : bCR) {
                if (bCD()) {
                    break;
                }
                aJ(str, 4);
                l.bCQ().yK(str);
                i++;
                if (bVar != null) {
                    bVar.f((i * 100) / size, str, 4);
                }
            }
            if (bCD()) {
                return;
            }
            aJ("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bCG().bCI();
        }
    }

    public void aI(String str, int i) {
        try {
            try {
                h.bCG().bCH();
                ImMessageCenterPojo aQ = com.baidu.tieba.im.memorycache.b.bEZ().aQ(str, i);
                aQ.setIs_hidden(1);
                aQ.setUnread_count(0);
                j.bCK().a(aQ, 2);
                h.bCG().bCI();
            } catch (Exception e) {
                e.printStackTrace();
                h.bCG().bCI();
            }
        } catch (Throwable th) {
            h.bCG().bCI();
            throw th;
        }
    }

    public void yU(String str) {
        try {
            h.bCG().bCH();
            ImMessageCenterPojo aQ = com.baidu.tieba.im.memorycache.b.bEZ().aQ(str, 1);
            aQ.setIs_hidden(1);
            aQ.setUnread_count(0);
            j.bCK().a(aQ, 2);
            com.baidu.tieba.im.db.c.bCz().yL(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bCG().bCI();
        }
    }

    public boolean bCC() {
        if (this.gEt != null && this.gEt.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.gEt.cancel(true);
        }
        this.gEt = null;
        return true;
    }

    public boolean bCD() {
        return this.gEt == null || (this.gEt != null && this.gEt.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gEt = new a(i, bVar);
        this.gEt.setParallel(TiebaIMConfig.getParallel());
        this.gEt.setPriority(3);
        this.gEt.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gEt = new a(i, bVar);
        this.gEt.setParallel(TiebaIMConfig.getParallel());
        this.gEt.setPriority(3);
        this.gEt.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b gEw;
        private b gEx = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void cX(List<c> list) {
                a.this.cW(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.gEw = bVar;
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
                        e.this.b(list, this.gEx);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.gEx);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.gEx);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gEw != null) {
                        a.this.gEw.onProgressUpdate(i, str, i2);
                        a.this.gEw.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cW(final List<c> list) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.gEw != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.gEw.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.gEw.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.gEw != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.gEw.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.gEw != null) {
                this.gEw.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.gEw != null) {
                if (isCancelled()) {
                    this.gEw.onCanceled();
                } else {
                    this.gEw.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.gEw != null) {
                this.gEw.onCanceled();
            }
        }
    }

    public void aJ(String str, int i) {
        j.bCK().aL(str, i);
    }

    public void aK(String str, int i) {
        com.baidu.tieba.im.memorycache.b.bEZ().aK(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aQ = com.baidu.tieba.im.memorycache.b.bEZ().aQ(str, i);
        if (aQ != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anD().pl(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anD().jt(com.baidu.adp.lib.g.b.f(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anD().ju(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anD().ju(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.anD().pk(str);
            }
            aQ.setIs_hidden(1);
            aQ.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.bEZ().aR(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.bEZ().f(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.bEZ().f(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d dP(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.gEu);
        return dVar;
    }
}
