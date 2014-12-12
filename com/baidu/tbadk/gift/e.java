package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity aaD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BuyGiftActivity buyGiftActivity) {
        this.aaD = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        EditText editText;
        String str;
        View view3;
        EditText editText2;
        view2 = this.aaD.aay;
        view2.setVisibility(8);
        BuyGiftActivity buyGiftActivity = this.aaD;
        editText = this.aaD.aav;
        buyGiftActivity.mPassword = editText.getText().toString();
        str = this.aaD.mPassword;
        if (!StringUtils.isValidPassWord(str)) {
            this.aaD.showToast(z.wrong_password);
            view3 = this.aaD.aay;
            view3.setVisibility(0);
            return;
        }
        this.aaD.vG();
        editText2 = this.aaD.aav;
        editText2.setText("");
    }
}
