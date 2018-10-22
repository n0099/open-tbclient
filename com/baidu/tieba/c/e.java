package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0170a {
    private static e cWB = null;
    private a cWC;
    private a cWD;
    private ArrayList<TransmitForumData> cWE;
    private ArrayList<TransmitForumData> cWG;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean cWF = false;
    private boolean cWH = false;
    private boolean isLoading = false;

    public static e aqb() {
        if (cWB == null) {
            synchronized (e.class) {
                if (cWB == null) {
                    cWB = new e();
                }
            }
        }
        return cWB;
    }

    private e() {
        init();
    }

    private void init() {
        aqd();
        aqc();
        this.isLoading = false;
    }

    private void aqc() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.cWD = (a) runTask.getData();
        }
        if (this.cWD != null) {
            this.cWD.a(this);
        }
    }

    private void aqd() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.cWC = (a) runTask.getData();
        }
        if (this.cWC != null) {
            this.cWC.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.aNS = aqh();
            }
            if (l.lo() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                aqe();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void aqe() {
        this.isLoading = true;
        if (this.cWC != null) {
            this.cWC.apQ();
        }
        if (this.cWD != null) {
            this.cWD.apQ();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0170a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.cWG = arrayList;
            }
            this.cWH = true;
        } else if (i == 2) {
            if (z) {
                this.cWE = arrayList;
                this.mPrivateThread = i2;
            }
            this.cWF = true;
        }
        aqf();
    }

    private void aqf() {
        if (this.cWC == null || this.cWF) {
            if (this.cWD == null || this.cWH) {
                this.cWF = false;
                this.cWH = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.J(this.cWE)) {
                    Iterator<TransmitForumData> it = this.cWE.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bA(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.J(this.cWG)) {
                    Iterator<TransmitForumData> it2 = this.cWG.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bA(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.cWE = null;
                this.cWG = null;
                aqg();
            }
        }
    }

    private void aqg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean bA(long j) {
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

    private Location aqh() {
        if (ab.bB(TbadkCoreApplication.getInst())) {
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
