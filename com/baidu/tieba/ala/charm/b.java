package com.baidu.tieba.ala.charm;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.charm.view.f;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private boolean agL;
    private String agM;
    private ALaCharmCardActivity dEE;
    private CommonEmptyView dEF;
    private f dEG;
    private View dEH;
    private PbListView dEI;
    private View.OnClickListener dEJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.dEG != null) {
                    b.this.a(b.this.dEG.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener dEK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private TextView dcy;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public b(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3) {
        this.dEE = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.agL = z;
        this.agM = str3;
        this.mRootView = this.dEE.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.dEF = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.dEH = this.mRootView.findViewById(a.g.toLogin_layout);
        this.dEH.setOnClickListener(this.dEK);
        if (TbadkCoreApplication.isLogin()) {
            this.dEH.setVisibility(8);
        } else {
            this.dEH.setVisibility(0);
        }
        this.dEG = new f(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.dEG);
        this.mListView.setEmptyView(this.dEF);
        this.dEG.n(this.dEJ);
        this.dcy = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.dEI == null) {
            this.dEI = new PbListView(this.dEE);
            this.dEI.setTextColor(this.dEE.getResources().getColor(a.d.sdk_cp_cont_j));
            this.dEI.setSkinType(0);
            this.dEI.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.dEI.createView();
        }
    }

    public void bq(List<com.baidu.live.data.d> list) {
        this.dEG.setData(list);
    }

    public void gN(boolean z) {
        if (z) {
            this.dEF.reset();
            this.dEF.setTitle(a.i.online_empty_text);
            this.dEF.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.dEF.setVisibility(0);
            return;
        }
        this.dEF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.d dVar) {
        if (dVar != null && dVar.OR != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.dEE.getPageContext().getPageActivity(), dVar.OR.userId + "", dVar.OR.userName, dVar.OR.portrait, dVar.OR.sex, dVar.OR.levelId, null, null, 0L, dVar.OR.fansCount, dVar.OR.fansCount, dVar.OR.userStatus, this.mGroupId, this.mLiveId, this.agL, this.agM, null, dVar.OR.userName, this.mOtherParams)));
        }
    }

    public void bU(long j) {
        if (this.dcy != null) {
            this.dcy.setText(String.format(this.dEE.getString(a.i.online_count), h.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.dEF.reset();
        this.dEF.setTitle(a.i.sdk_net_fail_tip);
        this.dEF.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.dEF.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.dEF.setVisibility(0);
    }

    public void aJm() {
        this.dEF.setVisibility(8);
    }

    public void sO(String str) {
        this.mListView.setNextPage(this.dEI);
        this.dEI.endLoadDataWithNoMore(str);
    }
}
