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
    private VoteView ahQ;
    private TbImageView hlJ;
    private ImageView hlK;
    private ImageView hlL;
    private LinearLayout hlM;
    private TextView hlN;
    private RankStarView hlO;
    private TextView hlP;
    private int hlQ;
    private a hlR;
    public int hlS;
    public boolean hlT;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;
    private static final int hlU = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int ajD = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int hlV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int afF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    private static final int hlW = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* loaded from: classes15.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.hlT = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlT = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hlT = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.hlJ = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.hlK = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.hlL = (ImageView) findViewById(R.id.thread_pic_mask);
            this.hlJ.setLongIconSupport(false);
            this.hlJ.setGifIconSupport(false);
            this.hlJ.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.hlJ.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlJ.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.hlJ.setLayoutParams(layoutParams);
            this.hlL.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hlK.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.hlK.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
            this.hlM = (LinearLayout) findViewById(R.id.add_item);
            this.hlN = (TextView) findViewById(R.id.item_title);
            this.hlN.setMaxWidth(com.baidu.adp.lib.util.l.getScreenDimensions(context)[0] / 2);
            this.hlO = (RankStarView) findViewById(R.id.item_star);
            this.hlP = (TextView) findViewById(R.id.item_score);
            this.ahQ = (VoteView) findViewById(R.id.vote_view);
            this.ahQ.setBgColor(R.color.cp_bg_line_e);
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
                        if (OriginalThreadCardView.this.hlR != null) {
                            OriginalThreadCardView.this.hlR.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.hlT = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.hlQ = 0;
                    this.hlJ.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.hlT) {
                        this.hlJ.setPlaceHolder(2);
                    } else {
                        this.hlJ.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.hlJ.setVisibility(0);
                    this.hlJ.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.hlQ = 0;
                    this.hlJ.setDefaultResource(R.drawable.icon_card_url_n);
                    this.hlJ.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlJ.setVisibility(0);
                    this.hlJ.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.hlQ = R.drawable.icon_share_play_n;
                    this.hlJ.setDefaultResource(R.color.cp_bg_line_c);
                    this.hlJ.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlJ.setVisibility(0);
                    this.hlJ.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.hlQ = R.drawable.icon_share_card_live;
                    this.hlJ.setDefaultResource(R.color.cp_bg_line_c);
                    this.hlJ.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlJ.setVisibility(0);
                    this.hlJ.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.hlQ = 0;
                    this.hlJ.setVisibility(8);
                    break;
            }
            if (this.hlQ != 0) {
                this.hlK.setVisibility(0);
                this.hlL.setVisibility(0);
                ap.setImageResource(this.hlK, this.hlQ);
            } else {
                this.hlK.setVisibility(8);
                this.hlL.setVisibility(8);
            }
            this.mTitleView.setText((originalThreadInfo.dZl == null || originalThreadInfo.dZl.length() == 0) ? originalThreadInfo.showText : originalThreadInfo.dZl);
            b(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.hlQ = 0;
                    this.hlJ.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.hlT) {
                        this.hlJ.setPlaceHolder(2);
                    } else {
                        this.hlJ.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.hlJ.setVisibility(0);
                    this.hlJ.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.hlQ = 0;
                    this.hlJ.setDefaultResource(R.drawable.icon_card_url_n);
                    this.hlJ.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlJ.setVisibility(0);
                    this.hlJ.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.hlQ = R.drawable.icon_share_play_n;
                    this.hlJ.setDefaultResource(R.color.cp_bg_line_c);
                    this.hlJ.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlJ.setVisibility(0);
                    this.hlJ.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.hlQ = R.drawable.icon_share_card_live;
                    this.hlJ.setDefaultResource(R.color.cp_bg_line_c);
                    this.hlJ.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hlJ.setVisibility(0);
                    this.hlJ.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.hlQ = 0;
                    this.hlJ.setVisibility(8);
                    break;
            }
            if (this.hlQ != 0) {
                this.hlK.setVisibility(0);
                this.hlL.setVisibility(0);
                ap.setImageResource(this.hlK, this.hlQ);
            } else {
                this.hlK.setVisibility(8);
                this.hlL.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            b(shareInfo);
            this.ahQ.setVisibility(8);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.hlR = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_j);
            if (this.hlQ != 0) {
                ap.setImageResource(this.hlK, this.hlQ);
            }
            setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.cp_bg_line_g)));
            this.hlM.setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.cp_bg_line_e)));
            this.ahQ.onChangeSkinType(skinType);
            ap.setViewTextColor(this.hlN, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hlP, R.color.cp_cont_d, 1);
            this.hlO.blq();
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
                if (originalThreadInfo.dZi != null) {
                    if (originalThreadInfo.dZi.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.dZi.share_info != null && originalThreadInfo.dZi.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.dZi != null && originalThreadInfo.dZi.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.dZi);
            if (originalThreadInfo.dZi.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.dZi.user_info.user_name;
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
                pbActivityConfig.setStartFrom(this.hlS);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.hlS);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }

    private void b(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        b(itemData);
        if (itemData != null) {
            this.hlN.setText(itemData.mTitle);
            this.hlO.setStarCount(itemData.mStar);
            if (itemData.mScore > 0.0d && itemData.mScore <= 10.0d) {
                this.hlP.setText(itemData.mScore + "");
            } else {
                this.hlP.setText(R.string.frs_evaluate_exception);
            }
            if (this.hlJ.getVisibility() == 8) {
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
        this.ahQ.setVisibility(8);
        if (pollData != null && !com.baidu.tbadk.core.util.y.isEmpty(pollData.getOptions())) {
            this.ahQ.setVisibility(0);
            this.ahQ.setIsTransmit(true);
            this.ahQ.setData(pollData, str, j);
        }
    }

    private void b(ItemData itemData) {
        if (itemData == null) {
            this.hlM.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.hlM.setVisibility(0);
        setPadding(ajD, ajD, ajD, hlV);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlM.getLayoutParams();
        if (this.hlJ.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.hlM.setLayoutParams(layoutParams);
        this.hlO.setStarSpacing(hlU);
        int i = hlW;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hlJ.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.hlJ.setLayoutParams(layoutParams2);
        this.hlL.setLayoutParams(layoutParams2);
        int i2 = afF;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hlK.getLayoutParams();
        layoutParams3.leftMargin = (i - i2) / 2;
        this.hlK.setLayoutParams(layoutParams3);
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
