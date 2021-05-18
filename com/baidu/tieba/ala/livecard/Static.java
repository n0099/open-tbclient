package com.baidu.tieba.ala.livecard;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaShareItemAdapter;
import com.baidu.tieba.ala.livecard.adapters.FrsSplitAlaShareItemAdapter;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import d.a.j0.r.q.a2;
import d.a.k0.d3.g;
import d.a.k0.d3.h;
import d.a.k0.q0.f0;
import d.a.k0.q0.g0;
import d.a.k0.t.i.a.d;
import d.a.k0.t.i.a.e;
import d.a.k0.t.i.a.f;
/* loaded from: classes4.dex */
public class Static {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                CustomMessage customMessage = (CustomMessage) customResponsedMessage.getOrginalMessage();
                absDelegateAdapterList.add(new d.a.k0.t.i.a.c(null, a2.h3, null));
                absDelegateAdapterList.add(new f(null, a2.g3, null));
                absDelegateAdapterList.add(new FrsSplitAlaShareItemAdapter(null, a2.i3, null));
                absDelegateAdapterList.add(new d.a.k0.t.i.a.a(null, g.f53759g, null));
                absDelegateAdapterList.add(new d(null, h.f53771f, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003022 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                absDelegateAdapterList.add(new d.a.k0.t.i.a.c(null, a2.h3, null));
                absDelegateAdapterList.add(new e(null, a2.g3, null));
                absDelegateAdapterList.add(new FrsAlaShareItemAdapter(null, a2.i3, null));
                absDelegateAdapterList.add(new e(null, h.f53771f, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof f0)) {
                f0 f0Var = (f0) customResponsedMessage.getData();
                d.a.k0.t.i.c.a aVar = new d.a.k0.t.i.c.a();
                aVar.h(f0Var.f58413e);
                f0Var.a(49, aVar);
            }
        }
    }

    static {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            MessageManager.getInstance().registerListener(new a(2003008));
            MessageManager.getInstance().registerListener(new b(2003022));
            MessageManager.getInstance().registerListener(new c(2003011));
            g0.a().c(49);
        }
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_STAGE_FEED_BACK, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_FRS_NEGATIVE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        messageManager.registerTask(tbHttpMessageTask);
    }
}
