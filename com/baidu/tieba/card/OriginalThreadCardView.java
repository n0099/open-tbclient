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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private TbImageView cAX;
    private ImageView cAY;
    private int cAZ;
    private int cBa;
    private a cBb;
    public int cBc;
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
            View inflate = LayoutInflater.from(context).inflate(d.h.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(d.g.textview_thread_abstract);
            this.cAX = (TbImageView) inflate.findViewById(d.g.imageview_thread_pic);
            this.cAY = (ImageView) inflate.findViewById(d.g.icon_video_type);
            this.cAX.setLongIconSupport(false);
            this.cAX.setGifIconSupport(false);
            this.cBa = ((com.baidu.adp.lib.util.l.ah(context) - (com.baidu.adp.lib.util.l.f(context, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.f(context, d.e.tbds140)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAX.getLayoutParams();
            layoutParams.width = this.cBa;
            layoutParams.height = this.cBa;
            this.cAX.setLayoutParams(layoutParams);
            int f = com.baidu.adp.lib.util.l.f(context, d.e.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cAY.getLayoutParams();
            layoutParams2.leftMargin = (this.cBa - f) / 2;
            this.cAY.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = this.cBa;
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
                        if (OriginalThreadCardView.this.cBb != null) {
                            OriginalThreadCardView.this.cBb.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.cBa, 1073741824));
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.cAZ = 0;
                    this.cAX.setDefaultResource(d.C0140d.cp_bg_line_b);
                    this.cAX.setDefaultBgResource(d.C0140d.cp_bg_line_b);
                    this.cAX.setVisibility(0);
                    this.cAX.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.cAZ = 0;
                    this.cAX.setDefaultResource(d.f.icon_card_url_n);
                    this.cAX.setDefaultBgResource(d.C0140d.cp_bg_line_b);
                    this.cAX.setVisibility(0);
                    this.cAX.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.cAZ = d.f.icon_share_card_video;
                    this.cAX.setDefaultResource(d.C0140d.cp_bg_line_b);
                    this.cAX.setDefaultBgResource(d.C0140d.cp_bg_line_b);
                    this.cAX.setVisibility(0);
                    this.cAX.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.cAZ = d.f.icon_share_card_live;
                    this.cAX.setDefaultResource(d.C0140d.cp_bg_line_b);
                    this.cAX.setDefaultBgResource(d.C0140d.cp_bg_line_b);
                    this.cAX.setVisibility(0);
                    this.cAX.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.cAZ = 0;
                    this.cAX.setVisibility(8);
                    break;
            }
            if (this.cAZ != 0) {
                this.cAY.setVisibility(0);
                am.c(this.cAY, this.cAZ);
            } else {
                this.cAY.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.cBb = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.h(this.mTitleView, d.C0140d.cp_cont_j);
            if (this.cAZ != 0) {
                am.c(this.cAY, this.cAZ);
            }
            am.i(this, d.f.bg_share_card_item);
        }
    }

    public void setReadState(boolean z) {
        am.h(this.mTitleView, z ? d.C0140d.cp_cont_d : d.C0140d.cp_cont_j);
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
            pbActivityConfig.setStartFrom(this.cBc);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }
}
