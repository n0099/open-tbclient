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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.g;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class e {
    private long edH;
    private String edJ;
    private boolean edK;
    private TextView fqi;
    private TextView fyF;
    private TextView fyG;
    private HeadImageView fyH;
    private LottieAnimationView fyI;
    private TextView fyJ;
    private TextView fyK;
    private g fyL;
    private Context mContext;
    private View mRootView;

    public e(Context context, View view, String str, long j, boolean z) {
        this.mContext = context;
        this.mRootView = view;
        this.edJ = str;
        this.edH = j;
        this.edK = z;
        this.fqi = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
        this.fyG = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
        this.fyF = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_rank_info);
        this.fyH = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_header);
        this.fyH.setIsRound(true);
        this.fyH.setAutoChangeStyle(false);
        this.fyK = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_stage_icon);
        this.fyJ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_header_pendent);
        this.fyI = (LottieAnimationView) this.mRootView.findViewById(a.g.rank_live_anim);
    }

    public void a(g gVar, final int i) {
        if (gVar != null) {
            this.fyL = gVar;
            String name_show = this.fyL.getName_show();
            if (TextHelper.getTextLengthWithEmoji(name_show) > 14) {
                name_show = TextHelper.subStringWithEmoji(name_show, 14) + StringHelper.STRING_MORE;
            }
            this.fqi.setText(name_show);
            this.fyH.startLoad(this.fyL.avatar, 12, false);
            if (this.fyL.cOh == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fyI.getLayoutParams();
                if (this.fyL.rank == 1 && TextUtils.equals("charm_day", this.edJ)) {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 19.0f), BdUtilHelper.dip2px(this.mContext, 37.0f), BdUtilHelper.dip2px(this.mContext, 19.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    this.fyI.setAnimation("anchor_living.json");
                } else {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 0.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    this.fyI.setAnimation("rank_list_living.json");
                }
                this.fyI.setVisibility(0);
                this.fyI.loop(true);
                this.fyI.playAnimation();
            } else {
                this.fyI.setVisibility(8);
            }
            int i2 = this.fyL.rank;
            if (i2 == 1) {
                this.fyG.setText("");
                this.fyG.setBackgroundResource(a.f.sdk_icon_live_list_first);
            } else if (i2 == 2) {
                this.fyG.setText("");
                this.fyG.setBackgroundResource(a.f.sdk_icon_live_list_second);
            } else if (i2 == 3) {
                this.fyG.setText("");
                this.fyG.setBackgroundResource(a.f.sdk_icon_live_list_third);
            } else {
                this.fyG.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                if (i2 >= 100) {
                    this.fyG.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                } else {
                    this.fyG.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize32));
                }
                this.fyG.setText(String.valueOf(i2));
                this.fyG.setBackgroundResource(a.d.sdk_transparent);
            }
            if (i2 == 1 && TextUtils.equals("charm_day", this.edJ)) {
                this.fyJ.setVisibility(0);
            } else {
                this.fyJ.setVisibility(8);
            }
            if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.edJ)) {
                double d = JavaTypesHelper.toDouble(this.fyL.point, 0.0d);
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                this.fyF.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), decimalFormat.format(d)));
            } else {
                long j = JavaTypesHelper.toLong(this.fyL.point, 0L);
                if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.edJ)) {
                    this.fyF.setText(String.format(this.mContext.getString(a.i.ala_rank_list_flower_point), StringHelper.numFormatOver10000(j)));
                } else if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.edJ)) {
                    this.fyF.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_point), i.formatTosepara(j)));
                } else if ("hot".equals(this.edJ)) {
                    this.fyF.setText(String.format(this.mContext.getString(a.i.ala_rank_list_hot_point), i.formatTosepara(j)));
                } else if ("pk".equals(this.edJ)) {
                    this.fyF.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), i.formatTosepara(j)));
                } else if ("guard".equals(this.edJ)) {
                    this.fyF.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), i.formatTosepara(j)));
                } else if ("charm_day".equals(this.edJ) || "hour".equals(this.edJ)) {
                    this.fyF.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(j)));
                }
            }
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.edJ)) {
                boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
                if (i <= 1 && !z) {
                    this.fyK.setVisibility(0);
                } else {
                    this.fyK.setVisibility(8);
                }
            } else {
                this.fyK.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (e.this.fyL == null || e.this.fyL.cOh != 1 || e.this.fyL.live_id <= 0 || e.this.fyL.live_id == e.this.edH || e.this.edK) {
                            if (e.this.fyL != null && (e.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) e.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == e.this.fyL.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(e.this.mContext, e.this.fyL.user_id + "", e.this.fyL.user_name, e.this.fyL.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, e.this.fyL.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(e.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(e.this.fyL.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            } else {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (e.this.fyL == null || e.this.fyL.cOh != 1 || e.this.fyL.live_id <= 0 || e.this.fyL.live_id == e.this.edH || e.this.edK || !com.baidu.live.s.a.wR().asq.YD) {
                            if (e.this.fyL != null && (e.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) e.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == e.this.fyL.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(e.this.mContext, e.this.fyL.user_id + "", e.this.fyL.user_name, e.this.fyL.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, e.this.fyL.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(e.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(e.this.fyL.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            }
        }
    }
}
