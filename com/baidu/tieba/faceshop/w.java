package com.baidu.tieba.faceshop;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
/* loaded from: classes9.dex */
public class w extends com.baidu.tbadk.editortools.emotiontool.c {
    private final String groupId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(w wVar);
    }

    public w(com.baidu.tieba.face.data.b bVar) {
        this.groupId = bVar.getGroupId();
        qZ(1);
        qY(4);
    }

    public boolean a(com.baidu.tieba.face.data.b bVar, final a aVar) {
        if (bVar instanceof SingleBarEmotionRecommendData) {
            com.baidu.adp.lib.e.d.mw().a(((SingleBarEmotionRecommendData) bVar).cover, 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.faceshop.w.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar2, str, i);
                    if (aVar2 != null) {
                        w.this.c(aVar2);
                        w.this.d(aVar2);
                        if (w.this.isReady()) {
                            aVar.a(w.this);
                        }
                    }
                }
            }, null);
            if (isReady()) {
                aVar.a(this);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a bBD() {
        return super.bBC();
    }

    public boolean isReady() {
        return bBC() != null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String qX(int i) {
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean CN(String str) {
        return false;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public EmotionGroupType bBB() {
        return EmotionGroupType.SINGLE_FORUM;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a CO(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a CP(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getEmotionsCount() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String getGroupId() {
        return this.groupId;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String getGroupName() {
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean bBA() {
        return false;
    }
}
