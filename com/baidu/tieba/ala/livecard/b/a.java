package com.baidu.tieba.ala.livecard.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.ala.view.ForbidParentSwipeBackRelativeLayout;
import com.baidu.ala.view.ParentDisallowInterceptHListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.y;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.b<g> implements y {
    public View dividerLine;
    public ThreadSkinView fGO;
    public TextView fGP;
    public TextView fGQ;
    public RelativeLayout fGR;
    public LinearLayout fGS;
    public ForbidParentSwipeBackRelativeLayout fGT;
    public ParentDisallowInterceptHListView fGU;
    public com.baidu.tieba.ala.livecard.adapters.b fGV;
    private boolean fGW;
    private g fGX;
    AdapterView.c fGY;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fGW = true;
        this.fGY = new AdapterView.c() { // from class: com.baidu.tieba.ala.livecard.b.a.2
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                bk item = a.this.fGV.getItem(i);
                a.this.W(item);
                a.this.a(a.this.mTbPageContext, item);
            }
        };
        this.fGT = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.fGO = (ThreadSkinView) getView().findViewById(R.id.frs_thread_skin);
        this.fGP = (TextView) getView().findViewById(R.id.frs_insert_live_label);
        this.fGQ = (TextView) getView().findViewById(R.id.frs_insert_live_more);
        this.fGR = (RelativeLayout) getView().findViewById(R.id.frs_insert_live_top);
        this.fGU = (ParentDisallowInterceptHListView) getView().findViewById(R.id.frs_insert_live_listview);
        this.fGS = (LinearLayout) getView().findViewById(R.id.frs_card_content_layout);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.fGU.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.fGU.setBackgroundResource(R.drawable.transparent_bg);
        this.fGU.setOnItemClickListener(this.fGY);
        this.fGU.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.fGV = new com.baidu.tieba.ala.livecard.adapters.b(tbPageContext);
        this.fGU.setAdapter((ListAdapter) this.fGV);
        this.fGQ.setOnClickListener(this);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.fGW = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.fGW = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.fGT.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.a.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (a.this.fGX != null && !v.isEmpty(a.this.fGX.ljH) && a.this.fGX.ljH.size() > 1) {
                    if (a.this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
                        ((BaseActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(false);
                    } else if (a.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(false);
                    }
                }
            }

            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void enableSwipeBack() {
                if (a.this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.fGW);
                } else if (a.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.fGW);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fGT, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.fGP, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.fGQ, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_insert_rec_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(g gVar) {
        if (gVar != null) {
            this.fGX = gVar;
            bwm();
            this.fGV.setData(gVar.ljH);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bwm() {
        if (!v.isEmpty(this.fGX.ljH)) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            customMessage.setData(this.fGX.ljH.get(0));
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(bk bkVar) {
        if (bkVar != null) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
            customMessage.setData(bkVar);
            MessageManager.getInstance().sendMessage(customMessage);
            TiebaStatic.log(new an("c12638"));
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qy(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fGQ) {
            TiebaStatic.log(new an("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.mTbPageContext.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void a(TbPageContext<?> tbPageContext, bk bkVar) {
        if (tbPageContext != null && bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bkVar.aQx().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
            if (bkVar.aQS() != null && bkVar.aQS().user_info != null) {
                alaLiveInfoCoreData.userName = bkVar.aQS().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.fGX != null && !v.isEmpty(this.fGX.ljH)) {
                for (bk bkVar2 : this.fGX.ljH) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(U(bkVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData U(bk bkVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
        alaLiveInfoCoreData.userName = bkVar.aQx().getUserName();
        return alaLiveInfoCoreData;
    }
}
