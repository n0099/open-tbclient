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
    final /* synthetic */ j boe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.boe = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ImageView imageView;
        EditText editText;
        TextView textView2;
        TbPageContext tbPageContext;
        textView = this.boe.boa;
        if (view == textView) {
            editText = this.boe.bnZ;
            String a = com.baidu.adp.lib.util.k.a(editText.getText(), null);
            if (!StringUtils.isNULL(a)) {
                if (a.trim().length() == 0) {
                    if (a.length() > 0) {
                        tbPageContext = this.boe.mPageContext;
                        tbPageContext.showToast(z.input_content);
                        return;
                    }
                    return;
                }
                this.boe.fT(a.trim());
                textView2 = this.boe.boa;
                textView2.setClickable(false);
                return;
            }
            return;
        }
        imageView = this.boe.bob;
        if (view == imageView) {
            this.boe.hi("");
        }
    }
}
