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
import com.baidu.live.data.af;
import com.baidu.live.data.q;
import com.baidu.live.data.t;
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
    private static final BdUniqueId gDT = BdUniqueId.gen();
    private boolean aUF;
    private int aUG;
    private AlaLiveUserInfoData ayC;
    private AlaLocationData ayD;
    private AlaRelationData ayE;
    private TextView dKI;
    private CustomMessageListener fEm;
    private ImageView gDG;
    private ALALevelView gDH;
    private TextView gDI;
    private TextView gDJ;
    private TextView gDK;
    private LinearLayout gDL;
    private LinearLayout gDM;
    private TextView gDN;
    private TbImageView gDO;
    private TextView gDP;
    private TextView gDQ;
    private DrawableTextView gDR;
    private View gDS;
    private boolean gDU;
    private q gDs;
    private HeadImageView gma;
    private com.baidu.live.ab.a gps;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.aUF = false;
        this.gDU = false;
        this.liveType = 2;
        this.fEm = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.ayC.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.gDT);
                        b.this.gDU = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.bH(z);
                                b.this.bI(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.KF().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.KF().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.aUF = !b.this.aUF;
                                b.this.bI(b.this.aUF);
                                b.this.bH(b.this.aUF);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.aUF = b.this.aUF ? false : true;
                            b.this.bI(b.this.aUF);
                            b.this.bH(b.this.aUF);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gma = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.gma.setIsRound(true);
        this.gma.setAutoChangeStyle(false);
        this.dKI = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gDG = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.gDH = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.gDI = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.gDJ = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.gDK = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gDL = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.gDM = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.gDO = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.gDN = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.gDP = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.gDP.getPaint().setFlags(8);
        this.gDP.getPaint().setAntiAlias(true);
        this.gDQ = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.gDR = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.gDS = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.gDL.setOnClickListener(this);
        this.gDP.setOnClickListener(this);
        this.gDQ.setOnClickListener(this);
        this.gDR.setOnClickListener(this);
        this.gDI.setOnClickListener(this);
        this.gDJ.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.fEm);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ab.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gps = (com.baidu.live.ab.a) runTask.getData();
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
        if (aVar != null && aVar.gDs != null) {
            this.gDs = aVar.gDs;
            this.ayC = aVar.gDs.ayC;
            this.ayE = aVar.gDs.ayE;
            this.ayD = aVar.gDs.ayD;
            if (this.gDs.mLiveInfo != null) {
                this.liveType = this.gDs.mLiveInfo.live_type;
            }
            if (this.ayC != null && this.ayE != null && this.ayD != null) {
                long j = this.ayC.userId;
                if (this.ayC.portrait != null && !this.ayC.portrait.equals("")) {
                    this.gma.startLoad(this.ayC.portrait, 12, false);
                }
                this.dKI.setText(this.ayC.userName);
                if (j == 0) {
                    this.gDG.setVisibility(8);
                } else {
                    this.gDG.setVisibility(0);
                    this.gDG.setImageResource(this.ayC.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.gDH.setupLevelIcon(this.ayC.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.ayC.greatAnchorIcon)) {
                        this.gDO.startLoad(this.ayC.greatAnchorIcon, 10, false);
                    } else {
                        this.gDO.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.ayC.greatAnchorDescRole) && !StringUtils.isNull(this.ayC.greatAnchorDescGrade)) {
                        this.gDN.setText(this.ayC.greatAnchorDescGrade + this.ayC.greatAnchorDescRole);
                    } else {
                        this.gDM.setVisibility(8);
                    }
                } else {
                    this.gDM.setVisibility(8);
                }
                this.gDI.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.ayC.followCount)));
                if (!this.gDU || this.mUserId != this.ayC.userId) {
                    this.gDU = false;
                    this.aUG = this.ayC.fansCount;
                    this.aUF = this.ayE.follow_status != 0;
                    this.mUserId = this.ayC.userId;
                }
                this.gDJ.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.aUG)));
                bH(this.aUF);
                if (!StringUtils.isNull(this.ayC.location)) {
                    str = this.ayC.location;
                } else {
                    str = this.ayD.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.gDK.setVisibility(0);
                    this.gDS.setVisibility(0);
                    this.gDK.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.gDK.setVisibility(4);
                this.gDS.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gDL) {
            bOp();
        } else if (view == this.gDP) {
            if (this.gps != null && this.gDs != null && this.gDs.ayV != null) {
                this.gps.a(this.gDs.ayV, "from_host_tab_panel");
            }
        } else if (view == this.gDQ) {
            bOr();
        } else if (view == this.gDR) {
            bOq();
        } else if (view == this.gDI) {
            sx(2);
        } else if (view == this.gDJ) {
            sx(1);
        }
    }

    private void sx(int i) {
        if (this.gDs != null && this.gDs.mLiveInfo != null && this.gDs.ayC != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.gDs.ayC;
            String valueOf = String.valueOf(this.gDs.mLiveInfo.group_id);
            t tVar = new t();
            tVar.groupId = valueOf;
            tVar.azm = false;
            tVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            tVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            tVar.userName = alaLiveUserInfoData.userName;
            tVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.aYJ = tVar;
            cVar.aYK = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void bOp() {
    }

    private void bOq() {
        if (this.ayC != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.gDU = true;
            this.aUF = this.aUF ? false : true;
            if (this.aUF) {
                TiebaInitialize.log("c12558");
            }
            bH(this.aUF);
            bI(this.aUF);
            com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.ayC.portrait, String.valueOf(this.ayC.userId), "1", this.aUF, gDT);
            dVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.KF().a(String.valueOf(this.ayC.userId), dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(boolean z) {
        this.aUF = z;
        if (z) {
            this.gDR.setEnabled(false);
            this.gDR.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.gDR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gDR.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.gDR.setGravity(17);
            return;
        }
        this.gDR.setEnabled(true);
        this.gDR.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.gDR.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gDR.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.gDR.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.gDR.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(boolean z) {
        if (z) {
            TextView textView = this.gDJ;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.aUG + 1;
            this.aUG = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.gDJ;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.aUG - 1;
        this.aUG = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bOr() {
        if (this.ayC != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.ayC.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.ayC.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, c(this.ayC)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.aYK = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private af c(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        af afVar = new af();
        afVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        afVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        afVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        afVar.verify_type = alaLiveUserInfoData.verifyType;
        afVar.user_name = alaLiveUserInfoData.userName;
        afVar.user_nickname = alaLiveUserInfoData.userName;
        afVar.pass_name = alaLiveUserInfoData.passName;
        afVar.sex = alaLiveUserInfoData.sex;
        afVar.description = alaLiveUserInfoData.description;
        afVar.portrait = alaLiveUserInfoData.portrait;
        afVar.level_id = alaLiveUserInfoData.levelId;
        afVar.level_exp = alaLiveUserInfoData.levelExp;
        afVar.is_login = alaLiveUserInfoData.isLogin;
        afVar.fans_count = alaLiveUserInfoData.fansCount;
        afVar.follow_count = alaLiveUserInfoData.followCount;
        afVar.user_status = alaLiveUserInfoData.userStatus;
        afVar.live_status = alaLiveUserInfoData.liveStatus;
        afVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        afVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        afVar.record_count = alaLiveUserInfoData.recordCount;
        afVar.location = alaLiveUserInfoData.location;
        afVar.lng = alaLiveUserInfoData.lng;
        afVar.lat = alaLiveUserInfoData.lat;
        afVar.is_block = alaLiveUserInfoData.isBlock;
        afVar.stream_id = alaLiveUserInfoData.streamID;
        afVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        afVar.verify_status = alaLiveUserInfoData.verifyStatus;
        afVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        afVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        afVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        afVar.petal_num = alaLiveUserInfoData.petalNum;
        return afVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.fEm);
        if (this.gps != null) {
            this.gps.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b gDp;

        public a(b bVar) {
            super(bVar.getView());
            this.gDp = bVar;
        }
    }
}
