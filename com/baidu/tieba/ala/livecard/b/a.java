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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.x;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<f> implements x {
    public View dividerLine;
    public ThreadSkinView eJH;
    public TextView eJI;
    public TextView eJJ;
    public RelativeLayout eJK;
    public LinearLayout eJL;
    public ForbidParentSwipeBackRelativeLayout eJM;
    public ParentDisallowInterceptHListView eJN;
    public com.baidu.tieba.ala.livecard.adapters.b eJO;
    private boolean eJP;
    private f eJQ;
    AdapterView.c eJR;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eJP = true;
        this.eJR = new AdapterView.c() { // from class: com.baidu.tieba.ala.livecard.b.a.2
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                bj item = a.this.eJO.getItem(i);
                a.this.T(item);
                a.this.a(a.this.mTbPageContext, item);
            }
        };
        this.eJM = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.eJH = (ThreadSkinView) getView().findViewById(R.id.frs_thread_skin);
        this.eJI = (TextView) getView().findViewById(R.id.frs_insert_live_label);
        this.eJJ = (TextView) getView().findViewById(R.id.frs_insert_live_more);
        this.eJK = (RelativeLayout) getView().findViewById(R.id.frs_insert_live_top);
        this.eJN = (ParentDisallowInterceptHListView) getView().findViewById(R.id.frs_insert_live_listview);
        this.eJL = (LinearLayout) getView().findViewById(R.id.frs_card_content_layout);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.eJN.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.eJN.setBackgroundResource(R.drawable.transparent_bg);
        this.eJN.setOnItemClickListener(this.eJR);
        this.eJN.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.eJO = new com.baidu.tieba.ala.livecard.adapters.b(tbPageContext);
        this.eJN.setAdapter((ListAdapter) this.eJO);
        this.eJJ.setOnClickListener(this);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.eJP = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.eJP = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.eJM.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.a.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (a.this.eJQ != null && !v.isEmpty(a.this.eJQ.kdj) && a.this.eJQ.kdj.size() > 1) {
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
                    ((BaseActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.eJP);
                } else if (a.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.eJP);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eJM, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eJI, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.eJJ, (int) R.color.cp_cont_d);
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
            this.eJQ = fVar;
            beM();
            this.eJO.setData(fVar.kdj);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void beM() {
        if (!v.isEmpty(this.eJQ.kdj)) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            customMessage.setData(this.eJQ.kdj.get(0));
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(bj bjVar) {
        if (bjVar != null) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
            customMessage.setData(bjVar);
            MessageManager.getInstance().sendMessage(customMessage);
            TiebaStatic.log(new an("c12638"));
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eJJ) {
            TiebaStatic.log(new an("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.mTbPageContext.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        if (tbPageContext != null && bjVar != null && bjVar.azX() != null && bjVar.aAq() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.azX().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
            if (bjVar.aAq() != null && bjVar.aAq().user_info != null) {
                alaLiveInfoCoreData.userName = bjVar.aAq().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.eJQ != null && !v.isEmpty(this.eJQ.kdj)) {
                for (bj bjVar2 : this.eJQ.kdj) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(R(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData R(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
        alaLiveInfoCoreData.userName = bjVar.azX().getUserName();
        return alaLiveInfoCoreData;
    }
}
