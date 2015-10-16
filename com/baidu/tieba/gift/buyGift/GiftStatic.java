package com.baidu.tieba.gift.buyGift;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BuyGiftActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
/* loaded from: classes.dex */
public class GiftStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(MyGiftListActivityConfig.class, MyGiftListActivity.class);
        TbadkApplication.getInst().RegisterIntent(BuyGiftActivityConfig.class, BuyGiftActivity.class);
    }
}
