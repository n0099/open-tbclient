package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.c.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f hcP = null;
    private c hcQ;
    private c hcR;
    private ArrayList<TransmitForumData> hcS;
    private ArrayList<TransmitForumData> hcU;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean hcT = false;
    private boolean hcV = false;
    private boolean isLoading = false;

    public static f bSP() {
        if (hcP == null) {
            synchronized (f.class) {
                if (hcP == null) {
                    hcP = new f();
                }
            }
        }
        return hcP;
    }

    private f() {
        init();
    }

    private void init() {
        bSR();
        bSQ();
        this.isLoading = false;
    }

    private void bSQ() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.hcR = (c) runTask.getData();
        }
        if (this.hcR != null) {
            this.hcR.a(this);
        }
    }

    private void bSR() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.hcQ = (c) runTask.getData();
        }
        if (this.hcQ != null) {
            this.hcQ.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = bSV();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bSS();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bSS() {
        this.isLoading = true;
        if (this.hcQ != null) {
            this.hcQ.bSM();
        }
        if (this.hcR != null) {
            this.hcR.bSM();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.hcU = arrayList;
            }
            this.hcV = true;
        } else if (i == 2) {
            if (z) {
                this.hcS = arrayList;
                this.mPrivateThread = i2;
            }
            this.hcT = true;
        }
        bST();
    }

    private void bST() {
        if (this.hcQ == null || this.hcT) {
            if (this.hcR == null || this.hcV) {
                this.hcT = false;
                this.hcV = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!x.isEmpty(this.hcS)) {
                    Iterator<TransmitForumData> it = this.hcS.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!em(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!x.isEmpty(this.hcU)) {
                    Iterator<TransmitForumData> it2 = this.hcU.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!em(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.hcS = null;
                this.hcU = null;
                bSU();
            }
        }
    }

    private void bSU() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean em(long j) {
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

    private Location bSV() {
        if (ad.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
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
