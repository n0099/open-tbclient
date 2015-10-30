package com.baidu.tieba.gift.buyGift;

import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.ueg.encrypt.entity.EncryptAlgorithm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ BuyGiftActivity bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BuyGiftActivity buyGiftActivity) {
        this.bmC = buyGiftActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EditText editText;
        String str;
        String str2;
        String str3;
        String str4;
        EditText editText2;
        this.bmC.cx(false);
        BuyGiftActivity buyGiftActivity = this.bmC;
        editText = this.bmC.bmu;
        buyGiftActivity.mPassword = editText.getText().toString();
        str = this.bmC.mPassword;
        if (StringUtils.isValidPassWord(str)) {
            str2 = this.bmC.mPublicKey;
            if (!StringUtils.isNull(str2)) {
                try {
                    EncryptAlgorithm encryptAlgorithm = EncryptAlgorithm.RSA;
                    str3 = this.bmC.mPublicKey;
                    com.baidu.ueg.encrypt.a a = com.baidu.ueg.encrypt.b.a(new com.baidu.ueg.encrypt.entity.a(encryptAlgorithm, str3));
                    BuyGiftActivity buyGiftActivity2 = this.bmC;
                    str4 = this.bmC.mPassword;
                    buyGiftActivity2.mPassword = a.encrypt(str4);
                } catch (Exception e) {
                    this.bmC.mPassword = "";
                    e.printStackTrace();
                }
            }
            this.bmC.Ql();
            editText2 = this.bmC.bmu;
            editText2.setText("");
            return;
        }
        this.bmC.cx(true);
    }
}
