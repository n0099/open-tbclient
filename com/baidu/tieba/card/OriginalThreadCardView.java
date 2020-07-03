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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private VoteView agO;
    private TbImageView gTh;
    private ImageView gTi;
    private ImageView gTj;
    private LinearLayout gTk;
    private TextView gTl;
    private RankStarView gTm;
    private TextView gTn;
    private int gTo;
    private a gTp;
    public int gTq;
    public boolean gTr;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;
    private static final int gTs = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int aiu = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int gTt = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int aeE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    private static final int gTu = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* loaded from: classes8.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.gTr = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gTr = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gTr = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.gTh = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.gTi = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.gTj = (ImageView) findViewById(R.id.thread_pic_mask);
            this.gTh.setLongIconSupport(false);
            this.gTh.setGifIconSupport(false);
            this.gTh.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.gTh.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gTh.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.gTh.setLayoutParams(layoutParams);
            this.gTj.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gTi.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.gTi.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
            this.gTk = (LinearLayout) findViewById(R.id.add_item);
            this.gTl = (TextView) findViewById(R.id.item_title);
            this.gTl.setMaxWidth(com.baidu.adp.lib.util.l.getScreenDimensions(context)[0] / 2);
            this.gTm = (RankStarView) findViewById(R.id.item_star);
            this.gTn = (TextView) findViewById(R.id.item_score);
            this.agO = (VoteView) findViewById(R.id.vote_view);
            this.agO.setBgColor(R.color.cp_bg_line_e);
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
                        if (OriginalThreadCardView.this.gTp != null) {
                            OriginalThreadCardView.this.gTp.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.gTr = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.gTo = 0;
                    this.gTh.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.gTr) {
                        this.gTh.setPlaceHolder(2);
                    } else {
                        this.gTh.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.gTh.setVisibility(0);
                    this.gTh.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.gTo = 0;
                    this.gTh.setDefaultResource(R.drawable.icon_card_url_n);
                    this.gTh.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gTh.setVisibility(0);
                    this.gTh.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.gTo = R.drawable.icon_share_play_n;
                    this.gTh.setDefaultResource(R.color.cp_bg_line_c);
                    this.gTh.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gTh.setVisibility(0);
                    this.gTh.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.gTo = R.drawable.icon_share_card_live;
                    this.gTh.setDefaultResource(R.color.cp_bg_line_c);
                    this.gTh.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gTh.setVisibility(0);
                    this.gTh.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.gTo = 0;
                    this.gTh.setVisibility(8);
                    break;
            }
            if (this.gTo != 0) {
                this.gTi.setVisibility(0);
                this.gTj.setVisibility(0);
                an.setImageResource(this.gTi, this.gTo);
            } else {
                this.gTi.setVisibility(8);
                this.gTj.setVisibility(8);
            }
            this.mTitleView.setText((originalThreadInfo.dJC == null || originalThreadInfo.dJC.length() == 0) ? originalThreadInfo.showText : originalThreadInfo.dJC);
            b(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.gTo = 0;
                    this.gTh.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.gTr) {
                        this.gTh.setPlaceHolder(2);
                    } else {
                        this.gTh.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.gTh.setVisibility(0);
                    this.gTh.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.gTo = 0;
                    this.gTh.setDefaultResource(R.drawable.icon_card_url_n);
                    this.gTh.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gTh.setVisibility(0);
                    this.gTh.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.gTo = R.drawable.icon_share_play_n;
                    this.gTh.setDefaultResource(R.color.cp_bg_line_c);
                    this.gTh.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gTh.setVisibility(0);
                    this.gTh.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.gTo = R.drawable.icon_share_card_live;
                    this.gTh.setDefaultResource(R.color.cp_bg_line_c);
                    this.gTh.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gTh.setVisibility(0);
                    this.gTh.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.gTo = 0;
                    this.gTh.setVisibility(8);
                    break;
            }
            if (this.gTo != 0) {
                this.gTi.setVisibility(0);
                this.gTj.setVisibility(0);
                an.setImageResource(this.gTi, this.gTo);
            } else {
                this.gTi.setVisibility(8);
                this.gTj.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            b(shareInfo);
            this.agO.setVisibility(8);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.gTp = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            an.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_j);
            if (this.gTo != 0) {
                an.setImageResource(this.gTi, this.gTo);
            }
            setBackgroundDrawable(an.aG(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), an.getColor(R.color.cp_bg_line_g)));
            this.gTk.setBackgroundDrawable(an.aG(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), an.getColor(R.color.cp_bg_line_e)));
            this.agO.onChangeSkinType(skinType);
            an.setViewTextColor(this.gTl, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.gTn, R.color.cp_cont_d, 1);
            this.gTm.aYW();
        }
    }

    public void setReadState(boolean z) {
        an.setViewTextColor(this.mTitleView, z ? R.color.cp_cont_d : R.color.cp_cont_j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null && originalThreadInfo.showType == 4) {
            if (originalThreadInfo.threadType == 49) {
                d(originalThreadInfo);
            } else if (originalThreadInfo.threadType == 60) {
                if (originalThreadInfo.dJz != null) {
                    if (originalThreadInfo.dJz.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.dJz.share_info != null && originalThreadInfo.dJz.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.dJz != null && originalThreadInfo.dJz.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.dJz);
            if (originalThreadInfo.dJz.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.dJz.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData, null, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            if (aw.a(originalThreadInfo.oriUgcInfo)) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, null, null);
                pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                pbActivityConfig.setStartFrom(this.gTq);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.gTq);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }

    private void b(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        b(itemData);
        if (itemData != null) {
            this.gTl.setText(itemData.mTitle);
            this.gTm.setStarCount(itemData.mStar);
            if (itemData.mScore > 0.0d && itemData.mScore <= 10.0d) {
                this.gTn.setText(itemData.mScore + "");
            } else {
                this.gTn.setText(R.string.frs_evaluate_exception);
            }
            if (this.gTh.getVisibility() == 8) {
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
        this.agO.setVisibility(8);
        if (pollData != null && !com.baidu.tbadk.core.util.w.isEmpty(pollData.getOptions())) {
            this.agO.setVisibility(0);
            this.agO.setIsTransmit(true);
            this.agO.setData(pollData, str, j);
        }
    }

    private void b(ItemData itemData) {
        if (itemData == null) {
            this.gTk.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.gTk.setVisibility(0);
        setPadding(aiu, aiu, aiu, gTt);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gTk.getLayoutParams();
        if (this.gTh.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.gTk.setLayoutParams(layoutParams);
        this.gTm.setStarSpacing(gTs);
        int i = gTu;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gTh.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.gTh.setLayoutParams(layoutParams2);
        this.gTj.setLayoutParams(layoutParams2);
        int i2 = aeE;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gTi.getLayoutParams();
        layoutParams3.leftMargin = (i - i2) / 2;
        this.gTi.setLayoutParams(layoutParams3);
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
