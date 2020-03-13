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
    private static final BdUniqueId frA = BdUniqueId.gen();
    private AlaLiveUserInfoData XQ;
    private AlaLocationData XR;
    private AlaRelationData XS;
    private boolean arF;
    private int arG;
    private TextView cbL;
    private CustomMessageListener evM;
    private HeadImageView fbp;
    private com.baidu.live.z.a fex;
    private m fqX;
    private boolean frB;
    private ImageView frm;
    private ALALevelView frn;
    private TextView fro;
    private TextView frp;
    private TextView frq;
    private LinearLayout frr;
    private LinearLayout frt;
    private TextView fru;
    private TbImageView frv;
    private TextView frw;
    private TextView frx;
    private DrawableTextView fry;
    private View frz;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.arF = false;
        this.frB = false;
        this.liveType = 2;
        this.evM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.XQ.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.frA);
                        b.this.frB = true;
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
                                b.this.arF = !b.this.arF;
                                b.this.aS(b.this.arF);
                                b.this.aR(b.this.arF);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.arF = b.this.arF ? false : true;
                            b.this.aS(b.this.arF);
                            b.this.aR(b.this.arF);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.fbp = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.fbp.setIsRound(true);
        this.fbp.setAutoChangeStyle(false);
        this.cbL = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.frm = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.frn = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.fro = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.frp = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.frq = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.frr = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.frt = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.frv = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.fru = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.frw = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.frw.getPaint().setFlags(8);
        this.frw.getPaint().setAntiAlias(true);
        this.frx = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.fry = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.frz = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.frr.setOnClickListener(this);
        this.frw.setOnClickListener(this);
        this.frx.setOnClickListener(this);
        this.fry.setOnClickListener(this);
        this.fro.setOnClickListener(this);
        this.frp.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.evM);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.z.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fex = (com.baidu.live.z.a) runTask.getData();
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
        if (aVar != null && aVar.fqX != null) {
            this.fqX = aVar.fqX;
            this.XQ = aVar.fqX.XQ;
            this.XS = aVar.fqX.XS;
            this.XR = aVar.fqX.XR;
            if (this.fqX.mLiveInfo != null) {
                this.liveType = this.fqX.mLiveInfo.live_type;
            }
            if (this.XQ != null && this.XS != null && this.XR != null) {
                long j = this.XQ.userId;
                if (this.XQ.portrait != null && !this.XQ.portrait.equals("")) {
                    this.fbp.startLoad(this.XQ.portrait, 12, false);
                }
                this.cbL.setText(this.XQ.userName);
                if (j == 0) {
                    this.frm.setVisibility(8);
                } else {
                    this.frm.setVisibility(0);
                    this.frm.setImageResource(this.XQ.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.frn.setupLevelIcon(this.XQ.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.XQ.greatAnchorIcon)) {
                        this.frv.startLoad(this.XQ.greatAnchorIcon, 10, false);
                    } else {
                        this.frv.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.XQ.greatAnchorDescRole) && !StringUtils.isNull(this.XQ.greatAnchorDescGrade)) {
                        this.fru.setText(this.XQ.greatAnchorDescGrade + this.XQ.greatAnchorDescRole);
                    } else {
                        this.frt.setVisibility(8);
                    }
                } else {
                    this.frt.setVisibility(8);
                }
                this.fro.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.XQ.followCount)));
                if (!this.frB || this.mUserId != this.XQ.userId) {
                    this.frB = false;
                    this.arG = this.XQ.fansCount;
                    this.arF = this.XS.follow_status != 0;
                    this.mUserId = this.XQ.userId;
                }
                this.frp.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.arG)));
                aR(this.arF);
                if (!StringUtils.isNull(this.XQ.location)) {
                    str = this.XQ.location;
                } else {
                    str = this.XR.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.frq.setVisibility(0);
                    this.frz.setVisibility(0);
                    this.frq.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.frq.setVisibility(4);
                this.frz.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.frr) {
            brZ();
        } else if (view == this.frw) {
            if (this.fex != null && this.fqX != null && this.fqX.Ye != null) {
                this.fex.a(this.fqX.Ye, "from_host_tab_panel");
            }
        } else if (view == this.frx) {
            bsb();
        } else if (view == this.fry) {
            bsa();
        } else if (view == this.fro) {
            qI(2);
        } else if (view == this.frp) {
            qI(1);
        }
    }

    private void qI(int i) {
        if (this.fqX != null && this.fqX.mLiveInfo != null && this.fqX.XQ != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.fqX.XQ;
            String valueOf = String.valueOf(this.fqX.mLiveInfo.group_id);
            o oVar = new o();
            oVar.groupId = valueOf;
            oVar.Yr = false;
            oVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            oVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            oVar.userName = alaLiveUserInfoData.userName;
            oVar.tabType = i;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.awa = oVar;
            cVar.awb = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void brZ() {
    }

    private void bsa() {
        if (this.XQ != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.frB = true;
            this.arF = this.arF ? false : true;
            if (this.arF) {
                TiebaInitialize.log("c12558");
            }
            aR(this.arF);
            aS(this.arF);
            com.baidu.live.view.a.Bj().a(String.valueOf(this.XQ.userId), new com.baidu.live.data.b(this.XQ.portrait, String.valueOf(this.XQ.userId), "1", this.arF, frA));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(boolean z) {
        this.arF = z;
        if (z) {
            this.fry.setEnabled(false);
            this.fry.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.fry.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fry.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.fry.setGravity(17);
            return;
        }
        this.fry.setEnabled(true);
        this.fry.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.fry.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fry.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.fry.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.fry.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(boolean z) {
        if (z) {
            TextView textView = this.frp;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.arG + 1;
            this.arG = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.frp;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.arG - 1;
        this.arG = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bsb() {
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
                cVar.awb = (short) 1;
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
        MessageManager.getInstance().unRegisterListener(this.evM);
        if (this.fex != null) {
            this.fex.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b fqU;

        public a(b bVar) {
            super(bVar.getView());
            this.fqU = bVar;
        }
    }
}
