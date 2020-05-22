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
    private static e iye;
    private a iyf;
    private final DialogInterface.OnCancelListener iyg = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.clE();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void dd(List<c> list);

        void h(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e clD() {
        if (iye == null) {
            synchronized (e.class) {
                if (iye == null) {
                    iye = new e();
                }
            }
        }
        return iye;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                Gq(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                Go(str);
            } else if (4 == i) {
                Gp(str);
            } else if (-3 == i) {
                aY(str, i);
            } else if (-4 == i) {
                aY(str, i);
            } else {
                aY(str, i);
            }
        }
    }

    public void Go(String str) {
        try {
            try {
                h.clI().clJ();
                aZ(str, 2);
                m.clU().Gg(str);
                h.clI().clK();
            } catch (Exception e) {
                e.printStackTrace();
                h.clI().clK();
            }
        } catch (Throwable th) {
            h.clI().clK();
            throw th;
        }
    }

    public void Gp(String str) {
        try {
            try {
                h.clI().clJ();
                aZ(str, 4);
                l.clS().Gg(str);
                h.clI().clK();
            } catch (Exception e) {
                e.printStackTrace();
                h.clI().clK();
            }
        } catch (Throwable th) {
            h.clI().clK();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.clI().clJ();
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
                if (clF()) {
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
            h.clI().clK();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.clI().clJ();
            if (!v.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (clF()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) v.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aZ(friendId, 4);
                        l.clS().Gg(friendId);
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
            h.clI().clK();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.clI().clJ();
            List<String> clY = n.clY();
            if (v.isEmpty(clY)) {
                return;
            }
            int size = clY.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (clF()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(v.subList(clY, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (clF()) {
                return;
            }
            aZ(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.clI().clK();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.Gu(db(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.clU().Gh(str);
                if (clF()) {
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
                bVar.dd(arrayList);
            }
        }
    }

    private String db(List<String> list) {
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
            h.clI().clJ();
            l.clS();
            List<String> clT = l.clT();
            if (v.isEmpty(clT)) {
                return;
            }
            int size = clT.size();
            int i = 0;
            for (String str : clT) {
                if (clF()) {
                    break;
                }
                aZ(str, 4);
                l.clS().Gg(str);
                i++;
                if (bVar != null) {
                    bVar.h((i * 100) / size, str, 4);
                }
            }
            if (clF()) {
                return;
            }
            aZ(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.clI().clK();
        }
    }

    public void aY(String str, int i) {
        try {
            try {
                h.clI().clJ();
                ImMessageCenterPojo bg = com.baidu.tieba.im.memorycache.b.cnY().bg(str, i);
                bg.setIs_hidden(1);
                bg.setUnread_count(0);
                j.clM().a(bg, 2);
                h.clI().clK();
            } catch (Exception e) {
                e.printStackTrace();
                h.clI().clK();
            }
        } catch (Throwable th) {
            h.clI().clK();
            throw th;
        }
    }

    public void Gq(String str) {
        try {
            h.clI().clJ();
            ImMessageCenterPojo bg = com.baidu.tieba.im.memorycache.b.cnY().bg(str, 1);
            bg.setIs_hidden(1);
            bg.setUnread_count(0);
            j.clM().a(bg, 2);
            com.baidu.tieba.im.db.c.clB().Gh(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.clI().clK();
        }
    }

    public boolean clE() {
        if (this.iyf != null && this.iyf.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.iyf.cancel(true);
        }
        this.iyf = null;
        return true;
    }

    public boolean clF() {
        return this.iyf == null || (this.iyf != null && this.iyf.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.iyf = new a(i, bVar);
        this.iyf.setParallel(TiebaIMConfig.getParallel());
        this.iyf.setPriority(3);
        this.iyf.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.iyf = new a(i, bVar);
        this.iyf.setParallel(TiebaIMConfig.getParallel());
        this.iyf.setPriority(3);
        this.iyf.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b iyi;
        private b iyj = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void dd(List<c> list) {
                a.this.dc(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.iyi = bVar;
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
                        e.this.b(list, this.iyj);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.iyj);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.iyj);
                }
                return 0;
            }
            return -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(final int i, final String str, final int i2) {
            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.iyi != null) {
                        a.this.iyi.onProgressUpdate(i, str, i2);
                        a.this.iyi.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dc(final List<c> list) {
            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.iyi != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.iyi.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.iyi.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.iyi != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.iyi.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.iyi != null) {
                this.iyi.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.iyi != null) {
                if (isCancelled()) {
                    this.iyi.onCanceled();
                } else {
                    this.iyi.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.iyi != null) {
                this.iyi.onCanceled();
            }
        }
    }

    public void aZ(String str, int i) {
        j.clM().bb(str, i);
    }

    public void ba(String str, int i) {
        com.baidu.tieba.im.memorycache.b.cnY().ba(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo bg = com.baidu.tieba.im.memorycache.b.cnY().bg(str, i);
        if (bg != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aZl().xm(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aZl().mC(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aZl().mD(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aZl().mD(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.aZl().xl(str);
            }
            bg.setIs_hidden(1);
            bg.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.cnY().bh(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.cnY().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.cnY().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d eV(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.iyg);
        return dVar;
    }
}
