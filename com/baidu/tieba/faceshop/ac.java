package com.baidu.tieba.faceshop;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class ac extends com.baidu.tbadk.editortools.emotiontool.a {
    private static ac iZm;
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iZn;
    private final CustomMessageListener iZo = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.faceshop.ac.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ac.this.register();
            new Thread(new Runnable() { // from class: com.baidu.tieba.faceshop.ac.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ac.this.czX();
                }
            }).start();
        }
    };

    private ac() {
        MessageManager.getInstance().registerListener(this.iZo);
    }

    public static ac czW() {
        if (iZm == null) {
            synchronized (ac.class) {
                if (iZm == null) {
                    iZm = new ac();
                }
            }
        }
        return iZm;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 3;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0579a interfaceC0579a) {
        if (com.baidu.tbadk.core.util.o.checkSD()) {
            if (this.iZn == null || this.iZn.isEmpty()) {
                this.iZn = new LinkedList<>();
                z zVar = new z();
                this.iZn.add(zVar);
                if (interfaceC0579a != null) {
                    interfaceC0579a.a(zVar);
                    return;
                }
                return;
            }
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iZn.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                if (interfaceC0579a != null) {
                    interfaceC0579a.a(next);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            List<CollectEmotionData> JP = i.cyR().JP(TbadkCoreApplication.getCurrentAccount());
            if (JP == null || JP.size() == 0) {
                CollectEmotionData collectEmotionData = new CollectEmotionData();
                collectEmotionData.pid = "setting_icon";
                collectEmotionData.orderId = 301;
                collectEmotionData.sharpText = com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT;
                collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
                i.cyR().a(collectEmotionData);
                EmotionGroupData emotionGroupData = new EmotionGroupData();
                emotionGroupData.groupId = com.baidu.tbadk.imageManager.d.getCollectGroupId();
                emotionGroupData.groupName = "用户收藏表情";
                emotionGroupData.groupDesc = "用户收藏表情";
                emotionGroupData.emotionsCount = 301;
                emotionGroupData.status = 1;
                emotionGroupData.downloadUrl = "";
                i.cyR().a(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
                i.cyR().a(emotionGroupData);
                return;
            }
            int size = (JP == null || JP.size() == 0) ? 0 : JP.size() - 1;
            ar arVar = new ar("c12224");
            arVar.aq("obj_param1", size);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
        }
    }

    public synchronized void czX() {
        if (this.iZn != null) {
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iZn.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                if (next instanceof z) {
                    ((z) next).Mn();
                }
            }
        }
    }

    public boolean Ka(String str) {
        if (this.iZn == null) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iZn.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next instanceof z) {
                return ((z) next).Ka(str);
            }
        }
        return false;
    }
}
