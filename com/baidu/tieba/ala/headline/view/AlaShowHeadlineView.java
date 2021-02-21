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
/* loaded from: classes11.dex */
public class AlaShowHeadlineView extends RelativeLayout {
    ab aDd;
    private TextView hem;
    public long heo;
    public RelativeLayout hff;
    public RelativeLayout hfg;
    private Button hfh;
    private Button hfi;
    private RelativeLayout hfj;
    private TextView hfk;
    private TextView hfl;
    private TextView hfm;
    private TextView hfn;
    public TextView hfo;
    private HeadImageView hfp;
    private HeadImageView hfq;
    private TextView hfr;
    private Bitmap hfs;
    AlaLiveMarkData hft;
    public Button hfu;
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
        this.hff = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_layout);
        this.hfg = (RelativeLayout) this.mView.findViewById(a.f.show_view_richer_view);
        this.hfh = (Button) this.mView.findViewById(a.f.show_view_go_look);
        this.hem = (TextView) this.mView.findViewById(a.f.show_view_get_headline_support);
        this.hfu = (Button) this.mView.findViewById(a.f.show_view_horizontal_close_button);
        this.hfu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.hfj = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_gifts_tip);
        this.hfk = (TextView) this.mView.findViewById(a.f.show_view_nobody_score);
        this.hfl = (TextView) this.mView.findViewById(a.f.show_view_got_gifts_tip);
        this.hfp = (HeadImageView) this.mView.findViewById(a.f.show_view_live_head);
        this.hfq = (HeadImageView) this.mView.findViewById(a.f.show_view_richer_head);
        this.hfn = (TextView) this.mView.findViewById(a.f.show_view_richer_head_name);
        this.hfm = (TextView) this.mView.findViewById(a.f.show_view_live_head_name);
        this.hfo = (TextView) this.mView.findViewById(a.f.show_view_timer);
        this.hfr = (TextView) this.mView.findViewById(a.f.show_view_tip);
        this.hfi = (Button) this.mView.findViewById(a.f.show_view_get_headline);
        this.hfh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.A(AlaShowHeadlineView.this.aDd);
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.hem.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaShowHeadlineView.this.aDd.aIB.aHC;
                cVar.bWs = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.hfp.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hfp.setIsRound(true);
        this.hfp.setAutoChangeStyle(false);
        this.hfp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hfq.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hfq.setIsRound(true);
        this.hfq.setAutoChangeStyle(false);
        this.hfq.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(ab abVar) {
        JSONObject jSONObject;
        com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(abVar.aIB.liveId)));
        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext());
        alaLiveRoomActivityConfig.addExtraByLiveId(abVar.aIB.liveId, abVar.aIB.roomId + "", "live_sdk");
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
        com.baidu.live.liveroom.a.Mr().a(alaLiveRoomActivityConfig);
    }

    public void setData(ab abVar, String str) {
        this.otherParams = str;
        if (this.heo > 0 && abVar.aIB.aHs > 0 && abVar.aIB.aHu > abVar.aIB.aHs) {
            setGetLineView(abVar);
        } else {
            setNobodyLayout(abVar);
        }
        B(abVar);
    }

    public void setGetLineView(ab abVar) {
        this.hff.setVisibility(8);
        this.hfh.setVisibility(0);
        this.hfg.setVisibility(0);
        this.hfj.setVisibility(8);
        this.hfl.setVisibility(0);
        setGiftTipString(abVar);
        this.hfp.startLoad(abVar.aIB.aHz, 12, false);
        this.hfq.startLoad(abVar.aIB.aHA, 12, false);
        this.hfn.setText(abVar.aIB.userName);
        this.hfm.setText(abVar.aIB.aHy);
        this.hfr.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_get_tip));
        this.hfi.setBackgroundResource(a.e.sdk_get_headline_button_small);
    }

    public void setNobodyLayout(ab abVar) {
        this.hff.setVisibility(0);
        this.hfh.setVisibility(8);
        this.hfg.setVisibility(8);
        this.hfj.setVisibility(0);
        this.hfl.setVisibility(8);
        this.hfk.setText(com.baidu.tieba.ala.headline.a.fs(abVar.aIB.aHs));
        this.hfr.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_tip));
        this.hfi.setBackgroundResource(a.e.sdk_get_headline);
    }

    private void B(ab abVar) {
        if (abVar.isHost) {
            this.hfh.setVisibility(8);
            this.hfi.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.hem.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds40);
        }
        if (abVar.mLiveInfo.live_id == abVar.aIB.liveId) {
            this.hfh.setVisibility(8);
            this.hfi.setBackgroundResource(a.e.sdk_get_headline);
        }
        this.aDd = abVar;
    }

    private void setGiftTipString(ab abVar) {
        if (this.hft == null || this.hft.mark_id != abVar.aIB.aHu) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(" " + this.mContext.getString(a.h.sdk_get_headline_send, abVar.aIB.giftName));
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            if (this.hft == null || !this.hft.mark_pic.equals(abVar.aIB.aHx)) {
                this.hft = new AlaLiveMarkData();
                this.hft.mark_pic = abVar.aIB.aHx;
                this.hft.isWidthAutoFit = true;
                com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, this.hft, false, new b.a() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.4
                    @Override // com.baidu.live.view.b.a
                    public void e(Bitmap bitmap) {
                        AlaShowHeadlineView.this.hfl.setText(AlaShowHeadlineView.this.hfl.getText());
                        AlaShowHeadlineView.this.hfs = bitmap;
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder2.setSpan(bVar, 1, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            } else {
                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getContext(), this.hfs);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder3.setSpan(centeredImageSpan, 1, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            }
            this.hft.mark_id = abVar.aIB.aHu;
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(a.h.sdk_get_headline_worth, abVar.aIB.giftNum + ""));
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            CenteredImageSpan centeredImageSpan2 = new CenteredImageSpan(getContext(), BitmapFactory.decodeResource(getContext().getResources(), a.e.sdk_icon_huobi_tdou));
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" [img]");
            spannableStringBuilder4.setSpan(centeredImageSpan2, 1, spannableStringBuilder4.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            SpannableString spannableString3 = new SpannableString(com.baidu.tieba.ala.headline.a.fs(abVar.aIB.aHw));
            spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFACA21")), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.hfl.setText(spannableStringBuilder);
        }
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
