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
/* loaded from: classes2.dex */
public class f implements c.a {
    private static f hpJ = null;
    private c hpK;
    private c hpL;
    private ArrayList<TransmitForumData> hpM;
    private ArrayList<TransmitForumData> hpO;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean hpN = false;
    private boolean hpP = false;
    private boolean isLoading = false;

    public static f cdb() {
        if (hpJ == null) {
            synchronized (f.class) {
                if (hpJ == null) {
                    hpJ = new f();
                }
            }
        }
        return hpJ;
    }

    private f() {
        init();
    }

    private void init() {
        cdd();
        cdc();
        this.isLoading = false;
    }

    private void cdc() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.hpL = (c) runTask.getData();
        }
        if (this.hpL != null) {
            this.hpL.a(this);
        }
    }

    private void cdd() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.hpK = (c) runTask.getData();
        }
        if (this.hpK != null) {
            this.hpK.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = cdh();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.bpA()) {
                cde();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void cde() {
        this.isLoading = true;
        if (this.hpK != null) {
            this.hpK.ccY();
        }
        if (this.hpL != null) {
            this.hpL.ccY();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.hpO = arrayList;
            }
            this.hpP = true;
        } else if (i == 2) {
            if (z) {
                this.hpM = arrayList;
                this.mPrivateThread = i2;
            }
            this.hpN = true;
        }
        cdf();
    }

    private void cdf() {
        if (this.hpK == null || this.hpN) {
            if (this.hpL == null || this.hpP) {
                this.hpN = false;
                this.hpP = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.hpM)) {
                    Iterator<TransmitForumData> it = this.hpM.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!ex(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.hpO)) {
                    Iterator<TransmitForumData> it2 = this.hpO.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!ex(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.hpM = null;
                this.hpO = null;
                cdg();
            }
        }
    }

    private void cdg() {
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

    private Location cdh() {
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
