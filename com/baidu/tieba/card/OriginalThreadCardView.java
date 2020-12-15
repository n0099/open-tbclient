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
/* loaded from: classes21.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private VoteView ajI;
    private ImageView ilA;
    private ImageView ilB;
    private LinearLayout ilC;
    private TextView ilD;
    private RankStarView ilE;
    private TextView ilF;
    private int ilG;
    private a ilH;
    public int ilI;
    public boolean ilJ;
    private TbImageView ilz;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;
    private static final int ilK = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int aly = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int ilL = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int ilM = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    private static final int ilN = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* loaded from: classes21.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.ilJ = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ilJ = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilJ = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.ilz = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.ilA = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.ilB = (ImageView) findViewById(R.id.thread_pic_mask);
            this.ilz.setLongIconSupport(false);
            this.ilz.setGifIconSupport(false);
            this.ilz.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.ilz.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilz.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.ilz.setLayoutParams(layoutParams);
            this.ilB.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ilA.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.ilA.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
            this.ilC = (LinearLayout) findViewById(R.id.add_item);
            this.ilD = (TextView) findViewById(R.id.item_title);
            this.ilD.setMaxWidth(com.baidu.adp.lib.util.l.getScreenDimensions(context)[0] / 2);
            this.ilE = (RankStarView) findViewById(R.id.item_star);
            this.ilF = (TextView) findViewById(R.id.item_score);
            this.ajI = (VoteView) findViewById(R.id.vote_view);
            this.ajI.setBgColor(R.color.CAM_X0207);
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
                        if (OriginalThreadCardView.this.ilH != null) {
                            OriginalThreadCardView.this.ilH.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.ilJ = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.ilG = 0;
                    this.ilz.setDefaultResource(R.color.CAM_X0204);
                    if (this.ilJ) {
                        this.ilz.setPlaceHolder(2);
                    } else {
                        this.ilz.setDefaultBgResource(R.color.CAM_X0209);
                    }
                    this.ilz.setVisibility(0);
                    this.ilz.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.ilG = 0;
                    this.ilz.setDefaultResource(R.drawable.icon_card_url_n);
                    this.ilz.setDefaultBgResource(R.color.CAM_X0209);
                    this.ilz.setVisibility(0);
                    this.ilz.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.ilG = R.drawable.icon_share_play_n;
                    this.ilz.setDefaultResource(R.color.CAM_X0204);
                    this.ilz.setDefaultBgResource(R.color.CAM_X0209);
                    this.ilz.setVisibility(0);
                    this.ilz.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.ilG = R.drawable.icon_share_card_live;
                    this.ilz.setDefaultResource(R.color.CAM_X0204);
                    this.ilz.setDefaultBgResource(R.color.CAM_X0209);
                    this.ilz.setVisibility(0);
                    this.ilz.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.ilG = 0;
                    this.ilz.setVisibility(8);
                    break;
            }
            if (this.ilG != 0) {
                this.ilA.setVisibility(0);
                this.ilB.setVisibility(0);
                ap.setImageResource(this.ilA, this.ilG);
            } else {
                this.ilA.setVisibility(8);
                this.ilB.setVisibility(8);
            }
            this.mTitleView.setText((originalThreadInfo.eHg == null || originalThreadInfo.eHg.length() == 0) ? originalThreadInfo.showText : originalThreadInfo.eHg);
            b(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.ilG = 0;
                    this.ilz.setDefaultResource(R.color.CAM_X0204);
                    if (this.ilJ) {
                        this.ilz.setPlaceHolder(2);
                    } else {
                        this.ilz.setDefaultBgResource(R.color.CAM_X0209);
                    }
                    this.ilz.setVisibility(0);
                    this.ilz.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.ilG = 0;
                    this.ilz.setDefaultResource(R.drawable.icon_card_url_n);
                    this.ilz.setDefaultBgResource(R.color.CAM_X0209);
                    this.ilz.setVisibility(0);
                    this.ilz.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.ilG = R.drawable.icon_share_play_n;
                    this.ilz.setDefaultResource(R.color.CAM_X0204);
                    this.ilz.setDefaultBgResource(R.color.CAM_X0209);
                    this.ilz.setVisibility(0);
                    this.ilz.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.ilG = R.drawable.icon_share_card_live;
                    this.ilz.setDefaultResource(R.color.CAM_X0204);
                    this.ilz.setDefaultBgResource(R.color.CAM_X0209);
                    this.ilz.setVisibility(0);
                    this.ilz.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.ilG = 0;
                    this.ilz.setVisibility(8);
                    break;
            }
            if (this.ilG != 0) {
                this.ilA.setVisibility(0);
                this.ilB.setVisibility(0);
                ap.setImageResource(this.ilA, this.ilG);
            } else {
                this.ilA.setVisibility(8);
                this.ilB.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            b(shareInfo);
            this.ajI.setVisibility(8);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.ilH = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0107);
            if (this.ilG != 0) {
                ap.setImageResource(this.ilA, this.ilG);
            }
            setBackgroundDrawable(ap.aR(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.CAM_X0206)));
            this.ilC.setBackgroundDrawable(ap.aR(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.CAM_X0205)));
            this.ajI.onChangeSkinType(skinType);
            ap.setViewTextColor(this.ilD, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ilF, R.color.CAM_X0109, 1);
            this.ilE.bwe();
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
                if (originalThreadInfo.eHd != null) {
                    if (originalThreadInfo.eHd.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.eHd.share_info != null && originalThreadInfo.eHd.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.eHd != null && originalThreadInfo.eHd.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.eHd);
            if (originalThreadInfo.eHd.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.eHd.user_info.user_name;
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
                pbActivityConfig.setStartFrom(this.ilI);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.ilI);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }

    private void b(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        b(itemData);
        if (itemData != null) {
            this.ilD.setText(itemData.mTitle);
            this.ilE.setStarCount(itemData.mStar);
            if (itemData.mScore > 0.0d && itemData.mScore <= 10.0d) {
                this.ilF.setText(itemData.mScore + "");
            } else {
                this.ilF.setText(R.string.frs_evaluate_exception);
            }
            if (this.ilz.getVisibility() == 8) {
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
        this.ajI.setVisibility(8);
        if (pollData != null && !com.baidu.tbadk.core.util.y.isEmpty(pollData.getOptions())) {
            this.ajI.setVisibility(0);
            this.ajI.setIsTransmit(true);
            this.ajI.setData(pollData, str, j);
        }
    }

    private void b(ItemData itemData) {
        if (itemData == null) {
            this.ilC.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.ilC.setVisibility(0);
        setPadding(aly, aly, aly, ilL);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilC.getLayoutParams();
        if (this.ilz.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.ilC.setLayoutParams(layoutParams);
        this.ilE.setStarSpacing(ilK);
        int i = ilN;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ilz.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.ilz.setLayoutParams(layoutParams2);
        this.ilB.setLayoutParams(layoutParams2);
        int i2 = ilM;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ilA.getLayoutParams();
        layoutParams3.leftMargin = (i - i2) / 2;
        this.ilA.setLayoutParams(layoutParams3);
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
