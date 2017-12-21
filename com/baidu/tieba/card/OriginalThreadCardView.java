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
    private TbImageView cbg;
    private ImageView ccQ;
    private int ccR;
    private int ccS;
    private a ccT;
    public int ccU;
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
            this.cbg = (TbImageView) inflate.findViewById(d.g.imageview_thread_pic);
            this.ccQ = (ImageView) inflate.findViewById(d.g.icon_video_type);
            this.cbg.setLongIconSupport(false);
            this.cbg.setGifIconSupport(false);
            this.ccS = ((com.baidu.adp.lib.util.l.ac(context) - (com.baidu.adp.lib.util.l.f(context, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.f(context, d.e.tbds140)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cbg.getLayoutParams();
            layoutParams.width = this.ccS;
            layoutParams.height = this.ccS;
            this.cbg.setLayoutParams(layoutParams);
            int f = com.baidu.adp.lib.util.l.f(context, d.e.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ccQ.getLayoutParams();
            layoutParams2.leftMargin = (this.ccS - f) / 2;
            this.ccQ.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = this.ccS;
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
                        if (OriginalThreadCardView.this.ccT != null) {
                            OriginalThreadCardView.this.ccT.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.ccS, 1073741824));
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.ccR = 0;
                    this.cbg.setDefaultResource(d.C0095d.cp_bg_line_b);
                    this.cbg.setDefaultBgResource(d.C0095d.cp_bg_line_b);
                    this.cbg.setVisibility(0);
                    this.cbg.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.ccR = 0;
                    this.cbg.setDefaultResource(d.f.icon_card_url_n);
                    this.cbg.setDefaultBgResource(d.C0095d.cp_bg_line_b);
                    this.cbg.setVisibility(0);
                    this.cbg.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.ccR = d.f.icon_share_card_video;
                    this.cbg.setDefaultResource(d.C0095d.cp_bg_line_b);
                    this.cbg.setDefaultBgResource(d.C0095d.cp_bg_line_b);
                    this.cbg.setVisibility(0);
                    this.cbg.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.ccR = d.f.icon_share_card_live;
                    this.cbg.setDefaultResource(d.C0095d.cp_bg_line_b);
                    this.cbg.setDefaultBgResource(d.C0095d.cp_bg_line_b);
                    this.cbg.setVisibility(0);
                    this.cbg.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.ccR = 0;
                    this.cbg.setVisibility(8);
                    break;
            }
            if (this.ccR != 0) {
                this.ccQ.setVisibility(0);
                aj.c(this.ccQ, this.ccR);
            } else {
                this.ccQ.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.ccT = aVar;
    }

    public void onChangeSkinType() {
        aj.i(this.mTitleView, d.C0095d.cp_cont_j);
        if (this.ccR != 0) {
            aj.c(this.ccQ, this.ccR);
        }
        aj.j(this, d.f.bg_share_card_item);
    }

    public void setReadState(boolean z) {
        aj.i(this.mTitleView, z ? d.C0095d.cp_cont_d : d.C0095d.cp_cont_j);
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
            pbActivityConfig.setStartFrom(this.ccU);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }
}
