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
    private static e jWf;
    private a jWg;
    private final DialogInterface.OnCancelListener jWh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cOw();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void dZ(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e cOv() {
        if (jWf == null) {
            synchronized (e.class) {
                if (jWf == null) {
                    jWf = new e();
                }
            }
        }
        return jWf;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                Mo(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                Mm(str);
            } else if (4 == i) {
                Mn(str);
            } else if (-3 == i) {
                bb(str, i);
            } else if (-4 == i) {
                bb(str, i);
            } else {
                bb(str, i);
            }
        }
    }

    public void Mm(String str) {
        try {
            try {
                h.cOA().cOB();
                bc(str, 2);
                m.cON().Me(str);
                h.cOA().cOC();
            } catch (Exception e) {
                e.printStackTrace();
                h.cOA().cOC();
            }
        } catch (Throwable th) {
            h.cOA().cOC();
            throw th;
        }
    }

    public void Mn(String str) {
        try {
            try {
                h.cOA().cOB();
                bc(str, 4);
                l.cOK().Me(str);
                h.cOA().cOC();
            } catch (Exception e) {
                e.printStackTrace();
                h.cOA().cOC();
            }
        } catch (Throwable th) {
            h.cOA().cOC();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.cOA().cOB();
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
                if (cOx()) {
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
            h.cOA().cOC();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.cOA().cOB();
            if (!y.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (cOx()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) y.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        bc(friendId, 4);
                        l.cOK().Me(friendId);
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
            h.cOA().cOC();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.cOA().cOB();
            List<String> cOR = n.cOR();
            if (y.isEmpty(cOR)) {
                return;
            }
            int size = cOR.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cOx()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(y.subList(cOR, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (cOx()) {
                return;
            }
            bc(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cOA().cOC();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.Ms(dX(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.cON().Mf(str);
                if (cOx()) {
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
                bVar.dZ(arrayList);
            }
        }
    }

    private String dX(List<String> list) {
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
            h.cOA().cOB();
            l.cOK();
            List<String> cOL = l.cOL();
            if (y.isEmpty(cOL)) {
                return;
            }
            int size = cOL.size();
            int i = 0;
            for (String str : cOL) {
                if (cOx()) {
                    break;
                }
                bc(str, 4);
                l.cOK().Me(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (cOx()) {
                return;
            }
            bc(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cOA().cOC();
        }
    }

    public void bb(String str, int i) {
        try {
            try {
                h.cOA().cOB();
                ImMessageCenterPojo bj = com.baidu.tieba.im.memorycache.b.cRj().bj(str, i);
                bj.setIs_hidden(1);
                bj.setUnread_count(0);
                j.cOE().a(bj, 2);
                h.cOA().cOC();
            } catch (Exception e) {
                e.printStackTrace();
                h.cOA().cOC();
            }
        } catch (Throwable th) {
            h.cOA().cOC();
            throw th;
        }
    }

    public void Mo(String str) {
        try {
            h.cOA().cOB();
            ImMessageCenterPojo bj = com.baidu.tieba.im.memorycache.b.cRj().bj(str, 1);
            bj.setIs_hidden(1);
            bj.setUnread_count(0);
            j.cOE().a(bj, 2);
            com.baidu.tieba.im.db.c.cOt().Mf(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.cOA().cOC();
        }
    }

    public boolean cOw() {
        if (this.jWg != null && this.jWg.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.jWg.cancel(true);
        }
        this.jWg = null;
        return true;
    }

    public boolean cOx() {
        return this.jWg == null || (this.jWg != null && this.jWg.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.jWg = new a(i, bVar);
        this.jWg.setParallel(TiebaIMConfig.getParallel());
        this.jWg.setPriority(3);
        this.jWg.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.jWg = new a(i, bVar);
        this.jWg.setParallel(TiebaIMConfig.getParallel());
        this.jWg.setPriority(3);
        this.jWg.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b jWj;
        private b jWk = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void dZ(List<c> list) {
                a.this.dY(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.jWj = bVar;
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
                        e.this.b(list, this.jWk);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.jWk);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.jWk);
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
                    if (a.this.jWj != null) {
                        a.this.jWj.onProgressUpdate(i, str, i2);
                        a.this.jWj.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dY(final List<c> list) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.jWj != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.jWj.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.jWj.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.jWj != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.jWj.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.jWj != null) {
                this.jWj.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.jWj != null) {
                if (isCancelled()) {
                    this.jWj.onCanceled();
                } else {
                    this.jWj.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.jWj != null) {
                this.jWj.onCanceled();
            }
        }
    }

    public void bc(String str, int i) {
        j.cOE().be(str, i);
    }

    public void bd(String str, int i) {
        com.baidu.tieba.im.memorycache.b.cRj().bd(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo bj = com.baidu.tieba.im.memorycache.b.cRj().bj(str, i);
        if (bj != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bts().CC(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bts().qw(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bts().qx(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bts().qx(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.bts().CB(str);
            }
            bj.setIs_hidden(1);
            bj.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.cRj().bk(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.cRj().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.cRj().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d fz(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.jWh);
        return dVar;
    }
}
