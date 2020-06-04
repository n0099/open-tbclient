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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.g;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class e {
    private long eUS;
    private String eUU;
    private boolean eUV;
    private TextView gnb;
    private TextView gvK;
    private TextView gvL;
    private HeadImageView gvM;
    private LottieAnimationView gvN;
    private TextView gvO;
    private g gvP;
    private Context mContext;
    private View mRootView;

    public e(Context context, View view, String str, long j, boolean z) {
        this.mContext = context;
        this.mRootView = view;
        this.eUU = str;
        this.eUS = j;
        this.eUV = z;
        this.gnb = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
        this.gvL = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
        this.gvK = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_rank_info);
        this.gvM = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_header);
        this.gvM.setIsRound(true);
        this.gvM.setAutoChangeStyle(false);
        this.gvO = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_header_pendent);
        this.gvN = (LottieAnimationView) this.mRootView.findViewById(a.g.rank_live_anim);
    }

    public void a(g gVar, final int i) {
        if (gVar != null) {
            this.gvP = gVar;
            this.gnb.setText(this.gvP.getName_show());
            this.gvM.startLoad(this.gvP.avatar, 12, false);
            if (this.gvP.dFH == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gvN.getLayoutParams();
                if (this.gvP.rank == 1 && TextUtils.equals("charm_day", this.eUU)) {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 19.0f), BdUtilHelper.dip2px(this.mContext, 37.0f), BdUtilHelper.dip2px(this.mContext, 19.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    this.gvN.setAnimation("anchor_living.json");
                } else {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 0.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    this.gvN.setAnimation("rank_list_living.json");
                }
                this.gvN.setVisibility(0);
                this.gvN.loop(true);
                this.gvN.playAnimation();
            } else {
                this.gvN.setVisibility(8);
            }
            int i2 = this.gvP.rank;
            if (i2 == 1) {
                this.gvL.setText("");
                this.gvL.setBackgroundResource(a.f.sdk_icon_live_list_first);
            } else if (i2 == 2) {
                this.gvL.setText("");
                this.gvL.setBackgroundResource(a.f.sdk_icon_live_list_second);
            } else if (i2 == 3) {
                this.gvL.setText("");
                this.gvL.setBackgroundResource(a.f.sdk_icon_live_list_third);
            } else {
                this.gvL.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                if (i2 >= 100) {
                    this.gvL.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                } else {
                    this.gvL.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize32));
                }
                this.gvL.setText(String.valueOf(i2));
                this.gvL.setBackgroundResource(a.d.sdk_transparent);
            }
            if (i2 == 1 && TextUtils.equals("charm_day", this.eUU)) {
                this.gvO.setVisibility(0);
            } else {
                this.gvO.setVisibility(8);
            }
            if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eUU)) {
                double d = JavaTypesHelper.toDouble(this.gvP.point, 0.0d);
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                this.gvK.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), decimalFormat.format(d)));
            } else {
                long j = JavaTypesHelper.toLong(this.gvP.point, 0L);
                if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eUU)) {
                    this.gvK.setText(String.format(this.mContext.getString(a.i.ala_rank_list_flower_point), StringHelper.numFormatOver10000(j)));
                } else if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eUU)) {
                    this.gvK.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_point), i.formatTosepara(j)));
                } else if ("hot".equals(this.eUU)) {
                    this.gvK.setText(String.format(this.mContext.getString(a.i.ala_rank_list_hot_point), i.formatTosepara(j)));
                } else if ("pk".equals(this.eUU)) {
                    this.gvK.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), i.formatTosepara(j)));
                } else if ("guard".equals(this.eUU)) {
                    this.gvK.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), i.formatTosepara(j)));
                } else if ("charm_day".equals(this.eUU) || "hour".equals(this.eUU)) {
                    this.gvK.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(j)));
                }
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (e.this.gvP == null || e.this.gvP.dFH != 1 || e.this.gvP.live_id <= 0 || e.this.gvP.live_id == e.this.eUS || e.this.eUV) {
                            if (e.this.gvP != null && (e.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) e.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == e.this.gvP.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(e.this.mContext, e.this.gvP.user_id + "", e.this.gvP.user_name, e.this.gvP.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, e.this.gvP.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(e.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(e.this.gvP.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            } else {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (e.this.gvP == null || e.this.gvP.dFH != 1 || e.this.gvP.live_id <= 0 || e.this.gvP.live_id == e.this.eUS || e.this.eUV || !com.baidu.live.v.a.Ge().aWF.aya) {
                            if (e.this.gvP != null && (e.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) e.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == e.this.gvP.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(e.this.mContext, e.this.gvP.user_id + "", e.this.gvP.user_name, e.this.gvP.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, e.this.gvP.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(e.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(e.this.gvP.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            }
        }
    }
}
