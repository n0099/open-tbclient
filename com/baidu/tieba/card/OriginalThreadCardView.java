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
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private TbImageView cXk;
    private ImageView cYU;
    private int cYV;
    private int cYW;
    private a cYX;
    public int cYY;
    private Context mContext;
    private TextView mTitleView;

    /* loaded from: classes.dex */
    public interface a {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(d.h.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(d.g.textview_thread_abstract);
            this.cXk = (TbImageView) inflate.findViewById(d.g.imageview_thread_pic);
            this.cYU = (ImageView) inflate.findViewById(d.g.icon_video_type);
            this.cXk.setLongIconSupport(false);
            this.cXk.setGifIconSupport(false);
            this.cYW = ((com.baidu.adp.lib.util.l.ao(context) - (com.baidu.adp.lib.util.l.t(context, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.t(context, d.e.tbds140)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cXk.getLayoutParams();
            layoutParams.width = this.cYW;
            layoutParams.height = this.cYW;
            this.cXk.setLayoutParams(layoutParams);
            int t = com.baidu.adp.lib.util.l.t(context, d.e.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cYU.getLayoutParams();
            layoutParams2.leftMargin = (this.cYW - t) / 2;
            this.cYU.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = this.cYW;
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
                        if (OriginalThreadCardView.this.cYX != null) {
                            OriginalThreadCardView.this.cYX.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.cYW, 1073741824));
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.cYV = 0;
                    this.cXk.setDefaultResource(d.C0141d.cp_bg_line_b);
                    this.cXk.setDefaultBgResource(d.C0141d.cp_bg_line_b);
                    this.cXk.setVisibility(0);
                    this.cXk.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.cYV = 0;
                    this.cXk.setDefaultResource(d.f.icon_card_url_n);
                    this.cXk.setDefaultBgResource(d.C0141d.cp_bg_line_b);
                    this.cXk.setVisibility(0);
                    this.cXk.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.cYV = d.f.icon_share_card_video;
                    this.cXk.setDefaultResource(d.C0141d.cp_bg_line_b);
                    this.cXk.setDefaultBgResource(d.C0141d.cp_bg_line_b);
                    this.cXk.setVisibility(0);
                    this.cXk.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.cYV = d.f.icon_share_card_live;
                    this.cXk.setDefaultResource(d.C0141d.cp_bg_line_b);
                    this.cXk.setDefaultBgResource(d.C0141d.cp_bg_line_b);
                    this.cXk.setVisibility(0);
                    this.cXk.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.cYV = 0;
                    this.cXk.setVisibility(8);
                    break;
            }
            if (this.cYV != 0) {
                this.cYU.setVisibility(0);
                aj.c(this.cYU, this.cYV);
            } else {
                this.cYU.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.cYX = aVar;
    }

    public void onChangeSkinType() {
        aj.r(this.mTitleView, d.C0141d.cp_cont_j);
        if (this.cYV != 0) {
            aj.c(this.cYU, this.cYV);
        }
        aj.s(this, d.f.bg_share_card_item);
    }

    public void setReadState(boolean z) {
        aj.r(this.mTitleView, z ? d.C0141d.cp_cont_d : d.C0141d.cp_cont_j);
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
            if (originalThreadInfo.threadType == 33) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(this.mContext, originalThreadInfo.threadId).cP(originalThreadInfo.postId).xD()));
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig.setStartFrom(this.cYY);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    public TbImageView getThreadImage() {
        return this.cXk;
    }
}
