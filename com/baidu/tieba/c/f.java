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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.c.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f hpN = null;
    private c hpO;
    private c hpP;
    private ArrayList<TransmitForumData> hpQ;
    private ArrayList<TransmitForumData> hpS;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean hpR = false;
    private boolean hpT = false;
    private boolean isLoading = false;

    public static f cdc() {
        if (hpN == null) {
            synchronized (f.class) {
                if (hpN == null) {
                    hpN = new f();
                }
            }
        }
        return hpN;
    }

    private f() {
        init();
    }

    private void init() {
        cde();
        cdd();
        this.isLoading = false;
    }

    private void cdd() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.hpP = (c) runTask.getData();
        }
        if (this.hpP != null) {
            this.hpP.a(this);
        }
    }

    private void cde() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.hpO = (c) runTask.getData();
        }
        if (this.hpO != null) {
            this.hpO.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = cdi();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.bpB()) {
                cdf();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void cdf() {
        this.isLoading = true;
        if (this.hpO != null) {
            this.hpO.ccZ();
        }
        if (this.hpP != null) {
            this.hpP.ccZ();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.hpS = arrayList;
            }
            this.hpT = true;
        } else if (i == 2) {
            if (z) {
                this.hpQ = arrayList;
                this.mPrivateThread = i2;
            }
            this.hpR = true;
        }
        cdg();
    }

    private void cdg() {
        if (this.hpO == null || this.hpR) {
            if (this.hpP == null || this.hpT) {
                this.hpR = false;
                this.hpT = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.hpQ)) {
                    Iterator<TransmitForumData> it = this.hpQ.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!ex(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.hpS)) {
                    Iterator<TransmitForumData> it2 = this.hpS.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!ex(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.hpQ = null;
                this.hpS = null;
                cdh();
            }
        }
    }

    private void cdh() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean ex(long j) {
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

    private Location cdi() {
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
