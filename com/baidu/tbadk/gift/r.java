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
    final /* synthetic */ BuyGiftActivity abb;

    private r(BuyGiftActivity buyGiftActivity) {
        this.abb = buyGiftActivity;
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
        giftCommonList = this.abb.aaK;
        if (giftCommonList != null) {
            giftCommonList2 = this.abb.aaK;
            if (giftCommonList2.getGiftInfo() != null) {
                giftCommonList3 = this.abb.aaK;
                List<GiftCommonList.NumInfo> numInfo = giftCommonList3.getGiftInfo().getNumInfo();
                if (i != numInfo.size()) {
                    GiftCommonList.NumInfo numInfo2 = numInfo.get(i);
                    if (numInfo2 != null) {
                        editText = this.abb.aax;
                        editText.setText(new StringBuilder().append(numInfo2.getNum()).toString());
                    }
                } else {
                    this.abb.aM(true);
                    editText2 = this.abb.aax;
                    Selection.selectAll(editText2.getText());
                }
                view2 = this.abb.aaF;
                view2.setVisibility(8);
                this.abb.aL(true);
            }
        }
    }
}
