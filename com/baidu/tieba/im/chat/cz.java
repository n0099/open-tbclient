package com.baidu.tieba.im.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class cz implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ PersonalChatActivity aPI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(PersonalChatActivity personalChatActivity) {
        this.aPI = personalChatActivity;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.w.stranger_tips, (ViewGroup) null);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dy() {
        return 3;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dz() {
        return 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
