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
    private static final BdUniqueId gQt = BdUniqueId.gen();
    private AlaLiveUserInfoData aDE;
    private AlaLocationData aDF;
    private AlaRelationData aDG;
    private boolean aZT;
    private int aZU;
    private TextView dTQ;
    private CustomMessageListener fPD;
    private com.baidu.live.ac.a gCj;
    private r gPR;
    private ImageView gQg;
    private ALALevelView gQh;
    private TextView gQi;
    private TextView gQj;
    private TextView gQk;
    private LinearLayout gQl;
    private LinearLayout gQm;
    private TextView gQn;
    private TbImageView gQo;
    private TextView gQp;
    private TextView gQq;
    private DrawableTextView gQr;
    private View gQs;
    private boolean gQu;
    private HeadImageView gyP;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.aZT = false;
        this.gQu = false;
        this.liveType = 2;
        this.fPD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aDE.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.gQt);
                        b.this.gQu = true;
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
                                b.this.aZT = !b.this.aZT;
                                b.this.bO(b.this.aZT);
                                b.this.bN(b.this.aZT);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.aZT = b.this.aZT ? false : true;
                            b.this.bO(b.this.aZT);
                            b.this.bN(b.this.aZT);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gyP = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.gyP.setIsRound(true);
        this.gyP.setAutoChangeStyle(false);
        this.dTQ = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gQg = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.gQh = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.gQi = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.gQj = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.gQk = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gQl = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.gQm = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.gQo = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.gQn = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.gQp = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.gQp.getPaint().setFlags(8);
        this.gQp.getPaint().setAntiAlias(true);
        this.gQq = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.gQr = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.gQs = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.gQl.setOnClickListener(this);
        this.gQp.setOnClickListener(this);
        this.gQq.setOnClickListener(this);
        this.gQr.setOnClickListener(this);
        this.gQi.setOnClickListener(this);
        this.gQj.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.fPD);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ac.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gCj = (com.baidu.live.ac.a) runTask.getData();
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
        if (aVar != null && aVar.gPR != null) {
            this.gPR = aVar.gPR;
            this.aDE = aVar.gPR.aDE;
            this.aDG = aVar.gPR.aDG;
            this.aDF = aVar.gPR.aDF;
            if (this.gPR.mLiveInfo != null) {
                this.liveType = this.gPR.mLiveInfo.live_type;
            }
            if (this.aDE != null && this.aDG != null && this.aDF != null) {
                long j = this.aDE.userId;
                if (this.aDE.portrait != null && !this.aDE.portrait.equals("")) {
                    this.gyP.startLoad(this.aDE.portrait, 12, false);
                }
                this.dTQ.setText(this.aDE.userName);
                if (j == 0) {
                    this.gQg.setVisibility(8);
                } else {
                    this.gQg.setVisibility(0);
                    this.gQg.setImageResource(this.aDE.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.gQh.setupLevelIcon(this.aDE.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aDE.greatAnchorIcon)) {
                        this.gQo.startLoad(this.aDE.greatAnchorIcon, 10, false);
                    } else {
                        this.gQo.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aDE.greatAnchorDescRole) && !StringUtils.isNull(this.aDE.greatAnchorDescGrade)) {
                        this.gQn.setText(this.aDE.greatAnchorDescGrade + this.aDE.greatAnchorDescRole);
                    } else {
                        this.gQm.setVisibility(8);
                    }
                } else {
                    this.gQm.setVisibility(8);
                }
                this.gQi.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aDE.followCount)));
                if (!this.gQu || this.mUserId != this.aDE.userId) {
                    this.gQu = false;
                    this.aZU = this.aDE.fansCount;
                    this.aZT = this.aDG.follow_status != 0;
                    this.mUserId = this.aDE.userId;
                }
                this.gQj.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.aZU)));
                bN(this.aZT);
                if (!StringUtils.isNull(this.aDE.location)) {
                    str = this.aDE.location;
                } else {
                    str = this.aDF.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.gQk.setVisibility(0);
                    this.gQs.setVisibility(0);
                    this.gQk.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.gQk.setVisibility(4);
                this.gQs.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gQl) {
            bYp();
        } else if (view == this.gQp) {
            if (this.gCj != null && this.gPR != null && this.gPR.aEd != null) {
                this.gCj.a(this.gPR.aEd, "from_host_tab_panel");
            }
        } else if (view == this.gQq) {
            bYr();
        } else if (view == this.gQr) {
            bYq();
        } else if (view == this.gQi) {
            uL(2);
        } else if (view == this.gQj) {
            uL(1);
        }
    }

    private void uL(int i) {
        if (this.gPR != null && this.gPR.mLiveInfo != null && this.gPR.aDE != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.gPR.aDE;
            String valueOf = String.valueOf(this.gPR.mLiveInfo.group_id);
            u uVar = new u();
            uVar.groupId = valueOf;
            uVar.aEw = false;
            uVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            uVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            uVar.userName = alaLiveUserInfoData.userName;
            uVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.bea = uVar;
            cVar.beb = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void bYp() {
    }

    private void bYq() {
        if (this.aDE != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.gQu = true;
            this.aZT = this.aZT ? false : true;
            if (this.aZT) {
                TiebaInitialize.log("c12558");
            }
            bN(this.aZT);
            bO(this.aZT);
            com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.aDE.portrait, String.valueOf(this.aDE.userId), "1", this.aZT, gQt);
            dVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Qx().a(String.valueOf(this.aDE.userId), dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        this.aZT = z;
        if (z) {
            this.gQr.setEnabled(false);
            this.gQr.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.gQr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gQr.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.gQr.setGravity(17);
            return;
        }
        this.gQr.setEnabled(true);
        this.gQr.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.gQr.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gQr.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.gQr.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.gQr.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(boolean z) {
        if (z) {
            TextView textView = this.gQj;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.aZU + 1;
            this.aZU = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.gQj;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.aZU - 1;
        this.aZU = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bYr() {
        if (this.aDE != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aDE.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aDE.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, c(this.aDE)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.beb = (short) 1;
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
        MessageManager.getInstance().unRegisterListener(this.fPD);
        if (this.gCj != null) {
            this.gCj.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes7.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b gPO;

        public a(b bVar) {
            super(bVar.getView());
            this.gPO = bVar;
        }
    }
}
