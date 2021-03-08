package com.baidu.tieba.ala.headline.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.CenteredImageSpan;
import com.baidu.live.an.c;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.view.b;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaShowHeadlineView extends RelativeLayout {
    ab aED;
    private TextView hfV;
    public long hfX;
    public RelativeLayout hgO;
    public RelativeLayout hgP;
    private Button hgQ;
    private Button hgR;
    private RelativeLayout hgS;
    private TextView hgT;
    private TextView hgU;
    private TextView hgV;
    private TextView hgW;
    public TextView hgX;
    private HeadImageView hgY;
    private HeadImageView hgZ;
    private TextView hha;
    private Bitmap hhb;
    AlaLiveMarkData hhc;
    public Button hhd;
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
        this.hgO = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_layout);
        this.hgP = (RelativeLayout) this.mView.findViewById(a.f.show_view_richer_view);
        this.hgQ = (Button) this.mView.findViewById(a.f.show_view_go_look);
        this.hfV = (TextView) this.mView.findViewById(a.f.show_view_get_headline_support);
        this.hhd = (Button) this.mView.findViewById(a.f.show_view_horizontal_close_button);
        this.hhd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.hgS = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_gifts_tip);
        this.hgT = (TextView) this.mView.findViewById(a.f.show_view_nobody_score);
        this.hgU = (TextView) this.mView.findViewById(a.f.show_view_got_gifts_tip);
        this.hgY = (HeadImageView) this.mView.findViewById(a.f.show_view_live_head);
        this.hgZ = (HeadImageView) this.mView.findViewById(a.f.show_view_richer_head);
        this.hgW = (TextView) this.mView.findViewById(a.f.show_view_richer_head_name);
        this.hgV = (TextView) this.mView.findViewById(a.f.show_view_live_head_name);
        this.hgX = (TextView) this.mView.findViewById(a.f.show_view_timer);
        this.hha = (TextView) this.mView.findViewById(a.f.show_view_tip);
        this.hgR = (Button) this.mView.findViewById(a.f.show_view_get_headline);
        this.hgQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.A(AlaShowHeadlineView.this.aED);
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.hfV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaShowHeadlineView.this.aED.aKb.aJc;
                cVar.bXS = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.hgY.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hgY.setIsRound(true);
        this.hgY.setAutoChangeStyle(false);
        this.hgY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hgZ.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hgZ.setIsRound(true);
        this.hgZ.setAutoChangeStyle(false);
        this.hgZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(ab abVar) {
        JSONObject jSONObject;
        com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(abVar.aKb.liveId)));
        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext());
        alaLiveRoomActivityConfig.addExtraByLiveId(abVar.aKb.liveId, abVar.aKb.roomId + "", "live_sdk");
        try {
            String flvUrl = abVar.mLiveInfo.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
            String str = abVar.mLiveInfo.cover;
            String valueOf = String.valueOf(abVar.mLiveInfo.room_id);
            String valueOf2 = String.valueOf(abVar.mLiveInfo.live_id);
            if (TextUtils.isEmpty(this.otherParams)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(this.otherParams);
            }
            jSONObject.put("live_url", flvUrl);
            jSONObject.put("cover", str);
            jSONObject.put("enterRoomId", valueOf);
            jSONObject.put("enterLiveId", valueOf2);
            jSONObject.put("screen_direction", abVar.mLiveInfo.screen_direction);
            this.otherParams = jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        alaLiveRoomActivityConfig.addExtraByParams(this.otherParams);
        alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
        com.baidu.live.liveroom.a.Mu().a(alaLiveRoomActivityConfig);
    }

    public void setData(ab abVar, String str) {
        this.otherParams = str;
        if (this.hfX > 0 && abVar.aKb.aIS > 0 && abVar.aKb.aIU > abVar.aKb.aIS) {
            setGetLineView(abVar);
        } else {
            setNobodyLayout(abVar);
        }
        B(abVar);
    }

    public void setGetLineView(ab abVar) {
        this.hgO.setVisibility(8);
        this.hgQ.setVisibility(0);
        this.hgP.setVisibility(0);
        this.hgS.setVisibility(8);
        this.hgU.setVisibility(0);
        setGiftTipString(abVar);
        this.hgY.startLoad(abVar.aKb.aIZ, 12, false);
        this.hgZ.startLoad(abVar.aKb.aJa, 12, false);
        this.hgW.setText(abVar.aKb.userName);
        this.hgV.setText(abVar.aKb.aIY);
        this.hha.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_get_tip));
        this.hgR.setBackgroundResource(a.e.sdk_get_headline_button_small);
    }

    public void setNobodyLayout(ab abVar) {
        this.hgO.setVisibility(0);
        this.hgQ.setVisibility(8);
        this.hgP.setVisibility(8);
        this.hgS.setVisibility(0);
        this.hgU.setVisibility(8);
        this.hgT.setText(com.baidu.tieba.ala.headline.a.fs(abVar.aKb.aIS));
        this.hha.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_tip));
        this.hgR.setBackgroundResource(a.e.sdk_get_headline);
    }

    private void B(ab abVar) {
        if (abVar.isHost) {
            this.hgQ.setVisibility(8);
            this.hgR.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.hfV.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds40);
        }
        if (abVar.mLiveInfo.live_id == abVar.aKb.liveId) {
            this.hgQ.setVisibility(8);
            this.hgR.setBackgroundResource(a.e.sdk_get_headline);
        }
        this.aED = abVar;
    }

    private void setGiftTipString(ab abVar) {
        if (this.hhc == null || this.hhc.mark_id != abVar.aKb.aIU) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(" " + this.mContext.getString(a.h.sdk_get_headline_send, abVar.aKb.giftName));
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            if (this.hhc == null || !this.hhc.mark_pic.equals(abVar.aKb.aIX)) {
                this.hhc = new AlaLiveMarkData();
                this.hhc.mark_pic = abVar.aKb.aIX;
                this.hhc.isWidthAutoFit = true;
                com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, this.hhc, false, new b.a() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.4
                    @Override // com.baidu.live.view.b.a
                    public void e(Bitmap bitmap) {
                        AlaShowHeadlineView.this.hgU.setText(AlaShowHeadlineView.this.hgU.getText());
                        AlaShowHeadlineView.this.hhb = bitmap;
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder2.setSpan(bVar, 1, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            } else {
                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getContext(), this.hhb);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder3.setSpan(centeredImageSpan, 1, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            }
            this.hhc.mark_id = abVar.aKb.aIU;
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(a.h.sdk_get_headline_worth, abVar.aKb.giftNum + ""));
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            CenteredImageSpan centeredImageSpan2 = new CenteredImageSpan(getContext(), BitmapFactory.decodeResource(getContext().getResources(), a.e.sdk_icon_huobi_tdou));
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" [img]");
            spannableStringBuilder4.setSpan(centeredImageSpan2, 1, spannableStringBuilder4.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            SpannableString spannableString3 = new SpannableString(com.baidu.tieba.ala.headline.a.fs(abVar.aKb.aIW));
            spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFACA21")), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.hgU.setText(spannableStringBuilder);
        }
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
