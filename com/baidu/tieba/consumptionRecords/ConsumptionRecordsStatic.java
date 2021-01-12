package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes8.dex */
public class ConsumptionRecordsStatic {
    public static String Tag = "tag";

    static {
        TbadkApplication.getInst().RegisterIntent(ConsumptionRecordsActivityConfig.class, ConsumptionRecordsActivity.class);
        be.bsB().a(new be.a() { // from class: com.baidu.tieba.consumptionRecords.ConsumptionRecordsStatic.1
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                if (!strArr[0].equals(UrlSchemaHelper.SCHEMA_TYPE_GOTO_CONSUMPTION_RECORDS) || tbPageContext == null) {
                    return 3;
                }
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ConsumptionRecordsActivityConfig(tbPageContext.getPageActivity())));
                return 0;
            }
        });
    }
}
