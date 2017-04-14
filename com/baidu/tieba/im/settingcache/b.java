package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
class b extends s<Boolean> {
    private final /* synthetic */ String deO;
    final /* synthetic */ a deW;
    private final /* synthetic */ String deX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.deW = aVar;
        this.deO = str;
        this.deX = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        ChatSetting bg = this.deW.bg(this.deO, this.deX);
        if (bg == null) {
            return false;
        }
        return Boolean.valueOf(bg.isAcceptNotify());
    }
}
