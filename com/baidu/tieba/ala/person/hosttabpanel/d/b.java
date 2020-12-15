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
import com.baidu.live.data.aa;
import com.baidu.live.data.ar;
import com.baidu.live.data.w;
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
    private static final BdUniqueId hKk = BdUniqueId.gen();
    private AlaLiveUserInfoData aJV;
    private AlaLocationData aJW;
    private AlaRelationData aJX;
    private boolean blr;
    private int bls;
    private TextView eBQ;
    private CustomMessageListener gDu;
    private w hJI;
    private ImageView hJX;
    private ALALevelView hJY;
    private TextView hJZ;
    private TextView hKa;
    private TextView hKb;
    private LinearLayout hKc;
    private LinearLayout hKd;
    private TextView hKe;
    private TbImageView hKf;
    private TextView hKg;
    private TextView hKh;
    private DrawableTextView hKi;
    private View hKj;
    private boolean hKl;
    private HeadImageView hrr;
    private com.baidu.live.al.a hva;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.blr = false;
        this.hKl = false;
        this.liveType = 2;
        this.gDu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aJV.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.hKk);
                        b.this.hKl = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.cg(z);
                                b.this.ch(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Yo().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.h.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Yo().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.blr = !b.this.blr;
                                b.this.ch(b.this.blr);
                                b.this.cg(b.this.blr);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.blr = b.this.blr ? false : true;
                            b.this.ch(b.this.blr);
                            b.this.cg(b.this.blr);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hrr = (HeadImageView) this.mRootView.findViewById(a.f.user_icon);
        this.hrr.setIsRound(true);
        this.hrr.setAutoChangeStyle(false);
        this.eBQ = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hJX = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        this.hJY = (ALALevelView) this.mRootView.findViewById(a.f.user_grade);
        this.hJZ = (TextView) this.mRootView.findViewById(a.f.user_attention_count);
        this.hKa = (TextView) this.mRootView.findViewById(a.f.user_fans_count);
        this.hKb = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hKc = (LinearLayout) this.mRootView.findViewById(a.f.profile_container);
        this.hKd = (LinearLayout) this.mRootView.findViewById(a.f.combat_authen_container);
        this.hKf = (TbImageView) this.mRootView.findViewById(a.f.anthen_icon);
        this.hKe = (TextView) this.mRootView.findViewById(a.f.combat_authen);
        this.hKg = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_go_to_authen);
        this.hKg.getPaint().setFlags(8);
        this.hKg.getPaint().setAntiAlias(true);
        this.hKh = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_reply_user);
        this.hKi = (DrawableTextView) this.mRootView.findViewById(a.f.ala_host_tab_attention_btn);
        this.hKj = this.mRootView.findViewById(a.f.divider_behind_fans_count);
        this.hKc.setOnClickListener(this);
        this.hKg.setOnClickListener(this);
        this.hKh.setOnClickListener(this);
        this.hKi.setOnClickListener(this);
        this.hJZ.setOnClickListener(this);
        this.hKa.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.gDu);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.al.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hva = (com.baidu.live.al.a) runTask.getData();
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
        if (aVar != null && aVar.hJI != null) {
            this.hJI = aVar.hJI;
            this.aJV = aVar.hJI.aJV;
            this.aJX = aVar.hJI.aJX;
            this.aJW = aVar.hJI.aJW;
            if (this.hJI.mLiveInfo != null) {
                this.liveType = this.hJI.mLiveInfo.live_type;
            }
            if (this.aJV != null && this.aJX != null && this.aJW != null) {
                long j = this.aJV.userId;
                if (this.aJV.portrait != null && !this.aJV.portrait.equals("")) {
                    this.hrr.startLoad(this.aJV.portrait, 12, false);
                }
                this.eBQ.setText(this.aJV.userName);
                if (j == 0) {
                    this.hJX.setVisibility(8);
                } else {
                    this.hJX.setVisibility(0);
                    this.hJX.setImageResource(this.aJV.sex == 1 ? a.e.sdk_icon_mine_boy : a.e.sdk_icon_mine_girl);
                }
                this.hJY.setupLevelIcon(this.aJV.live_mark_info_new, this.aJV.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aJV.greatAnchorIcon)) {
                        this.hKf.startLoad(this.aJV.greatAnchorIcon, 10, false);
                    } else {
                        this.hKf.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aJV.greatAnchorDescRole) && !StringUtils.isNull(this.aJV.greatAnchorDescGrade)) {
                        this.hKe.setText(this.aJV.greatAnchorDescGrade + this.aJV.greatAnchorDescRole);
                    } else {
                        this.hKd.setVisibility(8);
                    }
                } else {
                    this.hKd.setVisibility(8);
                }
                this.hJZ.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aJV.followCount)));
                if (!this.hKl || this.mUserId != this.aJV.userId) {
                    this.hKl = false;
                    this.bls = this.aJV.fansCount;
                    this.blr = this.aJX.follow_status != 0;
                    this.mUserId = this.aJV.userId;
                }
                this.hKa.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.bls)));
                cg(this.blr);
                if (!StringUtils.isNull(this.aJV.location)) {
                    str = this.aJV.location;
                } else {
                    str = this.aJW.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.hKb.setVisibility(0);
                    this.hKj.setVisibility(0);
                    this.hKb.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_location, str));
                    return;
                }
                this.hKb.setVisibility(4);
                this.hKj.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hKc) {
            cmC();
        } else if (view == this.hKg) {
            if (this.hva != null && this.hJI != null && this.hJI.aKr != null) {
                this.hva.a(this.hJI.aKr, "from_host_tab_panel");
            }
        } else if (view == this.hKh) {
            cmE();
        } else if (view == this.hKi) {
            cmD();
        } else if (view == this.hJZ) {
            xu(2);
        } else if (view == this.hKa) {
            xu(1);
        }
    }

    private void xu(int i) {
        if (this.hJI != null && this.hJI.mLiveInfo != null && this.hJI.aJV != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.hJI.aJV;
            String valueOf = String.valueOf(this.hJI.mLiveInfo.group_id);
            aa aaVar = new aa();
            aaVar.groupId = valueOf;
            aaVar.aLj = false;
            aaVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            aaVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            aaVar.userName = alaLiveUserInfoData.userName;
            aaVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.bqU = aaVar;
            cVar.bqV = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void cmC() {
    }

    private void cmD() {
        if (this.aJV != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.hKl = true;
            this.blr = this.blr ? false : true;
            if (this.blr) {
                TiebaInitialize.log("c12558");
            }
            cg(this.blr);
            ch(this.blr);
            com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aJV.portrait, String.valueOf(this.aJV.userId), "1", this.blr, hKk);
            fVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Yo().a(String.valueOf(this.aJV.userId), fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
        this.blr = z;
        if (z) {
            this.hKi.setEnabled(false);
            this.hKi.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
            this.hKi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.hKi.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10109));
            this.hKi.setGravity(17);
            return;
        }
        this.hKi.setEnabled(true);
        this.hKi.setText(this.mPageContext.getString(a.h.ala_person_attention));
        this.hKi.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.e.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hKi.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.hKi.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_other_b));
        this.hKi.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(boolean z) {
        if (z) {
            TextView textView = this.hKa;
            Resources resources = this.mPageContext.getResources();
            int i = a.h.ala_host_tab_fans_count;
            int i2 = this.bls + 1;
            this.bls = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.hKa;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.h.ala_host_tab_fans_count;
        int i4 = this.bls - 1;
        this.bls = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void cmE() {
        if (this.aJV != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aJV.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aJV.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.aJV)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bqV = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private ar b(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        ar arVar = new ar();
        arVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        arVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        arVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        arVar.verify_type = alaLiveUserInfoData.verifyType;
        arVar.user_name = alaLiveUserInfoData.userName;
        arVar.user_nickname = alaLiveUserInfoData.userName;
        arVar.pass_name = alaLiveUserInfoData.passName;
        arVar.sex = alaLiveUserInfoData.sex;
        arVar.description = alaLiveUserInfoData.description;
        arVar.portrait = alaLiveUserInfoData.portrait;
        arVar.level_id = alaLiveUserInfoData.levelId;
        arVar.level_exp = alaLiveUserInfoData.levelExp;
        arVar.is_login = alaLiveUserInfoData.isLogin;
        arVar.fans_count = alaLiveUserInfoData.fansCount;
        arVar.follow_count = alaLiveUserInfoData.followCount;
        arVar.user_status = alaLiveUserInfoData.userStatus;
        arVar.live_status = alaLiveUserInfoData.liveStatus;
        arVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        arVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        arVar.record_count = alaLiveUserInfoData.recordCount;
        arVar.location = alaLiveUserInfoData.location;
        arVar.lng = alaLiveUserInfoData.lng;
        arVar.lat = alaLiveUserInfoData.lat;
        arVar.is_block = alaLiveUserInfoData.isBlock;
        arVar.stream_id = alaLiveUserInfoData.streamID;
        arVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        arVar.verify_status = alaLiveUserInfoData.verifyStatus;
        arVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        arVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        arVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        arVar.petal_num = alaLiveUserInfoData.petalNum;
        return arVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.gDu);
        if (this.hva != null) {
            this.hva.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b hJF;

        public a(b bVar) {
            super(bVar.getView());
            this.hJF = bVar;
        }
    }
}
