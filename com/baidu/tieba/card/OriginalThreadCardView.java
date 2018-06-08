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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private TbImageView cAA;
    private ImageView cAB;
    private int cAC;
    private int cAD;
    private a cAE;
    public int cAF;
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
            this.cAA = (TbImageView) inflate.findViewById(d.g.imageview_thread_pic);
            this.cAB = (ImageView) inflate.findViewById(d.g.icon_video_type);
            this.cAA.setLongIconSupport(false);
            this.cAA.setGifIconSupport(false);
            this.cAD = ((com.baidu.adp.lib.util.l.ah(context) - (com.baidu.adp.lib.util.l.e(context, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.e(context, d.e.tbds140)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAA.getLayoutParams();
            layoutParams.width = this.cAD;
            layoutParams.height = this.cAD;
            this.cAA.setLayoutParams(layoutParams);
            int e = com.baidu.adp.lib.util.l.e(context, d.e.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cAB.getLayoutParams();
            layoutParams2.leftMargin = (this.cAD - e) / 2;
            this.cAB.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = this.cAD;
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
                        if (OriginalThreadCardView.this.cAE != null) {
                            OriginalThreadCardView.this.cAE.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.cAD, 1073741824));
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.cAC = 0;
                    this.cAA.setDefaultResource(d.C0141d.cp_bg_line_b);
                    this.cAA.setDefaultBgResource(d.C0141d.cp_bg_line_b);
                    this.cAA.setVisibility(0);
                    this.cAA.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.cAC = 0;
                    this.cAA.setDefaultResource(d.f.icon_card_url_n);
                    this.cAA.setDefaultBgResource(d.C0141d.cp_bg_line_b);
                    this.cAA.setVisibility(0);
                    this.cAA.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.cAC = d.f.icon_share_card_video;
                    this.cAA.setDefaultResource(d.C0141d.cp_bg_line_b);
                    this.cAA.setDefaultBgResource(d.C0141d.cp_bg_line_b);
                    this.cAA.setVisibility(0);
                    this.cAA.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.cAC = d.f.icon_share_card_live;
                    this.cAA.setDefaultResource(d.C0141d.cp_bg_line_b);
                    this.cAA.setDefaultBgResource(d.C0141d.cp_bg_line_b);
                    this.cAA.setVisibility(0);
                    this.cAA.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.cAC = 0;
                    this.cAA.setVisibility(8);
                    break;
            }
            if (this.cAC != 0) {
                this.cAB.setVisibility(0);
                al.c(this.cAB, this.cAC);
            } else {
                this.cAB.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.cAE = aVar;
    }

    public void onChangeSkinType() {
        al.h(this.mTitleView, d.C0141d.cp_cont_j);
        if (this.cAC != 0) {
            al.c(this.cAB, this.cAC);
        }
        al.i(this, d.f.bg_share_card_item);
    }

    public void setReadState(boolean z) {
        al.h(this.mTitleView, z ? d.C0141d.cp_cont_d : d.C0141d.cp_cont_j);
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
            pbActivityConfig.setStartFrom(this.cAF);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }
}
