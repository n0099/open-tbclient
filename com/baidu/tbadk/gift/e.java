package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity Uy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BuyGiftActivity buyGiftActivity) {
        this.Uy = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        EditText editText;
        String str;
        View view3;
        EditText editText2;
        view2 = this.Uy.Ut;
        view2.setVisibility(8);
        BuyGiftActivity buyGiftActivity = this.Uy;
        editText = this.Uy.Uq;
        buyGiftActivity.mPassword = editText.getText().toString();
        str = this.Uy.mPassword;
        if (!StringUtils.isValidPassWord(str)) {
            this.Uy.showToast(com.baidu.tieba.y.wrong_password);
            view3 = this.Uy.Ut;
            view3.setVisibility(0);
            return;
        }
        this.Uy.sd();
        editText2 = this.Uy.Uq;
        editText2.setText("");
    }
}
