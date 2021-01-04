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
/* loaded from: classes11.dex */
public class h {
    private String grB;
    private boolean grC;
    private long grz;
    private AlaLastLiveroomInfo gtp;
    private TextView hYe;
    private TextView ijl;
    private TextView ijm;
    private HeadImageView ijn;
    private LottieAnimationView ijo;
    private TextView ijp;
    private com.baidu.tieba.ala.data.h ijq;
    private Context mContext;
    private View mRootView;

    public h(Context context, View view, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.mRootView = view;
        this.grB = str;
        this.grz = j;
        this.grC = z;
        this.gtp = alaLastLiveroomInfo;
        this.hYe = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.ijm = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.ijl = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.ijn = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.ijn.setIsRound(true);
        this.ijn.setAutoChangeStyle(false);
        this.ijp = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_header_pendent);
        this.ijo = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
    }

    public void a(com.baidu.tieba.ala.data.h hVar, final int i) {
        if (hVar != null) {
            this.ijq = hVar;
            this.hYe.setText(this.ijq.getName_show());
            this.ijn.startLoad(this.ijq.avatar, 12, false);
            if (this.ijq.eTW == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ijo.getLayoutParams();
                if (this.ijq.rank == 1 && TextUtils.equals("charm_day", this.grB)) {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 19.0f), BdUtilHelper.dip2px(this.mContext, 37.0f), BdUtilHelper.dip2px(this.mContext, 19.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    this.ijo.setAnimation("anchor_living.json");
                } else {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 0.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    this.ijo.setAnimation("rank_list_living.json");
                }
                this.ijo.setVisibility(0);
                this.ijo.loop(true);
                this.ijo.playAnimation();
            } else {
                this.ijo.setVisibility(8);
            }
            int i2 = this.ijq.rank;
            if (i2 == 1) {
                this.ijm.setText("");
                this.ijm.setBackgroundResource(a.e.sdk_icon_live_list_first);
            } else if (i2 == 2) {
                this.ijm.setText("");
                this.ijm.setBackgroundResource(a.e.sdk_icon_live_list_second);
            } else if (i2 == 3) {
                this.ijm.setText("");
                this.ijm.setBackgroundResource(a.e.sdk_icon_live_list_third);
            } else {
                this.ijm.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                if (i2 >= 100) {
                    this.ijm.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                } else {
                    this.ijm.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize32));
                }
                this.ijm.setText(String.valueOf(i2));
                this.ijm.setBackgroundResource(a.c.sdk_transparent);
            }
            if (i2 == 1 && TextUtils.equals("charm_day", this.grB)) {
                this.ijp.setVisibility(0);
            } else {
                this.ijp.setVisibility(8);
            }
            if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.grB)) {
                double d = JavaTypesHelper.toDouble(this.ijq.gUA, 0.0d);
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                this.ijl.setText(String.format(this.mContext.getString(a.h.ala_rank_list_game_point), decimalFormat.format(d)));
            } else {
                long j = JavaTypesHelper.toLong(this.ijq.gUA, 0L);
                if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.grB)) {
                    this.ijl.setText(String.format(this.mContext.getString(a.h.ala_rank_list_flower_point), StringHelper.numFormatOver10000(j)));
                } else if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.grB)) {
                    this.ijl.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("hot".equals(this.grB)) {
                    this.ijl.setText(String.format(this.mContext.getString(a.h.ala_rank_list_hot_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("pk".equals(this.grB)) {
                    this.ijl.setText(String.format(this.mContext.getString(a.h.ala_rank_list_game_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("guard".equals(this.grB)) {
                    this.ijl.setText(String.format(this.mContext.getString(a.h.ala_rank_list_game_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("charm_day".equals(this.grB) || "hour".equals(this.grB)) {
                    this.ijl.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(j)));
                }
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (h.this.ijq == null || h.this.ijq.eTW != 1 || h.this.ijq.live_id <= 0 || h.this.ijq.live_id == h.this.grz || h.this.grC) {
                            if (h.this.ijq != null && (h.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) h.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == h.this.ijq.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(h.this.mContext, h.this.ijq.user_id + "", h.this.ijq.user_name, h.this.ijq.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, h.this.ijq.getName_show())));
                                return;
                            }
                            return;
                        }
                        com.baidu.live.liveroom.a.OO().a(com.baidu.live.liveroom.a.OO().OP().hW(String.valueOf(h.this.ijq.live_id)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(h.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(h.this.ijq.live_id, "", "live_sdk");
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(h.this.gtp);
                        com.baidu.live.liveroom.a.OO().a(alaLiveRoomActivityConfig);
                    }
                });
            } else {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (h.this.ijq == null || h.this.ijq.eTW != 1 || h.this.ijq.live_id <= 0 || h.this.ijq.live_id == h.this.grz || h.this.grC || !com.baidu.live.af.a.SE().bwi.aOz) {
                            if (h.this.ijq != null && (h.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) h.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == h.this.ijq.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(h.this.mContext, h.this.ijq.user_id + "", h.this.ijq.user_name, h.this.ijq.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, h.this.ijq.getName_show())));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(h.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(h.this.ijq.live_id, "", "live_sdk");
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(h.this.gtp);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            }
        }
    }
}
