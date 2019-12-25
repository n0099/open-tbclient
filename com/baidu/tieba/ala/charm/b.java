package com.baidu.tieba.ala.charm;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.q.a;
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
    private boolean aoM;
    private String aoN;
    private TextView dQt;
    private ALaCharmCardActivity eqs;
    private CommonEmptyView eqt;
    private f equ;
    private View eqv;
    private PbListView eqw;
    private View.OnClickListener eqx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.equ != null) {
                    b.this.a(b.this.equ.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener eqy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.2
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
        this.eqs = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aoM = z;
        this.aoN = str3;
        this.mRootView = this.eqs.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.eqt = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.eqv = this.mRootView.findViewById(a.g.toLogin_layout);
        this.eqv.setOnClickListener(this.eqy);
        if (TbadkCoreApplication.isLogin()) {
            this.eqv.setVisibility(8);
        } else {
            this.eqv.setVisibility(0);
        }
        this.equ = new f(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.equ);
        this.mListView.setEmptyView(this.eqt);
        this.equ.o(this.eqx);
        this.dQt = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.eqw == null) {
            this.eqw = new PbListView(this.eqs);
            this.eqw.setTextColor(this.eqs.getResources().getColor(a.d.sdk_cp_cont_j));
            this.eqw.setSkinType(0);
            this.eqw.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.eqw.createView();
        }
    }

    public void bp(List<com.baidu.live.data.f> list) {
        this.equ.setData(list);
    }

    public void hS(boolean z) {
        if (z) {
            this.eqt.reset();
            this.eqt.setTitle(a.i.online_empty_text);
            this.eqt.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.eqt.setVisibility(0);
            return;
        }
        this.eqt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.f fVar) {
        if (fVar != null && fVar.VP != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.eqs.getPageContext().getPageActivity(), fVar.VP.userId + "", fVar.VP.userName, fVar.VP.portrait, fVar.VP.sex, fVar.VP.levelId, null, null, 0L, fVar.VP.fansCount, fVar.VP.fansCount, fVar.VP.userStatus, this.mGroupId, this.mLiveId, this.aoM, this.aoN, null, fVar.VP.userName, this.mOtherParams)));
        }
    }

    public void cv(long j) {
        if (this.dQt != null) {
            this.dQt.setText(String.format(this.eqs.getString(a.i.online_count), i.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void m(View.OnClickListener onClickListener) {
        this.eqt.reset();
        this.eqt.setTitle(a.i.sdk_net_fail_tip);
        this.eqt.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.eqt.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.eqt.setVisibility(0);
    }

    public void aZK() {
        this.eqt.setVisibility(8);
    }

    public void xw(String str) {
        this.mListView.setNextPage(this.eqw);
        this.eqw.endLoadDataWithNoMore(str);
    }
}
