package com.baidu.tieba.faceshop;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class ac extends com.baidu.tbadk.editortools.emotiontool.a {
    private static ac iRI;
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iRJ;
    private final CustomMessageListener iRK = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.faceshop.ac.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ac.this.register();
            new Thread(new Runnable() { // from class: com.baidu.tieba.faceshop.ac.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ac.this.cyz();
                }
            }).start();
        }
    };

    private ac() {
        MessageManager.getInstance().registerListener(this.iRK);
    }

    public static ac cyy() {
        if (iRI == null) {
            synchronized (ac.class) {
                if (iRI == null) {
                    iRI = new ac();
                }
            }
        }
        return iRI;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 3;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0576a interfaceC0576a) {
        if (com.baidu.tbadk.core.util.n.checkSD()) {
            if (this.iRJ == null || this.iRJ.isEmpty()) {
                this.iRJ = new LinkedList<>();
                z zVar = new z();
                this.iRJ.add(zVar);
                if (interfaceC0576a != null) {
                    interfaceC0576a.a(zVar);
                    return;
                }
                return;
            }
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iRJ.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                if (interfaceC0576a != null) {
                    interfaceC0576a.a(next);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            List<CollectEmotionData> IU = i.cxt().IU(TbadkCoreApplication.getCurrentAccount());
            if (IU == null || IU.size() == 0) {
                CollectEmotionData collectEmotionData = new CollectEmotionData();
                collectEmotionData.pid = "setting_icon";
                collectEmotionData.orderId = 301;
                collectEmotionData.sharpText = com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT;
                collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
                i.cxt().a(collectEmotionData);
                EmotionGroupData emotionGroupData = new EmotionGroupData();
                emotionGroupData.groupId = com.baidu.tbadk.imageManager.d.getCollectGroupId();
                emotionGroupData.groupName = "用户收藏表情";
                emotionGroupData.groupDesc = "用户收藏表情";
                emotionGroupData.emotionsCount = 301;
                emotionGroupData.status = 1;
                emotionGroupData.downloadUrl = "";
                i.cxt().a(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
                i.cxt().a(emotionGroupData);
                return;
            }
            int size = (IU == null || IU.size() == 0) ? 0 : IU.size() - 1;
            aq aqVar = new aq("c12224");
            aqVar.an("obj_param1", size);
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
        }
    }

    public synchronized void cyz() {
        if (this.iRJ != null) {
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iRJ.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                if (next instanceof z) {
                    ((z) next).KM();
                }
            }
        }
    }

    public boolean Jf(String str) {
        if (this.iRJ == null) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iRJ.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next instanceof z) {
                return ((z) next).Jf(str);
            }
        }
        return false;
    }
}
