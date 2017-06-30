package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b bRu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionTabContentView.b bVar) {
        this.bRu = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.j jVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.j jVar2;
        EmotionTabContentView emotionTabContentView3;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        jVar = emotionTabContentView.JT;
        if (jVar != null) {
            com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.aaa() != null) {
                w aaa = aVar.aaa();
                int ZZ = aVar.ZZ();
                com.baidu.tbadk.editortools.emotiontool.c aad = aaa.aad();
                String eD = aaa.aad().eD(ZZ + i);
                if (aad.CV() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.f.aDU.equals(eD)) {
                    emotionTabContentView3 = EmotionTabContentView.this;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(emotionTabContentView3.mContext)));
                    return;
                }
                lVar.setName(eD);
                lVar.a(aad.CV());
                lVar.ev(aad.getGroupName());
                lVar.ew(aad.getGroupId());
                lVar.setWidth(aad.getWidth());
                lVar.setHeight(aad.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                jVar2 = emotionTabContentView2.JT;
                jVar2.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
            }
        }
    }
}
