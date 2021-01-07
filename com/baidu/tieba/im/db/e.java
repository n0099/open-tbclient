package com.baidu.tieba.im.db;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e kBh;
    private a kBi;
    private final DialogInterface.OnCancelListener kBj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cXp();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void e(int i, String str, int i2);

        void ez(List<c> list);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e cXo() {
        if (kBh == null) {
            synchronized (e.class) {
                if (kBh == null) {
                    kBh = new e();
                }
            }
        }
        return kBh;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                Nh(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                Nf(str);
            } else if (4 == i) {
                Ng(str);
            } else if (-3 == i) {
                bk(str, i);
            } else if (-4 == i) {
                bk(str, i);
            } else {
                bk(str, i);
            }
        }
    }

    public void Nf(String str) {
        try {
            try {
                h.cXt().cXu();
                bl(str, 2);
                m.cXG().MX(str);
                h.cXt().cXv();
            } catch (Exception e) {
                e.printStackTrace();
                h.cXt().cXv();
            }
        } catch (Throwable th) {
            h.cXt().cXv();
            throw th;
        }
    }

    public void Ng(String str) {
        try {
            try {
                h.cXt().cXu();
                bl(str, 4);
                l.cXD().MX(str);
                h.cXt().cXv();
            } catch (Exception e) {
                e.printStackTrace();
                h.cXt().cXv();
            }
        } catch (Throwable th) {
            h.cXt().cXv();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.cXt().cXu();
            if (x.isEmpty(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (int size = list.size() - 1; size >= 0; size--) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) x.getItem(list, size);
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
                if (cXq()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size2;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(x.subList(arrayList, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cXt().cXv();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.cXt().cXu();
            if (!x.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (cXq()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) x.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        bl(friendId, 4);
                        l.cXD().MX(friendId);
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
            h.cXt().cXv();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.cXt().cXu();
            List<String> cXK = n.cXK();
            if (x.isEmpty(cXK)) {
                return;
            }
            int size = cXK.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cXq()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(x.subList(cXK, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (cXq()) {
                return;
            }
            bl(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cXt().cXv();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.Nl(ex(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.cXG().MY(str);
                if (cXq()) {
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
                bVar.ez(arrayList);
            }
        }
    }

    private String ex(List<String> list) {
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
            h.cXt().cXu();
            l.cXD();
            List<String> cXE = l.cXE();
            if (x.isEmpty(cXE)) {
                return;
            }
            int size = cXE.size();
            int i = 0;
            for (String str : cXE) {
                if (cXq()) {
                    break;
                }
                bl(str, 4);
                l.cXD().MX(str);
                i++;
                if (bVar != null) {
                    bVar.e((i * 100) / size, str, 4);
                }
            }
            if (cXq()) {
                return;
            }
            bl(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.cXt().cXv();
        }
    }

    public void bk(String str, int i) {
        try {
            try {
                h.cXt().cXu();
                ImMessageCenterPojo br = com.baidu.tieba.im.memorycache.b.cYy().br(str, i);
                br.setIs_hidden(1);
                br.setUnread_count(0);
                j.cXx().a(br, 2);
                h.cXt().cXv();
            } catch (Exception e) {
                e.printStackTrace();
                h.cXt().cXv();
            }
        } catch (Throwable th) {
            h.cXt().cXv();
            throw th;
        }
    }

    public void Nh(String str) {
        try {
            h.cXt().cXu();
            ImMessageCenterPojo br = com.baidu.tieba.im.memorycache.b.cYy().br(str, 1);
            br.setIs_hidden(1);
            br.setUnread_count(0);
            j.cXx().a(br, 2);
            com.baidu.tieba.im.db.c.cXm().MY(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.cXt().cXv();
        }
    }

    public boolean cXp() {
        if (this.kBi != null && this.kBi.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.kBi.cancel(true);
        }
        this.kBi = null;
        return true;
    }

    public boolean cXq() {
        return this.kBi == null || (this.kBi != null && this.kBi.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.kBi = new a(i, bVar);
        this.kBi.setParallel(TiebaIMConfig.getParallel());
        this.kBi.setPriority(3);
        this.kBi.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.kBi = new a(i, bVar);
        this.kBi.setParallel(TiebaIMConfig.getParallel());
        this.kBi.setPriority(3);
        this.kBi.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b kBl;
        private b kBm = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void ez(List<c> list) {
                a.this.ey(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.kBl = bVar;
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
                        e.this.b(list, this.kBm);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.kBm);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.kBm);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(final int i, final String str, final int i2) {
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.kBl != null) {
                        a.this.kBl.onProgressUpdate(i, str, i2);
                        a.this.kBl.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ey(final List<c> list) {
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.kBl != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.kBl.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.kBl.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.kBl != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.kBl.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.kBl != null) {
                this.kBl.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.kBl != null) {
                if (isCancelled()) {
                    this.kBl.onCanceled();
                } else {
                    this.kBl.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.kBl != null) {
                this.kBl.onCanceled();
            }
        }
    }

    public void bl(String str, int i) {
        j.cXx().bn(str, i);
    }

    public void bm(String str, int i) {
        com.baidu.tieba.im.memorycache.b.cYy().bm(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo br = com.baidu.tieba.im.memorycache.b.cYy().br(str, i);
        if (br != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bBd().CU(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bBd().rR(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bBd().rS(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bBd().rS(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.bBd().CT(str);
            }
            br.setIs_hidden(1);
            br.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.cYy().bs(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.cYy().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.cYy().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d gx(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.kBj);
        return dVar;
    }
}
