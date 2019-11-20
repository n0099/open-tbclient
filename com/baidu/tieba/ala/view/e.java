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
    private long dtM;
    private String dtO;
    private boolean dtP;
    private TextView eDP;
    private TextView eDQ;
    private HeadImageView eDR;
    private LottieAnimationView eDS;
    private TextView eDT;
    private TextView eDU;
    private com.baidu.tieba.ala.data.c eDV;
    private TextView evA;
    private Context mContext;
    private View mRootView;

    public e(Context context, View view, String str, long j, boolean z) {
        this.mContext = context;
        this.mRootView = view;
        this.dtO = str;
        this.dtM = j;
        this.dtP = z;
        this.evA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
        this.eDQ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
        this.eDP = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_rank_info);
        this.eDR = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_header);
        this.eDR.setIsRound(true);
        this.eDR.setAutoChangeStyle(false);
        this.eDU = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_stage_icon);
        this.eDT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_header_pendent);
        this.eDS = (LottieAnimationView) this.mRootView.findViewById(a.g.rank_live_anim);
    }

    public void a(com.baidu.tieba.ala.data.c cVar, final int i) {
        if (cVar != null) {
            this.eDV = cVar;
            String name_show = this.eDV.getName_show();
            if (TextHelper.getTextLengthWithEmoji(name_show) > 14) {
                name_show = TextHelper.subStringWithEmoji(name_show, 14) + StringHelper.STRING_MORE;
            }
            this.evA.setText(name_show);
            this.eDR.startLoad(this.eDV.avatar, 12, false);
            if (this.eDV.cbt == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eDS.getLayoutParams();
                if (this.eDV.rank == 1 && TextUtils.equals("charm_day", this.dtO)) {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 19.0f), BdUtilHelper.dip2px(this.mContext, 37.0f), BdUtilHelper.dip2px(this.mContext, 19.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    this.eDS.setAnimation("anchor_living.json");
                } else {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 0.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    this.eDS.setAnimation("rank_list_living.json");
                }
                this.eDS.setVisibility(0);
                this.eDS.loop(true);
                this.eDS.playAnimation();
            } else {
                this.eDS.setVisibility(8);
            }
            int i2 = this.eDV.rank;
            if (i2 == 1) {
                this.eDQ.setText("");
                this.eDQ.setBackgroundResource(a.f.sdk_icon_live_list_first);
            } else if (i2 == 2) {
                this.eDQ.setText("");
                this.eDQ.setBackgroundResource(a.f.sdk_icon_live_list_second);
            } else if (i2 == 3) {
                this.eDQ.setText("");
                this.eDQ.setBackgroundResource(a.f.sdk_icon_live_list_third);
            } else {
                this.eDQ.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                if (i2 >= 100) {
                    this.eDQ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                } else {
                    this.eDQ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize32));
                }
                this.eDQ.setText(String.valueOf(i2));
                this.eDQ.setBackgroundResource(a.d.sdk_transparent);
            }
            if (i2 == 1 && TextUtils.equals("charm_day", this.dtO)) {
                this.eDT.setVisibility(0);
            } else {
                this.eDT.setVisibility(8);
            }
            if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.dtO)) {
                double d = JavaTypesHelper.toDouble(this.eDV.Tx, 0.0d);
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                this.eDP.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), decimalFormat.format(d)));
            } else {
                long j = JavaTypesHelper.toLong(this.eDV.Tx, 0L);
                if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.dtO)) {
                    this.eDP.setText(String.format(this.mContext.getString(a.i.ala_rank_list_flower_point), StringHelper.numFormatOver10000(j)));
                } else if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.dtO)) {
                    this.eDP.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_point), h.formatTosepara(j)));
                } else if ("hot".equals(this.dtO)) {
                    this.eDP.setText(String.format(this.mContext.getString(a.i.ala_rank_list_hot_point), h.formatTosepara(j)));
                } else if ("pk".equals(this.dtO)) {
                    this.eDP.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), h.formatTosepara(j)));
                } else if ("guard".equals(this.dtO)) {
                    this.eDP.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), h.formatTosepara(j)));
                } else if ("charm_day".equals(this.dtO) || "hour".equals(this.dtO)) {
                    this.eDP.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(j)));
                }
            }
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.dtO)) {
                boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba();
                if (i <= 1 && !z) {
                    this.eDU.setVisibility(0);
                } else {
                    this.eDU.setVisibility(8);
                }
            } else {
                this.eDU.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (e.this.eDV == null || e.this.eDV.cbt != 1 || e.this.eDV.live_id <= 0 || e.this.eDV.live_id == e.this.dtM || e.this.dtP) {
                            if (e.this.eDV != null && (e.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) e.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == e.this.eDV.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(e.this.mContext, e.this.eDV.user_id + "", e.this.eDV.user_name, e.this.eDV.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, e.this.eDV.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(e.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(e.this.eDV.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            }
        }
    }
}
