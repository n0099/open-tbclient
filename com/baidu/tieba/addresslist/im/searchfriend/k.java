package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j azl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.azl = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ImageView imageView;
        EditText editText;
        TextView textView2;
        TbPageContext tbPageContext;
        textView = this.azl.azh;
        if (view == textView) {
            editText = this.azl.azg;
            String a = com.baidu.adp.lib.util.m.a(editText.getText(), null);
            if (!StringUtils.isNULL(a)) {
                if (a.trim().length() == 0) {
                    if (a.length() > 0) {
                        tbPageContext = this.azl.mPageContext;
                        tbPageContext.showToast(y.input_content);
                        return;
                    }
                    return;
                }
                this.azl.fj(a.trim());
                textView2 = this.azl.azh;
                textView2.setClickable(false);
                return;
            }
            return;
        }
        imageView = this.azl.azi;
        if (view == imageView) {
            this.azl.fi("");
        }
    }
}
