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
public class e implements a.InterfaceC0205a {
    private static e dhj = null;
    private a dhk;
    private a dhl;
    private ArrayList<TransmitForumData> dhm;
    private ArrayList<TransmitForumData> dho;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean dhn = false;
    private boolean dhp = false;
    private boolean isLoading = false;

    public static e asd() {
        if (dhj == null) {
            synchronized (e.class) {
                if (dhj == null) {
                    dhj = new e();
                }
            }
        }
        return dhj;
    }

    private e() {
        init();
    }

    private void init() {
        asf();
        ase();
        this.isLoading = false;
    }

    private void ase() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.dhl = (a) runTask.getData();
        }
        if (this.dhl != null) {
            this.dhl.a(this);
        }
    }

    private void asf() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.dhk = (a) runTask.getData();
        }
        if (this.dhk != null) {
            this.dhk.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.aSj = asj();
            }
            if (l.ll() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                asg();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void asg() {
        this.isLoading = true;
        if (this.dhk != null) {
            this.dhk.arS();
        }
        if (this.dhl != null) {
            this.dhl.arS();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0205a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.dho = arrayList;
            }
            this.dhp = true;
        } else if (i == 2) {
            if (z) {
                this.dhm = arrayList;
                this.mPrivateThread = i2;
            }
            this.dhn = true;
        }
        ash();
    }

    private void ash() {
        if (this.dhk == null || this.dhn) {
            if (this.dhl == null || this.dhp) {
                this.dhn = false;
                this.dhp = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.I(this.dhm)) {
                    Iterator<TransmitForumData> it = this.dhm.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bI(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.I(this.dho)) {
                    Iterator<TransmitForumData> it2 = this.dho.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bI(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.dhm = null;
                this.dho = null;
                asi();
            }
        }
    }

    private void asi() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean bI(long j) {
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

    private Location asj() {
        if (ab.bC(TbadkCoreApplication.getInst())) {
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
