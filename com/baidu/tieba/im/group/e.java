package com.baidu.tieba.im.group;

import android.content.Context;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.b.a.a {
    final /* synthetic */ b aYH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b bVar, Context context, int i, int i2, int i3, int i4) {
        super(context, i, i2, i3, i4);
        this.aYH = bVar;
    }

    @Override // com.baidu.tbadk.b.a.a
    public void onClick() {
        Context context;
        context = this.aYH.mContext;
        AddGroupActivity.k((DiscoverMoreActivity) context);
    }
}
