package com.baidu.tieba.d;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
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
public class c implements a.InterfaceC0106a {
    private a cYL;
    private ShareDialogConfig cYM;
    private ArrayList<TransmitForumData> mForumList;
    private TbPageContext mPageContext;
    private int mPrivateThread;

    public c(Context context) {
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        alq();
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        alq();
    }

    private void alq() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER, this.mPageContext), a.class);
        if (runTask != null) {
            this.cYL = (a) runTask.getData();
        }
        if (this.cYL != null) {
            this.cYL.setUseCache(false);
            this.cYL.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            this.cYM = shareDialogConfig;
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.biO = alr();
            }
            if (TbadkCoreApplication.isLogin() && this.cYL != null && !shareDialogConfig.mIsAlaLive) {
                this.cYL.aJ(null, null);
            } else {
                Ef();
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0106a
    public void b(List<TransmitForumData> list, boolean z, int i) {
        if (list instanceof ArrayList) {
            this.mForumList = (ArrayList) list;
        }
        this.mPrivateThread = i;
        Ef();
    }

    private void Ef() {
        if (this.cYM != null && this.cYM.shareItem != null) {
            this.cYM.setIsShowTransmitShare(true);
            this.cYM.setTransmitForumList(this.mForumList);
            this.cYM.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, this.cYM));
        }
    }

    private Location alr() {
        if (ab.aT(this.mPageContext.getPageActivity())) {
            LocationManager locationManager = (LocationManager) this.mPageContext.getPageActivity().getApplication().getSystemService(Headers.LOCATION);
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
