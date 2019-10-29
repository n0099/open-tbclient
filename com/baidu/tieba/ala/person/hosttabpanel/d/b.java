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
    private static final BdUniqueId euT = BdUniqueId.gen();
    private AlaLiveUserInfoData Ps;
    private AlaLocationData Pt;
    private AlaRelationData Pu;
    private boolean afP;
    private int afQ;
    private TextView csn;
    private CustomMessageListener dFe;
    private com.baidu.live.o.a ejc;
    private HeadImageView euF;
    private ImageView euG;
    private ALALevelView euH;
    private TextView euI;
    private TextView euJ;
    private TextView euK;
    private LinearLayout euL;
    private LinearLayout euM;
    private TextView euN;
    private TbImageView euO;
    private TextView euP;
    private TextView euQ;
    private DrawableTextView euR;
    private View euS;
    private boolean euU;
    private i euq;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.afP = false;
        this.euU = false;
        this.liveType = 2;
        this.dFe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.Ps.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.euT);
                        b.this.euU = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.av(z);
                                b.this.aw(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.wx().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.wx().a(updateAttentionMessage.getData(), b.this.mPageContext, false)) {
                                b.this.afP = !b.this.afP;
                                b.this.aw(b.this.afP);
                                b.this.av(b.this.afP);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.afP = b.this.afP ? false : true;
                            b.this.aw(b.this.afP);
                            b.this.av(b.this.afP);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.euF = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.euF.setIsRound(true);
        this.euF.setAutoChangeStyle(false);
        this.csn = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.euG = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.euH = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.euI = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.euJ = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.euK = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.euL = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.euM = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.euO = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.euN = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.euP = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.euP.getPaint().setFlags(8);
        this.euP.getPaint().setAntiAlias(true);
        this.euQ = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.euR = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.euS = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.euL.setOnClickListener(this);
        this.euP.setOnClickListener(this);
        this.euQ.setOnClickListener(this);
        this.euR.setOnClickListener(this);
        this.euI.setOnClickListener(this);
        this.euJ.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.dFe);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.o.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.ejc = (com.baidu.live.o.a) runTask.getData();
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
        if (aVar != null && aVar.euq != null) {
            this.euq = aVar.euq;
            this.Ps = aVar.euq.Ps;
            this.Pu = aVar.euq.Pu;
            this.Pt = aVar.euq.Pt;
            if (this.euq.mLiveInfo != null) {
                this.liveType = this.euq.mLiveInfo.live_type;
            }
            if (this.Ps != null && this.Pu != null && this.Pt != null) {
                long j = this.Ps.userId;
                if (this.Ps.portrait != null && !this.Ps.portrait.equals("")) {
                    this.euF.startLoad(this.Ps.portrait, 12, false);
                }
                this.csn.setText(this.Ps.userName);
                if (j == 0) {
                    this.euG.setVisibility(8);
                } else {
                    this.euG.setVisibility(0);
                    this.euG.setImageResource(this.Ps.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.euH.setupLevelIcon(this.Ps.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.Ps.greatAnchorIcon)) {
                        this.euO.startLoad(this.Ps.greatAnchorIcon, 10, false);
                    } else {
                        this.euO.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.Ps.greatAnchorDescRole) && !StringUtils.isNull(this.Ps.greatAnchorDescGrade)) {
                        this.euN.setText(this.Ps.greatAnchorDescGrade + this.Ps.greatAnchorDescRole);
                    } else {
                        this.euM.setVisibility(8);
                    }
                } else {
                    this.euM.setVisibility(8);
                }
                this.euI.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.Ps.followCount)));
                if (!this.euU || this.mUserId != this.Ps.userId) {
                    this.euU = false;
                    this.afQ = this.Ps.fansCount;
                    this.afP = this.Pu.follow_status != 0;
                    this.mUserId = this.Ps.userId;
                }
                this.euJ.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.afQ)));
                av(this.afP);
                if (!StringUtils.isNull(this.Ps.location)) {
                    str = this.Ps.location;
                } else {
                    str = this.Pt.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.euK.setVisibility(0);
                    this.euS.setVisibility(0);
                    this.euK.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.euK.setVisibility(4);
                this.euS.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.euL) {
            aXv();
        } else if (view == this.euP) {
            if (this.ejc != null && this.euq != null && this.euq.PN != null) {
                this.ejc.a(this.euq.PN, "from_host_tab_panel");
            }
        } else if (view == this.euQ) {
            aXx();
        } else if (view == this.euR) {
            aXw();
        } else if (view == this.euI) {
            of(2);
        } else if (view == this.euJ) {
            of(1);
        }
    }

    private void of(int i) {
        if (this.euq != null && this.euq.mLiveInfo != null && this.euq.Ps != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.euq.Ps;
            String valueOf = String.valueOf(this.euq.mLiveInfo.group_id);
            j jVar = new j();
            jVar.groupId = valueOf;
            jVar.PW = false;
            jVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            jVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            jVar.userName = alaLiveUserInfoData.userName;
            jVar.tabType = i;
            com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
            cVar.ajH = jVar;
            cVar.ajI = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void aXv() {
    }

    private void aXw() {
        if (this.Ps != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.euU = true;
            this.afP = this.afP ? false : true;
            if (this.afP) {
                TiebaInitialize.log("c12558");
            }
            av(this.afP);
            aw(this.afP);
            com.baidu.live.view.a.wx().a(String.valueOf(this.Ps.userId), new com.baidu.live.data.b(this.Ps.portrait, String.valueOf(this.Ps.userId), "1", this.afP, euT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(boolean z) {
        this.afP = z;
        if (z) {
            this.euR.setEnabled(false);
            this.euR.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.euR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.euR.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.euR.setGravity(17);
            return;
        }
        this.euR.setEnabled(true);
        this.euR.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.euR.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.euR.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.euR.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.euR.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(boolean z) {
        if (z) {
            TextView textView = this.euJ;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.afQ + 1;
            this.afQ = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.euJ;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.afQ - 1;
        this.afQ = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void aXx() {
        if (this.Ps != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.Ps.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.Ps.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.Ps)));
                com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
                cVar.ajI = (short) 1;
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
        MessageManager.getInstance().unRegisterListener(this.dFe);
        if (this.ejc != null) {
            this.ejc.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.euF != null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b eun;

        public a(b bVar) {
            super(bVar.getView());
            this.eun = bVar;
        }
    }
}
