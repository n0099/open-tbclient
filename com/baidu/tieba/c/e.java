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
public class e implements a.InterfaceC0546a {
    private static e gvr = null;
    private a gvs;
    private a gvt;
    private ArrayList<TransmitForumData> gvu;
    private ArrayList<TransmitForumData> gvw;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean gvv = false;
    private boolean gvx = false;
    private boolean isLoading = false;

    public static e bGd() {
        if (gvr == null) {
            synchronized (e.class) {
                if (gvr == null) {
                    gvr = new e();
                }
            }
        }
        return gvr;
    }

    private e() {
        init();
    }

    private void init() {
        bGf();
        bGe();
        this.isLoading = false;
    }

    private void bGe() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.gvt = (a) runTask.getData();
        }
        if (this.gvt != null) {
            this.gvt.a(this);
        }
    }

    private void bGf() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.gvs = (a) runTask.getData();
        }
        if (this.gvs != null) {
            this.gvs.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = bGj();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bGg();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bGg() {
        this.isLoading = true;
        if (this.gvs != null) {
            this.gvs.bFV();
        }
        if (this.gvt != null) {
            this.gvt.bFV();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0546a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.gvw = arrayList;
            }
            this.gvx = true;
        } else if (i == 2) {
            if (z) {
                this.gvu = arrayList;
                this.mPrivateThread = i2;
            }
            this.gvv = true;
        }
        bGh();
    }

    private void bGh() {
        if (this.gvs == null || this.gvv) {
            if (this.gvt == null || this.gvx) {
                this.gvv = false;
                this.gvx = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.gvu)) {
                    Iterator<TransmitForumData> it = this.gvu.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!dV(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.gvw)) {
                    Iterator<TransmitForumData> it2 = this.gvw.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!dV(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.gvu = null;
                this.gvw = null;
                bGi();
            }
        }
    }

    private void bGi() {
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

    private Location bGj() {
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
