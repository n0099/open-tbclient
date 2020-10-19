package com.baidu.tieba.ala.person;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.y;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.personmanager.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.person.a;
import com.baidu.tieba.ala.person.messages.PlaybacksResponseMessage;
/* loaded from: classes4.dex */
public class PersonCardInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaPersonCardActivityConfig.class, PersonCardActivity.class);
        registerTask();
        cdD();
    }

    private static void registerTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913041, new CustomMessageTask.CustomRunnable<y>() { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<y> customMessage) {
                final y data = customMessage.getData();
                if (data != null && data.pageContext != null && !StringUtils.isNull(data.userId)) {
                    a aVar = new a(data.pageContext.getPageActivity());
                    aVar.a(new a.InterfaceC0662a() { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.1.1
                        @Override // com.baidu.tieba.ala.person.a.InterfaceC0662a
                        public void cdE() {
                            final b bVar = new b(data.pageContext);
                            bVar.a(new b.a() { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.1.1.1
                                @Override // com.baidu.live.personmanager.b.a
                                public void NN() {
                                    data.pageContext.showToast(a.i.ala_person_report_online_success);
                                    bVar.a((b.a) null);
                                }

                                @Override // com.baidu.live.personmanager.b.a
                                public void onFail(String str) {
                                    data.pageContext.showToast(str);
                                    bVar.a((b.a) null);
                                }
                            });
                            bVar.aC(data.userId, null);
                        }
                    });
                    aVar.show();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021027, TbConfig.SERVER_ADDRESS + "ala/live/getRecords");
        tbHttpMessageTask.setResponsedClass(PlaybacksResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cdD() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.d.a)) {
                    com.baidu.live.liveroom.d.a aVar = (com.baidu.live.liveroom.d.a) customResponsedMessage.getData();
                    if (aVar.bkG != null && aVar.bkG.context != null) {
                        aVar.a((e) new com.baidu.tieba.ala.person.b.a((TbPageContext) IScrollableHelper.getBbPageContext(aVar.bkG.context)));
                    }
                }
            }
        });
    }
}
