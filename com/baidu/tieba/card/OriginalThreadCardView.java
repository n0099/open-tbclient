package com.baidu.tieba.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private TbImageView fLG;
    private ImageView fLH;
    private ImageView fLI;
    private int fLJ;
    private a fLK;
    public int fLL;
    public boolean fLM;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;

    /* loaded from: classes8.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.fLM = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fLM = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fLM = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.fLG = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.fLH = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.fLI = (ImageView) findViewById(R.id.thread_pic_mask);
            this.fLG.setLongIconSupport(false);
            this.fLG.setGifIconSupport(false);
            this.fLG.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.fLG.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLG.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.fLG.setLayoutParams(layoutParams);
            this.fLI.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fLH.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.fLH.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = equipmentWidth;
            this.mTitleView.setLayoutParams(layoutParams3);
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
                        if (OriginalThreadCardView.this.fLK != null) {
                            OriginalThreadCardView.this.fLK.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.fLM = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.fLJ = 0;
                    this.fLG.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.fLM) {
                        this.fLG.setPlaceHolder(2);
                    } else {
                        this.fLG.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.fLG.setVisibility(0);
                    this.fLG.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.fLJ = 0;
                    this.fLG.setDefaultResource(R.drawable.icon_card_url_n);
                    this.fLG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.fLG.setVisibility(0);
                    this.fLG.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.fLJ = R.drawable.icon_share_play_n;
                    this.fLG.setDefaultResource(R.color.cp_bg_line_c);
                    this.fLG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.fLG.setVisibility(0);
                    this.fLG.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.fLJ = R.drawable.icon_share_card_live;
                    this.fLG.setDefaultResource(R.color.cp_bg_line_c);
                    this.fLG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.fLG.setVisibility(0);
                    this.fLG.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.fLJ = 0;
                    this.fLG.setVisibility(8);
                    break;
            }
            if (this.fLJ != 0) {
                this.fLH.setVisibility(0);
                this.fLI.setVisibility(0);
                am.setImageResource(this.fLH, this.fLJ);
            } else {
                this.fLH.setVisibility(8);
                this.fLI.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.fLJ = 0;
                    this.fLG.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.fLM) {
                        this.fLG.setPlaceHolder(2);
                    } else {
                        this.fLG.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.fLG.setVisibility(0);
                    this.fLG.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.fLJ = 0;
                    this.fLG.setDefaultResource(R.drawable.icon_card_url_n);
                    this.fLG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.fLG.setVisibility(0);
                    this.fLG.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.fLJ = R.drawable.icon_share_play_n;
                    this.fLG.setDefaultResource(R.color.cp_bg_line_c);
                    this.fLG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.fLG.setVisibility(0);
                    this.fLG.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.fLJ = R.drawable.icon_share_card_live;
                    this.fLG.setDefaultResource(R.color.cp_bg_line_c);
                    this.fLG.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.fLG.setVisibility(0);
                    this.fLG.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.fLJ = 0;
                    this.fLG.setVisibility(8);
                    break;
            }
            if (this.fLJ != 0) {
                this.fLH.setVisibility(0);
                this.fLI.setVisibility(0);
                am.setImageResource(this.fLH, this.fLJ);
            } else {
                this.fLH.setVisibility(8);
                this.fLI.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.fLK = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_j);
            if (this.fLJ != 0) {
                am.setImageResource(this.fLH, this.fLJ);
            }
            setBackgroundDrawable(am.ay(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20), am.getColor(R.color.cp_bg_line_g)));
        }
    }

    public void setReadState(boolean z) {
        am.setViewTextColor(this.mTitleView, z ? R.color.cp_cont_d : R.color.cp_cont_j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null && originalThreadInfo.showType == 4) {
            if (originalThreadInfo.threadType == 49) {
                d(originalThreadInfo);
            } else if (originalThreadInfo.threadType == 60) {
                if (originalThreadInfo.cPI != null) {
                    if (originalThreadInfo.cPI.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.cPI.share_info != null && originalThreadInfo.cPI.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.cPI != null && originalThreadInfo.cPI.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.cPI);
            if (originalThreadInfo.cPI.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.cPI.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData, null, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            if (au.a(originalThreadInfo.oriUgcInfo)) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, null, null);
                pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                pbActivityConfig.setStartFrom(this.fLL);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.fLL);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }
}
