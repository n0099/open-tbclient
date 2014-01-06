package com.baidu.tieba.data.emotions;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
/* loaded from: classes.dex */
public class a extends WritableEmotionGroup {
    private final String a;

    public a(AdsEmotionGroupData adsEmotionGroupData) {
        this.a = adsEmotionGroupData.getGroupId();
        c(1);
        b(4);
    }

    public boolean a(AdsEmotionGroupData adsEmotionGroupData, c cVar) {
        com.baidu.tieba.util.i iVar = new com.baidu.tieba.util.i(TiebaApplication.g());
        iVar.d(true);
        com.baidu.adp.widget.ImageView.d d = iVar.d(adsEmotionGroupData.getColorCoverUrl());
        if (d != null) {
            a(d);
        } else {
            iVar.a(adsEmotionGroupData.getColorCoverUrl(), new b(this, cVar));
        }
        if (b()) {
            cVar.a(this);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public com.baidu.adp.widget.ImageView.d a() {
        return super.g();
    }

    public boolean b() {
        return g() != null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public String a(int i) {
        return null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public boolean a(String str) {
        return false;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public WritableEmotionGroup.EmotionGroupType c() {
        return WritableEmotionGroup.EmotionGroupType.PROMOTION;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public com.baidu.adp.widget.ImageView.d b(String str) {
        return null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public com.baidu.adp.widget.ImageView.d c(String str) {
        return null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public int d() {
        return 0;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public String e() {
        return this.a;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public String f() {
        return null;
    }
}
