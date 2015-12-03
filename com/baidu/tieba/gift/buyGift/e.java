package com.baidu.tieba.gift.buyGift;

import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.ueg.encrypt.entity.EncryptAlgorithm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ BuyGiftActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BuyGiftActivity buyGiftActivity) {
        this.buJ = buyGiftActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EditText editText;
        String str;
        String str2;
        String str3;
        String str4;
        EditText editText2;
        this.buJ.cP(false);
        BuyGiftActivity buyGiftActivity = this.buJ;
        editText = this.buJ.buB;
        buyGiftActivity.mPassword = editText.getText().toString();
        str = this.buJ.mPassword;
        if (StringUtils.isValidPassWord(str)) {
            str2 = this.buJ.mPublicKey;
            if (!StringUtils.isNull(str2)) {
                try {
                    EncryptAlgorithm encryptAlgorithm = EncryptAlgorithm.RSA;
                    str3 = this.buJ.mPublicKey;
                    com.baidu.ueg.encrypt.a a = com.baidu.ueg.encrypt.b.a(new com.baidu.ueg.encrypt.entity.a(encryptAlgorithm, str3));
                    BuyGiftActivity buyGiftActivity2 = this.buJ;
                    str4 = this.buJ.mPassword;
                    buyGiftActivity2.mPassword = a.encrypt(str4);
                } catch (Exception e) {
                    this.buJ.mPassword = "";
                    e.printStackTrace();
                }
            }
            this.buJ.SX();
            editText2 = this.buJ.buB;
            editText2.setText("");
            return;
        }
        this.buJ.cP(true);
    }
}
