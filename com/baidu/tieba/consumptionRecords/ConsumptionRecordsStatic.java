package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
/* loaded from: classes4.dex */
public class ConsumptionRecordsStatic {

    /* loaded from: classes4.dex */
    public static class a implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr == null || strArr.length == 0 || !strArr[0].equals(UrlSchemaHelper.SCHEMA_TYPE_GOTO_CONSUMPTION_RECORDS) || tbPageContext == null) {
                return 3;
            }
            tbPageContext.sendMessage(new CustomMessage(2002001, new ConsumptionRecordsActivityConfig(tbPageContext.getPageActivity())));
            return 0;
        }
    }

    static {
        TbadkApplication.getInst().RegisterIntent(ConsumptionRecordsActivityConfig.class, ConsumptionRecordsActivity.class);
        UrlManager.getInstance().addListener(new a());
    }
}
