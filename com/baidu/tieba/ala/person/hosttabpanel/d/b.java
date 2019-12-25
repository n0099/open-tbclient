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
import com.baidu.live.data.k;
import com.baidu.live.data.l;
import com.baidu.live.data.u;
import com.baidu.live.q.a;
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
/* loaded from: classes2.dex */
public class b extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.a> {
    private static final BdUniqueId fly = BdUniqueId.gen();
    private AlaLiveUserInfoData VP;
    private AlaLocationData VQ;
    private AlaRelationData VR;
    private int anA;
    private boolean anz;
    private TextView bXt;
    private com.baidu.live.u.a eYw;
    private CustomMessageListener eqb;
    private k fkV;
    private HeadImageView flk;
    private ImageView fll;
    private ALALevelView flm;
    private TextView fln;
    private TextView flo;
    private TextView flp;
    private LinearLayout flq;
    private LinearLayout flr;
    private TextView fls;
    private TbImageView flt;
    private TextView flu;
    private TextView flv;
    private DrawableTextView flw;
    private View flx;
    private boolean flz;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.anz = false;
        this.flz = false;
        this.liveType = 2;
        this.eqb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.VP.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.fly);
                        b.this.flz = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.aM(z);
                                b.this.aN(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.yy().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.yy().a(updateAttentionMessage.getData(), b.this.mPageContext, false)) {
                                b.this.anz = !b.this.anz;
                                b.this.aN(b.this.anz);
                                b.this.aM(b.this.anz);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.anz = b.this.anz ? false : true;
                            b.this.aN(b.this.anz);
                            b.this.aM(b.this.anz);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.flk = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.flk.setIsRound(true);
        this.flk.setAutoChangeStyle(false);
        this.bXt = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fll = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.flm = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.fln = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.flo = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.flp = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.flq = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.flr = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.flt = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.fls = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.flu = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.flu.getPaint().setFlags(8);
        this.flu.getPaint().setAntiAlias(true);
        this.flv = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.flw = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.flx = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.flq.setOnClickListener(this);
        this.flu.setOnClickListener(this);
        this.flv.setOnClickListener(this);
        this.flw.setOnClickListener(this);
        this.fln.setOnClickListener(this);
        this.flo.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.eqb);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.u.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eYw = (com.baidu.live.u.a) runTask.getData();
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
        if (aVar != null && aVar.fkV != null) {
            this.fkV = aVar.fkV;
            this.VP = aVar.fkV.VP;
            this.VR = aVar.fkV.VR;
            this.VQ = aVar.fkV.VQ;
            if (this.fkV.mLiveInfo != null) {
                this.liveType = this.fkV.mLiveInfo.live_type;
            }
            if (this.VP != null && this.VR != null && this.VQ != null) {
                long j = this.VP.userId;
                if (this.VP.portrait != null && !this.VP.portrait.equals("")) {
                    this.flk.startLoad(this.VP.portrait, 12, false);
                }
                this.bXt.setText(this.VP.userName);
                if (j == 0) {
                    this.fll.setVisibility(8);
                } else {
                    this.fll.setVisibility(0);
                    this.fll.setImageResource(this.VP.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.flm.setupLevelIcon(this.VP.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.VP.greatAnchorIcon)) {
                        this.flt.startLoad(this.VP.greatAnchorIcon, 10, false);
                    } else {
                        this.flt.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.VP.greatAnchorDescRole) && !StringUtils.isNull(this.VP.greatAnchorDescGrade)) {
                        this.fls.setText(this.VP.greatAnchorDescGrade + this.VP.greatAnchorDescRole);
                    } else {
                        this.flr.setVisibility(8);
                    }
                } else {
                    this.flr.setVisibility(8);
                }
                this.fln.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.VP.followCount)));
                if (!this.flz || this.mUserId != this.VP.userId) {
                    this.flz = false;
                    this.anA = this.VP.fansCount;
                    this.anz = this.VR.follow_status != 0;
                    this.mUserId = this.VP.userId;
                }
                this.flo.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.anA)));
                aM(this.anz);
                if (!StringUtils.isNull(this.VP.location)) {
                    str = this.VP.location;
                } else {
                    str = this.VQ.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.flp.setVisibility(0);
                    this.flx.setVisibility(0);
                    this.flp.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.flp.setVisibility(4);
                this.flx.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.flq) {
            bpr();
        } else if (view == this.flu) {
            if (this.eYw != null && this.fkV != null && this.fkV.Wc != null) {
                this.eYw.a(this.fkV.Wc, "from_host_tab_panel");
            }
        } else if (view == this.flv) {
            bpt();
        } else if (view == this.flw) {
            bps();
        } else if (view == this.fln) {
            qw(2);
        } else if (view == this.flo) {
            qw(1);
        }
    }

    private void qw(int i) {
        if (this.fkV != null && this.fkV.mLiveInfo != null && this.fkV.VP != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.fkV.VP;
            String valueOf = String.valueOf(this.fkV.mLiveInfo.group_id);
            l lVar = new l();
            lVar.groupId = valueOf;
            lVar.Wm = false;
            lVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            lVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            lVar.userName = alaLiveUserInfoData.userName;
            lVar.tabType = i;
            com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
            cVar.arm = lVar;
            cVar.arn = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void bpr() {
    }

    private void bps() {
        if (this.VP != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.flz = true;
            this.anz = this.anz ? false : true;
            if (this.anz) {
                TiebaInitialize.log("c12558");
            }
            aM(this.anz);
            aN(this.anz);
            com.baidu.live.view.a.yy().a(String.valueOf(this.VP.userId), new com.baidu.live.data.b(this.VP.portrait, String.valueOf(this.VP.userId), "1", this.anz, fly));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(boolean z) {
        this.anz = z;
        if (z) {
            this.flw.setEnabled(false);
            this.flw.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.flw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.flw.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.flw.setGravity(17);
            return;
        }
        this.flw.setEnabled(true);
        this.flw.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.flw.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.flw.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.flw.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.flw.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(boolean z) {
        if (z) {
            TextView textView = this.flo;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.anA + 1;
            this.anA = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.flo;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.anA - 1;
        this.anA = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bpt() {
        if (this.VP != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.VP.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.VP.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.VP)));
                com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
                cVar.arn = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private u b(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        u uVar = new u();
        uVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        uVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        uVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        uVar.verify_type = alaLiveUserInfoData.verifyType;
        uVar.user_name = alaLiveUserInfoData.userName;
        uVar.user_nickname = alaLiveUserInfoData.userName;
        uVar.pass_name = alaLiveUserInfoData.passName;
        uVar.sex = alaLiveUserInfoData.sex;
        uVar.description = alaLiveUserInfoData.description;
        uVar.portrait = alaLiveUserInfoData.portrait;
        uVar.level_id = alaLiveUserInfoData.levelId;
        uVar.level_exp = alaLiveUserInfoData.levelExp;
        uVar.is_login = alaLiveUserInfoData.isLogin;
        uVar.fans_count = alaLiveUserInfoData.fansCount;
        uVar.follow_count = alaLiveUserInfoData.followCount;
        uVar.user_status = alaLiveUserInfoData.userStatus;
        uVar.live_status = alaLiveUserInfoData.liveStatus;
        uVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        uVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        uVar.record_count = alaLiveUserInfoData.recordCount;
        uVar.location = alaLiveUserInfoData.location;
        uVar.lng = alaLiveUserInfoData.lng;
        uVar.lat = alaLiveUserInfoData.lat;
        uVar.is_block = alaLiveUserInfoData.isBlock;
        uVar.stream_id = alaLiveUserInfoData.streamID;
        uVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        uVar.verify_status = alaLiveUserInfoData.verifyStatus;
        uVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        uVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        uVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        uVar.petal_num = alaLiveUserInfoData.petalNum;
        return uVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.eqb);
        if (this.eYw != null) {
            this.eYw.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.flk != null) {
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b fkS;

        public a(b bVar) {
            super(bVar.getView());
            this.fkS = bVar;
        }
    }
}
