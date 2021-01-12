package com.baidu.tieba.faceshop;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.img.GetEmotionInfosModel;
import com.baidu.tieba.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class ab {
    private static ab iRu;
    private GetEmotionInfosModel iRv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes8.dex */
    public interface c {
        void S(int i, int i2, int i3);
    }

    public static ab cyv() {
        if (iRu == null) {
            iRu = new ab();
        }
        return iRu;
    }

    public void eU(String str, String str2) {
        if (com.baidu.tieba.newfaceshop.d.dgo().dgs()) {
            com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), R.string.face_collect_is_syncing);
            return;
        }
        com.baidu.tbadk.img.c cVar = new com.baidu.tbadk.img.c();
        cVar.picUrl = str;
        cVar.pkgId = str2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        a((List<com.baidu.tbadk.img.c>) arrayList, true, (c) null);
    }

    public void a(List<String> list, c cVar) {
        if (com.baidu.tbadk.core.util.x.isEmpty(list) && cVar != null) {
            cVar.S(4, 0, 0);
        }
        if (com.baidu.tieba.newfaceshop.d.dgo().dgs()) {
            com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), R.string.face_collect_is_syncing);
            cVar.S(4, 0, 0);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            com.baidu.tbadk.img.c cVar2 = new com.baidu.tbadk.img.c();
            cVar2.picUrl = str;
            arrayList.add(cVar2);
        }
        a((List<com.baidu.tbadk.img.c>) arrayList, true, cVar);
    }

    public void a(final List<com.baidu.tbadk.img.c> list, final boolean z, final c cVar) {
        new BdAsyncTask<Void, Void, Integer>() { // from class: com.baidu.tieba.faceshop.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Integer doInBackground(Void... voidArr) {
                return Integer.valueOf(i.cxt().IV(TbadkApplication.getCurrentAccount()) - 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Integer num) {
                if (num.intValue() >= 300) {
                    if (cVar != null) {
                        cVar.S(4, 0, 0);
                        return;
                    } else {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.save_emotion_limit);
                        return;
                    }
                }
                while (list.size() + num.intValue() > 300) {
                    list.remove(list.size() - 1);
                }
                ab.this.b(list, z, cVar);
            }
        }.execute(new Void[0]);
    }

    public void b(List<com.baidu.tbadk.img.c> list, final boolean z, final c cVar) {
        if (list == null || list.isEmpty()) {
            if (cVar == null) {
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
            } else {
                cVar.S(4, 0, 0);
            }
        } else if (!TbadkCoreApplication.isLogin()) {
            if (cVar == null) {
                bg.skipToLoginActivity(TbadkCoreApplication.getInst());
            } else {
                cVar.S(4, 0, 0);
            }
        } else {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            final HashMap hashMap = new HashMap();
            for (com.baidu.tbadk.img.c cVar2 : list) {
                if (cVar2.picId == null || TextUtils.isEmpty(cVar2.picId)) {
                    arrayList2.add(cVar2.picUrl);
                    if (cVar2.pkgId != null) {
                        hashMap.put(cVar2.picUrl, cVar2.pkgId);
                    }
                } else if (!ac.cyy().Jf(cVar2.picId)) {
                    arrayList.add(cVar2);
                }
            }
            if (arrayList2.size() > 0) {
                if (this.iRv == null) {
                    this.iRv = new GetEmotionInfosModel();
                }
                this.iRv.a(arrayList2, new GetEmotionInfosModel.a() { // from class: com.baidu.tieba.faceshop.ab.2
                    @Override // com.baidu.tbadk.img.GetEmotionInfosModel.a
                    public void ai(List<com.baidu.tbadk.img.c> list2) {
                        if (list2 == null || list2.isEmpty()) {
                            if (cVar == null) {
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                            } else {
                                cVar.S(4, 0, 0);
                            }
                        }
                        for (com.baidu.tbadk.img.c cVar3 : list2) {
                            if (!ac.cyy().Jf(cVar3.picId)) {
                                cVar3.pkgId = (String) hashMap.get(cVar3.eEs);
                                arrayList.add(cVar3);
                            }
                        }
                        ab.this.a(arrayList, cVar, z);
                    }

                    @Override // com.baidu.tbadk.img.GetEmotionInfosModel.a
                    public void onFail(int i, String str) {
                        if (cVar == null) {
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                        } else {
                            cVar.S(4, 0, 0);
                        }
                    }
                });
                return;
            }
            a(arrayList, cVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.baidu.tbadk.img.c> list, final c cVar, final boolean z) {
        if (list.size() == 0) {
            if (cVar == null) {
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.add_success);
                return;
            } else {
                cVar.S(4, 1, 0);
                return;
            }
        }
        final AtomicInteger atomicInteger = new AtomicInteger(list.size());
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (final com.baidu.tbadk.img.c cVar2 : list) {
            new b(new a() { // from class: com.baidu.tieba.faceshop.ab.3
                @Override // com.baidu.tieba.faceshop.ab.a
                public void onSuccess() {
                    copyOnWriteArrayList.add(ab.this.b(cVar2));
                    if (atomicInteger.decrementAndGet() == 0) {
                        ab.this.b(copyOnWriteArrayList, cVar, z);
                    }
                }

                @Override // com.baidu.tieba.faceshop.ab.a
                public void onFail() {
                    if (atomicInteger.decrementAndGet() == 0) {
                        ab.this.b(copyOnWriteArrayList, cVar, z);
                    }
                }
            }).execute(cVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final List<CollectEmotionData> list, final c cVar, final boolean z) {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.faceshop.ab.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                return Boolean.valueOf(i.cxt().de(list));
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    if (cVar == null) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.add_success);
                    } else {
                        cVar.S(4, 1, 0);
                    }
                    ac.cyy().cyz();
                    if (z) {
                        new UserCollectModel().upload();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE));
                    TiebaStatic.log("c12222");
                } else if (cVar == null) {
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                } else {
                    cVar.S(4, 0, 0);
                }
            }
        }.execute(new Void[0]);
    }

    public void c(final List<CollectEmotionData> list, final boolean z, final c cVar) {
        if (list == null || list.size() <= 0) {
            if (cVar != null) {
                cVar.S(2, 0, 0);
                return;
            }
            return;
        }
        new BdAsyncTask<Void, Void, List<Integer>>() { // from class: com.baidu.tieba.faceshop.ab.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: c */
            public List<Integer> doInBackground(Void[] voidArr) {
                List<CollectEmotionData> IU = i.cxt().IU(TbadkCoreApplication.getCurrentAccount());
                HashMap hashMap = new HashMap();
                for (CollectEmotionData collectEmotionData : IU) {
                    hashMap.put(collectEmotionData.getSharpText(), collectEmotionData);
                }
                int size = IU.size() - 2;
                for (int i = 0; i < list.size(); i++) {
                    CollectEmotionData collectEmotionData2 = (CollectEmotionData) list.get(i);
                    collectEmotionData2.orderId = size;
                    String sharpText = collectEmotionData2.getSharpText();
                    if (hashMap.containsKey(sharpText)) {
                        IU.remove(hashMap.get(sharpText));
                        hashMap.remove(sharpText);
                    }
                    i.cxt().c(collectEmotionData2);
                    size--;
                }
                for (int i2 = 0; i2 < IU.size(); i2++) {
                    CollectEmotionData collectEmotionData3 = IU.get(i2);
                    if (!com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(collectEmotionData3.sharpText)) {
                        collectEmotionData3.orderId = size;
                        i.cxt().c(collectEmotionData3);
                        size--;
                    }
                }
                if (list.size() > 0) {
                    ac.cyy().cyz();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(list.size()));
                arrayList.add(0);
                return arrayList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: B */
            public void onPostExecute(List<Integer> list2) {
                if (cVar != null && list2 != null && list2.size() == 2) {
                    cVar.S(2, list2.get(0).intValue(), list2.get(1).intValue());
                    if (list2.get(0).intValue() > 0) {
                        if (z) {
                            new UserCollectModel().upload();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE));
                        aq aqVar = new aq("c12227");
                        aqVar.an("obj_param1", list2.get(0).intValue());
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        }.execute(new Void[0]);
    }

    public void d(final List<CollectEmotionData> list, final boolean z, final c cVar) {
        if (list == null || list.size() <= 0) {
            if (cVar != null) {
                cVar.S(1, 1, 0);
                return;
            }
            return;
        }
        new BdAsyncTask<Void, Void, List<Integer>>() { // from class: com.baidu.tieba.faceshop.ab.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: c */
            public List<Integer> doInBackground(Void[] voidArr) {
                int i = 0;
                for (CollectEmotionData collectEmotionData : list) {
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(collectEmotionData.sharpText)) {
                        i.cxt().b(collectEmotionData);
                        if (collectEmotionData.imageFileInfo != null && !TextUtils.isEmpty(collectEmotionData.imageFileInfo.getFilePath())) {
                            File file = new File(collectEmotionData.imageFileInfo.getFilePath());
                            if (file.exists()) {
                                file.delete();
                            }
                            String filePath = collectEmotionData.imageFileInfo.getFilePath();
                            File file2 = new File(filePath.replace("_s.jpg", "_b.jpg"));
                            if (file2.exists()) {
                                file2.delete();
                            }
                            File file3 = new File(filePath.replace("_s.jpg", "_b.gif"));
                            if (file3.exists()) {
                                file3.delete();
                            }
                        }
                        i++;
                    }
                }
                List<CollectEmotionData> IU = i.cxt().IU(TbadkCoreApplication.getCurrentAccount());
                for (int i2 = 0; i2 < IU.size(); i2++) {
                    CollectEmotionData collectEmotionData2 = IU.get(i2);
                    if (!com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(collectEmotionData2.getSharpText())) {
                        collectEmotionData2.orderId = (IU.size() - i2) - 1;
                        i.cxt().c(collectEmotionData2);
                    }
                }
                if (i > 0) {
                    ac.cyy().cyz();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i));
                arrayList.add(Integer.valueOf(list.size() - i));
                return arrayList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: B */
            public void onPostExecute(List<Integer> list2) {
                if (cVar != null && list2 != null && list2.size() == 2) {
                    cVar.S(1, list2.get(0).intValue(), list2.get(1).intValue());
                    if (list2.get(0).intValue() > 0) {
                        if (z) {
                            new UserCollectModel().upload();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE));
                        aq aqVar = new aq("c12226");
                        aqVar.an("obj_param1", list2.get(0).intValue());
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        }.execute(new Void[0]);
    }

    public void b(final List<CollectEmotionData> list, final c cVar) {
        if (list != null && list.size() > 0) {
            new BdAsyncTask<Void, Void, List<Integer>>() { // from class: com.baidu.tieba.faceshop.ab.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: c */
                public List<Integer> doInBackground(Void[] voidArr) {
                    int i = 0;
                    Iterator it = list.iterator();
                    while (true) {
                        int i2 = i;
                        if (it.hasNext()) {
                            CollectEmotionData collectEmotionData = (CollectEmotionData) it.next();
                            String filePath = collectEmotionData.imageFileInfo.getFilePath();
                            File file = new File(filePath.replace("_s.jpg", "_b.jpg"));
                            byte[] bArr = null;
                            if (file.exists()) {
                                bArr = ab.this.ab(file);
                            }
                            if (bArr == null) {
                                bArr = ab.this.ab(new File(filePath.replace("_s.jpg", "_b.gif")));
                            }
                            if (bArr != null && com.baidu.tbadk.core.util.n.saveImageFileByUser(collectEmotionData.picUrl, bArr, TbadkCoreApplication.getInst().getContext()) == 0) {
                                i2++;
                            }
                            i = i2;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(Integer.valueOf(i2));
                            arrayList.add(Integer.valueOf(list.size() - i2));
                            return arrayList;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: B */
                public void onPostExecute(List<Integer> list2) {
                    if (cVar != null && list2 != null && list2.size() == 2) {
                        cVar.S(3, list2.get(0).intValue(), list2.get(1).intValue());
                        if (list2.get(0).intValue() > 0) {
                            aq aqVar = new aq("c12228");
                            aqVar.an("obj_param1", list2.get(0).intValue());
                            TiebaStatic.log(aqVar);
                        }
                    }
                }
            }.execute(new Void[0]);
        }
    }

    public byte[] ab(File file) {
        FileInputStream fileInputStream;
        byte[] bArr = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr2, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                        bArr = byteArrayOutputStream.toByteArray();
                        com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                    } catch (IOException e) {
                        e = e;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                        return bArr;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                throw th;
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(com.baidu.tbadk.img.c cVar, boolean z) {
        if (cVar == null || TextUtils.isEmpty(cVar.picUrl) || TextUtils.isEmpty(cVar.picId)) {
            return "";
        }
        return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + com.baidu.tbadk.imageManager.d.getSaveDir() + "/" + cVar.picId + (z ? "_b.jpg" : "_s.jpg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<com.baidu.tbadk.img.c, Void, Boolean> {
        private com.baidu.tbadk.img.c iRE;
        private a iRF;

        b(a aVar) {
            this.iRF = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(com.baidu.tbadk.img.c[] cVarArr) {
            if (cVarArr == null || cVarArr.length <= 0) {
                return false;
            }
            this.iRE = cVarArr[0];
            com.baidu.tbadk.core.util.b.i iVar = new com.baidu.tbadk.core.util.b.i();
            byte[] ax = iVar.ax(this.iRE.picUrl, false);
            if (ax != null && iVar.bsO()) {
                String a2 = ab.this.a(this.iRE, true);
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                if (com.baidu.adp.lib.util.l.isGif(ax)) {
                    a2 = a2.replace("_b.jpg", "_b.gif");
                }
                File file = new File(a2);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!ab.this.c(file, ax)) {
                    return false;
                }
                byte[] ax2 = iVar.ax(this.iRE.thumbnail, false);
                if (ax2 != null && iVar.bsO()) {
                    String a3 = ab.this.a(this.iRE, false);
                    if (TextUtils.isEmpty(a3)) {
                        return false;
                    }
                    if (!ab.this.c(new File(a3), ax2)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                if (this.iRF != null) {
                    this.iRF.onSuccess();
                }
            } else if (this.iRF != null) {
                this.iRF.onFail();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [591=5, 592=5, 594=5, 595=5] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.exists() && !file.delete()) {
                    if (0 != 0) {
                        try {
                            fileOutputStream2.close();
                            return false;
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            return false;
                        }
                    }
                    return false;
                } else if (!file.createNewFile()) {
                    if (0 != 0) {
                        try {
                            fileOutputStream2.close();
                            return false;
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                            return false;
                        }
                    }
                    return false;
                } else {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                    try {
                        fileOutputStream3.write(bArr, 0, bArr.length);
                        fileOutputStream3.flush();
                        fileOutputStream3.close();
                        FileOutputStream fileOutputStream4 = null;
                        if (0 != 0) {
                            try {
                                fileOutputStream4.close();
                            } catch (Throwable th3) {
                                BdLog.e(th3.getMessage());
                                return false;
                            }
                        }
                        return true;
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream3;
                        BdLog.e(e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return false;
                            } catch (Throwable th4) {
                                BdLog.e(th4.getMessage());
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th6) {
                                BdLog.e(th6.getMessage());
                                return false;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static String aO(String str, boolean z) {
        String str2 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + com.baidu.tbadk.imageManager.d.getSaveDir() + "/" + str + "_s.jpg";
        if (z) {
            String replace = str2.replace("_s.jpg", "_b.jpg");
            if (new File(replace).exists()) {
                return replace;
            }
            String replace2 = str2.replace("_s.jpg", "_b.gif");
            return !new File(replace2).exists() ? "" : replace2;
        }
        return str2;
    }

    public void cyw() {
        new BdAsyncTask<Void, Void, List<CollectEmotionData>>() { // from class: com.baidu.tieba.faceshop.ab.8
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: c */
            public List<CollectEmotionData> doInBackground(Void... voidArr) {
                return ab.this.cyx();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: B */
            public void onPostExecute(List<CollectEmotionData> list) {
                if (list != null) {
                    for (CollectEmotionData collectEmotionData : list) {
                        if (collectEmotionData != null) {
                            com.baidu.tbadk.img.c cVar = new com.baidu.tbadk.img.c();
                            cVar.picId = collectEmotionData.pid;
                            cVar.pkgId = collectEmotionData.pkgId;
                            cVar.picUrl = collectEmotionData.picUrl;
                            cVar.thumbnail = collectEmotionData.thumbnail;
                            cVar.width = collectEmotionData.width;
                            cVar.height = collectEmotionData.height;
                            new b(null).execute(cVar);
                        }
                    }
                }
            }
        }.execute(new Void[0]);
    }

    public boolean qa(boolean z) {
        List<CollectEmotionData> cyx = cyx();
        if (cyx == null || cyx.isEmpty()) {
            return true;
        }
        if (z) {
            d(cyx, false, new c() { // from class: com.baidu.tieba.faceshop.ab.9
                @Override // com.baidu.tieba.faceshop.ab.c
                public void S(int i, int i2, int i3) {
                }
            });
            return false;
        }
        return false;
    }

    public List<CollectEmotionData> cyx() {
        ArrayList arrayList = new ArrayList();
        List<CollectEmotionData> IU = i.cxt().IU(TbadkCoreApplication.getCurrentAccount());
        if (IU != null) {
            for (CollectEmotionData collectEmotionData : IU) {
                if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !new File(aO(collectEmotionData.pid, false)).exists()) {
                    arrayList.add(collectEmotionData);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CollectEmotionData b(com.baidu.tbadk.img.c cVar) {
        CollectEmotionData collectEmotionData = new CollectEmotionData();
        StringBuilder sb = new StringBuilder(com.baidu.tbadk.imageManager.d.SHARP_TEXT_PREFIX_SHORT);
        if (TextUtils.isEmpty(cVar.pkgId)) {
            sb.append(cVar.picId).append(",");
        } else {
            sb.append(cVar.pkgId).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(cVar.picId).append(",");
        }
        sb.append(cVar.width).append(",");
        sb.append(cVar.height).append(",");
        String lowerCase = com.baidu.adp.lib.util.s.toMd5(sb.toString().replace("collect_", "") + "7S6wbXjEKL9N").toLowerCase();
        collectEmotionData.pid = cVar.picId;
        collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
        collectEmotionData.sharpText = "#(" + sb.toString() + lowerCase + ")";
        collectEmotionData.orderId = i.cxt().IV(collectEmotionData.uid) + 1;
        collectEmotionData.width = cVar.width;
        collectEmotionData.height = cVar.height;
        collectEmotionData.picUrl = cVar.picUrl;
        collectEmotionData.thumbnail = cVar.thumbnail;
        collectEmotionData.backup = "";
        return collectEmotionData;
    }
}
