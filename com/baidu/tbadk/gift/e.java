package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity abe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BuyGiftActivity buyGiftActivity) {
        this.abe = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        EditText editText;
        String str;
        View view3;
        EditText editText2;
        view2 = this.abe.aaZ;
        view2.setVisibility(8);
        BuyGiftActivity buyGiftActivity = this.abe;
        editText = this.abe.aaW;
        buyGiftActivity.mPassword = editText.getText().toString();
        str = this.abe.mPassword;
        if (!StringUtils.isValidPassWord(str)) {
            this.abe.showToast(z.wrong_password);
            view3 = this.abe.aaZ;
            view3.setVisibility(0);
            return;
        }
        this.abe.vZ();
        editText2 = this.abe.aaW;
        editText2.setText("");
    }
}
