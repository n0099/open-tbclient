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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.y;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.b<g> implements y {
    public View dividerLine;
    AdapterView.c fXA;
    public ThreadSkinView fXq;
    public TextView fXr;
    public TextView fXs;
    public RelativeLayout fXt;
    public LinearLayout fXu;
    public ForbidParentSwipeBackRelativeLayout fXv;
    public ParentDisallowInterceptHListView fXw;
    public com.baidu.tieba.ala.livecard.adapters.b fXx;
    private boolean fXy;
    private g fXz;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fXy = true;
        this.fXA = new AdapterView.c() { // from class: com.baidu.tieba.ala.livecard.b.a.2
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                bv item = a.this.fXx.getItem(i);
                a.this.U(item);
                a.this.a(a.this.mTbPageContext, item);
            }
        };
        this.fXv = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.fXq = (ThreadSkinView) getView().findViewById(R.id.frs_thread_skin);
        this.fXr = (TextView) getView().findViewById(R.id.frs_insert_live_label);
        this.fXs = (TextView) getView().findViewById(R.id.frs_insert_live_more);
        this.fXt = (RelativeLayout) getView().findViewById(R.id.frs_insert_live_top);
        this.fXw = (ParentDisallowInterceptHListView) getView().findViewById(R.id.frs_insert_live_listview);
        this.fXu = (LinearLayout) getView().findViewById(R.id.frs_card_content_layout);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.fXw.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.fXw.setBackgroundResource(R.drawable.transparent_bg);
        this.fXw.setOnItemClickListener(this.fXA);
        this.fXw.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.fXx = new com.baidu.tieba.ala.livecard.adapters.b(tbPageContext);
        this.fXw.setAdapter((ListAdapter) this.fXx);
        this.fXs.setOnClickListener(this);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.fXy = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.fXy = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.fXv.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.a.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (a.this.fXz != null && !x.isEmpty(a.this.fXz.lKR) && a.this.fXz.lKR.size() > 1) {
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
                    ((BaseActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.fXy);
                } else if (a.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.fXy);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.fXv, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.fXr, R.color.cp_cont_f);
            ao.setViewTextColor(this.fXs, R.color.cp_cont_d);
            ao.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
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
            this.fXz = gVar;
            bCw();
            this.fXx.setData(gVar.lKR);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bCw() {
        if (!x.isEmpty(this.fXz.lKR)) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            customMessage.setData(this.fXz.lKR.get(0));
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(bv bvVar) {
        if (bvVar != null) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
            customMessage.setData(bvVar);
            MessageManager.getInstance().sendMessage(customMessage);
            TiebaStatic.log(new ap("c12638"));
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fXs) {
            TiebaStatic.log(new ap("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.mTbPageContext.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void a(TbPageContext<?> tbPageContext, bv bvVar) {
        if (tbPageContext != null && bvVar != null && bvVar.aWl() != null && bvVar.aWF() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bvVar.aWl().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
            if (bvVar.aWF() != null && bvVar.aWF().user_info != null) {
                alaLiveInfoCoreData.userName = bvVar.aWF().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.fXz != null && !x.isEmpty(this.fXz.lKR)) {
                for (bv bvVar2 : this.fXz.lKR) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bvVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData S(bv bvVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
        alaLiveInfoCoreData.userName = bvVar.aWl().getUserName();
        return alaLiveInfoCoreData;
    }
}
