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
    private InterfaceC0427a egl;
    private HttpMessageListener egm = new HttpMessageListener(CmdConfigHttp.CMD_TRACK_CONFIG) { // from class: com.baidu.tbadk.trackConfig.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof TrackConfigResponseMessage) {
                TrackConfigResponseMessage trackConfigResponseMessage = (TrackConfigResponseMessage) httpResponsedMessage;
                if (a.this.egl != null) {
                    a.this.egl.q(trackConfigResponseMessage.isSuccess(), trackConfigResponseMessage.getData());
                }
            }
        }
    };

    /* renamed from: com.baidu.tbadk.trackConfig.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0427a {
        void q(boolean z, boolean z2);
    }

    public a() {
        MessageManager.getInstance().registerListener(this.egm);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_TRACK_CONFIG, TbConfig.SERVER_ADDRESS + TbConfig.GET_TRACK_CONFIG);
        tbHttpMessageTask.setResponsedClass(TrackConfigResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        f.am(TbSingleton.getInstance().isIsOpenTrack());
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_TRACK_CONFIG));
    }

    public void a(InterfaceC0427a interfaceC0427a) {
        this.egl = interfaceC0427a;
    }
}
