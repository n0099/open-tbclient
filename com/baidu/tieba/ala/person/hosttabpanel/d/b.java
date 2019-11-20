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
import com.baidu.live.data.i;
import com.baidu.live.data.j;
import com.baidu.live.data.s;
import com.baidu.live.k.a;
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
/* loaded from: classes6.dex */
public class b extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.a> {
    private static final BdUniqueId euc = BdUniqueId.gen();
    private AlaLiveUserInfoData OR;
    private AlaLocationData OT;
    private AlaRelationData OU;
    private boolean afx;
    private int afy;
    private TextView crw;
    private CustomMessageListener dEn;
    private com.baidu.live.o.a eil;
    private HeadImageView etO;
    private ImageView etP;
    private ALALevelView etQ;
    private TextView etR;
    private TextView etS;
    private TextView etT;
    private LinearLayout etU;
    private LinearLayout etV;
    private TextView etW;
    private TbImageView etX;
    private TextView etY;
    private TextView etZ;
    private i etz;
    private DrawableTextView eua;
    private View eub;
    private boolean eud;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.afx = false;
        this.eud = false;
        this.liveType = 2;
        this.dEn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.OR.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.euc);
                        b.this.eud = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.av(z);
                                b.this.aw(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.wy().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.wy().a(updateAttentionMessage.getData(), b.this.mPageContext, false)) {
                                b.this.afx = !b.this.afx;
                                b.this.aw(b.this.afx);
                                b.this.av(b.this.afx);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.afx = b.this.afx ? false : true;
                            b.this.aw(b.this.afx);
                            b.this.av(b.this.afx);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.etO = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.etO.setIsRound(true);
        this.etO.setAutoChangeStyle(false);
        this.crw = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.etP = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.etQ = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.etR = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.etS = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.etT = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.etU = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.etV = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.etX = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.etW = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.etY = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.etY.getPaint().setFlags(8);
        this.etY.getPaint().setAntiAlias(true);
        this.etZ = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.eua = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.eub = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.etU.setOnClickListener(this);
        this.etY.setOnClickListener(this);
        this.etZ.setOnClickListener(this);
        this.eua.setOnClickListener(this);
        this.etR.setOnClickListener(this);
        this.etS.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.dEn);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.o.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eil = (com.baidu.live.o.a) runTask.getData();
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
        if (aVar != null && aVar.etz != null) {
            this.etz = aVar.etz;
            this.OR = aVar.etz.OR;
            this.OU = aVar.etz.OU;
            this.OT = aVar.etz.OT;
            if (this.etz.mLiveInfo != null) {
                this.liveType = this.etz.mLiveInfo.live_type;
            }
            if (this.OR != null && this.OU != null && this.OT != null) {
                long j = this.OR.userId;
                if (this.OR.portrait != null && !this.OR.portrait.equals("")) {
                    this.etO.startLoad(this.OR.portrait, 12, false);
                }
                this.crw.setText(this.OR.userName);
                if (j == 0) {
                    this.etP.setVisibility(8);
                } else {
                    this.etP.setVisibility(0);
                    this.etP.setImageResource(this.OR.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.etQ.setupLevelIcon(this.OR.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.OR.greatAnchorIcon)) {
                        this.etX.startLoad(this.OR.greatAnchorIcon, 10, false);
                    } else {
                        this.etX.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.OR.greatAnchorDescRole) && !StringUtils.isNull(this.OR.greatAnchorDescGrade)) {
                        this.etW.setText(this.OR.greatAnchorDescGrade + this.OR.greatAnchorDescRole);
                    } else {
                        this.etV.setVisibility(8);
                    }
                } else {
                    this.etV.setVisibility(8);
                }
                this.etR.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.OR.followCount)));
                if (!this.eud || this.mUserId != this.OR.userId) {
                    this.eud = false;
                    this.afy = this.OR.fansCount;
                    this.afx = this.OU.follow_status != 0;
                    this.mUserId = this.OR.userId;
                }
                this.etS.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.afy)));
                av(this.afx);
                if (!StringUtils.isNull(this.OR.location)) {
                    str = this.OR.location;
                } else {
                    str = this.OT.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.etT.setVisibility(0);
                    this.eub.setVisibility(0);
                    this.etT.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.etT.setVisibility(4);
                this.eub.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.etU) {
            aXt();
        } else if (view == this.etY) {
            if (this.eil != null && this.etz != null && this.etz.Pj != null) {
                this.eil.a(this.etz.Pj, "from_host_tab_panel");
            }
        } else if (view == this.etZ) {
            aXv();
        } else if (view == this.eua) {
            aXu();
        } else if (view == this.etR) {
            oe(2);
        } else if (view == this.etS) {
            oe(1);
        }
    }

    private void oe(int i) {
        if (this.etz != null && this.etz.mLiveInfo != null && this.etz.OR != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.etz.OR;
            String valueOf = String.valueOf(this.etz.mLiveInfo.group_id);
            j jVar = new j();
            jVar.groupId = valueOf;
            jVar.Pr = false;
            jVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            jVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            jVar.userName = alaLiveUserInfoData.userName;
            jVar.tabType = i;
            com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
            cVar.ajp = jVar;
            cVar.ajq = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void aXt() {
    }

    private void aXu() {
        if (this.OR != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.eud = true;
            this.afx = this.afx ? false : true;
            if (this.afx) {
                TiebaInitialize.log("c12558");
            }
            av(this.afx);
            aw(this.afx);
            com.baidu.live.view.a.wy().a(String.valueOf(this.OR.userId), new com.baidu.live.data.b(this.OR.portrait, String.valueOf(this.OR.userId), "1", this.afx, euc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(boolean z) {
        this.afx = z;
        if (z) {
            this.eua.setEnabled(false);
            this.eua.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.eua.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eua.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.eua.setGravity(17);
            return;
        }
        this.eua.setEnabled(true);
        this.eua.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.eua.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.eua.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.eua.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.eua.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(boolean z) {
        if (z) {
            TextView textView = this.etS;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.afy + 1;
            this.afy = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.etS;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.afy - 1;
        this.afy = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void aXv() {
        if (this.OR != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.OR.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.OR.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.OR)));
                com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
                cVar.ajq = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private s b(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        s sVar = new s();
        sVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        sVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        sVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        sVar.verify_type = alaLiveUserInfoData.verifyType;
        sVar.user_name = alaLiveUserInfoData.userName;
        sVar.user_nickname = alaLiveUserInfoData.userName;
        sVar.pass_name = alaLiveUserInfoData.passName;
        sVar.sex = alaLiveUserInfoData.sex;
        sVar.description = alaLiveUserInfoData.description;
        sVar.portrait = alaLiveUserInfoData.portrait;
        sVar.level_id = alaLiveUserInfoData.levelId;
        sVar.level_exp = alaLiveUserInfoData.levelExp;
        sVar.is_login = alaLiveUserInfoData.isLogin;
        sVar.fans_count = alaLiveUserInfoData.fansCount;
        sVar.follow_count = alaLiveUserInfoData.followCount;
        sVar.user_status = alaLiveUserInfoData.userStatus;
        sVar.live_status = alaLiveUserInfoData.liveStatus;
        sVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        sVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        sVar.record_count = alaLiveUserInfoData.recordCount;
        sVar.location = alaLiveUserInfoData.location;
        sVar.lng = alaLiveUserInfoData.lng;
        sVar.lat = alaLiveUserInfoData.lat;
        sVar.is_block = alaLiveUserInfoData.isBlock;
        sVar.stream_id = alaLiveUserInfoData.streamID;
        sVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        sVar.verify_status = alaLiveUserInfoData.verifyStatus;
        sVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        sVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        sVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        sVar.petal_num = alaLiveUserInfoData.petalNum;
        return sVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.dEn);
        if (this.eil != null) {
            this.eil.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.etO != null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b etw;

        public a(b bVar) {
            super(bVar.getView());
            this.etw = bVar;
        }
    }
}
