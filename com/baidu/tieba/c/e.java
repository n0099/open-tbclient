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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0489a {
    private static e fQD = null;
    private a fQE;
    private a fQF;
    private ArrayList<TransmitForumData> fQG;
    private ArrayList<TransmitForumData> fQI;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean fQH = false;
    private boolean fQJ = false;
    private boolean isLoading = false;

    public static e bws() {
        if (fQD == null) {
            synchronized (e.class) {
                if (fQD == null) {
                    fQD = new e();
                }
            }
        }
        return fQD;
    }

    private e() {
        init();
    }

    private void init() {
        bwu();
        bwt();
        this.isLoading = false;
    }

    private void bwt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.fQF = (a) runTask.getData();
        }
        if (this.fQF != null) {
            this.fQF.a(this);
        }
    }

    private void bwu() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.fQE = (a) runTask.getData();
        }
        if (this.fQE != null) {
            this.fQE.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = bwy();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bwv();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bwv() {
        this.isLoading = true;
        if (this.fQE != null) {
            this.fQE.bwl();
        }
        if (this.fQF != null) {
            this.fQF.bwl();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0489a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.fQI = arrayList;
            }
            this.fQJ = true;
        } else if (i == 2) {
            if (z) {
                this.fQG = arrayList;
                this.mPrivateThread = i2;
            }
            this.fQH = true;
        }
        bww();
    }

    private void bww() {
        if (this.fQE == null || this.fQH) {
            if (this.fQF == null || this.fQJ) {
                this.fQH = false;
                this.fQJ = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.fQG)) {
                    Iterator<TransmitForumData> it = this.fQG.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!dn(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.fQI)) {
                    Iterator<TransmitForumData> it2 = this.fQI.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!dn(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.fQG = null;
                this.fQI = null;
                bwx();
            }
        }
    }

    private void bwx() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean dn(long j) {
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

    private Location bwy() {
        if (ab.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
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
