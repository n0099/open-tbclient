package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity Uu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BuyGiftActivity buyGiftActivity) {
        this.Uu = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        EditText editText;
        String str;
        View view3;
        EditText editText2;
        view2 = this.Uu.Up;
        view2.setVisibility(8);
        BuyGiftActivity buyGiftActivity = this.Uu;
        editText = this.Uu.Um;
        buyGiftActivity.mPassword = editText.getText().toString();
        str = this.Uu.mPassword;
        if (!StringUtils.isValidPassWord(str)) {
            this.Uu.showToast(com.baidu.tieba.y.wrong_password);
            view3 = this.Uu.Up;
            view3.setVisibility(0);
            return;
        }
        this.Uu.sb();
        editText2 = this.Uu.Um;
        editText2.setText("");
    }
}
