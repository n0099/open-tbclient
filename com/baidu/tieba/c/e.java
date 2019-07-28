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
public class e implements a.InterfaceC0295a {
    private static e eMh = null;
    private a eMi;
    private a eMj;
    private ArrayList<TransmitForumData> eMk;
    private ArrayList<TransmitForumData> eMm;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean eMl = false;
    private boolean eMn = false;
    private boolean isLoading = false;

    public static e bbB() {
        if (eMh == null) {
            synchronized (e.class) {
                if (eMh == null) {
                    eMh = new e();
                }
            }
        }
        return eMh;
    }

    private e() {
        init();
    }

    private void init() {
        bbD();
        bbC();
        this.isLoading = false;
    }

    private void bbC() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.eMj = (a) runTask.getData();
        }
        if (this.eMj != null) {
            this.eMj.a(this);
        }
    }

    private void bbD() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.eMi = (a) runTask.getData();
        }
        if (this.eMi != null) {
            this.eMi.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !i.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.ckG = bbH();
            }
            if (l.kt() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bbE();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void bbE() {
        this.isLoading = true;
        if (this.eMi != null) {
            this.eMi.bbr();
        }
        if (this.eMj != null) {
            this.eMj.bbr();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0295a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.eMm = arrayList;
            }
            this.eMn = true;
        } else if (i == 2) {
            if (z) {
                this.eMk = arrayList;
                this.mPrivateThread = i2;
            }
            this.eMl = true;
        }
        bbF();
    }

    private void bbF() {
        if (this.eMi == null || this.eMl) {
            if (this.eMj == null || this.eMn) {
                this.eMl = false;
                this.eMn = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.aa(this.eMk)) {
                    Iterator<TransmitForumData> it = this.eMk.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!cK(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.aa(this.eMm)) {
                    Iterator<TransmitForumData> it2 = this.eMm.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!cK(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.eMk = null;
                this.eMm = null;
                bbG();
            }
        }
    }

    private void bbG() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean cK(long j) {
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

    private Location bbH() {
        if (ab.cx(TbadkCoreApplication.getInst())) {
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
