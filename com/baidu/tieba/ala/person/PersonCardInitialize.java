package com.baidu.tieba.ala.person;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.q;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.person.a;
import com.baidu.tieba.ala.person.c.d;
import com.baidu.tieba.ala.person.messages.PlaybacksResponseMessage;
/* loaded from: classes3.dex */
public class PersonCardInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaPersonCardActivityConfig.class, PersonCardActivity.class);
        xB();
        bBA();
    }

    private static void xB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913041, new CustomMessageTask.CustomRunnable<q>() { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<q> customMessage) {
                final q data = customMessage.getData();
                if (data != null && data.pageContext != null && !StringUtils.isNull(data.userId)) {
                    a aVar = new a(data.pageContext.getPageActivity());
                    aVar.a(new a.InterfaceC0529a() { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.1.1
                        @Override // com.baidu.tieba.ala.person.a.InterfaceC0529a
                        public void bBB() {
                            final d dVar = new d(data.pageContext);
                            dVar.a(new d.a() { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.1.1.1
                                @Override // com.baidu.tieba.ala.person.c.d.a
                                public void bBz() {
                                    data.pageContext.showToast(a.i.ala_person_report_online_success);
                                    dVar.a((d.a) null);
                                }

                                @Override // com.baidu.tieba.ala.person.c.d.a
                                public void onFail(String str) {
                                    data.pageContext.showToast(str);
                                    dVar.a((d.a) null);
                                }
                            });
                            dVar.Bm(data.userId);
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

    private static void bBA() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.person.PersonCardInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.d.a)) {
                    com.baidu.live.liveroom.d.a aVar = (com.baidu.live.liveroom.d.a) customResponsedMessage.getData();
                    if (aVar.aPQ != null && aVar.aPQ.context != null) {
                        aVar.a((e) new com.baidu.tieba.ala.person.b.a((TbPageContext) IScrollableHelper.getBbPageContext(aVar.aPQ.context)));
                    }
                }
            }
        });
    }
}
