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
    private static e gFa;
    private a gFb;
    private final DialogInterface.OnCancelListener gFc = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bAo();
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

    public static e bAn() {
        if (gFa == null) {
            synchronized (e.class) {
                if (gFa == null) {
                    gFa = new e();
                }
            }
        }
        return gFa;
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
                h.bAs().bAt();
                aG(str, 2);
                m.bAF().xC(str);
                h.bAs().bAu();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAs().bAu();
            }
        } catch (Throwable th) {
            h.bAs().bAu();
            throw th;
        }
    }

    public void xL(String str) {
        try {
            try {
                h.bAs().bAt();
                aG(str, 4);
                l.bAD().xC(str);
                h.bAs().bAu();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAs().bAu();
            }
        } catch (Throwable th) {
            h.bAs().bAu();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bAs().bAt();
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
                if (bAp()) {
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
            h.bAs().bAu();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bAs().bAt();
            if (!v.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bAp()) {
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
                        l.bAD().xC(friendId);
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
            h.bAs().bAu();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bAs().bAt();
            List<String> bAJ = n.bAJ();
            if (v.isEmpty(bAJ)) {
                return;
            }
            int size = bAJ.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bAp()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.subList(bAJ, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bAp()) {
                return;
            }
            aG(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAs().bAu();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.xQ(dh(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bAF().xD(str);
                if (bAp()) {
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
            h.bAs().bAt();
            l.bAD();
            List<String> bAE = l.bAE();
            if (v.isEmpty(bAE)) {
                return;
            }
            int size = bAE.size();
            int i = 0;
            for (String str : bAE) {
                if (bAp()) {
                    break;
                }
                aG(str, 4);
                l.bAD().xC(str);
                i++;
                if (bVar != null) {
                    bVar.f((i * 100) / size, str, 4);
                }
            }
            if (bAp()) {
                return;
            }
            aG(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bAs().bAu();
        }
    }

    public void aF(String str, int i) {
        try {
            try {
                h.bAs().bAt();
                ImMessageCenterPojo aN = com.baidu.tieba.im.memorycache.b.bCM().aN(str, i);
                aN.setIs_hidden(1);
                aN.setUnread_count(0);
                j.bAx().a(aN, 2);
                h.bAs().bAu();
            } catch (Exception e) {
                e.printStackTrace();
                h.bAs().bAu();
            }
        } catch (Throwable th) {
            h.bAs().bAu();
            throw th;
        }
    }

    public void xM(String str) {
        try {
            h.bAs().bAt();
            ImMessageCenterPojo aN = com.baidu.tieba.im.memorycache.b.bCM().aN(str, 1);
            aN.setIs_hidden(1);
            aN.setUnread_count(0);
            j.bAx().a(aN, 2);
            com.baidu.tieba.im.db.c.bAl().xD(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bAs().bAu();
        }
    }

    public boolean bAo() {
        if (this.gFb != null && this.gFb.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.gFb.cancel(true);
        }
        this.gFb = null;
        return true;
    }

    public boolean bAp() {
        return this.gFb == null || (this.gFb != null && this.gFb.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gFb = new a(i, bVar);
        this.gFb.setParallel(TiebaIMConfig.getParallel());
        this.gFb.setPriority(3);
        this.gFb.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.gFb = new a(i, bVar);
        this.gFb.setParallel(TiebaIMConfig.getParallel());
        this.gFb.setPriority(3);
        this.gFb.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b gFe;
        private b gFf = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            this.gFe = bVar;
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
                        e.this.b(list, this.gFf);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.gFf);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.gFf);
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
                    if (a.this.gFe != null) {
                        a.this.gFe.onProgressUpdate(i, str, i2);
                        a.this.gFe.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void di(final List<c> list) {
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.gFe != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.gFe.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.gFe.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.gFe != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.gFe.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.gFe != null) {
                this.gFe.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.gFe != null) {
                if (isCancelled()) {
                    this.gFe.onCanceled();
                } else {
                    this.gFe.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.gFe != null) {
                this.gFe.onCanceled();
            }
        }
    }

    public void aG(String str, int i) {
        j.bAx().aI(str, i);
    }

    public void aH(String str, int i) {
        com.baidu.tieba.im.memorycache.b.bCM().aH(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aN = com.baidu.tieba.im.memorycache.b.bCM().aN(str, i);
        if (aN != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aqt().oP(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aqt().ji(com.baidu.adp.lib.g.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aqt().jj(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aqt().jj(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.aqt().oO(str);
            }
            aN.setIs_hidden(1);
            aN.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.bCM().aO(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.bCM().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.bCM().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d dE(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.gFc);
        return dVar;
    }
}
