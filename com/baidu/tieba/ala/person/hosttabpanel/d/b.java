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
import com.baidu.live.data.aq;
import com.baidu.live.data.w;
import com.baidu.live.data.z;
import com.baidu.live.sdk.a;
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
import com.baidu.live.view.ALALevelView;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.a> {
    private static final BdUniqueId hAW = BdUniqueId.gen();
    private AlaLiveUserInfoData aIV;
    private AlaLocationData aIW;
    private AlaRelationData aIX;
    private boolean biQ;
    private int biR;
    private TextView ewx;
    private CustomMessageListener gvc;
    private ImageView hAJ;
    private ALALevelView hAK;
    private TextView hAL;
    private TextView hAM;
    private TextView hAN;
    private LinearLayout hAO;
    private LinearLayout hAP;
    private TextView hAQ;
    private TbImageView hAR;
    private TextView hAS;
    private TextView hAT;
    private DrawableTextView hAU;
    private View hAV;
    private boolean hAX;
    private w hAu;
    private HeadImageView hig;
    private com.baidu.live.ah.a hlS;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.biQ = false;
        this.hAX = false;
        this.liveType = 2;
        this.gvc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aIV.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.hAW);
                        b.this.hAX = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.bV(z);
                                b.this.bW(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Wx().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.h.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Wx().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.biQ = !b.this.biQ;
                                b.this.bW(b.this.biQ);
                                b.this.bV(b.this.biQ);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.biQ = b.this.biQ ? false : true;
                            b.this.bW(b.this.biQ);
                            b.this.bV(b.this.biQ);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hig = (HeadImageView) this.mRootView.findViewById(a.f.user_icon);
        this.hig.setIsRound(true);
        this.hig.setAutoChangeStyle(false);
        this.ewx = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hAJ = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        this.hAK = (ALALevelView) this.mRootView.findViewById(a.f.user_grade);
        this.hAL = (TextView) this.mRootView.findViewById(a.f.user_attention_count);
        this.hAM = (TextView) this.mRootView.findViewById(a.f.user_fans_count);
        this.hAN = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hAO = (LinearLayout) this.mRootView.findViewById(a.f.profile_container);
        this.hAP = (LinearLayout) this.mRootView.findViewById(a.f.combat_authen_container);
        this.hAR = (TbImageView) this.mRootView.findViewById(a.f.anthen_icon);
        this.hAQ = (TextView) this.mRootView.findViewById(a.f.combat_authen);
        this.hAS = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_go_to_authen);
        this.hAS.getPaint().setFlags(8);
        this.hAS.getPaint().setAntiAlias(true);
        this.hAT = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_reply_user);
        this.hAU = (DrawableTextView) this.mRootView.findViewById(a.f.ala_host_tab_attention_btn);
        this.hAV = this.mRootView.findViewById(a.f.divider_behind_fans_count);
        this.hAO.setOnClickListener(this);
        this.hAS.setOnClickListener(this);
        this.hAT.setOnClickListener(this);
        this.hAU.setOnClickListener(this);
        this.hAL.setOnClickListener(this);
        this.hAM.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.gvc);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ah.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hlS = (com.baidu.live.ah.a) runTask.getData();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.g.ala_new_host_tab_profile;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.a aVar) {
        String str;
        if (aVar != null && aVar.hAu != null) {
            this.hAu = aVar.hAu;
            this.aIV = aVar.hAu.aIV;
            this.aIX = aVar.hAu.aIX;
            this.aIW = aVar.hAu.aIW;
            if (this.hAu.mLiveInfo != null) {
                this.liveType = this.hAu.mLiveInfo.live_type;
            }
            if (this.aIV != null && this.aIX != null && this.aIW != null) {
                long j = this.aIV.userId;
                if (this.aIV.portrait != null && !this.aIV.portrait.equals("")) {
                    this.hig.startLoad(this.aIV.portrait, 12, false);
                }
                this.ewx.setText(this.aIV.userName);
                if (j == 0) {
                    this.hAJ.setVisibility(8);
                } else {
                    this.hAJ.setVisibility(0);
                    this.hAJ.setImageResource(this.aIV.sex == 1 ? a.e.sdk_icon_mine_boy : a.e.sdk_icon_mine_girl);
                }
                this.hAK.setupLevelIcon(this.aIV.live_mark_info_new, this.aIV.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aIV.greatAnchorIcon)) {
                        this.hAR.startLoad(this.aIV.greatAnchorIcon, 10, false);
                    } else {
                        this.hAR.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aIV.greatAnchorDescRole) && !StringUtils.isNull(this.aIV.greatAnchorDescGrade)) {
                        this.hAQ.setText(this.aIV.greatAnchorDescGrade + this.aIV.greatAnchorDescRole);
                    } else {
                        this.hAP.setVisibility(8);
                    }
                } else {
                    this.hAP.setVisibility(8);
                }
                this.hAL.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aIV.followCount)));
                if (!this.hAX || this.mUserId != this.aIV.userId) {
                    this.hAX = false;
                    this.biR = this.aIV.fansCount;
                    this.biQ = this.aIX.follow_status != 0;
                    this.mUserId = this.aIV.userId;
                }
                this.hAM.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.biR)));
                bV(this.biQ);
                if (!StringUtils.isNull(this.aIV.location)) {
                    str = this.aIV.location;
                } else {
                    str = this.aIW.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.hAN.setVisibility(0);
                    this.hAV.setVisibility(0);
                    this.hAN.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_location, str));
                    return;
                }
                this.hAN.setVisibility(4);
                this.hAV.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hAO) {
            cjo();
        } else if (view == this.hAS) {
            if (this.hlS != null && this.hAu != null && this.hAu.aJr != null) {
                this.hlS.a(this.hAu.aJr, "from_host_tab_panel");
            }
        } else if (view == this.hAT) {
            cjq();
        } else if (view == this.hAU) {
            cjp();
        } else if (view == this.hAL) {
            wr(2);
        } else if (view == this.hAM) {
            wr(1);
        }
    }

    private void wr(int i) {
        if (this.hAu != null && this.hAu.mLiveInfo != null && this.hAu.aIV != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.hAu.aIV;
            String valueOf = String.valueOf(this.hAu.mLiveInfo.group_id);
            z zVar = new z();
            zVar.groupId = valueOf;
            zVar.aKf = false;
            zVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            zVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            zVar.userName = alaLiveUserInfoData.userName;
            zVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.bny = zVar;
            cVar.bnz = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void cjo() {
    }

    private void cjp() {
        if (this.aIV != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.hAX = true;
            this.biQ = this.biQ ? false : true;
            if (this.biQ) {
                TiebaInitialize.log("c12558");
            }
            bV(this.biQ);
            bW(this.biQ);
            com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aIV.portrait, String.valueOf(this.aIV.userId), "1", this.biQ, hAW);
            fVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Wx().a(String.valueOf(this.aIV.userId), fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(boolean z) {
        this.biQ = z;
        if (z) {
            this.hAU.setEnabled(false);
            this.hAU.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
            this.hAU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.hAU.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10109));
            this.hAU.setGravity(17);
            return;
        }
        this.hAU.setEnabled(true);
        this.hAU.setText(this.mPageContext.getString(a.h.ala_person_attention));
        this.hAU.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.e.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hAU.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.hAU.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_other_b));
        this.hAU.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(boolean z) {
        if (z) {
            TextView textView = this.hAM;
            Resources resources = this.mPageContext.getResources();
            int i = a.h.ala_host_tab_fans_count;
            int i2 = this.biR + 1;
            this.biR = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.hAM;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.h.ala_host_tab_fans_count;
        int i4 = this.biR - 1;
        this.biR = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void cjq() {
        if (this.aIV != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aIV.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aIV.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.aIV)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bnz = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private aq b(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        aqVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        aqVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        aqVar.verify_type = alaLiveUserInfoData.verifyType;
        aqVar.user_name = alaLiveUserInfoData.userName;
        aqVar.user_nickname = alaLiveUserInfoData.userName;
        aqVar.pass_name = alaLiveUserInfoData.passName;
        aqVar.sex = alaLiveUserInfoData.sex;
        aqVar.description = alaLiveUserInfoData.description;
        aqVar.portrait = alaLiveUserInfoData.portrait;
        aqVar.level_id = alaLiveUserInfoData.levelId;
        aqVar.level_exp = alaLiveUserInfoData.levelExp;
        aqVar.is_login = alaLiveUserInfoData.isLogin;
        aqVar.fans_count = alaLiveUserInfoData.fansCount;
        aqVar.follow_count = alaLiveUserInfoData.followCount;
        aqVar.user_status = alaLiveUserInfoData.userStatus;
        aqVar.live_status = alaLiveUserInfoData.liveStatus;
        aqVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        aqVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        aqVar.record_count = alaLiveUserInfoData.recordCount;
        aqVar.location = alaLiveUserInfoData.location;
        aqVar.lng = alaLiveUserInfoData.lng;
        aqVar.lat = alaLiveUserInfoData.lat;
        aqVar.is_block = alaLiveUserInfoData.isBlock;
        aqVar.stream_id = alaLiveUserInfoData.streamID;
        aqVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        aqVar.verify_status = alaLiveUserInfoData.verifyStatus;
        aqVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        aqVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        aqVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        aqVar.petal_num = alaLiveUserInfoData.petalNum;
        return aqVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.gvc);
        if (this.hlS != null) {
            this.hlS.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b hAr;

        public a(b bVar) {
            super(bVar.getView());
            this.hAr = bVar;
        }
    }
}
