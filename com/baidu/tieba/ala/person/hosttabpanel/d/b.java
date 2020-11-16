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
    private static final BdUniqueId hAD = BdUniqueId.gen();
    private AlaLiveUserInfoData aHk;
    private AlaLocationData aHl;
    private AlaRelationData aHm;
    private boolean bhc;
    private int bhd;
    private TextView euO;
    private CustomMessageListener guJ;
    private TextView hAA;
    private DrawableTextView hAB;
    private View hAC;
    private boolean hAE;
    private w hAb;
    private ImageView hAq;
    private ALALevelView hAr;
    private TextView hAs;
    private TextView hAt;
    private TextView hAu;
    private LinearLayout hAv;
    private LinearLayout hAw;
    private TextView hAx;
    private TbImageView hAy;
    private TextView hAz;
    private HeadImageView hhM;
    private com.baidu.live.ah.a hlz;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.bhc = false;
        this.hAE = false;
        this.liveType = 2;
        this.guJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aHk.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.hAD);
                        b.this.hAE = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.bX(z);
                                b.this.bY(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.VO().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.h.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.VO().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.bhc = !b.this.bhc;
                                b.this.bY(b.this.bhc);
                                b.this.bX(b.this.bhc);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.bhc = b.this.bhc ? false : true;
                            b.this.bY(b.this.bhc);
                            b.this.bX(b.this.bhc);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hhM = (HeadImageView) this.mRootView.findViewById(a.f.user_icon);
        this.hhM.setIsRound(true);
        this.hhM.setAutoChangeStyle(false);
        this.euO = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hAq = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        this.hAr = (ALALevelView) this.mRootView.findViewById(a.f.user_grade);
        this.hAs = (TextView) this.mRootView.findViewById(a.f.user_attention_count);
        this.hAt = (TextView) this.mRootView.findViewById(a.f.user_fans_count);
        this.hAu = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hAv = (LinearLayout) this.mRootView.findViewById(a.f.profile_container);
        this.hAw = (LinearLayout) this.mRootView.findViewById(a.f.combat_authen_container);
        this.hAy = (TbImageView) this.mRootView.findViewById(a.f.anthen_icon);
        this.hAx = (TextView) this.mRootView.findViewById(a.f.combat_authen);
        this.hAz = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_go_to_authen);
        this.hAz.getPaint().setFlags(8);
        this.hAz.getPaint().setAntiAlias(true);
        this.hAA = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_reply_user);
        this.hAB = (DrawableTextView) this.mRootView.findViewById(a.f.ala_host_tab_attention_btn);
        this.hAC = this.mRootView.findViewById(a.f.divider_behind_fans_count);
        this.hAv.setOnClickListener(this);
        this.hAz.setOnClickListener(this);
        this.hAA.setOnClickListener(this);
        this.hAB.setOnClickListener(this);
        this.hAs.setOnClickListener(this);
        this.hAt.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.guJ);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ah.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hlz = (com.baidu.live.ah.a) runTask.getData();
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
        if (aVar != null && aVar.hAb != null) {
            this.hAb = aVar.hAb;
            this.aHk = aVar.hAb.aHk;
            this.aHm = aVar.hAb.aHm;
            this.aHl = aVar.hAb.aHl;
            if (this.hAb.mLiveInfo != null) {
                this.liveType = this.hAb.mLiveInfo.live_type;
            }
            if (this.aHk != null && this.aHm != null && this.aHl != null) {
                long j = this.aHk.userId;
                if (this.aHk.portrait != null && !this.aHk.portrait.equals("")) {
                    this.hhM.startLoad(this.aHk.portrait, 12, false);
                }
                this.euO.setText(this.aHk.userName);
                if (j == 0) {
                    this.hAq.setVisibility(8);
                } else {
                    this.hAq.setVisibility(0);
                    this.hAq.setImageResource(this.aHk.sex == 1 ? a.e.sdk_icon_mine_boy : a.e.sdk_icon_mine_girl);
                }
                this.hAr.setupLevelIcon(this.aHk.live_mark_info_new, this.aHk.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aHk.greatAnchorIcon)) {
                        this.hAy.startLoad(this.aHk.greatAnchorIcon, 10, false);
                    } else {
                        this.hAy.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aHk.greatAnchorDescRole) && !StringUtils.isNull(this.aHk.greatAnchorDescGrade)) {
                        this.hAx.setText(this.aHk.greatAnchorDescGrade + this.aHk.greatAnchorDescRole);
                    } else {
                        this.hAw.setVisibility(8);
                    }
                } else {
                    this.hAw.setVisibility(8);
                }
                this.hAs.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aHk.followCount)));
                if (!this.hAE || this.mUserId != this.aHk.userId) {
                    this.hAE = false;
                    this.bhd = this.aHk.fansCount;
                    this.bhc = this.aHm.follow_status != 0;
                    this.mUserId = this.aHk.userId;
                }
                this.hAt.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.bhd)));
                bX(this.bhc);
                if (!StringUtils.isNull(this.aHk.location)) {
                    str = this.aHk.location;
                } else {
                    str = this.aHl.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.hAu.setVisibility(0);
                    this.hAC.setVisibility(0);
                    this.hAu.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_location, str));
                    return;
                }
                this.hAu.setVisibility(4);
                this.hAC.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hAv) {
            ciH();
        } else if (view == this.hAz) {
            if (this.hlz != null && this.hAb != null && this.hAb.aHG != null) {
                this.hlz.a(this.hAb.aHG, "from_host_tab_panel");
            }
        } else if (view == this.hAA) {
            ciJ();
        } else if (view == this.hAB) {
            ciI();
        } else if (view == this.hAs) {
            wP(2);
        } else if (view == this.hAt) {
            wP(1);
        }
    }

    private void wP(int i) {
        if (this.hAb != null && this.hAb.mLiveInfo != null && this.hAb.aHk != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.hAb.aHk;
            String valueOf = String.valueOf(this.hAb.mLiveInfo.group_id);
            z zVar = new z();
            zVar.groupId = valueOf;
            zVar.aIu = false;
            zVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            zVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            zVar.userName = alaLiveUserInfoData.userName;
            zVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.blN = zVar;
            cVar.blO = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void ciH() {
    }

    private void ciI() {
        if (this.aHk != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.hAE = true;
            this.bhc = this.bhc ? false : true;
            if (this.bhc) {
                TiebaInitialize.log("c12558");
            }
            bX(this.bhc);
            bY(this.bhc);
            com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aHk.portrait, String.valueOf(this.aHk.userId), "1", this.bhc, hAD);
            fVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.VO().a(String.valueOf(this.aHk.userId), fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(boolean z) {
        this.bhc = z;
        if (z) {
            this.hAB.setEnabled(false);
            this.hAB.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
            this.hAB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.hAB.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10109));
            this.hAB.setGravity(17);
            return;
        }
        this.hAB.setEnabled(true);
        this.hAB.setText(this.mPageContext.getString(a.h.ala_person_attention));
        this.hAB.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.e.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hAB.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.hAB.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_other_b));
        this.hAB.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(boolean z) {
        if (z) {
            TextView textView = this.hAt;
            Resources resources = this.mPageContext.getResources();
            int i = a.h.ala_host_tab_fans_count;
            int i2 = this.bhd + 1;
            this.bhd = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.hAt;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.h.ala_host_tab_fans_count;
        int i4 = this.bhd - 1;
        this.bhd = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void ciJ() {
        if (this.aHk != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aHk.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aHk.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.aHk)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.blO = (short) 1;
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
        MessageManager.getInstance().unRegisterListener(this.guJ);
        if (this.hlz != null) {
            this.hlz.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b hzY;

        public a(b bVar) {
            super(bVar.getView());
            this.hzY = bVar;
        }
    }
}
