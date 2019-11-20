package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
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
import com.baidu.tbadk.util.i;
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0393a {
    private static e eVv = null;
    private ArrayList<TransmitForumData> eVA;
    private a eVw;
    private a eVx;
    private ArrayList<TransmitForumData> eVy;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean eVz = false;
    private boolean eVB = false;
    private boolean isLoading = false;

    public static e bch() {
        if (eVv == null) {
            synchronized (e.class) {
                if (eVv == null) {
                    eVv = new e();
                }
            }
        }
        return eVv;
    }

    private e() {
        init();
    }

    private void init() {
        bcj();
        bci();
        this.isLoading = false;
    }

    private void bci() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.eVx = (a) runTask.getData();
        }
        if (this.eVx != null) {
            this.eVx.a(this);
        }
    }

    private void bcj() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.eVw = (a) runTask.getData();
        }
        if (this.eVw != null) {
            this.eVw.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !i.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.cxR = bcn();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bck();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bck() {
        this.isLoading = true;
        if (this.eVw != null) {
            this.eVw.bca();
        }
        if (this.eVx != null) {
            this.eVx.bca();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0393a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.eVA = arrayList;
            }
            this.eVB = true;
        } else if (i == 2) {
            if (z) {
                this.eVy = arrayList;
                this.mPrivateThread = i2;
            }
            this.eVz = true;
        }
        bcl();
    }

    private void bcl() {
        if (this.eVw == null || this.eVz) {
            if (this.eVx == null || this.eVB) {
                this.eVz = false;
                this.eVB = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.eVy)) {
                    Iterator<TransmitForumData> it = this.eVy.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!cA(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.eVA)) {
                    Iterator<TransmitForumData> it2 = this.eVA.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!cA(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.eVy = null;
                this.eVA = null;
                bcm();
            }
        }
    }

    private void bcm() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean cA(long j) {
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

    private Location bcn() {
        if (ab.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
            LocationManager locationManager = (LocationManager) TbadkCoreApplication.getInst().getSystemService(Headers.LOCATION);
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
