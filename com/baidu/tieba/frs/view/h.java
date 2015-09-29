package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.h> {
    final /* synthetic */ a bdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bdc = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        ay.uV().b(this.bdc.mContext, new String[]{str});
        String str2 = "";
        if (this.bdc.aUU != null) {
            str2 = this.bdc.aUU.getForumId();
        }
        TiebaStatic.log(new ap("c10133").ae(ImageViewerConfig.FORUM_ID, str2).r(ImageViewerConfig.INDEX, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.h hVar) {
        int i2;
        Drawable drawable;
        if (this.bdc.bcq != null) {
            String str = "";
            if (this.bdc.aUU != null) {
                str = this.bdc.aUU.getForumId();
            }
            TiebaStatic.log(new ap("c10132").ae(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, i));
            if (hVar == null || StringUtils.isNull(hVar.getTitle(), true)) {
                this.bdc.bcq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bdc.bcq.setText("");
                return;
            }
            TextView textView = this.bdc.bcq;
            i2 = this.bdc.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.bdc.bcq;
            drawable = this.bdc.bcr;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bdc.bcq.setText(hVar.getTitle());
        }
    }
}
