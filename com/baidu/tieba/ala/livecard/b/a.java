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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.card.y;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.b<g> implements y {
    public View dividerLine;
    public ThreadSkinView fRX;
    public TextView fRY;
    public TextView fRZ;
    public RelativeLayout fSa;
    public LinearLayout fSb;
    public ForbidParentSwipeBackRelativeLayout fSc;
    public ParentDisallowInterceptHListView fSd;
    public com.baidu.tieba.ala.livecard.adapters.b fSe;
    private boolean fSf;
    private g fSg;
    AdapterView.c fSh;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fSf = true;
        this.fSh = new AdapterView.c() { // from class: com.baidu.tieba.ala.livecard.b.a.2
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                bu item = a.this.fSe.getItem(i);
                a.this.X(item);
                a.this.a(a.this.mTbPageContext, item);
            }
        };
        this.fSc = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.fRX = (ThreadSkinView) getView().findViewById(R.id.frs_thread_skin);
        this.fRY = (TextView) getView().findViewById(R.id.frs_insert_live_label);
        this.fRZ = (TextView) getView().findViewById(R.id.frs_insert_live_more);
        this.fSa = (RelativeLayout) getView().findViewById(R.id.frs_insert_live_top);
        this.fSd = (ParentDisallowInterceptHListView) getView().findViewById(R.id.frs_insert_live_listview);
        this.fSb = (LinearLayout) getView().findViewById(R.id.frs_card_content_layout);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.fSd.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.fSd.setBackgroundResource(R.drawable.transparent_bg);
        this.fSd.setOnItemClickListener(this.fSh);
        this.fSd.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.fSe = new com.baidu.tieba.ala.livecard.adapters.b(tbPageContext);
        this.fSd.setAdapter((ListAdapter) this.fSe);
        this.fRZ.setOnClickListener(this);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.fSf = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.fSf = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.fSc.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.a.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (a.this.fSg != null && !w.isEmpty(a.this.fSg.lDC) && a.this.fSg.lDC.size() > 1) {
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
                    ((BaseActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.fSf);
                } else if (a.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.fSf);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.fSc, R.drawable.addresslist_item_bg);
            an.setViewTextColor(this.fRY, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.fRZ, (int) R.color.cp_cont_d);
            an.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
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
            this.fSg = gVar;
            bzh();
            this.fSe.setData(gVar.lDC);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bzh() {
        if (!w.isEmpty(this.fSg.lDC)) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            customMessage.setData(this.fSg.lDC.get(0));
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(bu buVar) {
        if (buVar != null) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
            customMessage.setData(buVar);
            MessageManager.getInstance().sendMessage(customMessage);
            TiebaStatic.log(new ao("c12638"));
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fRZ) {
            TiebaStatic.log(new ao("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.mTbPageContext.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void a(TbPageContext<?> tbPageContext, bu buVar) {
        if (tbPageContext != null && buVar != null && buVar.aSp() != null && buVar.aSJ() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = buVar.aSp().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
            if (buVar.aSJ() != null && buVar.aSJ().user_info != null) {
                alaLiveInfoCoreData.userName = buVar.aSJ().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.fSg != null && !w.isEmpty(this.fSg.lDC)) {
                for (bu buVar2 : this.fSg.lDC) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(buVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData V(bu buVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
        alaLiveInfoCoreData.userName = buVar.aSp().getUserName();
        return alaLiveInfoCoreData;
    }
}
