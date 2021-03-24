package com.baidu.tieba.chushou;

import android.content.SharedPreferences;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes4.dex */
public class ChushouStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
            edit.remove("pre_key_last_token");
            edit.remove("user_id");
            edit.apply();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PersonChangeData)) {
                return;
            }
            SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
            edit.remove("pre_key_last_token");
            edit.remove("user_id");
            edit.apply();
        }
    }

    static {
        MessageManager.getInstance().registerListener(new a(2005016));
        MessageManager.getInstance().registerListener(new b(2001380));
    }
}
