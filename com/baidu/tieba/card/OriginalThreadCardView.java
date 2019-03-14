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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class OriginalThreadCardView extends RelativeLayout {
    private TbImageView ekg;
    private ImageView ekh;
    private ImageView eki;
    private int ekj;
    private a ekk;
    public int ekl;
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
            View inflate = LayoutInflater.from(context).inflate(d.h.card_original_pb_layout, (ViewGroup) this, true);
            this.mTitleView = (TextView) inflate.findViewById(d.g.textview_thread_abstract);
            this.ekg = (TbImageView) inflate.findViewById(d.g.imageview_thread_pic);
            this.ekh = (ImageView) inflate.findViewById(d.g.icon_video_type);
            this.eki = (ImageView) findViewById(d.g.thread_pic_mask);
            this.ekg.setLongIconSupport(false);
            this.ekg.setGifIconSupport(false);
            this.ekg.setRadius(com.baidu.adp.lib.util.l.h(context, d.e.tbds20));
            this.ekg.setConrers(5);
            int aO = (((com.baidu.adp.lib.util.l.aO(context) - (com.baidu.adp.lib.util.l.h(context, d.e.tbds44) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds26) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds10) * 4)) / 5;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ekg.getLayoutParams();
            layoutParams.width = aO;
            layoutParams.height = aO;
            this.ekg.setLayoutParams(layoutParams);
            this.eki.setLayoutParams(layoutParams);
            int h = com.baidu.adp.lib.util.l.h(context, d.e.tbds78);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ekh.getLayoutParams();
            layoutParams2.leftMargin = (aO - h) / 2;
            this.ekh.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams3.height = aO;
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
                        if (OriginalThreadCardView.this.ekk != null) {
                            OriginalThreadCardView.this.ekk.a(originalThreadInfo);
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
                    this.ekj = 0;
                    this.ekg.setDefaultResource(d.C0277d.cp_bg_line_b);
                    this.ekg.setDefaultBgResource(d.C0277d.cp_bg_line_b);
                    this.ekg.setVisibility(0);
                    this.ekg.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 2:
                    this.ekj = 0;
                    this.ekg.setDefaultResource(d.f.icon_card_url_n);
                    this.ekg.setDefaultBgResource(d.C0277d.cp_bg_line_b);
                    this.ekg.setVisibility(0);
                    this.ekg.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 3:
                    this.ekj = d.f.icon_share_play_n;
                    this.ekg.setDefaultResource(d.C0277d.cp_bg_line_b);
                    this.ekg.setDefaultBgResource(d.C0277d.cp_bg_line_b);
                    this.ekg.setVisibility(0);
                    this.ekg.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                case 4:
                    this.ekj = d.f.icon_share_card_live;
                    this.ekg.setDefaultResource(d.C0277d.cp_bg_line_b);
                    this.ekg.setDefaultBgResource(d.C0277d.cp_bg_line_b);
                    this.ekg.setVisibility(0);
                    this.ekg.startLoad(originalThreadInfo.showPicUrl, 10, false);
                    break;
                default:
                    this.ekj = 0;
                    this.ekg.setVisibility(8);
                    break;
            }
            if (this.ekj != 0) {
                this.ekh.setVisibility(0);
                this.eki.setVisibility(0);
                al.c(this.ekh, this.ekj);
            } else {
                this.ekh.setVisibility(8);
                this.eki.setVisibility(8);
            }
            this.mTitleView.setText(originalThreadInfo.showText);
            setTag(originalThreadInfo);
        }
    }

    public void setSubClickListener(a aVar) {
        this.ekk = aVar;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            al.j(this.mTitleView, d.C0277d.cp_cont_j);
            if (this.ekj != 0) {
                al.c(this.ekh, this.ekj);
            }
            al.k(this.mTitleView, d.f.bg_share_card_item);
        }
    }

    public void setReadState(boolean z) {
        al.j(this.mTitleView, z ? d.C0277d.cp_cont_d : d.C0277d.cp_cont_j);
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
            pbActivityConfig.setStartFrom(this.ekl);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }
}
