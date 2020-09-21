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
/* loaded from: classes20.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private VoteView ail;
    private TbImageView hsM;
    private ImageView hsN;
    private ImageView hsO;
    private LinearLayout hsP;
    private TextView hsQ;
    private RankStarView hsR;
    private TextView hsS;
    private int hsT;
    private a hsU;
    public int hsV;
    public boolean hsW;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;
    private static final int hsX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int akb = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int hsY = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int afX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    private static final int hsZ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* loaded from: classes20.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.hsW = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hsW = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hsW = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.hsM = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.hsN = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.hsO = (ImageView) findViewById(R.id.thread_pic_mask);
            this.hsM.setLongIconSupport(false);
            this.hsM.setGifIconSupport(false);
            this.hsM.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.hsM.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsM.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.hsM.setLayoutParams(layoutParams);
            this.hsO.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hsN.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.hsN.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
            this.hsP = (LinearLayout) findViewById(R.id.add_item);
            this.hsQ = (TextView) findViewById(R.id.item_title);
            this.hsQ.setMaxWidth(com.baidu.adp.lib.util.l.getScreenDimensions(context)[0] / 2);
            this.hsR = (RankStarView) findViewById(R.id.item_star);
            this.hsS = (TextView) findViewById(R.id.item_score);
            this.ail = (VoteView) findViewById(R.id.vote_view);
            this.ail.setBgColor(R.color.cp_bg_line_e);
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
                        if (OriginalThreadCardView.this.hsU != null) {
                            OriginalThreadCardView.this.hsU.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.hsW = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.hsT = 0;
                    this.hsM.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.hsW) {
                        this.hsM.setPlaceHolder(2);
                    } else {
                        this.hsM.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.hsM.setVisibility(0);
                    this.hsM.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.hsT = 0;
                    this.hsM.setDefaultResource(R.drawable.icon_card_url_n);
                    this.hsM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hsM.setVisibility(0);
                    this.hsM.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.hsT = R.drawable.icon_share_play_n;
                    this.hsM.setDefaultResource(R.color.cp_bg_line_c);
                    this.hsM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hsM.setVisibility(0);
                    this.hsM.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.hsT = R.drawable.icon_share_card_live;
                    this.hsM.setDefaultResource(R.color.cp_bg_line_c);
                    this.hsM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hsM.setVisibility(0);
                    this.hsM.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.hsT = 0;
                    this.hsM.setVisibility(8);
                    break;
            }
            if (this.hsT != 0) {
                this.hsN.setVisibility(0);
                this.hsO.setVisibility(0);
                ap.setImageResource(this.hsN, this.hsT);
            } else {
                this.hsN.setVisibility(8);
                this.hsO.setVisibility(8);
            }
            this.mTitleView.setText((originalThreadInfo.ebv == null || originalThreadInfo.ebv.length() == 0) ? originalThreadInfo.showText : originalThreadInfo.ebv);
            b(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.hsT = 0;
                    this.hsM.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.hsW) {
                        this.hsM.setPlaceHolder(2);
                    } else {
                        this.hsM.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.hsM.setVisibility(0);
                    this.hsM.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.hsT = 0;
                    this.hsM.setDefaultResource(R.drawable.icon_card_url_n);
                    this.hsM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hsM.setVisibility(0);
                    this.hsM.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.hsT = R.drawable.icon_share_play_n;
                    this.hsM.setDefaultResource(R.color.cp_bg_line_c);
                    this.hsM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hsM.setVisibility(0);
                    this.hsM.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.hsT = R.drawable.icon_share_card_live;
                    this.hsM.setDefaultResource(R.color.cp_bg_line_c);
                    this.hsM.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hsM.setVisibility(0);
                    this.hsM.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.hsT = 0;
                    this.hsM.setVisibility(8);
                    break;
            }
            if (this.hsT != 0) {
                this.hsN.setVisibility(0);
                this.hsO.setVisibility(0);
                ap.setImageResource(this.hsN, this.hsT);
            } else {
                this.hsN.setVisibility(8);
                this.hsO.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            b(shareInfo);
            this.ail.setVisibility(8);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.hsU = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_j);
            if (this.hsT != 0) {
                ap.setImageResource(this.hsN, this.hsT);
            }
            setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.cp_bg_line_g)));
            this.hsP.setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.cp_bg_line_e)));
            this.ail.onChangeSkinType(skinType);
            ap.setViewTextColor(this.hsQ, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hsS, R.color.cp_cont_d, 1);
            this.hsR.bml();
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
                if (originalThreadInfo.ebs != null) {
                    if (originalThreadInfo.ebs.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.ebs.share_info != null && originalThreadInfo.ebs.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.ebs != null && originalThreadInfo.ebs.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.ebs);
            if (originalThreadInfo.ebs.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.ebs.user_info.user_name;
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
                pbActivityConfig.setStartFrom(this.hsV);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.hsV);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }

    private void b(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        b(itemData);
        if (itemData != null) {
            this.hsQ.setText(itemData.mTitle);
            this.hsR.setStarCount(itemData.mStar);
            if (itemData.mScore > 0.0d && itemData.mScore <= 10.0d) {
                this.hsS.setText(itemData.mScore + "");
            } else {
                this.hsS.setText(R.string.frs_evaluate_exception);
            }
            if (this.hsM.getVisibility() == 8) {
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
        this.ail.setVisibility(8);
        if (pollData != null && !com.baidu.tbadk.core.util.y.isEmpty(pollData.getOptions())) {
            this.ail.setVisibility(0);
            this.ail.setIsTransmit(true);
            this.ail.setData(pollData, str, j);
        }
    }

    private void b(ItemData itemData) {
        if (itemData == null) {
            this.hsP.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.hsP.setVisibility(0);
        setPadding(akb, akb, akb, hsY);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsP.getLayoutParams();
        if (this.hsM.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.hsP.setLayoutParams(layoutParams);
        this.hsR.setStarSpacing(hsX);
        int i = hsZ;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hsM.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.hsM.setLayoutParams(layoutParams2);
        this.hsO.setLayoutParams(layoutParams2);
        int i2 = afX;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hsN.getLayoutParams();
        layoutParams3.leftMargin = (i - i2) / 2;
        this.hsN.setLayoutParams(layoutParams3);
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
