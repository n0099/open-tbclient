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
import com.baidu.live.data.ab;
import com.baidu.live.data.at;
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class b extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.a> {
    private static final BdUniqueId hRP = BdUniqueId.gen();
    private AlaLiveUserInfoData aFH;
    private AlaLocationData aFI;
    private AlaRelationData aFJ;
    private boolean bik;
    private int bil;
    private TextView eGI;
    private CustomMessageListener gKA;
    private com.baidu.live.am.a hCq;
    private ImageView hRC;
    private ALALevelView hRD;
    private TextView hRE;
    private TextView hRF;
    private TextView hRG;
    private LinearLayout hRH;
    private LinearLayout hRI;
    private TextView hRJ;
    private TbImageView hRK;
    private TextView hRL;
    private TextView hRM;
    private DrawableTextView hRN;
    private View hRO;
    private boolean hRQ;
    private x hRn;
    private HeadImageView hyH;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.bik = false;
        this.hRQ = false;
        this.liveType = 2;
        this.gKA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aFH.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.hRP);
                        b.this.hRQ = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.cc(z);
                                b.this.cd(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.VF().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.h.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.VF().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.bik = !b.this.bik;
                                b.this.cd(b.this.bik);
                                b.this.cc(b.this.bik);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.bik = b.this.bik ? false : true;
                            b.this.cd(b.this.bik);
                            b.this.cc(b.this.bik);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hyH = (HeadImageView) this.mRootView.findViewById(a.f.user_icon);
        this.hyH.setIsRound(true);
        this.hyH.setAutoChangeStyle(false);
        this.eGI = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hRC = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        this.hRD = (ALALevelView) this.mRootView.findViewById(a.f.user_grade);
        this.hRE = (TextView) this.mRootView.findViewById(a.f.user_attention_count);
        this.hRF = (TextView) this.mRootView.findViewById(a.f.user_fans_count);
        this.hRG = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hRH = (LinearLayout) this.mRootView.findViewById(a.f.profile_container);
        this.hRI = (LinearLayout) this.mRootView.findViewById(a.f.combat_authen_container);
        this.hRK = (TbImageView) this.mRootView.findViewById(a.f.anthen_icon);
        this.hRJ = (TextView) this.mRootView.findViewById(a.f.combat_authen);
        this.hRL = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_go_to_authen);
        this.hRL.getPaint().setFlags(8);
        this.hRL.getPaint().setAntiAlias(true);
        this.hRM = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_reply_user);
        this.hRN = (DrawableTextView) this.mRootView.findViewById(a.f.ala_host_tab_attention_btn);
        this.hRO = this.mRootView.findViewById(a.f.divider_behind_fans_count);
        this.hRH.setOnClickListener(this);
        this.hRL.setOnClickListener(this);
        this.hRM.setOnClickListener(this);
        this.hRN.setOnClickListener(this);
        this.hRE.setOnClickListener(this);
        this.hRF.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.gKA);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.am.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hCq = (com.baidu.live.am.a) runTask.getData();
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
        if (aVar != null && aVar.hRn != null) {
            this.hRn = aVar.hRn;
            this.aFH = aVar.hRn.aFH;
            this.aFJ = aVar.hRn.aFJ;
            this.aFI = aVar.hRn.aFI;
            if (this.hRn.mLiveInfo != null) {
                this.liveType = this.hRn.mLiveInfo.live_type;
            }
            if (this.aFH != null && this.aFJ != null && this.aFI != null) {
                long j = this.aFH.userId;
                if (this.aFH.portrait != null && !this.aFH.portrait.equals("")) {
                    this.hyH.startLoad(this.aFH.portrait, 12, false);
                }
                this.eGI.setText(this.aFH.userName);
                if (j == 0) {
                    this.hRC.setVisibility(8);
                } else {
                    this.hRC.setVisibility(0);
                    this.hRC.setImageResource(this.aFH.sex == 1 ? a.e.sdk_icon_mine_boy : a.e.sdk_icon_mine_girl);
                }
                this.hRD.setupLevelIcon(this.aFH.live_mark_info_new, this.aFH.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aFH.greatAnchorIcon)) {
                        this.hRK.startLoad(this.aFH.greatAnchorIcon, 10, false);
                    } else {
                        this.hRK.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aFH.greatAnchorDescRole) && !StringUtils.isNull(this.aFH.greatAnchorDescGrade)) {
                        this.hRJ.setText(this.aFH.greatAnchorDescGrade + this.aFH.greatAnchorDescRole);
                    } else {
                        this.hRI.setVisibility(8);
                    }
                } else {
                    this.hRI.setVisibility(8);
                }
                this.hRE.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aFH.followCount)));
                if (!this.hRQ || this.mUserId != this.aFH.userId) {
                    this.hRQ = false;
                    this.bil = this.aFH.fansCount;
                    this.bik = this.aFJ.follow_status != 0;
                    this.mUserId = this.aFH.userId;
                }
                this.hRF.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.bil)));
                cc(this.bik);
                if (!StringUtils.isNull(this.aFH.location)) {
                    str = this.aFH.location;
                } else {
                    str = this.aFI.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.hRG.setVisibility(0);
                    this.hRO.setVisibility(0);
                    this.hRG.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_location, str));
                    return;
                }
                this.hRG.setVisibility(4);
                this.hRO.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hRH) {
            clC();
        } else if (view == this.hRL) {
            if (this.hCq != null && this.hRn != null && this.hRn.aGd != null) {
                this.hCq.a(this.hRn.aGd, "from_host_tab_panel");
            }
        } else if (view == this.hRM) {
            clE();
        } else if (view == this.hRN) {
            clD();
        } else if (view == this.hRE) {
            wb(2);
        } else if (view == this.hRF) {
            wb(1);
        }
    }

    private void wb(int i) {
        if (this.hRn != null && this.hRn.mLiveInfo != null && this.hRn.aFH != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.hRn.aFH;
            String valueOf = String.valueOf(this.hRn.mLiveInfo.group_id);
            ab abVar = new ab();
            abVar.groupId = valueOf;
            abVar.aGY = false;
            abVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            abVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            abVar.userName = alaLiveUserInfoData.userName;
            abVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.boc = abVar;
            cVar.bod = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void clC() {
    }

    private void clD() {
        if (this.aFH != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.hRQ = true;
            this.bik = this.bik ? false : true;
            if (this.bik) {
                TiebaInitialize.log("c12558");
            }
            cc(this.bik);
            cd(this.bik);
            com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aFH.portrait, String.valueOf(this.aFH.userId), "1", this.bik, hRP);
            fVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.VF().a(String.valueOf(this.aFH.userId), fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(boolean z) {
        this.bik = z;
        if (z) {
            this.hRN.setEnabled(false);
            this.hRN.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
            this.hRN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.hRN.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10109));
            this.hRN.setGravity(17);
            return;
        }
        this.hRN.setEnabled(true);
        this.hRN.setText(this.mPageContext.getString(a.h.ala_person_attention));
        this.hRN.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.e.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hRN.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.hRN.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_other_b));
        this.hRN.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(boolean z) {
        if (z) {
            TextView textView = this.hRF;
            Resources resources = this.mPageContext.getResources();
            int i = a.h.ala_host_tab_fans_count;
            int i2 = this.bil + 1;
            this.bil = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.hRF;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.h.ala_host_tab_fans_count;
        int i4 = this.bil - 1;
        this.bil = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void clE() {
        if (this.aFH != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aFH.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aFH.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.aFH)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bod = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private at b(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        at atVar = new at();
        atVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        atVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        atVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        atVar.verify_type = alaLiveUserInfoData.verifyType;
        atVar.user_name = alaLiveUserInfoData.userName;
        atVar.user_nickname = alaLiveUserInfoData.userName;
        atVar.pass_name = alaLiveUserInfoData.passName;
        atVar.sex = alaLiveUserInfoData.sex;
        atVar.description = alaLiveUserInfoData.description;
        atVar.portrait = alaLiveUserInfoData.portrait;
        atVar.level_id = alaLiveUserInfoData.levelId;
        atVar.level_exp = alaLiveUserInfoData.levelExp;
        atVar.is_login = alaLiveUserInfoData.isLogin;
        atVar.fans_count = alaLiveUserInfoData.fansCount;
        atVar.follow_count = alaLiveUserInfoData.followCount;
        atVar.user_status = alaLiveUserInfoData.userStatus;
        atVar.live_status = alaLiveUserInfoData.liveStatus;
        atVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        atVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        atVar.record_count = alaLiveUserInfoData.recordCount;
        atVar.location = alaLiveUserInfoData.location;
        atVar.lng = alaLiveUserInfoData.lng;
        atVar.lat = alaLiveUserInfoData.lat;
        atVar.is_block = alaLiveUserInfoData.isBlock;
        atVar.stream_id = alaLiveUserInfoData.streamID;
        atVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        atVar.verify_status = alaLiveUserInfoData.verifyStatus;
        atVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        atVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        atVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        atVar.petal_num = alaLiveUserInfoData.petalNum;
        return atVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.gKA);
        if (this.hCq != null) {
            this.hCq.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes10.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b hRk;

        public a(b bVar) {
            super(bVar.getView());
            this.hRk = bVar;
        }
    }
}
