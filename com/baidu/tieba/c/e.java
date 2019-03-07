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
public class e implements a.InterfaceC0234a {
    private static e erV = null;
    private a erW;
    private a erX;
    private ArrayList<TransmitForumData> erY;
    private ArrayList<TransmitForumData> esa;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean erZ = false;
    private boolean esb = false;
    private boolean isLoading = false;

    public static e aSt() {
        if (erV == null) {
            synchronized (e.class) {
                if (erV == null) {
                    erV = new e();
                }
            }
        }
        return erV;
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
            this.erX = (a) runTask.getData();
        }
        if (this.erX != null) {
            this.erX.a(this);
        }
    }

    private void aSv() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.erW = (a) runTask.getData();
        }
        if (this.erW != null) {
            this.erW.a(this);
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
        if (this.erW != null) {
            this.erW.aSi();
        }
        if (this.erX != null) {
            this.erX.aSi();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0234a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.esa = arrayList;
            }
            this.esb = true;
        } else if (i == 2) {
            if (z) {
                this.erY = arrayList;
                this.mPrivateThread = i2;
            }
            this.erZ = true;
        }
        aSx();
    }

    private void aSx() {
        if (this.erW == null || this.erZ) {
            if (this.erX == null || this.esb) {
                this.erZ = false;
                this.esb = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.T(this.erY)) {
                    Iterator<TransmitForumData> it = this.erY.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!ci(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.T(this.esa)) {
                    Iterator<TransmitForumData> it2 = this.esa.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!ci(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.erY = null;
                this.esa = null;
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
