package com.baidu.tieba.data.emotions;

import com.baidu.tieba.data.emotions.WritableEmotionGroup;
/* loaded from: classes.dex */
public final class a extends WritableEmotionGroup {
    private final String a;

    public a(AdsEmotionGroupData adsEmotionGroupData) {
        this.a = adsEmotionGroupData.getGroupId();
        c(1);
        b(4);
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final com.baidu.adp.widget.ImageView.b a() {
        return super.i();
    }

    public final boolean b() {
        return i() != null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final String a(int i) {
        return null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final boolean a(String str) {
        return false;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final WritableEmotionGroup.EmotionGroupType c() {
        return WritableEmotionGroup.EmotionGroupType.PROMOTION;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final com.baidu.adp.widget.ImageView.b b(String str) {
        return null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final com.baidu.adp.widget.ImageView.b c(String str) {
        return null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final int d() {
        return 0;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final String e() {
        return this.a;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final String f() {
        return null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final int g() {
        return 0;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final int h() {
        return 0;
    }
}
