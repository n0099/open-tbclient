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
public class d implements a.InterfaceC0139a {
    private static d dgq = null;
    private a dgr;
    private a dgs;
    private ArrayList<TransmitForumData> dgt;
    private ArrayList<TransmitForumData> dgv;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean dgu = false;
    private boolean dgw = false;
    private boolean isLoading = false;

    public static d anj() {
        if (dgq == null) {
            synchronized (d.class) {
                if (dgq == null) {
                    dgq = new d();
                }
            }
        }
        return dgq;
    }

    private d() {
        init();
    }

    private void init() {
        anl();
        ank();
        this.isLoading = false;
    }

    private void ank() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.dgs = (a) runTask.getData();
        }
        if (this.dgs != null) {
            this.dgs.a(this);
        }
    }

    private void anl() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.dgr = (a) runTask.getData();
        }
        if (this.dgr != null) {
            this.dgr.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.bls = ano();
            }
            if (l.pa() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                this.isLoading = true;
                if (this.dgr != null) {
                    this.dgr.ane();
                }
                if (this.dgs != null) {
                    this.dgs.ane();
                }
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0139a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.dgv = arrayList;
            }
            this.dgw = true;
        } else if (i == 2) {
            if (z) {
                this.dgt = arrayList;
                this.mPrivateThread = i2;
            }
            this.dgu = true;
        }
        anm();
    }

    private void anm() {
        if (this.dgr == null || this.dgu) {
            if (this.dgs == null || this.dgw) {
                this.dgu = false;
                this.dgw = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.E(this.dgt)) {
                    Iterator<TransmitForumData> it = this.dgt.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bp(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.E(this.dgv)) {
                    Iterator<TransmitForumData> it2 = this.dgv.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bp(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.dgt = null;
                this.dgv = null;
                ann();
            }
        }
    }

    private void ann() {
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

    private Location ano() {
        if (ab.aS(TbadkCoreApplication.getInst())) {
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
