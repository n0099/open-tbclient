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
import com.baidu.tieba.ala.data.HourRankItemData;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/* loaded from: classes4.dex */
public class h {
    private long fZh;
    private String fZj;
    private boolean fZk;
    private AlaLastLiveroomInfo gaY;
    private TextView hCp;
    private TextView hMi;
    private TextView hMj;
    private HeadImageView hMk;
    private LottieAnimationView hMl;
    private TextView hMm;
    private com.baidu.tieba.ala.data.h hMn;
    private Context mContext;
    private View mRootView;

    public h(Context context, View view, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.mRootView = view;
        this.fZj = str;
        this.fZh = j;
        this.fZk = z;
        this.gaY = alaLastLiveroomInfo;
        this.hCp = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hMj = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.hMi = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.hMk = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.hMk.setIsRound(true);
        this.hMk.setAutoChangeStyle(false);
        this.hMm = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_header_pendent);
        this.hMl = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
    }

    public void a(com.baidu.tieba.ala.data.h hVar, final int i) {
        if (hVar != null) {
            this.hMn = hVar;
            this.hCp.setText(this.hMn.getName_show());
            this.hMk.startLoad(this.hMn.avatar, 12, false);
            if (this.hMn.eEI == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hMl.getLayoutParams();
                if (this.hMn.rank == 1 && TextUtils.equals("charm_day", this.fZj)) {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 19.0f), BdUtilHelper.dip2px(this.mContext, 37.0f), BdUtilHelper.dip2px(this.mContext, 19.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    this.hMl.setAnimation("anchor_living.json");
                } else {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 0.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    this.hMl.setAnimation("rank_list_living.json");
                }
                this.hMl.setVisibility(0);
                this.hMl.loop(true);
                this.hMl.playAnimation();
            } else {
                this.hMl.setVisibility(8);
            }
            int i2 = this.hMn.rank;
            if (i2 == 1) {
                this.hMj.setText("");
                this.hMj.setBackgroundResource(a.e.sdk_icon_live_list_first);
            } else if (i2 == 2) {
                this.hMj.setText("");
                this.hMj.setBackgroundResource(a.e.sdk_icon_live_list_second);
            } else if (i2 == 3) {
                this.hMj.setText("");
                this.hMj.setBackgroundResource(a.e.sdk_icon_live_list_third);
            } else {
                this.hMj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                if (i2 >= 100) {
                    this.hMj.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                } else {
                    this.hMj.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize32));
                }
                this.hMj.setText(String.valueOf(i2));
                this.hMj.setBackgroundResource(a.c.sdk_transparent);
            }
            if (i2 == 1 && TextUtils.equals("charm_day", this.fZj)) {
                this.hMm.setVisibility(0);
            } else {
                this.hMm.setVisibility(8);
            }
            if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fZj)) {
                double d = JavaTypesHelper.toDouble(this.hMn.point, 0.0d);
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                this.hMi.setText(String.format(this.mContext.getString(a.h.ala_rank_list_game_point), decimalFormat.format(d)));
            } else {
                long j = JavaTypesHelper.toLong(this.hMn.point, 0L);
                if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fZj)) {
                    this.hMi.setText(String.format(this.mContext.getString(a.h.ala_rank_list_flower_point), StringHelper.numFormatOver10000(j)));
                } else if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fZj)) {
                    this.hMi.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("hot".equals(this.fZj)) {
                    this.hMi.setText(String.format(this.mContext.getString(a.h.ala_rank_list_hot_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("pk".equals(this.fZj)) {
                    this.hMi.setText(String.format(this.mContext.getString(a.h.ala_rank_list_game_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("guard".equals(this.fZj)) {
                    this.hMi.setText(String.format(this.mContext.getString(a.h.ala_rank_list_game_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("charm_day".equals(this.fZj) || "hour".equals(this.fZj)) {
                    this.hMi.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(j)));
                }
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (h.this.hMn == null || h.this.hMn.eEI != 1 || h.this.hMn.live_id <= 0 || h.this.hMn.live_id == h.this.fZh || h.this.fZk) {
                            if (h.this.hMn != null && (h.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) h.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == h.this.hMn.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(h.this.mContext, h.this.hMn.user_id + "", h.this.hMn.user_name, h.this.hMn.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, h.this.hMn.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(h.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(h.this.hMn.live_id, "", "live_sdk");
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(h.this.gaY);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            } else {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (h.this.hMn == null || h.this.hMn.eEI != 1 || h.this.hMn.live_id <= 0 || h.this.hMn.live_id == h.this.fZh || h.this.fZk || !com.baidu.live.aa.a.PQ().bod.aML) {
                            if (h.this.hMn != null && (h.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) h.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == h.this.hMn.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(h.this.mContext, h.this.hMn.user_id + "", h.this.hMn.user_name, h.this.hMn.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, h.this.hMn.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(h.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(h.this.hMn.live_id, "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            }
        }
    }
}
