package com.baidu.tieba.ala.liveroom.attentionpop;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener afT;
    private BdAlertDialog dVK;
    CustomMessageListener dVL;
    private Runnable dVM;
    private Handler mHandler;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.afT = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.nA();
            }
        };
        this.dVL = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.aOd();
            }
        };
        this.dVM = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.aOe();
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mHandler = new Handler();
        MessageManager.getInstance().registerListener(this.afT);
        MessageManager.getInstance().registerListener(this.dVL);
    }

    public void aOd() {
        if (this.dVK == null || !this.dVK.isShowing()) {
            if (this.dVK == null) {
                this.dVK = new BdAlertDialog(this.mTbPageContext.getPageActivity());
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
                this.dVK.setContentViewSize(1);
                this.dVK.setContentView(inflate);
                this.dVK.create(this.mTbPageContext);
                inflate.findViewById(a.g.id_ala_liveroom_attention_guide_btn).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.aOe();
                    }
                });
            }
            this.dVK.show();
            this.mHandler.postDelayed(this.dVM, 5000L);
            c.np().putBoolean("ala_attention_guide_has_displayed" + TbadkCoreApplication.getCurrentAccount(), true);
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", AlaStaticKeys.ALA_STATIC_VALUE_FROM);
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", "liveroom");
            alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_TIP);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void nA() {
        super.nA();
        aOe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOe() {
        if (this.dVK != null && this.dVK.isShowing()) {
            this.dVK.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.dVM);
        MessageManager.getInstance().unRegisterListener(this.afT);
        MessageManager.getInstance().unRegisterListener(this.dVL);
    }
}
