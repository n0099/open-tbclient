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
import com.baidu.live.ao.c;
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
    w aFN;
    public RelativeLayout gUZ;
    private TextView gUg;
    public long gUi;
    public RelativeLayout gVa;
    private Button gVb;
    private Button gVc;
    private RelativeLayout gVd;
    private TextView gVe;
    private TextView gVf;
    private TextView gVg;
    private TextView gVh;
    public TextView gVi;
    private HeadImageView gVj;
    private HeadImageView gVk;
    private TextView gVl;
    private Bitmap gVm;
    AlaLiveMarkData gVn;
    public Button gVo;
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
        this.gUZ = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_layout);
        this.gVa = (RelativeLayout) this.mView.findViewById(a.f.show_view_richer_view);
        this.gVb = (Button) this.mView.findViewById(a.f.show_view_go_look);
        this.gUg = (TextView) this.mView.findViewById(a.f.show_view_get_headline_support);
        this.gVo = (Button) this.mView.findViewById(a.f.show_view_horizontal_close_button);
        this.gVo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.gVd = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_gifts_tip);
        this.gVe = (TextView) this.mView.findViewById(a.f.show_view_nobody_score);
        this.gVf = (TextView) this.mView.findViewById(a.f.show_view_got_gifts_tip);
        this.gVj = (HeadImageView) this.mView.findViewById(a.f.show_view_live_head);
        this.gVk = (HeadImageView) this.mView.findViewById(a.f.show_view_richer_head);
        this.gVh = (TextView) this.mView.findViewById(a.f.show_view_richer_head_name);
        this.gVg = (TextView) this.mView.findViewById(a.f.show_view_live_head_name);
        this.gVi = (TextView) this.mView.findViewById(a.f.show_view_timer);
        this.gVl = (TextView) this.mView.findViewById(a.f.show_view_tip);
        this.gVc = (Button) this.mView.findViewById(a.f.show_view_get_headline);
        this.gVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.A(AlaShowHeadlineView.this.aFN);
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.gUg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaShowHeadlineView.this.aFN.aKt.aJu;
                cVar.bRy = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.gVj.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gVj.setIsRound(true);
        this.gVj.setAutoChangeStyle(false);
        this.gVj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gVk.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gVk.setIsRound(true);
        this.gVk.setAutoChangeStyle(false);
        this.gVk.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(w wVar) {
        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext());
        alaLiveRoomActivityConfig.addExtraByLiveId(wVar.aKt.liveId, "", "live_sdk");
        alaLiveRoomActivityConfig.addExtraByParams(this.otherParams);
        alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
    }

    public void setData(w wVar, String str) {
        this.otherParams = str;
        if (this.gUi > 0 && wVar.aKt.aJl > 0 && wVar.aKt.aJn > wVar.aKt.aJl) {
            setGetLineView(wVar);
        } else {
            setNobodyLayout(wVar);
        }
        B(wVar);
    }

    public void setGetLineView(w wVar) {
        this.gUZ.setVisibility(8);
        this.gVb.setVisibility(0);
        this.gVa.setVisibility(0);
        this.gVd.setVisibility(8);
        this.gVf.setVisibility(0);
        setGiftTipString(wVar);
        this.gVj.startLoad(wVar.aKt.aJs, 12, false);
        this.gVk.startLoad(wVar.aKt.aJt, 12, false);
        this.gVh.setText(wVar.aKt.userName);
        this.gVg.setText(wVar.aKt.aJr);
        this.gVl.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_get_tip));
        this.gVc.setBackgroundResource(a.e.sdk_get_headline_button_small);
    }

    public void setNobodyLayout(w wVar) {
        this.gUZ.setVisibility(0);
        this.gVb.setVisibility(8);
        this.gVa.setVisibility(8);
        this.gVd.setVisibility(0);
        this.gVf.setVisibility(8);
        this.gVe.setText(com.baidu.tieba.ala.headline.a.fm(wVar.aKt.aJl));
        this.gVl.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_tip));
        this.gVc.setBackgroundResource(a.e.sdk_get_headline);
    }

    private void B(w wVar) {
        if (wVar.isHost) {
            this.gVb.setVisibility(8);
            this.gVc.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.gUg.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds40);
        }
        if (wVar.mLiveInfo.live_id == wVar.aKt.liveId) {
            this.gVb.setVisibility(8);
            this.gVc.setBackgroundResource(a.e.sdk_get_headline);
        }
        this.aFN = wVar;
    }

    private void setGiftTipString(w wVar) {
        if (this.gVn == null || this.gVn.mark_id != wVar.aKt.aJn) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(" " + this.mContext.getString(a.h.sdk_get_headline_send, wVar.aKt.giftName));
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            if (this.gVn == null || !this.gVn.mark_pic.equals(wVar.aKt.aJq)) {
                this.gVn = new AlaLiveMarkData();
                this.gVn.mark_pic = wVar.aKt.aJq;
                this.gVn.isWidthAutoFit = true;
                com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, this.gVn, false, new b.a() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.4
                    @Override // com.baidu.live.view.b.a
                    public void d(Bitmap bitmap) {
                        AlaShowHeadlineView.this.gVf.setText(AlaShowHeadlineView.this.gVf.getText());
                        AlaShowHeadlineView.this.gVm = bitmap;
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder2.setSpan(bVar, 1, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            } else {
                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getContext(), this.gVm);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder3.setSpan(centeredImageSpan, 1, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            }
            this.gVn.mark_id = wVar.aKt.aJn;
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(a.h.sdk_get_headline_worth, wVar.aKt.giftNum + ""));
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            CenteredImageSpan centeredImageSpan2 = new CenteredImageSpan(getContext(), BitmapFactory.decodeResource(getContext().getResources(), a.e.sdk_icon_huobi_tdou));
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" [img]");
            spannableStringBuilder4.setSpan(centeredImageSpan2, 1, spannableStringBuilder4.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            SpannableString spannableString3 = new SpannableString(com.baidu.tieba.ala.headline.a.fm(wVar.aKt.aJp));
            spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFACA21")), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gVf.setText(spannableStringBuilder);
        }
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
