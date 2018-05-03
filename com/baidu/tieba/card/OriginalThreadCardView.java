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
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private TbImageView cqN;
    private ImageView cqO;
    private int cqP;
    private int cqQ;
    private a cqR;
    public int cqS;
    private Context mContext;
    private TextView mTitleView;

    /* loaded from: classes2.dex */
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
            View inflate = LayoutInflater.from(context).inflate(d.i.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(d.g.textview_thread_abstract);
            this.cqN = (TbImageView) inflate.findViewById(d.g.imageview_thread_pic);
            this.cqO = (ImageView) inflate.findViewById(d.g.icon_video_type);
            this.cqN.setLongIconSupport(false);
            this.cqN.setGifIconSupport(false);
            this.cqQ = ((com.baidu.adp.lib.util.l.af(context) - (com.baidu.adp.lib.util.l.e(context, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.e(context, d.e.tbds140)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cqN.getLayoutParams();
            layoutParams.width = this.cqQ;
            layoutParams.height = this.cqQ;
            this.cqN.setLayoutParams(layoutParams);
            int e = com.baidu.adp.lib.util.l.e(context, d.e.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cqO.getLayoutParams();
            layoutParams2.leftMargin = (this.cqQ - e) / 2;
            this.cqO.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = this.cqQ;
            this.mTitleView.setLayoutParams(layoutParams3);
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.OriginalThreadCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 != null && (view2.getTag() instanceof OriginalThreadInfo)) {
                        OriginalThreadInfo originalThreadInfo = (OriginalThreadInfo) view2.getTag();
                        if (originalThreadInfo.showType == 4) {
                            OriginalThreadCardView.this.c(originalThreadInfo);
                        } else {
                            OriginalThreadCardView.this.e(originalThreadInfo);
                        }
                        if (OriginalThreadCardView.this.cqR != null) {
                            OriginalThreadCardView.this.cqR.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.cqQ, 1073741824));
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.cqP = 0;
                    this.cqN.setDefaultResource(d.C0126d.cp_bg_line_b);
                    this.cqN.setDefaultBgResource(d.C0126d.cp_bg_line_b);
                    this.cqN.setVisibility(0);
                    this.cqN.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.cqP = 0;
                    this.cqN.setDefaultResource(d.f.icon_card_url_n);
                    this.cqN.setDefaultBgResource(d.C0126d.cp_bg_line_b);
                    this.cqN.setVisibility(0);
                    this.cqN.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.cqP = d.f.icon_share_card_video;
                    this.cqN.setDefaultResource(d.C0126d.cp_bg_line_b);
                    this.cqN.setDefaultBgResource(d.C0126d.cp_bg_line_b);
                    this.cqN.setVisibility(0);
                    this.cqN.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.cqP = d.f.icon_share_card_live;
                    this.cqN.setDefaultResource(d.C0126d.cp_bg_line_b);
                    this.cqN.setDefaultBgResource(d.C0126d.cp_bg_line_b);
                    this.cqN.setVisibility(0);
                    this.cqN.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.cqP = 0;
                    this.cqN.setVisibility(8);
                    break;
            }
            if (this.cqP != 0) {
                this.cqO.setVisibility(0);
                ak.c(this.cqO, this.cqP);
            } else {
                this.cqO.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.cqR = aVar;
    }

    public void onChangeSkinType() {
        ak.h(this.mTitleView, d.C0126d.cp_cont_j);
        if (this.cqP != 0) {
            ak.c(this.cqO, this.cqP);
        }
        ak.i(this, d.f.bg_share_card_item);
    }

    public void setReadState(boolean z) {
        ak.h(this.mTitleView, z ? d.C0126d.cp_cont_d : d.C0126d.cp_cont_j);
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
            pbActivityConfig.setStartFrom(this.cqS);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }
}
