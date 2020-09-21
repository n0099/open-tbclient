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
    private AlaLastLiveroomInfo fAJ;
    private long fyR;
    private String fyT;
    private boolean fyU;
    private TextView gVA;
    private TextView hfs;
    private TextView hft;
    private HeadImageView hfu;
    private LottieAnimationView hfv;
    private TextView hfw;
    private com.baidu.tieba.ala.data.h hfx;
    private Context mContext;
    private View mRootView;

    public h(Context context, View view, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.mRootView = view;
        this.fyT = str;
        this.fyR = j;
        this.fyU = z;
        this.fAJ = alaLastLiveroomInfo;
        this.gVA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
        this.hft = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
        this.hfs = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_rank_info);
        this.hfu = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_header);
        this.hfu.setIsRound(true);
        this.hfu.setAutoChangeStyle(false);
        this.hfw = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_header_pendent);
        this.hfv = (LottieAnimationView) this.mRootView.findViewById(a.g.rank_live_anim);
    }

    public void a(com.baidu.tieba.ala.data.h hVar, final int i) {
        if (hVar != null) {
            this.hfx = hVar;
            this.gVA.setText(this.hfx.getName_show());
            this.hfu.startLoad(this.hfx.avatar, 12, false);
            if (this.hfx.een == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hfv.getLayoutParams();
                if (this.hfx.rank == 1 && TextUtils.equals("charm_day", this.fyT)) {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 19.0f), BdUtilHelper.dip2px(this.mContext, 37.0f), BdUtilHelper.dip2px(this.mContext, 19.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    this.hfv.setAnimation("anchor_living.json");
                } else {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 0.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    this.hfv.setAnimation("rank_list_living.json");
                }
                this.hfv.setVisibility(0);
                this.hfv.loop(true);
                this.hfv.playAnimation();
            } else {
                this.hfv.setVisibility(8);
            }
            int i2 = this.hfx.rank;
            if (i2 == 1) {
                this.hft.setText("");
                this.hft.setBackgroundResource(a.f.sdk_icon_live_list_first);
            } else if (i2 == 2) {
                this.hft.setText("");
                this.hft.setBackgroundResource(a.f.sdk_icon_live_list_second);
            } else if (i2 == 3) {
                this.hft.setText("");
                this.hft.setBackgroundResource(a.f.sdk_icon_live_list_third);
            } else {
                this.hft.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                if (i2 >= 100) {
                    this.hft.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                } else {
                    this.hft.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize32));
                }
                this.hft.setText(String.valueOf(i2));
                this.hft.setBackgroundResource(a.d.sdk_transparent);
            }
            if (i2 == 1 && TextUtils.equals("charm_day", this.fyT)) {
                this.hfw.setVisibility(0);
            } else {
                this.hfw.setVisibility(8);
            }
            if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fyT)) {
                double d = JavaTypesHelper.toDouble(this.hfx.point, 0.0d);
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                this.hfs.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), decimalFormat.format(d)));
            } else {
                long j = JavaTypesHelper.toLong(this.hfx.point, 0L);
                if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fyT)) {
                    this.hfs.setText(String.format(this.mContext.getString(a.i.ala_rank_list_flower_point), StringHelper.numFormatOver10000(j)));
                } else if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fyT)) {
                    this.hfs.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("hot".equals(this.fyT)) {
                    this.hfs.setText(String.format(this.mContext.getString(a.i.ala_rank_list_hot_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("pk".equals(this.fyT)) {
                    this.hfs.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("guard".equals(this.fyT)) {
                    this.hfs.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), com.baidu.live.utils.j.formatTosepara(j)));
                } else if ("charm_day".equals(this.fyT) || "hour".equals(this.fyT)) {
                    this.hfs.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(j)));
                }
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (h.this.hfx == null || h.this.hfx.een != 1 || h.this.hfx.live_id <= 0 || h.this.hfx.live_id == h.this.fyR || h.this.fyU) {
                            if (h.this.hfx != null && (h.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) h.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == h.this.hfx.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(h.this.mContext, h.this.hfx.user_id + "", h.this.hfx.user_name, h.this.hfx.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, h.this.hfx.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(h.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(h.this.hfx.live_id, "", "live_sdk");
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(h.this.fAJ);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            } else {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (h.this.hfx == null || h.this.hfx.een != 1 || h.this.hfx.live_id <= 0 || h.this.hfx.live_id == h.this.fyR || h.this.fyU || !com.baidu.live.x.a.NN().bhy.aId) {
                            if (h.this.hfx != null && (h.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) h.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == h.this.hfx.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(h.this.mContext, h.this.hfx.user_id + "", h.this.hfx.user_name, h.this.hfx.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, h.this.hfx.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(h.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(h.this.hfx.live_id, "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            }
        }
    }
}
