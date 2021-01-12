package com.baidu.tieba.ala.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.data.HourRankItemData;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/* loaded from: classes10.dex */
public class h {
    private long gmS;
    private String gmU;
    private boolean gmV;
    private AlaLastLiveroomInfo goI;
    private TextView hTx;
    private TextView ieE;
    private TextView ieF;
    private HeadImageView ieG;
    private LottieAnimationView ieH;
    private TextView ieI;
    private com.baidu.tieba.ala.data.h ieJ;
    private Context mContext;
    private View mRootView;

    public h(Context context, View view, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.mRootView = view;
        this.gmU = str;
        this.gmS = j;
        this.gmV = z;
        this.goI = alaLastLiveroomInfo;
        this.hTx = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.ieF = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.ieE = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.ieG = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.ieG.setIsRound(true);
        this.ieG.setAutoChangeStyle(false);
        this.ieI = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_header_pendent);
        this.ieH = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
    }

    public void a(com.baidu.tieba.ala.data.h hVar, final int i) {
        if (hVar != null) {
            this.ieJ = hVar;
            this.hTx.setText(this.ieJ.getName_show());
            this.ieG.startLoad(this.ieJ.avatar, 12, false);
            if (this.ieJ.ePl == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ieH.getLayoutParams();
                if (this.ieJ.rank == 1 && TextUtils.equals("charm_day", this.gmU)) {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 19.0f), BdUtilHelper.dip2px(this.mContext, 37.0f), BdUtilHelper.dip2px(this.mContext, 19.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    this.ieH.setAnimation("anchor_living.json");
                } else {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 0.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    this.ieH.setAnimation("rank_list_living.json");
                }
                this.ieH.setVisibility(0);
                this.ieH.loop(true);
                this.ieH.playAnimation();
            } else {
                this.ieH.setVisibility(8);
            }
            int i2 = this.ieJ.rank;
            if (i2 == 1) {
                this.ieF.setText("");
                this.ieF.setBackgroundResource(a.e.sdk_icon_live_list_first);
            } else if (i2 == 2) {
                this.ieF.setText("");
                this.ieF.setBackgroundResource(a.e.sdk_icon_live_list_second);
            } else if (i2 == 3) {
                this.ieF.setText("");
                this.ieF.setBackgroundResource(a.e.sdk_icon_live_list_third);
            } else {
                this.ieF.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                if (i2 >= 100) {
                    this.ieF.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                } else {
                    this.ieF.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize32));
                }
                this.ieF.setText(String.valueOf(i2));
                this.ieF.setBackgroundResource(a.c.sdk_transparent);
            }
            if (i2 == 1 && TextUtils.equals("charm_day", this.gmU)) {
                this.ieI.setVisibility(0);
            } else {
                this.ieI.setVisibility(8);
            }
            if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.gmU)) {
                double d = JavaTypesHelper.toDouble(this.ieJ.gPU, 0.0d);
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                this.ieE.setText(String.format(this.mContext.getString(a.h.ala_rank_list_game_point), decimalFormat.format(d)));
            } else {
                long j = JavaTypesHelper.toLong(this.ieJ.gPU, 0L);
                if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.gmU)) {
                    this.ieE.setText(String.format(this.mContext.getString(a.h.ala_rank_list_flower_point), StringHelper.numFormatOver10000(j)));
                } else if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.gmU)) {
                    this.ieE.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("hot".equals(this.gmU)) {
                    this.ieE.setText(String.format(this.mContext.getString(a.h.ala_rank_list_hot_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("pk".equals(this.gmU)) {
                    this.ieE.setText(String.format(this.mContext.getString(a.h.ala_rank_list_game_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("guard".equals(this.gmU)) {
                    this.ieE.setText(String.format(this.mContext.getString(a.h.ala_rank_list_game_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("charm_day".equals(this.gmU) || "hour".equals(this.gmU)) {
                    this.ieE.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(j)));
                }
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (h.this.ieJ == null || h.this.ieJ.ePl != 1 || h.this.ieJ.live_id <= 0 || h.this.ieJ.live_id == h.this.gmS || h.this.gmV) {
                            if (h.this.ieJ != null && (h.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) h.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == h.this.ieJ.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(h.this.mContext, h.this.ieJ.user_id + "", h.this.ieJ.user_name, h.this.ieJ.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, h.this.ieJ.getName_show())));
                                return;
                            }
                            return;
                        }
                        com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(h.this.ieJ.live_id)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(h.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(h.this.ieJ.live_id, "", "live_sdk");
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(h.this.goI);
                        com.baidu.live.liveroom.a.KT().a(alaLiveRoomActivityConfig);
                    }
                });
            } else {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (h.this.ieJ == null || h.this.ieJ.ePl != 1 || h.this.ieJ.live_id <= 0 || h.this.ieJ.live_id == h.this.gmS || h.this.gmV || !com.baidu.live.af.a.OJ().bru.aJM) {
                            if (h.this.ieJ != null && (h.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) h.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == h.this.ieJ.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(h.this.mContext, h.this.ieJ.user_id + "", h.this.ieJ.user_name, h.this.ieJ.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, h.this.ieJ.getName_show())));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(h.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(h.this.ieJ.live_id, "", "live_sdk");
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(h.this.goI);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            }
        }
    }
}
