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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private VoteView ahO;
    private TbImageView hlF;
    private ImageView hlG;
    private ImageView hlH;
    private LinearLayout hlI;
    private TextView hlJ;
    private RankStarView hlK;
    private TextView hlL;
    private int hlM;
    private a hlN;
    public int hlO;
    public boolean hlP;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;
    private static final int hlQ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int ajB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int hlR = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int afD = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    private static final int hlS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* loaded from: classes15.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.hlP = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlP = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hlP = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.hlF = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.hlG = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.hlH = (ImageView) findViewById(R.id.thread_pic_mask);
            this.hlF.setLongIconSupport(false);
            this.hlF.setGifIconSupport(false);
            this.hlF.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.hlF.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlF.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.hlF.setLayoutParams(layoutParams);
            this.hlH.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hlG.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.hlG.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
            this.hlI = (LinearLayout) findViewById(R.id.add_item);
            this.hlJ = (TextView) findViewById(R.id.item_title);
            this.hlJ.setMaxWidth(com.baidu.adp.lib.util.l.getScreenDimensions(context)[0] / 2);
            this.hlK = (RankStarView) findViewById(R.id.item_star);
            this.hlL = (TextView) findViewById(R.id.item_score);
            this.ahO = (VoteView) findViewById(R.id.vote_view);
            this.ahO.setBgColor(R.color.cp_bg_line_e);
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
                        if (OriginalThreadCardView.this.hlN != null) {
                            OriginalThreadCardView.this.hlN.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.hlP = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.hlM = 0;
                    this.hlF.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.hlP) {
                        this.hlF.setPlaceHolder(2);
                    } else {
                        this.hlF.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.hlF.setVisibility(0);
                    this.hlF.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.hlM = 0;
                    this.hlF.setDefaultResource(R.drawable.icon_card_url_n);
                    this.hlF.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlF.setVisibility(0);
                    this.hlF.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.hlM = R.drawable.icon_share_play_n;
                    this.hlF.setDefaultResource(R.color.cp_bg_line_c);
                    this.hlF.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlF.setVisibility(0);
                    this.hlF.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.hlM = R.drawable.icon_share_card_live;
                    this.hlF.setDefaultResource(R.color.cp_bg_line_c);
                    this.hlF.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlF.setVisibility(0);
                    this.hlF.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.hlM = 0;
                    this.hlF.setVisibility(8);
                    break;
            }
            if (this.hlM != 0) {
                this.hlG.setVisibility(0);
                this.hlH.setVisibility(0);
                ap.setImageResource(this.hlG, this.hlM);
            } else {
                this.hlG.setVisibility(8);
                this.hlH.setVisibility(8);
            }
            this.mTitleView.setText((originalThreadInfo.dZh == null || originalThreadInfo.dZh.length() == 0) ? originalThreadInfo.showText : originalThreadInfo.dZh);
            b(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.hlM = 0;
                    this.hlF.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.hlP) {
                        this.hlF.setPlaceHolder(2);
                    } else {
                        this.hlF.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.hlF.setVisibility(0);
                    this.hlF.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.hlM = 0;
                    this.hlF.setDefaultResource(R.drawable.icon_card_url_n);
                    this.hlF.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlF.setVisibility(0);
                    this.hlF.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.hlM = R.drawable.icon_share_play_n;
                    this.hlF.setDefaultResource(R.color.cp_bg_line_c);
                    this.hlF.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlF.setVisibility(0);
                    this.hlF.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.hlM = R.drawable.icon_share_card_live;
                    this.hlF.setDefaultResource(R.color.cp_bg_line_c);
                    this.hlF.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlF.setVisibility(0);
                    this.hlF.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.hlM = 0;
                    this.hlF.setVisibility(8);
                    break;
            }
            if (this.hlM != 0) {
                this.hlG.setVisibility(0);
                this.hlH.setVisibility(0);
                ap.setImageResource(this.hlG, this.hlM);
            } else {
                this.hlG.setVisibility(8);
                this.hlH.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            b(shareInfo);
            this.ahO.setVisibility(8);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.hlN = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_j);
            if (this.hlM != 0) {
                ap.setImageResource(this.hlG, this.hlM);
            }
            setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.cp_bg_line_g)));
            this.hlI.setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.cp_bg_line_e)));
            this.ahO.onChangeSkinType(skinType);
            ap.setViewTextColor(this.hlJ, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hlL, R.color.cp_cont_d, 1);
            this.hlK.blq();
        }
    }

    public void setReadState(boolean z) {
        ap.setViewTextColor(this.mTitleView, z ? R.color.cp_cont_d : R.color.cp_cont_j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null && originalThreadInfo.showType == 4) {
            if (originalThreadInfo.threadType == 49) {
                d(originalThreadInfo);
            } else if (originalThreadInfo.threadType == 60) {
                if (originalThreadInfo.dZe != null) {
                    if (originalThreadInfo.dZe.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.dZe.share_info != null && originalThreadInfo.dZe.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.dZe != null && originalThreadInfo.dZe.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.dZe);
            if (originalThreadInfo.dZe.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.dZe.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData, null, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            if (ay.a(originalThreadInfo.oriUgcInfo)) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, null, null);
                pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                pbActivityConfig.setStartFrom(this.hlO);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.hlO);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }

    private void b(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        b(itemData);
        if (itemData != null) {
            this.hlJ.setText(itemData.mTitle);
            this.hlK.setStarCount(itemData.mStar);
            if (itemData.mScore > 0.0d && itemData.mScore <= 10.0d) {
                this.hlL.setText(itemData.mScore + "");
            } else {
                this.hlL.setText(R.string.frs_evaluate_exception);
            }
            if (this.hlF.getVisibility() == 8) {
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
        this.ahO.setVisibility(8);
        if (pollData != null && !com.baidu.tbadk.core.util.y.isEmpty(pollData.getOptions())) {
            this.ahO.setVisibility(0);
            this.ahO.setIsTransmit(true);
            this.ahO.setData(pollData, str, j);
        }
    }

    private void b(ItemData itemData) {
        if (itemData == null) {
            this.hlI.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.hlI.setVisibility(0);
        setPadding(ajB, ajB, ajB, hlR);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlI.getLayoutParams();
        if (this.hlF.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.hlI.setLayoutParams(layoutParams);
        this.hlK.setStarSpacing(hlQ);
        int i = hlS;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hlF.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.hlF.setLayoutParams(layoutParams2);
        this.hlH.setLayoutParams(layoutParams2);
        int i2 = afD;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hlG.getLayoutParams();
        layoutParams3.leftMargin = (i - i2) / 2;
        this.hlG.setLayoutParams(layoutParams3);
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
