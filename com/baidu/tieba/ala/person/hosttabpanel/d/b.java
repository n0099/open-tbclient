package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.m;
import com.baidu.live.data.o;
import com.baidu.live.data.x;
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
    private static final BdUniqueId frZ = BdUniqueId.gen();
    private AlaLiveUserInfoData Ya;
    private AlaLocationData Yb;
    private AlaRelationData Yc;
    private boolean arP;
    private int arQ;
    private TextView cbW;
    private CustomMessageListener ewi;
    private HeadImageView fbN;
    private com.baidu.live.z.a feW;
    private ImageView frM;
    private ALALevelView frN;
    private TextView frO;
    private TextView frP;
    private TextView frQ;
    private LinearLayout frR;
    private LinearLayout frS;
    private TextView frT;
    private TbImageView frU;
    private TextView frV;
    private TextView frW;
    private DrawableTextView frX;
    private View frY;
    private m frx;
    private boolean fsa;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.arP = false;
        this.fsa = false;
        this.liveType = 2;
        this.ewi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.Ya.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.frZ);
                        b.this.fsa = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.aR(z);
                                b.this.aS(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Bq().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Bq().a(updateAttentionMessage.getData(), b.this.mPageContext, false)) {
                                b.this.arP = !b.this.arP;
                                b.this.aS(b.this.arP);
                                b.this.aR(b.this.arP);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.arP = b.this.arP ? false : true;
                            b.this.aS(b.this.arP);
                            b.this.aR(b.this.arP);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.fbN = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.fbN.setIsRound(true);
        this.fbN.setAutoChangeStyle(false);
        this.cbW = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.frM = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.frN = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.frO = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.frP = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.frQ = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.frR = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.frS = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.frU = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.frT = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.frV = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.frV.getPaint().setFlags(8);
        this.frV.getPaint().setAntiAlias(true);
        this.frW = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.frX = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.frY = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.frR.setOnClickListener(this);
        this.frV.setOnClickListener(this);
        this.frW.setOnClickListener(this);
        this.frX.setOnClickListener(this);
        this.frO.setOnClickListener(this);
        this.frP.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.ewi);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.z.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.feW = (com.baidu.live.z.a) runTask.getData();
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
        if (aVar != null && aVar.frx != null) {
            this.frx = aVar.frx;
            this.Ya = aVar.frx.Ya;
            this.Yc = aVar.frx.Yc;
            this.Yb = aVar.frx.Yb;
            if (this.frx.mLiveInfo != null) {
                this.liveType = this.frx.mLiveInfo.live_type;
            }
            if (this.Ya != null && this.Yc != null && this.Yb != null) {
                long j = this.Ya.userId;
                if (this.Ya.portrait != null && !this.Ya.portrait.equals("")) {
                    this.fbN.startLoad(this.Ya.portrait, 12, false);
                }
                this.cbW.setText(this.Ya.userName);
                if (j == 0) {
                    this.frM.setVisibility(8);
                } else {
                    this.frM.setVisibility(0);
                    this.frM.setImageResource(this.Ya.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.frN.setupLevelIcon(this.Ya.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.Ya.greatAnchorIcon)) {
                        this.frU.startLoad(this.Ya.greatAnchorIcon, 10, false);
                    } else {
                        this.frU.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.Ya.greatAnchorDescRole) && !StringUtils.isNull(this.Ya.greatAnchorDescGrade)) {
                        this.frT.setText(this.Ya.greatAnchorDescGrade + this.Ya.greatAnchorDescRole);
                    } else {
                        this.frS.setVisibility(8);
                    }
                } else {
                    this.frS.setVisibility(8);
                }
                this.frO.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.Ya.followCount)));
                if (!this.fsa || this.mUserId != this.Ya.userId) {
                    this.fsa = false;
                    this.arQ = this.Ya.fansCount;
                    this.arP = this.Yc.follow_status != 0;
                    this.mUserId = this.Ya.userId;
                }
                this.frP.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.arQ)));
                aR(this.arP);
                if (!StringUtils.isNull(this.Ya.location)) {
                    str = this.Ya.location;
                } else {
                    str = this.Yb.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.frQ.setVisibility(0);
                    this.frY.setVisibility(0);
                    this.frQ.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.frQ.setVisibility(4);
                this.frY.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.frR) {
            bse();
        } else if (view == this.frV) {
            if (this.feW != null && this.frx != null && this.frx.Yo != null) {
                this.feW.a(this.frx.Yo, "from_host_tab_panel");
            }
        } else if (view == this.frW) {
            bsg();
        } else if (view == this.frX) {
            bsf();
        } else if (view == this.frO) {
            qK(2);
        } else if (view == this.frP) {
            qK(1);
        }
    }

    private void qK(int i) {
        if (this.frx != null && this.frx.mLiveInfo != null && this.frx.Ya != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.frx.Ya;
            String valueOf = String.valueOf(this.frx.mLiveInfo.group_id);
            o oVar = new o();
            oVar.groupId = valueOf;
            oVar.YB = false;
            oVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            oVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            oVar.userName = alaLiveUserInfoData.userName;
            oVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.awk = oVar;
            cVar.awl = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void bse() {
    }

    private void bsf() {
        if (this.Ya != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.fsa = true;
            this.arP = this.arP ? false : true;
            if (this.arP) {
                TiebaInitialize.log("c12558");
            }
            aR(this.arP);
            aS(this.arP);
            com.baidu.live.view.a.Bq().a(String.valueOf(this.Ya.userId), new com.baidu.live.data.b(this.Ya.portrait, String.valueOf(this.Ya.userId), "1", this.arP, frZ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(boolean z) {
        this.arP = z;
        if (z) {
            this.frX.setEnabled(false);
            this.frX.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.frX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.frX.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.frX.setGravity(17);
            return;
        }
        this.frX.setEnabled(true);
        this.frX.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.frX.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.frX.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.frX.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.frX.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(boolean z) {
        if (z) {
            TextView textView = this.frP;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.arQ + 1;
            this.arQ = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.frP;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.arQ - 1;
        this.arQ = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bsg() {
        if (this.Ya != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.Ya.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.Ya.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.Ya)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.awl = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private x b(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        x xVar = new x();
        xVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        xVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        xVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        xVar.verify_type = alaLiveUserInfoData.verifyType;
        xVar.user_name = alaLiveUserInfoData.userName;
        xVar.user_nickname = alaLiveUserInfoData.userName;
        xVar.pass_name = alaLiveUserInfoData.passName;
        xVar.sex = alaLiveUserInfoData.sex;
        xVar.description = alaLiveUserInfoData.description;
        xVar.portrait = alaLiveUserInfoData.portrait;
        xVar.level_id = alaLiveUserInfoData.levelId;
        xVar.level_exp = alaLiveUserInfoData.levelExp;
        xVar.is_login = alaLiveUserInfoData.isLogin;
        xVar.fans_count = alaLiveUserInfoData.fansCount;
        xVar.follow_count = alaLiveUserInfoData.followCount;
        xVar.user_status = alaLiveUserInfoData.userStatus;
        xVar.live_status = alaLiveUserInfoData.liveStatus;
        xVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        xVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        xVar.record_count = alaLiveUserInfoData.recordCount;
        xVar.location = alaLiveUserInfoData.location;
        xVar.lng = alaLiveUserInfoData.lng;
        xVar.lat = alaLiveUserInfoData.lat;
        xVar.is_block = alaLiveUserInfoData.isBlock;
        xVar.stream_id = alaLiveUserInfoData.streamID;
        xVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        xVar.verify_status = alaLiveUserInfoData.verifyStatus;
        xVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        xVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        xVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        xVar.petal_num = alaLiveUserInfoData.petalNum;
        return xVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.ewi);
        if (this.feW != null) {
            this.feW.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b fru;

        public a(b bVar) {
            super(bVar.getView());
            this.fru = bVar;
        }
    }
}
