package com.baidu.tieba.addresslist;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
/* loaded from: classes.dex */
public class AddressListActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(AddressListActivityConfig.class, AddressListActivity.class);
    }
}
