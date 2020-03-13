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
    private boolean asS;
    private String asT;
    private TextView dUW;
    private ALaCharmCardActivity ewd;
    private CommonEmptyView ewe;
    private f ewf;
    private View ewg;
    private PbListView ewh;
    private View.OnClickListener ewi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ewf != null) {
                    b.this.a(b.this.ewf.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener ewj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.2
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
        this.ewd = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.asS = z;
        this.asT = str3;
        this.mRootView = this.ewd.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.ewe = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.ewg = this.mRootView.findViewById(a.g.toLogin_layout);
        this.ewg.setOnClickListener(this.ewj);
        if (TbadkCoreApplication.isLogin()) {
            this.ewg.setVisibility(8);
        } else {
            this.ewg.setVisibility(0);
        }
        this.ewf = new f(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.ewf);
        this.mListView.setEmptyView(this.ewe);
        this.ewf.n(this.ewi);
        this.dUW = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.ewh == null) {
            this.ewh = new PbListView(this.ewd);
            this.ewh.setTextColor(this.ewd.getResources().getColor(a.d.sdk_cp_cont_j));
            this.ewh.setSkinType(0);
            this.ewh.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.ewh.createView();
        }
    }

    public void bp(List<g> list) {
        this.ewf.setData(list);
    }

    public void ij(boolean z) {
        if (z) {
            this.ewe.reset();
            this.ewe.setTitle(a.i.online_empty_text);
            this.ewe.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.ewe.setVisibility(0);
            return;
        }
        this.ewe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (gVar != null && gVar.XQ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.ewd.getPageContext().getPageActivity(), gVar.XQ.userId + "", gVar.XQ.userName, gVar.XQ.portrait, gVar.XQ.sex, gVar.XQ.levelId, null, null, 0L, gVar.XQ.fansCount, gVar.XQ.fansCount, gVar.XQ.userStatus, this.mGroupId, this.mLiveId, this.asS, this.asT, null, gVar.XQ.userName, this.mOtherParams)));
        }
    }

    public void cD(long j) {
        if (this.dUW != null) {
            this.dUW.setText(String.format(this.ewd.getString(a.i.online_count), i.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.ewe.reset();
        this.ewe.setTitle(a.i.sdk_net_fail_tip);
        this.ewe.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.ewe.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.ewe.setVisibility(0);
    }

    public void bcy() {
        this.ewe.setVisibility(8);
    }

    public void xW(String str) {
        this.mListView.setNextPage(this.ewh);
        this.ewh.endLoadDataWithNoMore(str);
    }
}
