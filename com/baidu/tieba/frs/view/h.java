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
    final /* synthetic */ a bop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bop = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        bf.vn().b(this.bop.mContext, new String[]{str});
        String str2 = "";
        if (this.bop.beB != null) {
            str2 = this.bop.beB.getForumId();
        }
        TiebaStatic.log(new av("c10133").aa(ImageViewerConfig.FORUM_ID, str2).r(ImageViewerConfig.INDEX, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.i iVar) {
        int i2;
        Drawable drawable;
        if (this.bop.bnC != null) {
            String str = "";
            if (this.bop.beB != null) {
                str = this.bop.beB.getForumId();
            }
            TiebaStatic.log(new av("c10132").aa(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, i));
            if (iVar == null || StringUtils.isNull(iVar.getTitle(), true)) {
                this.bop.bnC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bop.bnC.setText("");
                return;
            }
            TextView textView = this.bop.bnC;
            i2 = this.bop.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.bop.bnC;
            drawable = this.bop.bnD;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bop.bnC.setText(iVar.getTitle());
        }
    }
}
