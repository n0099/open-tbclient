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
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private a daA;
    public int daB;
    private TbImageView dav;
    private ImageView daw;
    private int dax;
    private int daz;
    private Context mContext;
    private int mSkinType;
    private TextView mTitleView;

    /* loaded from: classes6.dex */
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
            View inflate = LayoutInflater.from(context).inflate(e.h.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(e.g.textview_thread_abstract);
            this.dav = (TbImageView) inflate.findViewById(e.g.imageview_thread_pic);
            this.daw = (ImageView) inflate.findViewById(e.g.icon_video_type);
            this.dav.setLongIconSupport(false);
            this.dav.setGifIconSupport(false);
            this.daz = ((com.baidu.adp.lib.util.l.aO(context) - (com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds44) * 2)) - com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds140)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dav.getLayoutParams();
            layoutParams.width = this.daz;
            layoutParams.height = this.daz;
            this.dav.setLayoutParams(layoutParams);
            int h = com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.daw.getLayoutParams();
            layoutParams2.leftMargin = (this.daz - h) / 2;
            this.daw.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = this.daz;
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
                        if (OriginalThreadCardView.this.daA != null) {
                            OriginalThreadCardView.this.daA.a(originalThreadInfo);
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.daz, AiAppsFileUtils.GB));
    }

    public void b(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            switch (originalThreadInfo.showType) {
                case 1:
                    this.dax = 0;
                    this.dav.setDefaultResource(e.d.cp_bg_line_b);
                    this.dav.setDefaultBgResource(e.d.cp_bg_line_b);
                    this.dav.setVisibility(0);
                    this.dav.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.dax = 0;
                    this.dav.setDefaultResource(e.f.icon_card_url_n);
                    this.dav.setDefaultBgResource(e.d.cp_bg_line_b);
                    this.dav.setVisibility(0);
                    this.dav.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.dax = e.f.icon_share_card_video;
                    this.dav.setDefaultResource(e.d.cp_bg_line_b);
                    this.dav.setDefaultBgResource(e.d.cp_bg_line_b);
                    this.dav.setVisibility(0);
                    this.dav.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.dax = e.f.icon_share_card_live;
                    this.dav.setDefaultResource(e.d.cp_bg_line_b);
                    this.dav.setDefaultBgResource(e.d.cp_bg_line_b);
                    this.dav.setVisibility(0);
                    this.dav.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.dax = 0;
                    this.dav.setVisibility(8);
                    break;
            }
            if (this.dax != 0) {
                this.daw.setVisibility(0);
                al.c(this.daw, this.dax);
            } else {
                this.daw.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.daA = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            al.h(this.mTitleView, e.d.cp_cont_j);
            if (this.dax != 0) {
                al.c(this.daw, this.dax);
            }
            al.i(this, e.f.bg_share_card_item);
        }
    }

    public void setReadState(boolean z) {
        al.h(this.mTitleView, z ? e.d.cp_cont_d : e.d.cp_cont_j);
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
            pbActivityConfig.setStartFrom(this.daB);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }
}
