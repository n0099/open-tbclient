package com.baidu.tieba.d;

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
import com.baidu.tieba.d.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0124a {
    private static d cyb = null;
    private a cyc;
    private a cyd;
    private ArrayList<TransmitForumData> cye;
    private ArrayList<TransmitForumData> cyg;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean cyf = false;
    private boolean cyh = false;
    private boolean isLoading = false;

    public static d ahh() {
        if (cyb == null) {
            synchronized (d.class) {
                if (cyb == null) {
                    cyb = new d();
                }
            }
        }
        return cyb;
    }

    private d() {
        init();
    }

    private void init() {
        ahj();
        ahi();
        this.isLoading = false;
    }

    private void ahi() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.cyd = (a) runTask.getData();
        }
        if (this.cyd != null) {
            this.cyd.a(this);
        }
    }

    private void ahj() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.cyc = (a) runTask.getData();
        }
        if (this.cyc != null) {
            this.cyc.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.awW = ahm();
            }
            if (l.hg() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                this.isLoading = true;
                if (this.cyc != null) {
                    this.cyc.ahc();
                }
                if (this.cyd != null) {
                    this.cyd.ahc();
                }
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0124a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.cyg = arrayList;
            }
            this.cyh = true;
        } else if (i == 2) {
            if (z) {
                this.cye = arrayList;
                this.mPrivateThread = i2;
            }
            this.cyf = true;
        }
        ahk();
    }

    private void ahk() {
        if (this.cyc == null || this.cyf) {
            if (this.cyd == null || this.cyh) {
                this.cyf = false;
                this.cyh = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.w(this.cye)) {
                    Iterator<TransmitForumData> it = this.cye.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bn(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.w(this.cyg)) {
                    Iterator<TransmitForumData> it2 = this.cyg.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bn(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.cye = null;
                this.cyg = null;
                ahl();
            }
        }
    }

    private void ahl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean bn(long j) {
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

    private Location ahm() {
        if (ab.aC(TbadkCoreApplication.getInst())) {
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
