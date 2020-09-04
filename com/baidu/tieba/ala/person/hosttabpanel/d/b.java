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
import com.baidu.live.data.ah;
import com.baidu.live.data.r;
import com.baidu.live.data.u;
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
/* loaded from: classes7.dex */
public class b extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.a> {
    private static final BdUniqueId gQx = BdUniqueId.gen();
    private AlaLiveUserInfoData aDG;
    private AlaLocationData aDH;
    private AlaRelationData aDI;
    private boolean aZV;
    private int aZW;
    private TextView dTU;
    private CustomMessageListener fPH;
    private com.baidu.live.ac.a gCn;
    private r gPV;
    private ImageView gQk;
    private ALALevelView gQl;
    private TextView gQm;
    private TextView gQn;
    private TextView gQo;
    private LinearLayout gQp;
    private LinearLayout gQq;
    private TextView gQr;
    private TbImageView gQs;
    private TextView gQt;
    private TextView gQu;
    private DrawableTextView gQv;
    private View gQw;
    private boolean gQy;
    private HeadImageView gyT;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.aZV = false;
        this.gQy = false;
        this.liveType = 2;
        this.fPH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aDG.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.gQx);
                        b.this.gQy = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.bN(z);
                                b.this.bO(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Qx().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Qx().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.aZV = !b.this.aZV;
                                b.this.bO(b.this.aZV);
                                b.this.bN(b.this.aZV);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.aZV = b.this.aZV ? false : true;
                            b.this.bO(b.this.aZV);
                            b.this.bN(b.this.aZV);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gyT = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.gyT.setIsRound(true);
        this.gyT.setAutoChangeStyle(false);
        this.dTU = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gQk = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.gQl = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.gQm = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.gQn = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.gQo = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gQp = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.gQq = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.gQs = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.gQr = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.gQt = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.gQt.getPaint().setFlags(8);
        this.gQt.getPaint().setAntiAlias(true);
        this.gQu = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.gQv = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.gQw = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.gQp.setOnClickListener(this);
        this.gQt.setOnClickListener(this);
        this.gQu.setOnClickListener(this);
        this.gQv.setOnClickListener(this);
        this.gQm.setOnClickListener(this);
        this.gQn.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.fPH);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ac.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gCn = (com.baidu.live.ac.a) runTask.getData();
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
        if (aVar != null && aVar.gPV != null) {
            this.gPV = aVar.gPV;
            this.aDG = aVar.gPV.aDG;
            this.aDI = aVar.gPV.aDI;
            this.aDH = aVar.gPV.aDH;
            if (this.gPV.mLiveInfo != null) {
                this.liveType = this.gPV.mLiveInfo.live_type;
            }
            if (this.aDG != null && this.aDI != null && this.aDH != null) {
                long j = this.aDG.userId;
                if (this.aDG.portrait != null && !this.aDG.portrait.equals("")) {
                    this.gyT.startLoad(this.aDG.portrait, 12, false);
                }
                this.dTU.setText(this.aDG.userName);
                if (j == 0) {
                    this.gQk.setVisibility(8);
                } else {
                    this.gQk.setVisibility(0);
                    this.gQk.setImageResource(this.aDG.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.gQl.setupLevelIcon(this.aDG.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aDG.greatAnchorIcon)) {
                        this.gQs.startLoad(this.aDG.greatAnchorIcon, 10, false);
                    } else {
                        this.gQs.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aDG.greatAnchorDescRole) && !StringUtils.isNull(this.aDG.greatAnchorDescGrade)) {
                        this.gQr.setText(this.aDG.greatAnchorDescGrade + this.aDG.greatAnchorDescRole);
                    } else {
                        this.gQq.setVisibility(8);
                    }
                } else {
                    this.gQq.setVisibility(8);
                }
                this.gQm.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aDG.followCount)));
                if (!this.gQy || this.mUserId != this.aDG.userId) {
                    this.gQy = false;
                    this.aZW = this.aDG.fansCount;
                    this.aZV = this.aDI.follow_status != 0;
                    this.mUserId = this.aDG.userId;
                }
                this.gQn.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.aZW)));
                bN(this.aZV);
                if (!StringUtils.isNull(this.aDG.location)) {
                    str = this.aDG.location;
                } else {
                    str = this.aDH.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.gQo.setVisibility(0);
                    this.gQw.setVisibility(0);
                    this.gQo.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.gQo.setVisibility(4);
                this.gQw.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gQp) {
            bYq();
        } else if (view == this.gQt) {
            if (this.gCn != null && this.gPV != null && this.gPV.aEf != null) {
                this.gCn.a(this.gPV.aEf, "from_host_tab_panel");
            }
        } else if (view == this.gQu) {
            bYs();
        } else if (view == this.gQv) {
            bYr();
        } else if (view == this.gQm) {
            uL(2);
        } else if (view == this.gQn) {
            uL(1);
        }
    }

    private void uL(int i) {
        if (this.gPV != null && this.gPV.mLiveInfo != null && this.gPV.aDG != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.gPV.aDG;
            String valueOf = String.valueOf(this.gPV.mLiveInfo.group_id);
            u uVar = new u();
            uVar.groupId = valueOf;
            uVar.aEy = false;
            uVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            uVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            uVar.userName = alaLiveUserInfoData.userName;
            uVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.bec = uVar;
            cVar.bed = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void bYq() {
    }

    private void bYr() {
        if (this.aDG != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.gQy = true;
            this.aZV = this.aZV ? false : true;
            if (this.aZV) {
                TiebaInitialize.log("c12558");
            }
            bN(this.aZV);
            bO(this.aZV);
            com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.aDG.portrait, String.valueOf(this.aDG.userId), "1", this.aZV, gQx);
            dVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Qx().a(String.valueOf(this.aDG.userId), dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        this.aZV = z;
        if (z) {
            this.gQv.setEnabled(false);
            this.gQv.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.gQv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gQv.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.gQv.setGravity(17);
            return;
        }
        this.gQv.setEnabled(true);
        this.gQv.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.gQv.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gQv.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.gQv.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.gQv.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(boolean z) {
        if (z) {
            TextView textView = this.gQn;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.aZW + 1;
            this.aZW = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.gQn;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.aZW - 1;
        this.aZW = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bYs() {
        if (this.aDG != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aDG.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aDG.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, c(this.aDG)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bed = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private ah c(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        ah ahVar = new ah();
        ahVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        ahVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        ahVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        ahVar.verify_type = alaLiveUserInfoData.verifyType;
        ahVar.user_name = alaLiveUserInfoData.userName;
        ahVar.user_nickname = alaLiveUserInfoData.userName;
        ahVar.pass_name = alaLiveUserInfoData.passName;
        ahVar.sex = alaLiveUserInfoData.sex;
        ahVar.description = alaLiveUserInfoData.description;
        ahVar.portrait = alaLiveUserInfoData.portrait;
        ahVar.level_id = alaLiveUserInfoData.levelId;
        ahVar.level_exp = alaLiveUserInfoData.levelExp;
        ahVar.is_login = alaLiveUserInfoData.isLogin;
        ahVar.fans_count = alaLiveUserInfoData.fansCount;
        ahVar.follow_count = alaLiveUserInfoData.followCount;
        ahVar.user_status = alaLiveUserInfoData.userStatus;
        ahVar.live_status = alaLiveUserInfoData.liveStatus;
        ahVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        ahVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        ahVar.record_count = alaLiveUserInfoData.recordCount;
        ahVar.location = alaLiveUserInfoData.location;
        ahVar.lng = alaLiveUserInfoData.lng;
        ahVar.lat = alaLiveUserInfoData.lat;
        ahVar.is_block = alaLiveUserInfoData.isBlock;
        ahVar.stream_id = alaLiveUserInfoData.streamID;
        ahVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        ahVar.verify_status = alaLiveUserInfoData.verifyStatus;
        ahVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        ahVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        ahVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        ahVar.petal_num = alaLiveUserInfoData.petalNum;
        return ahVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.fPH);
        if (this.gCn != null) {
            this.gCn.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes7.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b gPS;

        public a(b bVar) {
            super(bVar.getView());
            this.gPS = bVar;
        }
    }
}
