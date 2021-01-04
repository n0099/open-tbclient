package com.baidu.tbadk.trackConfig;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.stats.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0601a fOI;
    private HttpMessageListener fvY = new HttpMessageListener(CmdConfigHttp.CMD_TRACK_CONFIG) { // from class: com.baidu.tbadk.trackConfig.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof TrackConfigResponseMessage) {
                TrackConfigResponseMessage trackConfigResponseMessage = (TrackConfigResponseMessage) httpResponsedMessage;
                if (a.this.fOI != null) {
                    a.this.fOI.x(trackConfigResponseMessage.isSuccess(), trackConfigResponseMessage.getData());
                }
            }
        }
    };

    /* renamed from: com.baidu.tbadk.trackConfig.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0601a {
        void x(boolean z, boolean z2);
    }

    public a() {
        MessageManager.getInstance().registerListener(this.fvY);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_TRACK_CONFIG, TbConfig.SERVER_ADDRESS + TbConfig.GET_TRACK_CONFIG);
        tbHttpMessageTask.setResponsedClass(TrackConfigResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        f.ao(TbSingleton.getInstance().isIsOpenTrack());
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_TRACK_CONFIG));
    }

    public void a(InterfaceC0601a interfaceC0601a) {
        this.fOI = interfaceC0601a;
    }
}
