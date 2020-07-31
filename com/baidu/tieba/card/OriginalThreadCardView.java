package com.baidu.tieba.card;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private VoteView agF;
    private TbImageView gYM;
    private ImageView gYN;
    private ImageView gYO;
    private LinearLayout gYP;
    private TextView gYQ;
    private RankStarView gYR;
    private TextView gYS;
    private int gYT;
    private a gYU;
    public int gYV;
    public boolean gYW;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;
    private static final int gYX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int aim = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int gYY = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int aeu = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    private static final int gYZ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* loaded from: classes15.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.gYW = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gYW = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gYW = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.gYM = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.gYN = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.gYO = (ImageView) findViewById(R.id.thread_pic_mask);
            this.gYM.setLongIconSupport(false);
            this.gYM.setGifIconSupport(false);
            this.gYM.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.gYM.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYM.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.gYM.setLayoutParams(layoutParams);
            this.gYO.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gYN.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.gYN.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
            this.gYP = (LinearLayout) findViewById(R.id.add_item);
            this.gYQ = (TextView) findViewById(R.id.item_title);
            this.gYQ.setMaxWidth(com.baidu.adp.lib.util.l.getScreenDimensions(context)[0] / 2);
            this.gYR = (RankStarView) findViewById(R.id.item_star);
            this.gYS = (TextView) findViewById(R.id.item_score);
            this.agF = (VoteView) findViewById(R.id.vote_view);
            this.agF.setBgColor(R.color.cp_bg_line_e);
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.OriginalThreadCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && (view.getTag() instanceof OriginalThreadInfo)) {
                        OriginalThreadInfo originalThreadInfo = (OriginalThreadInfo) view.getTag();
                        if (originalThreadInfo.showType == 4) {
                            OriginalThreadCardView.this.c(originalThreadInfo);
                        } else {
                            OriginalThreadCardView.this.e(originalThreadInfo);
                        }
                        if (OriginalThreadCardView.this.gYU != null) {
                            OriginalThreadCardView.this.gYU.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.gYW = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.gYT = 0;
                    this.gYM.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.gYW) {
                        this.gYM.setPlaceHolder(2);
                    } else {
                        this.gYM.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.gYM.setVisibility(0);
                    this.gYM.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.gYT = 0;
                    this.gYM.setDefaultResource(R.drawable.icon_card_url_n);
                    this.gYM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gYM.setVisibility(0);
                    this.gYM.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.gYT = R.drawable.icon_share_play_n;
                    this.gYM.setDefaultResource(R.color.cp_bg_line_c);
                    this.gYM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gYM.setVisibility(0);
                    this.gYM.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.gYT = R.drawable.icon_share_card_live;
                    this.gYM.setDefaultResource(R.color.cp_bg_line_c);
                    this.gYM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gYM.setVisibility(0);
                    this.gYM.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.gYT = 0;
                    this.gYM.setVisibility(8);
                    break;
            }
            if (this.gYT != 0) {
                this.gYN.setVisibility(0);
                this.gYO.setVisibility(0);
                ao.setImageResource(this.gYN, this.gYT);
            } else {
                this.gYN.setVisibility(8);
                this.gYO.setVisibility(8);
            }
            this.mTitleView.setText((originalThreadInfo.dPO == null || originalThreadInfo.dPO.length() == 0) ? originalThreadInfo.showText : originalThreadInfo.dPO);
            b(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.gYT = 0;
                    this.gYM.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.gYW) {
                        this.gYM.setPlaceHolder(2);
                    } else {
                        this.gYM.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.gYM.setVisibility(0);
                    this.gYM.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.gYT = 0;
                    this.gYM.setDefaultResource(R.drawable.icon_card_url_n);
                    this.gYM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gYM.setVisibility(0);
                    this.gYM.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.gYT = R.drawable.icon_share_play_n;
                    this.gYM.setDefaultResource(R.color.cp_bg_line_c);
                    this.gYM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gYM.setVisibility(0);
                    this.gYM.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.gYT = R.drawable.icon_share_card_live;
                    this.gYM.setDefaultResource(R.color.cp_bg_line_c);
                    this.gYM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gYM.setVisibility(0);
                    this.gYM.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.gYT = 0;
                    this.gYM.setVisibility(8);
                    break;
            }
            if (this.gYT != 0) {
                this.gYN.setVisibility(0);
                this.gYO.setVisibility(0);
                ao.setImageResource(this.gYN, this.gYT);
            } else {
                this.gYN.setVisibility(8);
                this.gYO.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            b(shareInfo);
            this.agF.setVisibility(8);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.gYU = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ao.setViewTextColor(this.mTitleView, R.color.cp_cont_j);
            if (this.gYT != 0) {
                ao.setImageResource(this.gYN, this.gYT);
            }
            setBackgroundDrawable(ao.aH(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ao.getColor(R.color.cp_bg_line_g)));
            this.gYP.setBackgroundDrawable(ao.aH(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ao.getColor(R.color.cp_bg_line_e)));
            this.agF.onChangeSkinType(skinType);
            ao.setViewTextColor(this.gYQ, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.gYS, R.color.cp_cont_d, 1);
            this.gYR.bcT();
        }
    }

    public void setReadState(boolean z) {
        ao.setViewTextColor(this.mTitleView, z ? R.color.cp_cont_d : R.color.cp_cont_j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null && originalThreadInfo.showType == 4) {
            if (originalThreadInfo.threadType == 49) {
                d(originalThreadInfo);
            } else if (originalThreadInfo.threadType == 60) {
                if (originalThreadInfo.dPL != null) {
                    if (originalThreadInfo.dPL.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.dPL.share_info != null && originalThreadInfo.dPL.share_info.record_tid <= 0) {
                        d(originalThreadInfo);
                        return;
                    } else {
                        e(originalThreadInfo);
                        return;
                    }
                }
                e(originalThreadInfo);
            } else {
                e(originalThreadInfo);
            }
        }
    }

    private void d(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null && originalThreadInfo.dPL != null && originalThreadInfo.dPL.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.dPL);
            if (originalThreadInfo.dPL.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.dPL.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData, null, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            if (ax.a(originalThreadInfo.oriUgcInfo)) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, null, null);
                pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                pbActivityConfig.setStartFrom(this.gYV);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.gYV);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }

    private void b(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        b(itemData);
        if (itemData != null) {
            this.gYQ.setText(itemData.mTitle);
            this.gYR.setStarCount(itemData.mStar);
            if (itemData.mScore > 0.0d && itemData.mScore <= 10.0d) {
                this.gYS.setText(itemData.mScore + "");
            } else {
                this.gYS.setText(R.string.frs_evaluate_exception);
            }
            if (this.gYM.getVisibility() == 8) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                layoutParams.height = -2;
                this.mTitleView.setLayoutParams(layoutParams);
            }
        }
        ItemStarData itemStarData = shareInfo.itemStarData;
        if (itemStarData != null) {
            this.mTitleView.setText(a(shareInfo.showText, itemStarData), TextView.BufferType.SPANNABLE);
        }
    }

    private void b(PollData pollData, String str, long j) {
        this.agF.setVisibility(8);
        if (pollData != null && !com.baidu.tbadk.core.util.x.isEmpty(pollData.getOptions())) {
            this.agF.setVisibility(0);
            this.agF.setIsTransmit(true);
            this.agF.setData(pollData, str, j);
        }
    }

    private void b(ItemData itemData) {
        if (itemData == null) {
            this.gYP.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.gYP.setVisibility(0);
        setPadding(aim, aim, aim, gYY);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYP.getLayoutParams();
        if (this.gYM.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.gYP.setLayoutParams(layoutParams);
        this.gYR.setStarSpacing(gYX);
        int i = gYZ;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gYM.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.gYM.setLayoutParams(layoutParams2);
        this.gYO.setLayoutParams(layoutParams2);
        int i2 = aeu;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gYN.getLayoutParams();
        layoutParams3.leftMargin = (i - i2) / 2;
        this.gYN.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
        layoutParams4.height = i;
        this.mTitleView.setLayoutParams(layoutParams4);
    }

    private SpannableStringBuilder a(String str, ItemStarData itemStarData) {
        SpannableStringBuilder a2 = com.baidu.tbadk.widget.richText.e.a(itemStarData);
        a2.append((CharSequence) str);
        return a2;
    }
}
