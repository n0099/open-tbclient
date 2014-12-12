package com.baidu.tbadk.gift;

import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.baidu.tbadk.gift.GiftCommonList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements AdapterView.OnItemClickListener {
    final /* synthetic */ BuyGiftActivity aaD;

    private r(BuyGiftActivity buyGiftActivity) {
        this.aaD = buyGiftActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(BuyGiftActivity buyGiftActivity, r rVar) {
        this(buyGiftActivity);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0060: INVOKE  (r0v11 int A[REMOVE]) = (r0v10 com.baidu.tbadk.gift.GiftCommonList$NumInfo) type: VIRTUAL call: com.baidu.tbadk.gift.GiftCommonList.NumInfo.getNum():int)] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GiftCommonList giftCommonList;
        GiftCommonList giftCommonList2;
        GiftCommonList giftCommonList3;
        EditText editText;
        View view2;
        EditText editText2;
        giftCommonList = this.aaD.aam;
        if (giftCommonList != null) {
            giftCommonList2 = this.aaD.aam;
            if (giftCommonList2.getGiftInfo() != null) {
                giftCommonList3 = this.aaD.aam;
                List<GiftCommonList.NumInfo> numInfo = giftCommonList3.getGiftInfo().getNumInfo();
                if (i != numInfo.size()) {
                    GiftCommonList.NumInfo numInfo2 = numInfo.get(i);
                    if (numInfo2 != null) {
                        editText = this.aaD.ZZ;
                        editText.setText(new StringBuilder().append(numInfo2.getNum()).toString());
                    }
                } else {
                    this.aaD.aK(true);
                    editText2 = this.aaD.ZZ;
                    Selection.selectAll(editText2.getText());
                }
                view2 = this.aaD.aah;
                view2.setVisibility(8);
                this.aaD.aJ(true);
            }
        }
    }
}
