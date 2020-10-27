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
    private VoteView aiE;
    private TbImageView hUd;
    private ImageView hUe;
    private ImageView hUf;
    private LinearLayout hUg;
    private TextView hUh;
    private RankStarView hUi;
    private TextView hUj;
    private int hUk;
    private a hUl;
    public int hUm;
    public boolean hUn;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;
    private static final int hUo = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int aku = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int hUp = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int agq = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    private static final int hUq = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* loaded from: classes21.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.hUn = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hUn = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hUn = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.hUd = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.hUe = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.hUf = (ImageView) findViewById(R.id.thread_pic_mask);
            this.hUd.setLongIconSupport(false);
            this.hUd.setGifIconSupport(false);
            this.hUd.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.hUd.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hUd.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.hUd.setLayoutParams(layoutParams);
            this.hUf.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hUe.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.hUe.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
            this.hUg = (LinearLayout) findViewById(R.id.add_item);
            this.hUh = (TextView) findViewById(R.id.item_title);
            this.hUh.setMaxWidth(com.baidu.adp.lib.util.l.getScreenDimensions(context)[0] / 2);
            this.hUi = (RankStarView) findViewById(R.id.item_star);
            this.hUj = (TextView) findViewById(R.id.item_score);
            this.aiE = (VoteView) findViewById(R.id.vote_view);
            this.aiE.setBgColor(R.color.cp_bg_line_e);
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
                        if (OriginalThreadCardView.this.hUl != null) {
                            OriginalThreadCardView.this.hUl.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.hUn = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.hUk = 0;
                    this.hUd.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.hUn) {
                        this.hUd.setPlaceHolder(2);
                    } else {
                        this.hUd.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.hUd.setVisibility(0);
                    this.hUd.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.hUk = 0;
                    this.hUd.setDefaultResource(R.drawable.icon_card_url_n);
                    this.hUd.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hUd.setVisibility(0);
                    this.hUd.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.hUk = R.drawable.icon_share_play_n;
                    this.hUd.setDefaultResource(R.color.cp_bg_line_c);
                    this.hUd.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hUd.setVisibility(0);
                    this.hUd.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.hUk = R.drawable.icon_share_card_live;
                    this.hUd.setDefaultResource(R.color.cp_bg_line_c);
                    this.hUd.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hUd.setVisibility(0);
                    this.hUd.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.hUk = 0;
                    this.hUd.setVisibility(8);
                    break;
            }
            if (this.hUk != 0) {
                this.hUe.setVisibility(0);
                this.hUf.setVisibility(0);
                ap.setImageResource(this.hUe, this.hUk);
            } else {
                this.hUe.setVisibility(8);
                this.hUf.setVisibility(8);
            }
            this.mTitleView.setText((originalThreadInfo.evX == null || originalThreadInfo.evX.length() == 0) ? originalThreadInfo.showText : originalThreadInfo.evX);
            b(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.hUk = 0;
                    this.hUd.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.hUn) {
                        this.hUd.setPlaceHolder(2);
                    } else {
                        this.hUd.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.hUd.setVisibility(0);
                    this.hUd.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.hUk = 0;
                    this.hUd.setDefaultResource(R.drawable.icon_card_url_n);
                    this.hUd.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hUd.setVisibility(0);
                    this.hUd.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.hUk = R.drawable.icon_share_play_n;
                    this.hUd.setDefaultResource(R.color.cp_bg_line_c);
                    this.hUd.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hUd.setVisibility(0);
                    this.hUd.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.hUk = R.drawable.icon_share_card_live;
                    this.hUd.setDefaultResource(R.color.cp_bg_line_c);
                    this.hUd.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.hUd.setVisibility(0);
                    this.hUd.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.hUk = 0;
                    this.hUd.setVisibility(8);
                    break;
            }
            if (this.hUk != 0) {
                this.hUe.setVisibility(0);
                this.hUf.setVisibility(0);
                ap.setImageResource(this.hUe, this.hUk);
            } else {
                this.hUe.setVisibility(8);
                this.hUf.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            b(shareInfo);
            this.aiE.setVisibility(8);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.hUl = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_j);
            if (this.hUk != 0) {
                ap.setImageResource(this.hUe, this.hUk);
            }
            setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.cp_bg_line_g)));
            this.hUg.setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ap.getColor(R.color.cp_bg_line_e)));
            this.aiE.onChangeSkinType(skinType);
            ap.setViewTextColor(this.hUh, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hUj, R.color.cp_cont_d, 1);
            this.hUi.bqO();
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
                if (originalThreadInfo.evU != null) {
                    if (originalThreadInfo.evU.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.evU.share_info != null && originalThreadInfo.evU.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.evU != null && originalThreadInfo.evU.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.evU);
            if (originalThreadInfo.evU.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.evU.user_info.user_name;
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
                pbActivityConfig.setStartFrom(this.hUm);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.hUm);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }

    private void b(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        b(itemData);
        if (itemData != null) {
            this.hUh.setText(itemData.mTitle);
            this.hUi.setStarCount(itemData.mStar);
            if (itemData.mScore > 0.0d && itemData.mScore <= 10.0d) {
                this.hUj.setText(itemData.mScore + "");
            } else {
                this.hUj.setText(R.string.frs_evaluate_exception);
            }
            if (this.hUd.getVisibility() == 8) {
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
        this.aiE.setVisibility(8);
        if (pollData != null && !com.baidu.tbadk.core.util.y.isEmpty(pollData.getOptions())) {
            this.aiE.setVisibility(0);
            this.aiE.setIsTransmit(true);
            this.aiE.setData(pollData, str, j);
        }
    }

    private void b(ItemData itemData) {
        if (itemData == null) {
            this.hUg.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.hUg.setVisibility(0);
        setPadding(aku, aku, aku, hUp);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hUg.getLayoutParams();
        if (this.hUd.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.hUg.setLayoutParams(layoutParams);
        this.hUi.setStarSpacing(hUo);
        int i = hUq;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hUd.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.hUd.setLayoutParams(layoutParams2);
        this.hUf.setLayoutParams(layoutParams2);
        int i2 = agq;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hUe.getLayoutParams();
        layoutParams3.leftMargin = (i - i2) / 2;
        this.hUe.setLayoutParams(layoutParams3);
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
