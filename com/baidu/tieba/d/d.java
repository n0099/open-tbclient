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
    private static d cye = null;
    private a cyf;
    private a cyg;
    private ArrayList<TransmitForumData> cyh;
    private ArrayList<TransmitForumData> cyj;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean cyi = false;
    private boolean cyk = false;
    private boolean isLoading = false;

    public static d ahh() {
        if (cye == null) {
            synchronized (d.class) {
                if (cye == null) {
                    cye = new d();
                }
            }
        }
        return cye;
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
            this.cyg = (a) runTask.getData();
        }
        if (this.cyg != null) {
            this.cyg.a(this);
        }
    }

    private void ahj() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.cyf = (a) runTask.getData();
        }
        if (this.cyf != null) {
            this.cyf.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.awW = ahm();
            }
            if (l.hg() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                this.isLoading = true;
                if (this.cyf != null) {
                    this.cyf.ahc();
                }
                if (this.cyg != null) {
                    this.cyg.ahc();
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
                this.cyj = arrayList;
            }
            this.cyk = true;
        } else if (i == 2) {
            if (z) {
                this.cyh = arrayList;
                this.mPrivateThread = i2;
            }
            this.cyi = true;
        }
        ahk();
    }

    private void ahk() {
        if (this.cyf == null || this.cyi) {
            if (this.cyg == null || this.cyk) {
                this.cyi = false;
                this.cyk = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.w(this.cyh)) {
                    Iterator<TransmitForumData> it = this.cyh.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bn(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.w(this.cyj)) {
                    Iterator<TransmitForumData> it2 = this.cyj.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bn(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.cyh = null;
                this.cyj = null;
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
