package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.c.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f hLM = null;
    private c hLN;
    private c hLO;
    private ArrayList<TransmitForumData> hLP;
    private ArrayList<TransmitForumData> hLR;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean hLQ = false;
    private boolean hLS = false;
    private boolean isLoading = false;

    public static f cjN() {
        if (hLM == null) {
            synchronized (f.class) {
                if (hLM == null) {
                    hLM = new f();
                }
            }
        }
        return hLM;
    }

    private f() {
        init();
    }

    private void init() {
        cjP();
        cjO();
        this.isLoading = false;
    }

    private void cjO() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.hLO = (c) runTask.getData();
        }
        if (this.hLO != null) {
            this.hLO.a(this);
        }
    }

    private void cjP() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.hLN = (c) runTask.getData();
        }
        if (this.hLN != null) {
            this.hLN.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !l.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = cjT();
            }
            if (com.baidu.adp.lib.util.l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.btf()) {
                cjQ();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void cjQ() {
        this.isLoading = true;
        if (this.hLN != null) {
            this.hLN.cjK();
        }
        if (this.hLO != null) {
            this.hLO.cjK();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.hLR = arrayList;
            }
            this.hLS = true;
        } else if (i == 2) {
            if (z) {
                this.hLP = arrayList;
                this.mPrivateThread = i2;
            }
            this.hLQ = true;
        }
        cjR();
    }

    private void cjR() {
        if (this.hLN == null || this.hLQ) {
            if (this.hLO == null || this.hLS) {
                this.hLQ = false;
                this.hLS = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.hLP)) {
                    Iterator<TransmitForumData> it = this.hLP.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!eY(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.hLR)) {
                    Iterator<TransmitForumData> it2 = this.hLR.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!eY(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.hLP = null;
                this.hLR = null;
                cjS();
            }
        }
    }

    private void cjS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean eY(long j) {
        if (this.mForumList == null) {
            return false;
        }
        Iterator<TransmitForumData> it = this.mForumList.iterator();
        while (it.hasNext()) {
            TransmitForumData next = it.next();
            if (next != null && next.forumId == j) {
                return true;
            }
        }
        return false;
    }

    private Location cjT() {
        if (ae.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
            LocationManager locationManager = (LocationManager) TbadkCoreApplication.getInst().getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(1);
            try {
                return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
