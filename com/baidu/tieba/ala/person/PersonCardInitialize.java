package com.baidu.tieba.ala.person;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ag;
import com.baidu.live.personmanager.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.person.a;
import com.baidu.tieba.ala.person.messages.PlaybacksResponseMessage;
/* loaded from: classes11.dex */
public class PersonCardInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaPersonCardActivityConfig.class, PersonCardActivity.class);
        registerTask();
        cmt();
    }

    private static void registerTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913041, new CustomMessageTask.CustomRunnable<ag>() { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ag> customMessage) {
                final ag data = customMessage.getData();
                if (data != null && data.pageContext != null && !StringUtils.isNull(data.userId)) {
                    a aVar = new a(data.pageContext.getPageActivity());
                    aVar.a(new a.InterfaceC0680a() { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.1.1
                        @Override // com.baidu.tieba.ala.person.a.InterfaceC0680a
                        public void cmu() {
                            final e eVar = new e(data.pageContext);
                            eVar.a(new e.a() { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.1.1.1
                                @Override // com.baidu.live.personmanager.e.a
                                public void Pg() {
                                    data.pageContext.showToast(a.h.ala_person_report_online_success);
                                    eVar.a((e.a) null);
                                }

                                @Override // com.baidu.live.personmanager.e.a
                                public void onFail(String str) {
                                    data.pageContext.showToast(str);
                                    eVar.a((e.a) null);
                                }
                            });
                            eVar.aF(data.userId, null);
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

    private static void cmt() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.d.a)) {
                    com.baidu.live.liveroom.d.a aVar = (com.baidu.live.liveroom.d.a) customResponsedMessage.getData();
                    if (aVar.brA != null && aVar.brA.context != null) {
                        aVar.a((com.baidu.live.liveroom.d.e) new com.baidu.tieba.ala.person.b.a((TbPageContext) IScrollableHelper.getBbPageContext(aVar.brA.context)));
                    }
                }
            }
        });
    }
}
