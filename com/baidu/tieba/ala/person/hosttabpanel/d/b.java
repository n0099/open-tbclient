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
import com.baidu.live.data.l;
import com.baidu.live.data.n;
import com.baidu.live.data.w;
import com.baidu.live.r.a;
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
    private static final BdUniqueId foH = BdUniqueId.gen();
    private AlaLiveUserInfoData Wf;
    private AlaLocationData Wg;
    private AlaRelationData Wh;
    private boolean aom;
    private int aon;
    private TextView bXF;
    private HeadImageView eXs;
    private CustomMessageListener ern;
    private com.baidu.live.w.a faY;
    private LinearLayout foA;
    private TextView foB;
    private TbImageView foC;
    private TextView foD;
    private TextView foE;
    private DrawableTextView foF;
    private View foG;
    private boolean foI;
    private l fof;
    private ImageView fou;
    private ALALevelView fov;
    private TextView fow;
    private TextView fox;
    private TextView foy;
    private LinearLayout foz;
    private int liveType;
    private TbPageContext mPageContext;
    private View mRootView;
    private long mUserId;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUserId = -1L;
        this.aom = false;
        this.foI = false;
        this.liveType = 2;
        this.ern = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(b.this.Wf.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                        boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(b.foH);
                        b.this.foI = true;
                        if (updateAttentionMessage.getData().isSucc) {
                            boolean z = updateAttentionMessage.getData().isAttention;
                            if (!equals) {
                                b.this.aO(z);
                                b.this.aP(z);
                                return;
                            } else if (z) {
                                com.baidu.live.view.a.yR().a(b.this.mPageContext, true);
                                return;
                            } else {
                                b.this.mPageContext.showToast(b.this.mPageContext.getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        boolean z2 = updateAttentionMessage.getData().isAttention;
                        if (equals) {
                            if (com.baidu.live.view.a.yR().a(updateAttentionMessage.getData(), b.this.mPageContext, false)) {
                                b.this.aom = !b.this.aom;
                                b.this.aP(b.this.aom);
                                b.this.aO(b.this.aom);
                                return;
                            }
                            if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                                b.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                            b.this.aom = b.this.aom ? false : true;
                            b.this.aP(b.this.aom);
                            b.this.aO(b.this.aom);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.eXs = (HeadImageView) this.mRootView.findViewById(a.g.user_icon);
        this.eXs.setIsRound(true);
        this.eXs.setAutoChangeStyle(false);
        this.bXF = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fou = (ImageView) this.mRootView.findViewById(a.g.user_sex);
        this.fov = (ALALevelView) this.mRootView.findViewById(a.g.user_grade);
        this.fow = (TextView) this.mRootView.findViewById(a.g.user_attention_count);
        this.fox = (TextView) this.mRootView.findViewById(a.g.user_fans_count);
        this.foy = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.foz = (LinearLayout) this.mRootView.findViewById(a.g.profile_container);
        this.foA = (LinearLayout) this.mRootView.findViewById(a.g.combat_authen_container);
        this.foC = (TbImageView) this.mRootView.findViewById(a.g.anthen_icon);
        this.foB = (TextView) this.mRootView.findViewById(a.g.combat_authen);
        this.foD = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_go_to_authen);
        this.foD.getPaint().setFlags(8);
        this.foD.getPaint().setAntiAlias(true);
        this.foE = (TextView) this.mRootView.findViewById(a.g.ala_host_tab_reply_user);
        this.foF = (DrawableTextView) this.mRootView.findViewById(a.g.ala_host_tab_attention_btn);
        this.foG = this.mRootView.findViewById(a.g.divider_behind_fans_count);
        this.foz.setOnClickListener(this);
        this.foD.setOnClickListener(this);
        this.foE.setOnClickListener(this);
        this.foF.setOnClickListener(this);
        this.fow.setOnClickListener(this);
        this.fox.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.ern);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.w.a.class, this.mPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.faY = (com.baidu.live.w.a) runTask.getData();
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
        if (aVar != null && aVar.fof != null) {
            this.fof = aVar.fof;
            this.Wf = aVar.fof.Wf;
            this.Wh = aVar.fof.Wh;
            this.Wg = aVar.fof.Wg;
            if (this.fof.mLiveInfo != null) {
                this.liveType = this.fof.mLiveInfo.live_type;
            }
            if (this.Wf != null && this.Wh != null && this.Wg != null) {
                long j = this.Wf.userId;
                if (this.Wf.portrait != null && !this.Wf.portrait.equals("")) {
                    this.eXs.startLoad(this.Wf.portrait, 12, false);
                }
                this.bXF.setText(this.Wf.userName);
                if (j == 0) {
                    this.fou.setVisibility(8);
                } else {
                    this.fou.setVisibility(0);
                    this.fou.setImageResource(this.Wf.sex == 1 ? a.f.sdk_icon_mine_boy : a.f.sdk_icon_mine_girl);
                }
                this.fov.setupLevelIcon(this.Wf.levelId);
                if (this.liveType == 2) {
                    if (!StringUtils.isNull(this.Wf.greatAnchorIcon)) {
                        this.foC.startLoad(this.Wf.greatAnchorIcon, 10, false);
                    } else {
                        this.foC.setVisibility(8);
                    }
                    if (!StringUtils.isNull(this.Wf.greatAnchorDescRole) && !StringUtils.isNull(this.Wf.greatAnchorDescGrade)) {
                        this.foB.setText(this.Wf.greatAnchorDescGrade + this.Wf.greatAnchorDescRole);
                    } else {
                        this.foA.setVisibility(8);
                    }
                } else {
                    this.foA.setVisibility(8);
                }
                this.fow.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_attention_count, StringHelper.numberUniformFormat(this.Wf.followCount)));
                if (!this.foI || this.mUserId != this.Wf.userId) {
                    this.foI = false;
                    this.aon = this.Wf.fansCount;
                    this.aom = this.Wh.follow_status != 0;
                    this.mUserId = this.Wf.userId;
                }
                this.fox.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_fans_count, StringHelper.numberUniformFormat(this.aon)));
                aO(this.aom);
                if (!StringUtils.isNull(this.Wf.location)) {
                    str = this.Wf.location;
                } else {
                    str = this.Wg.location;
                }
                if (this.liveType != 2 && !TextUtils.isEmpty(str)) {
                    this.foy.setVisibility(0);
                    this.foG.setVisibility(0);
                    this.foy.setText(this.mPageContext.getResources().getString(a.i.ala_host_tab_location, str));
                    return;
                }
                this.foy.setVisibility(4);
                this.foG.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.foz) {
            bqs();
        } else if (view == this.foD) {
            if (this.faY != null && this.fof != null && this.fof.Wt != null) {
                this.faY.a(this.fof.Wt, "from_host_tab_panel");
            }
        } else if (view == this.foE) {
            bqu();
        } else if (view == this.foF) {
            bqt();
        } else if (view == this.fow) {
            qB(2);
        } else if (view == this.fox) {
            qB(1);
        }
    }

    private void qB(int i) {
        if (this.fof != null && this.fof.mLiveInfo != null && this.fof.Wf != null) {
            AlaLiveUserInfoData alaLiveUserInfoData = this.fof.Wf;
            String valueOf = String.valueOf(this.fof.mLiveInfo.group_id);
            n nVar = new n();
            nVar.groupId = valueOf;
            nVar.WF = false;
            nVar.liveId = String.valueOf(alaLiveUserInfoData.liveId);
            nVar.userId = String.valueOf(alaLiveUserInfoData.userId);
            nVar.userName = alaLiveUserInfoData.userName;
            nVar.tabType = i;
            com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
            cVar.arY = nVar;
            cVar.arZ = (short) 4;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
            TiebaInitialize.log(new StatisticItem("c12559"));
        }
    }

    private void bqs() {
    }

    private void bqt() {
        if (this.Wf != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.foI = true;
            this.aom = this.aom ? false : true;
            if (this.aom) {
                TiebaInitialize.log("c12558");
            }
            aO(this.aom);
            aP(this.aom);
            com.baidu.live.view.a.yR().a(String.valueOf(this.Wf.userId), new com.baidu.live.data.b(this.Wf.portrait, String.valueOf(this.Wf.userId), "1", this.aom, foH));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(boolean z) {
        this.aom = z;
        if (z) {
            this.foF.setEnabled(false);
            this.foF.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
            this.foF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.foF.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10109));
            this.foF.setGravity(17);
            return;
        }
        this.foF.setEnabled(true);
        this.foF.setText(this.mPageContext.getString(a.i.ala_person_attention));
        this.foF.setCompoundDrawablesWithIntrinsicBounds(this.mPageContext.getResources().getDrawable(a.f.sdk_icon_add_live_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.foF.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.foF.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_other_b));
        this.foF.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(boolean z) {
        if (z) {
            TextView textView = this.fox;
            Resources resources = this.mPageContext.getResources();
            int i = a.i.ala_host_tab_fans_count;
            int i2 = this.aon + 1;
            this.aon = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.fox;
        Resources resources2 = this.mPageContext.getResources();
        int i3 = a.i.ala_host_tab_fans_count;
        int i4 = this.aon - 1;
        this.aon = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    private void bqu() {
        if (this.Wf != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            } else if (this.Wf.userId == 0) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_tourist);
            } else if (String.valueOf(this.Wf.userId).equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_cannot_reply_self);
            } else {
                TiebaInitialize.log("c12556");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, b(this.Wf)));
                com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
                cVar.arZ = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
            }
        }
    }

    private w b(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            return null;
        }
        w wVar = new w();
        wVar.user_id = String.valueOf(alaLiveUserInfoData.userId);
        wVar.verify_info_status = alaLiveUserInfoData.verifyInfoStatus;
        wVar.verify_video_status = alaLiveUserInfoData.verifyVideoStatus;
        wVar.verify_type = alaLiveUserInfoData.verifyType;
        wVar.user_name = alaLiveUserInfoData.userName;
        wVar.user_nickname = alaLiveUserInfoData.userName;
        wVar.pass_name = alaLiveUserInfoData.passName;
        wVar.sex = alaLiveUserInfoData.sex;
        wVar.description = alaLiveUserInfoData.description;
        wVar.portrait = alaLiveUserInfoData.portrait;
        wVar.level_id = alaLiveUserInfoData.levelId;
        wVar.level_exp = alaLiveUserInfoData.levelExp;
        wVar.is_login = alaLiveUserInfoData.isLogin;
        wVar.fans_count = alaLiveUserInfoData.fansCount;
        wVar.follow_count = alaLiveUserInfoData.followCount;
        wVar.user_status = alaLiveUserInfoData.userStatus;
        wVar.live_status = alaLiveUserInfoData.liveStatus;
        wVar.live_id = String.valueOf(alaLiveUserInfoData.liveId);
        wVar.create_time = String.valueOf(alaLiveUserInfoData.createTime);
        wVar.record_count = alaLiveUserInfoData.recordCount;
        wVar.location = alaLiveUserInfoData.location;
        wVar.lng = alaLiveUserInfoData.lng;
        wVar.lat = alaLiveUserInfoData.lat;
        wVar.is_block = alaLiveUserInfoData.isBlock;
        wVar.stream_id = alaLiveUserInfoData.streamID;
        wVar.has_tieba_username = alaLiveUserInfoData.hasTiebaName;
        wVar.verify_status = alaLiveUserInfoData.verifyStatus;
        wVar.great_anchor_icon = alaLiveUserInfoData.greatAnchorIcon;
        wVar.great_anchor_desc_grade = alaLiveUserInfoData.greatAnchorDescGrade;
        wVar.great_anchor_desc_role = alaLiveUserInfoData.greatAnchorDescRole;
        wVar.petal_num = alaLiveUserInfoData.petalNum;
        return wVar;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.ern);
        if (this.faY != null) {
            this.faY.onDestroy();
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.eXs != null) {
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public b foc;

        public a(b bVar) {
            super(bVar.getView());
            this.foc = bVar;
        }
    }
}
