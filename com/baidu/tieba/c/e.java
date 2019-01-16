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
    private static e dhV = null;
    private a dhW;
    private a dhX;
    private ArrayList<TransmitForumData> dhY;
    private ArrayList<TransmitForumData> dia;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean dhZ = false;
    private boolean dib = false;
    private boolean isLoading = false;

    public static e asB() {
        if (dhV == null) {
            synchronized (e.class) {
                if (dhV == null) {
                    dhV = new e();
                }
            }
        }
        return dhV;
    }

    private e() {
        init();
    }

    private void init() {
        asD();
        asC();
        this.isLoading = false;
    }

    private void asC() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.dhX = (a) runTask.getData();
        }
        if (this.dhX != null) {
            this.dhX.a(this);
        }
    }

    private void asD() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.dhW = (a) runTask.getData();
        }
        if (this.dhW != null) {
            this.dhW.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.aSO = asH();
            }
            if (l.ll() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                asE();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void asE() {
        this.isLoading = true;
        if (this.dhW != null) {
            this.dhW.asq();
        }
        if (this.dhX != null) {
            this.dhX.asq();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0205a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.dia = arrayList;
            }
            this.dib = true;
        } else if (i == 2) {
            if (z) {
                this.dhY = arrayList;
                this.mPrivateThread = i2;
            }
            this.dhZ = true;
        }
        asF();
    }

    private void asF() {
        if (this.dhW == null || this.dhZ) {
            if (this.dhX == null || this.dib) {
                this.dhZ = false;
                this.dib = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.I(this.dhY)) {
                    Iterator<TransmitForumData> it = this.dhY.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bI(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.I(this.dia)) {
                    Iterator<TransmitForumData> it2 = this.dia.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bI(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.dhY = null;
                this.dia = null;
                asG();
            }
        }
    }

    private void asG() {
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

    private Location asH() {
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
