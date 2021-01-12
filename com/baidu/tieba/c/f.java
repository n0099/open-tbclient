package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.c.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f ixI = null;
    private c ixJ;
    private c ixK;
    private ArrayList<TransmitForumData> ixL;
    private ArrayList<TransmitForumData> ixN;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean ixM = false;
    private boolean ixO = false;
    private boolean isLoading = false;

    public static f csn() {
        if (ixI == null) {
            synchronized (f.class) {
                if (ixI == null) {
                    ixI = new f();
                }
            }
        }
        return ixI;
    }

    private f() {
        init();
    }

    private void init() {
        csp();
        cso();
        this.isLoading = false;
    }

    private void cso() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.ixK = (c) runTask.getData();
        }
        if (this.ixK != null) {
            this.ixK.a(this);
        }
    }

    private void csp() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.ixJ = (c) runTask.getData();
        }
        if (this.ixJ != null) {
            this.ixJ.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = cst();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.byO()) {
                csq();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void csq() {
        this.isLoading = true;
        if (this.ixJ != null) {
            this.ixJ.csk();
        }
        if (this.ixK != null) {
            this.ixK.csk();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.ixN = arrayList;
            }
            this.ixO = true;
        } else if (i == 2) {
            if (z) {
                this.ixL = arrayList;
                this.mPrivateThread = i2;
            }
            this.ixM = true;
        }
        csr();
    }

    private void csr() {
        if (this.ixJ == null || this.ixM) {
            if (this.ixK == null || this.ixO) {
                this.ixM = false;
                this.ixO = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!x.isEmpty(this.ixL)) {
                    Iterator<TransmitForumData> it = this.ixL.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!gc(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!x.isEmpty(this.ixN)) {
                    Iterator<TransmitForumData> it2 = this.ixN.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!gc(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.ixL = null;
                this.ixN = null;
                css();
            }
        }
    }

    private void css() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean gc(long j) {
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

    private Location cst() {
        if (ad.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
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
