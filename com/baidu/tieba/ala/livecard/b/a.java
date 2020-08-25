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
import com.baidu.tieba.R;
import com.baidu.tieba.card.y;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.b<g> implements y {
    public View dividerLine;
    public ThreadSkinView gjp;
    public TextView gjq;
    public TextView gjr;
    public RelativeLayout gjs;
    public LinearLayout gjt;
    public ForbidParentSwipeBackRelativeLayout gju;
    public ParentDisallowInterceptHListView gjv;
    public com.baidu.tieba.ala.livecard.adapters.b gjw;
    private boolean gjx;
    private g gjy;
    AdapterView.c gjz;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gjx = true;
        this.gjz = new AdapterView.c() { // from class: com.baidu.tieba.ala.livecard.b.a.2
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                bw item = a.this.gjw.getItem(i);
                a.this.U(item);
                a.this.a(a.this.mTbPageContext, item);
            }
        };
        this.gju = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.gjp = (ThreadSkinView) getView().findViewById(R.id.frs_thread_skin);
        this.gjq = (TextView) getView().findViewById(R.id.frs_insert_live_label);
        this.gjr = (TextView) getView().findViewById(R.id.frs_insert_live_more);
        this.gjs = (RelativeLayout) getView().findViewById(R.id.frs_insert_live_top);
        this.gjv = (ParentDisallowInterceptHListView) getView().findViewById(R.id.frs_insert_live_listview);
        this.gjt = (LinearLayout) getView().findViewById(R.id.frs_card_content_layout);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.gjv.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.gjv.setBackgroundResource(R.drawable.transparent_bg);
        this.gjv.setOnItemClickListener(this.gjz);
        this.gjv.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.gjw = new com.baidu.tieba.ala.livecard.adapters.b(tbPageContext);
        this.gjv.setAdapter((ListAdapter) this.gjw);
        this.gjr.setOnClickListener(this);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.gjx = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.gjx = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.gju.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.a.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (a.this.gjy != null && !com.baidu.tbadk.core.util.y.isEmpty(a.this.gjy.mcC) && a.this.gjy.mcC.size() > 1) {
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
                    ((BaseActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.gjx);
                } else if (a.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.gjx);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gju, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gjq, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.gjr, (int) R.color.cp_cont_d);
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
            this.gjy = gVar;
            bLQ();
            this.gjw.setData(gVar.mcC);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bLQ() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.gjy.mcC)) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            customMessage.setData(this.gjy.mcC.get(0));
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(bw bwVar) {
        if (bwVar != null) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
            customMessage.setData(bwVar);
            MessageManager.getInstance().sendMessage(customMessage);
            TiebaStatic.log(new aq("c12638"));
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gjr) {
            TiebaStatic.log(new aq("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.mTbPageContext.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        if (tbPageContext != null && bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.beE().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
            if (bwVar.beY() != null && bwVar.beY().user_info != null) {
                alaLiveInfoCoreData.userName = bwVar.beY().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.gjy != null && !com.baidu.tbadk.core.util.y.isEmpty(this.gjy.mcC)) {
                for (bw bwVar2 : this.gjy.mcC) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData S(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
        alaLiveInfoCoreData.userName = bwVar.beE().getUserName();
        return alaLiveInfoCoreData;
    }
}
