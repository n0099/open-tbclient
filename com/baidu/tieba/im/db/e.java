package com.baidu.tieba.im.db;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e eBA;
    private a eBB;
    private final DialogInterface.OnCancelListener eBC = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.aIc();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cf(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e aIb() {
        if (eBA == null) {
            synchronized (e.class) {
                if (eBA == null) {
                    eBA = new e();
                }
            }
        }
        return eBA;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                nn(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                nl(str);
            } else if (4 == i) {
                nm(str);
            } else if (-3 == i) {
                af(str, i);
            } else if (-4 == i) {
                af(str, i);
            } else {
                af(str, i);
            }
        }
    }

    public void nl(String str) {
        try {
            try {
                h.aIg().aIh();
                ag(str, 2);
                m.aIs().nd(str);
                h.aIg().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aIg().endTransaction();
            }
        } catch (Throwable th) {
            h.aIg().endTransaction();
            throw th;
        }
    }

    public void nm(String str) {
        try {
            try {
                h.aIg().aIh();
                ag(str, 4);
                l.aIq().nd(str);
                h.aIg().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aIg().endTransaction();
            }
        } catch (Throwable th) {
            h.aIg().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.aIg().aIh();
            if (v.E(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (int size = list.size() - 1; size >= 0; size--) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.f(list, size);
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
                if (aId()) {
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
            h.aIg().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.aIg().aIh();
            if (!v.E(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (aId()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.f(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        ag(friendId, 4);
                        l.aIq().nd(friendId);
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
            h.aIg().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.aIg().aIh();
            List<String> aIw = n.aIw();
            if (v.E(aIw)) {
                return;
            }
            int size = aIw.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (aId()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.b(aIw, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (aId()) {
                return;
            }
            ag("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aIg().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.nq(cd(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.aIs().ne(str);
                if (aId()) {
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
                bVar.cf(arrayList);
            }
        }
    }

    private String cd(List<String> list) {
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
            h.aIg().aIh();
            l.aIq();
            List<String> aIr = l.aIr();
            if (v.E(aIr)) {
                return;
            }
            int size = aIr.size();
            int i = 0;
            for (String str : aIr) {
                if (aId()) {
                    break;
                }
                ag(str, 4);
                l.aIq().nd(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (aId()) {
                return;
            }
            ag("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aIg().endTransaction();
        }
    }

    public void af(String str, int i) {
        try {
            try {
                h.aIg().aIh();
                ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aKB().an(str, i);
                an.setIs_hidden(1);
                an.setUnread_count(0);
                j.aIk().f(an);
                h.aIg().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aIg().endTransaction();
            }
        } catch (Throwable th) {
            h.aIg().endTransaction();
            throw th;
        }
    }

    public void nn(String str) {
        try {
            h.aIg().aIh();
            ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aKB().an(str, 1);
            an.setIs_hidden(1);
            an.setUnread_count(0);
            j.aIk().f(an);
            com.baidu.tieba.im.db.c.aHZ().ne(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.aIg().endTransaction();
        }
    }

    public boolean aIc() {
        if (this.eBB != null && this.eBB.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.eBB.cancel(true);
            this.eBB = null;
        }
        return true;
    }

    public boolean aId() {
        return this.eBB == null || (this.eBB != null && this.eBB.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eBB = new a(i, bVar);
        this.eBB.setParallel(TiebaIMConfig.getParallel());
        this.eBB.setPriority(3);
        this.eBB.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eBB = new a(i, bVar);
        this.eBB.setParallel(TiebaIMConfig.getParallel());
        this.eBB.setPriority(3);
        this.eBB.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b eBE;
        private b eBF = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void cf(List<c> list) {
                a.this.ce(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.eBE = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    if (this.mCustomGroupType == 4) {
                        e.this.b(list, this.eBF);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.eBF);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.eBF);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eBE != null) {
                        a.this.eBE.onProgressUpdate(i, str, i2);
                        a.this.eBE.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ce(final List<c> list) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.eBE != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.eBE.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.eBE.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.eBE != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.eBE.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.eBE != null) {
                this.eBE.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.eBE != null) {
                if (isCancelled()) {
                    this.eBE.onCanceled();
                } else {
                    this.eBE.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eBE != null) {
                this.eBE.onCanceled();
            }
        }
    }

    public void ag(String str, int i) {
        j.aIk().ai(str, i);
    }

    public void ah(String str, int i) {
        com.baidu.tieba.im.memorycache.b.aKB().ah(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aKB().an(str, i);
        if (an != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().fp(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().gS(com.baidu.adp.lib.g.b.h(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().gT(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().gT(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().fo(str);
            }
            an.setIs_hidden(1);
            an.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.aKB().ao(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.aKB().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.aKB().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d bL(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(d.j.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.eBC);
        return dVar;
    }
}
