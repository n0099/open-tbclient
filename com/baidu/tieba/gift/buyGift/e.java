package com.baidu.tieba.gift.buyGift;

import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.ueg.encrypt.entity.EncryptAlgorithm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ BuyGiftActivity bng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BuyGiftActivity buyGiftActivity) {
        this.bng = buyGiftActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EditText editText;
        String str;
        String str2;
        String str3;
        String str4;
        EditText editText2;
        this.bng.cz(false);
        BuyGiftActivity buyGiftActivity = this.bng;
        editText = this.bng.bmY;
        buyGiftActivity.mPassword = editText.getText().toString();
        str = this.bng.mPassword;
        if (StringUtils.isValidPassWord(str)) {
            str2 = this.bng.mPublicKey;
            if (!StringUtils.isNull(str2)) {
                try {
                    EncryptAlgorithm encryptAlgorithm = EncryptAlgorithm.RSA;
                    str3 = this.bng.mPublicKey;
                    com.baidu.ueg.encrypt.a a = com.baidu.ueg.encrypt.b.a(new com.baidu.ueg.encrypt.entity.a(encryptAlgorithm, str3));
                    BuyGiftActivity buyGiftActivity2 = this.bng;
                    str4 = this.bng.mPassword;
                    buyGiftActivity2.mPassword = a.encrypt(str4);
                } catch (Exception e) {
                    this.bng.mPassword = "";
                    e.printStackTrace();
                }
            }
            this.bng.QH();
            editText2 = this.bng.bmY;
            editText2.setText("");
            return;
        }
        this.bng.cz(true);
    }
}
