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
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/* loaded from: classes7.dex */
public class g {
    private long fvC;
    private String fvE;
    private boolean fvF;
    private AlaLastLiveroomInfo fxt;
    private TextView gRO;
    private TextView haU;
    private TextView haV;
    private HeadImageView haW;
    private LottieAnimationView haX;
    private TextView haY;
    private com.baidu.tieba.ala.data.h haZ;
    private Context mContext;
    private View mRootView;

    public g(Context context, View view, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.mRootView = view;
        this.fvE = str;
        this.fvC = j;
        this.fvF = z;
        this.fxt = alaLastLiveroomInfo;
        this.gRO = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
        this.haV = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
        this.haU = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_rank_info);
        this.haW = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_header);
        this.haW.setIsRound(true);
        this.haW.setAutoChangeStyle(false);
        this.haY = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_header_pendent);
        this.haX = (LottieAnimationView) this.mRootView.findViewById(a.g.rank_live_anim);
    }

    public void a(com.baidu.tieba.ala.data.h hVar, final int i) {
        if (hVar != null) {
            this.haZ = hVar;
            this.gRO.setText(this.haZ.getName_show());
            this.haW.startLoad(this.haZ.avatar, 12, false);
            if (this.haZ.ebZ == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.haX.getLayoutParams();
                if (this.haZ.rank == 1 && TextUtils.equals("charm_day", this.fvE)) {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 19.0f), BdUtilHelper.dip2px(this.mContext, 37.0f), BdUtilHelper.dip2px(this.mContext, 19.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    this.haX.setAnimation("anchor_living.json");
                } else {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 0.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    this.haX.setAnimation("rank_list_living.json");
                }
                this.haX.setVisibility(0);
                this.haX.loop(true);
                this.haX.playAnimation();
            } else {
                this.haX.setVisibility(8);
            }
            int i2 = this.haZ.rank;
            if (i2 == 1) {
                this.haV.setText("");
                this.haV.setBackgroundResource(a.f.sdk_icon_live_list_first);
            } else if (i2 == 2) {
                this.haV.setText("");
                this.haV.setBackgroundResource(a.f.sdk_icon_live_list_second);
            } else if (i2 == 3) {
                this.haV.setText("");
                this.haV.setBackgroundResource(a.f.sdk_icon_live_list_third);
            } else {
                this.haV.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                if (i2 >= 100) {
                    this.haV.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                } else {
                    this.haV.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize32));
                }
                this.haV.setText(String.valueOf(i2));
                this.haV.setBackgroundResource(a.d.sdk_transparent);
            }
            if (i2 == 1 && TextUtils.equals("charm_day", this.fvE)) {
                this.haY.setVisibility(0);
            } else {
                this.haY.setVisibility(8);
            }
            if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fvE)) {
                double d = JavaTypesHelper.toDouble(this.haZ.point, 0.0d);
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                this.haU.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), decimalFormat.format(d)));
            } else {
                long j = JavaTypesHelper.toLong(this.haZ.point, 0L);
                if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fvE)) {
                    this.haU.setText(String.format(this.mContext.getString(a.i.ala_rank_list_flower_point), StringHelper.numFormatOver10000(j)));
                } else if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fvE)) {
                    this.haU.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_point), i.formatTosepara(j)));
                } else if ("hot".equals(this.fvE)) {
                    this.haU.setText(String.format(this.mContext.getString(a.i.ala_rank_list_hot_point), i.formatTosepara(j)));
                } else if ("pk".equals(this.fvE)) {
                    this.haU.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), i.formatTosepara(j)));
                } else if ("guard".equals(this.fvE)) {
                    this.haU.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), i.formatTosepara(j)));
                } else if ("charm_day".equals(this.fvE) || "hour".equals(this.fvE)) {
                    this.haU.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(j)));
                }
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (g.this.haZ == null || g.this.haZ.ebZ != 1 || g.this.haZ.live_id <= 0 || g.this.haZ.live_id == g.this.fvC || g.this.fvF) {
                            if (g.this.haZ != null && (g.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) g.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == g.this.haZ.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(g.this.mContext, g.this.haZ.user_id + "", g.this.haZ.user_name, g.this.haZ.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, g.this.haZ.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(g.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(g.this.haZ.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(g.this.fxt);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            } else {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.g.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (g.this.haZ == null || g.this.haZ.ebZ != 1 || g.this.haZ.live_id <= 0 || g.this.haZ.live_id == g.this.fvC || g.this.fvF || !com.baidu.live.w.a.Nk().beH.aGM) {
                            if (g.this.haZ != null && (g.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) g.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == g.this.haZ.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(g.this.mContext, g.this.haZ.user_id + "", g.this.haZ.user_name, g.this.haZ.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, g.this.haZ.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(g.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(g.this.haZ.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            }
        }
    }
}
