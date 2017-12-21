package com.baidu.tieba.d;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.d.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements a.InterfaceC0093a {
    private a ckh;
    private ShareDialogConfig cki;
    private ArrayList<TransmitForumData> mForumList;
    private TbPageContext mPageContext;
    private int mPrivateThread;

    public c(Context context) {
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        adK();
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        adK();
    }

    private void adK() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER, this.mPageContext), a.class);
        if (runTask != null) {
            this.ckh = (a) runTask.getData();
        }
        if (this.ckh != null) {
            this.ckh.setUseCache(false);
            this.ckh.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            this.cki = shareDialogConfig;
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.auI = adL();
            }
            if (TbadkCoreApplication.isLogin() && this.ckh != null && !shareDialogConfig.mIsAlaLive) {
                this.ckh.aK(null, null);
            } else {
                wH();
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0093a
    public void b(List<TransmitForumData> list, boolean z, int i) {
        if (list instanceof ArrayList) {
            this.mForumList = (ArrayList) list;
        }
        this.mPrivateThread = i;
        wH();
    }

    private void wH() {
        if (this.cki != null && this.cki.shareItem != null) {
            this.cki.setIsShowTransmitShare(true);
            this.cki.setTransmitForumList(this.mForumList);
            this.cki.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, this.cki));
        }
    }

    private Location adL() {
        if (ab.aH(this.mPageContext.getPageActivity())) {
            LocationManager locationManager = (LocationManager) this.mPageContext.getPageActivity().getApplication().getSystemService("location");
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
