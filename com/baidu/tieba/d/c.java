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
public class c implements a.InterfaceC0080a {
    private a cjP;
    private ShareDialogConfig cjQ;
    private ArrayList<TransmitForumData> mForumList;
    private TbPageContext mPageContext;

    public c(Context context) {
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        adB();
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        adB();
    }

    private void adB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER, this.mPageContext), a.class);
        if (runTask != null) {
            this.cjP = (a) runTask.getData();
        }
        if (this.cjP != null) {
            this.cjP.setUseCache(false);
            this.cjP.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            this.cjQ = shareDialogConfig;
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.auA = adC();
            }
            if (TbadkCoreApplication.isLogin() && this.cjP != null && !shareDialogConfig.mIsAlaLive) {
                this.cjP.aJ(null, null);
            } else {
                wJ();
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0080a
    public void e(List<TransmitForumData> list, boolean z) {
        if (list instanceof ArrayList) {
            this.mForumList = (ArrayList) list;
        }
        wJ();
    }

    private void wJ() {
        if (this.cjQ != null && this.cjQ.shareItem != null) {
            this.cjQ.setIsShowTransmitShare(true);
            this.cjQ.setTransmitForumList(this.mForumList);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, this.cjQ));
        }
    }

    private Location adC() {
        if (ab.aK(this.mPageContext.getPageActivity())) {
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
