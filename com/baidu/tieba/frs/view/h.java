package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.i> {
    final /* synthetic */ a bky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bky = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        bf.vD().b(this.bky.mContext, new String[]{str});
        String str2 = "";
        if (this.bky.baC != null) {
            str2 = this.bky.baC.getForumId();
        }
        TiebaStatic.log(new av("c10133").ab(ImageViewerConfig.FORUM_ID, str2).r(ImageViewerConfig.INDEX, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.i iVar) {
        int i2;
        Drawable drawable;
        if (this.bky.bjL != null) {
            String str = "";
            if (this.bky.baC != null) {
                str = this.bky.baC.getForumId();
            }
            TiebaStatic.log(new av("c10132").ab(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, i));
            if (iVar == null || StringUtils.isNull(iVar.getTitle(), true)) {
                this.bky.bjL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bky.bjL.setText("");
                return;
            }
            TextView textView = this.bky.bjL;
            i2 = this.bky.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.bky.bjL;
            drawable = this.bky.bjM;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bky.bjL.setText(iVar.getTitle());
        }
    }
}
