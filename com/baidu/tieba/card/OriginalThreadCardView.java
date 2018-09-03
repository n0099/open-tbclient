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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private TbImageView cAU;
    private ImageView cAV;
    private int cAW;
    private int cAX;
    private a cAY;
    public int cAZ;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;

    /* loaded from: classes2.dex */
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
            View inflate = LayoutInflater.from(context).inflate(f.h.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(f.g.textview_thread_abstract);
            this.cAU = (TbImageView) inflate.findViewById(f.g.imageview_thread_pic);
            this.cAV = (ImageView) inflate.findViewById(f.g.icon_video_type);
            this.cAU.setLongIconSupport(false);
            this.cAU.setGifIconSupport(false);
            this.cAX = ((com.baidu.adp.lib.util.l.ah(context) - (com.baidu.adp.lib.util.l.f(context, f.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.f(context, f.e.tbds140)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAU.getLayoutParams();
            layoutParams.width = this.cAX;
            layoutParams.height = this.cAX;
            this.cAU.setLayoutParams(layoutParams);
            int f = com.baidu.adp.lib.util.l.f(context, f.e.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cAV.getLayoutParams();
            layoutParams2.leftMargin = (this.cAX - f) / 2;
            this.cAV.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = this.cAX;
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
                        if (OriginalThreadCardView.this.cAY != null) {
                            OriginalThreadCardView.this.cAY.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.cAX, 1073741824));
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.cAW = 0;
                    this.cAU.setDefaultResource(f.d.cp_bg_line_b);
                    this.cAU.setDefaultBgResource(f.d.cp_bg_line_b);
                    this.cAU.setVisibility(0);
                    this.cAU.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.cAW = 0;
                    this.cAU.setDefaultResource(f.C0146f.icon_card_url_n);
                    this.cAU.setDefaultBgResource(f.d.cp_bg_line_b);
                    this.cAU.setVisibility(0);
                    this.cAU.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.cAW = f.C0146f.icon_share_card_video;
                    this.cAU.setDefaultResource(f.d.cp_bg_line_b);
                    this.cAU.setDefaultBgResource(f.d.cp_bg_line_b);
                    this.cAU.setVisibility(0);
                    this.cAU.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.cAW = f.C0146f.icon_share_card_live;
                    this.cAU.setDefaultResource(f.d.cp_bg_line_b);
                    this.cAU.setDefaultBgResource(f.d.cp_bg_line_b);
                    this.cAU.setVisibility(0);
                    this.cAU.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.cAW = 0;
                    this.cAU.setVisibility(8);
                    break;
            }
            if (this.cAW != 0) {
                this.cAV.setVisibility(0);
                am.c(this.cAV, this.cAW);
            } else {
                this.cAV.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.cAY = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.h(this.mTitleView, f.d.cp_cont_j);
            if (this.cAW != 0) {
                am.c(this.cAV, this.cAW);
            }
            am.i(this, f.C0146f.bg_share_card_item);
        }
    }

    public void setReadState(boolean z) {
        am.h(this.mTitleView, z ? f.d.cp_cont_d : f.d.cp_cont_j);
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
            pbActivityConfig.setStartFrom(this.cAZ);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }
}
