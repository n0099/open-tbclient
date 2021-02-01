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
    private static x iWy;
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iWz;

    private x() {
    }

    public static x czz() {
        if (iWy == null) {
            synchronized (x.class) {
                if (iWy == null) {
                    iWy = new x();
                }
            }
        }
        return iWy;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 2;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0573a interfaceC0573a) {
        if (com.baidu.tbadk.core.util.o.checkSD() && this.iWz != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iWz.size()) {
                    w wVar = (w) this.iWz.get(i2);
                    if (wVar.isReady() && com.baidu.tieba.newfaceshop.c.dil().OP(wVar.getGroupId()) == null && interfaceC0573a != null) {
                        interfaceC0573a.a(wVar);
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
                        x.this.db(null);
                        return;
                    }
                    SingleBarEmotionRecommendData singleBarEmotionRecommendData = (SingleBarEmotionRecommendData) data;
                    LinkedList linkedList = new LinkedList();
                    if (singleBarEmotionRecommendData == null || TextUtils.isEmpty(singleBarEmotionRecommendData.pkg_id) || TextUtils.isEmpty(singleBarEmotionRecommendData.cover)) {
                        x.this.db(null);
                        return;
                    }
                    linkedList.add(singleBarEmotionRecommendData);
                    x.this.db(linkedList);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void db(List<com.baidu.tieba.face.data.b> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (this.iWz != null) {
                    this.iWz = null;
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
                this.iWz = linkedList;
                if (z) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
                }
            }
        }
        if (this.iWz != null) {
            this.iWz = null;
            MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
        }
    }
}
