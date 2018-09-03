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
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0136a {
    private static e cIt = null;
    private a cIu;
    private a cIv;
    private ArrayList<TransmitForumData> cIw;
    private ArrayList<TransmitForumData> cIy;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean cIx = false;
    private boolean cIz = false;
    private boolean isLoading = false;

    public static e akQ() {
        if (cIt == null) {
            synchronized (e.class) {
                if (cIt == null) {
                    cIt = new e();
                }
            }
        }
        return cIt;
    }

    private e() {
        init();
    }

    private void init() {
        akS();
        akR();
        this.isLoading = false;
    }

    private void akR() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.cIv = (a) runTask.getData();
        }
        if (this.cIv != null) {
            this.cIv.a(this);
        }
    }

    private void akS() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.cIu = (a) runTask.getData();
        }
        if (this.cIu != null) {
            this.cIu.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !com.baidu.tbadk.util.f.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.aGc = akV();
            }
            if (l.jV() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                this.isLoading = true;
                if (this.cIu != null) {
                    this.cIu.akF();
                }
                if (this.cIv != null) {
                    this.cIv.akF();
                }
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0136a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.cIy = arrayList;
            }
            this.cIz = true;
        } else if (i == 2) {
            if (z) {
                this.cIw = arrayList;
                this.mPrivateThread = i2;
            }
            this.cIx = true;
        }
        akT();
    }

    private void akT() {
        if (this.cIu == null || this.cIx) {
            if (this.cIv == null || this.cIz) {
                this.cIx = false;
                this.cIz = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!w.z(this.cIw)) {
                    Iterator<TransmitForumData> it = this.cIw.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bp(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!w.z(this.cIy)) {
                    Iterator<TransmitForumData> it2 = this.cIy.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bp(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.cIw = null;
                this.cIy = null;
                akU();
            }
        }
    }

    private void akU() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean bp(long j) {
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

    private Location akV() {
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
