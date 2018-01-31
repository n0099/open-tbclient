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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private TbImageView cUJ;
    private ImageView cWq;
    private int cWr;
    private int cWs;
    private a cWt;
    public int cWu;
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
            this.cUJ = (TbImageView) inflate.findViewById(d.g.imageview_thread_pic);
            this.cWq = (ImageView) inflate.findViewById(d.g.icon_video_type);
            this.cUJ.setLongIconSupport(false);
            this.cUJ.setGifIconSupport(false);
            this.cWs = ((com.baidu.adp.lib.util.l.ao(context) - (com.baidu.adp.lib.util.l.s(context, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.s(context, d.e.tbds140)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cUJ.getLayoutParams();
            layoutParams.width = this.cWs;
            layoutParams.height = this.cWs;
            this.cUJ.setLayoutParams(layoutParams);
            int s = com.baidu.adp.lib.util.l.s(context, d.e.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cWq.getLayoutParams();
            layoutParams2.leftMargin = (this.cWs - s) / 2;
            this.cWq.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = this.cWs;
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
                        if (OriginalThreadCardView.this.cWt != null) {
                            OriginalThreadCardView.this.cWt.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.cWs, 1073741824));
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.cWr = 0;
                    this.cUJ.setDefaultResource(d.C0108d.cp_bg_line_b);
                    this.cUJ.setDefaultBgResource(d.C0108d.cp_bg_line_b);
                    this.cUJ.setVisibility(0);
                    this.cUJ.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.cWr = 0;
                    this.cUJ.setDefaultResource(d.f.icon_card_url_n);
                    this.cUJ.setDefaultBgResource(d.C0108d.cp_bg_line_b);
                    this.cUJ.setVisibility(0);
                    this.cUJ.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.cWr = d.f.icon_share_card_video;
                    this.cUJ.setDefaultResource(d.C0108d.cp_bg_line_b);
                    this.cUJ.setDefaultBgResource(d.C0108d.cp_bg_line_b);
                    this.cUJ.setVisibility(0);
                    this.cUJ.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.cWr = d.f.icon_share_card_live;
                    this.cUJ.setDefaultResource(d.C0108d.cp_bg_line_b);
                    this.cUJ.setDefaultBgResource(d.C0108d.cp_bg_line_b);
                    this.cUJ.setVisibility(0);
                    this.cUJ.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.cWr = 0;
                    this.cUJ.setVisibility(8);
                    break;
            }
            if (this.cWr != 0) {
                this.cWq.setVisibility(0);
                aj.c(this.cWq, this.cWr);
            } else {
                this.cWq.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.cWt = aVar;
    }

    public void onChangeSkinType() {
        aj.r(this.mTitleView, d.C0108d.cp_cont_j);
        if (this.cWr != 0) {
            aj.c(this.cWq, this.cWr);
        }
        aj.s(this, d.f.bg_share_card_item);
    }

    public void setReadState(boolean z) {
        aj.r(this.mTitleView, z ? d.C0108d.cp_cont_d : d.C0108d.cp_cont_j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null && originalThreadInfo.showType == 4) {
            if (originalThreadInfo.threadType == 49) {
                d(originalThreadInfo);
            } else if (originalThreadInfo.threadType == 60) {
                if (originalThreadInfo.alaInfoData.live_status == 1) {
                    d(originalThreadInfo);
                } else if (originalThreadInfo.alaInfoData.share_info != null && originalThreadInfo.alaInfoData.share_info.record_tid <= 0) {
                    d(originalThreadInfo);
                } else {
                    e(originalThreadInfo);
                }
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData, null, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, null, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
            pbActivityConfig.setStartFrom(this.cWu);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }
}
