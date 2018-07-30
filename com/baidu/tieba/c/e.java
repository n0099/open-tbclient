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
    private static e cIw = null;
    private ArrayList<TransmitForumData> cIB;
    private a cIx;
    private a cIy;
    private ArrayList<TransmitForumData> cIz;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean cIA = false;
    private boolean cIC = false;
    private boolean isLoading = false;

    public static e akO() {
        if (cIw == null) {
            synchronized (e.class) {
                if (cIw == null) {
                    cIw = new e();
                }
            }
        }
        return cIw;
    }

    private e() {
        init();
    }

    private void init() {
        akQ();
        akP();
        this.isLoading = false;
    }

    private void akP() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.cIy = (a) runTask.getData();
        }
        if (this.cIy != null) {
            this.cIy.a(this);
        }
    }

    private void akQ() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.cIx = (a) runTask.getData();
        }
        if (this.cIx != null) {
            this.cIx.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !com.baidu.tbadk.util.f.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.aGd = akT();
            }
            if (l.jV() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                this.isLoading = true;
                if (this.cIx != null) {
                    this.cIx.akD();
                }
                if (this.cIy != null) {
                    this.cIy.akD();
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
                this.cIB = arrayList;
            }
            this.cIC = true;
        } else if (i == 2) {
            if (z) {
                this.cIz = arrayList;
                this.mPrivateThread = i2;
            }
            this.cIA = true;
        }
        akR();
    }

    private void akR() {
        if (this.cIx == null || this.cIA) {
            if (this.cIy == null || this.cIC) {
                this.cIA = false;
                this.cIC = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!w.z(this.cIz)) {
                    Iterator<TransmitForumData> it = this.cIz.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bp(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!w.z(this.cIB)) {
                    Iterator<TransmitForumData> it2 = this.cIB.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bp(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.cIz = null;
                this.cIB = null;
                akS();
            }
        }
    }

    private void akS() {
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

    private Location akT() {
        if (ac.aN(TbadkCoreApplication.getInst())) {
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
