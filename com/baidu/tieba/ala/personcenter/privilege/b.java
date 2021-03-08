package com.baidu.tieba.ala.personcenter.privilege;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.gift.AlaRefreshScoreModel;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    private AlaRefreshScoreModel ich;
    private a ici;
    CustomMessageListener icj = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.tieba.ala.personcenter.privilege.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.refreshCurUserScores();
        }
    };
    CustomMessageListener ick = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.tieba.ala.personcenter.privilege.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.ici != null) {
                b.this.ici.oZ(true);
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface a {
        void oZ(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.icj);
        this.mPageContext.registerListener(this.ick);
    }

    public void a(a aVar) {
        this.ici = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean refreshCurUserScores() {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.ich == null) {
            this.ich = new AlaRefreshScoreModel();
            this.ich.initListener();
        }
        this.ich.refreshCurUserScores();
        return true;
    }

    public void fT(long j) {
        long j2 = j - TbadkCoreApplication.getInst().currentAccountTdouNum;
        if (j2 > 0) {
            if (j2 > 200000000) {
                l.showToast(TbadkCoreApplication.getInst(), this.mPageContext.getResources().getString(R.string.ala_toast_gift_exceeding_limit_msg, 20L));
                return;
            }
            if (j2 % 1000 != 0) {
                j2 = ((j2 / 1000) + 1) * 1000;
            }
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setFromDecreaseGiftStepStrategy(2);
            buyTBeanActivityConfig.setTBeanLeftToBuyGift(j2);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
        }
    }
}
