package com.baidu.tieba.d;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.d.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f ipV = null;
    private c ipW;
    private c ipX;
    private ArrayList<TransmitForumData> ipY;
    private ArrayList<TransmitForumData> iqa;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean ipZ = false;
    private boolean iqb = false;
    private boolean isLoading = false;

    public static f ctl() {
        if (ipV == null) {
            synchronized (f.class) {
                if (ipV == null) {
                    ipV = new f();
                }
            }
        }
        return ipV;
    }

    private f() {
        init();
    }

    private void init() {
        ctn();
        ctm();
        this.isLoading = false;
    }

    private void ctm() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.ipX = (c) runTask.getData();
        }
        if (this.ipX != null) {
            this.ipX.a(this);
        }
    }

    private void ctn() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.ipW = (c) runTask.getData();
        }
        if (this.ipW != null) {
            this.ipW.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !l.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = ctr();
            }
            if (com.baidu.adp.lib.util.l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.bAn()) {
                cto();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void cto() {
        this.isLoading = true;
        if (this.ipW != null) {
            this.ipW.cti();
        }
        if (this.ipX != null) {
            this.ipX.cti();
        }
    }

    @Override // com.baidu.tieba.d.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.iqa = arrayList;
            }
            this.iqb = true;
        } else if (i == 2) {
            if (z) {
                this.ipY = arrayList;
                this.mPrivateThread = i2;
            }
            this.ipZ = true;
        }
        ctp();
    }

    private void ctp() {
        if (this.ipW == null || this.ipZ) {
            if (this.ipX == null || this.iqb) {
                this.ipZ = false;
                this.iqb = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.ipY)) {
                    Iterator<TransmitForumData> it = this.ipY.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!gc(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.iqa)) {
                    Iterator<TransmitForumData> it2 = this.iqa.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!gc(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.ipY = null;
                this.iqa = null;
                ctq();
            }
        }
    }

    private void ctq() {
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

    private Location ctr() {
        if (ae.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
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
