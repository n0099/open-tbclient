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
    private static e eGH;
    private a eGI;
    private final DialogInterface.OnCancelListener eGJ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.aOA();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cy(List<c> list);

        void e(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e aOz() {
        if (eGH == null) {
            synchronized (e.class) {
                if (eGH == null) {
                    eGH = new e();
                }
            }
        }
        return eGH;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                pv(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                pt(str);
            } else if (4 == i) {
                pu(str);
            } else if (-3 == i) {
                ao(str, i);
            } else if (-4 == i) {
                ao(str, i);
            } else {
                ao(str, i);
            }
        }
    }

    public void pt(String str) {
        try {
            try {
                h.aOE().aOF();
                ap(str, 2);
                m.aOP().pl(str);
                h.aOE().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aOE().endTransaction();
            }
        } catch (Throwable th) {
            h.aOE().endTransaction();
            throw th;
        }
    }

    public void pu(String str) {
        try {
            try {
                h.aOE().aOF();
                ap(str, 4);
                l.aON().pl(str);
                h.aOE().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aOE().endTransaction();
            }
        } catch (Throwable th) {
            h.aOE().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.aOE().aOF();
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
                if (aOB()) {
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
            h.aOE().endTransaction();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.aOE().aOF();
            if (!v.I(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (aOB()) {
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
                        l.aON().pl(friendId);
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
            h.aOE().endTransaction();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.aOE().aOF();
            List<String> aOT = n.aOT();
            if (v.I(aOT)) {
                return;
            }
            int size = aOT.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (aOB()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.b(aOT, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (aOB()) {
                return;
            }
            ap("-1001", -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aOE().endTransaction();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.py(cw(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.aOP().pm(str);
                if (aOB()) {
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
                bVar.cy(arrayList);
            }
        }
    }

    private String cw(List<String> list) {
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
            h.aOE().aOF();
            l.aON();
            List<String> aOO = l.aOO();
            if (v.I(aOO)) {
                return;
            }
            int size = aOO.size();
            int i = 0;
            for (String str : aOO) {
                if (aOB()) {
                    break;
                }
                ap(str, 4);
                l.aON().pl(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (aOB()) {
                return;
            }
            ap("-1000", -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.aOE().endTransaction();
        }
    }

    public void ao(String str, int i) {
        try {
            try {
                h.aOE().aOF();
                ImMessageCenterPojo aw = com.baidu.tieba.im.memorycache.b.aQV().aw(str, i);
                aw.setIs_hidden(1);
                aw.setUnread_count(0);
                j.aOH().a(aw, 2);
                h.aOE().endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                h.aOE().endTransaction();
            }
        } catch (Throwable th) {
            h.aOE().endTransaction();
            throw th;
        }
    }

    public void pv(String str) {
        try {
            h.aOE().aOF();
            ImMessageCenterPojo aw = com.baidu.tieba.im.memorycache.b.aQV().aw(str, 1);
            aw.setIs_hidden(1);
            aw.setUnread_count(0);
            j.aOH().a(aw, 2);
            com.baidu.tieba.im.db.c.aOx().pm(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.aOE().endTransaction();
        }
    }

    public boolean aOA() {
        if (this.eGI != null && this.eGI.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.eGI.cancel(true);
        }
        this.eGI = null;
        return true;
    }

    public boolean aOB() {
        return this.eGI == null || (this.eGI != null && this.eGI.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eGI = new a(i, bVar);
        this.eGI.setParallel(TiebaIMConfig.getParallel());
        this.eGI.setPriority(3);
        this.eGI.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.eGI = new a(i, bVar);
        this.eGI.setParallel(TiebaIMConfig.getParallel());
        this.eGI.setPriority(3);
        this.eGI.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b eGL;
        private b eGM = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void cy(List<c> list) {
                a.this.cx(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.eGL = bVar;
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
                        e.this.b(list, this.eGM);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.eGM);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.eGM);
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
                    if (a.this.eGL != null) {
                        a.this.eGL.onProgressUpdate(i, str, i2);
                        a.this.eGL.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cx(final List<c> list) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.eGL != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.eGL.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.eGL.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.eGL != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.eGL.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.eGL != null) {
                this.eGL.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.eGL != null) {
                if (isCancelled()) {
                    this.eGL.onCanceled();
                } else {
                    this.eGL.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eGL != null) {
                this.eGL.onCanceled();
            }
        }
    }

    public void ap(String str, int i) {
        j.aOH().ar(str, i);
    }

    public void aq(String str, int i) {
        com.baidu.tieba.im.memorycache.b.aQV().aq(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aw = com.baidu.tieba.im.memorycache.b.aQV().aw(str, i);
        if (aw != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GL().gr(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GL().eF(com.baidu.adp.lib.g.b.l(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GL().eG(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GL().eG(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.a.GL().gq(str);
            }
            aw.setIs_hidden(1);
            aw.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.aQV().ax(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.aQV().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.aQV().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d cz(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(e.j.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.eGJ);
        return dVar;
    }
}
