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
/* loaded from: classes9.dex */
public class ac extends com.baidu.tbadk.editortools.emotiontool.a {
    private static ac iWp;
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iWq;
    private final CustomMessageListener iWr = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.faceshop.ac.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ac.this.register();
            new Thread(new Runnable() { // from class: com.baidu.tieba.faceshop.ac.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ac.this.cCr();
                }
            }).start();
        }
    };

    private ac() {
        MessageManager.getInstance().registerListener(this.iWr);
    }

    public static ac cCq() {
        if (iWp == null) {
            synchronized (ac.class) {
                if (iWp == null) {
                    iWp = new ac();
                }
            }
        }
        return iWp;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 3;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0593a interfaceC0593a) {
        if (com.baidu.tbadk.core.util.n.checkSD()) {
            if (this.iWq == null || this.iWq.isEmpty()) {
                this.iWq = new LinkedList<>();
                z zVar = new z();
                this.iWq.add(zVar);
                if (interfaceC0593a != null) {
                    interfaceC0593a.a(zVar);
                    return;
                }
                return;
            }
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iWq.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                if (interfaceC0593a != null) {
                    interfaceC0593a.a(next);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            List<CollectEmotionData> Kf = i.cBl().Kf(TbadkCoreApplication.getCurrentAccount());
            if (Kf == null || Kf.size() == 0) {
                CollectEmotionData collectEmotionData = new CollectEmotionData();
                collectEmotionData.pid = "setting_icon";
                collectEmotionData.orderId = 301;
                collectEmotionData.sharpText = com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT;
                collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
                i.cBl().a(collectEmotionData);
                EmotionGroupData emotionGroupData = new EmotionGroupData();
                emotionGroupData.groupId = com.baidu.tbadk.imageManager.d.getCollectGroupId();
                emotionGroupData.groupName = "用户收藏表情";
                emotionGroupData.groupDesc = "用户收藏表情";
                emotionGroupData.emotionsCount = 301;
                emotionGroupData.status = 1;
                emotionGroupData.downloadUrl = "";
                i.cBl().a(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
                i.cBl().a(emotionGroupData);
                return;
            }
            int size = (Kf == null || Kf.size() == 0) ? 0 : Kf.size() - 1;
            aq aqVar = new aq("c12224");
            aqVar.an("obj_param1", size);
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
        }
    }

    public synchronized void cCr() {
        if (this.iWq != null) {
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iWq.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                if (next instanceof z) {
                    ((z) next).OH();
                }
            }
        }
    }

    public boolean Kq(String str) {
        if (this.iWq == null) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iWq.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next instanceof z) {
                return ((z) next).Kq(str);
            }
        }
        return false;
    }
}
