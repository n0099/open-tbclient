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
public class e implements a.InterfaceC0195a {
    private static e cXH = null;
    private a cXI;
    private a cXJ;
    private ArrayList<TransmitForumData> cXK;
    private ArrayList<TransmitForumData> cXM;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean cXL = false;
    private boolean cXN = false;
    private boolean isLoading = false;

    public static e apC() {
        if (cXH == null) {
            synchronized (e.class) {
                if (cXH == null) {
                    cXH = new e();
                }
            }
        }
        return cXH;
    }

    private e() {
        init();
    }

    private void init() {
        apE();
        apD();
        this.isLoading = false;
    }

    private void apD() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.cXJ = (a) runTask.getData();
        }
        if (this.cXJ != null) {
            this.cXJ.a(this);
        }
    }

    private void apE() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.cXI = (a) runTask.getData();
        }
        if (this.cXI != null) {
            this.cXI.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.aOI = apI();
            }
            if (l.lm() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                apF();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void apF() {
        this.isLoading = true;
        if (this.cXI != null) {
            this.cXI.apr();
        }
        if (this.cXJ != null) {
            this.cXJ.apr();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0195a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.cXM = arrayList;
            }
            this.cXN = true;
        } else if (i == 2) {
            if (z) {
                this.cXK = arrayList;
                this.mPrivateThread = i2;
            }
            this.cXL = true;
        }
        apG();
    }

    private void apG() {
        if (this.cXI == null || this.cXL) {
            if (this.cXJ == null || this.cXN) {
                this.cXL = false;
                this.cXN = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.I(this.cXK)) {
                    Iterator<TransmitForumData> it = this.cXK.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bw(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.I(this.cXM)) {
                    Iterator<TransmitForumData> it2 = this.cXM.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bw(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.cXK = null;
                this.cXM = null;
                apH();
            }
        }
    }

    private void apH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean bw(long j) {
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

    private Location apI() {
        if (ab.bz(TbadkCoreApplication.getInst())) {
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
