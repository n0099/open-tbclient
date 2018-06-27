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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0138a {
    private static e cFP = null;
    private a cFQ;
    private a cFR;
    private ArrayList<TransmitForumData> cFS;
    private ArrayList<TransmitForumData> cFU;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean cFT = false;
    private boolean cFV = false;
    private boolean isLoading = false;

    public static e akp() {
        if (cFP == null) {
            synchronized (e.class) {
                if (cFP == null) {
                    cFP = new e();
                }
            }
        }
        return cFP;
    }

    private e() {
        init();
    }

    private void init() {
        akr();
        akq();
        this.isLoading = false;
    }

    private void akq() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.cFR = (a) runTask.getData();
        }
        if (this.cFR != null) {
            this.cFR.a(this);
        }
    }

    private void akr() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.cFQ = (a) runTask.getData();
        }
        if (this.cFQ != null) {
            this.cFQ.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.aGd = aku();
            }
            if (l.jU() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                this.isLoading = true;
                if (this.cFQ != null) {
                    this.cFQ.ake();
                }
                if (this.cFR != null) {
                    this.cFR.ake();
                }
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0138a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.cFU = arrayList;
            }
            this.cFV = true;
        } else if (i == 2) {
            if (z) {
                this.cFS = arrayList;
                this.mPrivateThread = i2;
            }
            this.cFT = true;
        }
        aks();
    }

    private void aks() {
        if (this.cFQ == null || this.cFT) {
            if (this.cFR == null || this.cFV) {
                this.cFT = false;
                this.cFV = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!w.A(this.cFS)) {
                    Iterator<TransmitForumData> it = this.cFS.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bl(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!w.A(this.cFU)) {
                    Iterator<TransmitForumData> it2 = this.cFU.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bl(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.cFS = null;
                this.cFU = null;
                akt();
            }
        }
    }

    private void akt() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean bl(long j) {
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

    private Location aku() {
        if (ac.aM(TbadkCoreApplication.getInst())) {
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
