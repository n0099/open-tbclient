package com.baidu.tieba.ala.charm;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.charm.view.f;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private boolean asR;
    private String asS;
    private TextView dUJ;
    private ALaCharmCardActivity evQ;
    private CommonEmptyView evR;
    private f evS;
    private View evT;
    private PbListView evU;
    private View.OnClickListener evV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.evS != null) {
                    b.this.a(b.this.evS.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener evW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public b(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3) {
        this.evQ = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.asR = z;
        this.asS = str3;
        this.mRootView = this.evQ.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.evR = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.evT = this.mRootView.findViewById(a.g.toLogin_layout);
        this.evT.setOnClickListener(this.evW);
        if (TbadkCoreApplication.isLogin()) {
            this.evT.setVisibility(8);
        } else {
            this.evT.setVisibility(0);
        }
        this.evS = new f(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.evS);
        this.mListView.setEmptyView(this.evR);
        this.evS.n(this.evV);
        this.dUJ = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.evU == null) {
            this.evU = new PbListView(this.evQ);
            this.evU.setTextColor(this.evQ.getResources().getColor(a.d.sdk_cp_cont_j));
            this.evU.setSkinType(0);
            this.evU.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.evU.createView();
        }
    }

    public void bp(List<g> list) {
        this.evS.setData(list);
    }

    public void ij(boolean z) {
        if (z) {
            this.evR.reset();
            this.evR.setTitle(a.i.online_empty_text);
            this.evR.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.evR.setVisibility(0);
            return;
        }
        this.evR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (gVar != null && gVar.XQ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.evQ.getPageContext().getPageActivity(), gVar.XQ.userId + "", gVar.XQ.userName, gVar.XQ.portrait, gVar.XQ.sex, gVar.XQ.levelId, null, null, 0L, gVar.XQ.fansCount, gVar.XQ.fansCount, gVar.XQ.userStatus, this.mGroupId, this.mLiveId, this.asR, this.asS, null, gVar.XQ.userName, this.mOtherParams)));
        }
    }

    public void cD(long j) {
        if (this.dUJ != null) {
            this.dUJ.setText(String.format(this.evQ.getString(a.i.online_count), i.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.evR.reset();
        this.evR.setTitle(a.i.sdk_net_fail_tip);
        this.evR.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.evR.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.evR.setVisibility(0);
    }

    public void bcx() {
        this.evR.setVisibility(8);
    }

    public void xV(String str) {
        this.mListView.setNextPage(this.evU);
        this.evU.endLoadDataWithNoMore(str);
    }
}
