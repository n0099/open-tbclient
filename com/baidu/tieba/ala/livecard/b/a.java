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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.b<g> implements z {
    public View dividerLine;
    public ThreadSkinView hcc;
    public TextView hcd;
    public TextView hce;
    public RelativeLayout hcf;
    public LinearLayout hcg;
    public ForbidParentSwipeBackRelativeLayout hch;
    public ParentDisallowInterceptHListView hci;
    public com.baidu.tieba.ala.livecard.adapters.b hcj;
    private boolean hck;
    private g hcl;
    AdapterView.c hcm;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hck = true;
        this.hcm = new AdapterView.c() { // from class: com.baidu.tieba.ala.livecard.b.a.2
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                by item = a.this.hcj.getItem(i);
                a.this.X(item);
                a.this.a(a.this.mTbPageContext, item);
            }
        };
        this.hch = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.hcc = (ThreadSkinView) getView().findViewById(R.id.frs_thread_skin);
        this.hcd = (TextView) getView().findViewById(R.id.frs_insert_live_label);
        this.hce = (TextView) getView().findViewById(R.id.frs_insert_live_more);
        this.hcf = (RelativeLayout) getView().findViewById(R.id.frs_insert_live_top);
        this.hci = (ParentDisallowInterceptHListView) getView().findViewById(R.id.frs_insert_live_listview);
        this.hcg = (LinearLayout) getView().findViewById(R.id.frs_card_content_layout);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.hci.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.hci.setBackgroundResource(R.drawable.transparent_bg);
        this.hci.setOnItemClickListener(this.hcm);
        this.hci.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.hcj = new com.baidu.tieba.ala.livecard.adapters.b(tbPageContext);
        this.hci.setAdapter((ListAdapter) this.hcj);
        this.hce.setOnClickListener(this);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.hck = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.hck = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.hch.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.a.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (a.this.hcl != null && !y.isEmpty(a.this.hcl.njz) && a.this.hcl.njz.size() > 1) {
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
                    ((BaseActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.hck);
                } else if (a.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) a.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(a.this.hck);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hch, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.hcd, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.hce, (int) R.color.CAM_X0109);
            ap.setBackgroundColor(this.dividerLine, R.color.CAM_X0204);
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
            this.hcl = gVar;
            bZb();
            this.hcj.setData(gVar.njz);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bZb() {
        if (!y.isEmpty(this.hcl.njz)) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            customMessage.setData(this.hcl.njz.get(0));
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(by byVar) {
        if (byVar != null) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
            customMessage.setData(byVar);
            MessageManager.getInstance().sendMessage(customMessage);
            TiebaStatic.log(new ar("c12638"));
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hce) {
            TiebaStatic.log(new ar("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.mTbPageContext.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void a(TbPageContext<?> tbPageContext, by byVar) {
        if (tbPageContext != null && byVar != null && byVar.boP() != null && byVar.bpj() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = byVar.boP().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
            if (byVar.bpj() != null && byVar.bpj().user_info != null) {
                alaLiveInfoCoreData.userName = byVar.bpj().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.hcl != null && !y.isEmpty(this.hcl.njz)) {
                for (by byVar2 : this.hcl.njz) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(byVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData V(by byVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
        alaLiveInfoCoreData.userName = byVar.boP().getUserName();
        return alaLiveInfoCoreData;
    }
}
