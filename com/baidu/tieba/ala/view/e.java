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
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.g;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class e {
    private long ehK;
    private String ehM;
    private boolean ehN;
    private TextView fBd;
    private TextView fBe;
    private HeadImageView fBf;
    private LottieAnimationView fBg;
    private TextView fBh;
    private TextView fBi;
    private g fBj;
    private TextView fsL;
    private Context mContext;
    private View mRootView;

    public e(Context context, View view, String str, long j, boolean z) {
        this.mContext = context;
        this.mRootView = view;
        this.ehM = str;
        this.ehK = j;
        this.ehN = z;
        this.fsL = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
        this.fBe = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
        this.fBd = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_rank_info);
        this.fBf = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_header);
        this.fBf.setIsRound(true);
        this.fBf.setAutoChangeStyle(false);
        this.fBi = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_stage_icon);
        this.fBh = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_header_pendent);
        this.fBg = (LottieAnimationView) this.mRootView.findViewById(a.g.rank_live_anim);
    }

    public void a(g gVar, final int i) {
        if (gVar != null) {
            this.fBj = gVar;
            String name_show = this.fBj.getName_show();
            if (TextHelper.getTextLengthWithEmoji(name_show) > 14) {
                name_show = TextHelper.subStringWithEmoji(name_show, 14) + StringHelper.STRING_MORE;
            }
            this.fsL.setText(name_show);
            this.fBf.startLoad(this.fBj.avatar, 12, false);
            if (this.fBj.cSk == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fBg.getLayoutParams();
                if (this.fBj.rank == 1 && TextUtils.equals("charm_day", this.ehM)) {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 19.0f), BdUtilHelper.dip2px(this.mContext, 37.0f), BdUtilHelper.dip2px(this.mContext, 19.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 14.0f);
                    this.fBg.setAnimation("anchor_living.json");
                } else {
                    layoutParams.setMargins(BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 35.0f), BdUtilHelper.dip2px(this.mContext, 0.0f), 0);
                    layoutParams.width = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    layoutParams.height = BdUtilHelper.dip2px(this.mContext, 12.0f);
                    this.fBg.setAnimation("rank_list_living.json");
                }
                this.fBg.setVisibility(0);
                this.fBg.loop(true);
                this.fBg.playAnimation();
            } else {
                this.fBg.setVisibility(8);
            }
            int i2 = this.fBj.rank;
            if (i2 == 1) {
                this.fBe.setText("");
                this.fBe.setBackgroundResource(a.f.sdk_icon_live_list_first);
            } else if (i2 == 2) {
                this.fBe.setText("");
                this.fBe.setBackgroundResource(a.f.sdk_icon_live_list_second);
            } else if (i2 == 3) {
                this.fBe.setText("");
                this.fBe.setBackgroundResource(a.f.sdk_icon_live_list_third);
            } else {
                this.fBe.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                if (i2 >= 100) {
                    this.fBe.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                } else {
                    this.fBe.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize32));
                }
                this.fBe.setText(String.valueOf(i2));
                this.fBe.setBackgroundResource(a.d.sdk_transparent);
            }
            if (i2 == 1 && TextUtils.equals("charm_day", this.ehM)) {
                this.fBh.setVisibility(0);
            } else {
                this.fBh.setVisibility(8);
            }
            if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.ehM)) {
                double d = JavaTypesHelper.toDouble(this.fBj.point, 0.0d);
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                this.fBd.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), decimalFormat.format(d)));
            } else {
                long j = JavaTypesHelper.toLong(this.fBj.point, 0L);
                if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ehM)) {
                    this.fBd.setText(String.format(this.mContext.getString(a.i.ala_rank_list_flower_point), StringHelper.numFormatOver10000(j)));
                } else if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.ehM)) {
                    this.fBd.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_point), i.formatTosepara(j)));
                } else if ("hot".equals(this.ehM)) {
                    this.fBd.setText(String.format(this.mContext.getString(a.i.ala_rank_list_hot_point), i.formatTosepara(j)));
                } else if ("pk".equals(this.ehM)) {
                    this.fBd.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), i.formatTosepara(j)));
                } else if ("guard".equals(this.ehM)) {
                    this.fBd.setText(String.format(this.mContext.getString(a.i.ala_rank_list_game_point), i.formatTosepara(j)));
                } else if ("charm_day".equals(this.ehM) || "hour".equals(this.ehM)) {
                    this.fBd.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(j)));
                }
            }
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ehM)) {
                boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
                if (i <= 1 && !z) {
                    this.fBi.setVisibility(0);
                } else {
                    this.fBi.setVisibility(8);
                }
            } else {
                this.fBi.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (e.this.fBj == null || e.this.fBj.cSk != 1 || e.this.fBj.live_id <= 0 || e.this.fBj.live_id == e.this.ehK || e.this.ehN) {
                            if (e.this.fBj != null && (e.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) e.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == e.this.fBj.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(e.this.mContext, e.this.fBj.user_id + "", e.this.fBj.user_name, e.this.fBj.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, e.this.fBj.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(e.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(e.this.fBj.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            } else {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, i + 2)));
                        if (e.this.fBj == null || e.this.fBj.cSk != 1 || e.this.fBj.live_id <= 0 || e.this.fBj.live_id == e.this.ehK || e.this.ehN || !com.baidu.live.v.a.zj().awA.aav) {
                            if (e.this.fBj != null && (e.this.mContext instanceof Activity)) {
                                Intent intent = ((Activity) e.this.mContext).getIntent();
                                long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                                String stringExtra = intent.getStringExtra("group_id");
                                String stringExtra2 = intent.getStringExtra("live_id");
                                boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                                String stringExtra3 = intent.getStringExtra("live_owner_uid");
                                if (longExtra == e.this.fBj.user_id) {
                                    stringExtra3 = longExtra + "";
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(e.this.mContext, e.this.fBj.user_id + "", e.this.fBj.user_name, e.this.fBj.avatar, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, e.this.fBj.getName_show(), "")));
                                return;
                            }
                            return;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(e.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(e.this.fBj.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                });
            }
        }
    }
}
