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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.b<g> implements z {
    public View dividerLine;
    public ThreadSkinView gTg;
    public TextView gTh;
    public TextView gTi;
    public RelativeLayout gTj;
    public LinearLayout gTk;
    public ForbidParentSwipeBackRelativeLayout gTl;
    public ParentDisallowInterceptHListView gTm;
    public com.baidu.tieba.ala.livecard.adapters.b gTn;
    private boolean gTo;
    private g gTp;
    AdapterView.c gTq;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gTo = true;
        this.gTq = new AdapterView.c() { // from class: com.baidu.tieba.ala.livecard.b.a.2
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                bw item = a.this.gTn.getItem(i);
                a.this.V(item);
                a.this.a(a.this.mTbPageContext, item);
            }
        };
        this.gTl = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.gTg = (ThreadSkinView) getView().findViewById(R.id.frs_thread_skin);
        this.gTh = (TextView) getView().findViewById(R.id.frs_insert_live_label);
        this.gTi = (TextView) getView().findViewById(R.id.frs_insert_live_more);
        this.gTj = (RelativeLayout) getView().findViewById(R.id.frs_insert_live_top);
        this.gTm = (ParentDisallowInterceptHListView) getView().findViewById(R.id.frs_insert_live_listview);
        this.gTk = (LinearLayout) getView().findViewById(R.id.frs_card_content_layout);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.gTm.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.gTm.setBackgroundResource(R.drawable.transparent_bg);
        this.gTm.setOnItemClickListener(this.gTq);
        this.gTm.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.gTn = new com.baidu.tieba.ala.livecard.adapters.b(tbPageContext);
        this.gTm.setAdapter((ListAdapter) this.gTn);
        this.gTi.setOnClickListener(this);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.gTo = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.gTo = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.gTl.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.a.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (a.this.gTp != null && !y.isEmpty(a.this.gTp.mUG) && a.this.gTp.mUG.size() > 1) {
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
                    ((BaseActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.gTo);
                } else if (a.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.gTo);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gTl, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gTh, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.gTi, (int) R.color.cp_cont_d);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
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
            this.gTp = gVar;
            bVX();
            this.gTn.setData(gVar.mUG);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bVX() {
        if (!y.isEmpty(this.gTp.mUG)) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            customMessage.setData(this.gTp.mUG.get(0));
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(bw bwVar) {
        if (bwVar != null) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
            customMessage.setData(bwVar);
            MessageManager.getInstance().sendMessage(customMessage);
            TiebaStatic.log(new aq("c12638"));
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gTi) {
            TiebaStatic.log(new aq("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.mTbPageContext.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        if (tbPageContext != null && bwVar != null && bwVar.bmA() != null && bwVar.bmU() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bmA().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
            if (bwVar.bmU() != null && bwVar.bmU().user_info != null) {
                alaLiveInfoCoreData.userName = bwVar.bmU().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.gTp != null && !y.isEmpty(this.gTp.mUG)) {
                for (bw bwVar2 : this.gTp.mUG) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
        alaLiveInfoCoreData.userName = bwVar.bmA().getUserName();
        return alaLiveInfoCoreData;
    }
}
