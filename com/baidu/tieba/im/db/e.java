package com.baidu.tieba.im.db;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e iPW;
    private a iPX;
    private final DialogInterface.OnCancelListener iPY = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cpD();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void ds(List<c> list);

        void h(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e cpC() {
        if (iPW == null) {
            synchronized (e.class) {
                if (iPW == null) {
                    iPW = new e();
                }
            }
        }
        return iPW;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                GS(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                GQ(str);
            } else if (4 == i) {
                GR(str);
            } else if (-3 == i) {
                aX(str, i);
            } else if (-4 == i) {
                aX(str, i);
            } else {
                aX(str, i);
            }
        }
    }

    public void GQ(String str) {
        try {
            try {
                h.cpH().cpI();
                aY(str, 2);
                m.cpT().GI(str);
                h.cpH().cpJ();
            } catch (Exception e) {
                e.printStackTrace();
                h.cpH().cpJ();
            }
        } catch (Throwable th) {
            h.cpH().cpJ();
            throw th;
        }
    }

    public void GR(String str) {
        try {
            try {
                h.cpH().cpI();
                aY(str, 4);
                l.cpR().GI(str);
                h.cpH().cpJ();
            } catch (Exception e) {
                e.printStackTrace();
                h.cpH().cpJ();
            }
        } catch (Throwable th) {
            h.cpH().cpJ();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.cpH().cpI();
            if (w.isEmpty(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (int size = list.size() - 1; size >= 0; size--) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) w.getItem(list, size);
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
                if (cpE()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size2;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(w.subList(arrayList, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cpH().cpJ();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.cpH().cpI();
            if (!w.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (cpE()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) w.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aY(friendId, 4);
                        l.cpR().GI(friendId);
                        i = i2 + 1;
                        if (bVar != null) {
                            bVar.h((i * 100) / size, friendId, 4);
                        }
                    }
                    i3--;
                    i2 = i;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cpH().cpJ();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.cpH().cpI();
            List<String> cpX = n.cpX();
            if (w.isEmpty(cpX)) {
                return;
            }
            int size = cpX.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cpE()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(w.subList(cpX, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (cpE()) {
                return;
            }
            aY(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cpH().cpJ();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.GW(dq(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.cpT().GJ(str);
                if (cpE()) {
                    c cVar = new c();
                    cVar.id = str;
                    cVar.customGroupType = 2;
                    cVar.progress = i;
                    arrayList.add(cVar);
                } else {
                    bVar.h(i, str, 2);
                }
            }
            if (!arrayList.isEmpty() && bVar != null) {
                bVar.ds(arrayList);
            }
        }
    }

    private String dq(List<String> list) {
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
            h.cpH().cpI();
            l.cpR();
            List<String> cpS = l.cpS();
            if (w.isEmpty(cpS)) {
                return;
            }
            int size = cpS.size();
            int i = 0;
            for (String str : cpS) {
                if (cpE()) {
                    break;
                }
                aY(str, 4);
                l.cpR().GI(str);
                i++;
                if (bVar != null) {
                    bVar.h((i * 100) / size, str, 4);
                }
            }
            if (cpE()) {
                return;
            }
            aY(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cpH().cpJ();
        }
    }

    public void aX(String str, int i) {
        try {
            try {
                h.cpH().cpI();
                ImMessageCenterPojo bf = com.baidu.tieba.im.memorycache.b.crX().bf(str, i);
                bf.setIs_hidden(1);
                bf.setUnread_count(0);
                j.cpL().a(bf, 2);
                h.cpH().cpJ();
            } catch (Exception e) {
                e.printStackTrace();
                h.cpH().cpJ();
            }
        } catch (Throwable th) {
            h.cpH().cpJ();
            throw th;
        }
    }

    public void GS(String str) {
        try {
            h.cpH().cpI();
            ImMessageCenterPojo bf = com.baidu.tieba.im.memorycache.b.crX().bf(str, 1);
            bf.setIs_hidden(1);
            bf.setUnread_count(0);
            j.cpL().a(bf, 2);
            com.baidu.tieba.im.db.c.cpA().GJ(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.cpH().cpJ();
        }
    }

    public boolean cpD() {
        if (this.iPX != null && this.iPX.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.iPX.cancel(true);
        }
        this.iPX = null;
        return true;
    }

    public boolean cpE() {
        return this.iPX == null || (this.iPX != null && this.iPX.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.iPX = new a(i, bVar);
        this.iPX.setParallel(TiebaIMConfig.getParallel());
        this.iPX.setPriority(3);
        this.iPX.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.iPX = new a(i, bVar);
        this.iPX.setParallel(TiebaIMConfig.getParallel());
        this.iPX.setPriority(3);
        this.iPX.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b iQa;
        private b iQb = new b() { // from class: com.baidu.tieba.im.db.e.a.1
            @Override // com.baidu.tieba.im.db.e.b
            public void h(int i, String str, int i2) {
                if (a.this.isCancelled()) {
                    a.this.g(i, str, i2);
                    return;
                }
                c cVar = new c();
                cVar.id = str;
                cVar.customGroupType = i2;
                cVar.progress = i;
                a.this.publishProgress(cVar);
            }

            @Override // com.baidu.tieba.im.db.e.b
            public void ds(List<c> list) {
                a.this.dr(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.iQa = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    if (this.mCustomGroupType == 4) {
                        e.this.b(list, this.iQb);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.iQb);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.iQb);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(final int i, final String str, final int i2) {
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.iQa != null) {
                        a.this.iQa.onProgressUpdate(i, str, i2);
                        a.this.iQa.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dr(final List<c> list) {
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.iQa != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.iQa.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.iQa.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.iQa != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.iQa.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.iQa != null) {
                this.iQa.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.iQa != null) {
                if (isCancelled()) {
                    this.iQa.onCanceled();
                } else {
                    this.iQa.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.iQa != null) {
                this.iQa.onCanceled();
            }
        }
    }

    public void aY(String str, int i) {
        j.cpL().ba(str, i);
    }

    public void aZ(String str, int i) {
        com.baidu.tieba.im.memorycache.b.crX().aZ(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo bf = com.baidu.tieba.im.memorycache.b.crX().bf(str, i);
        if (bf != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bbo().xF(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bbo().mY(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bbo().mZ(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bbo().mZ(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.bbo().xE(str);
            }
            bf.setIs_hidden(1);
            bf.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.crX().bg(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.crX().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.crX().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d eV(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.iPY);
        return dVar;
    }
}
