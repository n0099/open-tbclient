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
import com.baidu.live.k.a;
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
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/* loaded from: classes6.dex */
public class e {
    private long duD;
    private String duF;
    private boolean duG;
    private TextView eEG;
    private TextView eEH;
    private HeadImageView eEI;
    private LottieAnimationView eEJ;
    private TextView eEK;
    private TextView eEL;
    private com.baidu.tieba.ala.data.c eEM;
    private TextView ewr;
    private Context mContext;
    private View mRootView;

    public e(Context context, View view, String str, long j, boolean z) {
        this.mContext = context;
        this.mRootView = view;
        this.duF = str;
        this.duD = j;
        this.duG = z;
        this.ewr = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
        this.eEH = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
        this.eEG = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_rank_info);
        this.eEI = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_header);
        this.eEI.setIsRound(true);
        this.eEI.setAutoChangeStyle(false);
        this.eEL = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_stage_icon);
        this.eEK = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_header_pendent);
        this.eEJ = (LottieAnimationView) this.mRootView.findViewById(a.g.rank_live_anim);
    }

    public void a(com.baidu.tieba.ala.data.c cVar, final int i) {
        if (cVar != null) {
            this.eEM = cVar;
            String name_show = this.eEM.getName_show();
            if (TextHelper.getTextLengthWithEmoji(name_show) > 14) {
                name_show = TextHelper.subStringWithEmoji(name_show, 14) + StringHelper.STRING_MORE;
            }
            this.ewr.setText(name_show);
            this.eEI.startLoad(this.eEM.avatar, 12, false);
            if (this.eEM.cck == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eEJ.getLayoutParams();
                if (this.eEM.rank == 1 && TextUtils.equals("charm_day", this.duF)) {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 19.0f), BdUtilHelper.dip2px(this.mContext, 37.0f), BdUtilHelper.dip2px(this.mContext, 19.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    this.eEJ.setAnimation("anchor_living.json");
                } else {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 0.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    this.eEJ.setAnimation("rank_list_living.json");
                }
                this.eEJ.setVisibility(0);
                this.eEJ.loop(true);
                this.eEJ.playAnimation();
            } else {
                this.eEJ.setVisibility(8);
            }
            int i2 = this.eEM.rank;
            if (i2 == 1) {
                this.eEH.setText("");
                this.eEH.setBackgroundResource(a.f.sdk_icon_live_list_first);
            } else if (i2 == 2) {
                this.eEH.setText("");
                this.eEH.setBackgroundResource(a.f.sdk_icon_live_list_second);
            } else if (i2 == 3) {
                this.eEH.setText("");
                this.eEH.setBackgroundResource(a.f.sdk_icon_live_list_third);
            } else {
                this.eEH.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                if (i2 >= 100) {
                    this.eEH.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                } else {
                    this.eEH.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize32));
                }
                this.eEH.setText(String.valueOf(i2));
                this.eEH.setBackgroundResource(a.d.sdk_transparent);
            }
            if (i2 == 1 && TextUtils.equals("charm_day", this.duF)) {
                this.eEK.setVisibility(0);
            } else {
                this.eEK.setVisibility(8);
            }
            if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.duF)) {
                double d = JavaTypesHelper.toDouble(this.eEM.TS, 0.0d);
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                this.eEG.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), decimalFormat.format(d)));
            } else {
                long j = JavaTypesHelper.toLong(this.eEM.TS, 0L);
                if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.duF)) {
                    this.eEG.setText(String.format(this.mContext.getString(a.i.ala_rank_list_flower_point), StringHelper.numFormatOver10000(j)));
                } else if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.duF)) {
                    this.eEG.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_point), h.formatTosepara(j)));
                } else if ("hot".equals(this.duF)) {
                    this.eEG.setText(String.format(this.mContext.getString(a.i.ala_rank_list_hot_point), h.formatTosepara(j)));
                } else if ("pk".equals(this.duF)) {
                    this.eEG.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), h.formatTosepara(j)));
                } else if ("guard".equals(this.duF)) {
                    this.eEG.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), h.formatTosepara(j)));
                } else if ("charm_day".equals(this.duF) || "hour".equals(this.duF)) {
                    this.eEG.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(j)));
                }
            }
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.duF)) {
                boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba();
                if (i <= 1 && !z) {
                    this.eEL.setVisibility(0);
                } else {
                    this.eEL.setVisibility(8);
                }
            } else {
                this.eEL.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (e.this.eEM == null || e.this.eEM.cck != 1 || e.this.eEM.live_id <= 0 || e.this.eEM.live_id == e.this.duD || e.this.duG) {
                            if (e.this.eEM != null && (e.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) e.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == e.this.eEM.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(e.this.mContext, e.this.eEM.user_id + "", e.this.eEM.user_name, e.this.eEM.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, e.this.eEM.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(e.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(e.this.eEM.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            }
        }
    }
}
