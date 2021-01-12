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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private VoteView ajt;
    private TbImageView itn;
    private ImageView ito;
    private ImageView itp;
    private LinearLayout itq;
    private TextView itr;
    private RankStarView its;
    private TextView itt;
    private int itu;
    private a itv;
    public int itw;
    public boolean itx;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;
    private static final int ity = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int ali = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int itz = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int itA = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    private static final int itB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* loaded from: classes.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.itx = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.itx = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.itx = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.itn = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.ito = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.itp = (ImageView) findViewById(R.id.thread_pic_mask);
            this.itn.setLongIconSupport(false);
            this.itn.setGifIconSupport(false);
            this.itn.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.itn.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.itn.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.itn.setLayoutParams(layoutParams);
            this.itp.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ito.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.ito.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
            this.itq = (LinearLayout) findViewById(R.id.add_item);
            this.itr = (TextView) findViewById(R.id.item_title);
            this.itr.setMaxWidth(com.baidu.adp.lib.util.l.getScreenDimensions(context)[0] / 2);
            this.its = (RankStarView) findViewById(R.id.item_star);
            this.itt = (TextView) findViewById(R.id.item_score);
            this.ajt = (VoteView) findViewById(R.id.vote_view);
            this.ajt.setBgColor(R.color.CAM_X0207);
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
                        if (OriginalThreadCardView.this.itv != null) {
                            OriginalThreadCardView.this.itv.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.itx = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.itu = 0;
                    this.itn.setDefaultResource(R.color.CAM_X0204);
                    if (this.itx) {
                        this.itn.setPlaceHolder(2);
                    } else {
                        this.itn.setDefaultBgResource(R.color.CAM_X0209);
                    }
                    this.itn.setVisibility(0);
                    this.itn.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.itu = 0;
                    this.itn.setDefaultResource(R.drawable.icon_card_url_n);
                    this.itn.setDefaultBgResource(R.color.CAM_X0209);
                    this.itn.setVisibility(0);
                    this.itn.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.itu = R.drawable.icon_share_play_n;
                    this.itn.setDefaultResource(R.color.CAM_X0204);
                    this.itn.setDefaultBgResource(R.color.CAM_X0209);
                    this.itn.setVisibility(0);
                    this.itn.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.itu = R.drawable.icon_share_card_live;
                    this.itn.setDefaultResource(R.color.CAM_X0204);
                    this.itn.setDefaultBgResource(R.color.CAM_X0209);
                    this.itn.setVisibility(0);
                    this.itn.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.itu = 0;
                    this.itn.setVisibility(8);
                    break;
            }
            if (this.itu != 0) {
                this.ito.setVisibility(0);
                this.itp.setVisibility(0);
                ao.setImageResource(this.ito, this.itu);
            } else {
                this.ito.setVisibility(8);
                this.itp.setVisibility(8);
            }
            this.mTitleView.setText((originalThreadInfo.eMm == null || originalThreadInfo.eMm.length() == 0) ? originalThreadInfo.showText : originalThreadInfo.eMm);
            b(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.itu = 0;
                    this.itn.setDefaultResource(R.color.CAM_X0204);
                    if (this.itx) {
                        this.itn.setPlaceHolder(2);
                    } else {
                        this.itn.setDefaultBgResource(R.color.CAM_X0209);
                    }
                    this.itn.setVisibility(0);
                    this.itn.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.itu = 0;
                    this.itn.setDefaultResource(R.drawable.icon_card_url_n);
                    this.itn.setDefaultBgResource(R.color.CAM_X0209);
                    this.itn.setVisibility(0);
                    this.itn.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.itu = R.drawable.icon_share_play_n;
                    this.itn.setDefaultResource(R.color.CAM_X0204);
                    this.itn.setDefaultBgResource(R.color.CAM_X0209);
                    this.itn.setVisibility(0);
                    this.itn.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.itu = R.drawable.icon_share_card_live;
                    this.itn.setDefaultResource(R.color.CAM_X0204);
                    this.itn.setDefaultBgResource(R.color.CAM_X0209);
                    this.itn.setVisibility(0);
                    this.itn.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.itu = 0;
                    this.itn.setVisibility(8);
                    break;
            }
            if (this.itu != 0) {
                this.ito.setVisibility(0);
                this.itp.setVisibility(0);
                ao.setImageResource(this.ito, this.itu);
            } else {
                this.ito.setVisibility(8);
                this.itp.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            b(shareInfo);
            this.ajt.setVisibility(8);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.itv = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ao.setViewTextColor(this.mTitleView, R.color.CAM_X0107);
            if (this.itu != 0) {
                ao.setImageResource(this.ito, this.itu);
            }
            setBackgroundDrawable(ao.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ao.getColor(R.color.CAM_X0206)));
            this.itq.setBackgroundDrawable(ao.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10), ao.getColor(R.color.CAM_X0205)));
            this.ajt.onChangeSkinType(skinType);
            ao.setViewTextColor(this.itr, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.itt, R.color.CAM_X0109, 1);
            this.its.buF();
        }
    }

    public void setReadState(boolean z) {
        ao.setViewTextColor(this.mTitleView, z ? R.color.CAM_X0109 : R.color.CAM_X0107);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null && originalThreadInfo.showType == 4) {
            if (originalThreadInfo.threadType == 49) {
                d(originalThreadInfo);
            } else if (originalThreadInfo.threadType == 60) {
                if (originalThreadInfo.eMj != null) {
                    if (originalThreadInfo.eMj.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.eMj.share_info != null && originalThreadInfo.eMj.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.eMj != null && originalThreadInfo.eMj.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.eMj);
            if (originalThreadInfo.eMj.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.eMj.user_info.user_name;
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
                pbActivityConfig.setStartFrom(this.itw);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.itw);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }

    private void b(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        b(itemData);
        if (itemData != null) {
            this.itr.setText(itemData.mTitle);
            this.its.setStarCount(itemData.mStar);
            if (itemData.mScore > 0.0d && itemData.mScore <= 10.0d) {
                this.itt.setText(itemData.mScore + "");
            } else {
                this.itt.setText(R.string.frs_evaluate_exception);
            }
            if (this.itn.getVisibility() == 8) {
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
        this.ajt.setVisibility(8);
        if (pollData != null && !com.baidu.tbadk.core.util.x.isEmpty(pollData.getOptions())) {
            this.ajt.setVisibility(0);
            this.ajt.setIsTransmit(true);
            this.ajt.setData(pollData, str, j);
        }
    }

    private void b(ItemData itemData) {
        if (itemData == null) {
            this.itq.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.itq.setVisibility(0);
        setPadding(ali, ali, ali, itz);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.itq.getLayoutParams();
        if (this.itn.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.itq.setLayoutParams(layoutParams);
        this.its.setStarSpacing(ity);
        int i = itB;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.itn.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        this.itn.setLayoutParams(layoutParams2);
        this.itp.setLayoutParams(layoutParams2);
        int i2 = itA;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ito.getLayoutParams();
        layoutParams3.leftMargin = (i - i2) / 2;
        this.ito.setLayoutParams(layoutParams3);
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
