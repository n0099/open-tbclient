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
import com.baidu.live.data.ad;
import com.baidu.live.data.q;
import com.baidu.live.data.s;
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
    private static final BdUniqueId glE = BdUniqueId.gen();
    private boolean aQG;
    private int aQH;
    private AlaLiveUserInfoData avj;
    private AlaLocationData avk;
    private AlaRelationData avl;
    private TextView dXU;
    private HeadImageView fUh;
    private com.baidu.live.ab.a fXs;
    private CustomMessageListener fnS;
    private TextView glA;
    private TextView glB;
    private DrawableTextView glC;
    private View glD;
    private boolean glF;
    private q gld;
    private ImageView glr;
    private ALALevelView gls;
    private TextView glt;
    private TextView glu;
    private TextView glv;
    private LinearLayout glw;
    private LinearLayout glx;
    private TextView gly;
    private TbImageView glz;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.aQG = false;
        this.glF = false;
        this.liveType = 2;
        this.fnS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.avj.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.glE);
                        b.this.glF = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.bE(z);
                                b.this.bF(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Jl().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Jl().a(updateAttentionMessage.getData(), (BdPageContext<?>) b.this.mPageContext, false)) {
                                b.this.aQG = !b.this.aQG;
                                b.this.bF(b.this.aQG);
                                b.this.bE(b.this.aQG);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.aQG = b.this.aQG ? false : true;
                            b.this.bF(b.this.aQG);
                            b.this.bE(b.this.aQG);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.fUh = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.fUh.setIsRound(true);
        this.fUh.setAutoChangeStyle(false);
        this.dXU = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.glr = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.gls = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.glt = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.glu = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.glv = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.glw = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.glx = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.glz = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.gly = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.glA = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.glA.getPaint().setFlags(8);
        this.glA.getPaint().setAntiAlias(true);
        this.glB = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.glC = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.glD = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.glw.setOnClickListener(this);
        this.glA.setOnClickListener(this);
        this.glB.setOnClickListener(this);
        this.glC.setOnClickListener(this);
        this.glt.setOnClickListener(this);
        this.glu.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.fnS);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ab.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fXs = (com.baidu.live.ab.a) runTask.getData();
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
        if (aVar != null && aVar.gld != null) {
            this.gld = aVar.gld;
            this.avj = aVar.gld.avj;
            this.avl = aVar.gld.avl;
            this.avk = aVar.gld.avk;
            if (this.gld.mLiveInfo != null) {
                this.liveType = this.gld.mLiveInfo.live_type;
            }
            if (this.avj != null && this.avl != null && this.avk != null) {
                long j = this.avj.userId;
                if (this.avj.portrait != null && !this.avj.portrait.equals("")) {
                    this.fUh.startLoad(this.avj.portrait, 12, false);
                }
                this.dXU.setText(this.avj.userName);
                if (j == 0) {
                    this.glr.setVisibility(8);
                } else {
                    this.glr.setVisibility(0);
                    this.glr.setImageResource(this.avj.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.gls.setupLevelIcon(this.avj.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.avj.greatAnchorIcon)) {
                        this.glz.startLoad(this.avj.greatAnchorIcon, 10, false);
                    } else {
                        this.glz.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.avj.greatAnchorDescRole) && !StringUtils.isNull(this.avj.greatAnchorDescGrade)) {
                        this.gly.setText(this.avj.greatAnchorDescGrade + this.avj.greatAnchorDescRole);
                    } else {
                        this.glx.setVisibility(8);
                    }
                } else {
                    this.glx.setVisibility(8);
                }
                this.glt.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.avj.followCount)));
                if (!this.glF || this.mUserId != this.avj.userId) {
                    this.glF = false;
                    this.aQH = this.avj.fansCount;
                    this.aQG = this.avl.follow_status != 0;
                    this.mUserId = this.avj.userId;
                }
                this.glu.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.aQH)));
                bE(this.aQG);
                if (!StringUtils.isNull(this.avj.location)) {
                    str = this.avj.location;
                } else {
                    str = this.avk.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.glv.setVisibility(0);
                    this.glD.setVisibility(0);
                    this.glv.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.glv.setVisibility(4);
                this.glD.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.glw) {
            bIc();
        } else if (view == this.glA) {
            if (this.fXs != null && this.gld != null && this.gld.avC != null) {
                this.fXs.a(this.gld.avC, "from_host_tab_panel");
            }
        } else if (view == this.glB) {
            bIe();
        } else if (view == this.glC) {
            bId();
        } else if (view == this.glt) {
            rH(2);
        } else if (view == this.glu) {
            rH(1);
        }
    }

    private void rH(int i) {
        if (this.gld != null && this.gld.mLiveInfo != null && this.gld.avj != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.gld.avj;
            String valueOf = String.valueOf(this.gld.mLiveInfo.group_id);
            s sVar = new s();
            sVar.groupId = valueOf;
            sVar.avR = false;
            sVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            sVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            sVar.userName = alaLiveUserInfoData.userName;
            sVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.aWc = sVar;
            cVar.aWd = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void bIc() {
    }

    private void bId() {
        if (this.avj != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.glF = true;
            this.aQG = this.aQG ? false : true;
            if (this.aQG) {
                TiebaInitialize.log("c12558");
            }
            bE(this.aQG);
            bF(this.aQG);
            com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.avj.portrait, String.valueOf(this.avj.userId), "1", this.aQG, glE);
            dVar.setFrom("source_person_card_tab_host");
            com.baidu.live.view.a.Jl().a(String.valueOf(this.avj.userId), dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        this.aQG = z;
        if (z) {
            this.glC.setEnabled(false);
            this.glC.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.glC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.glC.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.glC.setGravity(17);
            return;
        }
        this.glC.setEnabled(true);
        this.glC.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.glC.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.glC.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.glC.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.glC.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (z) {
            TextView textView = this.glu;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.aQH + 1;
            this.aQH = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.glu;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.aQH - 1;
        this.aQH = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bIe() {
        if (this.avj != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.avj.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.avj.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, c(this.avj)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.aWd = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private ad c(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        ad adVar = new ad();
        adVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        adVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        adVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        adVar.verify_type = alaLiveUserInfoData.verifyType;
        adVar.user_name = alaLiveUserInfoData.userName;
        adVar.user_nickname = alaLiveUserInfoData.userName;
        adVar.pass_name = alaLiveUserInfoData.passName;
        adVar.sex = alaLiveUserInfoData.sex;
        adVar.description = alaLiveUserInfoData.description;
        adVar.portrait = alaLiveUserInfoData.portrait;
        adVar.level_id = alaLiveUserInfoData.levelId;
        adVar.level_exp = alaLiveUserInfoData.levelExp;
        adVar.is_login = alaLiveUserInfoData.isLogin;
        adVar.fans_count = alaLiveUserInfoData.fansCount;
        adVar.follow_count = alaLiveUserInfoData.followCount;
        adVar.user_status = alaLiveUserInfoData.userStatus;
        adVar.live_status = alaLiveUserInfoData.liveStatus;
        adVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        adVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        adVar.record_count = alaLiveUserInfoData.recordCount;
        adVar.location = alaLiveUserInfoData.location;
        adVar.lng = alaLiveUserInfoData.lng;
        adVar.lat = alaLiveUserInfoData.lat;
        adVar.is_block = alaLiveUserInfoData.isBlock;
        adVar.stream_id = alaLiveUserInfoData.streamID;
        adVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        adVar.verify_status = alaLiveUserInfoData.verifyStatus;
        adVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        adVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        adVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        adVar.petal_num = alaLiveUserInfoData.petalNum;
        return adVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.fnS);
        if (this.fXs != null) {
            this.fXs.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b gla;

        public a(b bVar) {
            super(bVar.getView());
            this.gla = bVar;
        }
    }
}
