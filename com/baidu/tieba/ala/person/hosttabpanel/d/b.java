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
    private static final BdUniqueId hKi = BdUniqueId.gen();
    private AlaLiveUserInfoData aJV;
    private AlaLocationData aJW;
    private AlaRelationData aJX;
    private boolean blr;
    private int bls;
    private TextView eBQ;
    private CustomMessageListener gDs;
    private w hJG;
    private ImageView hJV;
    private ALALevelView hJW;
    private TextView hJX;
    private TextView hJY;
    private TextView hJZ;
    private LinearLayout hKa;
    private LinearLayout hKb;
    private TextView hKc;
    private TbImageView hKd;
    private TextView hKe;
    private TextView hKf;
    private DrawableTextView hKg;
    private View hKh;
    private boolean hKj;
    private HeadImageView hrp;
    private com.baidu.live.al.a huY;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.blr = false;
        this.hKj = false;
        this.liveType = 2;
        this.gDs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aJV.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.hKi);
                        b.this.hKj = true;
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
        this.hrp = (HeadImageView) this.mRootView.findViewById(a.f.user_icon);
        this.hrp.setIsRound(true);
        this.hrp.setAutoChangeStyle(false);
        this.eBQ = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hJV = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        this.hJW = (ALALevelView) this.mRootView.findViewById(a.f.user_grade);
        this.hJX = (TextView) this.mRootView.findViewById(a.f.user_attention_count);
        this.hJY = (TextView) this.mRootView.findViewById(a.f.user_fans_count);
        this.hJZ = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hKa = (LinearLayout) this.mRootView.findViewById(a.f.profile_container);
        this.hKb = (LinearLayout) this.mRootView.findViewById(a.f.combat_authen_container);
        this.hKd = (TbImageView) this.mRootView.findViewById(a.f.anthen_icon);
        this.hKc = (TextView) this.mRootView.findViewById(a.f.combat_authen);
        this.hKe = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_go_to_authen);
        this.hKe.getPaint().setFlags(8);
        this.hKe.getPaint().setAntiAlias(true);
        this.hKf = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_reply_user);
        this.hKg = (DrawableTextView) this.mRootView.findViewById(a.f.ala_host_tab_attention_btn);
        this.hKh = this.mRootView.findViewById(a.f.divider_behind_fans_count);
        this.hKa.setOnClickListener(this);
        this.hKe.setOnClickListener(this);
        this.hKf.setOnClickListener(this);
        this.hKg.setOnClickListener(this);
        this.hJX.setOnClickListener(this);
        this.hJY.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.gDs);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.al.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.huY = (com.baidu.live.al.a) runTask.getData();
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
        if (aVar != null && aVar.hJG != null) {
            this.hJG = aVar.hJG;
            this.aJV = aVar.hJG.aJV;
            this.aJX = aVar.hJG.aJX;
            this.aJW = aVar.hJG.aJW;
            if (this.hJG.mLiveInfo != null) {
                this.liveType = this.hJG.mLiveInfo.live_type;
            }
            if (this.aJV != null && this.aJX != null && this.aJW != null) {
                long j = this.aJV.userId;
                if (this.aJV.portrait != null && !this.aJV.portrait.equals("")) {
                    this.hrp.startLoad(this.aJV.portrait, 12, false);
                }
                this.eBQ.setText(this.aJV.userName);
                if (j == 0) {
                    this.hJV.setVisibility(8);
                } else {
                    this.hJV.setVisibility(0);
                    this.hJV.setImageResource(this.aJV.sex == 1 ? a.e.sdk_icon_mine_boy : a.e.sdk_icon_mine_girl);
                }
                this.hJW.setupLevelIcon(this.aJV.live_mark_info_new, this.aJV.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aJV.greatAnchorIcon)) {
                        this.hKd.startLoad(this.aJV.greatAnchorIcon, 10, false);
                    } else {
                        this.hKd.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aJV.greatAnchorDescRole) && !StringUtils.isNull(this.aJV.greatAnchorDescGrade)) {
                        this.hKc.setText(this.aJV.greatAnchorDescGrade + this.aJV.greatAnchorDescRole);
                    } else {
                        this.hKb.setVisibility(8);
                    }
                } else {
                    this.hKb.setVisibility(8);
                }
                this.hJX.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aJV.followCount)));
                if (!this.hKj || this.mUserId != this.aJV.userId) {
                    this.hKj = false;
                    this.bls = this.aJV.fansCount;
                    this.blr = this.aJX.follow_status != 0;
                    this.mUserId = this.aJV.userId;
                }
                this.hJY.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.bls)));
                cg(this.blr);
                if (!StringUtils.isNull(this.aJV.location)) {
                    str = this.aJV.location;
                } else {
                    str = this.aJW.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.hJZ.setVisibility(0);
                    this.hKh.setVisibility(0);
                    this.hJZ.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_location, str));
                    return;
                }
                this.hJZ.setVisibility(4);
                this.hKh.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hKa) {
            cmB();
        } else if (view == this.hKe) {
            if (this.huY != null && this.hJG != null && this.hJG.aKr != null) {
                this.huY.a(this.hJG.aKr, "from_host_tab_panel");
            }
        } else if (view == this.hKf) {
            cmD();
        } else if (view == this.hKg) {
            cmC();
        } else if (view == this.hJX) {
            xu(2);
        } else if (view == this.hJY) {
            xu(1);
        }
    }

    private void xu(int i) {
        if (this.hJG != null && this.hJG.mLiveInfo != null && this.hJG.aJV != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.hJG.aJV;
            String valueOf = String.valueOf(this.hJG.mLiveInfo.group_id);
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

    private void cmB() {
    }

    private void cmC() {
        if (this.aJV != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.hKj = true;
            this.blr = this.blr ? false : true;
            if (this.blr) {
                TiebaInitialize.log("c12558");
            }
            cg(this.blr);
            ch(this.blr);
            com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aJV.portrait, String.valueOf(this.aJV.userId), "1", this.blr, hKi);
            fVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Yo().a(String.valueOf(this.aJV.userId), fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
        this.blr = z;
        if (z) {
            this.hKg.setEnabled(false);
            this.hKg.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
            this.hKg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.hKg.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10109));
            this.hKg.setGravity(17);
            return;
        }
        this.hKg.setEnabled(true);
        this.hKg.setText(this.mPageContext.getString(a.h.ala_person_attention));
        this.hKg.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.e.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hKg.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.hKg.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_other_b));
        this.hKg.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(boolean z) {
        if (z) {
            TextView textView = this.hJY;
            Resources resources = this.mPageContext.getResources();
            int i = a.h.ala_host_tab_fans_count;
            int i2 = this.bls + 1;
            this.bls = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.hJY;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.h.ala_host_tab_fans_count;
        int i4 = this.bls - 1;
        this.bls = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void cmD() {
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
        MessageManager.getInstance().unRegisterListener(this.gDs);
        if (this.huY != null) {
            this.huY.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b hJD;

        public a(b bVar) {
            super(bVar.getView());
            this.hJD = bVar;
        }
    }
}
