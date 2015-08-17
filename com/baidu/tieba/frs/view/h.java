package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.i> {
    final /* synthetic */ a bcO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bcO = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        ax.uR().b(this.bcO.LS, new String[]{str});
        String str2 = "";
        if (this.bcO.aVx != null) {
            str2 = this.bcO.aVx.getForumId();
        }
        TiebaStatic.log(new ao("c10133").af(ImageViewerConfig.FORUM_ID, str2).r(ImageViewerConfig.INDEX, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.i iVar) {
        int i2;
        Drawable drawable;
        if (this.bcO.bcc != null) {
            String str = "";
            if (this.bcO.aVx != null) {
                str = this.bcO.aVx.getForumId();
            }
            TiebaStatic.log(new ao("c10132").af(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, i));
            if (iVar == null || StringUtils.isNull(iVar.getTitle(), true)) {
                this.bcO.bcc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bcO.bcc.setText("");
                return;
            }
            TextView textView = this.bcO.bcc;
            i2 = this.bcO.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.bcO.bcc;
            drawable = this.bcO.bcd;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bcO.bcc.setText(iVar.getTitle());
        }
    }
}
