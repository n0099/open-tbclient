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
/* loaded from: classes11.dex */
public class b extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.a> {
    private static final BdUniqueId hWk = BdUniqueId.gen();
    private AlaLiveUserInfoData aId;
    private AlaLocationData aIe;
    private AlaRelationData aIf;
    private boolean blC;
    private int blD;
    private TextView eIO;
    private CustomMessageListener gNg;
    private HeadImageView hCS;
    private com.baidu.live.ak.a hGz;
    private ab hVI;
    private ImageView hVX;
    private ALALevelView hVY;
    private TextView hVZ;
    private TextView hWa;
    private TextView hWb;
    private LinearLayout hWc;
    private LinearLayout hWd;
    private TextView hWe;
    private TbImageView hWf;
    private TextView hWg;
    private TextView hWh;
    private DrawableTextView hWi;
    private View hWj;
    private boolean hWl;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.blC = false;
        this.hWl = false;
        this.liveType = 2;
        this.gNg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.aId.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.hWk);
                        b.this.hWl = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.ck(z);
                                b.this.cl(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Xo().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.h.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Xo().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.blC = !b.this.blC;
                                b.this.cl(b.this.blC);
                                b.this.ck(b.this.blC);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.blC = b.this.blC ? false : true;
                            b.this.cl(b.this.blC);
                            b.this.ck(b.this.blC);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hCS = (HeadImageView) this.mRootView.findViewById(a.f.user_icon);
        this.hCS.setIsRound(true);
        this.hCS.setAutoChangeStyle(false);
        this.eIO = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hVX = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        this.hVY = (ALALevelView) this.mRootView.findViewById(a.f.user_grade);
        this.hVZ = (TextView) this.mRootView.findViewById(a.f.user_attention_count);
        this.hWa = (TextView) this.mRootView.findViewById(a.f.user_fans_count);
        this.hWb = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hWc = (LinearLayout) this.mRootView.findViewById(a.f.profile_container);
        this.hWd = (LinearLayout) this.mRootView.findViewById(a.f.combat_authen_container);
        this.hWf = (TbImageView) this.mRootView.findViewById(a.f.anthen_icon);
        this.hWe = (TextView) this.mRootView.findViewById(a.f.combat_authen);
        this.hWg = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_go_to_authen);
        this.hWg.getPaint().setFlags(8);
        this.hWg.getPaint().setAntiAlias(true);
        this.hWh = (TextView) this.mRootView.findViewById(a.f.ala_host_tab_reply_user);
        this.hWi = (DrawableTextView) this.mRootView.findViewById(a.f.ala_host_tab_attention_btn);
        this.hWj = this.mRootView.findViewById(a.f.divider_behind_fans_count);
        this.hWc.setOnClickListener(this);
        this.hWg.setOnClickListener(this);
        this.hWh.setOnClickListener(this);
        this.hWi.setOnClickListener(this);
        this.hVZ.setOnClickListener(this);
        this.hWa.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.gNg);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ak.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hGz = (com.baidu.live.ak.a) runTask.getData();
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
        if (aVar != null && aVar.hVI != null) {
            this.hVI = aVar.hVI;
            this.aId = aVar.hVI.aId;
            this.aIf = aVar.hVI.aIf;
            this.aIe = aVar.hVI.aIe;
            if (this.hVI.mLiveInfo != null) {
                this.liveType = this.hVI.mLiveInfo.live_type;
            }
            if (this.aId != null && this.aIf != null && this.aIe != null) {
                long j = this.aId.userId;
                if (this.aId.portrait != null && !this.aId.portrait.equals("")) {
                    this.hCS.startLoad(this.aId.portrait, 12, false);
                }
                this.eIO.setText(this.aId.userName);
                if (j == 0) {
                    this.hVX.setVisibility(8);
                } else {
                    this.hVX.setVisibility(0);
                    this.hVX.setImageResource(this.aId.sex == 1 ? a.e.sdk_icon_mine_boy : a.e.sdk_icon_mine_girl);
                }
                this.hVY.setupLevelIcon(this.aId.live_mark_info_new, this.aId.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.aId.greatAnchorIcon)) {
                        this.hWf.startLoad(this.aId.greatAnchorIcon, 10, false);
                    } else {
                        this.hWf.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.aId.greatAnchorDescRole) && !StringUtils.isNull(this.aId.greatAnchorDescGrade)) {
                        this.hWe.setText(this.aId.greatAnchorDescGrade + this.aId.greatAnchorDescRole);
                    } else {
                        this.hWd.setVisibility(8);
                    }
                } else {
                    this.hWd.setVisibility(8);
                }
                this.hVZ.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.aId.followCount)));
                if (!this.hWl || this.mUserId != this.aId.userId) {
                    this.hWl = false;
                    this.blD = this.aId.fansCount;
                    this.blC = this.aIf.follow_status != 0;
                    this.mUserId = this.aId.userId;
                }
                this.hWa.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.blD)));
                ck(this.blC);
                if (!StringUtils.isNull(this.aId.location)) {
                    str = this.aId.location;
                } else {
                    str = this.aIe.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.hWb.setVisibility(0);
                    this.hWj.setVisibility(0);
                    this.hWb.setText(this.mPageContext.getResources().getString(a.h.ala_host_tab_location, str));
                    return;
                }
                this.hWb.setVisibility(4);
                this.hWj.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hWc) {
            cmA();
        } else if (view == this.hWg) {
            if (this.hGz != null && this.hVI != null && this.hVI.aIz != null) {
                this.hGz.a(this.hVI.aIz, "from_host_tab_panel");
            }
        } else if (view == this.hWh) {
            cmC();
        } else if (view == this.hWi) {
            cmB();
        } else if (view == this.hVZ) {
            wm(2);
        } else if (view == this.hWa) {
            wm(1);
        }
    }

    private void wm(int i) {
        if (this.hVI != null && this.hVI.mLiveInfo != null && this.hVI.aId != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.hVI.aId;
            String valueOf = String.valueOf(this.hVI.mLiveInfo.group_id);
            af afVar = new af();
            afVar.groupId = valueOf;
            afVar.aJC = false;
            afVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            afVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            afVar.userName = alaLiveUserInfoData.userName;
            afVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.brD = afVar;
            cVar.brE = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void cmA() {
    }

    private void cmB() {
        if (this.aId != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.hWl = true;
            this.blC = this.blC ? false : true;
            if (this.blC) {
                TiebaInitialize.log("c12558");
            }
            ck(this.blC);
            cl(this.blC);
            com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aId.portrait, String.valueOf(this.aId.userId), "1", this.blC, hWk);
            fVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Xo().a(String.valueOf(this.aId.userId), fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        this.blC = z;
        if (z) {
            this.hWi.setEnabled(false);
            this.hWi.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
            this.hWi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.hWi.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10109));
            this.hWi.setGravity(17);
            return;
        }
        this.hWi.setEnabled(true);
        this.hWi.setText(this.mPageContext.getString(a.h.ala_person_attention));
        this.hWi.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.e.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hWi.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.hWi.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_other_b));
        this.hWi.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(boolean z) {
        if (z) {
            TextView textView = this.hWa;
            Resources resources = this.mPageContext.getResources();
            int i = a.h.ala_host_tab_fans_count;
            int i2 = this.blD + 1;
            this.blD = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.hWa;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.h.ala_host_tab_fans_count;
        int i4 = this.blD - 1;
        this.blD = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void cmC() {
        if (this.aId != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.aId.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.aId.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.aId)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.brE = (short) 1;
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
        MessageManager.getInstance().unRegisterListener(this.gNg);
        if (this.hGz != null) {
            this.hGz.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b hVF;

        public a(b bVar) {
            super(bVar.getView());
            this.hVF = bVar;
        }
    }
}
