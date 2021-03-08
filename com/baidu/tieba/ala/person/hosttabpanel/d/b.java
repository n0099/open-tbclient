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
import com.baidu.live.data.af;
import com.baidu.live.data.ax;
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
    private static final BdUniqueId hYh = BdUniqueId.gen();
    private AlaLiveUserInfoData aJD;
    private AlaLocationData aJE;
    private AlaRelationData aJF;
    private boolean bnd;
    private int bne;
    private TextView eKp;
    private CustomMessageListener gPd;
    private HeadImageView hEP;
    private com.baidu.live.ak.a hIw;
    private ab hXF;
    private ImageView hXU;
    private ALALevelView hXV;
    private TextView hXW;
    private TextView hXX;
    private TextView hXY;
    private LinearLayout hXZ;
    private LinearLayout hYa;
    private TextView hYb;
    private TbImageView hYc;
    private TextView hYd;
    private TextView hYe;
    private DrawableTextView hYf;
    private View hYg;
    private boolean hYi;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.bnd = false;
        this.hYi = false;
        this.liveType = 2;
        this.gPd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aJD.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.hYh);
                        b.this.hYi = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.ck(z);
                                b.this.cl(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Xr().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.h.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Xr().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.bnd = !b.this.bnd;
                                b.this.cl(b.this.bnd);
                                b.this.ck(b.this.bnd);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.bnd = b.this.bnd ? false : true;
                            b.this.cl(b.this.bnd);
                            b.this.ck(b.this.bnd);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hEP = (HeadImageView) this.mRootView.findViewById(a.f.user_icon);
        this.hEP.setIsRound(true);
        this.hEP.setAutoChangeStyle(false);
        this.eKp = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hXU = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        this.hXV = (ALALevelView) this.mRootView.findViewById(a.f.user_grade);
        this.hXW = (TextView) this.mRootView.findViewById(a.f.user_attention_count);
        this.hXX = (TextView) this.mRootView.findViewById(a.f.user_fans_count);
        this.hXY = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hXZ = (LinearLayout) this.mRootView.findViewById(a.f.profile_container);
        this.hYa = (LinearLayout) this.mRootView.findViewById(a.f.combat_authen_container);
        this.hYc = (TbImageView) this.mRootView.findViewById(a.f.anthen_icon);
        this.hYb = (TextView) this.mRootView.findViewById(a.f.combat_authen);
        this.hYd = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_go_to_authen);
        this.hYd.getPaint().setFlags(8);
        this.hYd.getPaint().setAntiAlias(true);
        this.hYe = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_reply_user);
        this.hYf = (DrawableTextView) this.mRootView.findViewById(a.f.ala_host_tab_attention_btn);
        this.hYg = this.mRootView.findViewById(a.f.divider_behind_fans_count);
        this.hXZ.setOnClickListener(this);
        this.hYd.setOnClickListener(this);
        this.hYe.setOnClickListener(this);
        this.hYf.setOnClickListener(this);
        this.hXW.setOnClickListener(this);
        this.hXX.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.gPd);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ak.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hIw = (com.baidu.live.ak.a) runTask.getData();
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
        if (aVar != null && aVar.hXF != null) {
            this.hXF = aVar.hXF;
            this.aJD = aVar.hXF.aJD;
            this.aJF = aVar.hXF.aJF;
            this.aJE = aVar.hXF.aJE;
            if (this.hXF.mLiveInfo != null) {
                this.liveType = this.hXF.mLiveInfo.live_type;
            }
            if (this.aJD != null && this.aJF != null && this.aJE != null) {
                long j = this.aJD.userId;
                if (this.aJD.portrait != null && !this.aJD.portrait.equals("")) {
                    this.hEP.startLoad(this.aJD.portrait, 12, false);
                }
                this.eKp.setText(this.aJD.userName);
                if (j == 0) {
                    this.hXU.setVisibility(8);
                } else {
                    this.hXU.setVisibility(0);
                    this.hXU.setImageResource(this.aJD.sex == 1 ? a.e.sdk_icon_mine_boy : a.e.sdk_icon_mine_girl);
                }
                this.hXV.setupLevelIcon(this.aJD.live_mark_info_new, this.aJD.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aJD.greatAnchorIcon)) {
                        this.hYc.startLoad(this.aJD.greatAnchorIcon, 10, false);
                    } else {
                        this.hYc.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aJD.greatAnchorDescRole) && !StringUtils.isNull(this.aJD.greatAnchorDescGrade)) {
                        this.hYb.setText(this.aJD.greatAnchorDescGrade + this.aJD.greatAnchorDescRole);
                    } else {
                        this.hYa.setVisibility(8);
                    }
                } else {
                    this.hYa.setVisibility(8);
                }
                this.hXW.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aJD.followCount)));
                if (!this.hYi || this.mUserId != this.aJD.userId) {
                    this.hYi = false;
                    this.bne = this.aJD.fansCount;
                    this.bnd = this.aJF.follow_status != 0;
                    this.mUserId = this.aJD.userId;
                }
                this.hXX.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.bne)));
                ck(this.bnd);
                if (!StringUtils.isNull(this.aJD.location)) {
                    str = this.aJD.location;
                } else {
                    str = this.aJE.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.hXY.setVisibility(0);
                    this.hYg.setVisibility(0);
                    this.hXY.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_location, str));
                    return;
                }
                this.hXY.setVisibility(4);
                this.hYg.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hXZ) {
            cmN();
        } else if (view == this.hYd) {
            if (this.hIw != null && this.hXF != null && this.hXF.aJZ != null) {
                this.hIw.a(this.hXF.aJZ, "from_host_tab_panel");
            }
        } else if (view == this.hYe) {
            cmP();
        } else if (view == this.hYf) {
            cmO();
        } else if (view == this.hXW) {
            wn(2);
        } else if (view == this.hXX) {
            wn(1);
        }
    }

    private void wn(int i) {
        if (this.hXF != null && this.hXF.mLiveInfo != null && this.hXF.aJD != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.hXF.aJD;
            String valueOf = String.valueOf(this.hXF.mLiveInfo.group_id);
            af afVar = new af();
            afVar.groupId = valueOf;
            afVar.aLc = false;
            afVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            afVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            afVar.userName = alaLiveUserInfoData.userName;
            afVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.btd = afVar;
            cVar.bte = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void cmN() {
    }

    private void cmO() {
        if (this.aJD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.hYi = true;
            this.bnd = this.bnd ? false : true;
            if (this.bnd) {
                TiebaInitialize.log("c12558");
            }
            ck(this.bnd);
            cl(this.bnd);
            com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aJD.portrait, String.valueOf(this.aJD.userId), "1", this.bnd, hYh);
            fVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Xr().a(String.valueOf(this.aJD.userId), fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        this.bnd = z;
        if (z) {
            this.hYf.setEnabled(false);
            this.hYf.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
            this.hYf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.hYf.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10109));
            this.hYf.setGravity(17);
            return;
        }
        this.hYf.setEnabled(true);
        this.hYf.setText(this.mPageContext.getString(a.h.ala_person_attention));
        this.hYf.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.e.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hYf.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.hYf.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_other_b));
        this.hYf.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(boolean z) {
        if (z) {
            TextView textView = this.hXX;
            Resources resources = this.mPageContext.getResources();
            int i = a.h.ala_host_tab_fans_count;
            int i2 = this.bne + 1;
            this.bne = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.hXX;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.h.ala_host_tab_fans_count;
        int i4 = this.bne - 1;
        this.bne = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void cmP() {
        if (this.aJD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aJD.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aJD.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.aJD)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bte = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private ax b(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        ax axVar = new ax();
        axVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        axVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        axVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        axVar.verify_type = alaLiveUserInfoData.verifyType;
        axVar.user_name = alaLiveUserInfoData.userName;
        axVar.user_nickname = alaLiveUserInfoData.userName;
        axVar.pass_name = alaLiveUserInfoData.passName;
        axVar.sex = alaLiveUserInfoData.sex;
        axVar.description = alaLiveUserInfoData.description;
        axVar.portrait = alaLiveUserInfoData.portrait;
        axVar.level_id = alaLiveUserInfoData.levelId;
        axVar.level_exp = alaLiveUserInfoData.levelExp;
        axVar.is_login = alaLiveUserInfoData.isLogin;
        axVar.fans_count = alaLiveUserInfoData.fansCount;
        axVar.follow_count = alaLiveUserInfoData.followCount;
        axVar.user_status = alaLiveUserInfoData.userStatus;
        axVar.live_status = alaLiveUserInfoData.liveStatus;
        axVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        axVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        axVar.record_count = alaLiveUserInfoData.recordCount;
        axVar.location = alaLiveUserInfoData.location;
        axVar.lng = alaLiveUserInfoData.lng;
        axVar.lat = alaLiveUserInfoData.lat;
        axVar.is_block = alaLiveUserInfoData.isBlock;
        axVar.stream_id = alaLiveUserInfoData.streamID;
        axVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        axVar.verify_status = alaLiveUserInfoData.verifyStatus;
        axVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        axVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        axVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        axVar.petal_num = alaLiveUserInfoData.petalNum;
        return axVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.gPd);
        if (this.hIw != null) {
            this.hIw.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes10.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b hXC;

        public a(b bVar) {
            super(bVar.getView());
            this.hXC = bVar;
        }
    }
}
