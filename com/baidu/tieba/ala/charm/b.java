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
/* loaded from: classes3.dex */
public class b implements c {
    private boolean aSw;
    private String aSx;
    private com.baidu.tieba.ala.charm.model.a fnQ;
    private c.a fof;
    private CustomMessageListener fog;
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
        this.aSw = z;
        this.aSx = str4;
        this.mOtherParams = str5;
        registerListener();
    }

    @Override // com.baidu.tieba.ala.charm.c
    public void a(c.a aVar) {
        this.fof = aVar;
    }

    @Override // com.baidu.tieba.ala.charm.c
    public void bsZ() {
        if (this.fnQ == null) {
            this.fnQ = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUserId, new a.InterfaceC0532a() { // from class: com.baidu.tieba.ala.charm.b.1
                @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0532a
                public void a(ALaCharmDataList aLaCharmDataList) {
                    b.this.b(aLaCharmDataList);
                }

                @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0532a
                public void ax(int i, String str) {
                    if (b.this.fof != null) {
                        b.this.fof.pU(str);
                    }
                }
            });
        }
        this.fnQ.J(1, 20, 1);
    }

    @Override // com.baidu.tieba.ala.charm.c
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913186));
            if (this.fof != null) {
                this.fof.onClose();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.aSw, this.aSx, null, aLaCharmData.user_name, this.mOtherParams)));
        }
    }

    @Override // com.baidu.tieba.ala.charm.c
    public void release() {
        this.fof = null;
        if (this.fog != null) {
            MessageManager.getInstance().unRegisterListener(this.fog);
        }
        if (this.fnQ != null) {
            this.fnQ.onDestroy();
        }
    }

    private void registerListener() {
        this.fog = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.charm.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.fof != null) {
                    b.this.fof.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmDataList aLaCharmDataList) {
        ArrayList<ALaCharmData> arrayList;
        String str;
        if (this.fof != null && aLaCharmDataList != null && (arrayList = aLaCharmDataList.data) != null) {
            int size = arrayList.size();
            if (size > 3) {
                if (size >= 20) {
                    str = String.format("最多只展示前%d位用户", Integer.valueOf(size));
                } else {
                    str = "没有更多了哦";
                }
                this.fof.b(arrayList.subList(0, 3), arrayList.subList(3, size), str);
                return;
            }
            this.fof.b(arrayList.subList(0, size), null, null);
        }
    }
}
