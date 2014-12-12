package com.baidu.tieba.im.searchfriend;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j bmI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bmI = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ImageView imageView;
        EditText editText;
        TextView textView2;
        TbPageContext tbPageContext;
        textView = this.bmI.bmE;
        if (view == textView) {
            editText = this.bmI.bmD;
            String a = com.baidu.adp.lib.util.k.a(editText.getText(), null);
            if (!StringUtils.isNULL(a)) {
                if (a.trim().length() == 0) {
                    if (a.length() > 0) {
                        tbPageContext = this.bmI.mPageContext;
                        tbPageContext.showToast(z.input_content);
                        return;
                    }
                    return;
                }
                this.bmI.fR(a.trim());
                textView2 = this.bmI.bmE;
                textView2.setClickable(false);
                return;
            }
            return;
        }
        imageView = this.bmI.bmF;
        if (view == imageView) {
            this.bmI.hg("");
        }
    }
}
