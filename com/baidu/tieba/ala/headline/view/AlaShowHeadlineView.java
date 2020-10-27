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
import com.baidu.live.ai.c;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.view.c;
/* loaded from: classes4.dex */
public class AlaShowHeadlineView extends RelativeLayout {
    w aEc;
    private TextView gFA;
    public long gFC;
    private TextView gGA;
    private TextView gGB;
    public TextView gGC;
    private HeadImageView gGD;
    private HeadImageView gGE;
    private TextView gGF;
    private Bitmap gGG;
    AlaLiveMarkData gGH;
    public Button gGI;
    public RelativeLayout gGt;
    public RelativeLayout gGu;
    private Button gGv;
    private Button gGw;
    private RelativeLayout gGx;
    private TextView gGy;
    private TextView gGz;
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
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_show_headline_dialog, (ViewGroup) this, true);
        this.gGt = (RelativeLayout) this.mView.findViewById(a.g.show_view_nobody_layout);
        this.gGu = (RelativeLayout) this.mView.findViewById(a.g.show_view_richer_view);
        this.gGv = (Button) this.mView.findViewById(a.g.show_view_go_look);
        this.gFA = (TextView) this.mView.findViewById(a.g.show_view_get_headline_support);
        this.gGI = (Button) this.mView.findViewById(a.g.show_view_horizontal_close_button);
        this.gGI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.gGx = (RelativeLayout) this.mView.findViewById(a.g.show_view_nobody_gifts_tip);
        this.gGy = (TextView) this.mView.findViewById(a.g.show_view_nobody_score);
        this.gGz = (TextView) this.mView.findViewById(a.g.show_view_got_gifts_tip);
        this.gGD = (HeadImageView) this.mView.findViewById(a.g.show_view_live_head);
        this.gGE = (HeadImageView) this.mView.findViewById(a.g.show_view_richer_head);
        this.gGB = (TextView) this.mView.findViewById(a.g.show_view_richer_head_name);
        this.gGA = (TextView) this.mView.findViewById(a.g.show_view_live_head_name);
        this.gGC = (TextView) this.mView.findViewById(a.g.show_view_timer);
        this.gGF = (TextView) this.mView.findViewById(a.g.show_view_tip);
        this.gGw = (Button) this.mView.findViewById(a.g.show_view_get_headline);
        this.gGv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.u(AlaShowHeadlineView.this.aEc);
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.gFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaShowHeadlineView.this.aEc.aIC.aHE;
                cVar.bIw = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.gGD.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gGD.setIsRound(true);
        this.gGD.setAutoChangeStyle(false);
        this.gGD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gGE.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gGE.setIsRound(true);
        this.gGE.setAutoChangeStyle(false);
        this.gGE.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(w wVar) {
        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext());
        alaLiveRoomActivityConfig.addExtraByLiveId(wVar.aIC.liveId, "", "live_sdk");
        alaLiveRoomActivityConfig.addExtraByParams(this.otherParams);
        alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
    }

    public void setData(w wVar, String str) {
        this.otherParams = str;
        if (this.gFC > 0 && wVar.aIC.aHu > 0 && wVar.aIC.aHw > wVar.aIC.aHu) {
            setGetLineView(wVar);
        } else {
            setNobodyLayout(wVar);
        }
        v(wVar);
    }

    public void setGetLineView(w wVar) {
        this.gGt.setVisibility(8);
        this.gGv.setVisibility(0);
        this.gGu.setVisibility(0);
        this.gGx.setVisibility(8);
        this.gGz.setVisibility(0);
        setGiftTipString(wVar);
        this.gGD.startLoad(wVar.aIC.aHC, 12, false);
        this.gGE.startLoad(wVar.aIC.aHD, 12, false);
        this.gGB.setText(wVar.aIC.userName);
        this.gGA.setText(wVar.aIC.aHA);
        this.gGF.setText(this.mContext.getString(a.i.sdk_get_headline_show_view_get_tip));
        this.gGw.setBackgroundResource(a.f.sdk_get_headline_button_small);
    }

    public void setNobodyLayout(w wVar) {
        this.gGt.setVisibility(0);
        this.gGv.setVisibility(8);
        this.gGu.setVisibility(8);
        this.gGx.setVisibility(0);
        this.gGz.setVisibility(8);
        this.gGy.setText(com.baidu.tieba.ala.headline.a.em(wVar.aIC.aHu));
        this.gGF.setText(this.mContext.getString(a.i.sdk_get_headline_show_view_tip));
        this.gGw.setBackgroundResource(a.f.sdk_get_headline_button_big);
    }

    private void v(w wVar) {
        if (wVar.isHost) {
            this.gGv.setVisibility(8);
            this.gGw.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.gFA.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds40);
        }
        if (wVar.mLiveInfo.live_id == wVar.aIC.liveId) {
            this.gGv.setVisibility(8);
            this.gGw.setBackgroundResource(a.f.sdk_get_headline_button_big);
        }
        this.aEc = wVar;
    }

    private void setGiftTipString(w wVar) {
        if (this.gGH == null || this.gGH.mark_id != wVar.aIC.aHw) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(" " + this.mContext.getString(a.i.sdk_get_headline_send, wVar.aIC.giftName));
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            if (this.gGH == null || !this.gGH.mark_pic.equals(wVar.aIC.aHz)) {
                this.gGH = new AlaLiveMarkData();
                this.gGH.mark_pic = wVar.aIC.aHz;
                this.gGH.isWidthAutoFit = true;
                com.baidu.live.view.c cVar = new com.baidu.live.view.c(this.mContext, this.gGH, false, new c.a() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.4
                    @Override // com.baidu.live.view.c.a
                    public void d(Bitmap bitmap) {
                        AlaShowHeadlineView.this.gGz.setText(AlaShowHeadlineView.this.gGz.getText());
                        AlaShowHeadlineView.this.gGG = bitmap;
                    }

                    @Override // com.baidu.live.view.c.a
                    public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder2.setSpan(cVar, 1, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            } else {
                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getContext(), this.gGG);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder3.setSpan(centeredImageSpan, 1, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            }
            this.gGH.mark_id = wVar.aIC.aHw;
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(a.i.sdk_get_headline_worth, wVar.aIC.giftNum + ""));
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            CenteredImageSpan centeredImageSpan2 = new CenteredImageSpan(getContext(), BitmapFactory.decodeResource(getContext().getResources(), a.f.sdk_icon_huobi_tdou));
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" [img]");
            spannableStringBuilder4.setSpan(centeredImageSpan2, 1, spannableStringBuilder4.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            SpannableString spannableString3 = new SpannableString(com.baidu.tieba.ala.headline.a.em(wVar.aIC.aHy));
            spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFACA21")), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gGz.setText(spannableStringBuilder);
        }
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
