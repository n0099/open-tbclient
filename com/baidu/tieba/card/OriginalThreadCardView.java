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
    private TbImageView gro;
    private ImageView grp;
    private ImageView grq;
    private int grr;
    private a grs;
    public int grt;
    public boolean gru;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;

    /* loaded from: classes8.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.gru = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gru = true;
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gru = true;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.gro = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.grp = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.grq = (ImageView) findViewById(R.id.thread_pic_mask);
            this.gro.setLongIconSupport(false);
            this.gro.setGifIconSupport(false);
            this.gro.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
            this.gro.setConrers(5);
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gro.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
            this.gro.setLayoutParams(layoutParams);
            this.grq.setLayoutParams(layoutParams);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.grp.getLayoutParams();
            layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
            this.grp.setLayoutParams(layoutParams2);
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
                        if (OriginalThreadCardView.this.grs != null) {
                            OriginalThreadCardView.this.grs.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    public void setUsePlaceHolder(boolean z) {
        this.gru = z;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.grr = 0;
                    this.gro.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.gru) {
                        this.gro.setPlaceHolder(2);
                    } else {
                        this.gro.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.gro.setVisibility(0);
                    this.gro.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.grr = 0;
                    this.gro.setDefaultResource(R.drawable.icon_card_url_n);
                    this.gro.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gro.setVisibility(0);
                    this.gro.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.grr = R.drawable.icon_share_play_n;
                    this.gro.setDefaultResource(R.color.cp_bg_line_c);
                    this.gro.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gro.setVisibility(0);
                    this.gro.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.grr = R.drawable.icon_share_card_live;
                    this.gro.setDefaultResource(R.color.cp_bg_line_c);
                    this.gro.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gro.setVisibility(0);
                    this.gro.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.grr = 0;
                    this.gro.setVisibility(8);
                    break;
            }
            if (this.grr != 0) {
                this.grp.setVisibility(0);
                this.grq.setVisibility(0);
                am.setImageResource(this.grp, this.grr);
            } else {
                this.grp.setVisibility(8);
                this.grq.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void a(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo != null) {
            switch (shareInfo.showType) {
                case 1:
                    this.grr = 0;
                    this.gro.setDefaultResource(R.color.cp_bg_line_c);
                    if (this.gru) {
                        this.gro.setPlaceHolder(2);
                    } else {
                        this.gro.setDefaultBgResource(R.color.cp_bg_line_j);
                    }
                    this.gro.setVisibility(0);
                    this.gro.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.grr = 0;
                    this.gro.setDefaultResource(R.drawable.icon_card_url_n);
                    this.gro.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gro.setVisibility(0);
                    this.gro.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.grr = R.drawable.icon_share_play_n;
                    this.gro.setDefaultResource(R.color.cp_bg_line_c);
                    this.gro.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gro.setVisibility(0);
                    this.gro.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.grr = R.drawable.icon_share_card_live;
                    this.gro.setDefaultResource(R.color.cp_bg_line_c);
                    this.gro.setDefaultBgResource(R.color.cp_bg_line_j);
                    this.gro.setVisibility(0);
                    this.gro.startLoad(shareInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.grr = 0;
                    this.gro.setVisibility(8);
                    break;
            }
            if (this.grr != 0) {
                this.grp.setVisibility(0);
                this.grq.setVisibility(0);
                am.setImageResource(this.grp, this.grr);
            } else {
                this.grp.setVisibility(8);
                this.grq.setVisibility(8);
            }
            this.mTitleView.setText(shareInfo.showText);
            setTag(shareInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.grs = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_j);
            if (this.grr != 0) {
                am.setImageResource(this.grp, this.grr);
            }
            setBackgroundDrawable(am.aB(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20), am.getColor(R.color.cp_bg_line_g)));
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
                if (originalThreadInfo.dpg != null) {
                    if (originalThreadInfo.dpg.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.dpg.share_info != null && originalThreadInfo.dpg.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.dpg != null && originalThreadInfo.dpg.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.dpg);
            if (originalThreadInfo.dpg.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.dpg.user_info.user_name;
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
                pbActivityConfig.setStartFrom(this.grt);
                pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                return;
            }
            PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
            pbActivityConfig2.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig2.setStartFrom(this.grt);
            pbActivityConfig2.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
        }
    }
}
