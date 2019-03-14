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
import com.baidu.tbadk.util.i;
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0273a {
    private static e erR = null;
    private a erS;
    private a erT;
    private ArrayList<TransmitForumData> erU;
    private ArrayList<TransmitForumData> erW;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean erV = false;
    private boolean erX = false;
    private boolean isLoading = false;

    public static e aSt() {
        if (erR == null) {
            synchronized (e.class) {
                if (erR == null) {
                    erR = new e();
                }
            }
        }
        return erR;
    }

    private e() {
        init();
    }

    private void init() {
        aSv();
        aSu();
        this.isLoading = false;
    }

    private void aSu() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.erT = (a) runTask.getData();
        }
        if (this.erT != null) {
            this.erT.a(this);
        }
    }

    private void aSv() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.erS = (a) runTask.getData();
        }
        if (this.erS != null) {
            this.erS.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !i.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.cbw = aSz();
            }
            if (l.lo() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                aSw();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void aSw() {
        this.isLoading = true;
        if (this.erS != null) {
            this.erS.aSi();
        }
        if (this.erT != null) {
            this.erT.aSi();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0273a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.erW = arrayList;
            }
            this.erX = true;
        } else if (i == 2) {
            if (z) {
                this.erU = arrayList;
                this.mPrivateThread = i2;
            }
            this.erV = true;
        }
        aSx();
    }

    private void aSx() {
        if (this.erS == null || this.erV) {
            if (this.erT == null || this.erX) {
                this.erV = false;
                this.erX = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.T(this.erU)) {
                    Iterator<TransmitForumData> it = this.erU.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!ci(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.T(this.erW)) {
                    Iterator<TransmitForumData> it2 = this.erW.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!ci(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.erU = null;
                this.erW = null;
                aSy();
            }
        }
    }

    private void aSy() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean ci(long j) {
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

    private Location aSz() {
        if (ab.cR(TbadkCoreApplication.getInst())) {
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
