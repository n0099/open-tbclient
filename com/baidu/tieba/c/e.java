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
    private static e erD = null;
    private a erE;
    private a erF;
    private ArrayList<TransmitForumData> erG;
    private ArrayList<TransmitForumData> erI;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean erH = false;
    private boolean erJ = false;
    private boolean isLoading = false;

    public static e aSr() {
        if (erD == null) {
            synchronized (e.class) {
                if (erD == null) {
                    erD = new e();
                }
            }
        }
        return erD;
    }

    private e() {
        init();
    }

    private void init() {
        aSt();
        aSs();
        this.isLoading = false;
    }

    private void aSs() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.erF = (a) runTask.getData();
        }
        if (this.erF != null) {
            this.erF.a(this);
        }
    }

    private void aSt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.erE = (a) runTask.getData();
        }
        if (this.erE != null) {
            this.erE.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !i.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.cby = aSx();
            }
            if (l.lo() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                aSu();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void aSu() {
        this.isLoading = true;
        if (this.erE != null) {
            this.erE.aSg();
        }
        if (this.erF != null) {
            this.erF.aSg();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0273a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.erI = arrayList;
            }
            this.erJ = true;
        } else if (i == 2) {
            if (z) {
                this.erG = arrayList;
                this.mPrivateThread = i2;
            }
            this.erH = true;
        }
        aSv();
    }

    private void aSv() {
        if (this.erE == null || this.erH) {
            if (this.erF == null || this.erJ) {
                this.erH = false;
                this.erJ = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.T(this.erG)) {
                    Iterator<TransmitForumData> it = this.erG.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!ci(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.T(this.erI)) {
                    Iterator<TransmitForumData> it2 = this.erI.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!ci(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.erG = null;
                this.erI = null;
                aSw();
            }
        }
    }

    private void aSw() {
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

    private Location aSx() {
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
