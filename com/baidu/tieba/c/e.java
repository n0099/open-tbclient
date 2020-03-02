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
    private static e fPI = null;
    private a fPJ;
    private a fPK;
    private ArrayList<TransmitForumData> fPL;
    private ArrayList<TransmitForumData> fPN;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean fPM = false;
    private boolean fPO = false;
    private boolean isLoading = false;

    public static e bwm() {
        if (fPI == null) {
            synchronized (e.class) {
                if (fPI == null) {
                    fPI = new e();
                }
            }
        }
        return fPI;
    }

    private e() {
        init();
    }

    private void init() {
        bwo();
        bwn();
        this.isLoading = false;
    }

    private void bwn() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.fPK = (a) runTask.getData();
        }
        if (this.fPK != null) {
            this.fPK.a(this);
        }
    }

    private void bwo() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.fPJ = (a) runTask.getData();
        }
        if (this.fPJ != null) {
            this.fPJ.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = bws();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bwp();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bwp() {
        this.isLoading = true;
        if (this.fPJ != null) {
            this.fPJ.bwf();
        }
        if (this.fPK != null) {
            this.fPK.bwf();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0489a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.fPN = arrayList;
            }
            this.fPO = true;
        } else if (i == 2) {
            if (z) {
                this.fPL = arrayList;
                this.mPrivateThread = i2;
            }
            this.fPM = true;
        }
        bwq();
    }

    private void bwq() {
        if (this.fPJ == null || this.fPM) {
            if (this.fPK == null || this.fPO) {
                this.fPM = false;
                this.fPO = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.fPL)) {
                    Iterator<TransmitForumData> it = this.fPL.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!dn(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.fPN)) {
                    Iterator<TransmitForumData> it2 = this.fPN.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!dn(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.fPL = null;
                this.fPN = null;
                bwr();
            }
        }
    }

    private void bwr() {
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

    private Location bws() {
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
