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
/* loaded from: classes9.dex */
public class ac extends com.baidu.tbadk.editortools.emotiontool.a {
    private static ac iXD;
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iXE;
    private final CustomMessageListener iXF = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.faceshop.ac.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ac.this.register();
            new Thread(new Runnable() { // from class: com.baidu.tieba.faceshop.ac.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ac.this.czR();
                }
            }).start();
        }
    };

    private ac() {
        MessageManager.getInstance().registerListener(this.iXF);
    }

    public static ac czQ() {
        if (iXD == null) {
            synchronized (ac.class) {
                if (iXD == null) {
                    iXD = new ac();
                }
            }
        }
        return iXD;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 3;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0573a interfaceC0573a) {
        if (com.baidu.tbadk.core.util.o.checkSD()) {
            if (this.iXE == null || this.iXE.isEmpty()) {
                this.iXE = new LinkedList<>();
                z zVar = new z();
                this.iXE.add(zVar);
                if (interfaceC0573a != null) {
                    interfaceC0573a.a(zVar);
                    return;
                }
                return;
            }
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iXE.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                if (interfaceC0573a != null) {
                    interfaceC0573a.a(next);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            List<CollectEmotionData> JG = i.cyL().JG(TbadkCoreApplication.getCurrentAccount());
            if (JG == null || JG.size() == 0) {
                CollectEmotionData collectEmotionData = new CollectEmotionData();
                collectEmotionData.pid = "setting_icon";
                collectEmotionData.orderId = 301;
                collectEmotionData.sharpText = com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT;
                collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
                i.cyL().a(collectEmotionData);
                EmotionGroupData emotionGroupData = new EmotionGroupData();
                emotionGroupData.groupId = com.baidu.tbadk.imageManager.d.getCollectGroupId();
                emotionGroupData.groupName = "用户收藏表情";
                emotionGroupData.groupDesc = "用户收藏表情";
                emotionGroupData.emotionsCount = 301;
                emotionGroupData.status = 1;
                emotionGroupData.downloadUrl = "";
                i.cyL().a(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
                i.cyL().a(emotionGroupData);
                return;
            }
            int size = (JG == null || JG.size() == 0) ? 0 : JG.size() - 1;
            ar arVar = new ar("c12224");
            arVar.ap("obj_param1", size);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
        }
    }

    public synchronized void czR() {
        if (this.iXE != null) {
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iXE.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                if (next instanceof z) {
                    ((z) next).Mk();
                }
            }
        }
    }

    public boolean JR(String str) {
        if (this.iXE == null) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iXE.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next instanceof z) {
                return ((z) next).JR(str);
            }
        }
        return false;
    }
}
