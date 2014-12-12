package com.baidu.tieba.hao123;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tieba.hao123.IHao123ServerService;
/* loaded from: classes.dex */
public class Hao123ServerService extends BdBaseService {
    private static final int MSG_WHAT_START_ENTERFOURM = 3;
    private static final int MSG_WHAT_START_FRS = 0;
    private static final int MSG_WHAT_START_LOGIN = 1;
    private static final int MSG_WHAT_START_SEARCH = 2;
    private static final int MSG_WHAT_START_SQUARE = 4;
    private static final int MSG_WHAT_TURN_OPEN = 5;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.hao123.Hao123ServerService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(Hao123ServerService.this).createBackSpecialCfg((String) message.obj, "from_hao123", true, false)));
            } else if (message.what == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(Hao123ServerService.this, NotLoginGuideActivityConfig.FROM_HAO123)));
            } else if (message.what == 2) {
                if (TbadkCoreApplication.isLogin()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new SquareSearchActivityConfig(Hao123ServerService.this, "from_hao123", true)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(Hao123ServerService.this, NotLoginGuideActivityConfig.FROM_HAO123)));
                }
            } else if (message.what == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(Hao123ServerService.this).createNormalCfg(1)));
            } else if (message.what == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(Hao123ServerService.this, "from_hao123", true)));
            } else if (message.what == 5) {
                TbadkCoreApplication.m255getInst().setTiebaHelperOpen(((Boolean) message.obj).booleanValue());
            }
        }
    };
    private IHao123ServerService.Stub mBinder = new IHao123ServerService.Stub() { // from class: com.baidu.tieba.hao123.Hao123ServerService.2
        @Override // com.baidu.tieba.hao123.IHao123ServerService
        public void startFrs(String str) {
            Message obtainMessage = Hao123ServerService.this.mHandler.obtainMessage();
            obtainMessage.what = 0;
            obtainMessage.obj = str;
            Hao123ServerService.this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.baidu.tieba.hao123.IHao123ServerService
        public void startSearch() {
            Message obtainMessage = Hao123ServerService.this.mHandler.obtainMessage();
            obtainMessage.what = 2;
            Hao123ServerService.this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.baidu.tieba.hao123.IHao123ServerService
        public void startLogin() {
            Message obtainMessage = Hao123ServerService.this.mHandler.obtainMessage();
            obtainMessage.what = 1;
            Hao123ServerService.this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.baidu.tieba.hao123.IHao123ServerService
        public void startEnterFourm() {
            Message obtainMessage = Hao123ServerService.this.mHandler.obtainMessage();
            obtainMessage.what = 3;
            Hao123ServerService.this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.baidu.tieba.hao123.IHao123ServerService
        public void startSquare() {
            Message obtainMessage = Hao123ServerService.this.mHandler.obtainMessage();
            obtainMessage.what = 4;
            Hao123ServerService.this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.baidu.tieba.hao123.IHao123ServerService
        public void turn(boolean z) {
            Message obtainMessage = Hao123ServerService.this.mHandler.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = Boolean.valueOf(z);
            Hao123ServerService.this.mHandler.sendMessage(obtainMessage);
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
