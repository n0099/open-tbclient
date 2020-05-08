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
    private static e ijw;
    private a ijx;
    private final DialogInterface.OnCancelListener ijy = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cfg();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void df(List<c> list);

        void j(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e cff() {
        if (ijw == null) {
            synchronized (e.class) {
                if (ijw == null) {
                    ijw = new e();
                }
            }
        }
        return ijw;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                EH(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                EF(str);
            } else if (4 == i) {
                EG(str);
            } else if (-3 == i) {
                aX(str, i);
            } else if (-4 == i) {
                aX(str, i);
            } else {
                aX(str, i);
            }
        }
    }

    public void EF(String str) {
        try {
            try {
                h.cfk().cfl();
                aY(str, 2);
                m.cfw().Ex(str);
                h.cfk().cfm();
            } catch (Exception e) {
                e.printStackTrace();
                h.cfk().cfm();
            }
        } catch (Throwable th) {
            h.cfk().cfm();
            throw th;
        }
    }

    public void EG(String str) {
        try {
            try {
                h.cfk().cfl();
                aY(str, 4);
                l.cfu().Ex(str);
                h.cfk().cfm();
            } catch (Exception e) {
                e.printStackTrace();
                h.cfk().cfm();
            }
        } catch (Throwable th) {
            h.cfk().cfm();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.cfk().cfl();
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
                if (cfh()) {
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
            h.cfk().cfm();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.cfk().cfl();
            if (!v.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (cfh()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aY(friendId, 4);
                        l.cfu().Ex(friendId);
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
            h.cfk().cfm();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.cfk().cfl();
            List<String> cfA = n.cfA();
            if (v.isEmpty(cfA)) {
                return;
            }
            int size = cfA.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cfh()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.subList(cfA, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (cfh()) {
                return;
            }
            aY(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cfk().cfm();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.EL(dd(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.cfw().Ey(str);
                if (cfh()) {
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
                bVar.df(arrayList);
            }
        }
    }

    private String dd(List<String> list) {
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
            h.cfk().cfl();
            l.cfu();
            List<String> cfv = l.cfv();
            if (v.isEmpty(cfv)) {
                return;
            }
            int size = cfv.size();
            int i = 0;
            for (String str : cfv) {
                if (cfh()) {
                    break;
                }
                aY(str, 4);
                l.cfu().Ex(str);
                i++;
                if (bVar != null) {
                    bVar.j((i * 100) / size, str, 4);
                }
            }
            if (cfh()) {
                return;
            }
            aY(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cfk().cfm();
        }
    }

    public void aX(String str, int i) {
        try {
            try {
                h.cfk().cfl();
                ImMessageCenterPojo bf = com.baidu.tieba.im.memorycache.b.chA().bf(str, i);
                bf.setIs_hidden(1);
                bf.setUnread_count(0);
                j.cfo().a(bf, 2);
                h.cfk().cfm();
            } catch (Exception e) {
                e.printStackTrace();
                h.cfk().cfm();
            }
        } catch (Throwable th) {
            h.cfk().cfm();
            throw th;
        }
    }

    public void EH(String str) {
        try {
            h.cfk().cfl();
            ImMessageCenterPojo bf = com.baidu.tieba.im.memorycache.b.chA().bf(str, 1);
            bf.setIs_hidden(1);
            bf.setUnread_count(0);
            j.cfo().a(bf, 2);
            com.baidu.tieba.im.db.c.cfd().Ey(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.cfk().cfm();
        }
    }

    public boolean cfg() {
        if (this.ijx != null && this.ijx.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.ijx.cancel(true);
        }
        this.ijx = null;
        return true;
    }

    public boolean cfh() {
        return this.ijx == null || (this.ijx != null && this.ijx.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.ijx = new a(i, bVar);
        this.ijx.setParallel(TiebaIMConfig.getParallel());
        this.ijx.setPriority(3);
        this.ijx.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.ijx = new a(i, bVar);
        this.ijx.setParallel(TiebaIMConfig.getParallel());
        this.ijx.setPriority(3);
        this.ijx.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b ijA;
        private b ijB = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void df(List<c> list) {
                a.this.de(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.ijA = bVar;
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
                        e.this.b(list, this.ijB);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.ijB);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.ijB);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(final int i, final String str, final int i2) {
            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ijA != null) {
                        a.this.ijA.onProgressUpdate(i, str, i2);
                        a.this.ijA.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void de(final List<c> list) {
            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.ijA != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.ijA.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.ijA.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.ijA != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.ijA.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.ijA != null) {
                this.ijA.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.ijA != null) {
                if (isCancelled()) {
                    this.ijA.onCanceled();
                } else {
                    this.ijA.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.ijA != null) {
                this.ijA.onCanceled();
            }
        }
    }

    public void aY(String str, int i) {
        j.cfo().ba(str, i);
    }

    public void aZ(String str, int i) {
        com.baidu.tieba.im.memorycache.b.chA().aZ(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo bf = com.baidu.tieba.im.memorycache.b.chA().bf(str, i);
        if (bf != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aTe().vG(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aTe().lZ(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aTe().ma(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aTe().ma(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.aTe().vF(str);
            }
            bf.setIs_hidden(1);
            bf.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.chA().bg(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.chA().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.chA().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d eG(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.ijy);
        return dVar;
    }
}
