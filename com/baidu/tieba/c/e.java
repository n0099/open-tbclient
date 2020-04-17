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
public class e implements a.InterfaceC0525a {
    private static e gvl = null;
    private a gvm;
    private a gvn;
    private ArrayList<TransmitForumData> gvo;
    private ArrayList<TransmitForumData> gvq;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean gvp = false;
    private boolean gvr = false;
    private boolean isLoading = false;

    public static e bGe() {
        if (gvl == null) {
            synchronized (e.class) {
                if (gvl == null) {
                    gvl = new e();
                }
            }
        }
        return gvl;
    }

    private e() {
        init();
    }

    private void init() {
        bGg();
        bGf();
        this.isLoading = false;
    }

    private void bGf() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.gvn = (a) runTask.getData();
        }
        if (this.gvn != null) {
            this.gvn.a(this);
        }
    }

    private void bGg() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.gvm = (a) runTask.getData();
        }
        if (this.gvm != null) {
            this.gvm.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = bGk();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bGh();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bGh() {
        this.isLoading = true;
        if (this.gvm != null) {
            this.gvm.bFW();
        }
        if (this.gvn != null) {
            this.gvn.bFW();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0525a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.gvq = arrayList;
            }
            this.gvr = true;
        } else if (i == 2) {
            if (z) {
                this.gvo = arrayList;
                this.mPrivateThread = i2;
            }
            this.gvp = true;
        }
        bGi();
    }

    private void bGi() {
        if (this.gvm == null || this.gvp) {
            if (this.gvn == null || this.gvr) {
                this.gvp = false;
                this.gvr = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.gvo)) {
                    Iterator<TransmitForumData> it = this.gvo.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!dV(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.gvq)) {
                    Iterator<TransmitForumData> it2 = this.gvq.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!dV(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.gvo = null;
                this.gvq = null;
                bGj();
            }
        }
    }

    private void bGj() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean dV(long j) {
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

    private Location bGk() {
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
