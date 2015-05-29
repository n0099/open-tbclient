package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j aAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aAW = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ImageView imageView;
        EditText editText;
        TextView textView2;
        TbPageContext tbPageContext;
        textView = this.aAW.aAS;
        if (view == textView) {
            editText = this.aAW.aAR;
            String a = com.baidu.adp.lib.util.m.a(editText.getText(), null);
            if (!StringUtils.isNULL(a)) {
                if (a.trim().length() == 0) {
                    if (a.length() > 0) {
                        tbPageContext = this.aAW.mPageContext;
                        tbPageContext.showToast(com.baidu.tieba.t.input_content);
                        return;
                    }
                    return;
                }
                this.aAW.fE(a.trim());
                textView2 = this.aAW.aAS;
                textView2.setClickable(false);
                return;
            }
            return;
        }
        imageView = this.aAW.aAT;
        if (view == imageView) {
            this.aAW.fD("");
        }
    }
}
