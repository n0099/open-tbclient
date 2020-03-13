package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0489a {
    private static e fPV = null;
    private a fPW;
    private a fPX;
    private ArrayList<TransmitForumData> fPY;
    private ArrayList<TransmitForumData> fQa;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean fPZ = false;
    private boolean fQb = false;
    private boolean isLoading = false;

    public static e bwn() {
        if (fPV == null) {
            synchronized (e.class) {
                if (fPV == null) {
                    fPV = new e();
                }
            }
        }
        return fPV;
    }

    private e() {
        init();
    }

    private void init() {
        bwp();
        bwo();
        this.isLoading = false;
    }

    private void bwo() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.fPX = (a) runTask.getData();
        }
        if (this.fPX != null) {
            this.fPX.a(this);
        }
    }

    private void bwp() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.fPW = (a) runTask.getData();
        }
        if (this.fPW != null) {
            this.fPW.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = bwt();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bwq();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bwq() {
        this.isLoading = true;
        if (this.fPW != null) {
            this.fPW.bwg();
        }
        if (this.fPX != null) {
            this.fPX.bwg();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0489a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.fQa = arrayList;
            }
            this.fQb = true;
        } else if (i == 2) {
            if (z) {
                this.fPY = arrayList;
                this.mPrivateThread = i2;
            }
            this.fPZ = true;
        }
        bwr();
    }

    private void bwr() {
        if (this.fPW == null || this.fPZ) {
            if (this.fPX == null || this.fQb) {
                this.fPZ = false;
                this.fQb = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.fPY)) {
                    Iterator<TransmitForumData> it = this.fPY.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!dn(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.fQa)) {
                    Iterator<TransmitForumData> it2 = this.fQa.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!dn(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.fPY = null;
                this.fQa = null;
                bws();
            }
        }
    }

    private void bws() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean dn(long j) {
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

    private Location bwt() {
        if (ab.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
            LocationManager locationManager = (LocationManager) TbadkCoreApplication.getInst().getSystemService("location");
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
