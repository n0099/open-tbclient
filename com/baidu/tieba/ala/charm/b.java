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
    private TextView dUI;
    private ALaCharmCardActivity evP;
    private CommonEmptyView evQ;
    private f evR;
    private View evS;
    private PbListView evT;
    private View.OnClickListener evU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.evR != null) {
                    b.this.a(b.this.evR.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener evV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.2
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
        this.evP = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.asR = z;
        this.asS = str3;
        this.mRootView = this.evP.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.evQ = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.evS = this.mRootView.findViewById(a.g.toLogin_layout);
        this.evS.setOnClickListener(this.evV);
        if (TbadkCoreApplication.isLogin()) {
            this.evS.setVisibility(8);
        } else {
            this.evS.setVisibility(0);
        }
        this.evR = new f(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.evR);
        this.mListView.setEmptyView(this.evQ);
        this.evR.n(this.evU);
        this.dUI = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.evT == null) {
            this.evT = new PbListView(this.evP);
            this.evT.setTextColor(this.evP.getResources().getColor(a.d.sdk_cp_cont_j));
            this.evT.setSkinType(0);
            this.evT.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.evT.createView();
        }
    }

    public void bp(List<g> list) {
        this.evR.setData(list);
    }

    public void ij(boolean z) {
        if (z) {
            this.evQ.reset();
            this.evQ.setTitle(a.i.online_empty_text);
            this.evQ.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.evQ.setVisibility(0);
            return;
        }
        this.evQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (gVar != null && gVar.XQ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.evP.getPageContext().getPageActivity(), gVar.XQ.userId + "", gVar.XQ.userName, gVar.XQ.portrait, gVar.XQ.sex, gVar.XQ.levelId, null, null, 0L, gVar.XQ.fansCount, gVar.XQ.fansCount, gVar.XQ.userStatus, this.mGroupId, this.mLiveId, this.asR, this.asS, null, gVar.XQ.userName, this.mOtherParams)));
        }
    }

    public void cD(long j) {
        if (this.dUI != null) {
            this.dUI.setText(String.format(this.evP.getString(a.i.online_count), i.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.evQ.reset();
        this.evQ.setTitle(a.i.sdk_net_fail_tip);
        this.evQ.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.evQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.evQ.setVisibility(0);
    }

    public void bcv() {
        this.evQ.setVisibility(8);
    }

    public void xV(String str) {
        this.mListView.setNextPage(this.evT);
        this.evT.endLoadDataWithNoMore(str);
    }
}
