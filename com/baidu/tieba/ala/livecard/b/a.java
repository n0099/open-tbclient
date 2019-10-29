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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.f;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<f> implements z {
    public ThreadSkinView dTH;
    public TextView dTI;
    public TextView dTJ;
    public RelativeLayout dTK;
    public LinearLayout dTL;
    public ForbidParentSwipeBackRelativeLayout dTM;
    public ParentDisallowInterceptHListView dTN;
    public com.baidu.tieba.ala.livecard.adapters.b dTO;
    private boolean dTP;
    private f dTQ;
    AdapterView.c dTR;
    public View dividerLine;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dTP = true;
        this.dTR = new AdapterView.c() { // from class: com.baidu.tieba.ala.livecard.b.a.2
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                bh item = a.this.dTO.getItem(i);
                a.this.O(item);
                a.this.a(a.this.mTbPageContext, item);
            }
        };
        this.dTM = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dTH = (ThreadSkinView) getView().findViewById(R.id.frs_thread_skin);
        this.dTI = (TextView) getView().findViewById(R.id.frs_insert_live_label);
        this.dTJ = (TextView) getView().findViewById(R.id.frs_insert_live_more);
        this.dTK = (RelativeLayout) getView().findViewById(R.id.frs_insert_live_top);
        this.dTN = (ParentDisallowInterceptHListView) getView().findViewById(R.id.frs_insert_live_listview);
        this.dTL = (LinearLayout) getView().findViewById(R.id.frs_card_content_layout);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.dTN.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.dTN.setBackgroundResource(R.drawable.transparent_bg);
        this.dTN.setOnItemClickListener(this.dTR);
        this.dTN.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.dTO = new com.baidu.tieba.ala.livecard.adapters.b(tbPageContext);
        this.dTN.setAdapter((ListAdapter) this.dTO);
        this.dTJ.setOnClickListener(this);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.dTP = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.dTP = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.dTM.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.a.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (a.this.dTQ != null && !v.isEmpty(a.this.dTQ.jgf) && a.this.dTQ.jgf.size() > 1) {
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
                    ((BaseActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.dTP);
                } else if (a.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.dTP);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dTM, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.dTI, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.dTJ, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_insert_rec_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null) {
            this.dTQ = fVar;
            aMO();
            this.dTO.setData(fVar.jgf);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aMO() {
        if (!v.isEmpty(this.dTQ.jgf)) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            customMessage.setData(this.dTQ.jgf.get(0));
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(bh bhVar) {
        if (bhVar != null) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
            customMessage.setData(bhVar);
            MessageManager.getInstance().sendMessage(customMessage);
            TiebaStatic.log(new an("c12638"));
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dTJ) {
            TiebaStatic.log(new an("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.mTbPageContext.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void a(TbPageContext<?> tbPageContext, bh bhVar) {
        if (tbPageContext != null && bhVar != null && bhVar.aiG() != null && bhVar.aiZ() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiG().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
            if (bhVar.aiZ() != null && bhVar.aiZ().user_info != null) {
                alaLiveInfoCoreData.userName = bhVar.aiZ().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.dTQ != null && !v.isEmpty(this.dTQ.jgf)) {
                for (bh bhVar2 : this.dTQ.jgf) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(M(bhVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData M(bh bhVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
        alaLiveInfoCoreData.userName = bhVar.aiG().getUserName();
        return alaLiveInfoCoreData;
    }
}
