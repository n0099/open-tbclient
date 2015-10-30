package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.i> {
    final /* synthetic */ a bdn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bdn = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        az.uT().b(this.bdn.mContext, new String[]{str});
        String str2 = "";
        if (this.bdn.aVf != null) {
            str2 = this.bdn.aVf.getForumId();
        }
        TiebaStatic.log(new aq("c10133").ae(ImageViewerConfig.FORUM_ID, str2).r(ImageViewerConfig.INDEX, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.i iVar) {
        int i2;
        Drawable drawable;
        if (this.bdn.bcB != null) {
            String str = "";
            if (this.bdn.aVf != null) {
                str = this.bdn.aVf.getForumId();
            }
            TiebaStatic.log(new aq("c10132").ae(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, i));
            if (iVar == null || StringUtils.isNull(iVar.getTitle(), true)) {
                this.bdn.bcB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bdn.bcB.setText("");
                return;
            }
            TextView textView = this.bdn.bcB;
            i2 = this.bdn.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.bdn.bcB;
            drawable = this.bdn.bcC;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bdn.bcB.setText(iVar.getTitle());
        }
    }
}
