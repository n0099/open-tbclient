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
    private static e erE = null;
    private a erF;
    private a erG;
    private ArrayList<TransmitForumData> erH;
    private ArrayList<TransmitForumData> erJ;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean erI = false;
    private boolean erK = false;
    private boolean isLoading = false;

    public static e aSr() {
        if (erE == null) {
            synchronized (e.class) {
                if (erE == null) {
                    erE = new e();
                }
            }
        }
        return erE;
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
            this.erG = (a) runTask.getData();
        }
        if (this.erG != null) {
            this.erG.a(this);
        }
    }

    private void aSt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.erF = (a) runTask.getData();
        }
        if (this.erF != null) {
            this.erF.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !i.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.cbz = aSx();
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
        if (this.erF != null) {
            this.erF.aSg();
        }
        if (this.erG != null) {
            this.erG.aSg();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0273a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.erJ = arrayList;
            }
            this.erK = true;
        } else if (i == 2) {
            if (z) {
                this.erH = arrayList;
                this.mPrivateThread = i2;
            }
            this.erI = true;
        }
        aSv();
    }

    private void aSv() {
        if (this.erF == null || this.erI) {
            if (this.erG == null || this.erK) {
                this.erI = false;
                this.erK = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.T(this.erH)) {
                    Iterator<TransmitForumData> it = this.erH.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!ci(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.T(this.erJ)) {
                    Iterator<TransmitForumData> it2 = this.erJ.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!ci(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.erH = null;
                this.erJ = null;
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
