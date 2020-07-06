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
import com.baidu.live.data.ae;
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
/* loaded from: classes3.dex */
public class b extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.a> {
    private static final BdUniqueId gys = BdUniqueId.gen();
    private boolean aTm;
    private int aTn;
    private AlaLiveUserInfoData axp;
    private AlaLocationData axq;
    private AlaRelationData axr;
    private TextView dEL;
    private CustomMessageListener fzf;
    private HeadImageView gha;
    private com.baidu.live.ab.a gkt;
    private q gxR;
    private ImageView gyf;
    private ALALevelView gyg;
    private TextView gyh;
    private TextView gyi;
    private TextView gyj;
    private LinearLayout gyk;
    private LinearLayout gyl;
    private TextView gym;
    private TbImageView gyn;
    private TextView gyo;
    private TextView gyp;
    private DrawableTextView gyq;
    private View gyr;
    private boolean gyt;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.aTm = false;
        this.gyt = false;
        this.liveType = 2;
        this.fzf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.axp.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.gys);
                        b.this.gyt = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.bE(z);
                                b.this.bF(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Ky().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Ky().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.aTm = !b.this.aTm;
                                b.this.bF(b.this.aTm);
                                b.this.bE(b.this.aTm);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.aTm = b.this.aTm ? false : true;
                            b.this.bF(b.this.aTm);
                            b.this.bE(b.this.aTm);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gha = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.gha.setIsRound(true);
        this.gha.setAutoChangeStyle(false);
        this.dEL = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gyf = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.gyg = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.gyh = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.gyi = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.gyj = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gyk = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.gyl = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.gyn = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.gym = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.gyo = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.gyo.getPaint().setFlags(8);
        this.gyo.getPaint().setAntiAlias(true);
        this.gyp = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.gyq = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.gyr = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.gyk.setOnClickListener(this);
        this.gyo.setOnClickListener(this);
        this.gyp.setOnClickListener(this);
        this.gyq.setOnClickListener(this);
        this.gyh.setOnClickListener(this);
        this.gyi.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.fzf);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ab.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gkt = (com.baidu.live.ab.a) runTask.getData();
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
        if (aVar != null && aVar.gxR != null) {
            this.gxR = aVar.gxR;
            this.axp = aVar.gxR.axp;
            this.axr = aVar.gxR.axr;
            this.axq = aVar.gxR.axq;
            if (this.gxR.mLiveInfo != null) {
                this.liveType = this.gxR.mLiveInfo.live_type;
            }
            if (this.axp != null && this.axr != null && this.axq != null) {
                long j = this.axp.userId;
                if (this.axp.portrait != null && !this.axp.portrait.equals("")) {
                    this.gha.startLoad(this.axp.portrait, 12, false);
                }
                this.dEL.setText(this.axp.userName);
                if (j == 0) {
                    this.gyf.setVisibility(8);
                } else {
                    this.gyf.setVisibility(0);
                    this.gyf.setImageResource(this.axp.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.gyg.setupLevelIcon(this.axp.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.axp.greatAnchorIcon)) {
                        this.gyn.startLoad(this.axp.greatAnchorIcon, 10, false);
                    } else {
                        this.gyn.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.axp.greatAnchorDescRole) && !StringUtils.isNull(this.axp.greatAnchorDescGrade)) {
                        this.gym.setText(this.axp.greatAnchorDescGrade + this.axp.greatAnchorDescRole);
                    } else {
                        this.gyl.setVisibility(8);
                    }
                } else {
                    this.gyl.setVisibility(8);
                }
                this.gyh.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.axp.followCount)));
                if (!this.gyt || this.mUserId != this.axp.userId) {
                    this.gyt = false;
                    this.aTn = this.axp.fansCount;
                    this.aTm = this.axr.follow_status != 0;
                    this.mUserId = this.axp.userId;
                }
                this.gyi.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.aTn)));
                bE(this.aTm);
                if (!StringUtils.isNull(this.axp.location)) {
                    str = this.axp.location;
                } else {
                    str = this.axq.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.gyj.setVisibility(0);
                    this.gyr.setVisibility(0);
                    this.gyj.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.gyj.setVisibility(4);
                this.gyr.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gyk) {
            bLh();
        } else if (view == this.gyo) {
            if (this.gkt != null && this.gxR != null && this.gxR.axI != null) {
                this.gkt.a(this.gxR.axI, "from_host_tab_panel");
            }
        } else if (view == this.gyp) {
            bLj();
        } else if (view == this.gyq) {
            bLi();
        } else if (view == this.gyh) {
            sf(2);
        } else if (view == this.gyi) {
            sf(1);
        }
    }

    private void sf(int i) {
        if (this.gxR != null && this.gxR.mLiveInfo != null && this.gxR.axp != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.gxR.axp;
            String valueOf = String.valueOf(this.gxR.mLiveInfo.group_id);
            t tVar = new t();
            tVar.groupId = valueOf;
            tVar.axZ = false;
            tVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            tVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            tVar.userName = alaLiveUserInfoData.userName;
            tVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.aYL = tVar;
            cVar.aYM = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void bLh() {
    }

    private void bLi() {
        if (this.axp != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.gyt = true;
            this.aTm = this.aTm ? false : true;
            if (this.aTm) {
                TiebaInitialize.log("c12558");
            }
            bE(this.aTm);
            bF(this.aTm);
            com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.axp.portrait, String.valueOf(this.axp.userId), "1", this.aTm, gys);
            dVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Ky().a(String.valueOf(this.axp.userId), dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        this.aTm = z;
        if (z) {
            this.gyq.setEnabled(false);
            this.gyq.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.gyq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gyq.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.gyq.setGravity(17);
            return;
        }
        this.gyq.setEnabled(true);
        this.gyq.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.gyq.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gyq.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.gyq.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.gyq.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (z) {
            TextView textView = this.gyi;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.aTn + 1;
            this.aTn = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.gyi;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.aTn - 1;
        this.aTn = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bLj() {
        if (this.axp != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.axp.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.axp.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, c(this.axp)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.aYM = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private ae c(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        ae aeVar = new ae();
        aeVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        aeVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        aeVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        aeVar.verify_type = alaLiveUserInfoData.verifyType;
        aeVar.user_name = alaLiveUserInfoData.userName;
        aeVar.user_nickname = alaLiveUserInfoData.userName;
        aeVar.pass_name = alaLiveUserInfoData.passName;
        aeVar.sex = alaLiveUserInfoData.sex;
        aeVar.description = alaLiveUserInfoData.description;
        aeVar.portrait = alaLiveUserInfoData.portrait;
        aeVar.level_id = alaLiveUserInfoData.levelId;
        aeVar.level_exp = alaLiveUserInfoData.levelExp;
        aeVar.is_login = alaLiveUserInfoData.isLogin;
        aeVar.fans_count = alaLiveUserInfoData.fansCount;
        aeVar.follow_count = alaLiveUserInfoData.followCount;
        aeVar.user_status = alaLiveUserInfoData.userStatus;
        aeVar.live_status = alaLiveUserInfoData.liveStatus;
        aeVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        aeVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        aeVar.record_count = alaLiveUserInfoData.recordCount;
        aeVar.location = alaLiveUserInfoData.location;
        aeVar.lng = alaLiveUserInfoData.lng;
        aeVar.lat = alaLiveUserInfoData.lat;
        aeVar.is_block = alaLiveUserInfoData.isBlock;
        aeVar.stream_id = alaLiveUserInfoData.streamID;
        aeVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        aeVar.verify_status = alaLiveUserInfoData.verifyStatus;
        aeVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        aeVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        aeVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        aeVar.petal_num = alaLiveUserInfoData.petalNum;
        return aeVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.fzf);
        if (this.gkt != null) {
            this.gkt.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b gxO;

        public a(b bVar) {
            super(bVar.getView());
            this.gxO = bVar;
        }
    }
}
