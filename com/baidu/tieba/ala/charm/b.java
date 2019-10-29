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
    private boolean ahd;
    private String ahe;
    private View.OnClickListener dFA = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.dFx != null) {
                    b.this.a(b.this.dFx.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener dFB = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private ALaCharmCardActivity dFv;
    private CommonEmptyView dFw;
    private f dFx;
    private View dFy;
    private PbListView dFz;
    private TextView ddp;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public b(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3) {
        this.dFv = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.ahd = z;
        this.ahe = str3;
        this.mRootView = this.dFv.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.dFw = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.dFy = this.mRootView.findViewById(a.g.toLogin_layout);
        this.dFy.setOnClickListener(this.dFB);
        if (TbadkCoreApplication.isLogin()) {
            this.dFy.setVisibility(8);
        } else {
            this.dFy.setVisibility(0);
        }
        this.dFx = new f(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.dFx);
        this.mListView.setEmptyView(this.dFw);
        this.dFx.n(this.dFA);
        this.ddp = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.dFz == null) {
            this.dFz = new PbListView(this.dFv);
            this.dFz.setTextColor(this.dFv.getResources().getColor(a.d.sdk_cp_cont_j));
            this.dFz.setSkinType(0);
            this.dFz.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.dFz.createView();
        }
    }

    public void bq(List<com.baidu.live.data.d> list) {
        this.dFx.setData(list);
    }

    public void gN(boolean z) {
        if (z) {
            this.dFw.reset();
            this.dFw.setTitle(a.i.online_empty_text);
            this.dFw.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.dFw.setVisibility(0);
            return;
        }
        this.dFw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.d dVar) {
        if (dVar != null && dVar.Ps != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.dFv.getPageContext().getPageActivity(), dVar.Ps.userId + "", dVar.Ps.userName, dVar.Ps.portrait, dVar.Ps.sex, dVar.Ps.levelId, null, null, 0L, dVar.Ps.fansCount, dVar.Ps.fansCount, dVar.Ps.userStatus, this.mGroupId, this.mLiveId, this.ahd, this.ahe, null, dVar.Ps.userName, this.mOtherParams)));
        }
    }

    public void bV(long j) {
        if (this.ddp != null) {
            this.ddp.setText(String.format(this.dFv.getString(a.i.online_count), h.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.dFw.reset();
        this.dFw.setTitle(a.i.sdk_net_fail_tip);
        this.dFw.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.dFw.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.dFw.setVisibility(0);
    }

    public void aJo() {
        this.dFw.setVisibility(8);
    }

    public void sO(String str) {
        this.mListView.setNextPage(this.dFz);
        this.dFz.endLoadDataWithNoMore(str);
    }
}
