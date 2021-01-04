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
import com.baidu.live.data.at;
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
/* loaded from: classes11.dex */
public class b extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.a> {
    private static final BdUniqueId hWw = BdUniqueId.gen();
    private AlaLiveUserInfoData aKu;
    private AlaLocationData aKv;
    private AlaRelationData aKw;
    private boolean bmX;
    private int bmY;
    private TextView eLt;
    private CustomMessageListener gPg;
    private HeadImageView hDn;
    private com.baidu.live.am.a hGW;
    private x hVU;
    private ImageView hWj;
    private ALALevelView hWk;
    private TextView hWl;
    private TextView hWm;
    private TextView hWn;
    private LinearLayout hWo;
    private LinearLayout hWp;
    private TextView hWq;
    private TbImageView hWr;
    private TextView hWs;
    private TextView hWt;
    private DrawableTextView hWu;
    private View hWv;
    private boolean hWx;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.bmX = false;
        this.hWx = false;
        this.liveType = 2;
        this.gPg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aKu.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.hWw);
                        b.this.hWx = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.cg(z);
                                b.this.ch(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Zx().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.h.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Zx().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.bmX = !b.this.bmX;
                                b.this.ch(b.this.bmX);
                                b.this.cg(b.this.bmX);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.bmX = b.this.bmX ? false : true;
                            b.this.ch(b.this.bmX);
                            b.this.cg(b.this.bmX);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hDn = (HeadImageView) this.mRootView.findViewById(a.f.user_icon);
        this.hDn.setIsRound(true);
        this.hDn.setAutoChangeStyle(false);
        this.eLt = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hWj = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        this.hWk = (ALALevelView) this.mRootView.findViewById(a.f.user_grade);
        this.hWl = (TextView) this.mRootView.findViewById(a.f.user_attention_count);
        this.hWm = (TextView) this.mRootView.findViewById(a.f.user_fans_count);
        this.hWn = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hWo = (LinearLayout) this.mRootView.findViewById(a.f.profile_container);
        this.hWp = (LinearLayout) this.mRootView.findViewById(a.f.combat_authen_container);
        this.hWr = (TbImageView) this.mRootView.findViewById(a.f.anthen_icon);
        this.hWq = (TextView) this.mRootView.findViewById(a.f.combat_authen);
        this.hWs = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_go_to_authen);
        this.hWs.getPaint().setFlags(8);
        this.hWs.getPaint().setAntiAlias(true);
        this.hWt = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_reply_user);
        this.hWu = (DrawableTextView) this.mRootView.findViewById(a.f.ala_host_tab_attention_btn);
        this.hWv = this.mRootView.findViewById(a.f.divider_behind_fans_count);
        this.hWo.setOnClickListener(this);
        this.hWs.setOnClickListener(this);
        this.hWt.setOnClickListener(this);
        this.hWu.setOnClickListener(this);
        this.hWl.setOnClickListener(this);
        this.hWm.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.gPg);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.am.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hGW = (com.baidu.live.am.a) runTask.getData();
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
        if (aVar != null && aVar.hVU != null) {
            this.hVU = aVar.hVU;
            this.aKu = aVar.hVU.aKu;
            this.aKw = aVar.hVU.aKw;
            this.aKv = aVar.hVU.aKv;
            if (this.hVU.mLiveInfo != null) {
                this.liveType = this.hVU.mLiveInfo.live_type;
            }
            if (this.aKu != null && this.aKw != null && this.aKv != null) {
                long j = this.aKu.userId;
                if (this.aKu.portrait != null && !this.aKu.portrait.equals("")) {
                    this.hDn.startLoad(this.aKu.portrait, 12, false);
                }
                this.eLt.setText(this.aKu.userName);
                if (j == 0) {
                    this.hWj.setVisibility(8);
                } else {
                    this.hWj.setVisibility(0);
                    this.hWj.setImageResource(this.aKu.sex == 1 ? a.e.sdk_icon_mine_boy : a.e.sdk_icon_mine_girl);
                }
                this.hWk.setupLevelIcon(this.aKu.live_mark_info_new, this.aKu.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aKu.greatAnchorIcon)) {
                        this.hWr.startLoad(this.aKu.greatAnchorIcon, 10, false);
                    } else {
                        this.hWr.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aKu.greatAnchorDescRole) && !StringUtils.isNull(this.aKu.greatAnchorDescGrade)) {
                        this.hWq.setText(this.aKu.greatAnchorDescGrade + this.aKu.greatAnchorDescRole);
                    } else {
                        this.hWp.setVisibility(8);
                    }
                } else {
                    this.hWp.setVisibility(8);
                }
                this.hWl.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aKu.followCount)));
                if (!this.hWx || this.mUserId != this.aKu.userId) {
                    this.hWx = false;
                    this.bmY = this.aKu.fansCount;
                    this.bmX = this.aKw.follow_status != 0;
                    this.mUserId = this.aKu.userId;
                }
                this.hWm.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.bmY)));
                cg(this.bmX);
                if (!StringUtils.isNull(this.aKu.location)) {
                    str = this.aKu.location;
                } else {
                    str = this.aKv.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.hWn.setVisibility(0);
                    this.hWv.setVisibility(0);
                    this.hWn.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_location, str));
                    return;
                }
                this.hWn.setVisibility(4);
                this.hWv.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hWo) {
            cpt();
        } else if (view == this.hWs) {
            if (this.hGW != null && this.hVU != null && this.hVU.aKQ != null) {
                this.hGW.a(this.hVU.aKQ, "from_host_tab_panel");
            }
        } else if (view == this.hWt) {
            cpv();
        } else if (view == this.hWu) {
            cpu();
        } else if (view == this.hWl) {
            xH(2);
        } else if (view == this.hWm) {
            xH(1);
        }
    }

    private void xH(int i) {
        if (this.hVU != null && this.hVU.mLiveInfo != null && this.hVU.aKu != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.hVU.aKu;
            String valueOf = String.valueOf(this.hVU.mLiveInfo.group_id);
            ab abVar = new ab();
            abVar.groupId = valueOf;
            abVar.aLL = false;
            abVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            abVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            abVar.userName = alaLiveUserInfoData.userName;
            abVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.bsO = abVar;
            cVar.bsP = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void cpt() {
    }

    private void cpu() {
        if (this.aKu != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.hWx = true;
            this.bmX = this.bmX ? false : true;
            if (this.bmX) {
                TiebaInitialize.log("c12558");
            }
            cg(this.bmX);
            ch(this.bmX);
            com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aKu.portrait, String.valueOf(this.aKu.userId), "1", this.bmX, hWw);
            fVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Zx().a(String.valueOf(this.aKu.userId), fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
        this.bmX = z;
        if (z) {
            this.hWu.setEnabled(false);
            this.hWu.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
            this.hWu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.hWu.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10109));
            this.hWu.setGravity(17);
            return;
        }
        this.hWu.setEnabled(true);
        this.hWu.setText(this.mPageContext.getString(a.h.ala_person_attention));
        this.hWu.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.e.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hWu.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.hWu.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_other_b));
        this.hWu.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(boolean z) {
        if (z) {
            TextView textView = this.hWm;
            Resources resources = this.mPageContext.getResources();
            int i = a.h.ala_host_tab_fans_count;
            int i2 = this.bmY + 1;
            this.bmY = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.hWm;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.h.ala_host_tab_fans_count;
        int i4 = this.bmY - 1;
        this.bmY = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void cpv() {
        if (this.aKu != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aKu.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aKu.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.aKu)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bsP = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private at b(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        at atVar = new at();
        atVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        atVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        atVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        atVar.verify_type = alaLiveUserInfoData.verifyType;
        atVar.user_name = alaLiveUserInfoData.userName;
        atVar.user_nickname = alaLiveUserInfoData.userName;
        atVar.pass_name = alaLiveUserInfoData.passName;
        atVar.sex = alaLiveUserInfoData.sex;
        atVar.description = alaLiveUserInfoData.description;
        atVar.portrait = alaLiveUserInfoData.portrait;
        atVar.level_id = alaLiveUserInfoData.levelId;
        atVar.level_exp = alaLiveUserInfoData.levelExp;
        atVar.is_login = alaLiveUserInfoData.isLogin;
        atVar.fans_count = alaLiveUserInfoData.fansCount;
        atVar.follow_count = alaLiveUserInfoData.followCount;
        atVar.user_status = alaLiveUserInfoData.userStatus;
        atVar.live_status = alaLiveUserInfoData.liveStatus;
        atVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        atVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        atVar.record_count = alaLiveUserInfoData.recordCount;
        atVar.location = alaLiveUserInfoData.location;
        atVar.lng = alaLiveUserInfoData.lng;
        atVar.lat = alaLiveUserInfoData.lat;
        atVar.is_block = alaLiveUserInfoData.isBlock;
        atVar.stream_id = alaLiveUserInfoData.streamID;
        atVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        atVar.verify_status = alaLiveUserInfoData.verifyStatus;
        atVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        atVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        atVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        atVar.petal_num = alaLiveUserInfoData.petalNum;
        return atVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.gPg);
        if (this.hGW != null) {
            this.hGW.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b hVR;

        public a(b bVar) {
            super(bVar.getView());
            this.hVR = bVar;
        }
    }
}
