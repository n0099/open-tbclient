package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j aJB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aJB = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ImageView imageView;
        EditText editText;
        TextView textView2;
        TbPageContext tbPageContext;
        textView = this.aJB.aJy;
        if (view == textView) {
            editText = this.aJB.aJx;
            String a = com.baidu.adp.lib.util.j.a(editText.getText(), null);
            if (!StringUtils.isNULL(a)) {
                if (a.trim().length() == 0) {
                    if (a.length() > 0) {
                        tbPageContext = this.aJB.mPageContext;
                        tbPageContext.showToast(n.i.input_content);
                        return;
                    }
                    return;
                }
                this.aJB.gw(a.trim());
                textView2 = this.aJB.aJy;
                textView2.setClickable(false);
                return;
            }
            return;
        }
        imageView = this.aJB.aJz;
        if (view == imageView) {
            this.aJB.gv("");
        }
    }
}
