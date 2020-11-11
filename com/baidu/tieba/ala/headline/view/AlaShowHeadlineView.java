package com.baidu.tieba.ala.headline.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.CenteredImageSpan;
import com.baidu.live.ak.c;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.view.b;
/* loaded from: classes4.dex */
public class AlaShowHeadlineView extends RelativeLayout {
    w aES;
    private TextView gLm;
    public long gLo;
    public RelativeLayout gMf;
    public RelativeLayout gMg;
    private Button gMh;
    private Button gMi;
    private RelativeLayout gMj;
    private TextView gMk;
    private TextView gMl;
    private TextView gMm;
    private TextView gMn;
    public TextView gMo;
    private HeadImageView gMp;
    private HeadImageView gMq;
    private TextView gMr;
    private Bitmap gMs;
    AlaLiveMarkData gMt;
    public Button gMu;
    private Activity mActivity;
    Context mContext;
    private View mView;
    String otherParams;

    public AlaShowHeadlineView(Context context) {
        super(context);
        this.otherParams = "";
    }

    public AlaShowHeadlineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaShowHeadlineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.otherParams = "";
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_show_headline_dialog, (ViewGroup) this, true);
        this.gMf = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_layout);
        this.gMg = (RelativeLayout) this.mView.findViewById(a.f.show_view_richer_view);
        this.gMh = (Button) this.mView.findViewById(a.f.show_view_go_look);
        this.gLm = (TextView) this.mView.findViewById(a.f.show_view_get_headline_support);
        this.gMu = (Button) this.mView.findViewById(a.f.show_view_horizontal_close_button);
        this.gMu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.gMj = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_gifts_tip);
        this.gMk = (TextView) this.mView.findViewById(a.f.show_view_nobody_score);
        this.gMl = (TextView) this.mView.findViewById(a.f.show_view_got_gifts_tip);
        this.gMp = (HeadImageView) this.mView.findViewById(a.f.show_view_live_head);
        this.gMq = (HeadImageView) this.mView.findViewById(a.f.show_view_richer_head);
        this.gMn = (TextView) this.mView.findViewById(a.f.show_view_richer_head_name);
        this.gMm = (TextView) this.mView.findViewById(a.f.show_view_live_head_name);
        this.gMo = (TextView) this.mView.findViewById(a.f.show_view_timer);
        this.gMr = (TextView) this.mView.findViewById(a.f.show_view_tip);
        this.gMi = (Button) this.mView.findViewById(a.f.show_view_get_headline);
        this.gMh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.z(AlaShowHeadlineView.this.aES);
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.gLm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaShowHeadlineView.this.aES.aJt.aIv;
                cVar.bOc = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.gMp.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gMp.setIsRound(true);
        this.gMp.setAutoChangeStyle(false);
        this.gMp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gMq.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gMq.setIsRound(true);
        this.gMq.setAutoChangeStyle(false);
        this.gMq.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(w wVar) {
        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext());
        alaLiveRoomActivityConfig.addExtraByLiveId(wVar.aJt.liveId, "", "live_sdk");
        alaLiveRoomActivityConfig.addExtraByParams(this.otherParams);
        alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
    }

    public void setData(w wVar, String str) {
        this.otherParams = str;
        if (this.gLo > 0 && wVar.aJt.aIm > 0 && wVar.aJt.aIo > wVar.aJt.aIm) {
            setGetLineView(wVar);
        } else {
            setNobodyLayout(wVar);
        }
        A(wVar);
    }

    public void setGetLineView(w wVar) {
        this.gMf.setVisibility(8);
        this.gMh.setVisibility(0);
        this.gMg.setVisibility(0);
        this.gMj.setVisibility(8);
        this.gMl.setVisibility(0);
        setGiftTipString(wVar);
        this.gMp.startLoad(wVar.aJt.aIt, 12, false);
        this.gMq.startLoad(wVar.aJt.aIu, 12, false);
        this.gMn.setText(wVar.aJt.userName);
        this.gMm.setText(wVar.aJt.aIs);
        this.gMr.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_get_tip));
        this.gMi.setBackgroundResource(a.e.sdk_get_headline_button_small);
    }

    public void setNobodyLayout(w wVar) {
        this.gMf.setVisibility(0);
        this.gMh.setVisibility(8);
        this.gMg.setVisibility(8);
        this.gMj.setVisibility(0);
        this.gMl.setVisibility(8);
        this.gMk.setText(com.baidu.tieba.ala.headline.a.eI(wVar.aJt.aIm));
        this.gMr.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_tip));
        this.gMi.setBackgroundResource(a.e.sdk_get_headline);
    }

    private void A(w wVar) {
        if (wVar.isHost) {
            this.gMh.setVisibility(8);
            this.gMi.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.gLm.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds40);
        }
        if (wVar.mLiveInfo.live_id == wVar.aJt.liveId) {
            this.gMh.setVisibility(8);
            this.gMi.setBackgroundResource(a.e.sdk_get_headline);
        }
        this.aES = wVar;
    }

    private void setGiftTipString(w wVar) {
        if (this.gMt == null || this.gMt.mark_id != wVar.aJt.aIo) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(" " + this.mContext.getString(a.h.sdk_get_headline_send, wVar.aJt.giftName));
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            if (this.gMt == null || !this.gMt.mark_pic.equals(wVar.aJt.aIr)) {
                this.gMt = new AlaLiveMarkData();
                this.gMt.mark_pic = wVar.aJt.aIr;
                this.gMt.isWidthAutoFit = true;
                com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, this.gMt, false, new b.a() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.4
                    @Override // com.baidu.live.view.b.a
                    public void d(Bitmap bitmap) {
                        AlaShowHeadlineView.this.gMl.setText(AlaShowHeadlineView.this.gMl.getText());
                        AlaShowHeadlineView.this.gMs = bitmap;
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder2.setSpan(bVar, 1, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            } else {
                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getContext(), this.gMs);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder3.setSpan(centeredImageSpan, 1, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            }
            this.gMt.mark_id = wVar.aJt.aIo;
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(a.h.sdk_get_headline_worth, wVar.aJt.giftNum + ""));
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            CenteredImageSpan centeredImageSpan2 = new CenteredImageSpan(getContext(), BitmapFactory.decodeResource(getContext().getResources(), a.e.sdk_icon_huobi_tdou));
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" [img]");
            spannableStringBuilder4.setSpan(centeredImageSpan2, 1, spannableStringBuilder4.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            SpannableString spannableString3 = new SpannableString(com.baidu.tieba.ala.headline.a.eI(wVar.aJt.aIq));
            spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFACA21")), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gMl.setText(spannableStringBuilder);
        }
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
