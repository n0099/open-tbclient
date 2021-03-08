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
/* loaded from: classes.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private VoteView akA;
    private TbImageView iAU;
    private ImageView iAV;
    private ImageView iAW;
    private LinearLayout iAX;
    private TextView iAY;
    private RankStarView iAZ;
    private TextView iBa;
    private int iBb;
    private a iBc;
    public int iBd;
    public boolean iBe;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;
    private static final int iBf = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int amr = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int iBg = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int iBh = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    private static final int iBi = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* loaded from: classes.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.iBe = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iBe = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iBe = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.iAU = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.iAV = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.iAW = (ImageView) findViewById(R.id.thread_pic_mask);
            this.iAU.setLongIconSupport(false);
            this.iAU.setGifIconSupport(false);
            this.iAU.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.iAU.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iAU.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.iAU.setLayoutParams(layoutParams);
            this.iAW.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iAV.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.iAV.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
            this.iAX = (LinearLayout) findViewById(R.id.add_item);
            this.iAY = (TextView) findViewById(R.id.item_title);
            this.iAY.setMaxWidth(com.baidu.adp.lib.util.l.getScreenDimensions(context)[0] / 2);
            this.iAZ = (RankStarView) findViewById(R.id.item_star);
            this.iBa = (TextView) findViewById(R.id.item_score);
            this.akA = (VoteView) findViewById(R.id.vote_view);
            this.akA.setBgColor(R.color.CAM_X0207);
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
                        if (OriginalThreadCardView.this.iBc != null) {
                            OriginalThreadCardView.this.iBc.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.iBe = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.iBb = 0;
                    this.iAU.setDefaultResource(R.color.CAM_X0204);
                    if (this.iBe) {
                        this.iAU.setPlaceHolder(2);
                    } else {
                        this.iAU.setDefaultBgResource(R.color.CAM_X0209);
                    }
                    this.iAU.setVisibility(0);
                    this.iAU.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.iBb = 0;
                    this.iAU.setDefaultResource(R.drawable.icon_card_url_n);
                    this.iAU.setDefaultBgResource(R.color.CAM_X0209);
                    this.iAU.setVisibility(0);
                    this.iAU.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.iBb = R.drawable.icon_share_play_n;
                    this.iAU.setDefaultResource(R.color.CAM_X0204);
                    this.iAU.setDefaultBgResource(R.color.CAM_X0209);
                    this.iAU.setVisibility(0);
                    this.iAU.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.iBb = R.drawable.icon_share_card_live;
                    this.iAU.setDefaultResource(R.color.CAM_X0204);
                    this.iAU.setDefaultBgResource(R.color.CAM_X0209);
                    this.iAU.setVisibility(0);
                    this.iAU.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.iBb = 0;
                    this.iAU.setVisibility(8);
                    break;
            }
            if (this.iBb != 0) {
                this.iAV.setVisibility(0);
                this.iAW.setVisibility(0);
                ap.setImageResource(this.iAV, this.iBb);
            } else {
                this.iAV.setVisibility(8);
                this.iAW.setVisibility(8);
            }
            this.mTitleView.setText((originalThreadInfo.ePZ == null || originalThreadInfo.ePZ.length() == 0) ? originalThreadInfo.showText : originalThreadInfo.ePZ);
            b(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.iBb = 0;
                    this.iAU.setDefaultResource(R.color.CAM_X0204);
                    if (this.iBe) {
                        this.iAU.setPlaceHolder(2);
                    } else {
                        this.iAU.setDefaultBgResource(R.color.CAM_X0209);
                    }
                    this.iAU.setVisibility(0);
                    this.iAU.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.iBb = 0;
                    this.iAU.setDefaultResource(R.drawable.icon_card_url_n);
                    this.iAU.setDefaultBgResource(R.color.CAM_X0209);
                    this.iAU.setVisibility(0);
                    this.iAU.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.iBb = R.drawable.icon_share_play_n;
                    this.iAU.setDefaultResource(R.color.CAM_X0204);
                    this.iAU.setDefaultBgResource(R.color.CAM_X0209);
                    this.iAU.setVisibility(0);
                    this.iAU.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.iBb = R.drawable.icon_share_card_live;
                    this.iAU.setDefaultResource(R.color.CAM_X0204);
                    this.iAU.setDefaultBgResource(R.color.CAM_X0209);
                    this.iAU.setVisibility(0);
                    this.iAU.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.iBb = 0;
                    this.iAU.setVisibility(8);
                    break;
            }
            if (this.iBb != 0) {
                this.iAV.setVisibility(0);
                this.iAW.setVisibility(0);
                ap.setImageResource(this.iAV, this.iBb);
            } else {
                this.iAV.setVisibility(8);
                this.iAW.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            b(shareInfo);
            this.akA.setVisibility(8);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.iBc = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0107);
            if (this.iBb != 0) {
                ap.setImageResource(this.iAV, this.iBb);
            }
            setBackgroundDrawable(ap.aL(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.CAM_X0206)));
            this.iAX.setBackgroundDrawable(ap.aL(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.CAM_X0205)));
            this.akA.onChangeSkinType(skinType);
            ap.setViewTextColor(this.iAY, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.iBa, R.color.CAM_X0109, 1);
            this.iAZ.bvc();
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
                if (originalThreadInfo.ePW != null) {
                    if (originalThreadInfo.ePW.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.ePW.share_info != null && originalThreadInfo.ePW.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.ePW != null && originalThreadInfo.ePW.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.ePW);
            if (originalThreadInfo.ePW.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.ePW.user_info.user_name;
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
                pbActivityConfig.setStartFrom(this.iBd);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.iBd);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }

    private void b(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        b(itemData);
        if (itemData != null) {
            this.iAY.setText(itemData.mTitle);
            this.iAZ.setStarCount(itemData.mStar);
            if (itemData.mScore > 0.0d && itemData.mScore <= 10.0d) {
                this.iBa.setText(itemData.mScore + "");
            } else {
                this.iBa.setText(R.string.frs_evaluate_exception);
            }
            if (this.iAU.getVisibility() == 8) {
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
        this.akA.setVisibility(8);
        if (pollData != null && !com.baidu.tbadk.core.util.y.isEmpty(pollData.getOptions())) {
            this.akA.setVisibility(0);
            this.akA.setIsTransmit(true);
            this.akA.setData(pollData, str, j);
        }
    }

    private void b(ItemData itemData) {
        if (itemData == null) {
            this.iAX.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.iAX.setVisibility(0);
        setPadding(amr, amr, amr, iBg);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iAX.getLayoutParams();
        if (this.iAU.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.iAX.setLayoutParams(layoutParams);
        this.iAZ.setStarSpacing(iBf);
        int i = iBi;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iAU.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.iAU.setLayoutParams(layoutParams2);
        this.iAW.setLayoutParams(layoutParams2);
        int i2 = iBh;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iAV.getLayoutParams();
        layoutParams3.leftMargin = (i - i2) / 2;
        this.iAV.setLayoutParams(layoutParams3);
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
