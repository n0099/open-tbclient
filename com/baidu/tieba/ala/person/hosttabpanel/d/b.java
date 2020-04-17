package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.n;
import com.baidu.live.data.p;
import com.baidu.live.data.z;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.DrawableTextView;
import com.baidu.live.u.a;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes3.dex */
public class b extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.a> {
    private static final BdUniqueId fWu = BdUniqueId.gen();
    private boolean aKM;
    private int aKN;
    private AlaLiveUserInfoData aqe;
    private AlaLocationData aqf;
    private AlaRelationData aqg;
    private TextView cAX;
    private CustomMessageListener eZZ;
    private HeadImageView fFW;
    private com.baidu.live.aa.a fJe;
    private n fVS;
    private ImageView fWh;
    private ALALevelView fWi;
    private TextView fWj;
    private TextView fWk;
    private TextView fWl;
    private LinearLayout fWm;
    private LinearLayout fWn;
    private TextView fWo;
    private TbImageView fWp;
    private TextView fWq;
    private TextView fWr;
    private DrawableTextView fWs;
    private View fWt;
    private boolean fWv;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.aKM = false;
        this.fWv = false;
        this.liveType = 2;
        this.eZZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aqe.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.fWu);
                        b.this.fWv = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.bu(z);
                                b.this.bv(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Ht().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Ht().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.aKM = !b.this.aKM;
                                b.this.bv(b.this.aKM);
                                b.this.bu(b.this.aKM);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.aKM = b.this.aKM ? false : true;
                            b.this.bv(b.this.aKM);
                            b.this.bu(b.this.aKM);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.fFW = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.fFW.setIsRound(true);
        this.fFW.setAutoChangeStyle(false);
        this.cAX = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fWh = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.fWi = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.fWj = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.fWk = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.fWl = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.fWm = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.fWn = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.fWp = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.fWo = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.fWq = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.fWq.getPaint().setFlags(8);
        this.fWq.getPaint().setAntiAlias(true);
        this.fWr = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.fWs = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.fWt = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.fWm.setOnClickListener(this);
        this.fWq.setOnClickListener(this);
        this.fWr.setOnClickListener(this);
        this.fWs.setOnClickListener(this);
        this.fWj.setOnClickListener(this);
        this.fWk.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.eZZ);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.aa.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fJe = (com.baidu.live.aa.a) runTask.getData();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.h.ala_new_host_tab_profile;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.a aVar) {
        String str;
        if (aVar != null && aVar.fVS != null) {
            this.fVS = aVar.fVS;
            this.aqe = aVar.fVS.aqe;
            this.aqg = aVar.fVS.aqg;
            this.aqf = aVar.fVS.aqf;
            if (this.fVS.mLiveInfo != null) {
                this.liveType = this.fVS.mLiveInfo.live_type;
            }
            if (this.aqe != null && this.aqg != null && this.aqf != null) {
                long j = this.aqe.userId;
                if (this.aqe.portrait != null && !this.aqe.portrait.equals("")) {
                    this.fFW.startLoad(this.aqe.portrait, 12, false);
                }
                this.cAX.setText(this.aqe.userName);
                if (j == 0) {
                    this.fWh.setVisibility(8);
                } else {
                    this.fWh.setVisibility(0);
                    this.fWh.setImageResource(this.aqe.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.fWi.setupLevelIcon(this.aqe.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aqe.greatAnchorIcon)) {
                        this.fWp.startLoad(this.aqe.greatAnchorIcon, 10, false);
                    } else {
                        this.fWp.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aqe.greatAnchorDescRole) && !StringUtils.isNull(this.aqe.greatAnchorDescGrade)) {
                        this.fWo.setText(this.aqe.greatAnchorDescGrade + this.aqe.greatAnchorDescRole);
                    } else {
                        this.fWn.setVisibility(8);
                    }
                } else {
                    this.fWn.setVisibility(8);
                }
                this.fWj.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aqe.followCount)));
                if (!this.fWv || this.mUserId != this.aqe.userId) {
                    this.fWv = false;
                    this.aKN = this.aqe.fansCount;
                    this.aKM = this.aqg.follow_status != 0;
                    this.mUserId = this.aqe.userId;
                }
                this.fWk.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.aKN)));
                bu(this.aKM);
                if (!StringUtils.isNull(this.aqe.location)) {
                    str = this.aqe.location;
                } else {
                    str = this.aqf.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.fWl.setVisibility(0);
                    this.fWt.setVisibility(0);
                    this.fWl.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.fWl.setVisibility(4);
                this.fWt.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fWm) {
            bBJ();
        } else if (view == this.fWq) {
            if (this.fJe != null && this.fVS != null && this.fVS.aqx != null) {
                this.fJe.a(this.fVS.aqx, "from_host_tab_panel");
            }
        } else if (view == this.fWr) {
            bBL();
        } else if (view == this.fWs) {
            bBK();
        } else if (view == this.fWj) {
            rd(2);
        } else if (view == this.fWk) {
            rd(1);
        }
    }

    private void rd(int i) {
        if (this.fVS != null && this.fVS.mLiveInfo != null && this.fVS.aqe != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.fVS.aqe;
            String valueOf = String.valueOf(this.fVS.mLiveInfo.group_id);
            p pVar = new p();
            pVar.groupId = valueOf;
            pVar.aqL = false;
            pVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            pVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            pVar.userName = alaLiveUserInfoData.userName;
            pVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.aPN = pVar;
            cVar.aPO = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void bBJ() {
    }

    private void bBK() {
        if (this.aqe != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.fWv = true;
            this.aKM = this.aKM ? false : true;
            if (this.aKM) {
                TiebaInitialize.log("c12558");
            }
            bu(this.aKM);
            bv(this.aKM);
            com.baidu.live.data.b bVar = new com.baidu.live.data.b(this.aqe.portrait, String.valueOf(this.aqe.userId), "1", this.aKM, fWu);
            bVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Ht().a(String.valueOf(this.aqe.userId), bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(boolean z) {
        this.aKM = z;
        if (z) {
            this.fWs.setEnabled(false);
            this.fWs.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.fWs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fWs.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.fWs.setGravity(17);
            return;
        }
        this.fWs.setEnabled(true);
        this.fWs.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.fWs.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fWs.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.fWs.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.fWs.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(boolean z) {
        if (z) {
            TextView textView = this.fWk;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.aKN + 1;
            this.aKN = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.fWk;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.aKN - 1;
        this.aKN = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bBL() {
        if (this.aqe != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aqe.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aqe.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, c(this.aqe)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.aPO = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private z c(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        z zVar = new z();
        zVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        zVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        zVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        zVar.verify_type = alaLiveUserInfoData.verifyType;
        zVar.user_name = alaLiveUserInfoData.userName;
        zVar.user_nickname = alaLiveUserInfoData.userName;
        zVar.pass_name = alaLiveUserInfoData.passName;
        zVar.sex = alaLiveUserInfoData.sex;
        zVar.description = alaLiveUserInfoData.description;
        zVar.portrait = alaLiveUserInfoData.portrait;
        zVar.level_id = alaLiveUserInfoData.levelId;
        zVar.level_exp = alaLiveUserInfoData.levelExp;
        zVar.is_login = alaLiveUserInfoData.isLogin;
        zVar.fans_count = alaLiveUserInfoData.fansCount;
        zVar.follow_count = alaLiveUserInfoData.followCount;
        zVar.user_status = alaLiveUserInfoData.userStatus;
        zVar.live_status = alaLiveUserInfoData.liveStatus;
        zVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        zVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        zVar.record_count = alaLiveUserInfoData.recordCount;
        zVar.location = alaLiveUserInfoData.location;
        zVar.lng = alaLiveUserInfoData.lng;
        zVar.lat = alaLiveUserInfoData.lat;
        zVar.is_block = alaLiveUserInfoData.isBlock;
        zVar.stream_id = alaLiveUserInfoData.streamID;
        zVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        zVar.verify_status = alaLiveUserInfoData.verifyStatus;
        zVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        zVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        zVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        zVar.petal_num = alaLiveUserInfoData.petalNum;
        return zVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.eZZ);
        if (this.fJe != null) {
            this.fJe.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b fVP;

        public a(b bVar) {
            super(bVar.getView());
            this.fVP = bVar;
        }
    }
}
