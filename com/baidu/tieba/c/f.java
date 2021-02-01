package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
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
import com.baidu.tieba.c.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f iDs = null;
    private c iDt;
    private c iDu;
    private ArrayList<TransmitForumData> iDv;
    private ArrayList<TransmitForumData> iDx;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean iDw = false;
    private boolean iDy = false;
    private boolean isLoading = false;

    public static f ctz() {
        if (iDs == null) {
            synchronized (f.class) {
                if (iDs == null) {
                    iDs = new f();
                }
            }
        }
        return iDs;
    }

    private f() {
        init();
    }

    private void init() {
        ctB();
        ctA();
        this.isLoading = false;
    }

    private void ctA() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.iDu = (c) runTask.getData();
        }
        if (this.iDu != null) {
            this.iDu.a(this);
        }
    }

    private void ctB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.iDt = (c) runTask.getData();
        }
        if (this.iDt != null) {
            this.iDt.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !l.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = ctF();
            }
            if (com.baidu.adp.lib.util.l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.bzg()) {
                ctC();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void ctC() {
        this.isLoading = true;
        if (this.iDt != null) {
            this.iDt.ctw();
        }
        if (this.iDu != null) {
            this.iDu.ctw();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.iDx = arrayList;
            }
            this.iDy = true;
        } else if (i == 2) {
            if (z) {
                this.iDv = arrayList;
                this.mPrivateThread = i2;
            }
            this.iDw = true;
        }
        ctD();
    }

    private void ctD() {
        if (this.iDt == null || this.iDw) {
            if (this.iDu == null || this.iDy) {
                this.iDw = false;
                this.iDy = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.iDv)) {
                    Iterator<TransmitForumData> it = this.iDv.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!gh(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.iDx)) {
                    Iterator<TransmitForumData> it2 = this.iDx.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!gh(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.iDv = null;
                this.iDx = null;
                ctE();
            }
        }
    }

    private void ctE() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean gh(long j) {
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

    private Location ctF() {
        if (ae.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
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
