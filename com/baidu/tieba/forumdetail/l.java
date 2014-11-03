package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ ItemInfoView axT;
    private final /* synthetic */ boolean axU;
    private final /* synthetic */ String axV;
    private final /* synthetic */ String axW;
    private final /* synthetic */ String axX;
    private final /* synthetic */ String axY;
    private final /* synthetic */ BaseActivity axt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ItemInfoView itemInfoView, boolean z, String str, String str2, String str3, String str4, BaseActivity baseActivity) {
        this.axT = itemInfoView;
        this.axU = z;
        this.axV = str;
        this.axW = str2;
        this.axX = str3;
        this.axY = str4;
        this.axt = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (!this.axU) {
            context = this.axT.mContext;
            ForumListActivity.a(context, this.axV, this.axX, this.axW, this.axY);
            return;
        }
        ForumListActivity.avT = !ForumListActivity.avT;
        ForumListActivity.c(this.axV, this.axW, this.axX, this.axY);
        this.axt.finish();
    }
}
