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
import com.baidu.live.data.n;
import com.baidu.live.data.p;
import com.baidu.live.data.z;
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
import com.baidu.live.u.a;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes3.dex */
public class b extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.a> {
    private static final BdUniqueId fWz = BdUniqueId.gen();
    private boolean aKS;
    private int aKT;
    private AlaLiveUserInfoData aqk;
    private AlaLocationData aql;
    private AlaRelationData aqm;
    private TextView cBd;
    private HeadImageView fGb;
    private com.baidu.live.aa.a fJj;
    private n fVX;
    private boolean fWA;
    private ImageView fWm;
    private ALALevelView fWn;
    private TextView fWo;
    private TextView fWp;
    private TextView fWq;
    private LinearLayout fWr;
    private LinearLayout fWs;
    private TextView fWt;
    private TbImageView fWu;
    private TextView fWv;
    private TextView fWw;
    private DrawableTextView fWx;
    private View fWy;
    private CustomMessageListener fae;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.aKS = false;
        this.fWA = false;
        this.liveType = 2;
        this.fae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aqk.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.fWz);
                        b.this.fWA = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.bu(z);
                                b.this.bv(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Hs().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Hs().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.aKS = !b.this.aKS;
                                b.this.bv(b.this.aKS);
                                b.this.bu(b.this.aKS);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.aKS = b.this.aKS ? false : true;
                            b.this.bv(b.this.aKS);
                            b.this.bu(b.this.aKS);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.fGb = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.fGb.setIsRound(true);
        this.fGb.setAutoChangeStyle(false);
        this.cBd = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fWm = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.fWn = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.fWo = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.fWp = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.fWq = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.fWr = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.fWs = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.fWu = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.fWt = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.fWv = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.fWv.getPaint().setFlags(8);
        this.fWv.getPaint().setAntiAlias(true);
        this.fWw = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.fWx = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.fWy = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.fWr.setOnClickListener(this);
        this.fWv.setOnClickListener(this);
        this.fWw.setOnClickListener(this);
        this.fWx.setOnClickListener(this);
        this.fWo.setOnClickListener(this);
        this.fWp.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.fae);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.aa.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fJj = (com.baidu.live.aa.a) runTask.getData();
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
        if (aVar != null && aVar.fVX != null) {
            this.fVX = aVar.fVX;
            this.aqk = aVar.fVX.aqk;
            this.aqm = aVar.fVX.aqm;
            this.aql = aVar.fVX.aql;
            if (this.fVX.mLiveInfo != null) {
                this.liveType = this.fVX.mLiveInfo.live_type;
            }
            if (this.aqk != null && this.aqm != null && this.aql != null) {
                long j = this.aqk.userId;
                if (this.aqk.portrait != null && !this.aqk.portrait.equals("")) {
                    this.fGb.startLoad(this.aqk.portrait, 12, false);
                }
                this.cBd.setText(this.aqk.userName);
                if (j == 0) {
                    this.fWm.setVisibility(8);
                } else {
                    this.fWm.setVisibility(0);
                    this.fWm.setImageResource(this.aqk.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.fWn.setupLevelIcon(this.aqk.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aqk.greatAnchorIcon)) {
                        this.fWu.startLoad(this.aqk.greatAnchorIcon, 10, false);
                    } else {
                        this.fWu.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aqk.greatAnchorDescRole) && !StringUtils.isNull(this.aqk.greatAnchorDescGrade)) {
                        this.fWt.setText(this.aqk.greatAnchorDescGrade + this.aqk.greatAnchorDescRole);
                    } else {
                        this.fWs.setVisibility(8);
                    }
                } else {
                    this.fWs.setVisibility(8);
                }
                this.fWo.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aqk.followCount)));
                if (!this.fWA || this.mUserId != this.aqk.userId) {
                    this.fWA = false;
                    this.aKT = this.aqk.fansCount;
                    this.aKS = this.aqm.follow_status != 0;
                    this.mUserId = this.aqk.userId;
                }
                this.fWp.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.aKT)));
                bu(this.aKS);
                if (!StringUtils.isNull(this.aqk.location)) {
                    str = this.aqk.location;
                } else {
                    str = this.aql.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.fWq.setVisibility(0);
                    this.fWy.setVisibility(0);
                    this.fWq.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.fWq.setVisibility(4);
                this.fWy.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fWr) {
            bBH();
        } else if (view == this.fWv) {
            if (this.fJj != null && this.fVX != null && this.fVX.aqD != null) {
                this.fJj.a(this.fVX.aqD, "from_host_tab_panel");
            }
        } else if (view == this.fWw) {
            bBJ();
        } else if (view == this.fWx) {
            bBI();
        } else if (view == this.fWo) {
            rd(2);
        } else if (view == this.fWp) {
            rd(1);
        }
    }

    private void rd(int i) {
        if (this.fVX != null && this.fVX.mLiveInfo != null && this.fVX.aqk != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.fVX.aqk;
            String valueOf = String.valueOf(this.fVX.mLiveInfo.group_id);
            p pVar = new p();
            pVar.groupId = valueOf;
            pVar.aqR = false;
            pVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            pVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            pVar.userName = alaLiveUserInfoData.userName;
            pVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.aPT = pVar;
            cVar.aPU = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void bBH() {
    }

    private void bBI() {
        if (this.aqk != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.fWA = true;
            this.aKS = this.aKS ? false : true;
            if (this.aKS) {
                TiebaInitialize.log("c12558");
            }
            bu(this.aKS);
            bv(this.aKS);
            com.baidu.live.data.b bVar = new com.baidu.live.data.b(this.aqk.portrait, String.valueOf(this.aqk.userId), "1", this.aKS, fWz);
            bVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Hs().a(String.valueOf(this.aqk.userId), bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(boolean z) {
        this.aKS = z;
        if (z) {
            this.fWx.setEnabled(false);
            this.fWx.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.fWx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fWx.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.fWx.setGravity(17);
            return;
        }
        this.fWx.setEnabled(true);
        this.fWx.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.fWx.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fWx.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.fWx.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.fWx.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(boolean z) {
        if (z) {
            TextView textView = this.fWp;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.aKT + 1;
            this.aKT = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.fWp;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.aKT - 1;
        this.aKT = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bBJ() {
        if (this.aqk != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aqk.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aqk.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, c(this.aqk)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.aPU = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private z c(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        z zVar = new z();
        zVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        zVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        zVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        zVar.verify_type = alaLiveUserInfoData.verifyType;
        zVar.user_name = alaLiveUserInfoData.userName;
        zVar.user_nickname = alaLiveUserInfoData.userName;
        zVar.pass_name = alaLiveUserInfoData.passName;
        zVar.sex = alaLiveUserInfoData.sex;
        zVar.description = alaLiveUserInfoData.description;
        zVar.portrait = alaLiveUserInfoData.portrait;
        zVar.level_id = alaLiveUserInfoData.levelId;
        zVar.level_exp = alaLiveUserInfoData.levelExp;
        zVar.is_login = alaLiveUserInfoData.isLogin;
        zVar.fans_count = alaLiveUserInfoData.fansCount;
        zVar.follow_count = alaLiveUserInfoData.followCount;
        zVar.user_status = alaLiveUserInfoData.userStatus;
        zVar.live_status = alaLiveUserInfoData.liveStatus;
        zVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        zVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        zVar.record_count = alaLiveUserInfoData.recordCount;
        zVar.location = alaLiveUserInfoData.location;
        zVar.lng = alaLiveUserInfoData.lng;
        zVar.lat = alaLiveUserInfoData.lat;
        zVar.is_block = alaLiveUserInfoData.isBlock;
        zVar.stream_id = alaLiveUserInfoData.streamID;
        zVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        zVar.verify_status = alaLiveUserInfoData.verifyStatus;
        zVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        zVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        zVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        zVar.petal_num = alaLiveUserInfoData.petalNum;
        return zVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.fae);
        if (this.fJj != null) {
            this.fJj.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b fVU;

        public a(b bVar) {
            super(bVar.getView());
            this.fVU = bVar;
        }
    }
}
