package com.baidu.tieba.ala.charm;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.charm.view.f;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private String apA;
    private boolean apz;
    private TextView dQC;
    private ALaCharmCardActivity erF;
    private CommonEmptyView erG;
    private f erH;
    private View erI;
    private PbListView erJ;
    private View.OnClickListener erK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.erH != null) {
                    b.this.a(b.this.erH.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener erL = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.2
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
        this.erF = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.apz = z;
        this.apA = str3;
        this.mRootView = this.erF.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.erG = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.erI = this.mRootView.findViewById(a.g.toLogin_layout);
        this.erI.setOnClickListener(this.erL);
        if (TbadkCoreApplication.isLogin()) {
            this.erI.setVisibility(8);
        } else {
            this.erI.setVisibility(0);
        }
        this.erH = new f(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.erH);
        this.mListView.setEmptyView(this.erG);
        this.erH.n(this.erK);
        this.dQC = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.erJ == null) {
            this.erJ = new PbListView(this.erF);
            this.erJ.setTextColor(this.erF.getResources().getColor(a.d.sdk_cp_cont_j));
            this.erJ.setSkinType(0);
            this.erJ.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.erJ.createView();
        }
    }

    public void bp(List<com.baidu.live.data.f> list) {
        this.erH.setData(list);
    }

    public void ic(boolean z) {
        if (z) {
            this.erG.reset();
            this.erG.setTitle(a.i.online_empty_text);
            this.erG.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.erG.setVisibility(0);
            return;
        }
        this.erG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.f fVar) {
        if (fVar != null && fVar.Wf != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.erF.getPageContext().getPageActivity(), fVar.Wf.userId + "", fVar.Wf.userName, fVar.Wf.portrait, fVar.Wf.sex, fVar.Wf.levelId, null, null, 0L, fVar.Wf.fansCount, fVar.Wf.fansCount, fVar.Wf.userStatus, this.mGroupId, this.mLiveId, this.apz, this.apA, null, fVar.Wf.userName, this.mOtherParams)));
        }
    }

    public void cA(long j) {
        if (this.dQC != null) {
            this.dQC.setText(String.format(this.erF.getString(a.i.online_count), i.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.erG.reset();
        this.erG.setTitle(a.i.sdk_net_fail_tip);
        this.erG.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.erG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.erG.setVisibility(0);
    }

    public void baf() {
        this.erG.setVisibility(8);
    }

    public void xB(String str) {
        this.mListView.setNextPage(this.erJ);
        this.erJ.endLoadDataWithNoMore(str);
    }
}
