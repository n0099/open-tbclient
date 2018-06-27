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
    private TbImageView cyu;
    private ImageView cyv;
    private int cyw;
    private int cyx;
    private a cyy;
    public int cyz;
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
            View inflate = LayoutInflater.from(context).inflate(d.i.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(d.g.textview_thread_abstract);
            this.cyu = (TbImageView) inflate.findViewById(d.g.imageview_thread_pic);
            this.cyv = (ImageView) inflate.findViewById(d.g.icon_video_type);
            this.cyu.setLongIconSupport(false);
            this.cyu.setGifIconSupport(false);
            this.cyx = ((com.baidu.adp.lib.util.l.ah(context) - (com.baidu.adp.lib.util.l.e(context, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.e(context, d.e.tbds140)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cyu.getLayoutParams();
            layoutParams.width = this.cyx;
            layoutParams.height = this.cyx;
            this.cyu.setLayoutParams(layoutParams);
            int e = com.baidu.adp.lib.util.l.e(context, d.e.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cyv.getLayoutParams();
            layoutParams2.leftMargin = (this.cyx - e) / 2;
            this.cyv.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = this.cyx;
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
                        if (OriginalThreadCardView.this.cyy != null) {
                            OriginalThreadCardView.this.cyy.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.cyx, 1073741824));
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.cyw = 0;
                    this.cyu.setDefaultResource(d.C0142d.cp_bg_line_b);
                    this.cyu.setDefaultBgResource(d.C0142d.cp_bg_line_b);
                    this.cyu.setVisibility(0);
                    this.cyu.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.cyw = 0;
                    this.cyu.setDefaultResource(d.f.icon_card_url_n);
                    this.cyu.setDefaultBgResource(d.C0142d.cp_bg_line_b);
                    this.cyu.setVisibility(0);
                    this.cyu.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.cyw = d.f.icon_share_card_video;
                    this.cyu.setDefaultResource(d.C0142d.cp_bg_line_b);
                    this.cyu.setDefaultBgResource(d.C0142d.cp_bg_line_b);
                    this.cyu.setVisibility(0);
                    this.cyu.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.cyw = d.f.icon_share_card_live;
                    this.cyu.setDefaultResource(d.C0142d.cp_bg_line_b);
                    this.cyu.setDefaultBgResource(d.C0142d.cp_bg_line_b);
                    this.cyu.setVisibility(0);
                    this.cyu.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.cyw = 0;
                    this.cyu.setVisibility(8);
                    break;
            }
            if (this.cyw != 0) {
                this.cyv.setVisibility(0);
                am.c(this.cyv, this.cyw);
            } else {
                this.cyv.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.cyy = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.h(this.mTitleView, d.C0142d.cp_cont_j);
            if (this.cyw != 0) {
                am.c(this.cyv, this.cyw);
            }
            am.i(this, d.f.bg_share_card_item);
        }
    }

    public void setReadState(boolean z) {
        am.h(this.mTitleView, z ? d.C0142d.cp_cont_d : d.C0142d.cp_cont_j);
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
            pbActivityConfig.setStartFrom(this.cyz);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }
}
