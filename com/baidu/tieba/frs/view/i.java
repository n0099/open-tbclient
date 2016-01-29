package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.k> {
    final /* synthetic */ b brj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.brj = bVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        be.wt().c(this.brj.MR, new String[]{str});
        String str2 = "";
        if (this.brj.bgW != null) {
            str2 = this.brj.bgW.getForumId();
        }
        TiebaStatic.log(new au("c10133").aa(ImageViewerConfig.FORUM_ID, str2).r(ImageViewerConfig.INDEX, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.k kVar) {
        int i2;
        Drawable drawable;
        if (this.brj.bqu != null) {
            String str = "";
            if (this.brj.bgW != null) {
                str = this.brj.bgW.getForumId();
            }
            TiebaStatic.log(new au("c10132").aa(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, i));
            if (kVar == null || StringUtils.isNull(kVar.getTitle(), true)) {
                this.brj.bqu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.brj.bqu.setText("");
                return;
            }
            TextView textView = this.brj.bqu;
            i2 = this.brj.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.brj.bqu;
            drawable = this.brj.bqv;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.brj.bqu.setText(kVar.getTitle());
        }
    }
}
