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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e iXb;
    private a iXc;
    private final DialogInterface.OnCancelListener iXd = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.im.db.e.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.cti();
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void dy(List<c> list);

        void h(int i, String str, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {
        int customGroupType;
        String id;
        int progress;
    }

    public static e cth() {
        if (iXb == null) {
            synchronized (e.class) {
                if (iXb == null) {
                    iXb = new e();
                }
            }
        }
        return iXb;
    }

    public void a(String str, int i, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (1 == i) {
                HG(str);
            } else if (-7 == i) {
                a(bVar);
            } else if (-8 == i) {
                b(bVar);
            } else if (2 == i) {
                HE(str);
            } else if (4 == i) {
                HF(str);
            } else if (-3 == i) {
                aW(str, i);
            } else if (-4 == i) {
                aW(str, i);
            } else {
                aW(str, i);
            }
        }
    }

    public void HE(String str) {
        try {
            try {
                h.ctm().ctn();
                aX(str, 2);
                m.ctz().Hw(str);
                h.ctm().cto();
            } catch (Exception e) {
                e.printStackTrace();
                h.ctm().cto();
            }
        } catch (Throwable th) {
            h.ctm().cto();
            throw th;
        }
    }

    public void HF(String str) {
        try {
            try {
                h.ctm().ctn();
                aX(str, 4);
                l.ctw().Hw(str);
                h.ctm().cto();
            } catch (Exception e) {
                e.printStackTrace();
                h.ctm().cto();
            }
        } catch (Throwable th) {
            h.ctm().cto();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public void a(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        int i2;
        try {
            h.ctm().ctn();
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
                if (ctj()) {
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
            h.ctm().cto();
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, b bVar) {
        int i;
        try {
            h.ctm().ctn();
            if (!x.isEmpty(list)) {
                int size = list.size();
                int i2 = 0;
                int i3 = size - 1;
                while (i3 >= 0) {
                    if (ctj()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) x.getItem(list, i3);
                    if (imMessageCenterShowItemData == null) {
                        i = i2;
                    } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        i = i2;
                    } else {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        aX(friendId, 4);
                        l.ctw().Hw(friendId);
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
            h.ctm().cto();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=5] */
    public void a(b bVar) {
        int i;
        int i2;
        try {
            h.ctm().ctn();
            List<String> ctD = n.ctD();
            if (x.isEmpty(ctD)) {
                return;
            }
            int size = ctD.size();
            int i3 = size / 100;
            if (size % 100 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (ctj()) {
                    return;
                }
                if (i4 == i3 - 1) {
                    i = 100 * i4;
                    i2 = size;
                } else {
                    i = 100 * i4;
                    i2 = i + 100;
                }
                a(x.subList(ctD, i, i2), bVar, ((i4 + 1) * 100) / i3);
            }
            if (ctj()) {
                return;
            }
            aX(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.ctm().cto();
        }
    }

    private void a(List<String> list, b bVar, int i) {
        if (list != null && bVar != null) {
            n.HK(dw(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                m.ctz().Hx(str);
                if (ctj()) {
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
                bVar.dy(arrayList);
            }
        }
    }

    private String dw(List<String> list) {
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
            h.ctm().ctn();
            l.ctw();
            List<String> ctx = l.ctx();
            if (x.isEmpty(ctx)) {
                return;
            }
            int size = ctx.size();
            int i = 0;
            for (String str : ctx) {
                if (ctj()) {
                    break;
                }
                aX(str, 4);
                l.ctw().Hw(str);
                i++;
                if (bVar != null) {
                    bVar.h((i * 100) / size, str, 4);
                }
            }
            if (ctj()) {
                return;
            }
            aX(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.ctm().cto();
        }
    }

    public void aW(String str, int i) {
        try {
            try {
                h.ctm().ctn();
                ImMessageCenterPojo be = com.baidu.tieba.im.memorycache.b.cvV().be(str, i);
                be.setIs_hidden(1);
                be.setUnread_count(0);
                j.ctq().a(be, 2);
                h.ctm().cto();
            } catch (Exception e) {
                e.printStackTrace();
                h.ctm().cto();
            }
        } catch (Throwable th) {
            h.ctm().cto();
            throw th;
        }
    }

    public void HG(String str) {
        try {
            h.ctm().ctn();
            ImMessageCenterPojo be = com.baidu.tieba.im.memorycache.b.cvV().be(str, 1);
            be.setIs_hidden(1);
            be.setUnread_count(0);
            j.ctq().a(be, 2);
            com.baidu.tieba.im.db.c.ctf().Hx(str);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            h.ctm().cto();
        }
    }

    public boolean cti() {
        if (this.iXc != null && this.iXc.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.iXc.cancel(true);
        }
        this.iXc = null;
        return true;
    }

    public boolean ctj() {
        return this.iXc == null || (this.iXc != null && this.iXc.isCancelled());
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.iXc = new a(i, bVar);
        this.iXc.setParallel(TiebaIMConfig.getParallel());
        this.iXc.setPriority(3);
        this.iXc.execute(imMessageCenterShowItemData);
    }

    public void a(List<ImMessageCenterShowItemData> list, int i, com.baidu.tieba.im.chat.a.b bVar) {
        this.iXc = new a(i, bVar);
        this.iXc.setParallel(TiebaIMConfig.getParallel());
        this.iXc.setPriority(3);
        this.iXc.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, c, Integer> {
        private final com.baidu.tieba.im.chat.a.b iXf;
        private b iXg = new b() { // from class: com.baidu.tieba.im.db.e.a.1
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
            public void dy(List<c> list) {
                a.this.dx(list);
            }
        };
        private final int mCustomGroupType;

        public a(int i, com.baidu.tieba.im.chat.a.b bVar) {
            this.mCustomGroupType = i;
            this.iXf = bVar;
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
                        e.this.b(list, this.iXg);
                    } else if (this.mCustomGroupType == 2) {
                        e.this.a(list, this.iXg);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.a(((ImMessageCenterShowItemData) obj).getFriendId(), this.mCustomGroupType, this.iXg);
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
                    if (a.this.iXf != null) {
                        a.this.iXf.onProgressUpdate(i, str, i2);
                        a.this.iXf.onCanceled();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dx(final List<c> list) {
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.im.db.e.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (list != null && a.this.iXf != null) {
                        for (c cVar : list) {
                            if (cVar != null) {
                                a.this.iXf.onProgressUpdate(cVar.progress, cVar.id, cVar.customGroupType);
                            }
                        }
                        a.this.iXf.onCanceled();
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
            if (cVarArr != null && cVarArr.length > 0 && cVarArr[0] != null && this.iXf != null) {
                c cVar = cVarArr[0];
                String str = cVar.id;
                int i = cVar.customGroupType;
                this.iXf.onProgressUpdate(cVar.progress, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.iXf != null) {
                this.iXf.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (this.iXf != null) {
                if (isCancelled()) {
                    this.iXf.onCanceled();
                } else {
                    this.iXf.onPostExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.iXf != null) {
                this.iXf.onCanceled();
            }
        }
    }

    public void aX(String str, int i) {
        j.ctq().aZ(str, i);
    }

    public void aY(String str, int i) {
        com.baidu.tieba.im.memorycache.b.cvV().aY(str, i);
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        ImMessageCenterPojo be = com.baidu.tieba.im.memorycache.b.cvV().be(str, i);
        if (be != null) {
            if (i == 2) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bfl().yK(str);
            } else if (i == 4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bfl().nq(com.baidu.adp.lib.f.b.toInt(str, 0));
            } else if (i == -3) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bfl().nr(2);
            } else if (i == -4) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bfl().nr(1);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.b.bfl().yJ(str);
            }
            be.setIs_hidden(1);
            be.setUnread_count(0);
            if (i == 2 || i == 4 || i == -7 || i == -8) {
                com.baidu.tieba.im.memorycache.b.cvV().bf(str, i);
            } else if (i == 1) {
                com.baidu.tieba.im.memorycache.b.cvV().e(str, i, false);
            } else {
                com.baidu.tieba.im.memorycache.b.cvV().e(str, i, false);
            }
        }
    }

    public com.baidu.tbadk.core.dialog.d eZ(Context context) {
        com.baidu.tbadk.core.dialog.d dVar = new com.baidu.tbadk.core.dialog.d(context);
        dVar.setMessage(context.getString(R.string.delete_msg_loading));
        dVar.setCanceledOnTouchOutside(false);
        dVar.setCancelable(true);
        dVar.setOnCancelListener(this.iXd);
        return dVar;
    }
}
