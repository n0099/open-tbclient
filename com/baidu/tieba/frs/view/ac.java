package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ U9InfoView aGM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(U9InfoView u9InfoView) {
        this.aGM = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        com.baidu.tbadk.core.data.u uVar;
        Context context;
        com.baidu.tbadk.core.data.u uVar2;
        com.baidu.tbadk.core.data.r rVar;
        Context context2;
        com.baidu.tbadk.core.data.r rVar2;
        if (com.baidu.adp.lib.util.m.isNetOk()) {
            relativeLayout = this.aGM.aGA;
            if (view != relativeLayout) {
                linearLayout = this.aGM.aGB;
                if (view == linearLayout) {
                    uVar = this.aGM.news_info;
                    if (!TextUtils.isEmpty(uVar.kR())) {
                        bg mR = bg.mR();
                        context = this.aGM.mContext;
                        uVar2 = this.aGM.news_info;
                        mR.b(context, new String[]{uVar2.kR()});
                        return;
                    }
                    return;
                }
                return;
            }
            rVar = this.aGM.top_code;
            if (!TextUtils.isEmpty(rVar.kL())) {
                bg mR2 = bg.mR();
                context2 = this.aGM.mContext;
                rVar2 = this.aGM.top_code;
                mR2.b(context2, new String[]{rVar2.kL()});
            }
        }
    }
}
