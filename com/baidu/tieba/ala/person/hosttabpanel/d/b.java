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
    private static final BdUniqueId gUf = BdUniqueId.gen();
    private AlaLocationData aEA;
    private AlaRelationData aEB;
    private AlaLiveUserInfoData aEz;
    private boolean bct;
    private int bcu;
    private TextView dWe;
    private CustomMessageListener fSS;
    private HeadImageView gCe;
    private com.baidu.live.ad.a gFM;
    private u gTD;
    private ImageView gTS;
    private ALALevelView gTT;
    private TextView gTU;
    private TextView gTV;
    private TextView gTW;
    private LinearLayout gTX;
    private LinearLayout gTY;
    private TextView gTZ;
    private TbImageView gUa;
    private TextView gUb;
    private TextView gUc;
    private DrawableTextView gUd;
    private View gUe;
    private boolean gUg;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.bct = false;
        this.gUg = false;
        this.liveType = 2;
        this.fSS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aEz.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.gUf);
                        b.this.gUg = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.bP(z);
                                b.this.bQ(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Rg().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Rg().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.bct = !b.this.bct;
                                b.this.bQ(b.this.bct);
                                b.this.bP(b.this.bct);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.bct = b.this.bct ? false : true;
                            b.this.bQ(b.this.bct);
                            b.this.bP(b.this.bct);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gCe = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.gCe.setIsRound(true);
        this.gCe.setAutoChangeStyle(false);
        this.dWe = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gTS = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.gTT = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.gTU = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.gTV = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.gTW = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gTX = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.gTY = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.gUa = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.gTZ = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.gUb = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.gUb.getPaint().setFlags(8);
        this.gUb.getPaint().setAntiAlias(true);
        this.gUc = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.gUd = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.gUe = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.gTX.setOnClickListener(this);
        this.gUb.setOnClickListener(this);
        this.gUc.setOnClickListener(this);
        this.gUd.setOnClickListener(this);
        this.gTU.setOnClickListener(this);
        this.gTV.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.fSS);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ad.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gFM = (com.baidu.live.ad.a) runTask.getData();
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
        if (aVar != null && aVar.gTD != null) {
            this.gTD = aVar.gTD;
            this.aEz = aVar.gTD.aEz;
            this.aEB = aVar.gTD.aEB;
            this.aEA = aVar.gTD.aEA;
            if (this.gTD.mLiveInfo != null) {
                this.liveType = this.gTD.mLiveInfo.live_type;
            }
            if (this.aEz != null && this.aEB != null && this.aEA != null) {
                long j = this.aEz.userId;
                if (this.aEz.portrait != null && !this.aEz.portrait.equals("")) {
                    this.gCe.startLoad(this.aEz.portrait, 12, false);
                }
                this.dWe.setText(this.aEz.userName);
                if (j == 0) {
                    this.gTS.setVisibility(8);
                } else {
                    this.gTS.setVisibility(0);
                    this.gTS.setImageResource(this.aEz.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.gTT.setupLevelIcon(this.aEz.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aEz.greatAnchorIcon)) {
                        this.gUa.startLoad(this.aEz.greatAnchorIcon, 10, false);
                    } else {
                        this.gUa.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aEz.greatAnchorDescRole) && !StringUtils.isNull(this.aEz.greatAnchorDescGrade)) {
                        this.gTZ.setText(this.aEz.greatAnchorDescGrade + this.aEz.greatAnchorDescRole);
                    } else {
                        this.gTY.setVisibility(8);
                    }
                } else {
                    this.gTY.setVisibility(8);
                }
                this.gTU.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aEz.followCount)));
                if (!this.gUg || this.mUserId != this.aEz.userId) {
                    this.gUg = false;
                    this.bcu = this.aEz.fansCount;
                    this.bct = this.aEB.follow_status != 0;
                    this.mUserId = this.aEz.userId;
                }
                this.gTV.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.bcu)));
                bP(this.bct);
                if (!StringUtils.isNull(this.aEz.location)) {
                    str = this.aEz.location;
                } else {
                    str = this.aEA.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.gTW.setVisibility(0);
                    this.gUe.setVisibility(0);
                    this.gTW.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.gTW.setVisibility(4);
                this.gUe.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gTX) {
            cam();
        } else if (view == this.gUb) {
            if (this.gFM != null && this.gTD != null && this.gTD.aFb != null) {
                this.gFM.a(this.gTD.aFb, "from_host_tab_panel");
            }
        } else if (view == this.gUc) {
            cao();
        } else if (view == this.gUd) {
            can();
        } else if (view == this.gTU) {
            ve(2);
        } else if (view == this.gTV) {
            ve(1);
        }
    }

    private void ve(int i) {
        if (this.gTD != null && this.gTD.mLiveInfo != null && this.gTD.aEz != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.gTD.aEz;
            String valueOf = String.valueOf(this.gTD.mLiveInfo.group_id);
            x xVar = new x();
            xVar.groupId = valueOf;
            xVar.aFD = false;
            xVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            xVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            xVar.userName = alaLiveUserInfoData.userName;
            xVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.bgT = xVar;
            cVar.bgU = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void cam() {
    }

    private void can() {
        if (this.aEz != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.gUg = true;
            this.bct = this.bct ? false : true;
            if (this.bct) {
                TiebaInitialize.log("c12558");
            }
            bP(this.bct);
            bQ(this.bct);
            com.baidu.live.data.e eVar = new com.baidu.live.data.e(this.aEz.portrait, String.valueOf(this.aEz.userId), "1", this.bct, gUf);
            eVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Rg().a(String.valueOf(this.aEz.userId), eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(boolean z) {
        this.bct = z;
        if (z) {
            this.gUd.setEnabled(false);
            this.gUd.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.gUd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gUd.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.gUd.setGravity(17);
            return;
        }
        this.gUd.setEnabled(true);
        this.gUd.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.gUd.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gUd.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.gUd.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.gUd.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(boolean z) {
        if (z) {
            TextView textView = this.gTV;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.bcu + 1;
            this.bcu = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.gTV;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.bcu - 1;
        this.bcu = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void cao() {
        if (this.aEz != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aEz.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aEz.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.aEz)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bgU = (short) 1;
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
        MessageManager.getInstance().unRegisterListener(this.fSS);
        if (this.gFM != null) {
            this.gFM.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b gTA;

        public a(b bVar) {
            super(bVar.getView());
            this.gTA = bVar;
        }
    }
}
