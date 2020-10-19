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
import com.baidu.live.data.am;
import com.baidu.live.data.u;
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
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.a> {
    private static final BdUniqueId hjd = BdUniqueId.gen();
    private AlaLiveUserInfoData aHD;
    private AlaLocationData aHE;
    private AlaRelationData aHF;
    private boolean bgf;
    private int bgg;
    private TextView eig;
    private HeadImageView gQx;
    private com.baidu.live.ad.a gUk;
    private CustomMessageListener gfl;
    private u hiB;
    private ImageView hiQ;
    private ALALevelView hiR;
    private TextView hiS;
    private TextView hiT;
    private TextView hiU;
    private LinearLayout hiV;
    private LinearLayout hiW;
    private TextView hiX;
    private TbImageView hiY;
    private TextView hiZ;
    private TextView hja;
    private DrawableTextView hjb;
    private View hjc;
    private boolean hje;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.bgf = false;
        this.hje = false;
        this.liveType = 2;
        this.gfl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aHD.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.hjd);
                        b.this.hje = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.bS(z);
                                b.this.bT(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.SY().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.SY().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.bgf = !b.this.bgf;
                                b.this.bT(b.this.bgf);
                                b.this.bS(b.this.bgf);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.bgf = b.this.bgf ? false : true;
                            b.this.bT(b.this.bgf);
                            b.this.bS(b.this.bgf);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gQx = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.gQx.setIsRound(true);
        this.gQx.setAutoChangeStyle(false);
        this.eig = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.hiQ = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.hiR = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.hiS = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.hiT = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.hiU = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.hiV = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.hiW = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.hiY = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.hiX = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.hiZ = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.hiZ.getPaint().setFlags(8);
        this.hiZ.getPaint().setAntiAlias(true);
        this.hja = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.hjb = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.hjc = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.hiV.setOnClickListener(this);
        this.hiZ.setOnClickListener(this);
        this.hja.setOnClickListener(this);
        this.hjb.setOnClickListener(this);
        this.hiS.setOnClickListener(this);
        this.hiT.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.gfl);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ad.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gUk = (com.baidu.live.ad.a) runTask.getData();
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
        if (aVar != null && aVar.hiB != null) {
            this.hiB = aVar.hiB;
            this.aHD = aVar.hiB.aHD;
            this.aHF = aVar.hiB.aHF;
            this.aHE = aVar.hiB.aHE;
            if (this.hiB.mLiveInfo != null) {
                this.liveType = this.hiB.mLiveInfo.live_type;
            }
            if (this.aHD != null && this.aHF != null && this.aHE != null) {
                long j = this.aHD.userId;
                if (this.aHD.portrait != null && !this.aHD.portrait.equals("")) {
                    this.gQx.startLoad(this.aHD.portrait, 12, false);
                }
                this.eig.setText(this.aHD.userName);
                if (j == 0) {
                    this.hiQ.setVisibility(8);
                } else {
                    this.hiQ.setVisibility(0);
                    this.hiQ.setImageResource(this.aHD.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.hiR.setupLevelIcon(this.aHD.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aHD.greatAnchorIcon)) {
                        this.hiY.startLoad(this.aHD.greatAnchorIcon, 10, false);
                    } else {
                        this.hiY.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aHD.greatAnchorDescRole) && !StringUtils.isNull(this.aHD.greatAnchorDescGrade)) {
                        this.hiX.setText(this.aHD.greatAnchorDescGrade + this.aHD.greatAnchorDescRole);
                    } else {
                        this.hiW.setVisibility(8);
                    }
                } else {
                    this.hiW.setVisibility(8);
                }
                this.hiS.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aHD.followCount)));
                if (!this.hje || this.mUserId != this.aHD.userId) {
                    this.hje = false;
                    this.bgg = this.aHD.fansCount;
                    this.bgf = this.aHF.follow_status != 0;
                    this.mUserId = this.aHD.userId;
                }
                this.hiT.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.bgg)));
                bS(this.bgf);
                if (!StringUtils.isNull(this.aHD.location)) {
                    str = this.aHD.location;
                } else {
                    str = this.aHE.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.hiU.setVisibility(0);
                    this.hjc.setVisibility(0);
                    this.hiU.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.hiU.setVisibility(4);
                this.hjc.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hiV) {
            cdK();
        } else if (view == this.hiZ) {
            if (this.gUk != null && this.hiB != null && this.hiB.aIf != null) {
                this.gUk.a(this.hiB.aIf, "from_host_tab_panel");
            }
        } else if (view == this.hja) {
            cdM();
        } else if (view == this.hjb) {
            cdL();
        } else if (view == this.hiS) {
            vK(2);
        } else if (view == this.hiT) {
            vK(1);
        }
    }

    private void vK(int i) {
        if (this.hiB != null && this.hiB.mLiveInfo != null && this.hiB.aHD != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.hiB.aHD;
            String valueOf = String.valueOf(this.hiB.mLiveInfo.group_id);
            x xVar = new x();
            xVar.groupId = valueOf;
            xVar.aIH = false;
            xVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            xVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            xVar.userName = alaLiveUserInfoData.userName;
            xVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.bkJ = xVar;
            cVar.bkK = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void cdK() {
    }

    private void cdL() {
        if (this.aHD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.hje = true;
            this.bgf = this.bgf ? false : true;
            if (this.bgf) {
                TiebaInitialize.log("c12558");
            }
            bS(this.bgf);
            bT(this.bgf);
            com.baidu.live.data.e eVar = new com.baidu.live.data.e(this.aHD.portrait, String.valueOf(this.aHD.userId), "1", this.bgf, hjd);
            eVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.SY().a(String.valueOf(this.aHD.userId), eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(boolean z) {
        this.bgf = z;
        if (z) {
            this.hjb.setEnabled(false);
            this.hjb.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.hjb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.hjb.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.hjb.setGravity(17);
            return;
        }
        this.hjb.setEnabled(true);
        this.hjb.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.hjb.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hjb.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.hjb.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.hjb.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(boolean z) {
        if (z) {
            TextView textView = this.hiT;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.bgg + 1;
            this.bgg = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.hiT;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.bgg - 1;
        this.bgg = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void cdM() {
        if (this.aHD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aHD.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aHD.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.aHD)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bkK = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private am b(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        am amVar = new am();
        amVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        amVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        amVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        amVar.verify_type = alaLiveUserInfoData.verifyType;
        amVar.user_name = alaLiveUserInfoData.userName;
        amVar.user_nickname = alaLiveUserInfoData.userName;
        amVar.pass_name = alaLiveUserInfoData.passName;
        amVar.sex = alaLiveUserInfoData.sex;
        amVar.description = alaLiveUserInfoData.description;
        amVar.portrait = alaLiveUserInfoData.portrait;
        amVar.level_id = alaLiveUserInfoData.levelId;
        amVar.level_exp = alaLiveUserInfoData.levelExp;
        amVar.is_login = alaLiveUserInfoData.isLogin;
        amVar.fans_count = alaLiveUserInfoData.fansCount;
        amVar.follow_count = alaLiveUserInfoData.followCount;
        amVar.user_status = alaLiveUserInfoData.userStatus;
        amVar.live_status = alaLiveUserInfoData.liveStatus;
        amVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        amVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        amVar.record_count = alaLiveUserInfoData.recordCount;
        amVar.location = alaLiveUserInfoData.location;
        amVar.lng = alaLiveUserInfoData.lng;
        amVar.lat = alaLiveUserInfoData.lat;
        amVar.is_block = alaLiveUserInfoData.isBlock;
        amVar.stream_id = alaLiveUserInfoData.streamID;
        amVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        amVar.verify_status = alaLiveUserInfoData.verifyStatus;
        amVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        amVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        amVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        amVar.petal_num = alaLiveUserInfoData.petalNum;
        return amVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.gfl);
        if (this.gUk != null) {
            this.gUk.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b hiy;

        public a(b bVar) {
            super(bVar.getView());
            this.hiy = bVar;
        }
    }
}
