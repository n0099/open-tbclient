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
    private static e hsm;
    private a hsn;
    private final DialogInterface.OnCancelListener hso = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bRC();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cY(List<c> list);

        void j(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e bRB() {
        if (hsm == null) {
            synchronized (e.class) {
                if (hsm == null) {
                    hsm = new e();
                }
            }
        }
        return hsm;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                Cv(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                Ct(str);
            } else if (4 == i) {
                Cu(str);
            } else if (-3 == i) {
                aO(str, i);
            } else if (-4 == i) {
                aO(str, i);
            } else {
                aO(str, i);
            }
        }
    }

    public void Ct(String str) {
        try {
            try {
                h.bRG().bRH();
                aP(str, 2);
                m.bRS().Cl(str);
                h.bRG().bRI();
            } catch (Exception e) {
                e.printStackTrace();
                h.bRG().bRI();
            }
        } catch (Throwable th) {
            h.bRG().bRI();
            throw th;
        }
    }

    public void Cu(String str) {
        try {
            try {
                h.bRG().bRH();
                aP(str, 4);
                l.bRQ().Cl(str);
                h.bRG().bRI();
            } catch (Exception e) {
                e.printStackTrace();
                h.bRG().bRI();
            }
        } catch (Throwable th) {
            h.bRG().bRI();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bRG().bRH();
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
                if (bRD()) {
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
            h.bRG().bRI();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bRG().bRH();
            if (!v.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bRD()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aP(friendId, 4);
                        l.bRQ().Cl(friendId);
                        i = i2 + 1;
                        if (bVar != null) {
                            bVar.j((i * 100) / size, friendId, 4);
                        }
                    }
                    i3--;
                    i2 = i;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bRG().bRI();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bRG().bRH();
            List<String> bRW = n.bRW();
            if (v.isEmpty(bRW)) {
                return;
            }
            int size = bRW.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bRD()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.subList(bRW, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bRD()) {
                return;
            }
            aP(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bRG().bRI();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.Cz(cW(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bRS().Cm(str);
                if (bRD()) {
                    c cVar = new c();
                    cVar.id = str;
                    cVar.customGroupType = 2;
                    cVar.progress = i;
                    arrayList.add(cVar);
                } else {
                    bVar.j(i, str, 2);
                }
            }
            if (!arrayList.isEmpty() && bVar != null) {
                bVar.cY(arrayList);
            }
        }
    }

    private String cW(List<String> list) {
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
            h.bRG().bRH();
            l.bRQ();
            List<String> bRR = l.bRR();
            if (v.isEmpty(bRR)) {
                return;
            }
            int size = bRR.size();
            int i = 0;
            for (String str : bRR) {
                if (bRD()) {
                    break;
                }
                aP(str, 4);
                l.bRQ().Cl(str);
                i++;
                if (bVar != null) {
                    bVar.j((i * 100) / size, str, 4);
                }
            }
            if (bRD()) {
                return;
            }
            aP(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bRG().bRI();
        }
    }

    public void aO(String str, int i) {
        try {
            try {
                h.bRG().bRH();
                ImMessageCenterPojo aW = com.baidu.tieba.im.memorycache.b.bTW().aW(str, i);
                aW.setIs_hidden(1);
                aW.setUnread_count(0);
                j.bRK().a(aW, 2);
                h.bRG().bRI();
            } catch (Exception e) {
                e.printStackTrace();
                h.bRG().bRI();
            }
        } catch (Throwable th) {
            h.bRG().bRI();
            throw th;
        }
    }

    public void Cv(String str) {
        try {
            h.bRG().bRH();
            ImMessageCenterPojo aW = com.baidu.tieba.im.memorycache.b.bTW().aW(str, 1);
            aW.setIs_hidden(1);
            aW.setUnread_count(0);
            j.bRK().a(aW, 2);
            com.baidu.tieba.im.db.c.bRz().Cm(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bRG().bRI();
        }
    }

    public boolean bRC() {
        if (this.hsn != null && this.hsn.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.hsn.cancel(true);
        }
        this.hsn = null;
        return true;
    }

    public boolean bRD() {
        return this.hsn == null || (this.hsn != null && this.hsn.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.hsn = new a(i, bVar);
        this.hsn.setParallel(TiebaIMConfig.getParallel());
        this.hsn.setPriority(3);
        this.hsn.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.hsn = new a(i, bVar);
        this.hsn.setParallel(TiebaIMConfig.getParallel());
        this.hsn.setPriority(3);
        this.hsn.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b hsq;
        private b hsr = new b() { // from class: com.baidu.tieba.im.db.e.a.1
            @Override // com.baidu.tieba.im.db.e.b
            public void j(int i, String str, int i2) {
                if (a.this.isCancelled()) {
                    a.this.i(i, str, i2);
                    return;
                }
                c cVar = new c();
                cVar.id = str;
                cVar.customGroupType = i2;
                cVar.progress = i;
                a.this.publishProgress(cVar);
            }

            @Override // com.baidu.tieba.im.db.e.b
            public void cY(List<c> list) {
                a.this.cX(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.hsq = bVar;
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
                        e.this.b(list, this.hsr);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.hsr);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.hsr);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(final int i, final String str, final int i2) {
            com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hsq != null) {
                        a.this.hsq.onProgressUpdate(i, str, i2);
                        a.this.hsq.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cX(final List<c> list) {
            com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.hsq != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.hsq.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.hsq.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.hsq != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.hsq.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.hsq != null) {
                this.hsq.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.hsq != null) {
                if (isCancelled()) {
                    this.hsq.onCanceled();
                } else {
                    this.hsq.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.hsq != null) {
                this.hsq.onCanceled();
            }
        }
    }

    public void aP(String str, int i) {
        j.bRK().aR(str, i);
    }

    public void aQ(String str, int i) {
        com.baidu.tieba.im.memorycache.b.bTW().aQ(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aW = com.baidu.tieba.im.memorycache.b.bTW().aW(str, i);
        if (aW != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aHP().tS(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aHP().lu(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aHP().lv(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aHP().lv(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.aHP().tR(str);
            }
            aW.setIs_hidden(1);
            aW.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.bTW().aX(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.bTW().f(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.bTW().f(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d eX(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.hso);
        return dVar;
    }
}
