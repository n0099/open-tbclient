package com.baidu.tieba.faceshop;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import com.baidu.tieba.faceshop.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class x extends com.baidu.tbadk.editortools.emotiontool.a {
    private static x iVy;
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iVz;

    private x() {
    }

    public static x cCg() {
        if (iVy == null) {
            synchronized (x.class) {
                if (iVy == null) {
                    iVy = new x();
                }
            }
        }
        return iVy;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 2;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0593a interfaceC0593a) {
        if (com.baidu.tbadk.core.util.n.checkSD() && this.iVz != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iVz.size()) {
                    w wVar = (w) this.iVz.get(i2);
                    if (wVar.isReady() && com.baidu.tieba.newfaceshop.c.dkc().Ph(wVar.getGroupId()) == null && interfaceC0593a != null) {
                        interfaceC0593a.a(wVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION) { // from class: com.baidu.tieba.faceshop.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001444) {
                    Object data = customResponsedMessage.getData();
                    if (data == null || !(data instanceof SingleBarEmotionRecommendData)) {
                        x.this.dg(null);
                        return;
                    }
                    SingleBarEmotionRecommendData singleBarEmotionRecommendData = (SingleBarEmotionRecommendData) data;
                    LinkedList linkedList = new LinkedList();
                    if (singleBarEmotionRecommendData == null || TextUtils.isEmpty(singleBarEmotionRecommendData.pkg_id) || TextUtils.isEmpty(singleBarEmotionRecommendData.cover)) {
                        x.this.dg(null);
                        return;
                    }
                    linkedList.add(singleBarEmotionRecommendData);
                    x.this.dg(linkedList);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dg(List<com.baidu.tieba.face.data.b> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (this.iVz != null) {
                    this.iVz = null;
                }
                LinkedList<com.baidu.tbadk.editortools.emotiontool.c> linkedList = new LinkedList<>();
                boolean z = false;
                for (com.baidu.tieba.face.data.b bVar : list) {
                    if (bVar != null && !StringUtils.isNull(bVar.getGroupId()) && bVar.IsValid()) {
                        w wVar = new w(bVar);
                        linkedList.add(wVar);
                        z = wVar.a(bVar, new w.a() { // from class: com.baidu.tieba.faceshop.x.2
                            @Override // com.baidu.tieba.faceshop.w.a
                            public void a(w wVar2) {
                                MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
                            }
                        });
                    }
                }
                this.iVz = linkedList;
                if (z) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
                }
            }
        }
        if (this.iVz != null) {
            this.iVz = null;
            MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
        }
    }
}
