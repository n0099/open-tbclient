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
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private TbImageView eGu;
    private ImageView eGv;
    private ImageView eGw;
    private int eGx;
    private a eGy;
    public int eGz;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;

    /* loaded from: classes3.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
            this.eGu = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
            this.eGv = (ImageView) inflate.findViewById(R.id.icon_video_type);
            this.eGw = (ImageView) findViewById(R.id.thread_pic_mask);
            this.eGu.setLongIconSupport(false);
            this.eGu.setGifIconSupport(false);
            this.eGu.setRadius(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds20));
            this.eGu.setConrers(5);
            int af = (((com.baidu.adp.lib.util.l.af(context) - (com.baidu.adp.lib.util.l.g(context, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eGu.getLayoutParams();
            layoutParams.width = af;
            layoutParams.height = af;
            this.eGu.setLayoutParams(layoutParams);
            this.eGw.setLayoutParams(layoutParams);
            int g = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eGv.getLayoutParams();
            layoutParams2.leftMargin = (af - g) / 2;
            this.eGv.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = af;
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
                        if (OriginalThreadCardView.this.eGy != null) {
                            OriginalThreadCardView.this.eGy.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.eGx = 0;
                    this.eGu.setDefaultResource(R.color.cp_bg_line_c);
                    this.eGu.setDefaultBgResource(R.color.cp_bg_line_c);
                    this.eGu.setVisibility(0);
                    this.eGu.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.eGx = 0;
                    this.eGu.setDefaultResource(R.drawable.icon_card_url_n);
                    this.eGu.setDefaultBgResource(R.color.cp_bg_line_c);
                    this.eGu.setVisibility(0);
                    this.eGu.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.eGx = R.drawable.icon_share_play_n;
                    this.eGu.setDefaultResource(R.color.cp_bg_line_c);
                    this.eGu.setDefaultBgResource(R.color.cp_bg_line_c);
                    this.eGu.setVisibility(0);
                    this.eGu.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.eGx = R.drawable.icon_share_card_live;
                    this.eGu.setDefaultResource(R.color.cp_bg_line_c);
                    this.eGu.setDefaultBgResource(R.color.cp_bg_line_c);
                    this.eGu.setVisibility(0);
                    this.eGu.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.eGx = 0;
                    this.eGu.setVisibility(8);
                    break;
            }
            if (this.eGx != 0) {
                this.eGv.setVisibility(0);
                this.eGw.setVisibility(0);
                am.c(this.eGv, this.eGx);
            } else {
                this.eGv.setVisibility(8);
                this.eGw.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.eGy = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.j(this.mTitleView, R.color.cp_cont_j);
            if (this.eGx != 0) {
                am.c(this.eGv, this.eGx);
            }
            setBackgroundDrawable(am.X(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds20), am.getColor(R.color.cp_bg_line_g)));
        }
    }

    public void setReadState(boolean z) {
        am.j(this.mTitleView, z ? R.color.cp_cont_d : R.color.cp_cont_j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null && originalThreadInfo.showType == 4) {
            if (originalThreadInfo.threadType == 49) {
                d(originalThreadInfo);
            } else if (originalThreadInfo.threadType == 60) {
                if (originalThreadInfo.alaInfoData != null) {
                    if (originalThreadInfo.alaInfoData.live_status == 1) {
                        d(originalThreadInfo);
                        return;
                    } else if (originalThreadInfo.alaInfoData.share_info != null && originalThreadInfo.alaInfoData.share_info.record_tid <= 0) {
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
        if (originalThreadInfo != null && originalThreadInfo.alaInfoData != null && originalThreadInfo.alaInfoData.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.alaInfoData);
            if (originalThreadInfo.alaInfoData.user_info != null) {
                alaLiveInfoCoreData.userName = originalThreadInfo.alaInfoData.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData, null, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig.setStartFrom(this.eGz);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }
}
