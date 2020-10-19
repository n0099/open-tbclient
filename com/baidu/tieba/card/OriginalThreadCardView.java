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
/* loaded from: classes21.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private VoteView aiD;
    private TbImageView hHG;
    private ImageView hHH;
    private ImageView hHI;
    private LinearLayout hHJ;
    private TextView hHK;
    private RankStarView hHL;
    private TextView hHM;
    private int hHN;
    private a hHO;
    public int hHP;
    public boolean hHQ;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;
    private static final int hHR = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int akt = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int hHS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int agp = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    private static final int hHT = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* loaded from: classes21.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.hHQ = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hHQ = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hHQ = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.hHG = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.hHH = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.hHI = (ImageView) findViewById(R.id.thread_pic_mask);
            this.hHG.setLongIconSupport(false);
            this.hHG.setGifIconSupport(false);
            this.hHG.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.hHG.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHG.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.hHG.setLayoutParams(layoutParams);
            this.hHI.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hHH.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.hHH.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
            this.hHJ = (LinearLayout) findViewById(R.id.add_item);
            this.hHK = (TextView) findViewById(R.id.item_title);
            this.hHK.setMaxWidth(com.baidu.adp.lib.util.l.getScreenDimensions(context)[0] / 2);
            this.hHL = (RankStarView) findViewById(R.id.item_star);
            this.hHM = (TextView) findViewById(R.id.item_score);
            this.aiD = (VoteView) findViewById(R.id.vote_view);
            this.aiD.setBgColor(R.color.cp_bg_line_e);
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
                        if (OriginalThreadCardView.this.hHO != null) {
                            OriginalThreadCardView.this.hHO.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.hHQ = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.hHN = 0;
                    this.hHG.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.hHQ) {
                        this.hHG.setPlaceHolder(2);
                    } else {
                        this.hHG.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.hHG.setVisibility(0);
                    this.hHG.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.hHN = 0;
                    this.hHG.setDefaultResource(R.drawable.icon_card_url_n);
                    this.hHG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hHG.setVisibility(0);
                    this.hHG.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.hHN = R.drawable.icon_share_play_n;
                    this.hHG.setDefaultResource(R.color.cp_bg_line_c);
                    this.hHG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hHG.setVisibility(0);
                    this.hHG.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.hHN = R.drawable.icon_share_card_live;
                    this.hHG.setDefaultResource(R.color.cp_bg_line_c);
                    this.hHG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hHG.setVisibility(0);
                    this.hHG.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.hHN = 0;
                    this.hHG.setVisibility(8);
                    break;
            }
            if (this.hHN != 0) {
                this.hHH.setVisibility(0);
                this.hHI.setVisibility(0);
                ap.setImageResource(this.hHH, this.hHN);
            } else {
                this.hHH.setVisibility(8);
                this.hHI.setVisibility(8);
            }
            this.mTitleView.setText((originalThreadInfo.enz == null || originalThreadInfo.enz.length() == 0) ? originalThreadInfo.showText : originalThreadInfo.enz);
            b(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.hHN = 0;
                    this.hHG.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.hHQ) {
                        this.hHG.setPlaceHolder(2);
                    } else {
                        this.hHG.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.hHG.setVisibility(0);
                    this.hHG.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.hHN = 0;
                    this.hHG.setDefaultResource(R.drawable.icon_card_url_n);
                    this.hHG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hHG.setVisibility(0);
                    this.hHG.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.hHN = R.drawable.icon_share_play_n;
                    this.hHG.setDefaultResource(R.color.cp_bg_line_c);
                    this.hHG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hHG.setVisibility(0);
                    this.hHG.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.hHN = R.drawable.icon_share_card_live;
                    this.hHG.setDefaultResource(R.color.cp_bg_line_c);
                    this.hHG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hHG.setVisibility(0);
                    this.hHG.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.hHN = 0;
                    this.hHG.setVisibility(8);
                    break;
            }
            if (this.hHN != 0) {
                this.hHH.setVisibility(0);
                this.hHI.setVisibility(0);
                ap.setImageResource(this.hHH, this.hHN);
            } else {
                this.hHH.setVisibility(8);
                this.hHI.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            b(shareInfo);
            this.aiD.setVisibility(8);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.hHO = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_j);
            if (this.hHN != 0) {
                ap.setImageResource(this.hHH, this.hHN);
            }
            setBackgroundDrawable(ap.aN(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.cp_bg_line_g)));
            this.hHJ.setBackgroundDrawable(ap.aN(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.cp_bg_line_e)));
            this.aiD.onChangeSkinType(skinType);
            ap.setViewTextColor(this.hHK, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hHM, R.color.cp_cont_d, 1);
            this.hHL.boV();
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
                if (originalThreadInfo.enw != null) {
                    if (originalThreadInfo.enw.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.enw.share_info != null && originalThreadInfo.enw.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.enw != null && originalThreadInfo.enw.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.enw);
            if (originalThreadInfo.enw.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.enw.user_info.user_name;
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
                pbActivityConfig.setStartFrom(this.hHP);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.hHP);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }

    private void b(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        b(itemData);
        if (itemData != null) {
            this.hHK.setText(itemData.mTitle);
            this.hHL.setStarCount(itemData.mStar);
            if (itemData.mScore > 0.0d && itemData.mScore <= 10.0d) {
                this.hHM.setText(itemData.mScore + "");
            } else {
                this.hHM.setText(R.string.frs_evaluate_exception);
            }
            if (this.hHG.getVisibility() == 8) {
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
        this.aiD.setVisibility(8);
        if (pollData != null && !com.baidu.tbadk.core.util.y.isEmpty(pollData.getOptions())) {
            this.aiD.setVisibility(0);
            this.aiD.setIsTransmit(true);
            this.aiD.setData(pollData, str, j);
        }
    }

    private void b(ItemData itemData) {
        if (itemData == null) {
            this.hHJ.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.hHJ.setVisibility(0);
        setPadding(akt, akt, akt, hHS);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHJ.getLayoutParams();
        if (this.hHG.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.hHJ.setLayoutParams(layoutParams);
        this.hHL.setStarSpacing(hHR);
        int i = hHT;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hHG.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.hHG.setLayoutParams(layoutParams2);
        this.hHI.setLayoutParams(layoutParams2);
        int i2 = agp;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hHH.getLayoutParams();
        layoutParams3.leftMargin = (i - i2) / 2;
        this.hHH.setLayoutParams(layoutParams3);
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
