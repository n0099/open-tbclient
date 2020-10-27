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
import com.baidu.live.data.ap;
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
    private static final BdUniqueId huZ = BdUniqueId.gen();
    private AlaLiveUserInfoData aIe;
    private AlaLocationData aIf;
    private AlaRelationData aIg;
    private boolean bhu;
    private int bhv;
    private TextView eqE;
    private CustomMessageListener gpo;
    private HeadImageView hck;
    private com.baidu.live.ag.a hfX;
    private ImageView huM;
    private ALALevelView huN;
    private TextView huO;
    private TextView huP;
    private TextView huQ;
    private LinearLayout huR;
    private LinearLayout huS;
    private TextView huT;
    private TbImageView huU;
    private TextView huV;
    private TextView huW;
    private DrawableTextView huX;
    private View huY;
    private w hux;
    private boolean hva;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.bhu = false;
        this.hva = false;
        this.liveType = 2;
        this.gpo = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aIe.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.huZ);
                        b.this.hva = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.bU(z);
                                b.this.bV(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.TX().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.TX().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.bhu = !b.this.bhu;
                                b.this.bV(b.this.bhu);
                                b.this.bU(b.this.bhu);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.bhu = b.this.bhu ? false : true;
                            b.this.bV(b.this.bhu);
                            b.this.bU(b.this.bhu);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hck = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.hck.setIsRound(true);
        this.hck.setAutoChangeStyle(false);
        this.eqE = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.huM = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.huN = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.huO = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.huP = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.huQ = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.huR = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.huS = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.huU = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.huT = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.huV = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.huV.getPaint().setFlags(8);
        this.huV.getPaint().setAntiAlias(true);
        this.huW = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.huX = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.huY = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.huR.setOnClickListener(this);
        this.huV.setOnClickListener(this);
        this.huW.setOnClickListener(this);
        this.huX.setOnClickListener(this);
        this.huO.setOnClickListener(this);
        this.huP.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.gpo);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ag.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hfX = (com.baidu.live.ag.a) runTask.getData();
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
        if (aVar != null && aVar.hux != null) {
            this.hux = aVar.hux;
            this.aIe = aVar.hux.aIe;
            this.aIg = aVar.hux.aIg;
            this.aIf = aVar.hux.aIf;
            if (this.hux.mLiveInfo != null) {
                this.liveType = this.hux.mLiveInfo.live_type;
            }
            if (this.aIe != null && this.aIg != null && this.aIf != null) {
                long j = this.aIe.userId;
                if (this.aIe.portrait != null && !this.aIe.portrait.equals("")) {
                    this.hck.startLoad(this.aIe.portrait, 12, false);
                }
                this.eqE.setText(this.aIe.userName);
                if (j == 0) {
                    this.huM.setVisibility(8);
                } else {
                    this.huM.setVisibility(0);
                    this.huM.setImageResource(this.aIe.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.huN.setupLevelIcon(this.aIe.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aIe.greatAnchorIcon)) {
                        this.huU.startLoad(this.aIe.greatAnchorIcon, 10, false);
                    } else {
                        this.huU.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aIe.greatAnchorDescRole) && !StringUtils.isNull(this.aIe.greatAnchorDescGrade)) {
                        this.huT.setText(this.aIe.greatAnchorDescGrade + this.aIe.greatAnchorDescRole);
                    } else {
                        this.huS.setVisibility(8);
                    }
                } else {
                    this.huS.setVisibility(8);
                }
                this.huO.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aIe.followCount)));
                if (!this.hva || this.mUserId != this.aIe.userId) {
                    this.hva = false;
                    this.bhv = this.aIe.fansCount;
                    this.bhu = this.aIg.follow_status != 0;
                    this.mUserId = this.aIe.userId;
                }
                this.huP.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.bhv)));
                bU(this.bhu);
                if (!StringUtils.isNull(this.aIe.location)) {
                    str = this.aIe.location;
                } else {
                    str = this.aIf.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.huQ.setVisibility(0);
                    this.huY.setVisibility(0);
                    this.huQ.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.huQ.setVisibility(4);
                this.huY.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.huR) {
            cgM();
        } else if (view == this.huV) {
            if (this.hfX != null && this.hux != null && this.hux.aIA != null) {
                this.hfX.a(this.hux.aIA, "from_host_tab_panel");
            }
        } else if (view == this.huW) {
            cgO();
        } else if (view == this.huX) {
            cgN();
        } else if (view == this.huO) {
            we(2);
        } else if (view == this.huP) {
            we(1);
        }
    }

    private void we(int i) {
        if (this.hux != null && this.hux.mLiveInfo != null && this.hux.aIe != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.hux.aIe;
            String valueOf = String.valueOf(this.hux.mLiveInfo.group_id);
            z zVar = new z();
            zVar.groupId = valueOf;
            zVar.aJi = false;
            zVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            zVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            zVar.userName = alaLiveUserInfoData.userName;
            zVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.bme = zVar;
            cVar.bmf = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void cgM() {
    }

    private void cgN() {
        if (this.aIe != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.hva = true;
            this.bhu = this.bhu ? false : true;
            if (this.bhu) {
                TiebaInitialize.log("c12558");
            }
            bU(this.bhu);
            bV(this.bhu);
            com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aIe.portrait, String.valueOf(this.aIe.userId), "1", this.bhu, huZ);
            fVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.TX().a(String.valueOf(this.aIe.userId), fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(boolean z) {
        this.bhu = z;
        if (z) {
            this.huX.setEnabled(false);
            this.huX.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.huX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.huX.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.huX.setGravity(17);
            return;
        }
        this.huX.setEnabled(true);
        this.huX.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.huX.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.huX.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.huX.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.huX.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(boolean z) {
        if (z) {
            TextView textView = this.huP;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.bhv + 1;
            this.bhv = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.huP;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.bhv - 1;
        this.bhv = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void cgO() {
        if (this.aIe != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aIe.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aIe.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.aIe)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bmf = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private ap b(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        ap apVar = new ap();
        apVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        apVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        apVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        apVar.verify_type = alaLiveUserInfoData.verifyType;
        apVar.user_name = alaLiveUserInfoData.userName;
        apVar.user_nickname = alaLiveUserInfoData.userName;
        apVar.pass_name = alaLiveUserInfoData.passName;
        apVar.sex = alaLiveUserInfoData.sex;
        apVar.description = alaLiveUserInfoData.description;
        apVar.portrait = alaLiveUserInfoData.portrait;
        apVar.level_id = alaLiveUserInfoData.levelId;
        apVar.level_exp = alaLiveUserInfoData.levelExp;
        apVar.is_login = alaLiveUserInfoData.isLogin;
        apVar.fans_count = alaLiveUserInfoData.fansCount;
        apVar.follow_count = alaLiveUserInfoData.followCount;
        apVar.user_status = alaLiveUserInfoData.userStatus;
        apVar.live_status = alaLiveUserInfoData.liveStatus;
        apVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        apVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        apVar.record_count = alaLiveUserInfoData.recordCount;
        apVar.location = alaLiveUserInfoData.location;
        apVar.lng = alaLiveUserInfoData.lng;
        apVar.lat = alaLiveUserInfoData.lat;
        apVar.is_block = alaLiveUserInfoData.isBlock;
        apVar.stream_id = alaLiveUserInfoData.streamID;
        apVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        apVar.verify_status = alaLiveUserInfoData.verifyStatus;
        apVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        apVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        apVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        apVar.petal_num = alaLiveUserInfoData.petalNum;
        return apVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.gpo);
        if (this.hfX != null) {
            this.hfX.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b huu;

        public a(b bVar) {
            super(bVar.getView());
            this.huu = bVar;
        }
    }
}
