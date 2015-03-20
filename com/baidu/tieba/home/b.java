package com.baidu.tieba.home;

import android.support.v4.internal.view.SupportMenu;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ CreateBarActivity aVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CreateBarActivity createBarActivity) {
        this.aVR = createBarActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void afterTextChanged(Editable editable) {
        EditText editText;
        RelativeLayout relativeLayout;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        EditText editText2;
        RelativeLayout relativeLayout2;
        editText = this.aVR.aVF;
        int length = editText.getText().toString().trim().length();
        if (length > 0 && length < 32) {
            editText2 = this.aVR.avK;
            if (editText2.getText().toString().trim().length() > 0) {
                relativeLayout2 = this.aVR.aVG;
                relativeLayout2.setEnabled(true);
                if (length < 32) {
                    textView3 = this.aVR.aVM;
                    textView3.setText(this.aVR.getPageContext().getString(y.bar_name_long));
                    textView4 = this.aVR.aVM;
                    textView4.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                textView = this.aVR.aVM;
                textView.setText(this.aVR.getPageContext().getString(y.bar_name_rule));
                textView2 = this.aVR.aVM;
                textView2.setTextColor(-6250336);
                return;
            }
        }
        relativeLayout = this.aVR.aVG;
        relativeLayout.setEnabled(false);
        if (length < 32) {
        }
    }
}
