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
    private static e eMo = null;
    private a eMp;
    private a eMq;
    private ArrayList<TransmitForumData> eMr;
    private ArrayList<TransmitForumData> eMt;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean eMs = false;
    private boolean eMu = false;
    private boolean isLoading = false;

    public static e bbD() {
        if (eMo == null) {
            synchronized (e.class) {
                if (eMo == null) {
                    eMo = new e();
                }
            }
        }
        return eMo;
    }

    private e() {
        init();
    }

    private void init() {
        bbF();
        bbE();
        this.isLoading = false;
    }

    private void bbE() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.eMq = (a) runTask.getData();
        }
        if (this.eMq != null) {
            this.eMq.a(this);
        }
    }

    private void bbF() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.eMp = (a) runTask.getData();
        }
        if (this.eMp != null) {
            this.eMp.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !i.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.ckN = bbJ();
            }
            if (l.kt() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bbG();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void bbG() {
        this.isLoading = true;
        if (this.eMp != null) {
            this.eMp.bbt();
        }
        if (this.eMq != null) {
            this.eMq.bbt();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0295a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.eMt = arrayList;
            }
            this.eMu = true;
        } else if (i == 2) {
            if (z) {
                this.eMr = arrayList;
                this.mPrivateThread = i2;
            }
            this.eMs = true;
        }
        bbH();
    }

    private void bbH() {
        if (this.eMp == null || this.eMs) {
            if (this.eMq == null || this.eMu) {
                this.eMs = false;
                this.eMu = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.aa(this.eMr)) {
                    Iterator<TransmitForumData> it = this.eMr.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!cK(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.aa(this.eMt)) {
                    Iterator<TransmitForumData> it2 = this.eMt.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!cK(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.eMr = null;
                this.eMt = null;
                bbI();
            }
        }
    }

    private void bbI() {
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

    private Location bbJ() {
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
