package com.baidu.tieba.frs.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.v;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class b {
    public static int ebs;
    private static b ebv;
    private a ebt;
    private SparseArray<HashSet<String>> ebu;
    private CustomMessageListener aof = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.ebu != null) {
                b.this.ebu.clear();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.e.b.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.eby = false;
                        aVar.isRunning = false;
                        aVar.count = 0;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        public int count;
        public long ebx;
        public boolean eby;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.eby = false;
        }
    }

    public b() {
        ebs = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.aof);
    }

    public static b aGK() {
        if (ebv == null) {
            synchronized (v.class) {
                if (ebv == null) {
                    ebv = new b();
                }
            }
        }
        return ebv;
    }

    private boolean aGL() {
        if (this.ebt == null) {
            this.ebt = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.ebt.eby) {
            return true;
        }
        if (this.ebt.isRunning) {
            this.ebt.count++;
            if (currentTimeMillis - this.ebt.ebx < 120000) {
                if (this.ebt.count >= ebs) {
                    this.ebt.eby = true;
                    a(this.ebt);
                    return true;
                }
            } else {
                this.ebt.isRunning = false;
                this.ebt.count = 0;
            }
        } else {
            this.ebt.isRunning = true;
            this.ebt.ebx = currentTimeMillis;
        }
        return false;
    }

    private void a(a aVar) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = aVar;
        this.mHandler.removeMessages(5);
        this.mHandler.sendMessageDelayed(obtainMessage, ReportUserInfoModel.TIME_INTERVAL);
    }

    public void ad(bb bbVar) {
        if (bbVar != null && bbVar.Az()) {
            am amVar = new am("c11717");
            amVar.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.aA("obj_param2", bbVar.mRecomWeight);
            amVar.aA("obj_param1", bbVar.auX);
            amVar.x("obj_locate", 1);
            amVar.aA("tid", bbVar.getTid());
            v.apD().a(amVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar) {
        if (aVar != null && aVar.ebm && bbVar != null && bbVar.getTid() != null) {
            if (this.ebu == null) {
                this.ebu = new SparseArray<>();
            }
            if (this.ebu.get(aVar.ebp) == null) {
                this.ebu.put(aVar.ebp, new HashSet<>());
            }
            HashSet<String> hashSet = this.ebu.get(aVar.ebp);
            String tid = bbVar.getTid();
            if (aVar.ebq >= 0) {
                tid = tid + BaseRequestAction.SPLITE + aVar.ebq;
            }
            if (!hashSet.contains(tid) && !aGL()) {
                hashSet.add(tid);
                am amVar = new am("c11439");
                amVar.aA(ImageViewerConfig.FORUM_ID, aVar.ebo);
                amVar.x("obj_locate", a(aVar));
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar.aA("obj_param2", bbVar.mRecomWeight);
                amVar.aA("obj_param1", bbVar.mRecomAbTag);
                amVar.aA("obj_param3", bbVar.auX);
                amVar.aA("tid", bbVar.getTid());
                amVar.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.i("exposure_time", System.currentTimeMillis());
                if (aVar.ebp >= 0) {
                    amVar.x(MyBookrackActivityConfig.TAB_ID, aVar.ebp);
                }
                boolean z = (bbVar.AX() == null || (bbVar.AX().bDu() == null && bbVar.AX().Sh() == null)) ? false : true;
                if (z && bbVar.AX().bDu() != null && bbVar.AX().bDu().RZ() != null && bbVar.AX().bDu().RZ().size() > 0) {
                    amVar.x("obj_name", bbVar.AX().hlS ? 3 : 2);
                } else {
                    amVar.x("obj_name", z ? 1 : 0);
                }
                boolean z2 = bbVar.getType() == bb.atp;
                amVar.x("thread_type", z2 ? 2 : 1);
                if (z2 && bbVar.zG() != null && !StringUtils.isNull(bbVar.zG().getName_show())) {
                    amVar.aA("obj_name", bbVar.zG().getName_show());
                }
                v.apD().a(amVar);
                if (bbVar.Au()) {
                    am amVar2 = new am("c12099");
                    amVar2.aA(ImageViewerConfig.FORUM_ID, aVar.ebo);
                    amVar2.x("obj_locate", a(aVar));
                    amVar2.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                    amVar2.aA("obj_param2", bbVar.mRecomWeight);
                    amVar2.aA("obj_param1", bbVar.mRecomAbTag);
                    amVar2.aA("obj_param3", bbVar.auX);
                    amVar2.aA("tid", bbVar.getTid());
                    amVar2.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                    amVar2.aA("uid", TbadkCoreApplication.getCurrentAccount());
                    v.apD().a(amVar2);
                }
                if (bbVar.zL()) {
                    am amVar3 = new am("c13169");
                    amVar3.aA(ImageViewerConfig.FORUM_ID, aVar.ebo);
                    amVar3.aA("tid", bbVar.getTid());
                    amVar3.aA("uid", TbadkCoreApplication.getCurrentAccount());
                    v.apD().a(amVar3);
                }
                if (aVar.ebp == 501) {
                    am amVar4 = new am("c13259");
                    amVar4.aA(ImageViewerConfig.FORUM_ID, aVar.ebo);
                    amVar4.aA("tid", bbVar.getTid());
                    v.apD().a(amVar4);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.ebm && bbVar != null && bbVar.getTid() != null) {
            v.apD().ft(true);
            am amVar = new am("c11438");
            amVar.aA(ImageViewerConfig.FORUM_ID, aVar.ebo);
            amVar.x("obj_locate", a(aVar));
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.aA("obj_param2", bbVar.mRecomWeight);
            amVar.aA("obj_param1", bbVar.mRecomAbTag);
            amVar.aA("obj_param3", bbVar.auX);
            amVar.aA("tid", bbVar.getTid());
            amVar.x("obj_type", i);
            amVar.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
            amVar.aA("obj_to", ae(bbVar));
            if (aVar.ebp >= 0) {
                amVar.x(MyBookrackActivityConfig.TAB_ID, aVar.ebp);
            }
            amVar.x("thread_type", bbVar.getType() == bb.atp ? 2 : 1);
            TiebaStatic.log(amVar);
            if (bbVar.Au()) {
                am amVar2 = new am("c12098");
                amVar2.aA(ImageViewerConfig.FORUM_ID, aVar.ebo);
                amVar2.x("obj_locate", a(aVar));
                amVar2.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar2.aA("obj_param2", bbVar.mRecomWeight);
                amVar2.aA("obj_param1", bbVar.mRecomAbTag);
                amVar2.aA("obj_param3", bbVar.auX);
                amVar2.aA("tid", bbVar.getTid());
                amVar2.x("obj_type", i);
                amVar2.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar2.aA("obj_to", ae(bbVar));
                TiebaStatic.log(amVar2);
            }
            if (aVar.ebp == 501) {
                am amVar3 = new am("c13260");
                amVar3.aA(ImageViewerConfig.FORUM_ID, aVar.ebo);
                amVar3.aA("tid", bbVar.getTid());
                v.apD().a(amVar3);
            }
        }
    }

    private int a(com.baidu.tieba.frs.e.a aVar) {
        if (aVar == null) {
            return 5;
        }
        if (aVar.ebr > 0) {
            return aVar.ebr;
        }
        int i = aVar.ebn;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.ebm && bbVar != null && bbVar.getTid() != null && bbVar.zL()) {
            am amVar = new am("c13170");
            amVar.aA(ImageViewerConfig.FORUM_ID, aVar.ebo);
            amVar.x("obj_locate", i);
            amVar.aA("tid", bbVar.getTid());
            TiebaStatic.log(amVar);
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.bgi() != null && lVar.hiz == 1) {
            TiebaStatic.log(new am("c11440").aA(ImageViewerConfig.FORUM_ID, lVar.bgi().getId()).x("obj_locate", i).x("obj_type", i2));
        }
    }

    private int R(bb bbVar) {
        if (bbVar.AJ() == null || bbVar.AJ().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.AJ().channelId;
    }

    private String ae(bb bbVar) {
        return bbVar.auY ? String.valueOf(bbVar.AG()) : String.valueOf(4);
    }
}
