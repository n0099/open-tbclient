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
    final /* synthetic */ j azd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.azd = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ImageView imageView;
        EditText editText;
        TextView textView2;
        TbPageContext tbPageContext;
        textView = this.azd.ayZ;
        if (view == textView) {
            editText = this.azd.ayY;
            String a = com.baidu.adp.lib.util.m.a(editText.getText(), null);
            if (!StringUtils.isNULL(a)) {
                if (a.trim().length() == 0) {
                    if (a.length() > 0) {
                        tbPageContext = this.azd.mPageContext;
                        tbPageContext.showToast(y.input_content);
                        return;
                    }
                    return;
                }
                this.azd.fg(a.trim());
                textView2 = this.azd.ayZ;
                textView2.setClickable(false);
                return;
            }
            return;
        }
        imageView = this.azd.aza;
        if (view == imageView) {
            this.azd.ff("");
        }
    }
}
