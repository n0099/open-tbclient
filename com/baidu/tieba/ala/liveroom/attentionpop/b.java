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
    CustomMessageListener agm;
    private BdAlertDialog dWB;
    CustomMessageListener dWC;
    private Runnable dWD;
    private Handler mHandler;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.agm = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.nA();
            }
        };
        this.dWC = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.aOf();
            }
        };
        this.dWD = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.aOg();
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mHandler = new Handler();
        MessageManager.getInstance().registerListener(this.agm);
        MessageManager.getInstance().registerListener(this.dWC);
    }

    public void aOf() {
        if (this.dWB == null || !this.dWB.isShowing()) {
            if (this.dWB == null) {
                this.dWB = new BdAlertDialog(this.mTbPageContext.getPageActivity());
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
                this.dWB.setContentViewSize(1);
                this.dWB.setContentView(inflate);
                this.dWB.create(this.mTbPageContext);
                inflate.findViewById(a.g.id_ala_liveroom_attention_guide_btn).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.aOg();
                    }
                });
            }
            this.dWB.show();
            this.mHandler.postDelayed(this.dWD, 5000L);
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
        aOg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOg() {
        if (this.dWB != null && this.dWB.isShowing()) {
            this.dWB.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.dWD);
        MessageManager.getInstance().unRegisterListener(this.agm);
        MessageManager.getInstance().unRegisterListener(this.dWC);
    }
}
