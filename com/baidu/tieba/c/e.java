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
    private static e fPG = null;
    private a fPH;
    private a fPI;
    private ArrayList<TransmitForumData> fPJ;
    private ArrayList<TransmitForumData> fPL;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean fPK = false;
    private boolean fPM = false;
    private boolean isLoading = false;

    public static e bwk() {
        if (fPG == null) {
            synchronized (e.class) {
                if (fPG == null) {
                    fPG = new e();
                }
            }
        }
        return fPG;
    }

    private e() {
        init();
    }

    private void init() {
        bwm();
        bwl();
        this.isLoading = false;
    }

    private void bwl() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.fPI = (a) runTask.getData();
        }
        if (this.fPI != null) {
            this.fPI.a(this);
        }
    }

    private void bwm() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.fPH = (a) runTask.getData();
        }
        if (this.fPH != null) {
            this.fPH.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = bwq();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bwn();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bwn() {
        this.isLoading = true;
        if (this.fPH != null) {
            this.fPH.bwd();
        }
        if (this.fPI != null) {
            this.fPI.bwd();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0489a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.fPL = arrayList;
            }
            this.fPM = true;
        } else if (i == 2) {
            if (z) {
                this.fPJ = arrayList;
                this.mPrivateThread = i2;
            }
            this.fPK = true;
        }
        bwo();
    }

    private void bwo() {
        if (this.fPH == null || this.fPK) {
            if (this.fPI == null || this.fPM) {
                this.fPK = false;
                this.fPM = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.fPJ)) {
                    Iterator<TransmitForumData> it = this.fPJ.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!dn(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.fPL)) {
                    Iterator<TransmitForumData> it2 = this.fPL.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!dn(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.fPJ = null;
                this.fPL = null;
                bwp();
            }
        }
    }

    private void bwp() {
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

    private Location bwq() {
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
