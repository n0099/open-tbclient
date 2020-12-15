package com.baidu.tieba.ala.charm;

import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.ala.charm.c;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b implements c {
    private String aGk;
    private boolean bns;
    private com.baidu.tieba.ala.charm.model.a gDD;
    private c.a gDS;
    private CustomMessageListener gDT;
    private String mGroupId;
    private String mLiveId;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mUserId;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.ala.charm.c
    public void a(String str, String str2, String str3, boolean z, String str4, String str5) {
        this.mUserId = str;
        this.mGroupId = str2;
        this.mLiveId = str3;
        this.bns = z;
        this.aGk = str4;
        this.mOtherParams = str5;
        registerListener();
    }

    @Override // com.baidu.tieba.ala.charm.c
    public void a(c.a aVar) {
        this.gDS = aVar;
    }

    @Override // com.baidu.tieba.ala.charm.c
    public void bFR() {
        if (this.gDD == null) {
            this.gDD = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUserId, new a.InterfaceC0650a() { // from class: com.baidu.tieba.ala.charm.b.1
                @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0650a
                public void a(ALaCharmDataList aLaCharmDataList) {
                    b.this.b(aLaCharmDataList);
                }

                @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0650a
                public void t(int i, String str) {
                    if (b.this.gDS != null) {
                        b.this.gDS.vi(str);
                    }
                }
            });
        }
        this.gDD.L(1, 20, 1);
    }

    @Override // com.baidu.tieba.ala.charm.c
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913186));
            if (this.gDS != null) {
                this.gDS.onClose();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bns, this.aGk, null, aLaCharmData.user_name, this.mOtherParams)));
        }
    }

    @Override // com.baidu.tieba.ala.charm.c
    public void release() {
        this.gDS = null;
        if (this.gDT != null) {
            MessageManager.getInstance().unRegisterListener(this.gDT);
        }
        if (this.gDD != null) {
            this.gDD.onDestroy();
        }
    }

    private void registerListener() {
        this.gDT = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.charm.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gDS != null) {
                    b.this.gDS.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.gDT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmDataList aLaCharmDataList) {
        ArrayList<ALaCharmData> arrayList;
        String str;
        if (this.gDS != null && aLaCharmDataList != null && (arrayList = aLaCharmDataList.data) != null) {
            int size = arrayList.size();
            if (size > 3) {
                if (size >= 20) {
                    str = String.format("最多只展示前%d位用户", Integer.valueOf(size));
                } else {
                    str = "没有更多了哦";
                }
                this.gDS.b(arrayList.subList(0, 3), arrayList.subList(3, size), str);
                return;
            }
            this.gDS.b(arrayList.subList(0, size), null, null);
        }
    }
}
