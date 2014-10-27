package com.baidu.tieba.discover;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ DiscoverItemView anR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(DiscoverItemView discoverItemView) {
        this.anR = discoverItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        boolean z;
        ImageView imageView;
        boolean z2;
        ImageView imageView2;
        View.OnClickListener onClickListener2;
        onClickListener = this.anR.mOnClickListener;
        if (onClickListener != null) {
            onClickListener2 = this.anR.mOnClickListener;
            onClickListener2.onClick(view);
        }
        z = this.anR.anL;
        if (z) {
            z2 = this.anR.anM;
            if (z2) {
                String aE = com.baidu.adp.lib.util.u.aE(this.anR.anJ);
                if (!TbadkSettings.getInst().loadBoolean(aE, false)) {
                    TbadkSettings.getInst().saveBoolean(aE, true);
                    imageView2 = this.anR.anG;
                    imageView2.setVisibility(8);
                    return;
                }
                return;
            }
        }
        imageView = this.anR.anG;
        imageView.setVisibility(8);
    }
}
