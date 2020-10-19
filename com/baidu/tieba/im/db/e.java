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
    private static e jJG;
    private a jJH;
    private final DialogInterface.OnCancelListener jJI = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cLp();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void dQ(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e cLo() {
        if (jJG == null) {
            synchronized (e.class) {
                if (jJG == null) {
                    jJG = new e();
                }
            }
        }
        return jJG;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                LQ(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                LO(str);
            } else if (4 == i) {
                LP(str);
            } else if (-3 == i) {
                ba(str, i);
            } else if (-4 == i) {
                ba(str, i);
            } else {
                ba(str, i);
            }
        }
    }

    public void LO(String str) {
        try {
            try {
                h.cLt().cLu();
                bb(str, 2);
                m.cLG().LG(str);
                h.cLt().cLv();
            } catch (Exception e) {
                e.printStackTrace();
                h.cLt().cLv();
            }
        } catch (Throwable th) {
            h.cLt().cLv();
            throw th;
        }
    }

    public void LP(String str) {
        try {
            try {
                h.cLt().cLu();
                bb(str, 4);
                l.cLD().LG(str);
                h.cLt().cLv();
            } catch (Exception e) {
                e.printStackTrace();
                h.cLt().cLv();
            }
        } catch (Throwable th) {
            h.cLt().cLv();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.cLt().cLu();
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
                if (cLq()) {
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
            h.cLt().cLv();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.cLt().cLu();
            if (!y.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (cLq()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) y.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        bb(friendId, 4);
                        l.cLD().LG(friendId);
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
            h.cLt().cLv();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.cLt().cLu();
            List<String> cLK = n.cLK();
            if (y.isEmpty(cLK)) {
                return;
            }
            int size = cLK.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cLq()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(y.subList(cLK, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (cLq()) {
                return;
            }
            bb(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cLt().cLv();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.LU(dO(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.cLG().LH(str);
                if (cLq()) {
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
                bVar.dQ(arrayList);
            }
        }
    }

    private String dO(List<String> list) {
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
            h.cLt().cLu();
            l.cLD();
            List<String> cLE = l.cLE();
            if (y.isEmpty(cLE)) {
                return;
            }
            int size = cLE.size();
            int i = 0;
            for (String str : cLE) {
                if (cLq()) {
                    break;
                }
                bb(str, 4);
                l.cLD().LG(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (cLq()) {
                return;
            }
            bb(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cLt().cLv();
        }
    }

    public void ba(String str, int i) {
        try {
            try {
                h.cLt().cLu();
                ImMessageCenterPojo bi = com.baidu.tieba.im.memorycache.b.cOc().bi(str, i);
                bi.setIs_hidden(1);
                bi.setUnread_count(0);
                j.cLx().a(bi, 2);
                h.cLt().cLv();
            } catch (Exception e) {
                e.printStackTrace();
                h.cLt().cLv();
            }
        } catch (Throwable th) {
            h.cLt().cLv();
            throw th;
        }
    }

    public void LQ(String str) {
        try {
            h.cLt().cLu();
            ImMessageCenterPojo bi = com.baidu.tieba.im.memorycache.b.cOc().bi(str, 1);
            bi.setIs_hidden(1);
            bi.setUnread_count(0);
            j.cLx().a(bi, 2);
            com.baidu.tieba.im.db.c.cLm().LH(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.cLt().cLv();
        }
    }

    public boolean cLp() {
        if (this.jJH != null && this.jJH.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.jJH.cancel(true);
        }
        this.jJH = null;
        return true;
    }

    public boolean cLq() {
        return this.jJH == null || (this.jJH != null && this.jJH.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.jJH = new a(i, bVar);
        this.jJH.setParallel(TiebaIMConfig.getParallel());
        this.jJH.setPriority(3);
        this.jJH.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.jJH = new a(i, bVar);
        this.jJH.setParallel(TiebaIMConfig.getParallel());
        this.jJH.setPriority(3);
        this.jJH.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b jJK;
        private b jJL = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void dQ(List<c> list) {
                a.this.dP(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.jJK = bVar;
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
                        e.this.b(list, this.jJL);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.jJL);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.jJL);
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
                    if (a.this.jJK != null) {
                        a.this.jJK.onProgressUpdate(i, str, i2);
                        a.this.jJK.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dP(final List<c> list) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.jJK != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.jJK.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.jJK.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.jJK != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.jJK.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.jJK != null) {
                this.jJK.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.jJK != null) {
                if (isCancelled()) {
                    this.jJK.onCanceled();
                } else {
                    this.jJK.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.jJK != null) {
                this.jJK.onCanceled();
            }
        }
    }

    public void bb(String str, int i) {
        j.cLx().bd(str, i);
    }

    public void bc(String str, int i) {
        com.baidu.tieba.im.memorycache.b.cOc().bc(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo bi = com.baidu.tieba.im.memorycache.b.cOc().bi(str, i);
        if (bi != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.brz().Cj(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.brz().ql(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.brz().qm(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.brz().qm(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.brz().Ci(str);
            }
            bi.setIs_hidden(1);
            bi.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.cOc().bj(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.cOc().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.cOc().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d fy(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.jJI);
        return dVar;
    }
}
