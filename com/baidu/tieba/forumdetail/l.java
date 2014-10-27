package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ ItemInfoView axK;
    private final /* synthetic */ boolean axL;
    private final /* synthetic */ String axM;
    private final /* synthetic */ String axN;
    private final /* synthetic */ String axO;
    private final /* synthetic */ String axP;
    private final /* synthetic */ BaseActivity axk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ItemInfoView itemInfoView, boolean z, String str, String str2, String str3, String str4, BaseActivity baseActivity) {
        this.axK = itemInfoView;
        this.axL = z;
        this.axM = str;
        this.axN = str2;
        this.axO = str3;
        this.axP = str4;
        this.axk = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (!this.axL) {
            context = this.axK.mContext;
            ForumListActivity.a(context, this.axM, this.axO, this.axN, this.axP);
            return;
        }
        ForumListActivity.avK = !ForumListActivity.avK;
        ForumListActivity.c(this.axM, this.axN, this.axO, this.axP);
        this.axk.finish();
    }
}
