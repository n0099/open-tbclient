package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity abb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BuyGiftActivity buyGiftActivity) {
        this.abb = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        EditText editText;
        String str;
        View view3;
        EditText editText2;
        view2 = this.abb.aaW;
        view2.setVisibility(8);
        BuyGiftActivity buyGiftActivity = this.abb;
        editText = this.abb.aaT;
        buyGiftActivity.mPassword = editText.getText().toString();
        str = this.abb.mPassword;
        if (!StringUtils.isValidPassWord(str)) {
            this.abb.showToast(z.wrong_password);
            view3 = this.abb.aaW;
            view3.setVisibility(0);
            return;
        }
        this.abb.vT();
        editText2 = this.abb.aaT;
        editText2.setText("");
    }
}
