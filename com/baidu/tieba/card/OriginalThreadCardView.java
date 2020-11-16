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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private VoteView aiJ;
    private TbImageView iaB;
    private ImageView iaC;
    private ImageView iaD;
    private LinearLayout iaE;
    private TextView iaF;
    private RankStarView iaG;
    private TextView iaH;
    private int iaI;
    private a iaJ;
    public int iaK;
    public boolean iaL;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;
    private static final int iaM = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int akx = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int iaN = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int iaO = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    private static final int iaP = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* loaded from: classes20.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.iaL = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iaL = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iaL = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.iaB = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.iaC = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.iaD = (ImageView) findViewById(R.id.thread_pic_mask);
            this.iaB.setLongIconSupport(false);
            this.iaB.setGifIconSupport(false);
            this.iaB.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.iaB.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iaB.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.iaB.setLayoutParams(layoutParams);
            this.iaD.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iaC.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.iaC.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
            this.iaE = (LinearLayout) findViewById(R.id.add_item);
            this.iaF = (TextView) findViewById(R.id.item_title);
            this.iaF.setMaxWidth(com.baidu.adp.lib.util.l.getScreenDimensions(context)[0] / 2);
            this.iaG = (RankStarView) findViewById(R.id.item_star);
            this.iaH = (TextView) findViewById(R.id.item_score);
            this.aiJ = (VoteView) findViewById(R.id.vote_view);
            this.aiJ.setBgColor(R.color.CAM_X0207);
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
                        if (OriginalThreadCardView.this.iaJ != null) {
                            OriginalThreadCardView.this.iaJ.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.iaL = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.iaI = 0;
                    this.iaB.setDefaultResource(R.color.CAM_X0204);
                    if (this.iaL) {
                        this.iaB.setPlaceHolder(2);
                    } else {
                        this.iaB.setDefaultBgResource(R.color.CAM_X0209);
                    }
                    this.iaB.setVisibility(0);
                    this.iaB.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.iaI = 0;
                    this.iaB.setDefaultResource(R.drawable.icon_card_url_n);
                    this.iaB.setDefaultBgResource(R.color.CAM_X0209);
                    this.iaB.setVisibility(0);
                    this.iaB.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.iaI = R.drawable.icon_share_play_n;
                    this.iaB.setDefaultResource(R.color.CAM_X0204);
                    this.iaB.setDefaultBgResource(R.color.CAM_X0209);
                    this.iaB.setVisibility(0);
                    this.iaB.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.iaI = R.drawable.icon_share_card_live;
                    this.iaB.setDefaultResource(R.color.CAM_X0204);
                    this.iaB.setDefaultBgResource(R.color.CAM_X0209);
                    this.iaB.setVisibility(0);
                    this.iaB.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.iaI = 0;
                    this.iaB.setVisibility(8);
                    break;
            }
            if (this.iaI != 0) {
                this.iaC.setVisibility(0);
                this.iaD.setVisibility(0);
                ap.setImageResource(this.iaC, this.iaI);
            } else {
                this.iaC.setVisibility(8);
                this.iaD.setVisibility(8);
            }
            this.mTitleView.setText((originalThreadInfo.eAh == null || originalThreadInfo.eAh.length() == 0) ? originalThreadInfo.showText : originalThreadInfo.eAh);
            b(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.iaI = 0;
                    this.iaB.setDefaultResource(R.color.CAM_X0204);
                    if (this.iaL) {
                        this.iaB.setPlaceHolder(2);
                    } else {
                        this.iaB.setDefaultBgResource(R.color.CAM_X0209);
                    }
                    this.iaB.setVisibility(0);
                    this.iaB.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.iaI = 0;
                    this.iaB.setDefaultResource(R.drawable.icon_card_url_n);
                    this.iaB.setDefaultBgResource(R.color.CAM_X0209);
                    this.iaB.setVisibility(0);
                    this.iaB.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.iaI = R.drawable.icon_share_play_n;
                    this.iaB.setDefaultResource(R.color.CAM_X0204);
                    this.iaB.setDefaultBgResource(R.color.CAM_X0209);
                    this.iaB.setVisibility(0);
                    this.iaB.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.iaI = R.drawable.icon_share_card_live;
                    this.iaB.setDefaultResource(R.color.CAM_X0204);
                    this.iaB.setDefaultBgResource(R.color.CAM_X0209);
                    this.iaB.setVisibility(0);
                    this.iaB.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.iaI = 0;
                    this.iaB.setVisibility(8);
                    break;
            }
            if (this.iaI != 0) {
                this.iaC.setVisibility(0);
                this.iaD.setVisibility(0);
                ap.setImageResource(this.iaC, this.iaI);
            } else {
                this.iaC.setVisibility(8);
                this.iaD.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            b(shareInfo);
            this.aiJ.setVisibility(8);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.iaJ = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0107);
            if (this.iaI != 0) {
                ap.setImageResource(this.iaC, this.iaI);
            }
            setBackgroundDrawable(ap.aP(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.CAM_X0206)));
            this.iaE.setBackgroundDrawable(ap.aP(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.CAM_X0205)));
            this.aiJ.onChangeSkinType(skinType);
            ap.setViewTextColor(this.iaF, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.iaH, R.color.CAM_X0109, 1);
            this.iaG.bsE();
        }
    }

    public void setReadState(boolean z) {
        ap.setViewTextColor(this.mTitleView, z ? R.color.CAM_X0109 : R.color.CAM_X0107);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null && originalThreadInfo.showType == 4) {
            if (originalThreadInfo.threadType == 49) {
                d(originalThreadInfo);
            } else if (originalThreadInfo.threadType == 60) {
                if (originalThreadInfo.eAe != null) {
                    if (originalThreadInfo.eAe.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.eAe.share_info != null && originalThreadInfo.eAe.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.eAe != null && originalThreadInfo.eAe.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.eAe);
            if (originalThreadInfo.eAe.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.eAe.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData, null, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            if (az.a(originalThreadInfo.oriUgcInfo)) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, null, null);
                pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                pbActivityConfig.setStartFrom(this.iaK);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.iaK);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }

    private void b(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        b(itemData);
        if (itemData != null) {
            this.iaF.setText(itemData.mTitle);
            this.iaG.setStarCount(itemData.mStar);
            if (itemData.mScore > 0.0d && itemData.mScore <= 10.0d) {
                this.iaH.setText(itemData.mScore + "");
            } else {
                this.iaH.setText(R.string.frs_evaluate_exception);
            }
            if (this.iaB.getVisibility() == 8) {
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
        this.aiJ.setVisibility(8);
        if (pollData != null && !com.baidu.tbadk.core.util.y.isEmpty(pollData.getOptions())) {
            this.aiJ.setVisibility(0);
            this.aiJ.setIsTransmit(true);
            this.aiJ.setData(pollData, str, j);
        }
    }

    private void b(ItemData itemData) {
        if (itemData == null) {
            this.iaE.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.iaE.setVisibility(0);
        setPadding(akx, akx, akx, iaN);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iaE.getLayoutParams();
        if (this.iaB.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.iaE.setLayoutParams(layoutParams);
        this.iaG.setStarSpacing(iaM);
        int i = iaP;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iaB.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.iaB.setLayoutParams(layoutParams2);
        this.iaD.setLayoutParams(layoutParams2);
        int i2 = iaO;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iaC.getLayoutParams();
        layoutParams3.leftMargin = (i - i2) / 2;
        this.iaC.setLayoutParams(layoutParams3);
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
