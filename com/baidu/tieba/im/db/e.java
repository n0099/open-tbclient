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
    private static e hzC;
    private a hzD;
    private final DialogInterface.OnCancelListener hzE = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bUH();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void cU(List<c> list);

        void j(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e bUG() {
        if (hzC == null) {
            synchronized (e.class) {
                if (hzC == null) {
                    hzC = new e();
                }
            }
        }
        return hzC;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                CV(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                CT(str);
            } else if (4 == i) {
                CU(str);
            } else if (-3 == i) {
                aN(str, i);
            } else if (-4 == i) {
                aN(str, i);
            } else {
                aN(str, i);
            }
        }
    }

    public void CT(String str) {
        try {
            try {
                h.bUL().bUM();
                aO(str, 2);
                m.bUX().CL(str);
                h.bUL().bUN();
            } catch (Exception e) {
                e.printStackTrace();
                h.bUL().bUN();
            }
        } catch (Throwable th) {
            h.bUL().bUN();
            throw th;
        }
    }

    public void CU(String str) {
        try {
            try {
                h.bUL().bUM();
                aO(str, 4);
                l.bUV().CL(str);
                h.bUL().bUN();
            } catch (Exception e) {
                e.printStackTrace();
                h.bUL().bUN();
            }
        } catch (Throwable th) {
            h.bUL().bUN();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bUL().bUM();
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
                if (bUI()) {
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
            h.bUL().bUN();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bUL().bUM();
            if (!v.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bUI()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aO(friendId, 4);
                        l.bUV().CL(friendId);
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
            h.bUL().bUN();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bUL().bUM();
            List<String> bVb = n.bVb();
            if (v.isEmpty(bVb)) {
                return;
            }
            int size = bVb.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bUI()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.subList(bVb, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bUI()) {
                return;
            }
            aO(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bUL().bUN();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.CZ(cS(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bUX().CM(str);
                if (bUI()) {
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
                bVar.cU(arrayList);
            }
        }
    }

    private String cS(List<String> list) {
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
            h.bUL().bUM();
            l.bUV();
            List<String> bUW = l.bUW();
            if (v.isEmpty(bUW)) {
                return;
            }
            int size = bUW.size();
            int i = 0;
            for (String str : bUW) {
                if (bUI()) {
                    break;
                }
                aO(str, 4);
                l.bUV().CL(str);
                i++;
                if (bVar != null) {
                    bVar.j((i * 100) / size, str, 4);
                }
            }
            if (bUI()) {
                return;
            }
            aO(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bUL().bUN();
        }
    }

    public void aN(String str, int i) {
        try {
            try {
                h.bUL().bUM();
                ImMessageCenterPojo aV = com.baidu.tieba.im.memorycache.b.bXb().aV(str, i);
                aV.setIs_hidden(1);
                aV.setUnread_count(0);
                j.bUP().a(aV, 2);
                h.bUL().bUN();
            } catch (Exception e) {
                e.printStackTrace();
                h.bUL().bUN();
            }
        } catch (Throwable th) {
            h.bUL().bUN();
            throw th;
        }
    }

    public void CV(String str) {
        try {
            h.bUL().bUM();
            ImMessageCenterPojo aV = com.baidu.tieba.im.memorycache.b.bXb().aV(str, 1);
            aV.setIs_hidden(1);
            aV.setUnread_count(0);
            j.bUP().a(aV, 2);
            com.baidu.tieba.im.db.c.bUE().CM(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bUL().bUN();
        }
    }

    public boolean bUH() {
        if (this.hzD != null && this.hzD.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.hzD.cancel(true);
        }
        this.hzD = null;
        return true;
    }

    public boolean bUI() {
        return this.hzD == null || (this.hzD != null && this.hzD.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.hzD = new a(i, bVar);
        this.hzD.setParallel(TiebaIMConfig.getParallel());
        this.hzD.setPriority(3);
        this.hzD.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.hzD = new a(i, bVar);
        this.hzD.setParallel(TiebaIMConfig.getParallel());
        this.hzD.setPriority(3);
        this.hzD.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b hzG;
        private b hzH = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void cU(List<c> list) {
                a.this.cT(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.hzG = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    if (this.mCustomGroupType == 4) {
                        e.this.b(list, this.hzH);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.hzH);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.hzH);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(final int i, final String str, final int i2) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hzG != null) {
                        a.this.hzG.onProgressUpdate(i, str, i2);
                        a.this.hzG.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cT(final List<c> list) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.hzG != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.hzG.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.hzG.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.hzG != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.hzG.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.hzG != null) {
                this.hzG.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.hzG != null) {
                if (isCancelled()) {
                    this.hzG.onCanceled();
                } else {
                    this.hzG.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.hzG != null) {
                this.hzG.onCanceled();
            }
        }
    }

    public void aO(String str, int i) {
        j.bUP().aQ(str, i);
    }

    public void aP(String str, int i) {
        com.baidu.tieba.im.memorycache.b.bXb().aP(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aV = com.baidu.tieba.im.memorycache.b.bXb().aV(str, i);
        if (aV != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().uo(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().lN(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().lO(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().lO(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().un(str);
            }
            aV.setIs_hidden(1);
            aV.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.bXb().aW(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.bXb().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.bXb().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d eZ(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.hzE);
        return dVar;
    }
}
