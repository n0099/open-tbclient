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
    w aDh;
    private TextView gKT;
    public long gKV;
    public RelativeLayout gLM;
    public RelativeLayout gLN;
    private Button gLO;
    private Button gLP;
    private RelativeLayout gLQ;
    private TextView gLR;
    private TextView gLS;
    private TextView gLT;
    private TextView gLU;
    public TextView gLV;
    private HeadImageView gLW;
    private HeadImageView gLX;
    private TextView gLY;
    private Bitmap gLZ;
    AlaLiveMarkData gMa;
    public Button gMb;
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
        this.gLM = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_layout);
        this.gLN = (RelativeLayout) this.mView.findViewById(a.f.show_view_richer_view);
        this.gLO = (Button) this.mView.findViewById(a.f.show_view_go_look);
        this.gKT = (TextView) this.mView.findViewById(a.f.show_view_get_headline_support);
        this.gMb = (Button) this.mView.findViewById(a.f.show_view_horizontal_close_button);
        this.gMb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.gLQ = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_gifts_tip);
        this.gLR = (TextView) this.mView.findViewById(a.f.show_view_nobody_score);
        this.gLS = (TextView) this.mView.findViewById(a.f.show_view_got_gifts_tip);
        this.gLW = (HeadImageView) this.mView.findViewById(a.f.show_view_live_head);
        this.gLX = (HeadImageView) this.mView.findViewById(a.f.show_view_richer_head);
        this.gLU = (TextView) this.mView.findViewById(a.f.show_view_richer_head_name);
        this.gLT = (TextView) this.mView.findViewById(a.f.show_view_live_head_name);
        this.gLV = (TextView) this.mView.findViewById(a.f.show_view_timer);
        this.gLY = (TextView) this.mView.findViewById(a.f.show_view_tip);
        this.gLP = (Button) this.mView.findViewById(a.f.show_view_get_headline);
        this.gLO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.z(AlaShowHeadlineView.this.aDh);
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.gKT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaShowHeadlineView.this.aDh.aHI.aGK;
                cVar.bMs = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.gLW.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gLW.setIsRound(true);
        this.gLW.setAutoChangeStyle(false);
        this.gLW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gLX.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gLX.setIsRound(true);
        this.gLX.setAutoChangeStyle(false);
        this.gLX.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(w wVar) {
        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext());
        alaLiveRoomActivityConfig.addExtraByLiveId(wVar.aHI.liveId, "", "live_sdk");
        alaLiveRoomActivityConfig.addExtraByParams(this.otherParams);
        alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
    }

    public void setData(w wVar, String str) {
        this.otherParams = str;
        if (this.gKV > 0 && wVar.aHI.aGB > 0 && wVar.aHI.aGD > wVar.aHI.aGB) {
            setGetLineView(wVar);
        } else {
            setNobodyLayout(wVar);
        }
        A(wVar);
    }

    public void setGetLineView(w wVar) {
        this.gLM.setVisibility(8);
        this.gLO.setVisibility(0);
        this.gLN.setVisibility(0);
        this.gLQ.setVisibility(8);
        this.gLS.setVisibility(0);
        setGiftTipString(wVar);
        this.gLW.startLoad(wVar.aHI.aGI, 12, false);
        this.gLX.startLoad(wVar.aHI.aGJ, 12, false);
        this.gLU.setText(wVar.aHI.userName);
        this.gLT.setText(wVar.aHI.aGH);
        this.gLY.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_get_tip));
        this.gLP.setBackgroundResource(a.e.sdk_get_headline_button_small);
    }

    public void setNobodyLayout(w wVar) {
        this.gLM.setVisibility(0);
        this.gLO.setVisibility(8);
        this.gLN.setVisibility(8);
        this.gLQ.setVisibility(0);
        this.gLS.setVisibility(8);
        this.gLR.setText(com.baidu.tieba.ala.headline.a.eI(wVar.aHI.aGB));
        this.gLY.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_tip));
        this.gLP.setBackgroundResource(a.e.sdk_get_headline);
    }

    private void A(w wVar) {
        if (wVar.isHost) {
            this.gLO.setVisibility(8);
            this.gLP.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.gKT.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds40);
        }
        if (wVar.mLiveInfo.live_id == wVar.aHI.liveId) {
            this.gLO.setVisibility(8);
            this.gLP.setBackgroundResource(a.e.sdk_get_headline);
        }
        this.aDh = wVar;
    }

    private void setGiftTipString(w wVar) {
        if (this.gMa == null || this.gMa.mark_id != wVar.aHI.aGD) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(" " + this.mContext.getString(a.h.sdk_get_headline_send, wVar.aHI.giftName));
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            if (this.gMa == null || !this.gMa.mark_pic.equals(wVar.aHI.aGG)) {
                this.gMa = new AlaLiveMarkData();
                this.gMa.mark_pic = wVar.aHI.aGG;
                this.gMa.isWidthAutoFit = true;
                com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, this.gMa, false, new b.a() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.4
                    @Override // com.baidu.live.view.b.a
                    public void d(Bitmap bitmap) {
                        AlaShowHeadlineView.this.gLS.setText(AlaShowHeadlineView.this.gLS.getText());
                        AlaShowHeadlineView.this.gLZ = bitmap;
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder2.setSpan(bVar, 1, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            } else {
                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getContext(), this.gLZ);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder3.setSpan(centeredImageSpan, 1, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            }
            this.gMa.mark_id = wVar.aHI.aGD;
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(a.h.sdk_get_headline_worth, wVar.aHI.giftNum + ""));
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            CenteredImageSpan centeredImageSpan2 = new CenteredImageSpan(getContext(), BitmapFactory.decodeResource(getContext().getResources(), a.e.sdk_icon_huobi_tdou));
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" [img]");
            spannableStringBuilder4.setSpan(centeredImageSpan2, 1, spannableStringBuilder4.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            SpannableString spannableString3 = new SpannableString(com.baidu.tieba.ala.headline.a.eI(wVar.aHI.aGF));
            spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFACA21")), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gLS.setText(spannableStringBuilder);
        }
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
