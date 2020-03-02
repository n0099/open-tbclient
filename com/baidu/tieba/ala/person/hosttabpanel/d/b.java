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
    private static final BdUniqueId frm = BdUniqueId.gen();
    private AlaLiveUserInfoData XQ;
    private AlaLocationData XR;
    private AlaRelationData XS;
    private boolean arE;
    private int arF;
    private TextView cbK;
    private CustomMessageListener evz;
    private HeadImageView fbc;
    private com.baidu.live.z.a fek;
    private m fqK;
    private ImageView fqZ;
    private ALALevelView fra;
    private TextView frb;
    private TextView frc;
    private TextView frd;
    private LinearLayout fre;
    private LinearLayout frf;
    private TextView frg;
    private TbImageView frh;
    private TextView fri;
    private TextView frj;
    private DrawableTextView frk;
    private View frl;
    private boolean frn;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.arE = false;
        this.frn = false;
        this.liveType = 2;
        this.evz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.XQ.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.frm);
                        b.this.frn = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.aR(z);
                                b.this.aS(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.Bj().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.Bj().a(updateAttentionMessage.getData(), b.this.mPageContext, false)) {
                                b.this.arE = !b.this.arE;
                                b.this.aS(b.this.arE);
                                b.this.aR(b.this.arE);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.arE = b.this.arE ? false : true;
                            b.this.aS(b.this.arE);
                            b.this.aR(b.this.arE);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.fbc = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.fbc.setIsRound(true);
        this.fbc.setAutoChangeStyle(false);
        this.cbK = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fqZ = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.fra = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.frb = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.frc = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.frd = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.fre = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.frf = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.frh = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.frg = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.fri = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.fri.getPaint().setFlags(8);
        this.fri.getPaint().setAntiAlias(true);
        this.frj = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.frk = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.frl = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.fre.setOnClickListener(this);
        this.fri.setOnClickListener(this);
        this.frj.setOnClickListener(this);
        this.frk.setOnClickListener(this);
        this.frb.setOnClickListener(this);
        this.frc.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.evz);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.z.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fek = (com.baidu.live.z.a) runTask.getData();
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
        if (aVar != null && aVar.fqK != null) {
            this.fqK = aVar.fqK;
            this.XQ = aVar.fqK.XQ;
            this.XS = aVar.fqK.XS;
            this.XR = aVar.fqK.XR;
            if (this.fqK.mLiveInfo != null) {
                this.liveType = this.fqK.mLiveInfo.live_type;
            }
            if (this.XQ != null && this.XS != null && this.XR != null) {
                long j = this.XQ.userId;
                if (this.XQ.portrait != null && !this.XQ.portrait.equals("")) {
                    this.fbc.startLoad(this.XQ.portrait, 12, false);
                }
                this.cbK.setText(this.XQ.userName);
                if (j == 0) {
                    this.fqZ.setVisibility(8);
                } else {
                    this.fqZ.setVisibility(0);
                    this.fqZ.setImageResource(this.XQ.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.fra.setupLevelIcon(this.XQ.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.XQ.greatAnchorIcon)) {
                        this.frh.startLoad(this.XQ.greatAnchorIcon, 10, false);
                    } else {
                        this.frh.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.XQ.greatAnchorDescRole) && !StringUtils.isNull(this.XQ.greatAnchorDescGrade)) {
                        this.frg.setText(this.XQ.greatAnchorDescGrade + this.XQ.greatAnchorDescRole);
                    } else {
                        this.frf.setVisibility(8);
                    }
                } else {
                    this.frf.setVisibility(8);
                }
                this.frb.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.XQ.followCount)));
                if (!this.frn || this.mUserId != this.XQ.userId) {
                    this.frn = false;
                    this.arF = this.XQ.fansCount;
                    this.arE = this.XS.follow_status != 0;
                    this.mUserId = this.XQ.userId;
                }
                this.frc.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.arF)));
                aR(this.arE);
                if (!StringUtils.isNull(this.XQ.location)) {
                    str = this.XQ.location;
                } else {
                    str = this.XR.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.frd.setVisibility(0);
                    this.frl.setVisibility(0);
                    this.frd.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.frd.setVisibility(4);
                this.frl.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fre) {
            brY();
        } else if (view == this.fri) {
            if (this.fek != null && this.fqK != null && this.fqK.Ye != null) {
                this.fek.a(this.fqK.Ye, "from_host_tab_panel");
            }
        } else if (view == this.frj) {
            bsa();
        } else if (view == this.frk) {
            brZ();
        } else if (view == this.frb) {
            qI(2);
        } else if (view == this.frc) {
            qI(1);
        }
    }

    private void qI(int i) {
        if (this.fqK != null && this.fqK.mLiveInfo != null && this.fqK.XQ != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.fqK.XQ;
            String valueOf = String.valueOf(this.fqK.mLiveInfo.group_id);
            o oVar = new o();
            oVar.groupId = valueOf;
            oVar.Yr = false;
            oVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            oVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            oVar.userName = alaLiveUserInfoData.userName;
            oVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.avZ = oVar;
            cVar.awa = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void brY() {
    }

    private void brZ() {
        if (this.XQ != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.frn = true;
            this.arE = this.arE ? false : true;
            if (this.arE) {
                TiebaInitialize.log("c12558");
            }
            aR(this.arE);
            aS(this.arE);
            com.baidu.live.view.a.Bj().a(String.valueOf(this.XQ.userId), new com.baidu.live.data.b(this.XQ.portrait, String.valueOf(this.XQ.userId), "1", this.arE, frm));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(boolean z) {
        this.arE = z;
        if (z) {
            this.frk.setEnabled(false);
            this.frk.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.frk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.frk.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.frk.setGravity(17);
            return;
        }
        this.frk.setEnabled(true);
        this.frk.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.frk.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.frk.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.frk.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.frk.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(boolean z) {
        if (z) {
            TextView textView = this.frc;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.arF + 1;
            this.arF = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.frc;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.arF - 1;
        this.arF = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bsa() {
        if (this.XQ != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.XQ.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.XQ.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.XQ)));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.awa = (short) 1;
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
        MessageManager.getInstance().unRegisterListener(this.evz);
        if (this.fek != null) {
            this.fek.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b fqH;

        public a(b bVar) {
            super(bVar.getView());
            this.fqH = bVar;
        }
    }
}
