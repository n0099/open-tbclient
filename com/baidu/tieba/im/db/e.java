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
    private static e hxQ;
    private a hxR;
    private final DialogInterface.OnCancelListener hxS = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.bUo();
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

    public static e bUn() {
        if (hxQ == null) {
            synchronized (e.class) {
                if (hxQ == null) {
                    hxQ = new e();
                }
            }
        }
        return hxQ;
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
                h.bUs().bUt();
                aO(str, 2);
                m.bUE().CL(str);
                h.bUs().bUu();
            } catch (Exception e) {
                e.printStackTrace();
                h.bUs().bUu();
            }
        } catch (Throwable th) {
            h.bUs().bUu();
            throw th;
        }
    }

    public void CU(String str) {
        try {
            try {
                h.bUs().bUt();
                aO(str, 4);
                l.bUC().CL(str);
                h.bUs().bUu();
            } catch (Exception e) {
                e.printStackTrace();
                h.bUs().bUu();
            }
        } catch (Throwable th) {
            h.bUs().bUu();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.bUs().bUt();
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
                if (bUp()) {
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
            h.bUs().bUu();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.bUs().bUt();
            if (!v.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (bUp()) {
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
                        l.bUC().CL(friendId);
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
            h.bUs().bUu();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.bUs().bUt();
            List<String> bUI = n.bUI();
            if (v.isEmpty(bUI)) {
                return;
            }
            int size = bUI.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (bUp()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.subList(bUI, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (bUp()) {
                return;
            }
            aO(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bUs().bUu();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.CZ(cS(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.bUE().CM(str);
                if (bUp()) {
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
            h.bUs().bUt();
            l.bUC();
            List<String> bUD = l.bUD();
            if (v.isEmpty(bUD)) {
                return;
            }
            int size = bUD.size();
            int i = 0;
            for (String str : bUD) {
                if (bUp()) {
                    break;
                }
                aO(str, 4);
                l.bUC().CL(str);
                i++;
                if (bVar != null) {
                    bVar.j((i * 100) / size, str, 4);
                }
            }
            if (bUp()) {
                return;
            }
            aO(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.bUs().bUu();
        }
    }

    public void aN(String str, int i) {
        try {
            try {
                h.bUs().bUt();
                ImMessageCenterPojo aV = com.baidu.tieba.im.memorycache.b.bWI().aV(str, i);
                aV.setIs_hidden(1);
                aV.setUnread_count(0);
                j.bUw().a(aV, 2);
                h.bUs().bUu();
            } catch (Exception e) {
                e.printStackTrace();
                h.bUs().bUu();
            }
        } catch (Throwable th) {
            h.bUs().bUu();
            throw th;
        }
    }

    public void CV(String str) {
        try {
            h.bUs().bUt();
            ImMessageCenterPojo aV = com.baidu.tieba.im.memorycache.b.bWI().aV(str, 1);
            aV.setIs_hidden(1);
            aV.setUnread_count(0);
            j.bUw().a(aV, 2);
            com.baidu.tieba.im.db.c.bUl().CM(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.bUs().bUu();
        }
    }

    public boolean bUo() {
        if (this.hxR != null && this.hxR.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.hxR.cancel(true);
        }
        this.hxR = null;
        return true;
    }

    public boolean bUp() {
        return this.hxR == null || (this.hxR != null && this.hxR.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.hxR = new a(i, bVar);
        this.hxR.setParallel(TiebaIMConfig.getParallel());
        this.hxR.setPriority(3);
        this.hxR.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.hxR = new a(i, bVar);
        this.hxR.setParallel(TiebaIMConfig.getParallel());
        this.hxR.setPriority(3);
        this.hxR.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b hxU;
        private b hxV = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            this.hxU = bVar;
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
                        e.this.b(list, this.hxV);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.hxV);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.hxV);
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
                    if (a.this.hxU != null) {
                        a.this.hxU.onProgressUpdate(i, str, i2);
                        a.this.hxU.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cT(final List<c> list) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.hxU != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.hxU.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.hxU.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.hxU != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.hxU.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.hxU != null) {
                this.hxU.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.hxU != null) {
                if (isCancelled()) {
                    this.hxU.onCanceled();
                } else {
                    this.hxU.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.hxU != null) {
                this.hxU.onCanceled();
            }
        }
    }

    public void aO(String str, int i) {
        j.bUw().aQ(str, i);
    }

    public void aP(String str, int i) {
        com.baidu.tieba.im.memorycache.b.bWI().aP(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo aV = com.baidu.tieba.im.memorycache.b.bWI().aV(str, i);
        if (aV != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKE().uo(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKE().lL(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKE().lM(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKE().lM(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKE().un(str);
            }
            aV.setIs_hidden(1);
            aV.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.bWI().aW(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.bWI().f(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.bWI().f(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d fa(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.hxS);
        return dVar;
    }
}
