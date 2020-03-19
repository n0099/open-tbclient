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
    private boolean atc;
    private String atd;
    private TextView dVm;
    private CommonEmptyView ewA;
    private f ewB;
    private View ewC;
    private PbListView ewD;
    private View.OnClickListener ewE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ewB != null) {
                    b.this.a(b.this.ewB.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener ewF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private ALaCharmCardActivity ewz;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public b(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3) {
        this.ewz = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.atc = z;
        this.atd = str3;
        this.mRootView = this.ewz.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.ewA = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.ewC = this.mRootView.findViewById(a.g.toLogin_layout);
        this.ewC.setOnClickListener(this.ewF);
        if (TbadkCoreApplication.isLogin()) {
            this.ewC.setVisibility(8);
        } else {
            this.ewC.setVisibility(0);
        }
        this.ewB = new f(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.ewB);
        this.mListView.setEmptyView(this.ewA);
        this.ewB.n(this.ewE);
        this.dVm = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.ewD == null) {
            this.ewD = new PbListView(this.ewz);
            this.ewD.setTextColor(this.ewz.getResources().getColor(a.d.sdk_cp_cont_j));
            this.ewD.setSkinType(0);
            this.ewD.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.ewD.createView();
        }
    }

    public void bp(List<g> list) {
        this.ewB.setData(list);
    }

    public void il(boolean z) {
        if (z) {
            this.ewA.reset();
            this.ewA.setTitle(a.i.online_empty_text);
            this.ewA.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.ewA.setVisibility(0);
            return;
        }
        this.ewA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (gVar != null && gVar.Ya != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.ewz.getPageContext().getPageActivity(), gVar.Ya.userId + "", gVar.Ya.userName, gVar.Ya.portrait, gVar.Ya.sex, gVar.Ya.levelId, null, null, 0L, gVar.Ya.fansCount, gVar.Ya.fansCount, gVar.Ya.userStatus, this.mGroupId, this.mLiveId, this.atc, this.atd, null, gVar.Ya.userName, this.mOtherParams)));
        }
    }

    public void cD(long j) {
        if (this.dVm != null) {
            this.dVm.setText(String.format(this.ewz.getString(a.i.online_count), i.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.ewA.reset();
        this.ewA.setTitle(a.i.sdk_net_fail_tip);
        this.ewA.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.ewA.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.ewA.setVisibility(0);
    }

    public void bcC() {
        this.ewA.setVisibility(8);
    }

    public void xX(String str) {
        this.mListView.setNextPage(this.ewD);
        this.ewD.endLoadDataWithNoMore(str);
    }
}
